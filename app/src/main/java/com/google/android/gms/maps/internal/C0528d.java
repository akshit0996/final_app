package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.C0272d;
import com.google.android.gms.dynamic.C0272d.C0871a;
import com.google.android.gms.maps.model.internal.C0567l;
import com.google.android.gms.maps.model.internal.C0567l.C1175a;

/* renamed from: com.google.android.gms.maps.internal.d */
public interface C0528d extends IInterface {

    /* renamed from: com.google.android.gms.maps.internal.d$a */
    public static abstract class C1120a extends Binder implements C0528d {

        /* renamed from: com.google.android.gms.maps.internal.d$a$a */
        private static class C1119a implements C0528d {
            private IBinder le;

            C1119a(IBinder iBinder) {
                this.le = iBinder;
            }

            public IBinder asBinder() {
                return this.le;
            }

            /* renamed from: f */
            public C0272d mo2309f(C0567l c0567l) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IInfoWindowAdapter");
                    obtain.writeStrongBinder(c0567l != null ? c0567l.asBinder() : null);
                    this.le.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    C0272d ap = C0871a.ap(obtain2.readStrongBinder());
                    return ap;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: g */
            public C0272d mo2310g(C0567l c0567l) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IInfoWindowAdapter");
                    obtain.writeStrongBinder(c0567l != null ? c0567l.asBinder() : null);
                    this.le.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    C0272d ap = C0871a.ap(obtain2.readStrongBinder());
                    return ap;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C1120a() {
            attachInterface(this, "com.google.android.gms.maps.internal.IInfoWindowAdapter");
        }

        public static C0528d aU(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IInfoWindowAdapter");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0528d)) ? new C1119a(iBinder) : (C0528d) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            IBinder iBinder = null;
            C0272d f;
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.maps.internal.IInfoWindowAdapter");
                    f = mo2309f(C1175a.bA(data.readStrongBinder()));
                    reply.writeNoException();
                    if (f != null) {
                        iBinder = f.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.maps.internal.IInfoWindowAdapter");
                    f = mo2310g(C1175a.bA(data.readStrongBinder()));
                    reply.writeNoException();
                    if (f != null) {
                        iBinder = f.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.maps.internal.IInfoWindowAdapter");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: f */
    C0272d mo2309f(C0567l c0567l) throws RemoteException;

    /* renamed from: g */
    C0272d mo2310g(C0567l c0567l) throws RemoteException;
}
