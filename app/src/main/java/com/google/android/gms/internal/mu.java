package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.service.FitnessSensorServiceRequest;
import com.google.android.gms.internal.lx.C1023a;
import com.google.android.gms.internal.md.C1035a;

public interface mu extends IInterface {

    /* renamed from: com.google.android.gms.internal.mu$a */
    public static abstract class C1039a extends Binder implements mu {
        public C1039a() {
            attachInterface(this, "com.google.android.gms.fitness.internal.service.IFitnessSensorService");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            ms msVar = null;
            switch (code) {
                case 1:
                    mq mqVar;
                    data.enforceInterface("com.google.android.gms.fitness.internal.service.IFitnessSensorService");
                    if (data.readInt() != 0) {
                        mqVar = (mq) mq.CREATOR.createFromParcel(data);
                    }
                    mo2987a(mqVar, C1023a.at(data.readStrongBinder()));
                    return true;
                case 2:
                    FitnessSensorServiceRequest fitnessSensorServiceRequest;
                    data.enforceInterface("com.google.android.gms.fitness.internal.service.IFitnessSensorService");
                    if (data.readInt() != 0) {
                        fitnessSensorServiceRequest = (FitnessSensorServiceRequest) FitnessSensorServiceRequest.CREATOR.createFromParcel(data);
                    }
                    mo2986a(fitnessSensorServiceRequest, C1035a.az(data.readStrongBinder()));
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.fitness.internal.service.IFitnessSensorService");
                    if (data.readInt() != 0) {
                        msVar = (ms) ms.CREATOR.createFromParcel(data);
                    }
                    mo2988a(msVar, C1035a.az(data.readStrongBinder()));
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.fitness.internal.service.IFitnessSensorService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: a */
    void mo2986a(FitnessSensorServiceRequest fitnessSensorServiceRequest, md mdVar) throws RemoteException;

    /* renamed from: a */
    void mo2987a(mq mqVar, lx lxVar) throws RemoteException;

    /* renamed from: a */
    void mo2988a(ms msVar, md mdVar) throws RemoteException;
}
