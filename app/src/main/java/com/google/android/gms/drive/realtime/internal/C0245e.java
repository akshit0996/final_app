package com.google.android.gms.drive.realtime.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* renamed from: com.google.android.gms.drive.realtime.internal.e */
public interface C0245e extends IInterface {

    /* renamed from: com.google.android.gms.drive.realtime.internal.e$a */
    public static abstract class C0841a extends Binder implements C0245e {

        /* renamed from: com.google.android.gms.drive.realtime.internal.e$a$a */
        private static class C0840a implements C0245e {
            private IBinder le;

            C0840a(IBinder iBinder) {
                this.le = iBinder;
            }

            /* renamed from: a */
            public void mo1072a(ParcelableCollaborator[] parcelableCollaboratorArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.ICollaboratorsCallback");
                    obtain.writeTypedArray(parcelableCollaboratorArr, 0);
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
            public void mo1073n(Status status) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.ICollaboratorsCallback");
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

        public static C0245e ad(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.drive.realtime.internal.ICollaboratorsCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0245e)) ? new C0840a(iBinder) : (C0245e) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.ICollaboratorsCallback");
                    mo1072a((ParcelableCollaborator[]) data.createTypedArray(ParcelableCollaborator.CREATOR));
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.ICollaboratorsCallback");
                    mo1073n(data.readInt() != 0 ? Status.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.drive.realtime.internal.ICollaboratorsCallback");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: a */
    void mo1072a(ParcelableCollaborator[] parcelableCollaboratorArr) throws RemoteException;

    /* renamed from: n */
    void mo1073n(Status status) throws RemoteException;
}
