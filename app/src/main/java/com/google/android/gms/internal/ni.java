package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v4.util.TimeUtils;
import com.google.android.gms.internal.nh.C1049a;
import com.google.android.gms.internal.og.C1055a;
import com.google.android.gms.location.C0517b;
import com.google.android.gms.location.C0517b.C1085a;
import com.google.android.gms.location.C1087e;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.List;

public interface ni extends IInterface {

    /* renamed from: com.google.android.gms.internal.ni$a */
    public static abstract class C1051a extends Binder implements ni {

        /* renamed from: com.google.android.gms.internal.ni$a$a */
        private static class C1050a implements ni {
            private IBinder le;

            C1050a(IBinder iBinder) {
                this.le = iBinder;
            }

            /* renamed from: S */
            public void mo2006S(boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.le.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo2007a(long j, boolean z, PendingIntent pendingIntent) throws RemoteException {
                int i = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeLong(j);
                    if (!z) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo2008a(PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo2009a(PendingIntent pendingIntent, nh nhVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(nhVar != null ? nhVar.asBinder() : null);
                    obtain.writeString(str);
                    this.le.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo2010a(Location location, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (location != null) {
                        obtain.writeInt(1);
                        location.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    this.le.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo2011a(nh nhVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeStrongBinder(nhVar != null ? nhVar.asBinder() : null);
                    obtain.writeString(str);
                    this.le.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo2012a(nl nlVar, PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (nlVar != null) {
                        obtain.writeInt(1);
                        nlVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(53, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo2013a(nl nlVar, C0517b c0517b) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (nlVar != null) {
                        obtain.writeInt(1);
                        nlVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(c0517b != null ? c0517b.asBinder() : null);
                    this.le.transact(52, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo2014a(ns nsVar, oh ohVar, PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (nsVar != null) {
                        obtain.writeInt(1);
                        nsVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (ohVar != null) {
                        obtain.writeInt(1);
                        ohVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(48, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo2015a(nu nuVar, oh ohVar, og ogVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (nuVar != null) {
                        obtain.writeInt(1);
                        nuVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (ohVar != null) {
                        obtain.writeInt(1);
                        ohVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(ogVar != null ? ogVar.asBinder() : null);
                    this.le.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo2016a(nw nwVar, oh ohVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (nwVar != null) {
                        obtain.writeInt(1);
                        nwVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (ohVar != null) {
                        obtain.writeInt(1);
                        ohVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(25, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo2017a(ny nyVar, oh ohVar, PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (nyVar != null) {
                        obtain.writeInt(1);
                        nyVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (ohVar != null) {
                        obtain.writeInt(1);
                        ohVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo2018a(oc ocVar, oh ohVar, og ogVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (ocVar != null) {
                        obtain.writeInt(1);
                        ocVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (ohVar != null) {
                        obtain.writeInt(1);
                        ohVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(ogVar != null ? ogVar.asBinder() : null);
                    this.le.transact(46, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo2019a(oe oeVar, LatLngBounds latLngBounds, List<String> list, oh ohVar, og ogVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (oeVar != null) {
                        obtain.writeInt(1);
                        oeVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (latLngBounds != null) {
                        obtain.writeInt(1);
                        latLngBounds.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStringList(list);
                    if (ohVar != null) {
                        obtain.writeInt(1);
                        ohVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(ogVar != null ? ogVar.asBinder() : null);
                    this.le.transact(50, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo2020a(oh ohVar, PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (ohVar != null) {
                        obtain.writeInt(1);
                        ohVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo2021a(GeofencingRequest geofencingRequest, PendingIntent pendingIntent, nh nhVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (geofencingRequest != null) {
                        obtain.writeInt(1);
                        geofencingRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(nhVar != null ? nhVar.asBinder() : null);
                    this.le.transact(57, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo2022a(LocationRequest locationRequest, PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (locationRequest != null) {
                        obtain.writeInt(1);
                        locationRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo2023a(LocationRequest locationRequest, C0517b c0517b) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (locationRequest != null) {
                        obtain.writeInt(1);
                        locationRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(c0517b != null ? c0517b.asBinder() : null);
                    this.le.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo2024a(LocationRequest locationRequest, C0517b c0517b, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (locationRequest != null) {
                        obtain.writeInt(1);
                        locationRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(c0517b != null ? c0517b.asBinder() : null);
                    obtain.writeString(str);
                    this.le.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo2025a(C0517b c0517b) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeStrongBinder(c0517b != null ? c0517b.asBinder() : null);
                    this.le.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo2026a(LatLng latLng, nu nuVar, oh ohVar, og ogVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (latLng != null) {
                        obtain.writeInt(1);
                        latLng.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (nuVar != null) {
                        obtain.writeInt(1);
                        nuVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (ohVar != null) {
                        obtain.writeInt(1);
                        ohVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(ogVar != null ? ogVar.asBinder() : null);
                    this.le.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo2027a(LatLngBounds latLngBounds, int i, nu nuVar, oh ohVar, og ogVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (latLngBounds != null) {
                        obtain.writeInt(1);
                        latLngBounds.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    if (nuVar != null) {
                        obtain.writeInt(1);
                        nuVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (ohVar != null) {
                        obtain.writeInt(1);
                        ohVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(ogVar != null ? ogVar.asBinder() : null);
                    this.le.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo2028a(LatLngBounds latLngBounds, int i, String str, nu nuVar, oh ohVar, og ogVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (latLngBounds != null) {
                        obtain.writeInt(1);
                        latLngBounds.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (nuVar != null) {
                        obtain.writeInt(1);
                        nuVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (ohVar != null) {
                        obtain.writeInt(1);
                        ohVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(ogVar != null ? ogVar.asBinder() : null);
                    this.le.transact(47, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo2029a(String str, oh ohVar, og ogVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeString(str);
                    if (ohVar != null) {
                        obtain.writeInt(1);
                        ohVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(ogVar != null ? ogVar.asBinder() : null);
                    this.le.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo2030a(String str, LatLngBounds latLngBounds, nq nqVar, oh ohVar, og ogVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeString(str);
                    if (latLngBounds != null) {
                        obtain.writeInt(1);
                        latLngBounds.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (nqVar != null) {
                        obtain.writeInt(1);
                        nqVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (ohVar != null) {
                        obtain.writeInt(1);
                        ohVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(ogVar != null ? ogVar.asBinder() : null);
                    this.le.transact(55, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo2031a(List<nn> list, PendingIntent pendingIntent, nh nhVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeTypedList(list);
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(nhVar != null ? nhVar.asBinder() : null);
                    obtain.writeString(str);
                    this.le.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo2032a(List<String> list, oh ohVar, og ogVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeStringList(list);
                    if (ohVar != null) {
                        obtain.writeInt(1);
                        ohVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(ogVar != null ? ogVar.asBinder() : null);
                    this.le.transact(58, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo2033a(String[] strArr, nh nhVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeStringArray(strArr);
                    obtain.writeStrongBinder(nhVar != null ? nhVar.asBinder() : null);
                    obtain.writeString(str);
                    this.le.transact(3, obtain, obtain2, 0);
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
            public void mo2034b(PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo2035b(Location location) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (location != null) {
                        obtain.writeInt(1);
                        location.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo2036b(oh ohVar, PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (ohVar != null) {
                        obtain.writeInt(1);
                        ohVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.le.transact(49, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo2037b(String str, oh ohVar, og ogVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeString(str);
                    if (ohVar != null) {
                        obtain.writeInt(1);
                        ohVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(ogVar != null ? ogVar.asBinder() : null);
                    this.le.transact(42, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Location bZ(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeString(str);
                    this.le.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                    Location location = obtain2.readInt() != 0 ? (Location) Location.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return location;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public C1087e ca(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeString(str);
                    this.le.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                    C1087e cK = obtain2.readInt() != 0 ? C1087e.CREATOR.cK(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return cK;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Location ni() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    this.le.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    Location location = obtain2.readInt() != 0 ? (Location) Location.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return location;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder nj() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    this.le.transact(51, obtain, obtain2, 0);
                    obtain2.readException();
                    IBinder readStrongBinder = obtain2.readStrongBinder();
                    return readStrongBinder;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder nk() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    this.le.transact(54, obtain, obtain2, 0);
                    obtain2.readException();
                    IBinder readStrongBinder = obtain2.readStrongBinder();
                    return readStrongBinder;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static ni aO(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ni)) ? new C1050a(iBinder) : (ni) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            boolean z = false;
            oh ohVar = null;
            Location ni;
            LocationRequest cJ;
            String readString;
            IBinder nj;
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    mo2031a(data.createTypedArrayList(nn.CREATOR), data.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(data) : null, C1049a.aN(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    mo2009a(data.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(data) : null, C1049a.aN(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    mo2033a(data.createStringArray(), C1049a.aN(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    mo2011a(C1049a.aN(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 5:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    mo2007a(data.readLong(), data.readInt() != 0, data.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 6:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    mo2008a(data.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 7:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    ni = ni();
                    reply.writeNoException();
                    if (ni != null) {
                        reply.writeInt(1);
                        ni.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 8:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (data.readInt() != 0) {
                        cJ = LocationRequest.CREATOR.cJ(data);
                    }
                    mo2023a(cJ, C1085a.aL(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 9:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    mo2022a(data.readInt() != 0 ? LocationRequest.CREATOR.cJ(data) : null, data.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 10:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    mo2025a(C1085a.aL(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 11:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    mo2034b(data.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 12:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    mo2006S(z);
                    reply.writeNoException();
                    return true;
                case 13:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    mo2035b(data.readInt() != 0 ? (Location) Location.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 14:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    mo2027a(data.readInt() != 0 ? LatLngBounds.CREATOR.dd(data) : null, data.readInt(), data.readInt() != 0 ? nu.CREATOR.cQ(data) : null, data.readInt() != 0 ? oh.CREATOR.cW(data) : null, C1055a.aP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 15:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    readString = data.readString();
                    if (data.readInt() != 0) {
                        ohVar = oh.CREATOR.cW(data);
                    }
                    mo2029a(readString, ohVar, C1055a.aP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 16:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    LatLng de = data.readInt() != 0 ? LatLng.CREATOR.de(data) : null;
                    nu cQ = data.readInt() != 0 ? nu.CREATOR.cQ(data) : null;
                    if (data.readInt() != 0) {
                        ohVar = oh.CREATOR.cW(data);
                    }
                    mo2026a(de, cQ, ohVar, C1055a.aP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 17:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    nu cQ2 = data.readInt() != 0 ? nu.CREATOR.cQ(data) : null;
                    if (data.readInt() != 0) {
                        ohVar = oh.CREATOR.cW(data);
                    }
                    mo2015a(cQ2, ohVar, C1055a.aP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 18:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    mo2017a(data.readInt() != 0 ? ny.CREATOR.cS(data) : null, data.readInt() != 0 ? oh.CREATOR.cW(data) : null, data.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case TimeUtils.HUNDRED_DAY_FIELD_LEN /*19*/:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    mo2020a(data.readInt() != 0 ? oh.CREATOR.cW(data) : null, data.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 20:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (data.readInt() != 0) {
                        cJ = LocationRequest.CREATOR.cJ(data);
                    }
                    mo2024a(cJ, C1085a.aL(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 21:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    ni = bZ(data.readString());
                    reply.writeNoException();
                    if (ni != null) {
                        reply.writeInt(1);
                        ni.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 25:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    nw cR = data.readInt() != 0 ? nw.CREATOR.cR(data) : null;
                    if (data.readInt() != 0) {
                        ohVar = oh.CREATOR.cW(data);
                    }
                    mo2016a(cR, ohVar);
                    return true;
                case 26:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    mo2010a(data.readInt() != 0 ? (Location) Location.CREATOR.createFromParcel(data) : null, data.readInt());
                    reply.writeNoException();
                    return true;
                case 34:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    C1087e ca = ca(data.readString());
                    reply.writeNoException();
                    if (ca != null) {
                        reply.writeInt(1);
                        ca.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 42:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    readString = data.readString();
                    if (data.readInt() != 0) {
                        ohVar = oh.CREATOR.cW(data);
                    }
                    mo2037b(readString, ohVar, C1055a.aP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 46:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    oc ocVar = data.readInt() != 0 ? (oc) oc.CREATOR.createFromParcel(data) : null;
                    if (data.readInt() != 0) {
                        ohVar = oh.CREATOR.cW(data);
                    }
                    mo2018a(ocVar, ohVar, C1055a.aP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 47:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    LatLngBounds dd = data.readInt() != 0 ? LatLngBounds.CREATOR.dd(data) : null;
                    int readInt = data.readInt();
                    String readString2 = data.readString();
                    nu cQ3 = data.readInt() != 0 ? nu.CREATOR.cQ(data) : null;
                    if (data.readInt() != 0) {
                        ohVar = oh.CREATOR.cW(data);
                    }
                    mo2028a(dd, readInt, readString2, cQ3, ohVar, C1055a.aP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 48:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    mo2014a(data.readInt() != 0 ? ns.CREATOR.cP(data) : null, data.readInt() != 0 ? oh.CREATOR.cW(data) : null, data.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 49:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    mo2036b(data.readInt() != 0 ? oh.CREATOR.cW(data) : null, data.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 50:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    mo2019a(data.readInt() != 0 ? oe.CREATOR.cV(data) : null, data.readInt() != 0 ? LatLngBounds.CREATOR.dd(data) : null, data.createStringArrayList(), data.readInt() != 0 ? oh.CREATOR.cW(data) : null, C1055a.aP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 51:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    nj = nj();
                    reply.writeNoException();
                    reply.writeStrongBinder(nj);
                    return true;
                case 52:
                    nl cM;
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (data.readInt() != 0) {
                        cM = nl.CREATOR.cM(data);
                    }
                    mo2013a(cM, C1085a.aL(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 53:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    mo2012a(data.readInt() != 0 ? nl.CREATOR.cM(data) : null, data.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 54:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    nj = nk();
                    reply.writeNoException();
                    reply.writeStrongBinder(nj);
                    return true;
                case 55:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    mo2030a(data.readString(), data.readInt() != 0 ? LatLngBounds.CREATOR.dd(data) : null, data.readInt() != 0 ? nq.CREATOR.cO(data) : null, data.readInt() != 0 ? oh.CREATOR.cW(data) : null, C1055a.aP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 57:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    mo2021a(data.readInt() != 0 ? (GeofencingRequest) GeofencingRequest.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(data) : null, C1049a.aN(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 58:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    List createStringArrayList = data.createStringArrayList();
                    if (data.readInt() != 0) {
                        ohVar = oh.CREATOR.cW(data);
                    }
                    mo2032a(createStringArrayList, ohVar, C1055a.aP(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: S */
    void mo2006S(boolean z) throws RemoteException;

    /* renamed from: a */
    void mo2007a(long j, boolean z, PendingIntent pendingIntent) throws RemoteException;

    /* renamed from: a */
    void mo2008a(PendingIntent pendingIntent) throws RemoteException;

    /* renamed from: a */
    void mo2009a(PendingIntent pendingIntent, nh nhVar, String str) throws RemoteException;

    /* renamed from: a */
    void mo2010a(Location location, int i) throws RemoteException;

    /* renamed from: a */
    void mo2011a(nh nhVar, String str) throws RemoteException;

    /* renamed from: a */
    void mo2012a(nl nlVar, PendingIntent pendingIntent) throws RemoteException;

    /* renamed from: a */
    void mo2013a(nl nlVar, C0517b c0517b) throws RemoteException;

    /* renamed from: a */
    void mo2014a(ns nsVar, oh ohVar, PendingIntent pendingIntent) throws RemoteException;

    /* renamed from: a */
    void mo2015a(nu nuVar, oh ohVar, og ogVar) throws RemoteException;

    /* renamed from: a */
    void mo2016a(nw nwVar, oh ohVar) throws RemoteException;

    /* renamed from: a */
    void mo2017a(ny nyVar, oh ohVar, PendingIntent pendingIntent) throws RemoteException;

    /* renamed from: a */
    void mo2018a(oc ocVar, oh ohVar, og ogVar) throws RemoteException;

    /* renamed from: a */
    void mo2019a(oe oeVar, LatLngBounds latLngBounds, List<String> list, oh ohVar, og ogVar) throws RemoteException;

    /* renamed from: a */
    void mo2020a(oh ohVar, PendingIntent pendingIntent) throws RemoteException;

    /* renamed from: a */
    void mo2021a(GeofencingRequest geofencingRequest, PendingIntent pendingIntent, nh nhVar) throws RemoteException;

    /* renamed from: a */
    void mo2022a(LocationRequest locationRequest, PendingIntent pendingIntent) throws RemoteException;

    /* renamed from: a */
    void mo2023a(LocationRequest locationRequest, C0517b c0517b) throws RemoteException;

    /* renamed from: a */
    void mo2024a(LocationRequest locationRequest, C0517b c0517b, String str) throws RemoteException;

    /* renamed from: a */
    void mo2025a(C0517b c0517b) throws RemoteException;

    /* renamed from: a */
    void mo2026a(LatLng latLng, nu nuVar, oh ohVar, og ogVar) throws RemoteException;

    /* renamed from: a */
    void mo2027a(LatLngBounds latLngBounds, int i, nu nuVar, oh ohVar, og ogVar) throws RemoteException;

    /* renamed from: a */
    void mo2028a(LatLngBounds latLngBounds, int i, String str, nu nuVar, oh ohVar, og ogVar) throws RemoteException;

    /* renamed from: a */
    void mo2029a(String str, oh ohVar, og ogVar) throws RemoteException;

    /* renamed from: a */
    void mo2030a(String str, LatLngBounds latLngBounds, nq nqVar, oh ohVar, og ogVar) throws RemoteException;

    /* renamed from: a */
    void mo2031a(List<nn> list, PendingIntent pendingIntent, nh nhVar, String str) throws RemoteException;

    /* renamed from: a */
    void mo2032a(List<String> list, oh ohVar, og ogVar) throws RemoteException;

    /* renamed from: a */
    void mo2033a(String[] strArr, nh nhVar, String str) throws RemoteException;

    /* renamed from: b */
    void mo2034b(PendingIntent pendingIntent) throws RemoteException;

    /* renamed from: b */
    void mo2035b(Location location) throws RemoteException;

    /* renamed from: b */
    void mo2036b(oh ohVar, PendingIntent pendingIntent) throws RemoteException;

    /* renamed from: b */
    void mo2037b(String str, oh ohVar, og ogVar) throws RemoteException;

    Location bZ(String str) throws RemoteException;

    C1087e ca(String str) throws RemoteException;

    Location ni() throws RemoteException;

    IBinder nj() throws RemoteException;

    IBinder nk() throws RemoteException;
}
