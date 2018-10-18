package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.C0272d;
import com.google.android.gms.dynamic.C0272d.C0871a;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.StreetViewPanoramaOptions;
import com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate.C1096a;
import com.google.android.gms.maps.internal.IMapFragmentDelegate.C1102a;
import com.google.android.gms.maps.internal.IMapViewDelegate.C1104a;
import com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate.C1110a;
import com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate.C1112a;
import com.google.android.gms.maps.model.internal.C0562g;
import com.google.android.gms.maps.model.internal.C0562g.C1165a;

/* renamed from: com.google.android.gms.maps.internal.c */
public interface C0527c extends IInterface {

    /* renamed from: com.google.android.gms.maps.internal.c$a */
    public static abstract class C1118a extends Binder implements C0527c {

        /* renamed from: com.google.android.gms.maps.internal.c$a$a */
        private static class C1117a implements C0527c {
            private IBinder le;

            C1117a(IBinder iBinder) {
                this.le = iBinder;
            }

            /* renamed from: a */
            public IMapViewDelegate mo2301a(C0272d c0272d, GoogleMapOptions googleMapOptions) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    obtain.writeStrongBinder(c0272d != null ? c0272d.asBinder() : null);
                    if (googleMapOptions != null) {
                        obtain.writeInt(1);
                        googleMapOptions.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    IMapViewDelegate aY = C1104a.aY(obtain2.readStrongBinder());
                    return aY;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public IStreetViewPanoramaViewDelegate mo2302a(C0272d c0272d, StreetViewPanoramaOptions streetViewPanoramaOptions) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    obtain.writeStrongBinder(c0272d != null ? c0272d.asBinder() : null);
                    if (streetViewPanoramaOptions != null) {
                        obtain.writeInt(1);
                        streetViewPanoramaOptions.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    IStreetViewPanoramaViewDelegate bt = C1112a.bt(obtain2.readStrongBinder());
                    return bt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo2303a(C0272d c0272d, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    obtain.writeStrongBinder(c0272d != null ? c0272d.asBinder() : null);
                    obtain.writeInt(i);
                    this.le.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.le;
            }

            /* renamed from: i */
            public void mo2304i(C0272d c0272d) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    obtain.writeStrongBinder(c0272d != null ? c0272d.asBinder() : null);
                    this.le.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: j */
            public IMapFragmentDelegate mo2305j(C0272d c0272d) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    obtain.writeStrongBinder(c0272d != null ? c0272d.asBinder() : null);
                    this.le.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    IMapFragmentDelegate aX = C1102a.aX(obtain2.readStrongBinder());
                    return aX;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: k */
            public IStreetViewPanoramaFragmentDelegate mo2306k(C0272d c0272d) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    obtain.writeStrongBinder(c0272d != null ? c0272d.asBinder() : null);
                    this.le.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    IStreetViewPanoramaFragmentDelegate bs = C1110a.bs(obtain2.readStrongBinder());
                    return bs;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public ICameraUpdateFactoryDelegate nW() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    this.le.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    ICameraUpdateFactoryDelegate aQ = C1096a.aQ(obtain2.readStrongBinder());
                    return aQ;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public C0562g nX() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    this.le.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    C0562g bv = C1165a.bv(obtain2.readStrongBinder());
                    return bv;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static C0527c aS(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.ICreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0527c)) ? new C1117a(iBinder) : (C0527c) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            IBinder iBinder = null;
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    mo2304i(C0871a.ap(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    IMapFragmentDelegate j = mo2305j(C0871a.ap(data.readStrongBinder()));
                    reply.writeNoException();
                    if (j != null) {
                        iBinder = j.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    IMapViewDelegate a = mo2301a(C0871a.ap(data.readStrongBinder()), data.readInt() != 0 ? GoogleMapOptions.CREATOR.cX(data) : null);
                    reply.writeNoException();
                    if (a != null) {
                        iBinder = a.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    ICameraUpdateFactoryDelegate nW = nW();
                    reply.writeNoException();
                    if (nW != null) {
                        iBinder = nW.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 5:
                    data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    C0562g nX = nX();
                    reply.writeNoException();
                    if (nX != null) {
                        iBinder = nX.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 6:
                    data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    mo2303a(C0871a.ap(data.readStrongBinder()), data.readInt());
                    reply.writeNoException();
                    return true;
                case 7:
                    data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    IStreetViewPanoramaViewDelegate a2 = mo2302a(C0871a.ap(data.readStrongBinder()), data.readInt() != 0 ? StreetViewPanoramaOptions.CREATOR.cY(data) : null);
                    reply.writeNoException();
                    if (a2 != null) {
                        iBinder = a2.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 8:
                    data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    IStreetViewPanoramaFragmentDelegate k = mo2306k(C0871a.ap(data.readStrongBinder()));
                    reply.writeNoException();
                    if (k != null) {
                        iBinder = k.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.maps.internal.ICreator");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: a */
    IMapViewDelegate mo2301a(C0272d c0272d, GoogleMapOptions googleMapOptions) throws RemoteException;

    /* renamed from: a */
    IStreetViewPanoramaViewDelegate mo2302a(C0272d c0272d, StreetViewPanoramaOptions streetViewPanoramaOptions) throws RemoteException;

    /* renamed from: a */
    void mo2303a(C0272d c0272d, int i) throws RemoteException;

    /* renamed from: i */
    void mo2304i(C0272d c0272d) throws RemoteException;

    /* renamed from: j */
    IMapFragmentDelegate mo2305j(C0272d c0272d) throws RemoteException;

    /* renamed from: k */
    IStreetViewPanoramaFragmentDelegate mo2306k(C0272d c0272d) throws RemoteException;

    ICameraUpdateFactoryDelegate nW() throws RemoteException;

    C0562g nX() throws RemoteException;
}
