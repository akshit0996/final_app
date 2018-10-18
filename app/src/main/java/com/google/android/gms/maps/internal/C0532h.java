package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.internal.C0567l;
import com.google.android.gms.maps.model.internal.C0567l.C1175a;

/* renamed from: com.google.android.gms.maps.internal.h */
public interface C0532h extends IInterface {

    /* renamed from: com.google.android.gms.maps.internal.h$a */
    public static abstract class C1128a extends Binder implements C0532h {

        /* renamed from: com.google.android.gms.maps.internal.h$a$a */
        private static class C1127a implements C0532h {
            private IBinder le;

            C1127a(IBinder iBinder) {
                this.le = iBinder;
            }

            public IBinder asBinder() {
                return this.le;
            }

            /* renamed from: e */
            public void mo2315e(C0567l c0567l) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnInfoWindowClickListener");
                    obtain.writeStrongBinder(c0567l != null ? c0567l.asBinder() : null);
                    this.le.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C1128a() {
            attachInterface(this, "com.google.android.gms.maps.internal.IOnInfoWindowClickListener");
        }

        public static C0532h bb(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnInfoWindowClickListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0532h)) ? new C1127a(iBinder) : (C0532h) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.maps.internal.IOnInfoWindowClickListener");
                    mo2315e(C1175a.bA(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.maps.internal.IOnInfoWindowClickListener");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: e */
    void mo2315e(C0567l c0567l) throws RemoteException;
}
