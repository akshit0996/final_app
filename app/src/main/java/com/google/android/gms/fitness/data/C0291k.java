package com.google.android.gms.fitness.data;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.google.android.gms.fitness.data.k */
public interface C0291k extends IInterface {

    /* renamed from: com.google.android.gms.fitness.data.k$a */
    public static abstract class C0875a extends Binder implements C0291k {

        /* renamed from: com.google.android.gms.fitness.data.k$a$a */
        private static class C0874a implements C0291k {
            private IBinder le;

            C0874a(IBinder iBinder) {
                this.le = iBinder;
            }

            public IBinder asBinder() {
                return this.le;
            }

            /* renamed from: c */
            public void mo1160c(DataPoint dataPoint) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.data.IDataSourceListener");
                    if (dataPoint != null) {
                        obtain.writeInt(1);
                        dataPoint.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public C0875a() {
            attachInterface(this, "com.google.android.gms.fitness.data.IDataSourceListener");
        }

        public static C0291k aq(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.data.IDataSourceListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0291k)) ? new C0874a(iBinder) : (C0291k) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.fitness.data.IDataSourceListener");
                    mo1160c(data.readInt() != 0 ? (DataPoint) DataPoint.CREATOR.createFromParcel(data) : null);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.fitness.data.IDataSourceListener");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: c */
    void mo1160c(DataPoint dataPoint) throws RemoteException;
}
