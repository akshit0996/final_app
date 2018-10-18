package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.gms.dynamic.C1332e;
import com.google.android.gms.internal.cv.C0385a;

@ey
public final class cu implements C0385a {
    private final cy lA;
    private final Context mContext;
    private final Object mH = new Object();
    private final av mw;
    private final String qF;
    private final long qG;
    private final cq qH;
    private final ay qI;
    private final gs qJ;
    private cz qK;
    private int qL = -2;

    public cu(Context context, String str, cy cyVar, cr crVar, cq cqVar, av avVar, ay ayVar, gs gsVar) {
        this.mContext = context;
        this.lA = cyVar;
        this.qH = cqVar;
        if ("com.google.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
            this.qF = bO();
        } else {
            this.qF = str;
        }
        this.qG = crVar.qv != -1 ? crVar.qv : 10000;
        this.mw = avVar;
        this.qI = ayVar;
        this.qJ = gsVar;
    }

    /* renamed from: a */
    private void m3090a(long j, long j2, long j3, long j4) {
        while (this.qL == -2) {
            m3094b(j, j2, j3, j4);
        }
    }

    /* renamed from: a */
    private void m3091a(ct ctVar) {
        try {
            if (this.qJ.wU < 4100000) {
                if (this.qI.oq) {
                    this.qK.mo1709a(C1332e.m4013k(this.mContext), this.mw, this.qH.qt, ctVar);
                } else {
                    this.qK.mo1711a(C1332e.m4013k(this.mContext), this.qI, this.mw, this.qH.qt, (da) ctVar);
                }
            } else if (this.qI.oq) {
                this.qK.mo1710a(C1332e.m4013k(this.mContext), this.mw, this.qH.qt, this.qH.qn, (da) ctVar);
            } else {
                this.qK.mo1712a(C1332e.m4013k(this.mContext), this.qI, this.mw, this.qH.qt, this.qH.qn, ctVar);
            }
        } catch (Throwable e) {
            gr.m1345d("Could not request ad from mediation adapter.", e);
            mo1706k(5);
        }
    }

    /* renamed from: b */
    private void m3094b(long j, long j2, long j3, long j4) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j5 = j2 - (elapsedRealtime - j);
        elapsedRealtime = j4 - (elapsedRealtime - j3);
        if (j5 <= 0 || elapsedRealtime <= 0) {
            gr.m1339U("Timed out waiting for adapter.");
            this.qL = 3;
            return;
        }
        try {
            this.mH.wait(Math.min(j5, elapsedRealtime));
        } catch (InterruptedException e) {
            this.qL = -1;
        }
    }

    private String bO() {
        try {
            if (!TextUtils.isEmpty(this.qH.qr)) {
                return this.lA.mo1708y(this.qH.qr) ? "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter" : "com.google.ads.mediation.customevent.CustomEventAdapter";
            }
        } catch (RemoteException e) {
            gr.m1341W("Fail to determine the custom event's version, assuming the old one.");
        }
        return "com.google.ads.mediation.customevent.CustomEventAdapter";
    }

    private cz bP() {
        gr.m1339U("Instantiating mediation adapter: " + this.qF);
        try {
            return this.lA.mo1707x(this.qF);
        } catch (Throwable e) {
            gr.m1342a("Could not instantiate mediation adapter: " + this.qF, e);
            return null;
        }
    }

    /* renamed from: b */
    public cv m3097b(long j, long j2) {
        cv cvVar;
        synchronized (this.mH) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            final ct ctVar = new ct();
            gq.wR.post(new Runnable(this) {
                final /* synthetic */ cu qN;

                public void run() {
                    synchronized (this.qN.mH) {
                        if (this.qN.qL != -2) {
                            return;
                        }
                        this.qN.qK = this.qN.bP();
                        if (this.qN.qK == null) {
                            this.qN.mo1706k(4);
                            return;
                        }
                        ctVar.m4336a(this.qN);
                        this.qN.m3091a(ctVar);
                    }
                }
            });
            m3090a(elapsedRealtime, this.qG, j, j2);
            cvVar = new cv(this.qH, this.qK, this.qF, ctVar, this.qL);
        }
        return cvVar;
    }

    public void cancel() {
        synchronized (this.mH) {
            try {
                if (this.qK != null) {
                    this.qK.destroy();
                }
            } catch (Throwable e) {
                gr.m1345d("Could not destroy mediation adapter.", e);
            }
            this.qL = -1;
            this.mH.notify();
        }
    }

    /* renamed from: k */
    public void mo1706k(int i) {
        synchronized (this.mH) {
            this.qL = i;
            this.mH.notify();
        }
    }
}
