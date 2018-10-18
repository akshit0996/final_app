package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.internal.C0565j;
import com.google.android.gms.maps.model.internal.C0565j.C1171a;

/* renamed from: com.google.android.gms.maps.internal.g */
public interface C0531g extends IInterface {

    /* renamed from: com.google.android.gms.maps.internal.g$a */
    public static abstract class C1126a extends Binder implements C0531g {

        /* renamed from: com.google.android.gms.maps.internal.g$a$a */
        private static class C1125a implements C0531g {
            private IBinder le;

            C1125a(IBinder iBinder) {
                this.le = iBinder;
            }

            /* renamed from: a */
            public void mo2313a(C0565j c0565j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
                    obtain.writeStrongBinder(c0565j != null ? c0565j.asBinder() : null);
                    this.le.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.le;
            }

            public void onIndoorBuildingFocused() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
                    this.le.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C1126a() {
            attachInterface(this, "com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
        }

        public static C0531g ba(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0531g)) ? new C1125a(iBinder) : (C0531g) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
                    onIndoorBuildingFocused();
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
                    mo2313a(C1171a.by(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: a */
    void mo2313a(C0565j c0565j) throws RemoteException;

    void onIndoorBuildingFocused() throws RemoteException;
}
