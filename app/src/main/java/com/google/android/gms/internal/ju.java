package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.C0272d;
import com.google.android.gms.dynamic.C0272d.C0871a;

public interface ju extends IInterface {

    /* renamed from: com.google.android.gms.internal.ju$a */
    public static abstract class C1010a extends Binder implements ju {

        /* renamed from: com.google.android.gms.internal.ju$a$a */
        private static class C1009a implements ju {
            private IBinder le;

            C1009a(IBinder iBinder) {
                this.le = iBinder;
            }

            /* renamed from: a */
            public C0272d mo1905a(C0272d c0272d, int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.ISignInButtonCreator");
                    obtain.writeStrongBinder(c0272d != null ? c0272d.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.le.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    C0272d ap = C0871a.ap(obtain2.readStrongBinder());
                    return ap;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.le;
            }
        }

        /* renamed from: R */
        public static ju m3362R(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ju)) ? new C1009a(iBinder) : (ju) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
                    C0272d a = mo1905a(C0871a.ap(data.readStrongBinder()), data.readInt(), data.readInt());
                    reply.writeNoException();
                    reply.writeStrongBinder(a != null ? a.asBinder() : null);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.common.internal.ISignInButtonCreator");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: a */
    C0272d mo1905a(C0272d c0272d, int i, int i2) throws RemoteException;
}
