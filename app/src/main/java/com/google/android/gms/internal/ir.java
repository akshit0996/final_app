package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.cast.ApplicationMetadata;

public interface ir extends IInterface {

    /* renamed from: com.google.android.gms.internal.ir$a */
    public static abstract class C0993a extends Binder implements ir {
        public C0993a() {
            attachInterface(this, "com.google.android.gms.cast.internal.ICastDeviceControllerListener");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            boolean z = false;
            io ioVar = null;
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    ad(data.readInt());
                    return true;
                case 2:
                    ApplicationMetadata applicationMetadata;
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    if (data.readInt() != 0) {
                        applicationMetadata = (ApplicationMetadata) ApplicationMetadata.CREATOR.createFromParcel(data);
                    }
                    String readString = data.readString();
                    String readString2 = data.readString();
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    mo3333a(applicationMetadata, readString, readString2, z);
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    ae(data.readInt());
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    String readString3 = data.readString();
                    double readDouble = data.readDouble();
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    mo3334a(readString3, readDouble, z);
                    return true;
                case 5:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    mo3344j(data.readString(), data.readString());
                    return true;
                case 6:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    mo3343b(data.readString(), data.createByteArray());
                    return true;
                case 7:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    ag(data.readInt());
                    return true;
                case 8:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    af(data.readInt());
                    return true;
                case 9:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    onApplicationDisconnected(data.readInt());
                    return true;
                case 10:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    mo3336a(data.readString(), data.readLong(), data.readInt());
                    return true;
                case 11:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    mo3335a(data.readString(), data.readLong());
                    return true;
                case 12:
                    ij ijVar;
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    if (data.readInt() != 0) {
                        ijVar = (ij) ij.CREATOR.createFromParcel(data);
                    }
                    mo3341b(ijVar);
                    return true;
                case 13:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    if (data.readInt() != 0) {
                        ioVar = (io) io.CREATOR.createFromParcel(data);
                    }
                    mo3342b(ioVar);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: a */
    void mo3333a(ApplicationMetadata applicationMetadata, String str, String str2, boolean z) throws RemoteException;

    /* renamed from: a */
    void mo3334a(String str, double d, boolean z) throws RemoteException;

    /* renamed from: a */
    void mo3335a(String str, long j) throws RemoteException;

    /* renamed from: a */
    void mo3336a(String str, long j, int i) throws RemoteException;

    void ad(int i) throws RemoteException;

    void ae(int i) throws RemoteException;

    void af(int i) throws RemoteException;

    void ag(int i) throws RemoteException;

    /* renamed from: b */
    void mo3341b(ij ijVar) throws RemoteException;

    /* renamed from: b */
    void mo3342b(io ioVar) throws RemoteException;

    /* renamed from: b */
    void mo3343b(String str, byte[] bArr) throws RemoteException;

    /* renamed from: j */
    void mo3344j(String str, String str2) throws RemoteException;

    void onApplicationDisconnected(int i) throws RemoteException;
}
