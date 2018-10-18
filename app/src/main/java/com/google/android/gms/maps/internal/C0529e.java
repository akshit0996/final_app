package com.google.android.gms.maps.internal;

import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.internal.C0567l;
import com.google.android.gms.maps.model.internal.C0567l.C1175a;

/* renamed from: com.google.android.gms.maps.internal.e */
public interface C0529e extends IInterface {

    /* renamed from: com.google.android.gms.maps.internal.e$a */
    public static abstract class C1122a extends Binder implements C0529e {

        /* renamed from: com.google.android.gms.maps.internal.e$a$a */
        private static class C1121a implements C0529e {
            private IBinder le;

            C1121a(IBinder iBinder) {
                this.le = iBinder;
            }

            /* renamed from: a */
            public Bitmap mo2311a(C0567l c0567l, int i, int i2) throws RemoteException {
                Bitmap bitmap = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IInfoWindowRenderer");
                    obtain.writeStrongBinder(c0567l != null ? c0567l.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.le.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        bitmap = (Bitmap) Bitmap.CREATOR.createFromParcel(obtain2);
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return bitmap;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.le;
            }
        }

        public static C0529e aV(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IInfoWindowRenderer");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0529e)) ? new C1121a(iBinder) : (C0529e) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.maps.internal.IInfoWindowRenderer");
                    Bitmap a = mo2311a(C1175a.bA(data.readStrongBinder()), data.readInt(), data.readInt());
                    reply.writeNoException();
                    if (a != null) {
                        reply.writeInt(1);
                        a.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.maps.internal.IInfoWindowRenderer");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: a */
    Bitmap mo2311a(C0567l c0567l, int i, int i2) throws RemoteException;
}
