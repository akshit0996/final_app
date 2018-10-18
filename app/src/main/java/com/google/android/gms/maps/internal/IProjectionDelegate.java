package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.C0272d;
import com.google.android.gms.dynamic.C0272d.C0871a;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.VisibleRegion;

public interface IProjectionDelegate extends IInterface {

    /* renamed from: com.google.android.gms.maps.internal.IProjectionDelegate$a */
    public static abstract class C1106a extends Binder implements IProjectionDelegate {

        /* renamed from: com.google.android.gms.maps.internal.IProjectionDelegate$a$a */
        private static class C1105a implements IProjectionDelegate {
            private IBinder le;

            C1105a(IBinder iBinder) {
                this.le = iBinder;
            }

            public IBinder asBinder() {
                return this.le;
            }

            public LatLng fromScreenLocation(C0272d point) throws RemoteException {
                LatLng latLng = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IProjectionDelegate");
                    obtain.writeStrongBinder(point != null ? point.asBinder() : null);
                    this.le.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        latLng = LatLng.CREATOR.de(obtain2);
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return latLng;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public LatLng fromScreenLocation2(C1157y point) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IProjectionDelegate");
                    if (point != null) {
                        obtain.writeInt(1);
                        point.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    LatLng de = obtain2.readInt() != 0 ? LatLng.CREATOR.de(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return de;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public VisibleRegion getVisibleRegion() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IProjectionDelegate");
                    this.le.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    VisibleRegion visibleRegion = obtain2.readInt() != 0 ? VisibleRegion.CREATOR.m2025do(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return visibleRegion;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public C0272d toScreenLocation(LatLng location) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IProjectionDelegate");
                    if (location != null) {
                        obtain.writeInt(1);
                        location.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    C0272d ap = C0871a.ap(obtain2.readStrongBinder());
                    return ap;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public C1157y toScreenLocation2(LatLng location) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IProjectionDelegate");
                    if (location != null) {
                        obtain.writeInt(1);
                        location.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    C1157y cZ = obtain2.readInt() != 0 ? C1157y.CREATOR.cZ(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return cZ;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static IProjectionDelegate bp(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IProjectionDelegate");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IProjectionDelegate)) ? new C1105a(iBinder) : (IProjectionDelegate) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            LatLng latLng = null;
            LatLng fromScreenLocation;
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.maps.internal.IProjectionDelegate");
                    fromScreenLocation = fromScreenLocation(C0871a.ap(data.readStrongBinder()));
                    reply.writeNoException();
                    if (fromScreenLocation != null) {
                        reply.writeInt(1);
                        fromScreenLocation.writeToParcel(reply, 1);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                case 2:
                    IBinder asBinder;
                    data.enforceInterface("com.google.android.gms.maps.internal.IProjectionDelegate");
                    C0272d toScreenLocation = toScreenLocation(data.readInt() != 0 ? LatLng.CREATOR.de(data) : null);
                    reply.writeNoException();
                    if (toScreenLocation != null) {
                        asBinder = toScreenLocation.asBinder();
                    }
                    reply.writeStrongBinder(asBinder);
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.maps.internal.IProjectionDelegate");
                    VisibleRegion visibleRegion = getVisibleRegion();
                    reply.writeNoException();
                    if (visibleRegion != null) {
                        reply.writeInt(1);
                        visibleRegion.writeToParcel(reply, 1);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                case 4:
                    C1157y cZ;
                    data.enforceInterface("com.google.android.gms.maps.internal.IProjectionDelegate");
                    if (data.readInt() != 0) {
                        cZ = C1157y.CREATOR.cZ(data);
                    }
                    fromScreenLocation = fromScreenLocation2(cZ);
                    reply.writeNoException();
                    if (fromScreenLocation != null) {
                        reply.writeInt(1);
                        fromScreenLocation.writeToParcel(reply, 1);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                case 5:
                    data.enforceInterface("com.google.android.gms.maps.internal.IProjectionDelegate");
                    if (data.readInt() != 0) {
                        latLng = LatLng.CREATOR.de(data);
                    }
                    C1157y toScreenLocation2 = toScreenLocation2(latLng);
                    reply.writeNoException();
                    if (toScreenLocation2 != null) {
                        reply.writeInt(1);
                        toScreenLocation2.writeToParcel(reply, 1);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.maps.internal.IProjectionDelegate");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    LatLng fromScreenLocation(C0272d c0272d) throws RemoteException;

    LatLng fromScreenLocation2(C1157y c1157y) throws RemoteException;

    VisibleRegion getVisibleRegion() throws RemoteException;

    C0272d toScreenLocation(LatLng latLng) throws RemoteException;

    C1157y toScreenLocation2(LatLng latLng) throws RemoteException;
}
