package com.google.android.gms.location;

import android.app.PendingIntent;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.internal.nk;

@Deprecated
/* renamed from: com.google.android.gms.location.c */
public class C1086c implements GooglePlayServicesClient {
    private final nk agq;

    /* renamed from: com.google.android.gms.location.c$a */
    public interface C0518a {
        /* renamed from: a */
        void mo1996a(int i, String[] strArr);
    }

    /* renamed from: com.google.android.gms.location.c$b */
    public interface C0519b {
        /* renamed from: a */
        void mo1997a(int i, PendingIntent pendingIntent);

        /* renamed from: b */
        void mo1998b(int i, String[] strArr);
    }

    public void connect() {
        this.agq.connect();
    }

    public void disconnect() {
        this.agq.disconnect();
    }

    public boolean isConnected() {
        return this.agq.isConnected();
    }

    public boolean isConnecting() {
        return this.agq.isConnecting();
    }

    public boolean isConnectionCallbacksRegistered(ConnectionCallbacks listener) {
        return this.agq.isConnectionCallbacksRegistered(listener);
    }

    public boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener listener) {
        return this.agq.isConnectionFailedListenerRegistered(listener);
    }

    public void registerConnectionCallbacks(ConnectionCallbacks listener) {
        this.agq.registerConnectionCallbacks(listener);
    }

    public void registerConnectionFailedListener(OnConnectionFailedListener listener) {
        this.agq.registerConnectionFailedListener(listener);
    }

    public void unregisterConnectionCallbacks(ConnectionCallbacks listener) {
        this.agq.unregisterConnectionCallbacks(listener);
    }

    public void unregisterConnectionFailedListener(OnConnectionFailedListener listener) {
        this.agq.unregisterConnectionFailedListener(listener);
    }
}
