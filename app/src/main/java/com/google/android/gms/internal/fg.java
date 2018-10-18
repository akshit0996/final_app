package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.internal.fl.C0966a;
import com.google.android.gms.internal.jl.C1399e;

@ey
public class fg extends jl<fl> {
    final int qg;

    public fg(Context context, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, int i) {
        super(context, context.getMainLooper(), connectionCallbacks, onConnectionFailedListener, new String[0]);
        this.qg = i;
    }

    /* renamed from: B */
    protected fl m4372B(IBinder iBinder) {
        return C0966a.m3176C(iBinder);
    }

    /* renamed from: a */
    protected void mo2969a(jt jtVar, C1399e c1399e) throws RemoteException {
        jtVar.mo1886g(c1399e, this.qg, getContext().getPackageName(), new Bundle());
    }

    protected String bK() {
        return "com.google.android.gms.ads.service.START";
    }

    protected String bL() {
        return "com.google.android.gms.ads.internal.request.IAdRequestService";
    }

    public fl cL() throws DeadObjectException {
        return (fl) super.hw();
    }

    /* renamed from: l */
    protected /* synthetic */ IInterface mo2972l(IBinder iBinder) {
        return m4372B(iBinder);
    }
}
