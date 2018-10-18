package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;

class cy extends cx {
    private static cy atJ;
    private static final Object yT = new Object();
    private at atA;
    private volatile ar atB;
    private int atC = 1800000;
    private boolean atD = true;
    private boolean atE = false;
    private boolean atF = true;
    private au atG = new C12221(this);
    private bo atH;
    private boolean atI = false;
    private Context atz;
    private boolean connected = true;
    private Handler handler;

    /* renamed from: com.google.android.gms.tagmanager.cy$2 */
    class C06332 implements Callback {
        final /* synthetic */ cy atK;

        C06332(cy cyVar) {
            this.atK = cyVar;
        }

        public boolean handleMessage(Message msg) {
            if (1 == msg.what && cy.yT.equals(msg.obj)) {
                this.atK.dispatch();
                if (this.atK.atC > 0 && !this.atK.atI) {
                    this.atK.handler.sendMessageDelayed(this.atK.handler.obtainMessage(1, cy.yT), (long) this.atK.atC);
                }
            }
            return true;
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cy$3 */
    class C06343 implements Runnable {
        final /* synthetic */ cy atK;

        C06343(cy cyVar) {
            this.atK = cyVar;
        }

        public void run() {
            this.atK.atA.dispatch();
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cy$1 */
    class C12221 implements au {
        final /* synthetic */ cy atK;

        C12221(cy cyVar) {
            this.atK = cyVar;
        }

        /* renamed from: B */
        public void mo2559B(boolean z) {
            this.atK.m3744a(z, this.atK.connected);
        }
    }

    private cy() {
    }

    private void ev() {
        this.atH = new bo(this);
        this.atH.m2127z(this.atz);
    }

    private void ew() {
        this.handler = new Handler(this.atz.getMainLooper(), new C06332(this));
        if (this.atC > 0) {
            this.handler.sendMessageDelayed(this.handler.obtainMessage(1, yT), (long) this.atC);
        }
    }

    public static cy qN() {
        if (atJ == null) {
            atJ = new cy();
        }
        return atJ;
    }

    /* renamed from: C */
    synchronized void mo2560C(boolean z) {
        m3744a(this.atI, z);
    }

    /* renamed from: a */
    synchronized void m3743a(Context context, ar arVar) {
        if (this.atz == null) {
            this.atz = context.getApplicationContext();
            if (this.atB == null) {
                this.atB = arVar;
            }
        }
    }

    /* renamed from: a */
    synchronized void m3744a(boolean z, boolean z2) {
        if (!(this.atI == z && this.connected == z2)) {
            if (z || !z2) {
                if (this.atC > 0) {
                    this.handler.removeMessages(1, yT);
                }
            }
            if (!z && z2 && this.atC > 0) {
                this.handler.sendMessageDelayed(this.handler.obtainMessage(1, yT), (long) this.atC);
            }
            StringBuilder append = new StringBuilder().append("PowerSaveMode ");
            String str = (z || !z2) ? "initiated." : "terminated.";
            bh.m2116V(append.append(str).toString());
            this.atI = z;
            this.connected = z2;
        }
    }

    public synchronized void dispatch() {
        if (this.atE) {
            this.atB.mo2515b(new C06343(this));
        } else {
            bh.m2116V("Dispatch call queued. Dispatch will run once initialization is complete.");
            this.atD = true;
        }
    }

    synchronized void ey() {
        if (!this.atI && this.connected && this.atC > 0) {
            this.handler.removeMessages(1, yT);
            this.handler.sendMessage(this.handler.obtainMessage(1, yT));
        }
    }

    synchronized at qO() {
        if (this.atA == null) {
            if (this.atz == null) {
                throw new IllegalStateException("Cant get a store unless we have a context");
            }
            this.atA = new cb(this.atG, this.atz);
        }
        if (this.handler == null) {
            ew();
        }
        this.atE = true;
        if (this.atD) {
            dispatch();
            this.atD = false;
        }
        if (this.atH == null && this.atF) {
            ev();
        }
        return this.atA;
    }
}
