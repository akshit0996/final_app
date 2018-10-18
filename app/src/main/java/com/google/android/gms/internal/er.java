package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.eq.C0950a;

public interface er extends IInterface {

    /* renamed from: com.google.android.gms.internal.er$a */
    public static abstract class C0952a extends Binder implements er {

        /* renamed from: com.google.android.gms.internal.er$a$a */
        private static class C0951a implements er {
            private IBinder le;

            C0951a(IBinder iBinder) {
                this.le = iBinder;
            }

            /* renamed from: a */
            public void mo1780a(eq eqVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IPlayStorePurchaseListener");
                    obtain.writeStrongBinder(eqVar != null ? eqVar.asBinder() : null);
                    this.le.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.le;
            }

            public boolean isValidPurchase(String productId) throws RemoteException {
                boolean z = true;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IPlayStorePurchaseListener");
                    obtain.writeString(productId);
                    this.le.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C0952a() {
            attachInterface(this, "com.google.android.gms.ads.internal.purchase.client.IPlayStorePurchaseListener");
        }

        /* renamed from: z */
        public static er m3139z(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.purchase.client.IPlayStorePurchaseListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof er)) ? new C0951a(iBinder) : (er) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IPlayStorePurchaseListener");
                    boolean isValidPurchase = isValidPurchase(data.readString());
                    reply.writeNoException();
                    reply.writeInt(isValidPurchase ? 1 : 0);
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IPlayStorePurchaseListener");
                    mo1780a(C0950a.m3137y(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.ads.internal.purchase.client.IPlayStorePurchaseListener");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: a */
    void mo1780a(eq eqVar) throws RemoteException;

    boolean isValidPurchase(String str) throws RemoteException;
}
