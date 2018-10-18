package com.google.android.gms.common.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.C0152a;
import com.google.android.gms.common.api.Api.C0153b;
import com.google.android.gms.common.api.Api.C0154c;
import com.google.android.gms.common.api.BaseImplementation.C1301a;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.internal.jg;
import com.google.android.gms.internal.jm;
import com.google.android.gms.internal.jm.C0479b;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.kc;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.google.android.gms.common.api.c */
final class C0807c implements GoogleApiClient {
    private final Looper JF;
    private final Condition JR = this.zO.newCondition();
    private final jm JS;
    private final int JT;
    final Queue<C0160d<?>> JU = new LinkedList();
    private ConnectionResult JV;
    private int JW;
    private volatile int JX = 4;
    private volatile boolean JY;
    private boolean JZ = false;
    private final C0158b Jy = new C08021(this);
    private int Ka;
    private long Kb = 120000;
    private long Kc = 5000;
    final Handler Kd;
    BroadcastReceiver Ke;
    private final Bundle Kf = new Bundle();
    private final Map<C0154c<?>, C0152a> Kg = new HashMap();
    private final List<String> Kh;
    private boolean Ki;
    private final Set<C0163d<?>> Kj = Collections.newSetFromMap(new WeakHashMap());
    final Set<C0160d<?>> Kk = Collections.newSetFromMap(new ConcurrentHashMap());
    private final ConnectionCallbacks Kl = new C08032(this);
    private final C0479b Km = new C08043(this);
    private final Context mContext;
    private final Lock zO = new ReentrantLock();

    /* renamed from: com.google.android.gms.common.api.c$a */
    private static class C0157a extends BroadcastReceiver {
        private WeakReference<C0807c> Ks;

        C0157a(C0807c c0807c) {
            this.Ks = new WeakReference(c0807c);
        }

        public void onReceive(Context context, Intent intent) {
            Uri data = intent.getData();
            String str = null;
            if (data != null) {
                str = data.getSchemeSpecificPart();
            }
            if (str != null && str.equals(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE)) {
                C0807c c0807c = (C0807c) this.Ks.get();
                if (c0807c != null && !c0807c.isConnected() && !c0807c.isConnecting() && c0807c.gL()) {
                    c0807c.connect();
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.common.api.c$b */
    interface C0158b {
        /* renamed from: b */
        void mo919b(C0160d<?> c0160d);
    }

    /* renamed from: com.google.android.gms.common.api.c$c */
    private class C0159c extends Handler {
        final /* synthetic */ C0807c Kn;

        C0159c(C0807c c0807c, Looper looper) {
            this.Kn = c0807c;
            super(looper);
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    this.Kn.gM();
                    return;
                case 2:
                    this.Kn.resume();
                    return;
                default:
                    Log.w("GoogleApiClientImpl", "Unknown message id: " + msg.what);
                    return;
            }
        }
    }

    /* renamed from: com.google.android.gms.common.api.c$d */
    interface C0160d<A extends C0152a> {
        /* renamed from: a */
        void mo2952a(C0158b c0158b);

        /* renamed from: b */
        void mo2953b(A a) throws DeadObjectException;

        void cancel();

        int gF();

        C0154c<A> gz();

        /* renamed from: l */
        void mo2957l(Status status);
    }

    /* renamed from: com.google.android.gms.common.api.c$1 */
    class C08021 implements C0158b {
        final /* synthetic */ C0807c Kn;

        C08021(C0807c c0807c) {
            this.Kn = c0807c;
        }

        /* renamed from: b */
        public void mo919b(C0160d<?> c0160d) {
            this.Kn.Kk.remove(c0160d);
        }
    }

    /* renamed from: com.google.android.gms.common.api.c$2 */
    class C08032 implements ConnectionCallbacks {
        final /* synthetic */ C0807c Kn;

        C08032(C0807c c0807c) {
            this.Kn = c0807c;
        }

        public void onConnected(Bundle connectionHint) {
            this.Kn.zO.lock();
            try {
                if (this.Kn.JX == 1) {
                    if (connectionHint != null) {
                        this.Kn.Kf.putAll(connectionHint);
                    }
                    this.Kn.gJ();
                }
                this.Kn.zO.unlock();
            } catch (Throwable th) {
                this.Kn.zO.unlock();
            }
        }

        public void onConnectionSuspended(int cause) {
            this.Kn.zO.lock();
            switch (cause) {
                case 1:
                    if (!this.Kn.gL()) {
                        this.Kn.JY = true;
                        this.Kn.Ke = new C0157a(this.Kn);
                        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
                        intentFilter.addDataScheme("package");
                        this.Kn.mContext.registerReceiver(this.Kn.Ke, intentFilter);
                        this.Kn.Kd.sendMessageDelayed(this.Kn.Kd.obtainMessage(1), this.Kn.Kb);
                        this.Kn.Kd.sendMessageDelayed(this.Kn.Kd.obtainMessage(2), this.Kn.Kc);
                        this.Kn.al(cause);
                        break;
                    }
                    this.Kn.zO.unlock();
                    return;
                case 2:
                    try {
                        this.Kn.al(cause);
                        this.Kn.connect();
                        break;
                    } catch (Throwable th) {
                        this.Kn.zO.unlock();
                    }
            }
            this.Kn.zO.unlock();
        }
    }

    /* renamed from: com.google.android.gms.common.api.c$3 */
    class C08043 implements C0479b {
        final /* synthetic */ C0807c Kn;

        C08043(C0807c c0807c) {
            this.Kn = c0807c;
        }

        public Bundle fX() {
            return null;
        }

        public boolean gN() {
            return this.Kn.Ki;
        }

        public boolean isConnected() {
            return this.Kn.isConnected();
        }
    }

    public C0807c(Context context, Looper looper, jg jgVar, Map<Api<?>, ApiOptions> map, Set<ConnectionCallbacks> set, Set<OnConnectionFailedListener> set2, int i) {
        this.mContext = context;
        this.JS = new jm(context, looper, this.Km);
        this.JF = looper;
        this.Kd = new C0159c(this, looper);
        this.JT = i;
        for (ConnectionCallbacks registerConnectionCallbacks : set) {
            this.JS.registerConnectionCallbacks(registerConnectionCallbacks);
        }
        for (OnConnectionFailedListener registerConnectionFailedListener : set2) {
            this.JS.registerConnectionFailedListener(registerConnectionFailedListener);
        }
        for (Api api : map.keySet()) {
            final C0153b gx = api.gx();
            Object obj = map.get(api);
            this.Kg.put(api.gz(), C0807c.m2456a(gx, obj, context, looper, jgVar, this.Kl, new OnConnectionFailedListener(this) {
                final /* synthetic */ C0807c Kn;

                public void onConnectionFailed(ConnectionResult result) {
                    this.Kn.zO.lock();
                    try {
                        if (this.Kn.JV == null || gx.getPriority() < this.Kn.JW) {
                            this.Kn.JV = result;
                            this.Kn.JW = gx.getPriority();
                        }
                        this.Kn.gJ();
                    } finally {
                        this.Kn.zO.unlock();
                    }
                }
            }));
        }
        this.Kh = Collections.unmodifiableList(jgVar.ho());
    }

    /* renamed from: a */
    private static <C extends C0152a, O> C m2456a(C0153b<C, O> c0153b, Object obj, Context context, Looper looper, jg jgVar, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        return c0153b.mo878a(context, looper, jgVar, obj, connectionCallbacks, onConnectionFailedListener);
    }

    /* renamed from: a */
    private void m2458a(final GoogleApiClient googleApiClient, final C1304f c1304f, final boolean z) {
        kc.Nu.mo1906c(googleApiClient).setResultCallback(new ResultCallback<Status>(this) {
            final /* synthetic */ C0807c Kn;

            /* renamed from: j */
            public void m2454j(Status status) {
                if (status.isSuccess() && this.Kn.isConnected()) {
                    this.Kn.reconnect();
                }
                c1304f.m2447b((Result) status);
                if (z) {
                    googleApiClient.disconnect();
                }
            }

            public /* synthetic */ void onResult(Result x0) {
                m2454j((Status) x0);
            }
        });
    }

    /* renamed from: a */
    private <A extends C0152a> void m2459a(C0160d<A> c0160d) throws DeadObjectException {
        this.zO.lock();
        try {
            jx.m1580b(c0160d.gz() != null, (Object) "This task can not be executed or enqueued (it's probably a Batch or malformed)");
            this.Kk.add(c0160d);
            c0160d.mo2952a(this.Jy);
            if (gL()) {
                c0160d.mo2957l(new Status(8));
                return;
            }
            c0160d.mo2953b(mo925a(c0160d.gz()));
            this.zO.unlock();
        } finally {
            this.zO.unlock();
        }
    }

    private void al(int i) {
        this.zO.lock();
        try {
            if (this.JX != 3) {
                if (i == -1) {
                    Iterator it;
                    C0160d c0160d;
                    if (isConnecting()) {
                        it = this.JU.iterator();
                        while (it.hasNext()) {
                            c0160d = (C0160d) it.next();
                            if (c0160d.gF() != 1) {
                                c0160d.cancel();
                                it.remove();
                            }
                        }
                    } else {
                        this.JU.clear();
                    }
                    for (C0160d c0160d2 : this.Kk) {
                        c0160d2.cancel();
                    }
                    this.Kk.clear();
                    for (C0163d clear : this.Kj) {
                        clear.clear();
                    }
                    this.Kj.clear();
                    if (this.JV == null && !this.JU.isEmpty()) {
                        this.JZ = true;
                        return;
                    }
                }
                boolean isConnecting = isConnecting();
                boolean isConnected = isConnected();
                this.JX = 3;
                if (isConnecting) {
                    if (i == -1) {
                        this.JV = null;
                    }
                    this.JR.signalAll();
                }
                this.Ki = false;
                for (C0152a c0152a : this.Kg.values()) {
                    if (c0152a.isConnected()) {
                        c0152a.disconnect();
                    }
                }
                this.Ki = true;
                this.JX = 4;
                if (isConnected) {
                    if (i != -1) {
                        this.JS.aE(i);
                    }
                    this.Ki = false;
                }
            }
            this.zO.unlock();
        } finally {
            this.zO.unlock();
        }
    }

    private void gJ() {
        this.Ka--;
        if (this.Ka != 0) {
            return;
        }
        if (this.JV != null) {
            this.JZ = false;
            al(3);
            if (!(gL() && GooglePlayServicesUtil.m142e(this.mContext, this.JV.getErrorCode()))) {
                gM();
                this.JS.m1503b(this.JV);
            }
            this.Ki = false;
            return;
        }
        this.JX = 2;
        gM();
        this.JR.signalAll();
        gK();
        if (this.JZ) {
            this.JZ = false;
            al(-1);
            return;
        }
        this.JS.m1504f(this.Kf.isEmpty() ? null : this.Kf);
    }

    private void gK() {
        this.zO.lock();
        try {
            boolean z = isConnected() || gL();
            jx.m1576a(z, "GoogleApiClient is not connected yet.");
            while (!this.JU.isEmpty()) {
                m2459a((C0160d) this.JU.remove());
            }
            this.zO.unlock();
        } catch (Throwable e) {
            Log.w("GoogleApiClientImpl", "Service died while flushing queue", e);
        } catch (Throwable th) {
            this.zO.unlock();
        }
    }

    private void gM() {
        this.zO.lock();
        try {
            if (this.JY) {
                this.JY = false;
                this.Kd.removeMessages(2);
                this.Kd.removeMessages(1);
                this.mContext.unregisterReceiver(this.Ke);
                this.zO.unlock();
            }
        } finally {
            this.zO.unlock();
        }
    }

    private void resume() {
        this.zO.lock();
        try {
            if (gL()) {
                connect();
            }
            this.zO.unlock();
        } catch (Throwable th) {
            this.zO.unlock();
        }
    }

    /* renamed from: a */
    public <C extends C0152a> C mo925a(C0154c<C> c0154c) {
        Object obj = (C0152a) this.Kg.get(c0154c);
        jx.m1578b(obj, (Object) "Appropriate Api was not requested.");
        return obj;
    }

    /* renamed from: a */
    public <A extends C0152a, R extends Result, T extends C1301a<R, A>> T mo926a(T t) {
        this.zO.lock();
        try {
            if (isConnected()) {
                mo928b((C1301a) t);
            } else {
                this.JU.add(t);
            }
            this.zO.unlock();
            return t;
        } catch (Throwable th) {
            this.zO.unlock();
        }
    }

    /* renamed from: a */
    public boolean mo927a(Scope scope) {
        return this.Kh.contains(scope.gO());
    }

    /* renamed from: b */
    public <A extends C0152a, T extends C1301a<? extends Result, A>> T mo928b(T t) {
        boolean z = isConnected() || gL();
        jx.m1576a(z, "GoogleApiClient is not connected yet.");
        gK();
        try {
            m2459a((C0160d) t);
        } catch (DeadObjectException e) {
            al(1);
        }
        return t;
    }

    public ConnectionResult blockingConnect() {
        ConnectionResult connectionResult;
        jx.m1576a(Looper.myLooper() != Looper.getMainLooper(), "blockingConnect must not be called on the UI thread");
        this.zO.lock();
        try {
            connect();
            while (isConnecting()) {
                this.JR.await();
            }
            if (isConnected()) {
                connectionResult = ConnectionResult.Iu;
            } else if (this.JV != null) {
                connectionResult = this.JV;
                this.zO.unlock();
            } else {
                connectionResult = new ConnectionResult(13, null);
                this.zO.unlock();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            connectionResult = new ConnectionResult(15, null);
        } finally {
            this.zO.unlock();
        }
        return connectionResult;
    }

    public ConnectionResult blockingConnect(long timeout, TimeUnit unit) {
        ConnectionResult connectionResult;
        jx.m1576a(Looper.myLooper() != Looper.getMainLooper(), "blockingConnect must not be called on the UI thread");
        this.zO.lock();
        try {
            connect();
            long toNanos = unit.toNanos(timeout);
            while (isConnecting()) {
                toNanos = this.JR.awaitNanos(toNanos);
                if (toNanos <= 0) {
                    connectionResult = new ConnectionResult(14, null);
                    break;
                }
            }
            if (isConnected()) {
                connectionResult = ConnectionResult.Iu;
                this.zO.unlock();
            } else if (this.JV != null) {
                connectionResult = this.JV;
                this.zO.unlock();
            } else {
                connectionResult = new ConnectionResult(13, null);
                this.zO.unlock();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            connectionResult = new ConnectionResult(15, null);
        } finally {
            this.zO.unlock();
        }
        return connectionResult;
    }

    public PendingResult<Status> clearDefaultAccountAndReconnect() {
        jx.m1576a(isConnected(), "GoogleApiClient is not connected yet.");
        final C1304f c1304f = new C1304f(this.JF);
        if (this.Kg.containsKey(kc.DQ)) {
            m2458a(this, c1304f, false);
        } else {
            final AtomicReference atomicReference = new AtomicReference();
            ConnectionCallbacks c08055 = new ConnectionCallbacks(this) {
                final /* synthetic */ C0807c Kn;

                public void onConnected(Bundle connectionHint) {
                    this.Kn.m2458a((GoogleApiClient) atomicReference.get(), c1304f, true);
                }

                public void onConnectionSuspended(int cause) {
                }
            };
            GoogleApiClient build = new Builder(this.mContext).addApi(kc.API).addConnectionCallbacks(c08055).addOnConnectionFailedListener(new OnConnectionFailedListener(this) {
                final /* synthetic */ C0807c Kn;

                public void onConnectionFailed(ConnectionResult result) {
                    c1304f.m2447b(new Status(8));
                }
            }).setHandler(this.Kd).build();
            atomicReference.set(build);
            build.connect();
        }
        return c1304f;
    }

    public void connect() {
        this.zO.lock();
        try {
            this.JZ = false;
            if (isConnected() || isConnecting()) {
                this.zO.unlock();
                return;
            }
            this.Ki = true;
            this.JV = null;
            this.JX = 1;
            this.Kf.clear();
            this.Ka = this.Kg.size();
            for (C0152a connect : this.Kg.values()) {
                connect.connect();
            }
            this.zO.unlock();
        } catch (Throwable th) {
            this.zO.unlock();
        }
    }

    /* renamed from: d */
    public <L> C0163d<L> mo933d(L l) {
        jx.m1578b((Object) l, (Object) "Listener must not be null");
        this.zO.lock();
        try {
            C0163d<L> c0163d = new C0163d(this.JF, l);
            this.Kj.add(c0163d);
            return c0163d;
        } finally {
            this.zO.unlock();
        }
    }

    public void disconnect() {
        gM();
        al(-1);
    }

    boolean gL() {
        return this.JY;
    }

    public Looper getLooper() {
        return this.JF;
    }

    public boolean isConnected() {
        return this.JX == 2;
    }

    public boolean isConnecting() {
        return this.JX == 1;
    }

    public boolean isConnectionCallbacksRegistered(ConnectionCallbacks listener) {
        return this.JS.isConnectionCallbacksRegistered(listener);
    }

    public boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener listener) {
        return this.JS.isConnectionFailedListenerRegistered(listener);
    }

    public void reconnect() {
        disconnect();
        connect();
    }

    public void registerConnectionCallbacks(ConnectionCallbacks listener) {
        this.JS.registerConnectionCallbacks(listener);
    }

    public void registerConnectionFailedListener(OnConnectionFailedListener listener) {
        this.JS.registerConnectionFailedListener(listener);
    }

    public void stopAutoManage(FragmentActivity lifecycleActivity) {
        jx.m1576a(this.JT >= 0, "Called stopAutoManage but automatic lifecycle management is not enabled.");
        C0808g.m2480a(lifecycleActivity).ao(this.JT);
    }

    public void unregisterConnectionCallbacks(ConnectionCallbacks listener) {
        this.JS.unregisterConnectionCallbacks(listener);
    }

    public void unregisterConnectionFailedListener(OnConnectionFailedListener listener) {
        this.JS.unregisterConnectionFailedListener(listener);
    }
}
