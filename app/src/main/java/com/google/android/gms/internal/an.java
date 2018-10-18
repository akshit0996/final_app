package com.google.android.gms.internal;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.KeyguardManager;
import android.content.Context;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@ey
public class an extends Thread {
    private final Object mH;
    private boolean mStarted = false;
    private boolean nC = false;
    private boolean nD = false;
    private final am nE;
    private final al nF;
    private final ex nG;
    private final int nH;
    private final int nI;
    private final int nJ;
    private final int np;
    private final int nr;

    @ey
    /* renamed from: com.google.android.gms.internal.an$a */
    class C0374a {
        final /* synthetic */ an nL;
        final int nQ;
        final int nR;

        C0374a(an anVar, int i, int i2) {
            this.nL = anVar;
            this.nQ = i;
            this.nR = i2;
        }
    }

    public an(am amVar, al alVar, Bundle bundle, ex exVar) {
        this.nE = amVar;
        this.nF = alVar;
        this.nG = exVar;
        this.mH = new Object();
        this.np = bundle.getInt(bn.pq.getKey());
        this.nI = bundle.getInt(bn.pr.getKey());
        this.nr = bundle.getInt(bn.ps.getKey());
        this.nJ = bundle.getInt(bn.pt.getKey());
        this.nH = bundle.getInt(bn.pu.getKey(), 10);
        setName("ContentFetchTask");
    }

    /* renamed from: a */
    private void m1015a(Activity activity) {
        if (activity != null) {
            View view = null;
            if (!(activity.getWindow() == null || activity.getWindow().getDecorView() == null)) {
                view = activity.getWindow().getDecorView().findViewById(16908290);
            }
            if (view != null) {
                m1019g(view);
            }
        }
    }

    /* renamed from: a */
    private boolean m1016a(final WebView webView, final ak akVar) {
        if (!ll.im()) {
            return false;
        }
        akVar.aW();
        webView.post(new Runnable(this) {
            final /* synthetic */ an nL;
            ValueCallback<String> nM = new C03721(this);

            /* renamed from: com.google.android.gms.internal.an$2$1 */
            class C03721 implements ValueCallback<String> {
                final /* synthetic */ C03732 nP;

                C03721(C03732 c03732) {
                    this.nP = c03732;
                }

                /* renamed from: k */
                public void m1014k(String str) {
                    this.nP.nL.m1018a(akVar, webView, str);
                }

                public /* synthetic */ void onReceiveValue(Object x0) {
                    m1014k((String) x0);
                }
            }

            public void run() {
                if (webView.getSettings().getJavaScriptEnabled()) {
                    webView.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", this.nM);
                }
            }
        });
        return true;
    }

    private boolean bb() {
        try {
            Context context = this.nE.getContext();
            if (context == null) {
                return false;
            }
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            if (activityManager == null || keyguardManager == null || powerManager == null) {
                return false;
            }
            List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses == null) {
                return false;
            }
            for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (Process.myPid() == runningAppProcessInfo.pid) {
                    if (runningAppProcessInfo.importance == 100 && !keyguardManager.inKeyguardRestrictedInputMode() && powerManager.isScreenOn()) {
                        return true;
                    }
                    return false;
                }
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    /* renamed from: a */
    C0374a m1017a(View view, ak akVar) {
        int i = 0;
        if (view == null) {
            return new C0374a(this, 0, 0);
        }
        if ((view instanceof TextView) && !(view instanceof EditText)) {
            akVar.m1010i(((TextView) view).getText().toString());
            return new C0374a(this, 1, 0);
        } else if ((view instanceof WebView) && !(view instanceof gu)) {
            akVar.aW();
            return m1016a((WebView) view, akVar) ? new C0374a(this, 0, 1) : new C0374a(this, 0, 0);
        } else if (!(view instanceof ViewGroup)) {
            return new C0374a(this, 0, 0);
        } else {
            ViewGroup viewGroup = (ViewGroup) view;
            int i2 = 0;
            int i3 = 0;
            while (i < viewGroup.getChildCount()) {
                C0374a a = m1017a(viewGroup.getChildAt(i), akVar);
                i3 += a.nQ;
                i2 += a.nR;
                i++;
            }
            return new C0374a(this, i3, i2);
        }
    }

    /* renamed from: a */
    void m1018a(ak akVar, WebView webView, String str) {
        akVar.aV();
        try {
            if (!TextUtils.isEmpty(str)) {
                String optString = new JSONObject(str).optString("text");
                if (TextUtils.isEmpty(webView.getTitle())) {
                    akVar.m1009h(optString);
                } else {
                    akVar.m1009h(webView.getTitle() + "\n" + optString);
                }
            }
            if (akVar.aS()) {
                this.nF.m1012b(akVar);
            }
        } catch (JSONException e) {
            gr.m1337S("Json string may be malformed.");
        } catch (Throwable th) {
            gr.m1342a("Failed to get webview content.", th);
            this.nG.m1186b(th);
        }
    }

    public void ba() {
        synchronized (this.mH) {
            if (this.mStarted) {
                gr.m1337S("Content hash thread already started, quiting...");
                return;
            }
            this.mStarted = true;
            start();
        }
    }

    public ak bc() {
        return this.nF.aZ();
    }

    public void bd() {
        synchronized (this.mH) {
            this.nC = true;
            gr.m1337S("ContentFetchThread: paused, mPause = " + this.nC);
        }
    }

    public boolean be() {
        return this.nC;
    }

    /* renamed from: g */
    boolean m1019g(final View view) {
        if (view == null) {
            return false;
        }
        view.post(new Runnable(this) {
            final /* synthetic */ an nL;

            public void run() {
                this.nL.m1020h(view);
            }
        });
        return true;
    }

    /* renamed from: h */
    void m1020h(View view) {
        try {
            ak akVar = new ak(this.np, this.nI, this.nr, this.nJ);
            C0374a a = m1017a(view, akVar);
            akVar.aX();
            if (a.nQ != 0 || a.nR != 0) {
                if (a.nR != 0 || akVar.aY() != 0) {
                    if (a.nR != 0 || !this.nF.m1011a(akVar)) {
                        this.nF.m1013c(akVar);
                    }
                }
            }
        } catch (Throwable e) {
            gr.m1343b("Exception in fetchContentOnUIThread", e);
            this.nG.m1186b(e);
        }
    }

    public void run() {
        while (!this.nD) {
            try {
                if (bb()) {
                    Activity activity = this.nE.getActivity();
                    if (activity == null) {
                        gr.m1337S("ContentFetchThread: no activity");
                    } else {
                        m1015a(activity);
                    }
                } else {
                    gr.m1337S("ContentFetchTask: sleeping");
                    bd();
                }
                Thread.sleep((long) (this.nH * 1000));
            } catch (Throwable th) {
                gr.m1343b("Error in ContentFetchTask", th);
                this.nG.m1186b(th);
            }
            synchronized (this.mH) {
                while (this.nC) {
                    try {
                        gr.m1337S("ContentFetchTask: waiting");
                        this.mH.wait();
                    } catch (InterruptedException e) {
                    }
                }
            }
        }
    }

    public void wakeup() {
        synchronized (this.mH) {
            this.nC = false;
            this.mH.notifyAll();
            gr.m1337S("ContentFetchThread: wakeup");
        }
    }
}
