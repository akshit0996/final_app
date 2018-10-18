package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v4.util.TimeUtils;
import com.google.android.gms.fitness.request.C0877b;
import com.google.android.gms.fitness.request.C0878e;
import com.google.android.gms.fitness.request.C0879j;
import com.google.android.gms.fitness.request.C0882m;
import com.google.android.gms.fitness.request.C0883o;
import com.google.android.gms.fitness.request.C0884q;
import com.google.android.gms.fitness.request.C0885u;
import com.google.android.gms.fitness.request.C0886w;
import com.google.android.gms.fitness.request.C0887y;
import com.google.android.gms.fitness.request.DataDeleteRequest;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.request.DataSourcesRequest;
import com.google.android.gms.fitness.request.DataTypeCreateRequest;
import com.google.android.gms.fitness.request.SessionInsertRequest;
import com.google.android.gms.fitness.request.SessionReadRequest;
import com.google.android.gms.fitness.request.StartBleScanRequest;
import com.google.android.gms.fitness.request.aa;
import com.google.android.gms.fitness.request.ad;
import com.google.android.gms.fitness.request.af;
import com.google.android.gms.fitness.request.ah;
import com.google.android.gms.fitness.request.aj;
import com.google.android.gms.internal.lw.C1021a;
import com.google.android.gms.internal.lx.C1023a;
import com.google.android.gms.internal.ly.C1025a;
import com.google.android.gms.internal.ma.C1029a;
import com.google.android.gms.internal.mb.C1031a;
import com.google.android.gms.internal.mc.C1033a;
import com.google.android.gms.internal.md.C1035a;
import com.google.android.gms.internal.mp.C1038a;

public interface lz extends IInterface {

    /* renamed from: com.google.android.gms.internal.lz$a */
    public static abstract class C1027a extends Binder implements lz {

        /* renamed from: com.google.android.gms.internal.lz$a$a */
        private static class C1026a implements lz {
            private IBinder le;

            C1026a(IBinder iBinder) {
                this.le = iBinder;
            }

            /* renamed from: a */
            public void mo1921a(DataDeleteRequest dataDeleteRequest, md mdVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (dataDeleteRequest != null) {
                        obtain.writeInt(1);
                        dataDeleteRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(mdVar != null ? mdVar.asBinder() : null);
                    obtain.writeString(str);
                    this.le.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1922a(DataReadRequest dataReadRequest, lw lwVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (dataReadRequest != null) {
                        obtain.writeInt(1);
                        dataReadRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (lwVar != null) {
                        iBinder = lwVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.le.transact(8, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1923a(DataSourcesRequest dataSourcesRequest, lx lxVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (dataSourcesRequest != null) {
                        obtain.writeInt(1);
                        dataSourcesRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (lxVar != null) {
                        iBinder = lxVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.le.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1924a(DataTypeCreateRequest dataTypeCreateRequest, ly lyVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (dataTypeCreateRequest != null) {
                        obtain.writeInt(1);
                        dataTypeCreateRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (lyVar != null) {
                        iBinder = lyVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.le.transact(13, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1925a(SessionInsertRequest sessionInsertRequest, md mdVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (sessionInsertRequest != null) {
                        obtain.writeInt(1);
                        sessionInsertRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (mdVar != null) {
                        iBinder = mdVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.le.transact(9, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1926a(SessionReadRequest sessionReadRequest, mb mbVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (sessionReadRequest != null) {
                        obtain.writeInt(1);
                        sessionReadRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (mbVar != null) {
                        iBinder = mbVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.le.transact(10, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1927a(StartBleScanRequest startBleScanRequest, md mdVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (startBleScanRequest != null) {
                        obtain.writeInt(1);
                        startBleScanRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (mdVar != null) {
                        iBinder = mdVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.le.transact(15, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1928a(aa aaVar, md mdVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (aaVar != null) {
                        obtain.writeInt(1);
                        aaVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (mdVar != null) {
                        iBinder = mdVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.le.transact(21, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1929a(ad adVar, md mdVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (adVar != null) {
                        obtain.writeInt(1);
                        adVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (mdVar != null) {
                        iBinder = mdVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.le.transact(16, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1930a(af afVar, md mdVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (afVar != null) {
                        obtain.writeInt(1);
                        afVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (mdVar != null) {
                        iBinder = mdVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.le.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1931a(ah ahVar, md mdVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (ahVar != null) {
                        obtain.writeInt(1);
                        ahVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (mdVar != null) {
                        iBinder = mdVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.le.transact(18, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1932a(aj ajVar, md mdVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (ajVar != null) {
                        obtain.writeInt(1);
                        ajVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (mdVar != null) {
                        iBinder = mdVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.le.transact(5, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1933a(C0877b c0877b, md mdVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (c0877b != null) {
                        obtain.writeInt(1);
                        c0877b.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (mdVar != null) {
                        iBinder = mdVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.le.transact(17, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1934a(C0878e c0878e, md mdVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (c0878e != null) {
                        obtain.writeInt(1);
                        c0878e.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (mdVar != null) {
                        iBinder = mdVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.le.transact(7, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1935a(C0879j c0879j, ly lyVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (c0879j != null) {
                        obtain.writeInt(1);
                        c0879j.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (lyVar != null) {
                        iBinder = lyVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.le.transact(14, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1936a(C0882m c0882m, ma maVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (c0882m != null) {
                        obtain.writeInt(1);
                        c0882m.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (maVar != null) {
                        iBinder = maVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.le.transact(6, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1937a(C0883o c0883o, md mdVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (c0883o != null) {
                        obtain.writeInt(1);
                        c0883o.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (mdVar != null) {
                        iBinder = mdVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.le.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1938a(C0884q c0884q, md mdVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (c0884q != null) {
                        obtain.writeInt(1);
                        c0884q.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (mdVar != null) {
                        iBinder = mdVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.le.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1939a(C0885u c0885u, md mdVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (c0885u != null) {
                        obtain.writeInt(1);
                        c0885u.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (mdVar != null) {
                        iBinder = mdVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.le.transact(20, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1940a(C0886w c0886w, md mdVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (c0886w != null) {
                        obtain.writeInt(1);
                        c0886w.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (mdVar != null) {
                        iBinder = mdVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.le.transact(11, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1941a(C0887y c0887y, mc mcVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (c0887y != null) {
                        obtain.writeInt(1);
                        c0887y.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (mcVar != null) {
                        iBinder = mcVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.le.transact(12, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1942a(md mdVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (mdVar != null) {
                        iBinder = mdVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.le.transact(22, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1943a(mp mpVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (mpVar != null) {
                        iBinder = mpVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.le.transact(24, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.le;
            }

            /* renamed from: b */
            public void mo1944b(md mdVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (mdVar != null) {
                        iBinder = mdVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.le.transact(23, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static lz av(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof lz)) ? new C1026a(iBinder) : (lz) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            aa aaVar = null;
            switch (code) {
                case 1:
                    DataSourcesRequest dataSourcesRequest;
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (data.readInt() != 0) {
                        dataSourcesRequest = (DataSourcesRequest) DataSourcesRequest.CREATOR.createFromParcel(data);
                    }
                    mo1923a(dataSourcesRequest, C1023a.at(data.readStrongBinder()), data.readString());
                    return true;
                case 2:
                    C0883o c0883o;
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (data.readInt() != 0) {
                        c0883o = (C0883o) C0883o.CREATOR.createFromParcel(data);
                    }
                    mo1937a(c0883o, C1035a.az(data.readStrongBinder()), data.readString());
                    return true;
                case 3:
                    C0884q c0884q;
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (data.readInt() != 0) {
                        c0884q = (C0884q) C0884q.CREATOR.createFromParcel(data);
                    }
                    mo1938a(c0884q, C1035a.az(data.readStrongBinder()), data.readString());
                    return true;
                case 4:
                    af afVar;
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (data.readInt() != 0) {
                        afVar = (af) af.CREATOR.createFromParcel(data);
                    }
                    mo1930a(afVar, C1035a.az(data.readStrongBinder()), data.readString());
                    return true;
                case 5:
                    aj ajVar;
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (data.readInt() != 0) {
                        ajVar = (aj) aj.CREATOR.createFromParcel(data);
                    }
                    mo1932a(ajVar, C1035a.az(data.readStrongBinder()), data.readString());
                    return true;
                case 6:
                    C0882m c0882m;
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (data.readInt() != 0) {
                        c0882m = (C0882m) C0882m.CREATOR.createFromParcel(data);
                    }
                    mo1936a(c0882m, C1029a.aw(data.readStrongBinder()), data.readString());
                    return true;
                case 7:
                    C0878e c0878e;
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (data.readInt() != 0) {
                        c0878e = (C0878e) C0878e.CREATOR.createFromParcel(data);
                    }
                    mo1934a(c0878e, C1035a.az(data.readStrongBinder()), data.readString());
                    return true;
                case 8:
                    DataReadRequest dataReadRequest;
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (data.readInt() != 0) {
                        dataReadRequest = (DataReadRequest) DataReadRequest.CREATOR.createFromParcel(data);
                    }
                    mo1922a(dataReadRequest, C1021a.as(data.readStrongBinder()), data.readString());
                    return true;
                case 9:
                    SessionInsertRequest sessionInsertRequest;
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (data.readInt() != 0) {
                        sessionInsertRequest = (SessionInsertRequest) SessionInsertRequest.CREATOR.createFromParcel(data);
                    }
                    mo1925a(sessionInsertRequest, C1035a.az(data.readStrongBinder()), data.readString());
                    return true;
                case 10:
                    SessionReadRequest sessionReadRequest;
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (data.readInt() != 0) {
                        sessionReadRequest = (SessionReadRequest) SessionReadRequest.CREATOR.createFromParcel(data);
                    }
                    mo1926a(sessionReadRequest, C1031a.ax(data.readStrongBinder()), data.readString());
                    return true;
                case 11:
                    C0886w c0886w;
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (data.readInt() != 0) {
                        c0886w = (C0886w) C0886w.CREATOR.createFromParcel(data);
                    }
                    mo1940a(c0886w, C1035a.az(data.readStrongBinder()), data.readString());
                    return true;
                case 12:
                    C0887y c0887y;
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (data.readInt() != 0) {
                        c0887y = (C0887y) C0887y.CREATOR.createFromParcel(data);
                    }
                    mo1941a(c0887y, C1033a.ay(data.readStrongBinder()), data.readString());
                    return true;
                case 13:
                    DataTypeCreateRequest dataTypeCreateRequest;
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (data.readInt() != 0) {
                        dataTypeCreateRequest = (DataTypeCreateRequest) DataTypeCreateRequest.CREATOR.createFromParcel(data);
                    }
                    mo1924a(dataTypeCreateRequest, C1025a.au(data.readStrongBinder()), data.readString());
                    return true;
                case 14:
                    C0879j c0879j;
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (data.readInt() != 0) {
                        c0879j = (C0879j) C0879j.CREATOR.createFromParcel(data);
                    }
                    mo1935a(c0879j, C1025a.au(data.readStrongBinder()), data.readString());
                    return true;
                case 15:
                    StartBleScanRequest startBleScanRequest;
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (data.readInt() != 0) {
                        startBleScanRequest = (StartBleScanRequest) StartBleScanRequest.CREATOR.createFromParcel(data);
                    }
                    mo1927a(startBleScanRequest, C1035a.az(data.readStrongBinder()), data.readString());
                    return true;
                case 16:
                    ad adVar;
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (data.readInt() != 0) {
                        adVar = (ad) ad.CREATOR.createFromParcel(data);
                    }
                    mo1929a(adVar, C1035a.az(data.readStrongBinder()), data.readString());
                    return true;
                case 17:
                    C0877b c0877b;
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (data.readInt() != 0) {
                        c0877b = (C0877b) C0877b.CREATOR.createFromParcel(data);
                    }
                    mo1933a(c0877b, C1035a.az(data.readStrongBinder()), data.readString());
                    return true;
                case 18:
                    ah ahVar;
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (data.readInt() != 0) {
                        ahVar = (ah) ah.CREATOR.createFromParcel(data);
                    }
                    mo1931a(ahVar, C1035a.az(data.readStrongBinder()), data.readString());
                    return true;
                case TimeUtils.HUNDRED_DAY_FIELD_LEN /*19*/:
                    DataDeleteRequest dataDeleteRequest;
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (data.readInt() != 0) {
                        dataDeleteRequest = (DataDeleteRequest) DataDeleteRequest.CREATOR.createFromParcel(data);
                    }
                    mo1921a(dataDeleteRequest, C1035a.az(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 20:
                    C0885u c0885u;
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (data.readInt() != 0) {
                        c0885u = (C0885u) C0885u.CREATOR.createFromParcel(data);
                    }
                    mo1939a(c0885u, C1035a.az(data.readStrongBinder()), data.readString());
                    return true;
                case 21:
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (data.readInt() != 0) {
                        aaVar = (aa) aa.CREATOR.createFromParcel(data);
                    }
                    mo1928a(aaVar, C1035a.az(data.readStrongBinder()), data.readString());
                    return true;
                case 22:
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    mo1942a(C1035a.az(data.readStrongBinder()), data.readString());
                    return true;
                case 23:
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    mo1944b(C1035a.az(data.readStrongBinder()), data.readString());
                    return true;
                case 24:
                    data.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    mo1943a(C1038a.aA(data.readStrongBinder()), data.readString());
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: a */
    void mo1921a(DataDeleteRequest dataDeleteRequest, md mdVar, String str) throws RemoteException;

    /* renamed from: a */
    void mo1922a(DataReadRequest dataReadRequest, lw lwVar, String str) throws RemoteException;

    /* renamed from: a */
    void mo1923a(DataSourcesRequest dataSourcesRequest, lx lxVar, String str) throws RemoteException;

    /* renamed from: a */
    void mo1924a(DataTypeCreateRequest dataTypeCreateRequest, ly lyVar, String str) throws RemoteException;

    /* renamed from: a */
    void mo1925a(SessionInsertRequest sessionInsertRequest, md mdVar, String str) throws RemoteException;

    /* renamed from: a */
    void mo1926a(SessionReadRequest sessionReadRequest, mb mbVar, String str) throws RemoteException;

    /* renamed from: a */
    void mo1927a(StartBleScanRequest startBleScanRequest, md mdVar, String str) throws RemoteException;

    /* renamed from: a */
    void mo1928a(aa aaVar, md mdVar, String str) throws RemoteException;

    /* renamed from: a */
    void mo1929a(ad adVar, md mdVar, String str) throws RemoteException;

    /* renamed from: a */
    void mo1930a(af afVar, md mdVar, String str) throws RemoteException;

    /* renamed from: a */
    void mo1931a(ah ahVar, md mdVar, String str) throws RemoteException;

    /* renamed from: a */
    void mo1932a(aj ajVar, md mdVar, String str) throws RemoteException;

    /* renamed from: a */
    void mo1933a(C0877b c0877b, md mdVar, String str) throws RemoteException;

    /* renamed from: a */
    void mo1934a(C0878e c0878e, md mdVar, String str) throws RemoteException;

    /* renamed from: a */
    void mo1935a(C0879j c0879j, ly lyVar, String str) throws RemoteException;

    /* renamed from: a */
    void mo1936a(C0882m c0882m, ma maVar, String str) throws RemoteException;

    /* renamed from: a */
    void mo1937a(C0883o c0883o, md mdVar, String str) throws RemoteException;

    /* renamed from: a */
    void mo1938a(C0884q c0884q, md mdVar, String str) throws RemoteException;

    /* renamed from: a */
    void mo1939a(C0885u c0885u, md mdVar, String str) throws RemoteException;

    /* renamed from: a */
    void mo1940a(C0886w c0886w, md mdVar, String str) throws RemoteException;

    /* renamed from: a */
    void mo1941a(C0887y c0887y, mc mcVar, String str) throws RemoteException;

    /* renamed from: a */
    void mo1942a(md mdVar, String str) throws RemoteException;

    /* renamed from: a */
    void mo1943a(mp mpVar, String str) throws RemoteException;

    /* renamed from: b */
    void mo1944b(md mdVar, String str) throws RemoteException;
}
