package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri.Builder;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@ey
public class ex implements UncaughtExceptionHandler {
    private Context mContext;
    private UncaughtExceptionHandler tf;
    private UncaughtExceptionHandler tg;
    private gs th;

    public ex(Context context, gs gsVar, UncaughtExceptionHandler uncaughtExceptionHandler, UncaughtExceptionHandler uncaughtExceptionHandler2) {
        this.tf = uncaughtExceptionHandler;
        this.tg = uncaughtExceptionHandler2;
        this.mContext = context;
        this.th = gsVar;
    }

    /* renamed from: a */
    public static ex m1180a(Context context, Thread thread, gs gsVar) {
        if (context == null || thread == null || gsVar == null) {
            return null;
        }
        ga.bN();
        if (!m1182k(context)) {
            return null;
        }
        UncaughtExceptionHandler uncaughtExceptionHandler = thread.getUncaughtExceptionHandler();
        UncaughtExceptionHandler exVar = new ex(context, gsVar, uncaughtExceptionHandler, Thread.getDefaultUncaughtExceptionHandler());
        if (uncaughtExceptionHandler != null && (uncaughtExceptionHandler instanceof ex)) {
            return (ex) uncaughtExceptionHandler;
        }
        try {
            thread.setUncaughtExceptionHandler(exVar);
            return exVar;
        } catch (Throwable e) {
            gr.m1344c("Fail to set UncaughtExceptionHandler.", e);
            return null;
        }
    }

    private String cD() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        return str2.startsWith(str) ? str2 : str + " " + str2;
    }

    /* renamed from: d */
    private Throwable m1181d(Throwable th) {
        Bundle bN = ga.bN();
        if (bN != null && bN.getBoolean("gads:sdk_crash_report_full_stacktrace", false)) {
            return th;
        }
        LinkedList linkedList = new LinkedList();
        while (th != null) {
            linkedList.push(th);
            th = th.getCause();
        }
        Throwable th2 = null;
        while (!linkedList.isEmpty()) {
            Throwable th3;
            Throwable th4 = (Throwable) linkedList.pop();
            StackTraceElement[] stackTrace = th4.getStackTrace();
            ArrayList arrayList = new ArrayList();
            arrayList.add(new StackTraceElement(th4.getClass().getName(), "<filtered>", "<filtered>", 1));
            boolean z = false;
            for (StackTraceElement stackTraceElement : stackTrace) {
                if (m1183G(stackTraceElement.getClassName())) {
                    arrayList.add(stackTraceElement);
                    z = true;
                } else if (m1184H(stackTraceElement.getClassName())) {
                    arrayList.add(stackTraceElement);
                } else {
                    arrayList.add(new StackTraceElement("<filtered>", "<filtered>", "<filtered>", 1));
                }
            }
            if (z) {
                th3 = th2 == null ? new Throwable(th4.getMessage()) : new Throwable(th4.getMessage(), th2);
                th3.setStackTrace((StackTraceElement[]) arrayList.toArray(new StackTraceElement[0]));
            } else {
                th3 = th2;
            }
            th2 = th3;
        }
        return th2;
    }

    /* renamed from: k */
    private static boolean m1182k(Context context) {
        Bundle bN = ga.bN();
        return bN != null && bN.getBoolean("gads:sdk_crash_report_enabled", false);
    }

    /* renamed from: G */
    protected boolean m1183G(String str) {
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            return z;
        }
        if (str.startsWith("com.google.android.gms.ads")) {
            return true;
        }
        if (str.startsWith("com.google.ads")) {
            return true;
        }
        try {
            return Class.forName(str).isAnnotationPresent(ey.class);
        } catch (Throwable e) {
            gr.m1342a("Fail to check class type for class " + str, e);
            return z;
        }
    }

    /* renamed from: H */
    protected boolean m1184H(String str) {
        return TextUtils.isEmpty(str) ? false : str.startsWith("android.") || str.startsWith("java.");
    }

    /* renamed from: a */
    protected boolean m1185a(Throwable th) {
        boolean z = true;
        if (th == null) {
            return false;
        }
        boolean z2 = false;
        boolean z3 = false;
        while (th != null) {
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                if (m1183G(stackTraceElement.getClassName())) {
                    z3 = true;
                }
                if (getClass().getName().equals(stackTraceElement.getClassName())) {
                    z2 = true;
                }
            }
            th = th.getCause();
        }
        if (!z3 || r2) {
            z = false;
        }
        return z;
    }

    /* renamed from: b */
    public void m1186b(Throwable th) {
        if (m1182k(this.mContext)) {
            Throwable d = m1181d(th);
            if (d != null) {
                List arrayList = new ArrayList();
                arrayList.add(m1187c(d));
                gi.m1294a(this.mContext, this.th.wS, arrayList, ga.dn());
            }
        }
    }

    /* renamed from: c */
    protected String m1187c(Throwable th) {
        Writer stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return new Builder().scheme("https").path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("id", "gmob-apps-report-exception").appendQueryParameter("os", VERSION.RELEASE).appendQueryParameter("api", String.valueOf(VERSION.SDK_INT)).appendQueryParameter("device", cD()).appendQueryParameter("js", this.th.wS).appendQueryParameter("appid", this.mContext.getApplicationContext().getPackageName()).appendQueryParameter("stacktrace", stringWriter.toString()).toString();
    }

    public void uncaughtException(Thread thread, Throwable exception) {
        if (m1185a(exception)) {
            m1186b(exception);
            if (Looper.getMainLooper().getThread() != thread) {
                return;
            }
        }
        if (this.tf != null) {
            this.tf.uncaughtException(thread, exception);
        } else if (this.tg != null) {
            this.tg.uncaughtException(thread, exception);
        }
    }
}
