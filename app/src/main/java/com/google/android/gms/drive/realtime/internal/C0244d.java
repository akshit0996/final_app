package com.google.android.gms.drive.realtime.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.google.android.gms.drive.realtime.internal.d */
public interface C0244d extends IInterface {

    /* renamed from: com.google.android.gms.drive.realtime.internal.d$a */
    public static abstract class C0839a extends Binder implements C0244d {

        /* renamed from: com.google.android.gms.drive.realtime.internal.d$a$a */
        private static class C0838a implements C0244d {
            private IBinder le;

            C0838a(IBinder iBinder) {
                this.le = iBinder;
            }

            /* renamed from: a */
            public void mo1070a(ParcelableCollaborator parcelableCollaborator) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.ICollaboratorEventCallback");
                    if (parcelableCollaborator != null) {
                        obtain.writeInt(1);
                        parcelableCollaborator.writeToParcel(obtain, 0);
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

            /* renamed from: b */
            public void mo1071b(ParcelableCollaborator parcelableCollaborator) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.ICollaboratorEventCallback");
                    if (parcelableCollaborator != null) {
                        obtain.writeInt(1);
                        parcelableCollaborator.writeToParcel(obtain, 0);
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

        public static C0244d ac(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.drive.realtime.internal.ICollaboratorEventCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0244d)) ? new C0838a(iBinder) : (C0244d) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            ParcelableCollaborator parcelableCollaborator = null;
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.ICollaboratorEventCallback");
                    if (data.readInt() != 0) {
                        parcelableCollaborator = (ParcelableCollaborator) ParcelableCollaborator.CREATOR.createFromParcel(data);
                    }
                    mo1070a(parcelableCollaborator);
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.ICollaboratorEventCallback");
                    if (data.readInt() != 0) {
                        parcelableCollaborator = (ParcelableCollaborator) ParcelableCollaborator.CREATOR.createFromParcel(data);
                    }
                    mo1071b(parcelableCollaborator);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.drive.realtime.internal.ICollaboratorEventCallback");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: a */
    void mo1070a(ParcelableCollaborator parcelableCollaborator) throws RemoteException;

    /* renamed from: b */
    void mo1071b(ParcelableCollaborator parcelableCollaborator) throws RemoteException;
}
