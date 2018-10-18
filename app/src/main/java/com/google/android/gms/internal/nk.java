package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.internal.jl.C0476b;
import com.google.android.gms.internal.nh.C1049a;
import com.google.android.gms.location.C1086c.C0518a;
import com.google.android.gms.location.C1086c.C0519b;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationStatusCodes;
import java.util.List;

public class nk extends nc {
    private final nj agX;
    private final mz agY;
    private final ie agZ;

    /* renamed from: com.google.android.gms.internal.nk$a */
    private final class C1052a extends C0476b<C0518a> {
        private final int Iv;
        private final String[] aha;
        final /* synthetic */ nk ahb;

        public C1052a(nk nkVar, C0518a c0518a, int i, String[] strArr) {
            this.ahb = nkVar;
            super(nkVar, c0518a);
            this.Iv = LocationStatusCodes.eC(i);
            this.aha = strArr;
        }

        /* renamed from: a */
        protected void m3485a(C0518a c0518a) {
            if (c0518a != null) {
                c0518a.mo1996a(this.Iv, this.aha);
            }
        }

        /* renamed from: g */
        protected /* synthetic */ void mo1853g(Object obj) {
            m3485a((C0518a) obj);
        }

        protected void hx() {
        }
    }

    /* renamed from: com.google.android.gms.internal.nk$c */
    private final class C1053c extends C0476b<C0519b> {
        private final int Iv;
        private final String[] aha;
        final /* synthetic */ nk ahb;
        private final int ahf;
        private final PendingIntent mPendingIntent;

        public C1053c(nk nkVar, int i, C0519b c0519b, int i2, PendingIntent pendingIntent) {
            boolean z = true;
            this.ahb = nkVar;
            super(nkVar, c0519b);
            if (i != 1) {
                z = false;
            }
            je.m1495K(z);
            this.ahf = i;
            this.Iv = LocationStatusCodes.eC(i2);
            this.mPendingIntent = pendingIntent;
            this.aha = null;
        }

        public C1053c(nk nkVar, int i, C0519b c0519b, int i2, String[] strArr) {
            this.ahb = nkVar;
            super(nkVar, c0519b);
            je.m1495K(i == 2);
            this.ahf = i;
            this.Iv = LocationStatusCodes.eC(i2);
            this.aha = strArr;
            this.mPendingIntent = null;
        }

        /* renamed from: a */
        protected void m3487a(C0519b c0519b) {
            if (c0519b != null) {
                switch (this.ahf) {
                    case 1:
                        c0519b.mo1997a(this.Iv, this.mPendingIntent);
                        return;
                    case 2:
                        c0519b.mo1998b(this.Iv, this.aha);
                        return;
                    default:
                        Log.wtf("LocationClientImpl", "Unsupported action: " + this.ahf);
                        return;
                }
            }
        }

        /* renamed from: g */
        protected /* synthetic */ void mo1853g(Object obj) {
            m3487a((C0519b) obj);
        }

        protected void hx() {
        }
    }

    /* renamed from: com.google.android.gms.internal.nk$b */
    private static final class C1417b extends C1049a {
        private C0518a ahc;
        private C0519b ahd;
        private nk ahe;

        public C1417b(C0518a c0518a, nk nkVar) {
            this.ahc = c0518a;
            this.ahd = null;
            this.ahe = nkVar;
        }

        public C1417b(C0519b c0519b, nk nkVar) {
            this.ahd = c0519b;
            this.ahc = null;
            this.ahe = nkVar;
        }

        /* renamed from: a */
        public void mo2003a(int i, PendingIntent pendingIntent) {
            if (this.ahe == null) {
                Log.wtf("LocationClientImpl", "onRemoveGeofencesByPendingIntentResult called multiple times");
                return;
            }
            nk nkVar = this.ahe;
            nk nkVar2 = this.ahe;
            nkVar2.getClass();
            nkVar.m3310a(new C1053c(nkVar2, 1, this.ahd, i, pendingIntent));
            this.ahe = null;
            this.ahc = null;
            this.ahd = null;
        }

        /* renamed from: a */
        public void mo2004a(int i, String[] strArr) throws RemoteException {
            if (this.ahe == null) {
                Log.wtf("LocationClientImpl", "onAddGeofenceResult called multiple times");
                return;
            }
            nk nkVar = this.ahe;
            nk nkVar2 = this.ahe;
            nkVar2.getClass();
            nkVar.m3310a(new C1052a(nkVar2, this.ahc, i, strArr));
            this.ahe = null;
            this.ahc = null;
            this.ahd = null;
        }

        /* renamed from: b */
        public void mo2005b(int i, String[] strArr) {
            if (this.ahe == null) {
                Log.wtf("LocationClientImpl", "onRemoveGeofencesByRequestIdsResult called multiple times");
                return;
            }
            nk nkVar = this.ahe;
            nk nkVar2 = this.ahe;
            nkVar2.getClass();
            nkVar.m3310a(new C1053c(nkVar2, 2, this.ahd, i, strArr));
            this.ahe = null;
            this.ahc = null;
            this.ahd = null;
        }
    }

    public nk(Context context, Looper looper, String str, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String str2) {
        this(context, looper, str, connectionCallbacks, onConnectionFailedListener, str2, null);
    }

    public nk(Context context, Looper looper, String str, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String str2, String str3) {
        this(context, looper, str, connectionCallbacks, onConnectionFailedListener, str2, str3, null);
    }

    public nk(Context context, Looper looper, String str, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String str2, String str3, String str4) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, str2);
        this.agX = new nj(context, this.Ee);
        this.agY = mz.m1695a(context, str3, str4, this.Ee);
        this.agZ = ie.m1436a(context, this.Ee);
    }

    /* renamed from: S */
    public void m4943S(boolean z) throws RemoteException {
        this.agX.m1736S(z);
    }

    /* renamed from: a */
    public void m4944a(long j, PendingIntent pendingIntent) throws RemoteException {
        dS();
        jx.m1582i(pendingIntent);
        jx.m1580b(j >= 0, (Object) "detectionIntervalMillis must be >= 0");
        ((ni) hw()).mo2007a(j, true, pendingIntent);
    }

    /* renamed from: a */
    public void m4945a(PendingIntent pendingIntent) throws RemoteException {
        dS();
        jx.m1582i(pendingIntent);
        ((ni) hw()).mo2008a(pendingIntent);
    }

    /* renamed from: a */
    public void m4946a(PendingIntent pendingIntent, C0519b c0519b) throws RemoteException {
        nh nhVar;
        dS();
        jx.m1578b((Object) pendingIntent, (Object) "PendingIntent must be specified.");
        jx.m1578b((Object) c0519b, (Object) "OnRemoveGeofencesResultListener not provided.");
        if (c0519b == null) {
            nhVar = null;
        } else {
            Object c1417b = new C1417b(c0519b, this);
        }
        ((ni) hw()).mo2009a(pendingIntent, nhVar, getContext().getPackageName());
    }

    /* renamed from: a */
    public void m4947a(GeofencingRequest geofencingRequest, PendingIntent pendingIntent, C0518a c0518a) throws RemoteException {
        nh nhVar;
        dS();
        jx.m1578b((Object) geofencingRequest, (Object) "geofencingRequest can't be null.");
        jx.m1578b((Object) pendingIntent, (Object) "PendingIntent must be specified.");
        jx.m1578b((Object) c0518a, (Object) "OnAddGeofencesResultListener not provided.");
        if (c0518a == null) {
            nhVar = null;
        } else {
            Object c1417b = new C1417b(c0518a, this);
        }
        ((ni) hw()).mo2021a(geofencingRequest, pendingIntent, nhVar);
    }

    /* renamed from: a */
    public void m4948a(LocationListener locationListener) throws RemoteException {
        this.agX.m1737a(locationListener);
    }

    /* renamed from: a */
    public void m4949a(LocationRequest locationRequest, LocationListener locationListener, Looper looper) throws RemoteException {
        synchronized (this.agX) {
            this.agX.m1738a(locationRequest, locationListener, looper);
        }
    }

    /* renamed from: a */
    public void m4950a(List<String> list, C0519b c0519b) throws RemoteException {
        nh nhVar;
        dS();
        boolean z = list != null && list.size() > 0;
        jx.m1580b(z, (Object) "geofenceRequestIds can't be null nor empty.");
        jx.m1578b((Object) c0519b, (Object) "OnRemoveGeofencesResultListener not provided.");
        String[] strArr = (String[]) list.toArray(new String[0]);
        if (c0519b == null) {
            nhVar = null;
        } else {
            Object c1417b = new C1417b(c0519b, this);
        }
        ((ni) hw()).mo2033a(strArr, nhVar, getContext().getPackageName());
    }

    /* renamed from: b */
    public void m4951b(Location location) throws RemoteException {
        this.agX.m1739b(location);
    }

    /* renamed from: b */
    public void m4952b(LocationRequest locationRequest, PendingIntent pendingIntent) throws RemoteException {
        this.agX.m1740b(locationRequest, pendingIntent);
    }

    /* renamed from: c */
    public void m4953c(PendingIntent pendingIntent) throws RemoteException {
        this.agX.m1741c(pendingIntent);
    }

    public void disconnect() {
        synchronized (this.agX) {
            if (isConnected()) {
                try {
                    this.agX.removeAllListeners();
                    this.agX.nm();
                } catch (Throwable e) {
                    Log.e("LocationClientImpl", "Client disconnected before listeners could be cleaned up", e);
                }
            }
            super.disconnect();
        }
    }

    public Location nl() {
        return this.agX.nl();
    }
}
