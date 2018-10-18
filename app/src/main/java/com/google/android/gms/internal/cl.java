package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.internal.cm.C0927a;
import com.google.android.gms.internal.jl.C1399e;

@ey
public class cl extends jl<cm> {
    final int qg;

    public cl(Context context, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, int i) {
        super(context, context.getMainLooper(), connectionCallbacks, onConnectionFailedListener, new String[0]);
        this.qg = i;
    }

    /* renamed from: a */
    protected void mo2969a(jt jtVar, C1399e c1399e) throws RemoteException {
        jtVar.mo1886g(c1399e, this.qg, getContext().getPackageName(), new Bundle());
    }

    protected String bK() {
        return "com.google.android.gms.ads.gservice.START";
    }

    protected String bL() {
        return "com.google.android.gms.ads.internal.gservice.IGservicesValueService";
    }

    public cm bM() throws DeadObjectException {
        return (cm) super.hw();
    }

    /* renamed from: k */
    protected cm m4333k(IBinder iBinder) {
        return C0927a.m3086m(iBinder);
    }

    /* renamed from: l */
    protected /* synthetic */ IInterface mo2972l(IBinder iBinder) {
        return m4333k(iBinder);
    }
}
