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
import com.google.android.gms.internal.ni.C1051a;

public class nc extends jl<ni> {
    protected final np<ni> Ee = new C10441(this);
    private final String agD;

    /* renamed from: com.google.android.gms.internal.nc$1 */
    class C10441 implements np<ni> {
        final /* synthetic */ nc agE;

        C10441(nc ncVar) {
            this.agE = ncVar;
        }

        public void dS() {
            this.agE.dS();
        }

        public /* synthetic */ IInterface hw() throws DeadObjectException {
            return nh();
        }

        public ni nh() throws DeadObjectException {
            return (ni) this.agE.hw();
        }
    }

    public nc(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String str) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, new String[0]);
        this.agD = str;
    }

    /* renamed from: a */
    protected void mo2969a(jt jtVar, C1399e c1399e) throws RemoteException {
        Bundle bundle = new Bundle();
        bundle.putString("client_name", this.agD);
        jtVar.mo1882e(c1399e, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName(), bundle);
    }

    protected ni aM(IBinder iBinder) {
        return C1051a.aO(iBinder);
    }

    protected String bK() {
        return "com.google.android.location.internal.GoogleLocationManagerService.START";
    }

    protected String bL() {
        return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
    }

    /* renamed from: l */
    protected /* synthetic */ IInterface mo2972l(IBinder iBinder) {
        return aM(iBinder);
    }
}
