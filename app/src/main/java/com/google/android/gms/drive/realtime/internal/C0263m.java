package com.google.android.gms.drive.realtime.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v4.util.TimeUtils;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.realtime.internal.C0243c.C0837a;
import com.google.android.gms.drive.realtime.internal.C0244d.C0839a;
import com.google.android.gms.drive.realtime.internal.C0245e.C0841a;
import com.google.android.gms.drive.realtime.internal.C0256f.C0843a;
import com.google.android.gms.drive.realtime.internal.C0257g.C0845a;
import com.google.android.gms.drive.realtime.internal.C0258h.C0847a;
import com.google.android.gms.drive.realtime.internal.C0259i.C0849a;
import com.google.android.gms.drive.realtime.internal.C0260j.C0851a;
import com.google.android.gms.drive.realtime.internal.C0261k.C0853a;
import com.google.android.gms.drive.realtime.internal.C0262l.C0855a;
import com.google.android.gms.drive.realtime.internal.C0264n.C0859a;
import com.google.android.gms.drive.realtime.internal.C0265o.C0861a;
import com.google.android.gms.games.Notifications;

/* renamed from: com.google.android.gms.drive.realtime.internal.m */
public interface C0263m extends IInterface {

    /* renamed from: com.google.android.gms.drive.realtime.internal.m$a */
    public static abstract class C0857a extends Binder implements C0263m {

        /* renamed from: com.google.android.gms.drive.realtime.internal.m$a$a */
        private static class C0856a implements C0263m {
            private IBinder le;

            C0856a(IBinder iBinder) {
                this.le = iBinder;
            }

            /* renamed from: a */
            public void mo1086a(int i, C0260j c0260j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(c0260j != null ? c0260j.asBinder() : null);
                    this.le.transact(30, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1087a(BeginCompoundOperationRequest beginCompoundOperationRequest, C0265o c0265o) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    if (beginCompoundOperationRequest != null) {
                        obtain.writeInt(1);
                        beginCompoundOperationRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(c0265o != null ? c0265o.asBinder() : null);
                    this.le.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1088a(EndCompoundOperationRequest endCompoundOperationRequest, C0260j c0260j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    if (endCompoundOperationRequest != null) {
                        obtain.writeInt(1);
                        endCompoundOperationRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(c0260j != null ? c0260j.asBinder() : null);
                    this.le.transact(41, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1089a(EndCompoundOperationRequest endCompoundOperationRequest, C0265o c0265o) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    if (endCompoundOperationRequest != null) {
                        obtain.writeInt(1);
                        endCompoundOperationRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(c0265o != null ? c0265o.asBinder() : null);
                    this.le.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1090a(ParcelableIndexReference parcelableIndexReference, C0264n c0264n) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    if (parcelableIndexReference != null) {
                        obtain.writeInt(1);
                        parcelableIndexReference.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(c0264n != null ? c0264n.asBinder() : null);
                    this.le.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1091a(C0243c c0243c) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(c0243c != null ? c0243c.asBinder() : null);
                    this.le.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1092a(C0244d c0244d) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(c0244d != null ? c0244d.asBinder() : null);
                    this.le.transact(32, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1093a(C0245e c0245e) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(c0245e != null ? c0245e.asBinder() : null);
                    this.le.transact(31, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1094a(C0258h c0258h) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(c0258h != null ? c0258h.asBinder() : null);
                    this.le.transact(36, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1095a(C0259i c0259i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(c0259i != null ? c0259i.asBinder() : null);
                    this.le.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1096a(C0260j c0260j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(c0260j != null ? c0260j.asBinder() : null);
                    this.le.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1097a(C0262l c0262l) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(c0262l != null ? c0262l.asBinder() : null);
                    this.le.transact(40, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1098a(C0265o c0265o) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(c0265o != null ? c0265o.asBinder() : null);
                    this.le.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1099a(String str, int i, int i2, C0257g c0257g) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeStrongBinder(c0257g != null ? c0257g.asBinder() : null);
                    this.le.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1100a(String str, int i, int i2, C0260j c0260j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeStrongBinder(c0260j != null ? c0260j.asBinder() : null);
                    this.le.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1101a(String str, int i, DataHolder dataHolder, C0257g c0257g) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(c0257g != null ? c0257g.asBinder() : null);
                    this.le.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1102a(String str, int i, DataHolder dataHolder, C0260j c0260j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(c0260j != null ? c0260j.asBinder() : null);
                    this.le.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1103a(String str, int i, C0265o c0265o) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(c0265o != null ? c0265o.asBinder() : null);
                    this.le.transact(28, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1104a(String str, int i, String str2, int i2, C0260j c0260j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeString(str2);
                    obtain.writeInt(i2);
                    obtain.writeStrongBinder(c0260j != null ? c0260j.asBinder() : null);
                    this.le.transact(37, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1105a(String str, int i, String str2, C0260j c0260j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(c0260j != null ? c0260j.asBinder() : null);
                    this.le.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1106a(String str, DataHolder dataHolder, C0260j c0260j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(c0260j != null ? c0260j.asBinder() : null);
                    this.le.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1107a(String str, C0256f c0256f) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(c0256f != null ? c0256f.asBinder() : null);
                    this.le.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1108a(String str, C0260j c0260j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(c0260j != null ? c0260j.asBinder() : null);
                    this.le.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1109a(String str, C0261k c0261k) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(c0261k != null ? c0261k.asBinder() : null);
                    this.le.transact(27, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1110a(String str, C0262l c0262l) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(c0262l != null ? c0262l.asBinder() : null);
                    this.le.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1111a(String str, C0264n c0264n) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(c0264n != null ? c0264n.asBinder() : null);
                    this.le.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1112a(String str, C0265o c0265o) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(c0265o != null ? c0265o.asBinder() : null);
                    this.le.transact(38, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1113a(String str, String str2, C0256f c0256f) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(c0256f != null ? c0256f.asBinder() : null);
                    this.le.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1114a(String str, String str2, C0257g c0257g) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(c0257g != null ? c0257g.asBinder() : null);
                    this.le.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1115a(String str, String str2, C0260j c0260j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(c0260j != null ? c0260j.asBinder() : null);
                    this.le.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.le;
            }

            /* renamed from: b */
            public void mo1116b(C0243c c0243c) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(c0243c != null ? c0243c.asBinder() : null);
                    this.le.transact(33, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo1117b(C0260j c0260j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(c0260j != null ? c0260j.asBinder() : null);
                    this.le.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo1118b(C0262l c0262l) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(c0262l != null ? c0262l.asBinder() : null);
                    this.le.transact(29, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo1119b(C0265o c0265o) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(c0265o != null ? c0265o.asBinder() : null);
                    this.le.transact(35, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo1120b(String str, C0256f c0256f) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(c0256f != null ? c0256f.asBinder() : null);
                    this.le.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo1121b(String str, C0262l c0262l) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(c0262l != null ? c0262l.asBinder() : null);
                    this.le.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo1122b(String str, C0264n c0264n) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(c0264n != null ? c0264n.asBinder() : null);
                    this.le.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo1123b(String str, C0265o c0265o) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(c0265o != null ? c0265o.asBinder() : null);
                    this.le.transact(39, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo1124c(C0243c c0243c) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(c0243c != null ? c0243c.asBinder() : null);
                    this.le.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo1125c(String str, C0262l c0262l) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(c0262l != null ? c0262l.asBinder() : null);
                    this.le.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: d */
            public void mo1126d(C0243c c0243c) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(c0243c != null ? c0243c.asBinder() : null);
                    this.le.transact(25, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static C0263m al(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0263m)) ? new C0856a(iBinder) : (C0263m) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            EndCompoundOperationRequest endCompoundOperationRequest = null;
            String readString;
            DataHolder B;
            int readInt;
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    mo1111a(data.readString(), C0859a.am(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    mo1091a(C0837a.ab(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    mo1098a(C0861a.an(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    mo1113a(data.readString(), data.readString(), C0843a.ae(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 5:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    mo1110a(data.readString(), C0855a.ak(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 6:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    readString = data.readString();
                    if (data.readInt() != 0) {
                        B = DataHolder.CREATOR.m174B(data);
                    }
                    mo1106a(readString, B, C0851a.ai(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 7:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    mo1108a(data.readString(), C0851a.ai(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 8:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    mo1121b(data.readString(), C0855a.ak(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 9:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    mo1122b(data.readString(), C0859a.am(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 10:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    mo1105a(data.readString(), data.readInt(), data.readString(), C0851a.ai(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 11:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    mo1100a(data.readString(), data.readInt(), data.readInt(), C0851a.ai(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 12:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    mo1115a(data.readString(), data.readString(), C0851a.ai(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 13:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    mo1120b(data.readString(), C0843a.ae(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 14:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    mo1125c(data.readString(), C0855a.ak(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 15:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    readString = data.readString();
                    readInt = data.readInt();
                    if (data.readInt() != 0) {
                        B = DataHolder.CREATOR.m174B(data);
                    }
                    mo1102a(readString, readInt, B, C0851a.ai(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 16:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    readString = data.readString();
                    readInt = data.readInt();
                    if (data.readInt() != 0) {
                        B = DataHolder.CREATOR.m174B(data);
                    }
                    mo1101a(readString, readInt, B, C0845a.af(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 17:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    mo1099a(data.readString(), data.readInt(), data.readInt(), C0845a.af(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 18:
                    BeginCompoundOperationRequest beginCompoundOperationRequest;
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    if (data.readInt() != 0) {
                        beginCompoundOperationRequest = (BeginCompoundOperationRequest) BeginCompoundOperationRequest.CREATOR.createFromParcel(data);
                    }
                    mo1087a(beginCompoundOperationRequest, C0861a.an(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case TimeUtils.HUNDRED_DAY_FIELD_LEN /*19*/:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    if (data.readInt() != 0) {
                        endCompoundOperationRequest = (EndCompoundOperationRequest) EndCompoundOperationRequest.CREATOR.createFromParcel(data);
                    }
                    mo1089a(endCompoundOperationRequest, C0861a.an(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 20:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    mo1107a(data.readString(), C0843a.ae(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 21:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    mo1114a(data.readString(), data.readString(), C0845a.af(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 22:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    mo1096a(C0851a.ai(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 23:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    mo1117b(C0851a.ai(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 24:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    mo1124c(C0837a.ab(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 25:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    mo1126d(C0837a.ab(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 26:
                    ParcelableIndexReference parcelableIndexReference;
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    if (data.readInt() != 0) {
                        parcelableIndexReference = (ParcelableIndexReference) ParcelableIndexReference.CREATOR.createFromParcel(data);
                    }
                    mo1090a(parcelableIndexReference, C0859a.am(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 27:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    mo1109a(data.readString(), C0853a.aj(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 28:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    mo1103a(data.readString(), data.readInt(), C0861a.an(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 29:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    mo1118b(C0855a.ak(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 30:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    mo1086a(data.readInt(), C0851a.ai(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case Notifications.NOTIFICATION_TYPES_ALL /*31*/:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    mo1093a(C0841a.ad(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 32:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    mo1092a(C0839a.ac(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 33:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    mo1116b(C0837a.ab(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 34:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    mo1095a(C0849a.ah(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 35:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    mo1119b(C0861a.an(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 36:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    mo1094a(C0847a.ag(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 37:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    mo1104a(data.readString(), data.readInt(), data.readString(), data.readInt(), C0851a.ai(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 38:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    mo1112a(data.readString(), C0861a.an(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 39:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    mo1123b(data.readString(), C0861a.an(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 40:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    mo1097a(C0855a.ak(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 41:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    if (data.readInt() != 0) {
                        endCompoundOperationRequest = (EndCompoundOperationRequest) EndCompoundOperationRequest.CREATOR.createFromParcel(data);
                    }
                    mo1088a(endCompoundOperationRequest, C0851a.ai(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: a */
    void mo1086a(int i, C0260j c0260j) throws RemoteException;

    /* renamed from: a */
    void mo1087a(BeginCompoundOperationRequest beginCompoundOperationRequest, C0265o c0265o) throws RemoteException;

    /* renamed from: a */
    void mo1088a(EndCompoundOperationRequest endCompoundOperationRequest, C0260j c0260j) throws RemoteException;

    /* renamed from: a */
    void mo1089a(EndCompoundOperationRequest endCompoundOperationRequest, C0265o c0265o) throws RemoteException;

    /* renamed from: a */
    void mo1090a(ParcelableIndexReference parcelableIndexReference, C0264n c0264n) throws RemoteException;

    /* renamed from: a */
    void mo1091a(C0243c c0243c) throws RemoteException;

    /* renamed from: a */
    void mo1092a(C0244d c0244d) throws RemoteException;

    /* renamed from: a */
    void mo1093a(C0245e c0245e) throws RemoteException;

    /* renamed from: a */
    void mo1094a(C0258h c0258h) throws RemoteException;

    /* renamed from: a */
    void mo1095a(C0259i c0259i) throws RemoteException;

    /* renamed from: a */
    void mo1096a(C0260j c0260j) throws RemoteException;

    /* renamed from: a */
    void mo1097a(C0262l c0262l) throws RemoteException;

    /* renamed from: a */
    void mo1098a(C0265o c0265o) throws RemoteException;

    /* renamed from: a */
    void mo1099a(String str, int i, int i2, C0257g c0257g) throws RemoteException;

    /* renamed from: a */
    void mo1100a(String str, int i, int i2, C0260j c0260j) throws RemoteException;

    /* renamed from: a */
    void mo1101a(String str, int i, DataHolder dataHolder, C0257g c0257g) throws RemoteException;

    /* renamed from: a */
    void mo1102a(String str, int i, DataHolder dataHolder, C0260j c0260j) throws RemoteException;

    /* renamed from: a */
    void mo1103a(String str, int i, C0265o c0265o) throws RemoteException;

    /* renamed from: a */
    void mo1104a(String str, int i, String str2, int i2, C0260j c0260j) throws RemoteException;

    /* renamed from: a */
    void mo1105a(String str, int i, String str2, C0260j c0260j) throws RemoteException;

    /* renamed from: a */
    void mo1106a(String str, DataHolder dataHolder, C0260j c0260j) throws RemoteException;

    /* renamed from: a */
    void mo1107a(String str, C0256f c0256f) throws RemoteException;

    /* renamed from: a */
    void mo1108a(String str, C0260j c0260j) throws RemoteException;

    /* renamed from: a */
    void mo1109a(String str, C0261k c0261k) throws RemoteException;

    /* renamed from: a */
    void mo1110a(String str, C0262l c0262l) throws RemoteException;

    /* renamed from: a */
    void mo1111a(String str, C0264n c0264n) throws RemoteException;

    /* renamed from: a */
    void mo1112a(String str, C0265o c0265o) throws RemoteException;

    /* renamed from: a */
    void mo1113a(String str, String str2, C0256f c0256f) throws RemoteException;

    /* renamed from: a */
    void mo1114a(String str, String str2, C0257g c0257g) throws RemoteException;

    /* renamed from: a */
    void mo1115a(String str, String str2, C0260j c0260j) throws RemoteException;

    /* renamed from: b */
    void mo1116b(C0243c c0243c) throws RemoteException;

    /* renamed from: b */
    void mo1117b(C0260j c0260j) throws RemoteException;

    /* renamed from: b */
    void mo1118b(C0262l c0262l) throws RemoteException;

    /* renamed from: b */
    void mo1119b(C0265o c0265o) throws RemoteException;

    /* renamed from: b */
    void mo1120b(String str, C0256f c0256f) throws RemoteException;

    /* renamed from: b */
    void mo1121b(String str, C0262l c0262l) throws RemoteException;

    /* renamed from: b */
    void mo1122b(String str, C0264n c0264n) throws RemoteException;

    /* renamed from: b */
    void mo1123b(String str, C0265o c0265o) throws RemoteException;

    /* renamed from: c */
    void mo1124c(C0243c c0243c) throws RemoteException;

    /* renamed from: c */
    void mo1125c(String str, C0262l c0262l) throws RemoteException;

    /* renamed from: d */
    void mo1126d(C0243c c0243c) throws RemoteException;
}
