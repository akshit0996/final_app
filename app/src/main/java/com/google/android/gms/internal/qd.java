package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.C0271c;
import com.google.android.gms.dynamic.C0271c.C0869a;
import com.google.android.gms.dynamic.C0272d;
import com.google.android.gms.dynamic.C0272d.C0871a;
import com.google.android.gms.internal.qa.C1064a;
import com.google.android.gms.internal.qb.C1066a;
import com.google.android.gms.wallet.fragment.WalletFragmentOptions;

public interface qd extends IInterface {

    /* renamed from: com.google.android.gms.internal.qd$a */
    public static abstract class C1070a extends Binder implements qd {

        /* renamed from: com.google.android.gms.internal.qd$a$a */
        private static class C1069a implements qd {
            private IBinder le;

            C1069a(IBinder iBinder) {
                this.le = iBinder;
            }

            /* renamed from: a */
            public qa mo2101a(C0272d c0272d, C0271c c0271c, WalletFragmentOptions walletFragmentOptions, qb qbVar) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IWalletDynamiteCreator");
                    obtain.writeStrongBinder(c0272d != null ? c0272d.asBinder() : null);
                    obtain.writeStrongBinder(c0271c != null ? c0271c.asBinder() : null);
                    if (walletFragmentOptions != null) {
                        obtain.writeInt(1);
                        walletFragmentOptions.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (qbVar != null) {
                        iBinder = qbVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.le.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    qa bP = C1064a.bP(obtain2.readStrongBinder());
                    return bP;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.le;
            }
        }

        public static qd bS(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wallet.internal.IWalletDynamiteCreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof qd)) ? new C1069a(iBinder) : (qd) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            IBinder iBinder = null;
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.wallet.internal.IWalletDynamiteCreator");
                    qa a = mo2101a(C0871a.ap(data.readStrongBinder()), C0869a.ao(data.readStrongBinder()), data.readInt() != 0 ? (WalletFragmentOptions) WalletFragmentOptions.CREATOR.createFromParcel(data) : null, C1066a.bQ(data.readStrongBinder()));
                    reply.writeNoException();
                    if (a != null) {
                        iBinder = a.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.wallet.internal.IWalletDynamiteCreator");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: a */
    qa mo2101a(C0272d c0272d, C0271c c0271c, WalletFragmentOptions walletFragmentOptions, qb qbVar) throws RemoteException;
}
