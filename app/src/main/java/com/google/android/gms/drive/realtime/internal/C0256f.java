package com.google.android.gms.drive.realtime.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

/* renamed from: com.google.android.gms.drive.realtime.internal.f */
public interface C0256f extends IInterface {

    /* renamed from: com.google.android.gms.drive.realtime.internal.f$a */
    public static abstract class C0843a extends Binder implements C0256f {

        /* renamed from: com.google.android.gms.drive.realtime.internal.f$a$a */
        private static class C0842a implements C0256f {
            private IBinder le;

            C0842a(IBinder iBinder) {
                this.le = iBinder;
            }

            public IBinder asBinder() {
                return this.le;
            }

            /* renamed from: b */
            public void mo1074b(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IDataHolderCallback");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
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

            /* renamed from: n */
            public void mo1075n(Status status) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IDataHolderCallback");
                    if (status != null) {
                        obtain.writeInt(1);
                        status.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static C0256f ae(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.drive.realtime.internal.IDataHolderCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0256f)) ? new C0842a(iBinder) : (C0256f) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            Status status = null;
            switch (code) {
                case 1:
                    DataHolder B;
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IDataHolderCallback");
                    if (data.readInt() != 0) {
                        B = DataHolder.CREATOR.m174B(data);
                    }
                    mo1074b(B);
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IDataHolderCallback");
                    if (data.readInt() != 0) {
                        status = Status.CREATOR.createFromParcel(data);
                    }
                    mo1075n(status);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.drive.realtime.internal.IDataHolderCallback");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: b */
    void mo1074b(DataHolder dataHolder) throws RemoteException;

    /* renamed from: n */
    void mo1075n(Status status) throws RemoteException;
}
