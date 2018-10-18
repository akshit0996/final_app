package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.em.C0942a;

public interface en extends IInterface {

    /* renamed from: com.google.android.gms.internal.en$a */
    public static abstract class C0944a extends Binder implements en {

        /* renamed from: com.google.android.gms.internal.en$a$a */
        private static class C0943a implements en {
            private IBinder le;

            C0943a(IBinder iBinder) {
                this.le = iBinder;
            }

            /* renamed from: a */
            public void mo1770a(em emVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseListener");
                    obtain.writeStrongBinder(emVar != null ? emVar.asBinder() : null);
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

        public C0944a() {
            attachInterface(this, "com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseListener");
        }

        /* renamed from: v */
        public static en m3133v(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof en)) ? new C0943a(iBinder) : (en) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseListener");
                    mo1770a(C0942a.m3131u(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseListener");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: a */
    void mo1770a(em emVar) throws RemoteException;
}
