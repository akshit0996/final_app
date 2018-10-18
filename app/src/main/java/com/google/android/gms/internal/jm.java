package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import java.util.ArrayList;
import java.util.Iterator;

public final class jm {
    private final C0479b MX;
    private final ArrayList<ConnectionCallbacks> MY = new ArrayList();
    final ArrayList<ConnectionCallbacks> MZ = new ArrayList();
    private boolean Na = false;
    private final ArrayList<OnConnectionFailedListener> Nb = new ArrayList();
    private final Handler mHandler;

    /* renamed from: com.google.android.gms.internal.jm$a */
    final class C0478a extends Handler {
        final /* synthetic */ jm Nc;

        public C0478a(jm jmVar, Looper looper) {
            this.Nc = jmVar;
            super(looper);
        }

        public void handleMessage(Message msg) {
            if (msg.what == 1) {
                synchronized (this.Nc.MY) {
                    if (this.Nc.MX.gN() && this.Nc.MX.isConnected() && this.Nc.MY.contains(msg.obj)) {
                        ((ConnectionCallbacks) msg.obj).onConnected(this.Nc.MX.fX());
                    }
                }
                return;
            }
            Log.wtf("GmsClientEvents", "Don't know how to handle this message.");
        }
    }

    /* renamed from: com.google.android.gms.internal.jm$b */
    public interface C0479b {
        Bundle fX();

        boolean gN();

        boolean isConnected();
    }

    public jm(Context context, Looper looper, C0479b c0479b) {
        this.MX = c0479b;
        this.mHandler = new C0478a(this, looper);
    }

    public void aE(int i) {
        this.mHandler.removeMessages(1);
        synchronized (this.MY) {
            this.Na = true;
            Iterator it = new ArrayList(this.MY).iterator();
            while (it.hasNext()) {
                ConnectionCallbacks connectionCallbacks = (ConnectionCallbacks) it.next();
                if (!this.MX.gN()) {
                    break;
                } else if (this.MY.contains(connectionCallbacks)) {
                    connectionCallbacks.onConnectionSuspended(i);
                }
            }
            this.Na = false;
        }
    }

    /* renamed from: b */
    public void m1503b(ConnectionResult connectionResult) {
        this.mHandler.removeMessages(1);
        synchronized (this.Nb) {
            Iterator it = new ArrayList(this.Nb).iterator();
            while (it.hasNext()) {
                OnConnectionFailedListener onConnectionFailedListener = (OnConnectionFailedListener) it.next();
                if (!this.MX.gN()) {
                    return;
                } else if (this.Nb.contains(onConnectionFailedListener)) {
                    onConnectionFailedListener.onConnectionFailed(connectionResult);
                }
            }
        }
    }

    protected void dU() {
        synchronized (this.MY) {
            m1504f(this.MX.fX());
        }
    }

    /* renamed from: f */
    public void m1504f(Bundle bundle) {
        boolean z = true;
        synchronized (this.MY) {
            jx.m1574K(!this.Na);
            this.mHandler.removeMessages(1);
            this.Na = true;
            if (this.MZ.size() != 0) {
                z = false;
            }
            jx.m1574K(z);
            Iterator it = new ArrayList(this.MY).iterator();
            while (it.hasNext()) {
                ConnectionCallbacks connectionCallbacks = (ConnectionCallbacks) it.next();
                if (!this.MX.gN() || !this.MX.isConnected()) {
                    break;
                } else if (!this.MZ.contains(connectionCallbacks)) {
                    connectionCallbacks.onConnected(bundle);
                }
            }
            this.MZ.clear();
            this.Na = false;
        }
    }

    public boolean isConnectionCallbacksRegistered(ConnectionCallbacks listener) {
        boolean contains;
        jx.m1582i(listener);
        synchronized (this.MY) {
            contains = this.MY.contains(listener);
        }
        return contains;
    }

    public boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener listener) {
        boolean contains;
        jx.m1582i(listener);
        synchronized (this.Nb) {
            contains = this.Nb.contains(listener);
        }
        return contains;
    }

    public void registerConnectionCallbacks(ConnectionCallbacks listener) {
        jx.m1582i(listener);
        synchronized (this.MY) {
            if (this.MY.contains(listener)) {
                Log.w("GmsClientEvents", "registerConnectionCallbacks(): listener " + listener + " is already registered");
            } else {
                this.MY.add(listener);
            }
        }
        if (this.MX.isConnected()) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1, listener));
        }
    }

    public void registerConnectionFailedListener(OnConnectionFailedListener listener) {
        jx.m1582i(listener);
        synchronized (this.Nb) {
            if (this.Nb.contains(listener)) {
                Log.w("GmsClientEvents", "registerConnectionFailedListener(): listener " + listener + " is already registered");
            } else {
                this.Nb.add(listener);
            }
        }
    }

    public void unregisterConnectionCallbacks(ConnectionCallbacks listener) {
        jx.m1582i(listener);
        synchronized (this.MY) {
            if (this.MY != null) {
                if (!this.MY.remove(listener)) {
                    Log.w("GmsClientEvents", "unregisterConnectionCallbacks(): listener " + listener + " not found");
                } else if (this.Na) {
                    this.MZ.add(listener);
                }
            }
        }
    }

    public void unregisterConnectionFailedListener(OnConnectionFailedListener listener) {
        jx.m1582i(listener);
        synchronized (this.Nb) {
            if (!(this.Nb == null || this.Nb.remove(listener))) {
                Log.w("GmsClientEvents", "unregisterConnectionFailedListener(): listener " + listener + " not found");
            }
        }
    }
}
