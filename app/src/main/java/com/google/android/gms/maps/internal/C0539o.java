package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.internal.C0567l;
import com.google.android.gms.maps.model.internal.C0567l.C1175a;

/* renamed from: com.google.android.gms.maps.internal.o */
public interface C0539o extends IInterface {

    /* renamed from: com.google.android.gms.maps.internal.o$a */
    public static abstract class C1142a extends Binder implements C0539o {

        /* renamed from: com.google.android.gms.maps.internal.o$a$a */
        private static class C1141a implements C0539o {
            private IBinder le;

            C1141a(IBinder iBinder) {
                this.le = iBinder;
            }

            public IBinder asBinder() {
                return this.le;
            }

            /* renamed from: b */
            public void mo2323b(C0567l c0567l) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnMarkerDragListener");
                    obtain.writeStrongBinder(c0567l != null ? c0567l.asBinder() : null);
                    this.le.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo2324c(C0567l c0567l) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnMarkerDragListener");
                    obtain.writeStrongBinder(c0567l != null ? c0567l.asBinder() : null);
                    this.le.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: d */
            public void mo2325d(C0567l c0567l) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnMarkerDragListener");
                    obtain.writeStrongBinder(c0567l != null ? c0567l.asBinder() : null);
                    this.le.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C1142a() {
            attachInterface(this, "com.google.android.gms.maps.internal.IOnMarkerDragListener");
        }

        public static C0539o bi(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnMarkerDragListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0539o)) ? new C1141a(iBinder) : (C0539o) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.maps.internal.IOnMarkerDragListener");
                    mo2323b(C1175a.bA(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.maps.internal.IOnMarkerDragListener");
                    mo2325d(C1175a.bA(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.maps.internal.IOnMarkerDragListener");
                    mo2324c(C1175a.bA(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.maps.internal.IOnMarkerDragListener");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: b */
    void mo2323b(C0567l c0567l) throws RemoteException;

    /* renamed from: c */
    void mo2324c(C0567l c0567l) throws RemoteException;

    /* renamed from: d */
    void mo2325d(C0567l c0567l) throws RemoteException;
}
