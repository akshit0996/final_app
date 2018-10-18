package com.google.android.gms.analytics;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.analytics.C0781c.C0112b;
import com.google.android.gms.analytics.C0781c.C0113c;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.ha;
import com.google.android.gms.internal.ld;
import com.google.android.gms.internal.lf;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentLinkedQueue;

/* renamed from: com.google.android.gms.analytics.w */
class C0789w implements ak, C0112b, C0113c {
    private final Context mContext;
    private ld wb;
    private C0114d yU;
    private final C0116f yV;
    private boolean yX;
    private volatile long zh;
    private volatile C0133a zi;
    private volatile C0110b zj;
    private C0114d zk;
    private final GoogleAnalytics zl;
    private final Queue<C0136d> zm;
    private volatile int zn;
    private volatile Timer zo;
    private volatile Timer zp;
    private volatile Timer zq;
    private boolean zr;
    private boolean zs;
    private boolean zt;
    private long zu;

    /* renamed from: com.google.android.gms.analytics.w$1 */
    class C01311 implements Runnable {
        final /* synthetic */ C0789w zv;

        C01311(C0789w c0789w) {
            this.zv = c0789w;
        }

        public void run() {
            this.zv.eC();
        }
    }

    /* renamed from: com.google.android.gms.analytics.w$a */
    private enum C0133a {
        CONNECTING,
        CONNECTED_SERVICE,
        CONNECTED_LOCAL,
        BLOCKED,
        PENDING_CONNECTION,
        PENDING_DISCONNECT,
        DISCONNECTED
    }

    /* renamed from: com.google.android.gms.analytics.w$b */
    private class C0134b extends TimerTask {
        final /* synthetic */ C0789w zv;

        private C0134b(C0789w c0789w) {
            this.zv = c0789w;
        }

        public void run() {
            if (this.zv.zi == C0133a.CONNECTED_SERVICE && this.zv.zm.isEmpty() && this.zv.zh + this.zv.zu < this.zv.wb.elapsedRealtime()) {
                ae.m44V("Disconnecting due to inactivity");
                this.zv.cJ();
                return;
            }
            this.zv.zq.schedule(new C0134b(this.zv), this.zv.zu);
        }
    }

    /* renamed from: com.google.android.gms.analytics.w$c */
    private class C0135c extends TimerTask {
        final /* synthetic */ C0789w zv;

        private C0135c(C0789w c0789w) {
            this.zv = c0789w;
        }

        public void run() {
            if (this.zv.zi == C0133a.CONNECTING) {
                this.zv.eE();
            }
        }
    }

    /* renamed from: com.google.android.gms.analytics.w$d */
    private static class C0136d {
        private final Map<String, String> zF;
        private final long zG;
        private final String zH;
        private final List<ha> zI;

        public C0136d(Map<String, String> map, long j, String str, List<ha> list) {
            this.zF = map;
            this.zG = j;
            this.zH = str;
            this.zI = list;
        }

        public Map<String, String> eH() {
            return this.zF;
        }

        public long eI() {
            return this.zG;
        }

        public List<ha> eJ() {
            return this.zI;
        }

        public String getPath() {
            return this.zH;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("PATH: ");
            stringBuilder.append(this.zH);
            if (this.zF != null) {
                stringBuilder.append("  PARAMS: ");
                for (Entry entry : this.zF.entrySet()) {
                    stringBuilder.append((String) entry.getKey());
                    stringBuilder.append("=");
                    stringBuilder.append((String) entry.getValue());
                    stringBuilder.append(",  ");
                }
            }
            return stringBuilder.toString();
        }
    }

    /* renamed from: com.google.android.gms.analytics.w$e */
    private class C0137e extends TimerTask {
        final /* synthetic */ C0789w zv;

        private C0137e(C0789w c0789w) {
            this.zv = c0789w;
        }

        public void run() {
            this.zv.eF();
        }
    }

    C0789w(Context context, C0116f c0116f) {
        this(context, c0116f, null, GoogleAnalytics.getInstance(context));
    }

    C0789w(Context context, C0116f c0116f, C0114d c0114d, GoogleAnalytics googleAnalytics) {
        this.zm = new ConcurrentLinkedQueue();
        this.zu = 300000;
        this.zk = c0114d;
        this.mContext = context;
        this.yV = c0116f;
        this.zl = googleAnalytics;
        this.wb = lf.m3403if();
        this.zn = 0;
        this.zi = C0133a.DISCONNECTED;
    }

    /* renamed from: a */
    private Timer m2402a(Timer timer) {
        if (timer != null) {
            timer.cancel();
        }
        return null;
    }

    private synchronized void cJ() {
        if (this.zj != null && this.zi == C0133a.CONNECTED_SERVICE) {
            this.zi = C0133a.PENDING_DISCONNECT;
            this.zj.disconnect();
        }
    }

    private void eA() {
        this.zo = m2402a(this.zo);
        this.zp = m2402a(this.zp);
        this.zq = m2402a(this.zq);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void eC() {
        /*
        r7 = this;
        monitor-enter(r7);
        r1 = java.lang.Thread.currentThread();	 Catch:{ all -> 0x0074 }
        r2 = r7.yV;	 Catch:{ all -> 0x0074 }
        r2 = r2.getThread();	 Catch:{ all -> 0x0074 }
        r1 = r1.equals(r2);	 Catch:{ all -> 0x0074 }
        if (r1 != 0) goto L_0x0021;
    L_0x0011:
        r1 = r7.yV;	 Catch:{ all -> 0x0074 }
        r1 = r1.dX();	 Catch:{ all -> 0x0074 }
        r2 = new com.google.android.gms.analytics.w$1;	 Catch:{ all -> 0x0074 }
        r2.<init>(r7);	 Catch:{ all -> 0x0074 }
        r1.add(r2);	 Catch:{ all -> 0x0074 }
    L_0x001f:
        monitor-exit(r7);
        return;
    L_0x0021:
        r1 = r7.zr;	 Catch:{ all -> 0x0074 }
        if (r1 == 0) goto L_0x0028;
    L_0x0025:
        r7.dQ();	 Catch:{ all -> 0x0074 }
    L_0x0028:
        r1 = com.google.android.gms.analytics.C0789w.C01322.zw;	 Catch:{ all -> 0x0074 }
        r2 = r7.zi;	 Catch:{ all -> 0x0074 }
        r2 = r2.ordinal();	 Catch:{ all -> 0x0074 }
        r1 = r1[r2];	 Catch:{ all -> 0x0074 }
        switch(r1) {
            case 1: goto L_0x0036;
            case 2: goto L_0x008a;
            case 3: goto L_0x0035;
            case 4: goto L_0x0035;
            case 5: goto L_0x0035;
            case 6: goto L_0x00e5;
            case 7: goto L_0x0077;
            default: goto L_0x0035;
        };	 Catch:{ all -> 0x0074 }
    L_0x0035:
        goto L_0x001f;
    L_0x0036:
        r1 = r7.zm;	 Catch:{ all -> 0x0074 }
        r1 = r1.isEmpty();	 Catch:{ all -> 0x0074 }
        if (r1 != 0) goto L_0x0082;
    L_0x003e:
        r1 = r7.zm;	 Catch:{ all -> 0x0074 }
        r1 = r1.poll();	 Catch:{ all -> 0x0074 }
        r0 = r1;
        r0 = (com.google.android.gms.analytics.C0789w.C0136d) r0;	 Catch:{ all -> 0x0074 }
        r6 = r0;
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0074 }
        r1.<init>();	 Catch:{ all -> 0x0074 }
        r2 = "Sending hit to store  ";
        r1 = r1.append(r2);	 Catch:{ all -> 0x0074 }
        r1 = r1.append(r6);	 Catch:{ all -> 0x0074 }
        r1 = r1.toString();	 Catch:{ all -> 0x0074 }
        com.google.android.gms.analytics.ae.m44V(r1);	 Catch:{ all -> 0x0074 }
        r1 = r7.yU;	 Catch:{ all -> 0x0074 }
        r2 = r6.eH();	 Catch:{ all -> 0x0074 }
        r3 = r6.eI();	 Catch:{ all -> 0x0074 }
        r5 = r6.getPath();	 Catch:{ all -> 0x0074 }
        r6 = r6.eJ();	 Catch:{ all -> 0x0074 }
        r1.mo818a(r2, r3, r5, r6);	 Catch:{ all -> 0x0074 }
        goto L_0x0036;
    L_0x0074:
        r1 = move-exception;
        monitor-exit(r7);
        throw r1;
    L_0x0077:
        r1 = "Blocked. Dropping hits.";
        com.google.android.gms.analytics.ae.m44V(r1);	 Catch:{ all -> 0x0074 }
        r1 = r7.zm;	 Catch:{ all -> 0x0074 }
        r1.clear();	 Catch:{ all -> 0x0074 }
        goto L_0x001f;
    L_0x0082:
        r1 = r7.yX;	 Catch:{ all -> 0x0074 }
        if (r1 == 0) goto L_0x001f;
    L_0x0086:
        r7.eD();	 Catch:{ all -> 0x0074 }
        goto L_0x001f;
    L_0x008a:
        r1 = r7.zm;	 Catch:{ all -> 0x0074 }
        r1 = r1.isEmpty();	 Catch:{ all -> 0x0074 }
        if (r1 != 0) goto L_0x00db;
    L_0x0092:
        r1 = r7.zm;	 Catch:{ all -> 0x0074 }
        r1 = r1.peek();	 Catch:{ all -> 0x0074 }
        r0 = r1;
        r0 = (com.google.android.gms.analytics.C0789w.C0136d) r0;	 Catch:{ all -> 0x0074 }
        r6 = r0;
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0074 }
        r1.<init>();	 Catch:{ all -> 0x0074 }
        r2 = "Sending hit to service   ";
        r1 = r1.append(r2);	 Catch:{ all -> 0x0074 }
        r1 = r1.append(r6);	 Catch:{ all -> 0x0074 }
        r1 = r1.toString();	 Catch:{ all -> 0x0074 }
        com.google.android.gms.analytics.ae.m44V(r1);	 Catch:{ all -> 0x0074 }
        r1 = r7.zl;	 Catch:{ all -> 0x0074 }
        r1 = r1.isDryRunEnabled();	 Catch:{ all -> 0x0074 }
        if (r1 != 0) goto L_0x00d5;
    L_0x00ba:
        r1 = r7.zj;	 Catch:{ all -> 0x0074 }
        r2 = r6.eH();	 Catch:{ all -> 0x0074 }
        r3 = r6.eI();	 Catch:{ all -> 0x0074 }
        r5 = r6.getPath();	 Catch:{ all -> 0x0074 }
        r6 = r6.eJ();	 Catch:{ all -> 0x0074 }
        r1.mo828a(r2, r3, r5, r6);	 Catch:{ all -> 0x0074 }
    L_0x00cf:
        r1 = r7.zm;	 Catch:{ all -> 0x0074 }
        r1.poll();	 Catch:{ all -> 0x0074 }
        goto L_0x008a;
    L_0x00d5:
        r1 = "Dry run enabled. Hit not actually sent to service.";
        com.google.android.gms.analytics.ae.m44V(r1);	 Catch:{ all -> 0x0074 }
        goto L_0x00cf;
    L_0x00db:
        r1 = r7.wb;	 Catch:{ all -> 0x0074 }
        r1 = r1.elapsedRealtime();	 Catch:{ all -> 0x0074 }
        r7.zh = r1;	 Catch:{ all -> 0x0074 }
        goto L_0x001f;
    L_0x00e5:
        r1 = "Need to reconnect";
        com.google.android.gms.analytics.ae.m44V(r1);	 Catch:{ all -> 0x0074 }
        r1 = r7.zm;	 Catch:{ all -> 0x0074 }
        r1 = r1.isEmpty();	 Catch:{ all -> 0x0074 }
        if (r1 != 0) goto L_0x001f;
    L_0x00f2:
        r7.eF();	 Catch:{ all -> 0x0074 }
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.w.eC():void");
    }

    private void eD() {
        this.yU.dispatch();
        this.yX = false;
    }

    private synchronized void eE() {
        if (this.zi != C0133a.CONNECTED_LOCAL) {
            if (this.mContext == null || !GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE.equals(this.mContext.getPackageName())) {
                eA();
                ae.m44V("falling back to local store");
                if (this.zk != null) {
                    this.yU = this.zk;
                } else {
                    C0788v eu = C0788v.eu();
                    eu.m2400a(this.mContext, this.yV);
                    this.yU = eu.ex();
                }
                this.zi = C0133a.CONNECTED_LOCAL;
                eC();
            } else {
                this.zi = C0133a.BLOCKED;
                this.zj.disconnect();
                ae.m45W("Attempted to fall back to local store from service.");
            }
        }
    }

    private synchronized void eF() {
        if (this.zt || this.zj == null || this.zi == C0133a.CONNECTED_LOCAL) {
            ae.m45W("client not initialized.");
            eE();
        } else {
            try {
                this.zn++;
                m2402a(this.zp);
                this.zi = C0133a.CONNECTING;
                this.zp = new Timer("Failed Connect");
                this.zp.schedule(new C0135c(), 3000);
                ae.m44V("connecting to Analytics service");
                this.zj.connect();
            } catch (SecurityException e) {
                ae.m45W("security exception on connectToService");
                eE();
            }
        }
    }

    private void eG() {
        this.zo = m2402a(this.zo);
        this.zo = new Timer("Service Reconnect");
        this.zo.schedule(new C0137e(), 5000);
    }

    /* renamed from: a */
    public synchronized void mo858a(int i, Intent intent) {
        this.zi = C0133a.PENDING_CONNECTION;
        if (this.zn < 2) {
            ae.m45W("Service unavailable (code=" + i + "), will retry.");
            eG();
        } else {
            ae.m45W("Service unavailable (code=" + i + "), using local store.");
            eE();
        }
    }

    /* renamed from: b */
    public void mo859b(Map<String, String> map, long j, String str, List<ha> list) {
        ae.m44V("putHit called");
        this.zm.add(new C0136d(map, j, str, list));
        eC();
    }

    public void dQ() {
        ae.m44V("clearHits called");
        this.zm.clear();
        switch (this.zi) {
            case CONNECTED_LOCAL:
                this.yU.mo821l(0);
                this.zr = false;
                return;
            case CONNECTED_SERVICE:
                this.zj.dQ();
                this.zr = false;
                return;
            default:
                this.zr = true;
                return;
        }
    }

    public synchronized void dW() {
        if (!this.zt) {
            ae.m44V("setForceLocalDispatch called.");
            this.zt = true;
            switch (this.zi) {
                case CONNECTED_LOCAL:
                case PENDING_CONNECTION:
                case PENDING_DISCONNECT:
                case DISCONNECTED:
                    break;
                case CONNECTED_SERVICE:
                    cJ();
                    break;
                case CONNECTING:
                    this.zs = true;
                    break;
                default:
                    break;
            }
        }
    }

    public void dispatch() {
        switch (this.zi) {
            case CONNECTED_LOCAL:
                eD();
                return;
            case CONNECTED_SERVICE:
                return;
            default:
                this.yX = true;
                return;
        }
    }

    public void eB() {
        if (this.zj == null) {
            this.zj = new C0781c(this.mContext, this, this);
            eF();
        }
    }

    public synchronized void onConnected() {
        this.zp = m2402a(this.zp);
        this.zn = 0;
        ae.m44V("Connected to service");
        this.zi = C0133a.CONNECTED_SERVICE;
        if (this.zs) {
            cJ();
            this.zs = false;
        } else {
            eC();
            this.zq = m2402a(this.zq);
            this.zq = new Timer("disconnect check");
            this.zq.schedule(new C0134b(), this.zu);
        }
    }

    public synchronized void onDisconnected() {
        if (this.zi == C0133a.BLOCKED) {
            ae.m44V("Service blocked.");
            eA();
        } else if (this.zi == C0133a.PENDING_DISCONNECT) {
            ae.m44V("Disconnected from service");
            eA();
            this.zi = C0133a.DISCONNECTED;
        } else {
            ae.m44V("Unexpected disconnect.");
            this.zi = C0133a.PENDING_CONNECTION;
            if (this.zn < 2) {
                eG();
            } else {
                eE();
            }
        }
    }
}
