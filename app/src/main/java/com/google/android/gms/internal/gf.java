package com.google.android.gms.internal;

@ey
public abstract class gf {
    private final Runnable mv = new C04351(this);
    private volatile Thread wu;

    /* renamed from: com.google.android.gms.internal.gf$1 */
    class C04351 implements Runnable {
        final /* synthetic */ gf wv;

        C04351(gf gfVar) {
            this.wv = gfVar;
        }

        public final void run() {
            this.wv.wu = Thread.currentThread();
            this.wv.cx();
        }
    }

    public final void cancel() {
        onStop();
        if (this.wu != null) {
            this.wu.interrupt();
        }
    }

    public abstract void cx();

    public abstract void onStop();

    public final void start() {
        gh.m1283a(this.mv);
    }
}
