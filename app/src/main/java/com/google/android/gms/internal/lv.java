package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.internal.jl.C1399e;
import com.google.android.gms.internal.lz.C1027a;

public class lv extends jl<lz> implements lu {
    private final String DZ;

    public lv(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String str, String[] strArr) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, strArr);
        this.DZ = str;
    }

    /* renamed from: a */
    protected void mo2969a(jt jtVar, C1399e c1399e) throws RemoteException {
        jtVar.mo1869a((js) c1399e, (int) GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName(), this.DZ, hv(), new Bundle());
    }

    protected lz ar(IBinder iBinder) {
        return C1027a.av(iBinder);
    }

    protected String bK() {
        return "com.google.android.gms.fitness.GoogleFitnessService.START";
    }

    protected String bL() {
        return "com.google.android.gms.fitness.internal.IGoogleFitnessService";
    }

    public lz jM() throws DeadObjectException {
        return (lz) hw();
    }

    /* renamed from: l */
    protected /* synthetic */ IInterface mo2972l(IBinder iBinder) {
        return ar(iBinder);
    }
}
