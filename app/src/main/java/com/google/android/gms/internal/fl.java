package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface fl extends IInterface {

    /* renamed from: com.google.android.gms.internal.fl$a */
    public static abstract class C0966a extends Binder implements fl {

        /* renamed from: com.google.android.gms.internal.fl$a$a */
        private static class C0965a implements fl {
            private IBinder le;

            C0965a(IBinder iBinder) {
                this.le = iBinder;
            }

            public IBinder asBinder() {
                return this.le;
            }

            /* renamed from: b */
            public fj mo1792b(fh fhVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.request.IAdRequestService");
                    if (fhVar != null) {
                        obtain.writeInt(1);
                        fhVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    fj i = obtain2.readInt() != 0 ? fj.CREATOR.m1213i(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return i;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C0966a() {
            attachInterface(this, "com.google.android.gms.ads.internal.request.IAdRequestService");
        }

        /* renamed from: C */
        public static fl m3176C(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof fl)) ? new C0965a(iBinder) : (fl) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
                    fj b = mo1792b(data.readInt() != 0 ? fh.CREATOR.m1210h(data) : null);
                    reply.writeNoException();
                    if (b != null) {
                        reply.writeInt(1);
                        b.writeToParcel(reply, 1);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.ads.internal.request.IAdRequestService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: b */
    fj mo1792b(fh fhVar) throws RemoteException;
}
