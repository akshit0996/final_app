package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.internal.jl.C1399e;
import com.google.android.gms.internal.ok.C1059a;

public class om extends jl<ok> {
    public om(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, (String[]) null);
    }

    /* renamed from: a */
    protected void mo2969a(jt jtVar, C1399e c1399e) throws RemoteException {
        jtVar.mo1864a((js) c1399e, (int) GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName(), new Bundle());
    }

    public ok bH(IBinder iBinder) {
        return C1059a.bG(iBinder);
    }

    protected String bK() {
        return "com.google.android.gms.panorama.service.START";
    }

    protected String bL() {
        return "com.google.android.gms.panorama.internal.IPanoramaService";
    }

    /* renamed from: l */
    public /* synthetic */ IInterface mo2972l(IBinder iBinder) {
        return bH(iBinder);
    }
}
