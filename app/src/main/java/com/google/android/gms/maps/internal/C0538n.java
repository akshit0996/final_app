package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.internal.C0567l;
import com.google.android.gms.maps.model.internal.C0567l.C1175a;

/* renamed from: com.google.android.gms.maps.internal.n */
public interface C0538n extends IInterface {

    /* renamed from: com.google.android.gms.maps.internal.n$a */
    public static abstract class C1140a extends Binder implements C0538n {

        /* renamed from: com.google.android.gms.maps.internal.n$a$a */
        private static class C1139a implements C0538n {
            private IBinder le;

            C1139a(IBinder iBinder) {
                this.le = iBinder;
            }

            /* renamed from: a */
            public boolean mo2322a(C0567l c0567l) throws RemoteException {
                boolean z = true;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnMarkerClickListener");
                    obtain.writeStrongBinder(c0567l != null ? c0567l.asBinder() : null);
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

            public IBinder asBinder() {
                return this.le;
            }
        }

        public C1140a() {
            attachInterface(this, "com.google.android.gms.maps.internal.IOnMarkerClickListener");
        }

        public static C0538n bh(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnMarkerClickListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0538n)) ? new C1139a(iBinder) : (C0538n) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.maps.internal.IOnMarkerClickListener");
                    boolean a = mo2322a(C1175a.bA(data.readStrongBinder()));
                    reply.writeNoException();
                    reply.writeInt(a ? 1 : 0);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.maps.internal.IOnMarkerClickListener");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: a */
    boolean mo2322a(C0567l c0567l) throws RemoteException;
}
