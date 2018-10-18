package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

public interface oq extends IInterface {

    /* renamed from: com.google.android.gms.internal.oq$a */
    public static abstract class C1061a extends Binder implements oq {

        /* renamed from: com.google.android.gms.internal.oq$a$a */
        private static class C1060a implements oq {
            private IBinder le;

            C1060a(IBinder iBinder) {
                this.le = iBinder;
            }

            /* renamed from: a */
            public void mo2054a(String str, ov ovVar, or orVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.playlog.internal.IPlayLogService");
                    obtain.writeString(str);
                    if (ovVar != null) {
                        obtain.writeInt(1);
                        ovVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (orVar != null) {
                        obtain.writeInt(1);
                        orVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo2055a(String str, ov ovVar, List<or> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.playlog.internal.IPlayLogService");
                    obtain.writeString(str);
                    if (ovVar != null) {
                        obtain.writeInt(1);
                        ovVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeTypedList(list);
                    this.le.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo2056a(String str, ov ovVar, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.playlog.internal.IPlayLogService");
                    obtain.writeString(str);
                    if (ovVar != null) {
                        obtain.writeInt(1);
                        ovVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeByteArray(bArr);
                    this.le.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.le;
            }
        }

        public static oq bI(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.playlog.internal.IPlayLogService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof oq)) ? new C1060a(iBinder) : (oq) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            ov ovVar = null;
            String readString;
            switch (code) {
                case 2:
                    or dt;
                    data.enforceInterface("com.google.android.gms.playlog.internal.IPlayLogService");
                    String readString2 = data.readString();
                    ov du = data.readInt() != 0 ? ov.CREATOR.du(data) : null;
                    if (data.readInt() != 0) {
                        dt = or.CREATOR.dt(data);
                    }
                    mo2054a(readString2, du, dt);
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.playlog.internal.IPlayLogService");
                    readString = data.readString();
                    if (data.readInt() != 0) {
                        ovVar = ov.CREATOR.du(data);
                    }
                    mo2055a(readString, ovVar, data.createTypedArrayList(or.CREATOR));
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.playlog.internal.IPlayLogService");
                    readString = data.readString();
                    if (data.readInt() != 0) {
                        ovVar = ov.CREATOR.du(data);
                    }
                    mo2056a(readString, ovVar, data.createByteArray());
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.playlog.internal.IPlayLogService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: a */
    void mo2054a(String str, ov ovVar, or orVar) throws RemoteException;

    /* renamed from: a */
    void mo2055a(String str, ov ovVar, List<or> list) throws RemoteException;

    /* renamed from: a */
    void mo2056a(String str, ov ovVar, byte[] bArr) throws RemoteException;
}
