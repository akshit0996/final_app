package com.google.android.gms.fitness.request;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.data.BleDevice;

/* renamed from: com.google.android.gms.fitness.request.l */
public interface C0325l extends IInterface {

    /* renamed from: com.google.android.gms.fitness.request.l$a */
    public static abstract class C0881a extends Binder implements C0325l {

        /* renamed from: com.google.android.gms.fitness.request.l$a$a */
        private static class C0880a implements C0325l {
            private IBinder le;

            C0880a(IBinder iBinder) {
                this.le = iBinder;
            }

            public IBinder asBinder() {
                return this.le;
            }

            public void onDeviceFound(BleDevice device) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.request.IBleScanCallback");
                    if (device != null) {
                        obtain.writeInt(1);
                        device.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void onScanStopped() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.request.IBleScanCallback");
                    this.le.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public C0881a() {
            attachInterface(this, "com.google.android.gms.fitness.request.IBleScanCallback");
        }

        public static C0325l aB(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.request.IBleScanCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0325l)) ? new C0880a(iBinder) : (C0325l) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.fitness.request.IBleScanCallback");
                    onDeviceFound(data.readInt() != 0 ? (BleDevice) BleDevice.CREATOR.createFromParcel(data) : null);
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.fitness.request.IBleScanCallback");
                    onScanStopped();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.fitness.request.IBleScanCallback");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void onDeviceFound(BleDevice bleDevice) throws RemoteException;

    void onScanStopped() throws RemoteException;
}
