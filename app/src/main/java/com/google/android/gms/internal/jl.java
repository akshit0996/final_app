package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.Api.C0152a;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.jm.C0479b;
import com.google.android.gms.internal.js.C1006a;
import com.google.android.gms.internal.jt.C1008a;
import java.util.ArrayList;

public abstract class jl<T extends IInterface> implements C0152a, C0479b {
    public static final String[] MP = new String[]{"service_esmobile", "service_googleme"};
    private final Looper JF;
    private final jm JS;
    private T MJ;
    private final ArrayList<C0476b<?>> MK;
    private C0477f ML;
    private int MM;
    private final String[] MN;
    boolean MO;
    private final Context mContext;
    private final Object mH;
    final Handler mHandler;

    /* renamed from: com.google.android.gms.internal.jl$a */
    final class C0475a extends Handler {
        final /* synthetic */ jl MQ;

        public C0475a(jl jlVar, Looper looper) {
            this.MQ = jlVar;
            super(looper);
        }

        public void handleMessage(Message msg) {
            C0476b c0476b;
            if (msg.what == 1 && !this.MQ.isConnecting()) {
                c0476b = (C0476b) msg.obj;
                c0476b.hx();
                c0476b.unregister();
            } else if (msg.what == 3) {
                this.MQ.JS.m1503b(new ConnectionResult(((Integer) msg.obj).intValue(), null));
            } else if (msg.what == 4) {
                this.MQ.m3301a(4, null);
                this.MQ.JS.aE(((Integer) msg.obj).intValue());
                this.MQ.m3303a(4, 1, null);
            } else if (msg.what == 2 && !this.MQ.isConnected()) {
                c0476b = (C0476b) msg.obj;
                c0476b.hx();
                c0476b.unregister();
            } else if (msg.what == 2 || msg.what == 1) {
                ((C0476b) msg.obj).hy();
            } else {
                Log.wtf("GmsClient", "Don't know how to handle this message.");
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.jl$b */
    protected abstract class C0476b<TListener> {
        final /* synthetic */ jl MQ;
        private boolean MR = false;
        private TListener mListener;

        public C0476b(jl jlVar, TListener tListener) {
            this.MQ = jlVar;
            this.mListener = tListener;
        }

        /* renamed from: g */
        protected abstract void mo1853g(TListener tListener);

        protected abstract void hx();

        public void hy() {
            synchronized (this) {
                Object obj = this.mListener;
                if (this.MR) {
                    Log.w("GmsClient", "Callback proxy " + this + " being reused. This is not safe.");
                }
            }
            if (obj != null) {
                try {
                    mo1853g(obj);
                } catch (RuntimeException e) {
                    hx();
                    throw e;
                }
            }
            hx();
            synchronized (this) {
                this.MR = true;
            }
            unregister();
        }

        public void hz() {
            synchronized (this) {
                this.mListener = null;
            }
        }

        public void unregister() {
            hz();
            synchronized (this.MQ.MK) {
                this.MQ.MK.remove(this);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.jl$f */
    public final class C0477f implements ServiceConnection {
        final /* synthetic */ jl MQ;

        public C0477f(jl jlVar) {
            this.MQ = jlVar;
        }

        public void onServiceConnected(ComponentName component, IBinder binder) {
            this.MQ.m3308N(binder);
        }

        public void onServiceDisconnected(ComponentName component) {
            this.MQ.mHandler.sendMessage(this.MQ.mHandler.obtainMessage(4, Integer.valueOf(1)));
        }
    }

    /* renamed from: com.google.android.gms.internal.jl$c */
    public static final class C0999c implements ConnectionCallbacks {
        private final GooglePlayServicesClient.ConnectionCallbacks MS;

        public C0999c(GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks) {
            this.MS = connectionCallbacks;
        }

        public boolean equals(Object other) {
            return other instanceof C0999c ? this.MS.equals(((C0999c) other).MS) : this.MS.equals(other);
        }

        public void onConnected(Bundle connectionHint) {
            this.MS.onConnected(connectionHint);
        }

        public void onConnectionSuspended(int cause) {
            this.MS.onDisconnected();
        }
    }

    /* renamed from: com.google.android.gms.internal.jl$d */
    public abstract class C1000d<TListener> extends C0476b<TListener> {
        private final DataHolder JG;
        final /* synthetic */ jl MQ;

        public C1000d(jl jlVar, TListener tListener, DataHolder dataHolder) {
            this.MQ = jlVar;
            super(jlVar, tListener);
            this.JG = dataHolder;
        }

        /* renamed from: b */
        protected abstract void mo3605b(TListener tListener, DataHolder dataHolder);

        /* renamed from: g */
        protected final void mo1853g(TListener tListener) {
            mo3605b(tListener, this.JG);
        }

        protected void hx() {
            if (this.JG != null) {
                this.JG.close();
            }
        }

        public /* bridge */ /* synthetic */ void hy() {
            super.hy();
        }

        public /* bridge */ /* synthetic */ void hz() {
            super.hz();
        }

        public /* bridge */ /* synthetic */ void unregister() {
            super.unregister();
        }
    }

    /* renamed from: com.google.android.gms.internal.jl$h */
    protected final class C1001h extends C0476b<Boolean> {
        final /* synthetic */ jl MQ;
        public final Bundle MV;
        public final IBinder MW;
        public final int statusCode;

        public C1001h(jl jlVar, int i, IBinder iBinder, Bundle bundle) {
            this.MQ = jlVar;
            super(jlVar, Boolean.valueOf(true));
            this.statusCode = i;
            this.MW = iBinder;
            this.MV = bundle;
        }

        /* renamed from: b */
        protected void m3297b(Boolean bool) {
            if (bool == null) {
                this.MQ.m3301a(1, null);
                return;
            }
            switch (this.statusCode) {
                case 0:
                    try {
                        if (this.MQ.bL().equals(this.MW.getInterfaceDescriptor())) {
                            IInterface l = this.MQ.mo2972l(this.MW);
                            if (l != null) {
                                this.MQ.m3301a(3, l);
                                this.MQ.JS.dU();
                                return;
                            }
                        }
                    } catch (RemoteException e) {
                    }
                    jn.m1512J(this.MQ.mContext).m1516b(this.MQ.bK(), this.MQ.ML);
                    this.MQ.ML = null;
                    this.MQ.m3301a(1, null);
                    this.MQ.JS.m1503b(new ConnectionResult(8, null));
                    return;
                case 10:
                    this.MQ.m3301a(1, null);
                    throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
                default:
                    PendingIntent pendingIntent = this.MV != null ? (PendingIntent) this.MV.getParcelable("pendingIntent") : null;
                    if (this.MQ.ML != null) {
                        jn.m1512J(this.MQ.mContext).m1516b(this.MQ.bK(), this.MQ.ML);
                        this.MQ.ML = null;
                    }
                    this.MQ.m3301a(1, null);
                    this.MQ.JS.m1503b(new ConnectionResult(this.statusCode, pendingIntent));
                    return;
            }
        }

        /* renamed from: g */
        protected /* synthetic */ void mo1853g(Object obj) {
            m3297b((Boolean) obj);
        }

        protected void hx() {
        }
    }

    /* renamed from: com.google.android.gms.internal.jl$e */
    public static final class C1399e extends C1006a {
        private jl MT;

        public C1399e(jl jlVar) {
            this.MT = jlVar;
        }

        /* renamed from: b */
        public void mo1861b(int i, IBinder iBinder, Bundle bundle) {
            jx.m1578b((Object) "onPostInitComplete can be called only once per call to getServiceFromBroker", this.MT);
            this.MT.mo2968a(i, iBinder, bundle);
            this.MT = null;
        }
    }

    /* renamed from: com.google.android.gms.internal.jl$g */
    public static final class C1400g implements OnConnectionFailedListener {
        private final GooglePlayServicesClient.OnConnectionFailedListener MU;

        public C1400g(GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener) {
            this.MU = onConnectionFailedListener;
        }

        public boolean equals(Object other) {
            return other instanceof C1400g ? this.MU.equals(((C1400g) other).MU) : this.MU.equals(other);
        }

        public void onConnectionFailed(ConnectionResult result) {
            this.MU.onConnectionFailed(result);
        }
    }

    protected jl(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String... strArr) {
        this.mH = new Object();
        this.MK = new ArrayList();
        this.MM = 1;
        this.MO = false;
        this.mContext = (Context) jx.m1582i(context);
        this.JF = (Looper) jx.m1578b((Object) looper, (Object) "Looper must not be null");
        this.JS = new jm(context, looper, this);
        this.mHandler = new C0475a(this, looper);
        mo3132c(strArr);
        this.MN = strArr;
        registerConnectionCallbacks((ConnectionCallbacks) jx.m1582i(connectionCallbacks));
        registerConnectionFailedListener((OnConnectionFailedListener) jx.m1582i(onConnectionFailedListener));
    }

    @Deprecated
    protected jl(Context context, GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener, String... strArr) {
        this(context, context.getMainLooper(), new C0999c(connectionCallbacks), new C1400g(onConnectionFailedListener), strArr);
    }

    /* renamed from: a */
    private void m3301a(int i, T t) {
        boolean z = true;
        if ((i == 3) != (t != null)) {
            z = false;
        }
        jx.m1575L(z);
        synchronized (this.mH) {
            this.MM = i;
            this.MJ = t;
        }
    }

    /* renamed from: a */
    private boolean m3303a(int i, int i2, T t) {
        boolean z;
        synchronized (this.mH) {
            if (this.MM != i) {
                z = false;
            } else {
                m3301a(i2, (IInterface) t);
                z = true;
            }
        }
        return z;
    }

    /* renamed from: N */
    protected final void m3308N(IBinder iBinder) {
        try {
            mo2969a(C1008a.m3360Q(iBinder), new C1399e(this));
        } catch (DeadObjectException e) {
            Log.w("GmsClient", "service died");
            aD(1);
        } catch (Throwable e2) {
            Log.w("GmsClient", "Remote exception occurred", e2);
        }
    }

    /* renamed from: a */
    protected void mo2968a(int i, IBinder iBinder, Bundle bundle) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1, new C1001h(this, i, iBinder, bundle)));
    }

    @Deprecated
    /* renamed from: a */
    public final void m3310a(C0476b<?> c0476b) {
        synchronized (this.MK) {
            this.MK.add(c0476b);
        }
        this.mHandler.sendMessage(this.mHandler.obtainMessage(2, c0476b));
    }

    /* renamed from: a */
    protected abstract void mo2969a(jt jtVar, C1399e c1399e) throws RemoteException;

    public void aD(int i) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4, Integer.valueOf(i)));
    }

    protected abstract String bK();

    protected abstract String bL();

    /* renamed from: c */
    protected void mo3132c(String... strArr) {
    }

    public void connect() {
        this.MO = true;
        m3301a(2, null);
        int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.mContext);
        if (isGooglePlayServicesAvailable != 0) {
            m3301a(1, null);
            this.mHandler.sendMessage(this.mHandler.obtainMessage(3, Integer.valueOf(isGooglePlayServicesAvailable)));
            return;
        }
        if (this.ML != null) {
            Log.e("GmsClient", "Calling connect() while still connected, missing disconnect() for " + bK());
            jn.m1512J(this.mContext).m1516b(bK(), this.ML);
        }
        this.ML = new C0477f(this);
        if (!jn.m1512J(this.mContext).m1515a(bK(), this.ML)) {
            Log.e("GmsClient", "unable to connect to service: " + bK());
            this.mHandler.sendMessage(this.mHandler.obtainMessage(3, Integer.valueOf(9)));
        }
    }

    protected final void dS() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public void disconnect() {
        this.MO = false;
        synchronized (this.MK) {
            int size = this.MK.size();
            for (int i = 0; i < size; i++) {
                ((C0476b) this.MK.get(i)).hz();
            }
            this.MK.clear();
        }
        m3301a(1, null);
        if (this.ML != null) {
            jn.m1512J(this.mContext).m1516b(bK(), this.ML);
            this.ML = null;
        }
    }

    public Bundle fX() {
        return null;
    }

    public boolean gN() {
        return this.MO;
    }

    public final Context getContext() {
        return this.mContext;
    }

    public final Looper getLooper() {
        return this.JF;
    }

    public final String[] hv() {
        return this.MN;
    }

    public final T hw() throws DeadObjectException {
        T t;
        synchronized (this.mH) {
            if (this.MM == 4) {
                throw new DeadObjectException();
            }
            dS();
            jx.m1576a(this.MJ != null, "Client is connected but service is null");
            t = this.MJ;
        }
        return t;
    }

    public boolean isConnected() {
        boolean z;
        synchronized (this.mH) {
            z = this.MM == 3;
        }
        return z;
    }

    public boolean isConnecting() {
        boolean z;
        synchronized (this.mH) {
            z = this.MM == 2;
        }
        return z;
    }

    @Deprecated
    public boolean isConnectionCallbacksRegistered(GooglePlayServicesClient.ConnectionCallbacks listener) {
        return this.JS.isConnectionCallbacksRegistered(new C0999c(listener));
    }

    @Deprecated
    public boolean isConnectionFailedListenerRegistered(GooglePlayServicesClient.OnConnectionFailedListener listener) {
        return this.JS.isConnectionFailedListenerRegistered(listener);
    }

    /* renamed from: l */
    protected abstract T mo2972l(IBinder iBinder);

    @Deprecated
    public void registerConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks listener) {
        this.JS.registerConnectionCallbacks(new C0999c(listener));
    }

    public void registerConnectionCallbacks(ConnectionCallbacks listener) {
        this.JS.registerConnectionCallbacks(listener);
    }

    @Deprecated
    public void registerConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener listener) {
        this.JS.registerConnectionFailedListener(listener);
    }

    public void registerConnectionFailedListener(OnConnectionFailedListener listener) {
        this.JS.registerConnectionFailedListener(listener);
    }

    @Deprecated
    public void unregisterConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks listener) {
        this.JS.unregisterConnectionCallbacks(new C0999c(listener));
    }

    @Deprecated
    public void unregisterConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener listener) {
        this.JS.unregisterConnectionFailedListener(listener);
    }
}
