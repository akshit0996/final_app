package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.C0272d;
import com.google.android.gms.dynamic.C0272d.C0871a;
import com.google.android.gms.internal.da.C0933a;

public interface cz extends IInterface {

    /* renamed from: com.google.android.gms.internal.cz$a */
    public static abstract class C0931a extends Binder implements cz {

        /* renamed from: com.google.android.gms.internal.cz$a$a */
        private static class C0930a implements cz {
            private IBinder le;

            C0930a(IBinder iBinder) {
                this.le = iBinder;
            }

            /* renamed from: a */
            public void mo1709a(C0272d c0272d, av avVar, String str, da daVar) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    obtain.writeStrongBinder(c0272d != null ? c0272d.asBinder() : null);
                    if (avVar != null) {
                        obtain.writeInt(1);
                        avVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (daVar != null) {
                        iBinder = daVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.le.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1710a(C0272d c0272d, av avVar, String str, String str2, da daVar) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    obtain.writeStrongBinder(c0272d != null ? c0272d.asBinder() : null);
                    if (avVar != null) {
                        obtain.writeInt(1);
                        avVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (daVar != null) {
                        iBinder = daVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.le.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1711a(C0272d c0272d, ay ayVar, av avVar, String str, da daVar) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    obtain.writeStrongBinder(c0272d != null ? c0272d.asBinder() : null);
                    if (ayVar != null) {
                        obtain.writeInt(1);
                        ayVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (avVar != null) {
                        obtain.writeInt(1);
                        avVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (daVar != null) {
                        iBinder = daVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.le.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1712a(C0272d c0272d, ay ayVar, av avVar, String str, String str2, da daVar) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    obtain.writeStrongBinder(c0272d != null ? c0272d.asBinder() : null);
                    if (ayVar != null) {
                        obtain.writeInt(1);
                        ayVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (avVar != null) {
                        obtain.writeInt(1);
                        avVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (daVar != null) {
                        iBinder = daVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.le.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.le;
            }

            public void destroy() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.le.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public C0272d getView() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.le.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    C0272d ap = C0871a.ap(obtain2.readStrongBinder());
                    return ap;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void pause() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.le.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void resume() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.le.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void showInterstitial() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.le.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C0931a() {
            attachInterface(this, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
        }

        /* renamed from: o */
        public static cz m3106o(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof cz)) ? new C0930a(iBinder) : (cz) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            av avVar = null;
            C0272d view;
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    mo1711a(C0871a.ap(data.readStrongBinder()), data.readInt() != 0 ? ay.CREATOR.m1041c(data) : null, data.readInt() != 0 ? av.CREATOR.m1037b(data) : null, data.readString(), C0933a.m3107p(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 2:
                    IBinder asBinder;
                    data.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    view = getView();
                    reply.writeNoException();
                    if (view != null) {
                        asBinder = view.asBinder();
                    }
                    reply.writeStrongBinder(asBinder);
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    view = C0871a.ap(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        avVar = av.CREATOR.m1037b(data);
                    }
                    mo1709a(view, avVar, data.readString(), C0933a.m3107p(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    showInterstitial();
                    reply.writeNoException();
                    return true;
                case 5:
                    data.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    destroy();
                    reply.writeNoException();
                    return true;
                case 6:
                    data.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    mo1712a(C0871a.ap(data.readStrongBinder()), data.readInt() != 0 ? ay.CREATOR.m1041c(data) : null, data.readInt() != 0 ? av.CREATOR.m1037b(data) : null, data.readString(), data.readString(), C0933a.m3107p(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 7:
                    data.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    mo1710a(C0871a.ap(data.readStrongBinder()), data.readInt() != 0 ? av.CREATOR.m1037b(data) : null, data.readString(), data.readString(), C0933a.m3107p(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 8:
                    data.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    pause();
                    reply.writeNoException();
                    return true;
                case 9:
                    data.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    resume();
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: a */
    void mo1709a(C0272d c0272d, av avVar, String str, da daVar) throws RemoteException;

    /* renamed from: a */
    void mo1710a(C0272d c0272d, av avVar, String str, String str2, da daVar) throws RemoteException;

    /* renamed from: a */
    void mo1711a(C0272d c0272d, ay ayVar, av avVar, String str, da daVar) throws RemoteException;

    /* renamed from: a */
    void mo1712a(C0272d c0272d, ay ayVar, av avVar, String str, String str2, da daVar) throws RemoteException;

    void destroy() throws RemoteException;

    C0272d getView() throws RemoteException;

    void pause() throws RemoteException;

    void resume() throws RemoteException;

    void showInterstitial() throws RemoteException;
}
