package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.internal.fe.C0426a;

@ey
public abstract class ff extends gf {
    private final fh qh;
    private final C0426a tI;

    @ey
    /* renamed from: com.google.android.gms.internal.ff$a */
    public static final class C1390a extends ff {
        private final Context mContext;

        public C1390a(Context context, fh fhVar, C0426a c0426a) {
            super(fhVar, c0426a);
            this.mContext = context;
        }

        public void cJ() {
        }

        public fl cK() {
            Bundle bN = ga.bN();
            return fq.m4378a(this.mContext, new bm(bN.getString("gads:sdk_core_location"), bN.getString("gads:sdk_core_experiment_id"), bN.getString("gads:block_autoclicks_experiment_id"), bN.getString("gads:spam_app_context:experiment_id")), new co(), new fx());
        }
    }

    @ey
    /* renamed from: com.google.android.gms.internal.ff$b */
    public static final class C1391b extends ff implements ConnectionCallbacks, OnConnectionFailedListener {
        private final Object mH = new Object();
        private final C0426a tI;
        private final fg tJ;

        public C1391b(Context context, fh fhVar, C0426a c0426a) {
            super(fhVar, c0426a);
            this.tI = c0426a;
            this.tJ = new fg(context, this, this, fhVar.lO.wU);
            this.tJ.connect();
        }

        public void cJ() {
            synchronized (this.mH) {
                if (this.tJ.isConnected() || this.tJ.isConnecting()) {
                    this.tJ.disconnect();
                }
            }
        }

        public fl cK() {
            fl cL;
            synchronized (this.mH) {
                try {
                    cL = this.tJ.cL();
                } catch (IllegalStateException e) {
                    cL = null;
                    return cL;
                } catch (DeadObjectException e2) {
                    cL = null;
                    return cL;
                }
            }
            return cL;
        }

        public void onConnected(Bundle connectionHint) {
            start();
        }

        public void onConnectionFailed(ConnectionResult result) {
            this.tI.mo1791a(new fj(0));
        }

        public void onConnectionSuspended(int cause) {
            gr.m1337S("Disconnected from remote ad request service.");
        }
    }

    public ff(fh fhVar, C0426a c0426a) {
        this.qh = fhVar;
        this.tI = c0426a;
    }

    /* renamed from: a */
    private static fj m3174a(fl flVar, fh fhVar) {
        fj fjVar = null;
        try {
            fjVar = flVar.mo1792b(fhVar);
        } catch (Throwable e) {
            gr.m1345d("Could not fetch ad response from ad request service.", e);
        } catch (Throwable e2) {
            gr.m1345d("Could not fetch ad response from ad request service due to an Exception.", e2);
        } catch (Throwable e22) {
            gr.m1345d("Could not fetch ad response from ad request service due to an Exception.", e22);
        } catch (Throwable e222) {
            ga.m3195e(e222);
        }
        return fjVar;
    }

    public abstract void cJ();

    public abstract fl cK();

    public final void cx() {
        try {
            fj fjVar;
            fl cK = cK();
            if (cK == null) {
                fjVar = new fj(0);
            } else {
                fjVar = m3174a(cK, this.qh);
                if (fjVar == null) {
                    fjVar = new fj(0);
                }
            }
            cJ();
            this.tI.mo1791a(fjVar);
        } catch (Throwable th) {
            cJ();
        }
    }

    public final void onStop() {
        cJ();
    }
}
