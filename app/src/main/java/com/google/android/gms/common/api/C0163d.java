package com.google.android.gms.common.api;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.internal.jx;

/* renamed from: com.google.android.gms.common.api.d */
public final class C0163d<L> {
    private final C0161a Kt;
    private volatile L mListener;

    /* renamed from: com.google.android.gms.common.api.d$a */
    private final class C0161a extends Handler {
        final /* synthetic */ C0163d Ku;

        public C0161a(C0163d c0163d, Looper looper) {
            this.Ku = c0163d;
            super(looper);
        }

        public void handleMessage(Message msg) {
            boolean z = true;
            if (msg.what != 1) {
                z = false;
            }
            jx.m1575L(z);
            this.Ku.m162b((C0162b) msg.obj);
        }
    }

    /* renamed from: com.google.android.gms.common.api.d$b */
    public interface C0162b<L> {
        /* renamed from: c */
        void mo916c(L l);

        void gG();
    }

    C0163d(Looper looper, L l) {
        this.Kt = new C0161a(this, looper);
        this.mListener = jx.m1578b((Object) l, (Object) "Listener must not be null");
    }

    /* renamed from: a */
    public void m161a(C0162b<? super L> c0162b) {
        jx.m1578b((Object) c0162b, (Object) "Notifier must not be null");
        this.Kt.sendMessage(this.Kt.obtainMessage(1, c0162b));
    }

    /* renamed from: b */
    void m162b(C0162b<? super L> c0162b) {
        Object obj = this.mListener;
        if (obj == null) {
            c0162b.gG();
            return;
        }
        try {
            c0162b.mo916c(obj);
        } catch (Throwable e) {
            Log.w("ListenerHolder", "Notifying listener failed", e);
            c0162b.gG();
        }
    }

    public void clear() {
        this.mListener = null;
    }
}
