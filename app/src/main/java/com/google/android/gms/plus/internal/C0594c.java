package com.google.android.gms.plus.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.C0272d;
import com.google.android.gms.dynamic.C0272d.C0871a;

/* renamed from: com.google.android.gms.plus.internal.c */
public interface C0594c extends IInterface {

    /* renamed from: com.google.android.gms.plus.internal.c$a */
    public static abstract class C1198a extends Binder implements C0594c {

        /* renamed from: com.google.android.gms.plus.internal.c$a$a */
        private static class C1197a implements C0594c {
            private IBinder le;

            C1197a(IBinder iBinder) {
                this.le = iBinder;
            }

            /* renamed from: a */
            public C0272d mo2482a(C0272d c0272d, int i, int i2, String str, int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusOneButtonCreator");
                    obtain.writeStrongBinder(c0272d != null ? c0272d.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    obtain.writeInt(i3);
                    this.le.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    C0272d ap = C0871a.ap(obtain2.readStrongBinder());
                    return ap;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public C0272d mo2483a(C0272d c0272d, int i, int i2, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusOneButtonCreator");
                    obtain.writeStrongBinder(c0272d != null ? c0272d.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.le.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    C0272d ap = C0871a.ap(obtain2.readStrongBinder());
                    return ap;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.le;
            }
        }

        public static C0594c bL(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.plus.internal.IPlusOneButtonCreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0594c)) ? new C1197a(iBinder) : (C0594c) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            IBinder iBinder = null;
            C0272d a;
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusOneButtonCreator");
                    a = mo2482a(C0871a.ap(data.readStrongBinder()), data.readInt(), data.readInt(), data.readString(), data.readInt());
                    reply.writeNoException();
                    reply.writeStrongBinder(a != null ? a.asBinder() : null);
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusOneButtonCreator");
                    a = mo2483a(C0871a.ap(data.readStrongBinder()), data.readInt(), data.readInt(), data.readString(), data.readString());
                    reply.writeNoException();
                    if (a != null) {
                        iBinder = a.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.plus.internal.IPlusOneButtonCreator");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: a */
    C0272d mo2482a(C0272d c0272d, int i, int i2, String str, int i3) throws RemoteException;

    /* renamed from: a */
    C0272d mo2483a(C0272d c0272d, int i, int i2, String str, String str2) throws RemoteException;
}
