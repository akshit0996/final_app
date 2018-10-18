package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.C0381c.C1387j;
import com.google.android.gms.tagmanager.C1473o.C1237e;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

class cp implements C1237e {
    private String aqI;
    private final String aqm;
    private bg<C1387j> asC;
    private C0645r asD;
    private final ScheduledExecutorService asF;
    private final C0618a asG;
    private ScheduledFuture<?> asH;
    private boolean mClosed;
    private final Context mContext;

    /* renamed from: com.google.android.gms.tagmanager.cp$a */
    interface C0618a {
        /* renamed from: a */
        co mo2556a(C0645r c0645r);
    }

    /* renamed from: com.google.android.gms.tagmanager.cp$b */
    interface C0619b {
        ScheduledExecutorService qh();
    }

    /* renamed from: com.google.android.gms.tagmanager.cp$1 */
    class C12161 implements C0619b {
        final /* synthetic */ cp asI;

        C12161(cp cpVar) {
            this.asI = cpVar;
        }

        public ScheduledExecutorService qh() {
            return Executors.newSingleThreadScheduledExecutor();
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cp$2 */
    class C12172 implements C0618a {
        final /* synthetic */ cp asI;

        C12172(cp cpVar) {
            this.asI = cpVar;
        }

        /* renamed from: a */
        public co mo2556a(C0645r c0645r) {
            return new co(this.asI.mContext, this.asI.aqm, c0645r);
        }
    }

    public cp(Context context, String str, C0645r c0645r) {
        this(context, str, c0645r, null, null);
    }

    cp(Context context, String str, C0645r c0645r, C0619b c0619b, C0618a c0618a) {
        this.asD = c0645r;
        this.mContext = context;
        this.aqm = str;
        if (c0619b == null) {
            c0619b = new C12161(this);
        }
        this.asF = c0619b.qh();
        if (c0618a == null) {
            this.asG = new C12172(this);
        } else {
            this.asG = c0618a;
        }
    }

    private co cM(String str) {
        co a = this.asG.mo2556a(this.asD);
        a.m2136a(this.asC);
        a.cw(this.aqI);
        a.cL(str);
        return a;
    }

    private synchronized void qg() {
        if (this.mClosed) {
            throw new IllegalStateException("called method after closed");
        }
    }

    /* renamed from: a */
    public synchronized void mo3607a(bg<C1387j> bgVar) {
        qg();
        this.asC = bgVar;
    }

    public synchronized void cw(String str) {
        qg();
        this.aqI = str;
    }

    /* renamed from: e */
    public synchronized void mo3609e(long j, String str) {
        bh.m2116V("loadAfterDelay: containerId=" + this.aqm + " delay=" + j);
        qg();
        if (this.asC == null) {
            throw new IllegalStateException("callback must be set before loadAfterDelay() is called.");
        }
        if (this.asH != null) {
            this.asH.cancel(false);
        }
        this.asH = this.asF.schedule(cM(str), j, TimeUnit.MILLISECONDS);
    }

    public synchronized void release() {
        qg();
        if (this.asH != null) {
            this.asH.cancel(false);
        }
        this.asF.shutdown();
        this.mClosed = true;
    }
}
