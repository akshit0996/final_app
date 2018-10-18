package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ih extends IInterface {

    /* renamed from: com.google.android.gms.internal.ih$a */
    public static abstract class C0990a extends Binder implements ih {

        /* renamed from: com.google.android.gms.internal.ih$a$a */
        private static class C0989a implements ih {
            private IBinder le;

            C0989a(IBinder iBinder) {
                this.le = iBinder;
            }

            /* renamed from: a */
            public void mo1835a(int i, String str, PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.api.IGoogleAuthApiCallbacks");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1836a(C0988if c0988if) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.api.IGoogleAuthApiCallbacks");
                    if (c0988if != null) {
                        obtain.writeInt(1);
                        c0988if.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
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

        public C0990a() {
            attachInterface(this, "com.google.android.gms.auth.api.IGoogleAuthApiCallbacks");
        }

        /* renamed from: K */
        public static ih m3266K(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.IGoogleAuthApiCallbacks");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ih)) ? new C0989a(iBinder) : (ih) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            PendingIntent pendingIntent = null;
            switch (code) {
                case 1:
                    C0988if t;
                    data.enforceInterface("com.google.android.gms.auth.api.IGoogleAuthApiCallbacks");
                    if (data.readInt() != 0) {
                        t = C0988if.CREATOR.m1439t(data);
                    }
                    mo1836a(t);
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.auth.api.IGoogleAuthApiCallbacks");
                    int readInt = data.readInt();
                    String readString = data.readString();
                    if (data.readInt() != 0) {
                        pendingIntent = (PendingIntent) PendingIntent.CREATOR.createFromParcel(data);
                    }
                    mo1835a(readInt, readString, pendingIntent);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.auth.api.IGoogleAuthApiCallbacks");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: a */
    void mo1835a(int i, String str, PendingIntent pendingIntent) throws RemoteException;

    /* renamed from: a */
    void mo1836a(C0988if c0988if) throws RemoteException;
}
