package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.hl.C0978b;

public interface hv extends IInterface {

    /* renamed from: com.google.android.gms.internal.hv$a */
    public static abstract class C0982a extends Binder implements hv {

        /* renamed from: com.google.android.gms.internal.hv$a$a */
        private static class C0981a implements hv {
            private IBinder le;

            C0981a(IBinder iBinder) {
                this.le = iBinder;
            }

            /* renamed from: a */
            public void mo1810a(Status status) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearchCallbacks");
                    if (status != null) {
                        obtain.writeInt(1);
                        status.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1811a(Status status, ParcelFileDescriptor parcelFileDescriptor) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearchCallbacks");
                    if (status != null) {
                        obtain.writeInt(1);
                        status.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (parcelFileDescriptor != null) {
                        obtain.writeInt(1);
                        parcelFileDescriptor.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1812a(Status status, boolean z) throws RemoteException {
                int i = 1;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearchCallbacks");
                    if (status != null) {
                        obtain.writeInt(1);
                        status.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!z) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    this.le.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1813a(C0978b c0978b) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearchCallbacks");
                    if (c0978b != null) {
                        obtain.writeInt(1);
                        c0978b.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.le;
            }
        }

        public C0982a() {
            attachInterface(this, "com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearchCallbacks");
        }

        /* renamed from: F */
        public static hv m3246F(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearchCallbacks");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof hv)) ? new C0981a(iBinder) : (hv) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            C0978b c0978b = null;
            Status createFromParcel;
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearchCallbacks");
                    if (data.readInt() != 0) {
                        createFromParcel = Status.CREATOR.createFromParcel(data);
                    }
                    mo1810a(createFromParcel);
                    return true;
                case 2:
                    ParcelFileDescriptor parcelFileDescriptor;
                    data.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearchCallbacks");
                    Status createFromParcel2 = data.readInt() != 0 ? Status.CREATOR.createFromParcel(data) : null;
                    if (data.readInt() != 0) {
                        parcelFileDescriptor = (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(data);
                    }
                    mo1811a(createFromParcel2, parcelFileDescriptor);
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearchCallbacks");
                    if (data.readInt() != 0) {
                        createFromParcel = Status.CREATOR.createFromParcel(data);
                    }
                    mo1812a(createFromParcel, data.readInt() != 0);
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearchCallbacks");
                    if (data.readInt() != 0) {
                        c0978b = C0978b.CREATOR.m1402q(data);
                    }
                    mo1813a(c0978b);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearchCallbacks");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: a */
    void mo1810a(Status status) throws RemoteException;

    /* renamed from: a */
    void mo1811a(Status status, ParcelFileDescriptor parcelFileDescriptor) throws RemoteException;

    /* renamed from: a */
    void mo1812a(Status status, boolean z) throws RemoteException;

    /* renamed from: a */
    void mo1813a(C0978b c0978b) throws RemoteException;
}
