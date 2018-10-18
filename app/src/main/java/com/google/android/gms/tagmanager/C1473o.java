package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.BaseImplementation.AbstractPendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.C0381c.C1383f;
import com.google.android.gms.internal.C0381c.C1387j;
import com.google.android.gms.internal.ld;
import com.google.android.gms.internal.lf;
import com.google.android.gms.internal.pu.C1431a;
import com.google.android.gms.tagmanager.C1472n.C0642a;
import com.google.android.gms.tagmanager.bg.C0615a;
import com.google.android.gms.tagmanager.ce.C0617a;
import com.google.android.gms.tagmanager.cr.C0625c;

/* renamed from: com.google.android.gms.tagmanager.o */
class C1473o extends AbstractPendingResult<ContainerHolder> {
    private final Looper JF;
    private final C1236d aqB;
    private final cg aqC;
    private final int aqD;
    private C1238f aqE;
    private volatile C1472n aqF;
    private volatile boolean aqG;
    private C1387j aqH;
    private String aqI;
    private C1237e aqJ;
    private C0644a aqK;
    private final String aqm;
    private long aqr;
    private final TagManager aqy;
    private final Context mContext;
    private final ld wb;

    /* renamed from: com.google.android.gms.tagmanager.o$a */
    interface C0644a {
        /* renamed from: b */
        boolean mo2569b(Container container);
    }

    /* renamed from: com.google.android.gms.tagmanager.o$1 */
    class C12321 implements C0642a {
        final /* synthetic */ C1473o aqL;

        C12321(C1473o c1473o) {
            this.aqL = c1473o;
        }

        public void ct(String str) {
            this.aqL.ct(str);
        }

        public String pl() {
            return this.aqL.pl();
        }

        public void pn() {
            bh.m2117W("Refresh ignored: container loaded as default only.");
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.o$b */
    private class C1234b implements bg<C1431a> {
        final /* synthetic */ C1473o aqL;

        private C1234b(C1473o c1473o) {
            this.aqL = c1473o;
        }

        /* renamed from: a */
        public void m3763a(C1431a c1431a) {
            C1387j c1387j;
            if (c1431a.auC != null) {
                c1387j = c1431a.auC;
            } else {
                C1383f c1383f = c1431a.gs;
                c1387j = new C1387j();
                c1387j.gs = c1383f;
                c1387j.gr = null;
                c1387j.gt = c1383f.version;
            }
            this.aqL.m4689a(c1387j, c1431a.auB, true);
        }

        /* renamed from: a */
        public void mo2570a(C0615a c0615a) {
            if (!this.aqL.aqG) {
                this.aqL.m4699w(0);
            }
        }

        /* renamed from: l */
        public /* synthetic */ void mo2571l(Object obj) {
            m3763a((C1431a) obj);
        }

        public void ps() {
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.o$c */
    private class C1235c implements bg<C1387j> {
        final /* synthetic */ C1473o aqL;

        private C1235c(C1473o c1473o) {
            this.aqL = c1473o;
        }

        /* renamed from: a */
        public void mo2570a(C0615a c0615a) {
            if (this.aqL.aqF != null) {
                this.aqL.m2447b(this.aqL.aqF);
            } else {
                this.aqL.m2447b(this.aqL.aD(Status.Kz));
            }
            this.aqL.m4699w(3600000);
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: b */
        public void m3767b(com.google.android.gms.internal.C0381c.C1387j r6) {
            /*
            r5 = this;
            r1 = r5.aqL;
            monitor-enter(r1);
            r0 = r6.gs;	 Catch:{ all -> 0x0065 }
            if (r0 != 0) goto L_0x002a;
        L_0x0007:
            r0 = r5.aqL;	 Catch:{ all -> 0x0065 }
            r0 = r0.aqH;	 Catch:{ all -> 0x0065 }
            r0 = r0.gs;	 Catch:{ all -> 0x0065 }
            if (r0 != 0) goto L_0x0020;
        L_0x0011:
            r0 = "Current resource is null; network resource is also null";
            com.google.android.gms.tagmanager.bh.m2114T(r0);	 Catch:{ all -> 0x0065 }
            r0 = r5.aqL;	 Catch:{ all -> 0x0065 }
            r2 = 3600000; // 0x36ee80 float:5.044674E-39 double:1.7786363E-317;
            r0.m4699w(r2);	 Catch:{ all -> 0x0065 }
            monitor-exit(r1);	 Catch:{ all -> 0x0065 }
        L_0x001f:
            return;
        L_0x0020:
            r0 = r5.aqL;	 Catch:{ all -> 0x0065 }
            r0 = r0.aqH;	 Catch:{ all -> 0x0065 }
            r0 = r0.gs;	 Catch:{ all -> 0x0065 }
            r6.gs = r0;	 Catch:{ all -> 0x0065 }
        L_0x002a:
            r0 = r5.aqL;	 Catch:{ all -> 0x0065 }
            r2 = r5.aqL;	 Catch:{ all -> 0x0065 }
            r2 = r2.wb;	 Catch:{ all -> 0x0065 }
            r2 = r2.currentTimeMillis();	 Catch:{ all -> 0x0065 }
            r4 = 0;
            r0.m4689a(r6, r2, r4);	 Catch:{ all -> 0x0065 }
            r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0065 }
            r0.<init>();	 Catch:{ all -> 0x0065 }
            r2 = "setting refresh time to current time: ";
            r0 = r0.append(r2);	 Catch:{ all -> 0x0065 }
            r2 = r5.aqL;	 Catch:{ all -> 0x0065 }
            r2 = r2.aqr;	 Catch:{ all -> 0x0065 }
            r0 = r0.append(r2);	 Catch:{ all -> 0x0065 }
            r0 = r0.toString();	 Catch:{ all -> 0x0065 }
            com.google.android.gms.tagmanager.bh.m2116V(r0);	 Catch:{ all -> 0x0065 }
            r0 = r5.aqL;	 Catch:{ all -> 0x0065 }
            r0 = r0.pr();	 Catch:{ all -> 0x0065 }
            if (r0 != 0) goto L_0x0063;
        L_0x005e:
            r0 = r5.aqL;	 Catch:{ all -> 0x0065 }
            r0.m4688a(r6);	 Catch:{ all -> 0x0065 }
        L_0x0063:
            monitor-exit(r1);	 Catch:{ all -> 0x0065 }
            goto L_0x001f;
        L_0x0065:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0065 }
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.o.c.b(com.google.android.gms.internal.c$j):void");
        }

        /* renamed from: l */
        public /* synthetic */ void mo2571l(Object obj) {
            m3767b((C1387j) obj);
        }

        public void ps() {
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.o$d */
    private class C1236d implements C0642a {
        final /* synthetic */ C1473o aqL;

        private C1236d(C1473o c1473o) {
            this.aqL = c1473o;
        }

        public void ct(String str) {
            this.aqL.ct(str);
        }

        public String pl() {
            return this.aqL.pl();
        }

        public void pn() {
            if (this.aqL.aqC.fe()) {
                this.aqL.m4699w(0);
            }
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.o$e */
    interface C1237e extends Releasable {
        /* renamed from: a */
        void mo3607a(bg<C1387j> bgVar);

        void cw(String str);

        /* renamed from: e */
        void mo3609e(long j, String str);
    }

    /* renamed from: com.google.android.gms.tagmanager.o$f */
    interface C1238f extends Releasable {
        /* renamed from: a */
        void mo3610a(bg<C1431a> bgVar);

        /* renamed from: b */
        void mo3611b(C1431a c1431a);

        C0625c fH(int i);

        void pt();
    }

    C1473o(Context context, TagManager tagManager, Looper looper, String str, int i, C1238f c1238f, C1237e c1237e, ld ldVar, cg cgVar) {
        super(looper == null ? Looper.getMainLooper() : looper);
        this.mContext = context;
        this.aqy = tagManager;
        if (looper == null) {
            looper = Looper.getMainLooper();
        }
        this.JF = looper;
        this.aqm = str;
        this.aqD = i;
        this.aqE = c1238f;
        this.aqJ = c1237e;
        this.aqB = new C1236d();
        this.aqH = new C1387j();
        this.wb = ldVar;
        this.aqC = cgVar;
        if (pr()) {
            ct(ce.qa().qc());
        }
    }

    public C1473o(Context context, TagManager tagManager, Looper looper, String str, int i, C0645r c0645r) {
        this(context, tagManager, looper, str, i, new cq(context, str), new cp(context, str, c0645r), lf.m3403if(), new bf(30, 900000, 5000, "refreshing", lf.m3403if()));
    }

    /* renamed from: V */
    private void m4686V(final boolean z) {
        this.aqE.mo3610a(new C1234b());
        this.aqJ.mo3607a(new C1235c());
        C0625c fH = this.aqE.fH(this.aqD);
        if (fH != null) {
            this.aqF = new C1472n(this.aqy, this.JF, new Container(this.mContext, this.aqy.getDataLayer(), this.aqm, 0, fH), this.aqB);
        }
        this.aqK = new C0644a(this) {
            final /* synthetic */ C1473o aqL;

            /* renamed from: b */
            public boolean mo2569b(Container container) {
                return z ? container.getLastRefreshTime() + 43200000 >= this.aqL.wb.currentTimeMillis() : !container.isDefault();
            }
        };
        if (pr()) {
            this.aqJ.mo3609e(0, "");
        } else {
            this.aqE.pt();
        }
    }

    /* renamed from: a */
    private synchronized void m4688a(C1387j c1387j) {
        if (this.aqE != null) {
            C1431a c1431a = new C1431a();
            c1431a.auB = this.aqr;
            c1431a.gs = new C1383f();
            c1431a.auC = c1387j;
            this.aqE.mo3611b(c1431a);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private synchronized void m4689a(com.google.android.gms.internal.C0381c.C1387j r9, long r10, boolean r12) {
        /*
        r8 = this;
        r6 = 43200000; // 0x2932e00 float:2.1626111E-37 double:2.1343636E-316;
        monitor-enter(r8);
        if (r12 == 0) goto L_0x000c;
    L_0x0006:
        r0 = r8.aqG;	 Catch:{ all -> 0x006a }
        if (r0 == 0) goto L_0x000c;
    L_0x000a:
        monitor-exit(r8);
        return;
    L_0x000c:
        r0 = r8.isReady();	 Catch:{ all -> 0x006a }
        if (r0 == 0) goto L_0x0016;
    L_0x0012:
        r0 = r8.aqF;	 Catch:{ all -> 0x006a }
        if (r0 != 0) goto L_0x0016;
    L_0x0016:
        r8.aqH = r9;	 Catch:{ all -> 0x006a }
        r8.aqr = r10;	 Catch:{ all -> 0x006a }
        r0 = 0;
        r2 = 43200000; // 0x2932e00 float:2.1626111E-37 double:2.1343636E-316;
        r4 = r8.aqr;	 Catch:{ all -> 0x006a }
        r4 = r4 + r6;
        r6 = r8.wb;	 Catch:{ all -> 0x006a }
        r6 = r6.currentTimeMillis();	 Catch:{ all -> 0x006a }
        r4 = r4 - r6;
        r2 = java.lang.Math.min(r2, r4);	 Catch:{ all -> 0x006a }
        r0 = java.lang.Math.max(r0, r2);	 Catch:{ all -> 0x006a }
        r8.m4699w(r0);	 Catch:{ all -> 0x006a }
        r0 = new com.google.android.gms.tagmanager.Container;	 Catch:{ all -> 0x006a }
        r1 = r8.mContext;	 Catch:{ all -> 0x006a }
        r2 = r8.aqy;	 Catch:{ all -> 0x006a }
        r2 = r2.getDataLayer();	 Catch:{ all -> 0x006a }
        r3 = r8.aqm;	 Catch:{ all -> 0x006a }
        r4 = r10;
        r6 = r9;
        r0.<init>(r1, r2, r3, r4, r6);	 Catch:{ all -> 0x006a }
        r1 = r8.aqF;	 Catch:{ all -> 0x006a }
        if (r1 != 0) goto L_0x006d;
    L_0x0049:
        r1 = new com.google.android.gms.tagmanager.n;	 Catch:{ all -> 0x006a }
        r2 = r8.aqy;	 Catch:{ all -> 0x006a }
        r3 = r8.JF;	 Catch:{ all -> 0x006a }
        r4 = r8.aqB;	 Catch:{ all -> 0x006a }
        r1.<init>(r2, r3, r0, r4);	 Catch:{ all -> 0x006a }
        r8.aqF = r1;	 Catch:{ all -> 0x006a }
    L_0x0056:
        r1 = r8.isReady();	 Catch:{ all -> 0x006a }
        if (r1 != 0) goto L_0x000a;
    L_0x005c:
        r1 = r8.aqK;	 Catch:{ all -> 0x006a }
        r0 = r1.mo2569b(r0);	 Catch:{ all -> 0x006a }
        if (r0 == 0) goto L_0x000a;
    L_0x0064:
        r0 = r8.aqF;	 Catch:{ all -> 0x006a }
        r8.m2447b(r0);	 Catch:{ all -> 0x006a }
        goto L_0x000a;
    L_0x006a:
        r0 = move-exception;
        monitor-exit(r8);
        throw r0;
    L_0x006d:
        r1 = r8.aqF;	 Catch:{ all -> 0x006a }
        r1.m4685a(r0);	 Catch:{ all -> 0x006a }
        goto L_0x0056;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.o.a(com.google.android.gms.internal.c$j, long, boolean):void");
    }

    private boolean pr() {
        ce qa = ce.qa();
        return (qa.qb() == C0617a.CONTAINER || qa.qb() == C0617a.CONTAINER_DEBUG) && this.aqm.equals(qa.getContainerId());
    }

    /* renamed from: w */
    private synchronized void m4699w(long j) {
        if (this.aqJ == null) {
            bh.m2117W("Refresh requested, but no network load scheduler.");
        } else {
            this.aqJ.mo3609e(j, this.aqH.gt);
        }
    }

    protected ContainerHolder aD(Status status) {
        if (this.aqF != null) {
            return this.aqF;
        }
        if (status == Status.Kz) {
            bh.m2114T("timer expired: setting result to failure");
        }
        return new C1472n(status);
    }

    /* renamed from: c */
    protected /* synthetic */ Result mo2958c(Status status) {
        return aD(status);
    }

    synchronized void ct(String str) {
        this.aqI = str;
        if (this.aqJ != null) {
            this.aqJ.cw(str);
        }
    }

    synchronized String pl() {
        return this.aqI;
    }

    public void po() {
        C0625c fH = this.aqE.fH(this.aqD);
        if (fH != null) {
            m2447b(new C1472n(this.aqy, this.JF, new Container(this.mContext, this.aqy.getDataLayer(), this.aqm, 0, fH), new C12321(this)));
        } else {
            String str = "Default was requested, but no default container was found";
            bh.m2114T(str);
            m2447b(aD(new Status(10, str, null)));
        }
        this.aqJ = null;
        this.aqE = null;
    }

    public void pp() {
        m4686V(false);
    }

    public void pq() {
        m4686V(true);
    }
}
