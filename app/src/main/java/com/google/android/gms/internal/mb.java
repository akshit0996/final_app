package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.SessionReadResult;

public interface mb extends IInterface {

    /* renamed from: com.google.android.gms.internal.mb$a */
    public static abstract class C1031a extends Binder implements mb {

        /* renamed from: com.google.android.gms.internal.mb$a$a */
        private static class C1030a implements mb {
            private IBinder le;

            C1030a(IBinder iBinder) {
                this.le = iBinder;
            }

            /* renamed from: a */
            public void mo1946a(SessionReadResult sessionReadResult) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.ISessionReadCallback");
                    if (sessionReadResult != null) {
                        obtain.writeInt(1);
                        sessionReadResult.writeToParcel(obtain, 0);
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

        public C1031a() {
            attachInterface(this, "com.google.android.gms.fitness.internal.ISessionReadCallback");
        }

        public static mb ax(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.ISessionReadCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof mb)) ? new C1030a(iBinder) : (mb) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.fitness.internal.ISessionReadCallback");
                    mo1946a(data.readInt() != 0 ? (SessionReadResult) SessionReadResult.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.fitness.internal.ISessionReadCallback");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: a */
    void mo1946a(SessionReadResult sessionReadResult) throws RemoteException;
}
