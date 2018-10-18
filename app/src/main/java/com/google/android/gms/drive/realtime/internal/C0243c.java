package com.google.android.gms.drive.realtime.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* renamed from: com.google.android.gms.drive.realtime.internal.c */
public interface C0243c extends IInterface {

    /* renamed from: com.google.android.gms.drive.realtime.internal.c$a */
    public static abstract class C0837a extends Binder implements C0243c {

        /* renamed from: com.google.android.gms.drive.realtime.internal.c$a$a */
        private static class C0836a implements C0243c {
            private IBinder le;

            C0836a(IBinder iBinder) {
                this.le = iBinder;
            }

            /* renamed from: N */
            public void mo1068N(boolean z) throws RemoteException {
                int i = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IBooleanCallback");
                    if (!z) {
                        i = 0;
                    }
                    obtain.writeInt(i);
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
            public void mo1069n(Status status) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IBooleanCallback");
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

        public static C0243c ab(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.drive.realtime.internal.IBooleanCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0243c)) ? new C0836a(iBinder) : (C0243c) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IBooleanCallback");
                    mo1068N(data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IBooleanCallback");
                    mo1069n(data.readInt() != 0 ? Status.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.drive.realtime.internal.IBooleanCallback");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: N */
    void mo1068N(boolean z) throws RemoteException;

    /* renamed from: n */
    void mo1069n(Status status) throws RemoteException;
}
