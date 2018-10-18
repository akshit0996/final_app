package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.qe.C1072a;
import com.google.android.gms.internal.qf.C1074a;
import com.google.android.gms.wallet.C1247d;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;

public interface qc extends IInterface {

    /* renamed from: com.google.android.gms.internal.qc$a */
    public static abstract class C1068a extends Binder implements qc {

        /* renamed from: com.google.android.gms.internal.qc$a$a */
        private static class C1067a implements qc {
            private IBinder le;

            C1067a(IBinder iBinder) {
                this.le = iBinder;
            }

            /* renamed from: a */
            public void mo2091a(Bundle bundle, qf qfVar) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (qfVar != null) {
                        iBinder = qfVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.le.transact(5, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo2092a(pw pwVar, Bundle bundle, qf qfVar) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (pwVar != null) {
                        obtain.writeInt(1);
                        pwVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (qfVar != null) {
                        iBinder = qfVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.le.transact(8, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo2093a(FullWalletRequest fullWalletRequest, Bundle bundle, qf qfVar) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (fullWalletRequest != null) {
                        obtain.writeInt(1);
                        fullWalletRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (qfVar != null) {
                        iBinder = qfVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.le.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo2094a(MaskedWalletRequest maskedWalletRequest, Bundle bundle, qe qeVar) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (maskedWalletRequest != null) {
                        obtain.writeInt(1);
                        maskedWalletRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (qeVar != null) {
                        iBinder = qeVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.le.transact(7, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo2095a(MaskedWalletRequest maskedWalletRequest, Bundle bundle, qf qfVar) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (maskedWalletRequest != null) {
                        obtain.writeInt(1);
                        maskedWalletRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (qfVar != null) {
                        iBinder = qfVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.le.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo2096a(NotifyTransactionStatusRequest notifyTransactionStatusRequest, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (notifyTransactionStatusRequest != null) {
                        obtain.writeInt(1);
                        notifyTransactionStatusRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo2097a(C1247d c1247d, Bundle bundle, qf qfVar) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (c1247d != null) {
                        obtain.writeInt(1);
                        c1247d.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (qfVar != null) {
                        iBinder = qfVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.le.transact(6, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo2098a(String str, String str2, Bundle bundle, qf qfVar) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (qfVar != null) {
                        iBinder = qfVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.le.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.le;
            }

            /* renamed from: r */
            public void mo2099r(Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(9, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: s */
            public void mo2100s(Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(10, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static qc bR(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wallet.internal.IOwService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof qc)) ? new C1067a(iBinder) : (qc) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    mo2095a(data.readInt() != 0 ? (MaskedWalletRequest) MaskedWalletRequest.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null, C1074a.bU(data.readStrongBinder()));
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    mo2093a(data.readInt() != 0 ? (FullWalletRequest) FullWalletRequest.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null, C1074a.bU(data.readStrongBinder()));
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    mo2098a(data.readString(), data.readString(), data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null, C1074a.bU(data.readStrongBinder()));
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    mo2096a(data.readInt() != 0 ? (NotifyTransactionStatusRequest) NotifyTransactionStatusRequest.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                    return true;
                case 5:
                    data.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    mo2091a(data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null, C1074a.bU(data.readStrongBinder()));
                    return true;
                case 6:
                    data.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    mo2097a(data.readInt() != 0 ? (C1247d) C1247d.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null, C1074a.bU(data.readStrongBinder()));
                    return true;
                case 7:
                    data.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    mo2094a(data.readInt() != 0 ? (MaskedWalletRequest) MaskedWalletRequest.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null, C1072a.bT(data.readStrongBinder()));
                    return true;
                case 8:
                    data.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    mo2092a(data.readInt() != 0 ? (pw) pw.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null, C1074a.bU(data.readStrongBinder()));
                    return true;
                case 9:
                    data.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    mo2099r(data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                    return true;
                case 10:
                    data.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    mo2100s(data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.wallet.internal.IOwService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: a */
    void mo2091a(Bundle bundle, qf qfVar) throws RemoteException;

    /* renamed from: a */
    void mo2092a(pw pwVar, Bundle bundle, qf qfVar) throws RemoteException;

    /* renamed from: a */
    void mo2093a(FullWalletRequest fullWalletRequest, Bundle bundle, qf qfVar) throws RemoteException;

    /* renamed from: a */
    void mo2094a(MaskedWalletRequest maskedWalletRequest, Bundle bundle, qe qeVar) throws RemoteException;

    /* renamed from: a */
    void mo2095a(MaskedWalletRequest maskedWalletRequest, Bundle bundle, qf qfVar) throws RemoteException;

    /* renamed from: a */
    void mo2096a(NotifyTransactionStatusRequest notifyTransactionStatusRequest, Bundle bundle) throws RemoteException;

    /* renamed from: a */
    void mo2097a(C1247d c1247d, Bundle bundle, qf qfVar) throws RemoteException;

    /* renamed from: a */
    void mo2098a(String str, String str2, Bundle bundle, qf qfVar) throws RemoteException;

    /* renamed from: r */
    void mo2099r(Bundle bundle) throws RemoteException;

    /* renamed from: s */
    void mo2100s(Bundle bundle) throws RemoteException;
}
