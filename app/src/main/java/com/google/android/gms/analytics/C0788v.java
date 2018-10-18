package com.google.android.gms.analytics;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.google.android.gms.analytics.C0144y.C0143a;

/* renamed from: com.google.android.gms.analytics.v */
class C0788v extends aj {
    private static final Object yT = new Object();
    private static C0788v zf;
    private Context mContext;
    private Handler mHandler;
    private C0114d yU;
    private volatile C0116f yV;
    private int yW = 1800;
    private boolean yX = true;
    private boolean yY;
    private String yZ;
    private boolean yt = false;
    private boolean za = true;
    private boolean zb = true;
    private C0115e zc = new C07871(this);
    private C0129u zd;
    private boolean ze = false;

    /* renamed from: com.google.android.gms.analytics.v$2 */
    class C01302 implements Callback {
        final /* synthetic */ C0788v zg;

        C01302(C0788v c0788v) {
            this.zg = c0788v;
        }

        public boolean handleMessage(Message msg) {
            if (1 == msg.what && C0788v.yT.equals(msg.obj)) {
                C0144y.eK().m85D(true);
                this.zg.dispatchLocalHits();
                C0144y.eK().m85D(false);
                if (this.zg.yW > 0 && !this.zg.ze) {
                    this.zg.mHandler.sendMessageDelayed(this.zg.mHandler.obtainMessage(1, C0788v.yT), (long) (this.zg.yW * 1000));
                }
            }
            return true;
        }
    }

    /* renamed from: com.google.android.gms.analytics.v$1 */
    class C07871 implements C0115e {
        final /* synthetic */ C0788v zg;

        C07871(C0788v c0788v) {
            this.zg = c0788v;
        }

        /* renamed from: B */
        public void mo853B(boolean z) {
            this.zg.m2401a(z, this.zg.za);
        }
    }

    private C0788v() {
    }

    public static C0788v eu() {
        if (zf == null) {
            zf = new C0788v();
        }
        return zf;
    }

    private void ev() {
        this.zd = new C0129u(this);
        this.zd.m80z(this.mContext);
    }

    private void ew() {
        this.mHandler = new Handler(this.mContext.getMainLooper(), new C01302(this));
        if (this.yW > 0) {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, yT), (long) (this.yW * 1000));
        }
    }

    /* renamed from: C */
    synchronized void mo854C(boolean z) {
        m2401a(this.ze, z);
    }

    /* renamed from: a */
    synchronized void m2400a(Context context, C0116f c0116f) {
        if (this.mContext == null) {
            this.mContext = context.getApplicationContext();
            if (this.yV == null) {
                this.yV = c0116f;
                if (this.yX) {
                    dispatchLocalHits();
                    this.yX = false;
                }
                if (this.yY) {
                    dW();
                    this.yY = false;
                }
            }
        }
    }

    /* renamed from: a */
    synchronized void m2401a(boolean z, boolean z2) {
        if (!(this.ze == z && this.za == z2)) {
            if (z || !z2) {
                if (this.yW > 0) {
                    this.mHandler.removeMessages(1, yT);
                }
            }
            if (!z && z2 && this.yW > 0) {
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, yT), (long) (this.yW * 1000));
            }
            StringBuilder append = new StringBuilder().append("PowerSaveMode ");
            String str = (z || !z2) ? "initiated." : "terminated.";
            ae.m44V(append.append(str).toString());
            this.ze = z;
            this.za = z2;
        }
    }

    void dW() {
        if (this.yV == null) {
            ae.m44V("setForceLocalDispatch() queued. It will be called once initialization is complete.");
            this.yY = true;
            return;
        }
        C0144y.eK().m86a(C0143a.SET_FORCE_LOCAL_DISPATCH);
        this.yV.dW();
    }

    synchronized void dispatchLocalHits() {
        if (this.yV == null) {
            ae.m44V("Dispatch call queued. Dispatch will run once initialization is complete.");
            this.yX = true;
        } else {
            C0144y.eK().m86a(C0143a.DISPATCH);
            this.yV.dispatch();
        }
    }

    synchronized C0114d ex() {
        if (this.yU == null) {
            if (this.mContext == null) {
                throw new IllegalStateException("Cant get a store unless we have a context");
            }
            this.yU = new ag(this.zc, this.mContext, new C0784j());
            this.yU.setDryRun(this.yt);
            if (this.yZ != null) {
                this.yU.dV().ad(this.yZ);
                this.yZ = null;
            }
        }
        if (this.mHandler == null) {
            ew();
        }
        if (this.zd == null && this.zb) {
            ev();
        }
        return this.yU;
    }

    synchronized void ey() {
        if (!this.ze && this.za && this.yW > 0) {
            this.mHandler.removeMessages(1, yT);
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1, yT));
        }
    }

    synchronized void setLocalDispatchPeriod(int dispatchPeriodInSeconds) {
        if (this.mHandler == null) {
            ae.m44V("Dispatch period set with null handler. Dispatch will run once initialization is complete.");
            this.yW = dispatchPeriodInSeconds;
        } else {
            C0144y.eK().m86a(C0143a.SET_DISPATCH_PERIOD);
            if (!this.ze && this.za && this.yW > 0) {
                this.mHandler.removeMessages(1, yT);
            }
            this.yW = dispatchPeriodInSeconds;
            if (dispatchPeriodInSeconds > 0 && !this.ze && this.za) {
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, yT), (long) (dispatchPeriodInSeconds * 1000));
            }
        }
    }
}
