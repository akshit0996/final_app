package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.C0272d;
import com.google.android.gms.dynamic.C0272d.C0871a;

public interface ep extends IInterface {

    /* renamed from: com.google.android.gms.internal.ep$a */
    public static abstract class C0948a extends Binder implements ep {

        /* renamed from: com.google.android.gms.internal.ep$a$a */
        private static class C0947a implements ep {
            private IBinder le;

            C0947a(IBinder iBinder) {
                this.le = iBinder;
            }

            public IBinder asBinder() {
                return this.le;
            }

            /* renamed from: c */
            public IBinder mo1774c(C0272d c0272d) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManagerCreator");
                    obtain.writeStrongBinder(c0272d != null ? c0272d.asBinder() : null);
                    this.le.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    IBinder readStrongBinder = obtain2.readStrongBinder();
                    return readStrongBinder;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        /* renamed from: x */
        public static ep m3136x(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManagerCreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ep)) ? new C0947a(iBinder) : (ep) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManagerCreator");
                    IBinder c = mo1774c(C0871a.ap(data.readStrongBinder()));
                    reply.writeNoException();
                    reply.writeStrongBinder(c);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManagerCreator");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: c */
    IBinder mo1774c(C0272d c0272d) throws RemoteException;
}
