package com.google.android.gms.analytics;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.ha;
import com.google.android.gms.internal.hb;
import com.google.android.gms.internal.hb.C0975a;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.analytics.c */
class C0781c implements C0110b {
    private Context mContext;
    private ServiceConnection xV;
    private C0112b xW;
    private C0113c xX;
    private hb xY;

    /* renamed from: com.google.android.gms.analytics.c$a */
    final class C0111a implements ServiceConnection {
        final /* synthetic */ C0781c xZ;

        C0111a(C0781c c0781c) {
            this.xZ = c0781c;
        }

        public void onServiceConnected(ComponentName component, IBinder binder) {
            ae.m44V("service connected, binder: " + binder);
            try {
                if ("com.google.android.gms.analytics.internal.IAnalyticsService".equals(binder.getInterfaceDescriptor())) {
                    ae.m44V("bound to service");
                    this.xZ.xY = C0975a.m3226D(binder);
                    this.xZ.dT();
                    return;
                }
            } catch (RemoteException e) {
            }
            try {
                this.xZ.mContext.unbindService(this);
            } catch (IllegalArgumentException e2) {
            }
            this.xZ.xV = null;
            this.xZ.xX.mo858a(2, null);
        }

        public void onServiceDisconnected(ComponentName component) {
            ae.m44V("service disconnected: " + component);
            this.xZ.xV = null;
            this.xZ.xW.onDisconnected();
        }
    }

    /* renamed from: com.google.android.gms.analytics.c$b */
    public interface C0112b {
        void onConnected();

        void onDisconnected();
    }

    /* renamed from: com.google.android.gms.analytics.c$c */
    public interface C0113c {
        /* renamed from: a */
        void mo858a(int i, Intent intent);
    }

    public C0781c(Context context, C0112b c0112b, C0113c c0113c) {
        this.mContext = context;
        if (c0112b == null) {
            throw new IllegalArgumentException("onConnectedListener cannot be null");
        }
        this.xW = c0112b;
        if (c0113c == null) {
            throw new IllegalArgumentException("onConnectionFailedListener cannot be null");
        }
        this.xX = c0113c;
    }

    private hb dR() {
        dS();
        return this.xY;
    }

    private void dT() {
        dU();
    }

    private void dU() {
        this.xW.onConnected();
    }

    /* renamed from: a */
    public void mo828a(Map<String, String> map, long j, String str, List<ha> list) {
        try {
            dR().mo1802a(map, j, str, list);
        } catch (RemoteException e) {
            ae.m42T("sendHit failed: " + e);
        }
    }

    public void connect() {
        Intent intent = new Intent("com.google.android.gms.analytics.service.START");
        intent.setComponent(new ComponentName(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE, "com.google.android.gms.analytics.service.AnalyticsService"));
        intent.putExtra("app_package_name", this.mContext.getPackageName());
        if (this.xV != null) {
            ae.m42T("Calling connect() while still connected, missing disconnect().");
            return;
        }
        this.xV = new C0111a(this);
        boolean bindService = this.mContext.bindService(intent, this.xV, 129);
        ae.m44V("connect: bindService returned " + bindService + " for " + intent);
        if (!bindService) {
            this.xV = null;
            this.xX.mo858a(1, null);
        }
    }

    public void dQ() {
        try {
            dR().dQ();
        } catch (RemoteException e) {
            ae.m42T("clear hits failed: " + e);
        }
    }

    protected void dS() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public void disconnect() {
        this.xY = null;
        if (this.xV != null) {
            try {
                this.mContext.unbindService(this.xV);
            } catch (IllegalStateException e) {
            } catch (IllegalArgumentException e2) {
            }
            this.xV = null;
            this.xW.onDisconnected();
        }
    }

    public boolean isConnected() {
        return this.xY != null;
    }
}
