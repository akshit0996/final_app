package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.internal.IGoogleMapDelegate.C1098a;

/* renamed from: com.google.android.gms.maps.internal.m */
public interface C0537m extends IInterface {

    /* renamed from: com.google.android.gms.maps.internal.m$a */
    public static abstract class C1138a extends Binder implements C0537m {

        /* renamed from: com.google.android.gms.maps.internal.m$a$a */
        private static class C1137a implements C0537m {
            private IBinder le;

            C1137a(IBinder iBinder) {
                this.le = iBinder;
            }

            /* renamed from: a */
            public void mo2321a(IGoogleMapDelegate iGoogleMapDelegate) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnMapReadyCallback");
                    obtain.writeStrongBinder(iGoogleMapDelegate != null ? iGoogleMapDelegate.asBinder() : null);
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

        public C1138a() {
            attachInterface(this, "com.google.android.gms.maps.internal.IOnMapReadyCallback");
        }

        public static C0537m bg(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnMapReadyCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0537m)) ? new C1137a(iBinder) : (C0537m) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.maps.internal.IOnMapReadyCallback");
                    mo2321a(C1098a.aT(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.maps.internal.IOnMapReadyCallback");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: a */
    void mo2321a(IGoogleMapDelegate iGoogleMapDelegate) throws RemoteException;
}
