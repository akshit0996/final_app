package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.kh.C1013a;

public interface ki extends IInterface {

    /* renamed from: com.google.android.gms.internal.ki$a */
    public static abstract class C1015a extends Binder implements ki {

        /* renamed from: com.google.android.gms.internal.ki$a$a */
        private static class C1014a implements ki {
            private IBinder le;

            C1014a(IBinder iBinder) {
                this.le = iBinder;
            }

            /* renamed from: a */
            public void mo1908a(kh khVar) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.service.ICommonService");
                    if (khVar != null) {
                        iBinder = khVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.le.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.le;
            }
        }

        /* renamed from: V */
        public static ki m3372V(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.service.ICommonService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ki)) ? new C1014a(iBinder) : (ki) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.common.internal.service.ICommonService");
                    mo1908a(C1013a.m3370U(data.readStrongBinder()));
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.common.internal.service.ICommonService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: a */
    void mo1908a(kh khVar) throws RemoteException;
}
