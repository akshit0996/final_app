package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.cz.C0931a;

public interface cy extends IInterface {

    /* renamed from: com.google.android.gms.internal.cy$a */
    public static abstract class C0929a extends Binder implements cy {

        /* renamed from: com.google.android.gms.internal.cy$a$a */
        private static class C0928a implements cy {
            private IBinder le;

            C0928a(IBinder iBinder) {
                this.le = iBinder;
            }

            public IBinder asBinder() {
                return this.le;
            }

            /* renamed from: x */
            public cz mo1707x(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
                    obtain.writeString(str);
                    this.le.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    cz o = C0931a.m3106o(obtain2.readStrongBinder());
                    return o;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: y */
            public boolean mo1708y(String str) throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
                    obtain.writeString(str);
                    this.le.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
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

        public C0929a() {
            attachInterface(this, "com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
        }

        /* renamed from: n */
        public static cy m3101n(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof cy)) ? new C0928a(iBinder) : (cy) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
                    cz x = mo1707x(data.readString());
                    reply.writeNoException();
                    reply.writeStrongBinder(x != null ? x.asBinder() : null);
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
                    boolean y = mo1708y(data.readString());
                    reply.writeNoException();
                    reply.writeInt(y ? 1 : 0);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: x */
    cz mo1707x(String str) throws RemoteException;

    /* renamed from: y */
    boolean mo1708y(String str) throws RemoteException;
}
