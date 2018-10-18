package com.google.android.gms.analytics;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.google.android.gms.internal.ha;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.google.android.gms.analytics.x */
class C0790x extends Thread implements C0116f {
    private static C0790x zM;
    private volatile boolean mClosed = false;
    private final Context mContext;
    private final LinkedBlockingQueue<Runnable> zJ = new LinkedBlockingQueue();
    private volatile boolean zK = false;
    private volatile String zL;
    private volatile ak zN;
    private final Lock zO;
    private final List<ha> zP = new ArrayList();

    /* renamed from: com.google.android.gms.analytics.x$a */
    private class C0139a implements Runnable {
        final /* synthetic */ C0790x zQ;

        private C0139a(C0790x c0790x) {
            this.zQ = c0790x;
        }

        public void run() {
            this.zQ.zN.dQ();
        }
    }

    /* renamed from: com.google.android.gms.analytics.x$b */
    private class C0140b implements Runnable {
        final /* synthetic */ C0790x zQ;

        private C0140b(C0790x c0790x) {
            this.zQ = c0790x;
        }

        public void run() {
            this.zQ.zN.dispatch();
        }
    }

    /* renamed from: com.google.android.gms.analytics.x$c */
    private class C0141c implements Runnable {
        final /* synthetic */ C0790x zQ;

        private C0141c(C0790x c0790x) {
            this.zQ = c0790x;
        }

        public void run() {
            this.zQ.zN.dW();
        }
    }

    /* renamed from: com.google.android.gms.analytics.x$d */
    private class C0142d implements Runnable {
        final /* synthetic */ C0790x zQ;
        private final Map<String, String> zR;

        C0142d(C0790x c0790x, Map<String, String> map) {
            this.zQ = c0790x;
            this.zR = new HashMap(map);
            String str = (String) map.get("&ht");
            if (str != null) {
                try {
                    Long.valueOf(str);
                } catch (NumberFormatException e) {
                    str = null;
                }
            }
            if (str == null) {
                this.zR.put("&ht", Long.toString(System.currentTimeMillis()));
            }
        }

        /* renamed from: v */
        private String m81v(Map<String, String> map) {
            return map.containsKey("useSecure") ? an.m57f((String) map.get("useSecure"), true) ? "https:" : "http:" : "https:";
        }

        /* renamed from: w */
        private void m82w(Map<String, String> map) {
            C0125q w = C0779a.m2352w(this.zQ.mContext);
            an.m55a((Map) map, "&adid", w);
            an.m55a((Map) map, "&ate", w);
        }

        /* renamed from: x */
        private void m83x(Map<String, String> map) {
            C0125q dZ = C0782g.dZ();
            an.m55a((Map) map, "&an", dZ);
            an.m55a((Map) map, "&av", dZ);
            an.m55a((Map) map, "&aid", dZ);
            an.m55a((Map) map, "&aiid", dZ);
            map.put("&v", "1");
        }

        /* renamed from: y */
        private boolean m84y(Map<String, String> map) {
            if (map.get("&sf") == null) {
                return false;
            }
            double a = an.m53a((String) map.get("&sf"), 100.0d);
            if (a >= 100.0d) {
                return false;
            }
            if (((double) (C0790x.ah((String) map.get("&cid")) % 10000)) < a * 100.0d) {
                return false;
            }
            String str = map.get("&t") == null ? "unknown" : (String) map.get("&t");
            ae.m44V(String.format("%s hit sampled out", new Object[]{str}));
            return true;
        }

        public void run() {
            m82w(this.zR);
            if (TextUtils.isEmpty((CharSequence) this.zR.get("&cid"))) {
                this.zR.put("&cid", C0785k.el().getValue("&cid"));
            }
            if (!GoogleAnalytics.getInstance(this.zQ.mContext).getAppOptOut() && !m84y(this.zR)) {
                if (!TextUtils.isEmpty(this.zQ.zL)) {
                    C0144y.eK().m85D(true);
                    this.zR.putAll(new HitBuilder().setCampaignParamsFromUrl(this.zQ.zL).build());
                    C0144y.eK().m85D(false);
                    this.zQ.zL = null;
                }
                m83x(this.zR);
                this.zQ.zN.mo859b(ac.m41z(this.zR), Long.valueOf((String) this.zR.get("&ht")).longValue(), m81v(this.zR), this.zQ.zP);
            }
        }
    }

    private C0790x(Context context) {
        super("GAThread");
        if (context != null) {
            this.mContext = context.getApplicationContext();
        } else {
            this.mContext = context;
        }
        this.zP.add(new ha("appendVersion", "&_v".substring(1), "ma4.0.4"));
        this.zO = new ReentrantLock();
        start();
    }

    /* renamed from: A */
    static C0790x m2415A(Context context) {
        if (zM == null) {
            zM = new C0790x(context);
        }
        return zM;
    }

    /* renamed from: B */
    static String m2416B(Context context) {
        try {
            FileInputStream openFileInput = context.openFileInput("gaInstallData");
            byte[] bArr = new byte[8192];
            int read = openFileInput.read(bArr, 0, 8192);
            if (openFileInput.available() > 0) {
                ae.m42T("Too much campaign data, ignoring it.");
                openFileInput.close();
                context.deleteFile("gaInstallData");
                return null;
            }
            openFileInput.close();
            context.deleteFile("gaInstallData");
            if (read <= 0) {
                ae.m45W("Campaign file is empty.");
                return null;
            }
            String str = new String(bArr, 0, read);
            ae.m43U("Campaign found: " + str);
            return str;
        } catch (FileNotFoundException e) {
            ae.m43U("No campaign data found.");
            return null;
        } catch (IOException e2) {
            ae.m42T("Error reading campaign data.");
            context.deleteFile("gaInstallData");
            return null;
        }
    }

    static int ah(String str) {
        int i = 1;
        if (!TextUtils.isEmpty(str)) {
            i = 0;
            for (int length = str.length() - 1; length >= 0; length--) {
                char charAt = str.charAt(length);
                i = (((i << 6) & 268435455) + charAt) + (charAt << 14);
                int i2 = 266338304 & i;
                if (i2 != 0) {
                    i ^= i2 >> 21;
                }
            }
        }
        return i;
    }

    /* renamed from: b */
    private void m2420b(Runnable runnable) {
        this.zJ.add(runnable);
    }

    /* renamed from: g */
    private String m2423g(Throwable th) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        th.printStackTrace(printStream);
        printStream.flush();
        return new String(byteArrayOutputStream.toByteArray());
    }

    public void dQ() {
        m2420b(new C0139a());
    }

    public void dW() {
        m2420b(new C0141c());
    }

    public LinkedBlockingQueue<Runnable> dX() {
        return this.zJ;
    }

    public void dY() {
        init();
        Object<Runnable> arrayList = new ArrayList();
        this.zJ.drainTo(arrayList);
        this.zO.lock();
        try {
            this.zK = true;
            for (Runnable run : arrayList) {
                run.run();
            }
        } catch (Throwable th) {
            this.zO.unlock();
        }
        this.zO.unlock();
    }

    public void dispatch() {
        m2420b(new C0140b());
    }

    public Thread getThread() {
        return this;
    }

    protected synchronized void init() {
        if (this.zN == null) {
            this.zN = new C0789w(this.mContext, this);
            this.zN.eB();
        }
    }

    public void run() {
        Process.setThreadPriority(10);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            ae.m45W("sleep interrupted in GAThread initialize");
        }
        try {
            init();
            this.zL = C0790x.m2416B(this.mContext);
            ae.m44V("Initialized GA Thread");
        } catch (Throwable th) {
            ae.m42T("Error initializing the GAThread: " + m2423g(th));
            ae.m42T("Google Analytics will not start up.");
            this.zK = true;
        }
        while (!this.mClosed) {
            try {
                Runnable runnable = (Runnable) this.zJ.take();
                this.zO.lock();
                if (!this.zK) {
                    runnable.run();
                }
                this.zO.unlock();
            } catch (InterruptedException e2) {
                ae.m43U(e2.toString());
            } catch (Throwable th2) {
                ae.m42T("Error on GAThread: " + m2423g(th2));
                ae.m42T("Google Analytics is shutting down.");
                this.zK = true;
            }
        }
    }

    /* renamed from: u */
    public void mo872u(Map<String, String> map) {
        m2420b(new C0142d(this, map));
    }
}
