package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface bf extends IInterface {

    /* renamed from: com.google.android.gms.internal.bf$a */
    public static abstract class C0910a extends Binder implements bf {

        /* renamed from: com.google.android.gms.internal.bf$a$a */
        private static class C0909a implements bf {
            private IBinder le;

            C0909a(IBinder iBinder) {
                this.le = iBinder;
            }

            public IBinder asBinder() {
                return this.le;
            }

            public void onAppEvent(String name, String info) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAppEventListener");
                    obtain.writeString(name);
                    obtain.writeString(info);
                    this.le.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C0910a() {
            attachInterface(this, "com.google.android.gms.ads.internal.client.IAppEventListener");
        }

        /* renamed from: h */
        public static bf m3064h(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAppEventListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof bf)) ? new C0909a(iBinder) : (bf) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.ads.internal.client.IAppEventListener");
                    onAppEvent(data.readString(), data.readString());
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.ads.internal.client.IAppEventListener");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void onAppEvent(String str, String str2) throws RemoteException;
}
