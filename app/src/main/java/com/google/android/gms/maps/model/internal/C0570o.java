package com.google.android.gms.maps.model.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.Tile;

/* renamed from: com.google.android.gms.maps.model.internal.o */
public interface C0570o extends IInterface {

    /* renamed from: com.google.android.gms.maps.model.internal.o$a */
    public static abstract class C1181a extends Binder implements C0570o {

        /* renamed from: com.google.android.gms.maps.model.internal.o$a$a */
        private static class C1180a implements C0570o {
            private IBinder le;

            C1180a(IBinder iBinder) {
                this.le = iBinder;
            }

            public IBinder asBinder() {
                return this.le;
            }

            public Tile getTile(int x, int y, int zoom) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.ITileProviderDelegate");
                    obtain.writeInt(x);
                    obtain.writeInt(y);
                    obtain.writeInt(zoom);
                    this.le.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    Tile dm = obtain2.readInt() != 0 ? Tile.CREATOR.dm(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return dm;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C1181a() {
            attachInterface(this, "com.google.android.gms.maps.model.internal.ITileProviderDelegate");
        }

        public static C0570o bE(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.ITileProviderDelegate");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0570o)) ? new C1180a(iBinder) : (C0570o) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.ITileProviderDelegate");
                    Tile tile = getTile(data.readInt(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    if (tile != null) {
                        reply.writeInt(1);
                        tile.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.maps.model.internal.ITileProviderDelegate");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    Tile getTile(int i, int i2, int i3) throws RemoteException;
}
