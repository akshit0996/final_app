package com.google.android.gms.games.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;

public interface IRoomServiceCallbacks extends IInterface {

    public static abstract class Stub extends Binder implements IRoomServiceCallbacks {

        private static class Proxy implements IRoomServiceCallbacks {
            private IBinder le;

            Proxy(IBinder remote) {
                this.le = remote;
            }

            /* renamed from: a */
            public void mo1471a(ParcelFileDescriptor parcelFileDescriptor, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    if (parcelFileDescriptor != null) {
                        obtain.writeInt(1);
                        parcelFileDescriptor.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    this.le.transact(1024, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1472a(ConnectionInfo connectionInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    if (connectionInfo != null) {
                        obtain.writeInt(1);
                        connectionInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(1022, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1473a(String str, byte[] bArr, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    obtain.writeByteArray(bArr);
                    obtain.writeInt(i);
                    this.le.transact(1002, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1474a(String str, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    obtain.writeStringArray(strArr);
                    this.le.transact(1008, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void aG(IBinder iBinder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeStrongBinder(iBinder);
                    this.le.transact(1021, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.le;
            }

            /* renamed from: b */
            public void mo1476b(String str, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    obtain.writeStringArray(strArr);
                    this.le.transact(1009, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void bS(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    this.le.transact(1003, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void bT(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    this.le.transact(1004, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void bU(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    this.le.transact(1005, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void bV(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    this.le.transact(1006, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void bW(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    this.le.transact(1007, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void bX(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    this.le.transact(1019, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo1483c(int i, int i2, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    this.le.transact(1001, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo1484c(String str, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    obtain.writeByteArray(bArr);
                    this.le.transact(1018, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo1485c(String str, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    obtain.writeStringArray(strArr);
                    this.le.transact(1010, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: d */
            public void mo1486d(String str, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    obtain.writeStringArray(strArr);
                    this.le.transact(1011, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void dX(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeInt(i);
                    this.le.transact(1020, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: e */
            public void mo1488e(String str, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    obtain.writeStringArray(strArr);
                    this.le.transact(1012, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: f */
            public void mo1489f(String str, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    obtain.writeStringArray(strArr);
                    this.le.transact(1013, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: g */
            public void mo1490g(String str, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    obtain.writeStringArray(strArr);
                    this.le.transact(1017, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: j */
            public void mo1491j(String str, boolean z) throws RemoteException {
                int i = 1;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    if (!z) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    this.le.transact(1026, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void lR() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    this.le.transact(1016, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void lS() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    this.le.transact(1023, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void onP2PConnected(String participantId) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(participantId);
                    this.le.transact(1014, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void onP2PDisconnected(String participantId) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(participantId);
                    this.le.transact(1015, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: x */
            public void mo1496x(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.le.transact(1025, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.google.android.gms.games.internal.IRoomServiceCallbacks");
        }

        public static IRoomServiceCallbacks aH(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IRoomServiceCallbacks)) ? new Proxy(iBinder) : (IRoomServiceCallbacks) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            ParcelFileDescriptor parcelFileDescriptor = null;
            switch (code) {
                case 1001:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    mo1483c(data.readInt(), data.readInt(), data.readString());
                    return true;
                case 1002:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    mo1473a(data.readString(), data.createByteArray(), data.readInt());
                    return true;
                case 1003:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    bS(data.readString());
                    return true;
                case 1004:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    bT(data.readString());
                    return true;
                case 1005:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    bU(data.readString());
                    return true;
                case 1006:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    bV(data.readString());
                    return true;
                case 1007:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    bW(data.readString());
                    return true;
                case 1008:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    mo1474a(data.readString(), data.createStringArray());
                    return true;
                case 1009:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    mo1476b(data.readString(), data.createStringArray());
                    return true;
                case 1010:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    mo1485c(data.readString(), data.createStringArray());
                    return true;
                case 1011:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    mo1486d(data.readString(), data.createStringArray());
                    return true;
                case 1012:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    mo1488e(data.readString(), data.createStringArray());
                    return true;
                case 1013:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    mo1489f(data.readString(), data.createStringArray());
                    return true;
                case 1014:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    onP2PConnected(data.readString());
                    return true;
                case 1015:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    onP2PDisconnected(data.readString());
                    return true;
                case 1016:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    lR();
                    return true;
                case 1017:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    mo1490g(data.readString(), data.createStringArray());
                    return true;
                case 1018:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    mo1484c(data.readString(), data.createByteArray());
                    return true;
                case 1019:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    bX(data.readString());
                    return true;
                case 1020:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    dX(data.readInt());
                    return true;
                case 1021:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    aG(data.readStrongBinder());
                    return true;
                case 1022:
                    ConnectionInfo ct;
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    if (data.readInt() != 0) {
                        ct = ConnectionInfo.CREATOR.ct(data);
                    }
                    mo1472a(ct);
                    return true;
                case 1023:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    lS();
                    return true;
                case 1024:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    if (data.readInt() != 0) {
                        parcelFileDescriptor = (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(data);
                    }
                    mo1471a(parcelFileDescriptor, data.readInt());
                    return true;
                case 1025:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    mo1496x(data.readString(), data.readInt());
                    return true;
                case 1026:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    mo1491j(data.readString(), data.readInt() != 0);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: a */
    void mo1471a(ParcelFileDescriptor parcelFileDescriptor, int i) throws RemoteException;

    /* renamed from: a */
    void mo1472a(ConnectionInfo connectionInfo) throws RemoteException;

    /* renamed from: a */
    void mo1473a(String str, byte[] bArr, int i) throws RemoteException;

    /* renamed from: a */
    void mo1474a(String str, String[] strArr) throws RemoteException;

    void aG(IBinder iBinder) throws RemoteException;

    /* renamed from: b */
    void mo1476b(String str, String[] strArr) throws RemoteException;

    void bS(String str) throws RemoteException;

    void bT(String str) throws RemoteException;

    void bU(String str) throws RemoteException;

    void bV(String str) throws RemoteException;

    void bW(String str) throws RemoteException;

    void bX(String str) throws RemoteException;

    /* renamed from: c */
    void mo1483c(int i, int i2, String str) throws RemoteException;

    /* renamed from: c */
    void mo1484c(String str, byte[] bArr) throws RemoteException;

    /* renamed from: c */
    void mo1485c(String str, String[] strArr) throws RemoteException;

    /* renamed from: d */
    void mo1486d(String str, String[] strArr) throws RemoteException;

    void dX(int i) throws RemoteException;

    /* renamed from: e */
    void mo1488e(String str, String[] strArr) throws RemoteException;

    /* renamed from: f */
    void mo1489f(String str, String[] strArr) throws RemoteException;

    /* renamed from: g */
    void mo1490g(String str, String[] strArr) throws RemoteException;

    /* renamed from: j */
    void mo1491j(String str, boolean z) throws RemoteException;

    void lR() throws RemoteException;

    void lS() throws RemoteException;

    void onP2PConnected(String str) throws RemoteException;

    void onP2PDisconnected(String str) throws RemoteException;

    /* renamed from: x */
    void mo1496x(String str, int i) throws RemoteException;
}
