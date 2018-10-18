package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate.C1108a;

/* renamed from: com.google.android.gms.maps.internal.u */
public interface C0545u extends IInterface {

    /* renamed from: com.google.android.gms.maps.internal.u$a */
    public static abstract class C1154a extends Binder implements C0545u {

        /* renamed from: com.google.android.gms.maps.internal.u$a$a */
        private static class C1153a implements C0545u {
            private IBinder le;

            C1153a(IBinder iBinder) {
                this.le = iBinder;
            }

            /* renamed from: a */
            public void mo2332a(IStreetViewPanoramaDelegate iStreetViewPanoramaDelegate) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnStreetViewPanoramaReadyCallback");
                    obtain.writeStrongBinder(iStreetViewPanoramaDelegate != null ? iStreetViewPanoramaDelegate.asBinder() : null);
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

        public C1154a() {
            attachInterface(this, "com.google.android.gms.maps.internal.IOnStreetViewPanoramaReadyCallback");
        }

        public static C0545u bo(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnStreetViewPanoramaReadyCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0545u)) ? new C1153a(iBinder) : (C0545u) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.maps.internal.IOnStreetViewPanoramaReadyCallback");
                    mo2332a(C1108a.br(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.maps.internal.IOnStreetViewPanoramaReadyCallback");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: a */
    void mo2332a(IStreetViewPanoramaDelegate iStreetViewPanoramaDelegate) throws RemoteException;
}
