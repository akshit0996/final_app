package com.google.android.gms.wearable.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

public interface ad extends IInterface {

    /* renamed from: com.google.android.gms.wearable.internal.ad$a */
    public static abstract class C1263a extends Binder implements ad {

        /* renamed from: com.google.android.gms.wearable.internal.ad$a$a */
        private static class C1262a implements ad {
            private IBinder le;

            C1262a(IBinder iBinder) {
                this.le = iBinder;
            }

            /* renamed from: a */
            public void mo2598a(Status status) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (status != null) {
                        obtain.writeInt(1);
                        status.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo2599a(ab abVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (abVar != null) {
                        obtain.writeInt(1);
                        abVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo2600a(ap apVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (apVar != null) {
                        obtain.writeInt(1);
                        apVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo2601a(at atVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (atVar != null) {
                        obtain.writeInt(1);
                        atVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo2602a(aw awVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (awVar != null) {
                        obtain.writeInt(1);
                        awVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo2603a(C1274p c1274p) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (c1274p != null) {
                        obtain.writeInt(1);
                        c1274p.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo2604a(C1275r c1275r) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (c1275r != null) {
                        obtain.writeInt(1);
                        c1275r.writeToParcel(obtain, 0);
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
            public void mo2605a(C1276t c1276t) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (c1276t != null) {
                        obtain.writeInt(1);
                        c1276t.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo2606a(C1277v c1277v) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (c1277v != null) {
                        obtain.writeInt(1);
                        c1277v.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo2607a(C1278x c1278x) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (c1278x != null) {
                        obtain.writeInt(1);
                        c1278x.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo2608a(C1279z c1279z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (c1279z != null) {
                        obtain.writeInt(1);
                        c1279z.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void ab(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(5, obtain, obtain2, 0);
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

        public C1263a() {
            attachInterface(this, "com.google.android.gms.wearable.internal.IWearableCallbacks");
        }

        public static ad bX(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ad)) ? new C1262a(iBinder) : (ad) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            aw awVar = null;
            switch (code) {
                case 2:
                    C1275r c1275r;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (data.readInt() != 0) {
                        c1275r = (C1275r) C1275r.CREATOR.createFromParcel(data);
                    }
                    mo2604a(c1275r);
                    reply.writeNoException();
                    return true;
                case 3:
                    ap apVar;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (data.readInt() != 0) {
                        apVar = (ap) ap.CREATOR.createFromParcel(data);
                    }
                    mo2600a(apVar);
                    reply.writeNoException();
                    return true;
                case 4:
                    C1278x c1278x;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (data.readInt() != 0) {
                        c1278x = (C1278x) C1278x.CREATOR.createFromParcel(data);
                    }
                    mo2607a(c1278x);
                    reply.writeNoException();
                    return true;
                case 5:
                    DataHolder B;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (data.readInt() != 0) {
                        B = DataHolder.CREATOR.m174B(data);
                    }
                    ab(B);
                    reply.writeNoException();
                    return true;
                case 6:
                    C1274p c1274p;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (data.readInt() != 0) {
                        c1274p = (C1274p) C1274p.CREATOR.createFromParcel(data);
                    }
                    mo2603a(c1274p);
                    reply.writeNoException();
                    return true;
                case 7:
                    at atVar;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (data.readInt() != 0) {
                        atVar = (at) at.CREATOR.createFromParcel(data);
                    }
                    mo2601a(atVar);
                    reply.writeNoException();
                    return true;
                case 8:
                    C1279z c1279z;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (data.readInt() != 0) {
                        c1279z = (C1279z) C1279z.CREATOR.createFromParcel(data);
                    }
                    mo2608a(c1279z);
                    reply.writeNoException();
                    return true;
                case 9:
                    ab abVar;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (data.readInt() != 0) {
                        abVar = (ab) ab.CREATOR.createFromParcel(data);
                    }
                    mo2599a(abVar);
                    reply.writeNoException();
                    return true;
                case 10:
                    C1277v c1277v;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (data.readInt() != 0) {
                        c1277v = (C1277v) C1277v.CREATOR.createFromParcel(data);
                    }
                    mo2606a(c1277v);
                    reply.writeNoException();
                    return true;
                case 11:
                    Status createFromParcel;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (data.readInt() != 0) {
                        createFromParcel = Status.CREATOR.createFromParcel(data);
                    }
                    mo2598a(createFromParcel);
                    reply.writeNoException();
                    return true;
                case 12:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (data.readInt() != 0) {
                        awVar = (aw) aw.CREATOR.createFromParcel(data);
                    }
                    mo2602a(awVar);
                    reply.writeNoException();
                    return true;
                case 13:
                    C1276t c1276t;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (data.readInt() != 0) {
                        c1276t = (C1276t) C1276t.CREATOR.createFromParcel(data);
                    }
                    mo2605a(c1276t);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: a */
    void mo2598a(Status status) throws RemoteException;

    /* renamed from: a */
    void mo2599a(ab abVar) throws RemoteException;

    /* renamed from: a */
    void mo2600a(ap apVar) throws RemoteException;

    /* renamed from: a */
    void mo2601a(at atVar) throws RemoteException;

    /* renamed from: a */
    void mo2602a(aw awVar) throws RemoteException;

    /* renamed from: a */
    void mo2603a(C1274p c1274p) throws RemoteException;

    /* renamed from: a */
    void mo2604a(C1275r c1275r) throws RemoteException;

    /* renamed from: a */
    void mo2605a(C1276t c1276t) throws RemoteException;

    /* renamed from: a */
    void mo2606a(C1277v c1277v) throws RemoteException;

    /* renamed from: a */
    void mo2607a(C1278x c1278x) throws RemoteException;

    /* renamed from: a */
    void mo2608a(C1279z c1279z) throws RemoteException;

    void ab(DataHolder dataHolder) throws RemoteException;
}
