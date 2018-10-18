package com.google.android.gms.common.api;

import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.Api.C0152a;
import com.google.android.gms.common.api.Api.C0154c;
import com.google.android.gms.common.api.C0807c.C0158b;
import com.google.android.gms.common.api.C0807c.C0160d;
import com.google.android.gms.common.api.PendingResult.C0156a;
import com.google.android.gms.internal.jr;
import com.google.android.gms.internal.jx;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class BaseImplementation {

    public static class CallbackHandler<R extends Result> extends Handler {
        public static final int CALLBACK_ON_COMPLETE = 1;
        public static final int CALLBACK_ON_TIMEOUT = 2;

        public CallbackHandler() {
            this(Looper.getMainLooper());
        }

        public CallbackHandler(Looper looper) {
            super(looper);
        }

        protected void deliverResultCallback(ResultCallback<R> callback, R result) {
            try {
                callback.onResult(result);
            } catch (RuntimeException e) {
                BaseImplementation.m147a(result);
                throw e;
            }
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    Pair pair = (Pair) msg.obj;
                    deliverResultCallback((ResultCallback) pair.first, (Result) pair.second);
                    return;
                case 2:
                    ((AbstractPendingResult) msg.obj).gD();
                    return;
                default:
                    Log.wtf("GoogleApi", "Don't know how to handle this message.");
                    return;
            }
        }

        public void removeTimeoutMessages() {
            removeMessages(2);
        }

        public void sendResultCallback(ResultCallback<R> callback, R result) {
            sendMessage(obtainMessage(1, new Pair(callback, result)));
        }

        public void sendTimeoutResultCallback(AbstractPendingResult<R> pendingResult, long millis) {
            sendMessageDelayed(obtainMessage(2, pendingResult), millis);
        }
    }

    /* renamed from: com.google.android.gms.common.api.BaseImplementation$b */
    public interface C0155b<R> {
        /* renamed from: b */
        void mo908b(R r);
    }

    public static abstract class AbstractPendingResult<R extends Result> implements C0155b<R>, PendingResult<R> {
        private final Object Jp = new Object();
        private final ArrayList<C0156a> Jq = new ArrayList();
        private ResultCallback<R> Jr;
        private volatile R Js;
        private volatile boolean Jt;
        private boolean Ju;
        private boolean Jv;
        private jr Jw;
        protected final CallbackHandler<R> mHandler;
        private final CountDownLatch mr = new CountDownLatch(1);

        protected AbstractPendingResult(Looper looper) {
            this.mHandler = new CallbackHandler(looper);
        }

        protected AbstractPendingResult(CallbackHandler<R> callbackHandler) {
            this.mHandler = callbackHandler;
        }

        /* renamed from: c */
        private void m2444c(R r) {
            this.Js = r;
            this.Jw = null;
            this.mr.countDown();
            Status status = this.Js.getStatus();
            if (this.Jr != null) {
                this.mHandler.removeTimeoutMessages();
                if (!this.Ju) {
                    this.mHandler.sendResultCallback(this.Jr, gA());
                }
            }
            Iterator it = this.Jq.iterator();
            while (it.hasNext()) {
                ((C0156a) it.next()).mo913m(status);
            }
            this.Jq.clear();
        }

        private R gA() {
            R r;
            synchronized (this.Jp) {
                jx.m1576a(!this.Jt, "Result has already been consumed.");
                jx.m1576a(isReady(), "Result is not ready.");
                r = this.Js;
                gB();
            }
            return r;
        }

        private void gC() {
            synchronized (this.Jp) {
                if (!isReady()) {
                    m2447b(mo2958c(Status.Kx));
                    this.Jv = true;
                }
            }
        }

        private void gD() {
            synchronized (this.Jp) {
                if (!isReady()) {
                    m2447b(mo2958c(Status.Kz));
                    this.Jv = true;
                }
            }
        }

        /* renamed from: a */
        public final void mo905a(C0156a c0156a) {
            jx.m1576a(!this.Jt, "Result has already been consumed.");
            synchronized (this.Jp) {
                if (isReady()) {
                    c0156a.mo913m(this.Js.getStatus());
                } else {
                    this.Jq.add(c0156a);
                }
            }
        }

        /* renamed from: a */
        protected final void m2446a(jr jrVar) {
            synchronized (this.Jp) {
                this.Jw = jrVar;
            }
        }

        public final R await() {
            boolean z = true;
            jx.m1576a(Looper.myLooper() != Looper.getMainLooper(), "await must not be called on the UI thread");
            if (this.Jt) {
                z = false;
            }
            jx.m1576a(z, "Result has already been consumed");
            try {
                this.mr.await();
            } catch (InterruptedException e) {
                gC();
            }
            jx.m1576a(isReady(), "Result is not ready.");
            return gA();
        }

        public final R await(long time, TimeUnit units) {
            boolean z = true;
            boolean z2 = time <= 0 || Looper.myLooper() != Looper.getMainLooper();
            jx.m1576a(z2, "await must not be called on the UI thread when time is greater than zero.");
            if (this.Jt) {
                z = false;
            }
            jx.m1576a(z, "Result has already been consumed.");
            try {
                if (!this.mr.await(time, units)) {
                    gD();
                }
            } catch (InterruptedException e) {
                gC();
            }
            jx.m1576a(isReady(), "Result is not ready.");
            return gA();
        }

        /* renamed from: b */
        public final void m2447b(R r) {
            boolean z = true;
            synchronized (this.Jp) {
                if (this.Jv || this.Ju) {
                    BaseImplementation.m147a(r);
                    return;
                }
                jx.m1576a(!isReady(), "Results have already been set");
                if (this.Jt) {
                    z = false;
                }
                jx.m1576a(z, "Result has already been consumed");
                m2444c((Result) r);
            }
        }

        /* renamed from: c */
        protected abstract R mo2958c(Status status);

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void cancel() {
            /*
            r2 = this;
            r1 = r2.Jp;
            monitor-enter(r1);
            r0 = r2.Ju;	 Catch:{ all -> 0x002c }
            if (r0 != 0) goto L_0x000b;
        L_0x0007:
            r0 = r2.Jt;	 Catch:{ all -> 0x002c }
            if (r0 == 0) goto L_0x000d;
        L_0x000b:
            monitor-exit(r1);	 Catch:{ all -> 0x002c }
        L_0x000c:
            return;
        L_0x000d:
            r0 = r2.Jw;	 Catch:{ all -> 0x002c }
            if (r0 == 0) goto L_0x0016;
        L_0x0011:
            r0 = r2.Jw;	 Catch:{ RemoteException -> 0x002f }
            r0.cancel();	 Catch:{ RemoteException -> 0x002f }
        L_0x0016:
            r0 = r2.Js;	 Catch:{ all -> 0x002c }
            com.google.android.gms.common.api.BaseImplementation.m147a(r0);	 Catch:{ all -> 0x002c }
            r0 = 0;
            r2.Jr = r0;	 Catch:{ all -> 0x002c }
            r0 = 1;
            r2.Ju = r0;	 Catch:{ all -> 0x002c }
            r0 = com.google.android.gms.common.api.Status.KA;	 Catch:{ all -> 0x002c }
            r0 = r2.mo2958c(r0);	 Catch:{ all -> 0x002c }
            r2.m2444c(r0);	 Catch:{ all -> 0x002c }
            monitor-exit(r1);	 Catch:{ all -> 0x002c }
            goto L_0x000c;
        L_0x002c:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x002c }
            throw r0;
        L_0x002f:
            r0 = move-exception;
            goto L_0x0016;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.BaseImplementation.AbstractPendingResult.cancel():void");
        }

        protected void gB() {
            this.Jt = true;
            this.Js = null;
            this.Jr = null;
        }

        public boolean isCanceled() {
            boolean z;
            synchronized (this.Jp) {
                z = this.Ju;
            }
            return z;
        }

        public final boolean isReady() {
            return this.mr.getCount() == 0;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void setResultCallback(com.google.android.gms.common.api.ResultCallback<R> r4) {
            /*
            r3 = this;
            r0 = r3.Jt;
            if (r0 != 0) goto L_0x0015;
        L_0x0004:
            r0 = 1;
        L_0x0005:
            r1 = "Result has already been consumed.";
            com.google.android.gms.internal.jx.m1576a(r0, r1);
            r1 = r3.Jp;
            monitor-enter(r1);
            r0 = r3.isCanceled();	 Catch:{ all -> 0x0028 }
            if (r0 == 0) goto L_0x0017;
        L_0x0013:
            monitor-exit(r1);	 Catch:{ all -> 0x0028 }
        L_0x0014:
            return;
        L_0x0015:
            r0 = 0;
            goto L_0x0005;
        L_0x0017:
            r0 = r3.isReady();	 Catch:{ all -> 0x0028 }
            if (r0 == 0) goto L_0x002b;
        L_0x001d:
            r0 = r3.mHandler;	 Catch:{ all -> 0x0028 }
            r2 = r3.gA();	 Catch:{ all -> 0x0028 }
            r0.sendResultCallback(r4, r2);	 Catch:{ all -> 0x0028 }
        L_0x0026:
            monitor-exit(r1);	 Catch:{ all -> 0x0028 }
            goto L_0x0014;
        L_0x0028:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0028 }
            throw r0;
        L_0x002b:
            r3.Jr = r4;	 Catch:{ all -> 0x0028 }
            goto L_0x0026;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.BaseImplementation.AbstractPendingResult.setResultCallback(com.google.android.gms.common.api.ResultCallback):void");
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void setResultCallback(com.google.android.gms.common.api.ResultCallback<R> r5, long r6, java.util.concurrent.TimeUnit r8) {
            /*
            r4 = this;
            r1 = 1;
            r2 = 0;
            r0 = r4.Jt;
            if (r0 != 0) goto L_0x0020;
        L_0x0006:
            r0 = r1;
        L_0x0007:
            r3 = "Result has already been consumed.";
            com.google.android.gms.internal.jx.m1576a(r0, r3);
            r0 = r4.mHandler;
            if (r0 == 0) goto L_0x0022;
        L_0x0010:
            r0 = "CallbackHandler has not been set before calling setResultCallback.";
            com.google.android.gms.internal.jx.m1576a(r1, r0);
            r1 = r4.Jp;
            monitor-enter(r1);
            r0 = r4.isCanceled();	 Catch:{ all -> 0x0035 }
            if (r0 == 0) goto L_0x0024;
        L_0x001e:
            monitor-exit(r1);	 Catch:{ all -> 0x0035 }
        L_0x001f:
            return;
        L_0x0020:
            r0 = r2;
            goto L_0x0007;
        L_0x0022:
            r1 = r2;
            goto L_0x0010;
        L_0x0024:
            r0 = r4.isReady();	 Catch:{ all -> 0x0035 }
            if (r0 == 0) goto L_0x0038;
        L_0x002a:
            r0 = r4.mHandler;	 Catch:{ all -> 0x0035 }
            r2 = r4.gA();	 Catch:{ all -> 0x0035 }
            r0.sendResultCallback(r5, r2);	 Catch:{ all -> 0x0035 }
        L_0x0033:
            monitor-exit(r1);	 Catch:{ all -> 0x0035 }
            goto L_0x001f;
        L_0x0035:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0035 }
            throw r0;
        L_0x0038:
            r4.Jr = r5;	 Catch:{ all -> 0x0035 }
            r0 = r4.mHandler;	 Catch:{ all -> 0x0035 }
            r2 = r8.toMillis(r6);	 Catch:{ all -> 0x0035 }
            r0.sendTimeoutResultCallback(r4, r2);	 Catch:{ all -> 0x0035 }
            goto L_0x0033;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.BaseImplementation.AbstractPendingResult.setResultCallback(com.google.android.gms.common.api.ResultCallback, long, java.util.concurrent.TimeUnit):void");
        }
    }

    /* renamed from: com.google.android.gms.common.api.BaseImplementation$a */
    public static abstract class C1301a<R extends Result, A extends C0152a> extends AbstractPendingResult<R> implements C0160d<A> {
        private final C0154c<A> Jn;
        private final GoogleApiClient Jx;
        private C0158b Jy;

        protected C1301a(C0154c<A> c0154c, GoogleApiClient googleApiClient) {
            super(googleApiClient.getLooper());
            this.Jn = (C0154c) jx.m1582i(c0154c);
            this.Jx = googleApiClient;
        }

        /* renamed from: a */
        private void m3918a(RemoteException remoteException) {
            mo2957l(new Status(8, remoteException.getLocalizedMessage(), null));
        }

        /* renamed from: a */
        protected abstract void mo3691a(A a) throws RemoteException;

        /* renamed from: a */
        public void mo2952a(C0158b c0158b) {
            this.Jy = c0158b;
        }

        /* renamed from: b */
        public final void mo2953b(A a) throws DeadObjectException {
            try {
                mo3691a((C0152a) a);
            } catch (RemoteException e) {
                m3918a(e);
                throw e;
            } catch (RemoteException e2) {
                m3918a(e2);
            }
        }

        protected void gB() {
            super.gB();
            if (this.Jy != null) {
                this.Jy.mo919b(this);
                this.Jy = null;
            }
        }

        public final C1301a gE() {
            jx.m1578b(this.Jx, (Object) "GoogleApiClient was not set.");
            this.Jx.mo928b(this);
            return this;
        }

        public int gF() {
            return 0;
        }

        public final C0154c<A> gz() {
            return this.Jn;
        }

        /* renamed from: l */
        public final void mo2957l(Status status) {
            jx.m1580b(!status.isSuccess(), (Object) "Failed result must not be success");
            m2447b(mo2958c(status));
        }
    }

    /* renamed from: a */
    static void m147a(Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).release();
            } catch (Throwable e) {
                Log.w("GoogleApi", "Unable to release " + result, e);
            }
        }
    }
}
