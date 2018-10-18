package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.fitness.FitnessStatusCodes;

public interface ic extends IInterface {

    /* renamed from: com.google.android.gms.internal.ic$a */
    public static abstract class C0985a extends Binder implements ic {

        /* renamed from: com.google.android.gms.internal.ic$a$a */
        private static class C0984a implements ic {
            private IBinder le;

            C0984a(IBinder iBinder) {
                this.le = iBinder;
            }

            /* renamed from: T */
            public void mo1821T(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateCallbacks");
                    obtain.writeInt(i);
                    this.le.transact(FitnessStatusCodes.UNKNOWN_AUTH_ERROR, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1822a(int i, DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateCallbacks");
                    obtain.writeInt(i);
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(FitnessStatusCodes.CONFLICTING_DATA_TYPE, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1823a(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(FitnessStatusCodes.INCONSISTENT_DATA_TYPE, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.le;
            }

            /* renamed from: e */
            public void mo1824e(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateCallbacks");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.le.transact(FitnessStatusCodes.DATA_TYPE_NOT_FOUND, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void fK() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateCallbacks");
                    this.le.transact(FitnessStatusCodes.APP_MISMATCH, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C0985a() {
            attachInterface(this, "com.google.android.gms.appstate.internal.IAppStateCallbacks");
        }

        /* renamed from: I */
        public static ic m3255I(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.appstate.internal.IAppStateCallbacks");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ic)) ? new C0984a(iBinder) : (ic) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            DataHolder dataHolder = null;
            switch (code) {
                case FitnessStatusCodes.CONFLICTING_DATA_TYPE /*5001*/:
                    data.enforceInterface("com.google.android.gms.appstate.internal.IAppStateCallbacks");
                    int readInt = data.readInt();
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m174B(data);
                    }
                    mo1822a(readInt, dataHolder);
                    reply.writeNoException();
                    return true;
                case FitnessStatusCodes.INCONSISTENT_DATA_TYPE /*5002*/:
                    data.enforceInterface("com.google.android.gms.appstate.internal.IAppStateCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m174B(data);
                    }
                    mo1823a(dataHolder);
                    reply.writeNoException();
                    return true;
                case FitnessStatusCodes.DATA_TYPE_NOT_FOUND /*5003*/:
                    data.enforceInterface("com.google.android.gms.appstate.internal.IAppStateCallbacks");
                    mo1824e(data.readInt(), data.readInt());
                    reply.writeNoException();
                    return true;
                case FitnessStatusCodes.APP_MISMATCH /*5004*/:
                    data.enforceInterface("com.google.android.gms.appstate.internal.IAppStateCallbacks");
                    fK();
                    reply.writeNoException();
                    return true;
                case FitnessStatusCodes.UNKNOWN_AUTH_ERROR /*5005*/:
                    data.enforceInterface("com.google.android.gms.appstate.internal.IAppStateCallbacks");
                    mo1821T(data.readInt());
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.appstate.internal.IAppStateCallbacks");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: T */
    void mo1821T(int i) throws RemoteException;

    /* renamed from: a */
    void mo1822a(int i, DataHolder dataHolder) throws RemoteException;

    /* renamed from: a */
    void mo1823a(DataHolder dataHolder) throws RemoteException;

    /* renamed from: e */
    void mo1824e(int i, int i2) throws RemoteException;

    void fK() throws RemoteException;
}
