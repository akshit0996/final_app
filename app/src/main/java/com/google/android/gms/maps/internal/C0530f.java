package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.CameraPosition;

/* renamed from: com.google.android.gms.maps.internal.f */
public interface C0530f extends IInterface {

    /* renamed from: com.google.android.gms.maps.internal.f$a */
    public static abstract class C1124a extends Binder implements C0530f {

        /* renamed from: com.google.android.gms.maps.internal.f$a$a */
        private static class C1123a implements C0530f {
            private IBinder le;

            C1123a(IBinder iBinder) {
                this.le = iBinder;
            }

            public IBinder asBinder() {
                return this.le;
            }

            public void onCameraChange(CameraPosition position) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnCameraChangeListener");
                    if (position != null) {
                        obtain.writeInt(1);
                        position.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C1124a() {
            attachInterface(this, "com.google.android.gms.maps.internal.IOnCameraChangeListener");
        }

        public static C0530f aZ(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnCameraChangeListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0530f)) ? new C1123a(iBinder) : (C0530f) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.maps.internal.IOnCameraChangeListener");
                    onCameraChange(data.readInt() != 0 ? CameraPosition.CREATOR.da(data) : null);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.maps.internal.IOnCameraChangeListener");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void onCameraChange(CameraPosition cameraPosition) throws RemoteException;
}
