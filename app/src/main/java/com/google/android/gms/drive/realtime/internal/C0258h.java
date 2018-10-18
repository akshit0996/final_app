package com.google.android.gms.drive.realtime.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.google.android.gms.drive.realtime.internal.h */
public interface C0258h extends IInterface {

    /* renamed from: com.google.android.gms.drive.realtime.internal.h$a */
    public static abstract class C0847a extends Binder implements C0258h {

        /* renamed from: com.google.android.gms.drive.realtime.internal.h$a$a */
        private static class C0846a implements C0258h {
            private IBinder le;

            C0846a(IBinder iBinder) {
                this.le = iBinder;
            }

            public IBinder asBinder() {
                return this.le;
            }

            /* renamed from: c */
            public void mo1078c(boolean z, boolean z2) throws RemoteException {
                int i = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IDocumentSaveStateEventCallback");
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
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
        }

        public static C0258h ag(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.drive.realtime.internal.IDocumentSaveStateEventCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0258h)) ? new C0846a(iBinder) : (C0258h) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            boolean z = false;
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IDocumentSaveStateEventCallback");
                    boolean z2 = data.readInt() != 0;
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    mo1078c(z2, z);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.drive.realtime.internal.IDocumentSaveStateEventCallback");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: c */
    void mo1078c(boolean z, boolean z2) throws RemoteException;
}
