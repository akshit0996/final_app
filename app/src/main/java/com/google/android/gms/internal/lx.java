package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.DataSourcesResult;

public interface lx extends IInterface {

    /* renamed from: com.google.android.gms.internal.lx$a */
    public static abstract class C1023a extends Binder implements lx {

        /* renamed from: com.google.android.gms.internal.lx$a$a */
        private static class C1022a implements lx {
            private IBinder le;

            C1022a(IBinder iBinder) {
                this.le = iBinder;
            }

            /* renamed from: a */
            public void mo1919a(DataSourcesResult dataSourcesResult) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IDataSourcesCallback");
                    if (dataSourcesResult != null) {
                        obtain.writeInt(1);
                        dataSourcesResult.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.le;
            }
        }

        public C1023a() {
            attachInterface(this, "com.google.android.gms.fitness.internal.IDataSourcesCallback");
        }

        public static lx at(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IDataSourcesCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof lx)) ? new C1022a(iBinder) : (lx) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.fitness.internal.IDataSourcesCallback");
                    mo1919a(data.readInt() != 0 ? (DataSourcesResult) DataSourcesResult.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.fitness.internal.IDataSourcesCallback");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: a */
    void mo1919a(DataSourcesResult dataSourcesResult) throws RemoteException;
}
