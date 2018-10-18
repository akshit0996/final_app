package com.google.android.gms.games.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.fitness.FitnessStatusCodes;
import com.google.android.gms.games.GamesActivityResultCodes;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessage;

public interface IGamesCallbacks extends IInterface {

    public static abstract class Stub extends Binder implements IGamesCallbacks {

        private static class Proxy implements IGamesCallbacks {
            private IBinder le;

            Proxy(IBinder remote) {
                this.le = remote;
            }

            /* renamed from: A */
            public void mo1172A(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(5025, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: B */
            public void mo1173B(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(5038, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: C */
            public void mo1174C(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(5035, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: D */
            public void mo1175D(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(5039, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: E */
            public void mo1176E(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(GamesStatusCodes.STATUS_MILESTONE_CLAIM_FAILED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: F */
            public void mo1177F(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(GamesActivityResultCodes.RESULT_LICENSE_FAILED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: G */
            public void mo1178G(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(GamesActivityResultCodes.RESULT_APP_MISCONFIGURED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: H */
            public void mo1179H(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(GamesActivityResultCodes.RESULT_NETWORK_FAILURE, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: I */
            public void mo1180I(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(12001, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: J */
            public void mo1181J(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(12005, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: K */
            public void mo1182K(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(12006, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: L */
            public void mo1183L(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(12007, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: M */
            public void mo1184M(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(12014, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: N */
            public void mo1185N(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(12016, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: O */
            public void mo1186O(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(12008, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: P */
            public void mo1187P(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(12013, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: Q */
            public void mo1188Q(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(13001, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1189a(int i, String str, boolean z) throws RemoteException {
                int i2 = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (z) {
                        i2 = 1;
                    }
                    obtain.writeInt(i2);
                    this.le.transact(5034, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1190a(DataHolder dataHolder, DataHolder dataHolder2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (dataHolder2 != null) {
                        obtain.writeInt(1);
                        dataHolder2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(FitnessStatusCodes.UNKNOWN_AUTH_ERROR, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1191a(DataHolder dataHolder, Contents contents) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (contents != null) {
                        obtain.writeInt(1);
                        contents.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(12004, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1192a(DataHolder dataHolder, String str, Contents contents, Contents contents2, Contents contents3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (contents != null) {
                        obtain.writeInt(1);
                        contents.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (contents2 != null) {
                        obtain.writeInt(1);
                        contents2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (contents3 != null) {
                        obtain.writeInt(1);
                        contents3.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(12017, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1193a(DataHolder dataHolder, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStringArray(strArr);
                    this.le.transact(5026, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1194a(DataHolder[] dataHolderArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeTypedArray(dataHolderArr, 0);
                    this.le.transact(14001, obtain, obtain2, 0);
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
            public void mo1195b(int i, int i2, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    this.le.transact(5033, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo1196b(int i, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(GamesStatusCodes.STATUS_QUEST_NO_LONGER_AVAILABLE, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo1197b(DataHolder dataHolder, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStringArray(strArr);
                    this.le.transact(5027, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo1198c(int i, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(GamesActivityResultCodes.RESULT_LEFT_ROOM, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo1199c(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(FitnessStatusCodes.INCONSISTENT_DATA_TYPE, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo1200c(DataHolder dataHolder, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStringArray(strArr);
                    this.le.transact(5028, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: d */
            public void mo1201d(int i, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(11001, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: d */
            public void mo1202d(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(12011, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: d */
            public void mo1203d(DataHolder dataHolder, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStringArray(strArr);
                    this.le.transact(5029, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void dO(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(i);
                    this.le.transact(5036, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void dP(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(i);
                    this.le.transact(5040, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void dQ(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(i);
                    this.le.transact(13002, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: e */
            public void mo1207e(int i, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(12003, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: e */
            public void mo1208e(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(FitnessStatusCodes.APP_MISMATCH, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: e */
            public void mo1209e(DataHolder dataHolder, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStringArray(strArr);
                    this.le.transact(5030, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: f */
            public void mo1210f(int i, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(12015, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: f */
            public void mo1211f(int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.le.transact(FitnessStatusCodes.CONFLICTING_DATA_TYPE, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: f */
            public void mo1212f(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(FitnessStatusCodes.MISSING_BLE_PERMISSION, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: f */
            public void mo1213f(DataHolder dataHolder, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStringArray(strArr);
                    this.le.transact(5031, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void fK() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    this.le.transact(5016, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: g */
            public void mo1215g(int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.le.transact(FitnessStatusCodes.DATA_TYPE_NOT_FOUND, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: g */
            public void mo1216g(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(FitnessStatusCodes.UNSUPPORTED_PLATFORM, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: h */
            public void mo1217h(int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.le.transact(8007, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: h */
            public void mo1218h(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(FitnessStatusCodes.TRANSIENT_ERROR, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: i */
            public void mo1219i(int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.le.transact(12012, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: i */
            public void mo1220i(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(FitnessStatusCodes.EQUIVALENT_SESSION_ENDED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: j */
            public void mo1221j(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(FitnessStatusCodes.APP_NOT_FIT_ENABLED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: k */
            public void mo1222k(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(FitnessStatusCodes.API_EXCEPTION, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: l */
            public void mo1223l(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(9001, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: m */
            public void mo1224m(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(5017, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: n */
            public void mo1225n(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(5037, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: o */
            public void mo1226o(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(GamesActivityResultCodes.RESULT_RECONNECT_REQUIRED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onInvitationRemoved(String invitationId) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeString(invitationId);
                    this.le.transact(8010, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onLeftRoom(int statusCode, String roomId) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(statusCode);
                    obtain.writeString(roomId);
                    this.le.transact(5020, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onP2PConnected(String participantId) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeString(participantId);
                    this.le.transact(GamesStatusCodes.STATUS_MULTIPLAYER_ERROR_NOT_TRUSTED_TESTER, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onP2PDisconnected(String participantId) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeString(participantId);
                    this.le.transact(GamesStatusCodes.STATUS_MULTIPLAYER_ERROR_INVALID_MULTIPLAYER_TYPE, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onRealTimeMessageReceived(RealTimeMessage message) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (message != null) {
                        obtain.writeInt(1);
                        message.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(5032, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onRequestRemoved(String requestId) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeString(requestId);
                    this.le.transact(GamesActivityResultCodes.RESULT_SIGN_IN_FAILED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onTurnBasedMatchRemoved(String matchId) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeString(matchId);
                    this.le.transact(8009, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: p */
            public void mo1234p(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(GamesStatusCodes.STATUS_QUEST_NOT_STARTED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: q */
            public void mo1235q(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(8004, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: r */
            public void mo1236r(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(8005, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: s */
            public void mo1237s(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(8006, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: t */
            public void mo1238t(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(8008, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: u */
            public void mo1239u(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(5018, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: v */
            public void mo1240v(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(5019, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: w */
            public void mo1241w(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(5021, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: x */
            public void mo1242x(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(5022, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: y */
            public void mo1243y(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(5023, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: z */
            public void mo1244z(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(5024, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.google.android.gms.games.internal.IGamesCallbacks");
        }

        public static IGamesCallbacks aD(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IGamesCallbacks)) ? new Proxy(iBinder) : (IGamesCallbacks) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            DataHolder dataHolder = null;
            switch (code) {
                case FitnessStatusCodes.CONFLICTING_DATA_TYPE /*5001*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    mo1211f(data.readInt(), data.readString());
                    reply.writeNoException();
                    return true;
                case FitnessStatusCodes.INCONSISTENT_DATA_TYPE /*5002*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    mo1199c(data.readInt() != 0 ? DataHolder.CREATOR.m174B(data) : null);
                    reply.writeNoException();
                    return true;
                case FitnessStatusCodes.DATA_TYPE_NOT_FOUND /*5003*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    mo1215g(data.readInt(), data.readString());
                    reply.writeNoException();
                    return true;
                case FitnessStatusCodes.APP_MISMATCH /*5004*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m174B(data);
                    }
                    mo1208e(dataHolder);
                    reply.writeNoException();
                    return true;
                case FitnessStatusCodes.UNKNOWN_AUTH_ERROR /*5005*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    DataHolder B = data.readInt() != 0 ? DataHolder.CREATOR.m174B(data) : null;
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m174B(data);
                    }
                    mo1190a(B, dataHolder);
                    reply.writeNoException();
                    return true;
                case FitnessStatusCodes.MISSING_BLE_PERMISSION /*5006*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m174B(data);
                    }
                    mo1212f(dataHolder);
                    reply.writeNoException();
                    return true;
                case FitnessStatusCodes.UNSUPPORTED_PLATFORM /*5007*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m174B(data);
                    }
                    mo1216g(dataHolder);
                    reply.writeNoException();
                    return true;
                case FitnessStatusCodes.TRANSIENT_ERROR /*5008*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m174B(data);
                    }
                    mo1218h(dataHolder);
                    reply.writeNoException();
                    return true;
                case FitnessStatusCodes.EQUIVALENT_SESSION_ENDED /*5009*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m174B(data);
                    }
                    mo1220i(dataHolder);
                    reply.writeNoException();
                    return true;
                case FitnessStatusCodes.APP_NOT_FIT_ENABLED /*5010*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m174B(data);
                    }
                    mo1221j(dataHolder);
                    reply.writeNoException();
                    return true;
                case FitnessStatusCodes.API_EXCEPTION /*5011*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m174B(data);
                    }
                    mo1222k(dataHolder);
                    reply.writeNoException();
                    return true;
                case 5016:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    fK();
                    reply.writeNoException();
                    return true;
                case 5017:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m174B(data);
                    }
                    mo1224m(dataHolder);
                    reply.writeNoException();
                    return true;
                case 5018:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m174B(data);
                    }
                    mo1239u(dataHolder);
                    reply.writeNoException();
                    return true;
                case 5019:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m174B(data);
                    }
                    mo1240v(dataHolder);
                    reply.writeNoException();
                    return true;
                case 5020:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    onLeftRoom(data.readInt(), data.readString());
                    reply.writeNoException();
                    return true;
                case 5021:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m174B(data);
                    }
                    mo1241w(dataHolder);
                    reply.writeNoException();
                    return true;
                case 5022:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m174B(data);
                    }
                    mo1242x(dataHolder);
                    reply.writeNoException();
                    return true;
                case 5023:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m174B(data);
                    }
                    mo1243y(dataHolder);
                    reply.writeNoException();
                    return true;
                case 5024:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m174B(data);
                    }
                    mo1244z(dataHolder);
                    reply.writeNoException();
                    return true;
                case 5025:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m174B(data);
                    }
                    mo1172A(dataHolder);
                    reply.writeNoException();
                    return true;
                case 5026:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m174B(data);
                    }
                    mo1193a(dataHolder, data.createStringArray());
                    reply.writeNoException();
                    return true;
                case 5027:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m174B(data);
                    }
                    mo1197b(dataHolder, data.createStringArray());
                    reply.writeNoException();
                    return true;
                case 5028:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m174B(data);
                    }
                    mo1200c(dataHolder, data.createStringArray());
                    reply.writeNoException();
                    return true;
                case 5029:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m174B(data);
                    }
                    mo1203d(dataHolder, data.createStringArray());
                    reply.writeNoException();
                    return true;
                case 5030:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m174B(data);
                    }
                    mo1209e(dataHolder, data.createStringArray());
                    reply.writeNoException();
                    return true;
                case 5031:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m174B(data);
                    }
                    mo1213f(dataHolder, data.createStringArray());
                    reply.writeNoException();
                    return true;
                case 5032:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    onRealTimeMessageReceived(data.readInt() != 0 ? (RealTimeMessage) RealTimeMessage.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 5033:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    mo1195b(data.readInt(), data.readInt(), data.readString());
                    reply.writeNoException();
                    return true;
                case 5034:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    mo1189a(data.readInt(), data.readString(), data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                case 5035:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m174B(data);
                    }
                    mo1174C(dataHolder);
                    reply.writeNoException();
                    return true;
                case 5036:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    dO(data.readInt());
                    reply.writeNoException();
                    return true;
                case 5037:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m174B(data);
                    }
                    mo1225n(dataHolder);
                    reply.writeNoException();
                    return true;
                case 5038:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m174B(data);
                    }
                    mo1173B(dataHolder);
                    reply.writeNoException();
                    return true;
                case 5039:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m174B(data);
                    }
                    mo1175D(dataHolder);
                    reply.writeNoException();
                    return true;
                case 5040:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    dP(data.readInt());
                    reply.writeNoException();
                    return true;
                case GamesStatusCodes.STATUS_MULTIPLAYER_ERROR_NOT_TRUSTED_TESTER /*6001*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    onP2PConnected(data.readString());
                    reply.writeNoException();
                    return true;
                case GamesStatusCodes.STATUS_MULTIPLAYER_ERROR_INVALID_MULTIPLAYER_TYPE /*6002*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    onP2PDisconnected(data.readString());
                    reply.writeNoException();
                    return true;
                case GamesStatusCodes.STATUS_MILESTONE_CLAIM_FAILED /*8001*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m174B(data);
                    }
                    mo1176E(dataHolder);
                    reply.writeNoException();
                    return true;
                case GamesStatusCodes.STATUS_QUEST_NO_LONGER_AVAILABLE /*8002*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    mo1196b(data.readInt(), data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case GamesStatusCodes.STATUS_QUEST_NOT_STARTED /*8003*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m174B(data);
                    }
                    mo1234p(dataHolder);
                    reply.writeNoException();
                    return true;
                case 8004:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m174B(data);
                    }
                    mo1235q(dataHolder);
                    reply.writeNoException();
                    return true;
                case 8005:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m174B(data);
                    }
                    mo1236r(dataHolder);
                    reply.writeNoException();
                    return true;
                case 8006:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m174B(data);
                    }
                    mo1237s(dataHolder);
                    reply.writeNoException();
                    return true;
                case 8007:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    mo1217h(data.readInt(), data.readString());
                    reply.writeNoException();
                    return true;
                case 8008:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m174B(data);
                    }
                    mo1238t(dataHolder);
                    reply.writeNoException();
                    return true;
                case 8009:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    onTurnBasedMatchRemoved(data.readString());
                    reply.writeNoException();
                    return true;
                case 8010:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    onInvitationRemoved(data.readString());
                    reply.writeNoException();
                    return true;
                case 9001:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m174B(data);
                    }
                    mo1223l(dataHolder);
                    reply.writeNoException();
                    return true;
                case GamesActivityResultCodes.RESULT_RECONNECT_REQUIRED /*10001*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m174B(data);
                    }
                    mo1226o(dataHolder);
                    reply.writeNoException();
                    return true;
                case GamesActivityResultCodes.RESULT_SIGN_IN_FAILED /*10002*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    onRequestRemoved(data.readString());
                    reply.writeNoException();
                    return true;
                case GamesActivityResultCodes.RESULT_LICENSE_FAILED /*10003*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m174B(data);
                    }
                    mo1177F(dataHolder);
                    reply.writeNoException();
                    return true;
                case GamesActivityResultCodes.RESULT_APP_MISCONFIGURED /*10004*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m174B(data);
                    }
                    mo1178G(dataHolder);
                    reply.writeNoException();
                    return true;
                case GamesActivityResultCodes.RESULT_LEFT_ROOM /*10005*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    mo1198c(data.readInt(), data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case GamesActivityResultCodes.RESULT_NETWORK_FAILURE /*10006*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m174B(data);
                    }
                    mo1179H(dataHolder);
                    reply.writeNoException();
                    return true;
                case 11001:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    mo1201d(data.readInt(), data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 12001:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m174B(data);
                    }
                    mo1180I(dataHolder);
                    reply.writeNoException();
                    return true;
                case 12003:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    mo1207e(data.readInt(), data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 12004:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    mo1191a(data.readInt() != 0 ? DataHolder.CREATOR.m174B(data) : null, data.readInt() != 0 ? (Contents) Contents.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 12005:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m174B(data);
                    }
                    mo1181J(dataHolder);
                    reply.writeNoException();
                    return true;
                case 12006:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m174B(data);
                    }
                    mo1182K(dataHolder);
                    reply.writeNoException();
                    return true;
                case 12007:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m174B(data);
                    }
                    mo1183L(dataHolder);
                    reply.writeNoException();
                    return true;
                case 12008:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m174B(data);
                    }
                    mo1186O(dataHolder);
                    reply.writeNoException();
                    return true;
                case 12011:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m174B(data);
                    }
                    mo1202d(dataHolder);
                    reply.writeNoException();
                    return true;
                case 12012:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    mo1219i(data.readInt(), data.readString());
                    reply.writeNoException();
                    return true;
                case 12013:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m174B(data);
                    }
                    mo1187P(dataHolder);
                    reply.writeNoException();
                    return true;
                case 12014:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m174B(data);
                    }
                    mo1184M(dataHolder);
                    reply.writeNoException();
                    return true;
                case 12015:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    mo1210f(data.readInt(), data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 12016:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m174B(data);
                    }
                    mo1185N(dataHolder);
                    reply.writeNoException();
                    return true;
                case 12017:
                    Contents contents;
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    DataHolder B2 = data.readInt() != 0 ? DataHolder.CREATOR.m174B(data) : null;
                    String readString = data.readString();
                    Contents contents2 = data.readInt() != 0 ? (Contents) Contents.CREATOR.createFromParcel(data) : null;
                    Contents contents3 = data.readInt() != 0 ? (Contents) Contents.CREATOR.createFromParcel(data) : null;
                    if (data.readInt() != 0) {
                        contents = (Contents) Contents.CREATOR.createFromParcel(data);
                    }
                    mo1192a(B2, readString, contents2, contents3, contents);
                    reply.writeNoException();
                    return true;
                case 13001:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.m174B(data);
                    }
                    mo1188Q(dataHolder);
                    reply.writeNoException();
                    return true;
                case 13002:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    dQ(data.readInt());
                    reply.writeNoException();
                    return true;
                case 14001:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    mo1194a((DataHolder[]) data.createTypedArray(DataHolder.CREATOR));
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.games.internal.IGamesCallbacks");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: A */
    void mo1172A(DataHolder dataHolder) throws RemoteException;

    /* renamed from: B */
    void mo1173B(DataHolder dataHolder) throws RemoteException;

    /* renamed from: C */
    void mo1174C(DataHolder dataHolder) throws RemoteException;

    /* renamed from: D */
    void mo1175D(DataHolder dataHolder) throws RemoteException;

    /* renamed from: E */
    void mo1176E(DataHolder dataHolder) throws RemoteException;

    /* renamed from: F */
    void mo1177F(DataHolder dataHolder) throws RemoteException;

    /* renamed from: G */
    void mo1178G(DataHolder dataHolder) throws RemoteException;

    /* renamed from: H */
    void mo1179H(DataHolder dataHolder) throws RemoteException;

    /* renamed from: I */
    void mo1180I(DataHolder dataHolder) throws RemoteException;

    /* renamed from: J */
    void mo1181J(DataHolder dataHolder) throws RemoteException;

    /* renamed from: K */
    void mo1182K(DataHolder dataHolder) throws RemoteException;

    /* renamed from: L */
    void mo1183L(DataHolder dataHolder) throws RemoteException;

    /* renamed from: M */
    void mo1184M(DataHolder dataHolder) throws RemoteException;

    /* renamed from: N */
    void mo1185N(DataHolder dataHolder) throws RemoteException;

    /* renamed from: O */
    void mo1186O(DataHolder dataHolder) throws RemoteException;

    /* renamed from: P */
    void mo1187P(DataHolder dataHolder) throws RemoteException;

    /* renamed from: Q */
    void mo1188Q(DataHolder dataHolder) throws RemoteException;

    /* renamed from: a */
    void mo1189a(int i, String str, boolean z) throws RemoteException;

    /* renamed from: a */
    void mo1190a(DataHolder dataHolder, DataHolder dataHolder2) throws RemoteException;

    /* renamed from: a */
    void mo1191a(DataHolder dataHolder, Contents contents) throws RemoteException;

    /* renamed from: a */
    void mo1192a(DataHolder dataHolder, String str, Contents contents, Contents contents2, Contents contents3) throws RemoteException;

    /* renamed from: a */
    void mo1193a(DataHolder dataHolder, String[] strArr) throws RemoteException;

    /* renamed from: a */
    void mo1194a(DataHolder[] dataHolderArr) throws RemoteException;

    /* renamed from: b */
    void mo1195b(int i, int i2, String str) throws RemoteException;

    /* renamed from: b */
    void mo1196b(int i, Bundle bundle) throws RemoteException;

    /* renamed from: b */
    void mo1197b(DataHolder dataHolder, String[] strArr) throws RemoteException;

    /* renamed from: c */
    void mo1198c(int i, Bundle bundle) throws RemoteException;

    /* renamed from: c */
    void mo1199c(DataHolder dataHolder) throws RemoteException;

    /* renamed from: c */
    void mo1200c(DataHolder dataHolder, String[] strArr) throws RemoteException;

    /* renamed from: d */
    void mo1201d(int i, Bundle bundle) throws RemoteException;

    /* renamed from: d */
    void mo1202d(DataHolder dataHolder) throws RemoteException;

    /* renamed from: d */
    void mo1203d(DataHolder dataHolder, String[] strArr) throws RemoteException;

    void dO(int i) throws RemoteException;

    void dP(int i) throws RemoteException;

    void dQ(int i) throws RemoteException;

    /* renamed from: e */
    void mo1207e(int i, Bundle bundle) throws RemoteException;

    /* renamed from: e */
    void mo1208e(DataHolder dataHolder) throws RemoteException;

    /* renamed from: e */
    void mo1209e(DataHolder dataHolder, String[] strArr) throws RemoteException;

    /* renamed from: f */
    void mo1210f(int i, Bundle bundle) throws RemoteException;

    /* renamed from: f */
    void mo1211f(int i, String str) throws RemoteException;

    /* renamed from: f */
    void mo1212f(DataHolder dataHolder) throws RemoteException;

    /* renamed from: f */
    void mo1213f(DataHolder dataHolder, String[] strArr) throws RemoteException;

    void fK() throws RemoteException;

    /* renamed from: g */
    void mo1215g(int i, String str) throws RemoteException;

    /* renamed from: g */
    void mo1216g(DataHolder dataHolder) throws RemoteException;

    /* renamed from: h */
    void mo1217h(int i, String str) throws RemoteException;

    /* renamed from: h */
    void mo1218h(DataHolder dataHolder) throws RemoteException;

    /* renamed from: i */
    void mo1219i(int i, String str) throws RemoteException;

    /* renamed from: i */
    void mo1220i(DataHolder dataHolder) throws RemoteException;

    /* renamed from: j */
    void mo1221j(DataHolder dataHolder) throws RemoteException;

    /* renamed from: k */
    void mo1222k(DataHolder dataHolder) throws RemoteException;

    /* renamed from: l */
    void mo1223l(DataHolder dataHolder) throws RemoteException;

    /* renamed from: m */
    void mo1224m(DataHolder dataHolder) throws RemoteException;

    /* renamed from: n */
    void mo1225n(DataHolder dataHolder) throws RemoteException;

    /* renamed from: o */
    void mo1226o(DataHolder dataHolder) throws RemoteException;

    void onInvitationRemoved(String str) throws RemoteException;

    void onLeftRoom(int i, String str) throws RemoteException;

    void onP2PConnected(String str) throws RemoteException;

    void onP2PDisconnected(String str) throws RemoteException;

    void onRealTimeMessageReceived(RealTimeMessage realTimeMessage) throws RemoteException;

    void onRequestRemoved(String str) throws RemoteException;

    void onTurnBasedMatchRemoved(String str) throws RemoteException;

    /* renamed from: p */
    void mo1234p(DataHolder dataHolder) throws RemoteException;

    /* renamed from: q */
    void mo1235q(DataHolder dataHolder) throws RemoteException;

    /* renamed from: r */
    void mo1236r(DataHolder dataHolder) throws RemoteException;

    /* renamed from: s */
    void mo1237s(DataHolder dataHolder) throws RemoteException;

    /* renamed from: t */
    void mo1238t(DataHolder dataHolder) throws RemoteException;

    /* renamed from: u */
    void mo1239u(DataHolder dataHolder) throws RemoteException;

    /* renamed from: v */
    void mo1240v(DataHolder dataHolder) throws RemoteException;

    /* renamed from: w */
    void mo1241w(DataHolder dataHolder) throws RemoteException;

    /* renamed from: x */
    void mo1242x(DataHolder dataHolder) throws RemoteException;

    /* renamed from: y */
    void mo1243y(DataHolder dataHolder) throws RemoteException;

    /* renamed from: z */
    void mo1244z(DataHolder dataHolder) throws RemoteException;
}
