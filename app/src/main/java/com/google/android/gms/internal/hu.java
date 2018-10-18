package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.hl.C0977a;
import com.google.android.gms.internal.hv.C0982a;

public interface hu extends IInterface {

    /* renamed from: com.google.android.gms.internal.hu$a */
    public static abstract class C0980a extends Binder implements hu {

        /* renamed from: com.google.android.gms.internal.hu$a$a */
        private static class C0979a implements hu {
            private IBinder le;

            C0979a(IBinder iBinder) {
                this.le = iBinder;
            }

            /* renamed from: a */
            public void mo1805a(C0977a c0977a, hv hvVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    if (c0977a != null) {
                        obtain.writeInt(1);
                        c0977a.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(hvVar != null ? hvVar.asBinder() : null);
                    this.le.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1806a(hv hvVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    obtain.writeStrongBinder(hvVar != null ? hvVar.asBinder() : null);
                    this.le.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1807a(hv hvVar, String str, hr[] hrVarArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    obtain.writeStrongBinder(hvVar != null ? hvVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeTypedArray(hrVarArr, 0);
                    this.le.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1808a(hv hvVar, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    obtain.writeStrongBinder(hvVar != null ? hvVar.asBinder() : null);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.le.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.le;
            }

            /* renamed from: b */
            public void mo1809b(hv hvVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    obtain.writeStrongBinder(hvVar != null ? hvVar.asBinder() : null);
                    this.le.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        /* renamed from: E */
        public static hu m3241E(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof hu)) ? new C0979a(iBinder) : (hu) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    mo1807a(C0982a.m3246F(data.readStrongBinder()), data.readString(), (hr[]) data.createTypedArray(hr.CREATOR));
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    mo1806a(C0982a.m3246F(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    mo1809b(C0982a.m3246F(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    mo1808a(C0982a.m3246F(data.readStrongBinder()), data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                case 5:
                    data.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    mo1805a(data.readInt() != 0 ? C0977a.CREATOR.m1399p(data) : null, C0982a.m3246F(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: a */
    void mo1805a(C0977a c0977a, hv hvVar) throws RemoteException;

    /* renamed from: a */
    void mo1806a(hv hvVar) throws RemoteException;

    /* renamed from: a */
    void mo1807a(hv hvVar, String str, hr[] hrVarArr) throws RemoteException;

    /* renamed from: a */
    void mo1808a(hv hvVar, boolean z) throws RemoteException;

    /* renamed from: b */
    void mo1809b(hv hvVar) throws RemoteException;
}
