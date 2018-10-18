package com.google.android.gms.drive.realtime.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.realtime.internal.event.ParcelableEventList;

/* renamed from: com.google.android.gms.drive.realtime.internal.j */
public interface C0260j extends IInterface {

    /* renamed from: com.google.android.gms.drive.realtime.internal.j$a */
    public static abstract class C0851a extends Binder implements C0260j {

        /* renamed from: com.google.android.gms.drive.realtime.internal.j$a$a */
        private static class C0850a implements C0260j {
            private IBinder le;

            C0850a(IBinder iBinder) {
                this.le = iBinder;
            }

            /* renamed from: a */
            public void mo1080a(ParcelableEventList parcelableEventList) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IEventCallback");
                    if (parcelableEventList != null) {
                        obtain.writeInt(1);
                        parcelableEventList.writeToParcel(obtain, 0);
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
            public void mo1081n(Status status) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IEventCallback");
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

        public static C0260j ai(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.drive.realtime.internal.IEventCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0260j)) ? new C0850a(iBinder) : (C0260j) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            Status status = null;
            switch (code) {
                case 1:
                    ParcelableEventList parcelableEventList;
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IEventCallback");
                    if (data.readInt() != 0) {
                        parcelableEventList = (ParcelableEventList) ParcelableEventList.CREATOR.createFromParcel(data);
                    }
                    mo1080a(parcelableEventList);
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IEventCallback");
                    if (data.readInt() != 0) {
                        status = Status.CREATOR.createFromParcel(data);
                    }
                    mo1081n(status);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.drive.realtime.internal.IEventCallback");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: a */
    void mo1080a(ParcelableEventList parcelableEventList) throws RemoteException;

    /* renamed from: n */
    void mo1081n(Status status) throws RemoteException;
}
