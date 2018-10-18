package com.google.android.gms.drive.realtime.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* renamed from: com.google.android.gms.drive.realtime.internal.k */
public interface C0261k extends IInterface {

    /* renamed from: com.google.android.gms.drive.realtime.internal.k$a */
    public static abstract class C0853a extends Binder implements C0261k {

        /* renamed from: com.google.android.gms.drive.realtime.internal.k$a$a */
        private static class C0852a implements C0261k {
            private IBinder le;

            C0852a(IBinder iBinder) {
                this.le = iBinder;
            }

            /* renamed from: a */
            public void mo1082a(ParcelableIndexReference parcelableIndexReference) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IIndexReferenceCallback");
                    if (parcelableIndexReference != null) {
                        obtain.writeInt(1);
                        parcelableIndexReference.writeToParcel(obtain, 0);
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

            /* renamed from: n */
            public void mo1083n(Status status) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IIndexReferenceCallback");
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

        public static C0261k aj(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.drive.realtime.internal.IIndexReferenceCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0261k)) ? new C0852a(iBinder) : (C0261k) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            Status status = null;
            switch (code) {
                case 1:
                    ParcelableIndexReference parcelableIndexReference;
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IIndexReferenceCallback");
                    if (data.readInt() != 0) {
                        parcelableIndexReference = (ParcelableIndexReference) ParcelableIndexReference.CREATOR.createFromParcel(data);
                    }
                    mo1082a(parcelableIndexReference);
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IIndexReferenceCallback");
                    if (data.readInt() != 0) {
                        status = Status.CREATOR.createFromParcel(data);
                    }
                    mo1083n(status);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.drive.realtime.internal.IIndexReferenceCallback");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: a */
    void mo1082a(ParcelableIndexReference parcelableIndexReference) throws RemoteException;

    /* renamed from: n */
    void mo1083n(Status status) throws RemoteException;
}
