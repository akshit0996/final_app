package com.google.android.gms.internal;

import android.os.Handler;
import java.lang.ref.WeakReference;

@ey
public class ab {
    private final C0363a mu;
    private final Runnable mv;
    private av mw;
    private boolean mx;
    private boolean my;
    private long mz;

    /* renamed from: com.google.android.gms.internal.ab$a */
    public static class C0363a {
        private final Handler mHandler;

        public C0363a(Handler handler) {
            this.mHandler = handler;
        }

        public boolean postDelayed(Runnable runnable, long timeFromNowInMillis) {
            return this.mHandler.postDelayed(runnable, timeFromNowInMillis);
        }

        public void removeCallbacks(Runnable runnable) {
            this.mHandler.removeCallbacks(runnable);
        }
    }

    public ab(C1440u c1440u) {
        this(c1440u, new C0363a(gq.wR));
    }

    ab(final C1440u c1440u, C0363a c0363a) {
        this.mx = false;
        this.my = false;
        this.mz = 0;
        this.mu = c0363a;
        this.mv = new Runnable(this) {
            private final WeakReference<C1440u> mA = new WeakReference(c1440u);
            final /* synthetic */ ab mC;

            public void run() {
                this.mC.mx = false;
                C1440u c1440u = (C1440u) this.mA.get();
                if (c1440u != null) {
                    c1440u.m4614b(this.mC.mw);
                }
            }
        };
    }

    /* renamed from: a */
    public void m978a(av avVar, long j) {
        if (this.mx) {
            gr.m1341W("An ad refresh is already scheduled.");
            return;
        }
        this.mw = avVar;
        this.mx = true;
        this.mz = j;
        if (!this.my) {
            gr.m1339U("Scheduling ad refresh " + j + " milliseconds from now.");
            this.mu.postDelayed(this.mv, j);
        }
    }

    public boolean aD() {
        return this.mx;
    }

    /* renamed from: c */
    public void m979c(av avVar) {
        m978a(avVar, 60000);
    }

    public void cancel() {
        this.mx = false;
        this.mu.removeCallbacks(this.mv);
    }

    public void pause() {
        this.my = true;
        if (this.mx) {
            this.mu.removeCallbacks(this.mv);
        }
    }

    public void resume() {
        this.my = false;
        if (this.mx) {
            this.mx = false;
            m978a(this.mw, this.mz);
        }
    }
}
