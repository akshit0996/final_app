package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.internal.jl.C1399e;
import com.google.android.gms.internal.ki.C1015a;

public class kg extends jl<ki> {
    public kg(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String... strArr) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, strArr);
    }

    /* renamed from: T */
    protected ki m4460T(IBinder iBinder) {
        return C1015a.m3372V(iBinder);
    }

    /* renamed from: a */
    protected void mo2969a(jt jtVar, C1399e c1399e) throws RemoteException {
        jtVar.mo1891j(c1399e, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName());
    }

    public String bK() {
        return "com.google.android.gms.common.service.START";
    }

    protected String bL() {
        return "com.google.android.gms.common.internal.service.ICommonService";
    }

    /* renamed from: l */
    protected /* synthetic */ IInterface mo2972l(IBinder iBinder) {
        return m4460T(iBinder);
    }
}
