package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.C0272d;
import com.google.android.gms.dynamic.C0272d.C0871a;
import com.google.android.gms.internal.cy.C0929a;

public interface be extends IInterface {

    /* renamed from: com.google.android.gms.internal.be$a */
    public static abstract class C0908a extends Binder implements be {

        /* renamed from: com.google.android.gms.internal.be$a$a */
        private static class C0907a implements be {
            private IBinder le;

            C0907a(IBinder iBinder) {
                this.le = iBinder;
            }

            /* renamed from: a */
            public IBinder mo1695a(C0272d c0272d, ay ayVar, String str, cy cyVar, int i) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManagerCreator");
                    obtain.writeStrongBinder(c0272d != null ? c0272d.asBinder() : null);
                    if (ayVar != null) {
                        obtain.writeInt(1);
                        ayVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (cyVar != null) {
                        iBinder = cyVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    this.le.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    iBinder = obtain2.readStrongBinder();
                    return iBinder;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.le;
            }
        }

        /* renamed from: g */
        public static be m3063g(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof be)) ? new C0907a(iBinder) : (be) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
                    IBinder a = mo1695a(C0871a.ap(data.readStrongBinder()), data.readInt() != 0 ? ay.CREATOR.m1041c(data) : null, data.readString(), C0929a.m3101n(data.readStrongBinder()), data.readInt());
                    reply.writeNoException();
                    reply.writeStrongBinder(a);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.ads.internal.client.IAdManagerCreator");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: a */
    IBinder mo1695a(C0272d c0272d, ay ayVar, String str, cy cyVar, int i) throws RemoteException;
}
