package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.ContentProviderClient;
import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.location.C0517b;
import com.google.android.gms.location.C0517b.C1085a;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import java.util.HashMap;

public class nj {
    private final np<ni> Ee;
    private ContentProviderClient agS = null;
    private boolean agT = false;
    private HashMap<LocationListener, C1416b> agU = new HashMap();
    private final Context mContext;

    /* renamed from: com.google.android.gms.internal.nj$a */
    private static class C0490a extends Handler {
        private final LocationListener agV;

        public C0490a(LocationListener locationListener) {
            this.agV = locationListener;
        }

        public C0490a(LocationListener locationListener, Looper looper) {
            super(looper);
            this.agV = locationListener;
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    this.agV.onLocationChanged(new Location((Location) msg.obj));
                    return;
                default:
                    Log.e("LocationClientHelper", "unknown message in LocationHandler.handleMessage");
                    return;
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.nj$b */
    private static class C1416b extends C1085a {
        private Handler agW;

        C1416b(LocationListener locationListener, Looper looper) {
            this.agW = looper == null ? new C0490a(locationListener) : new C0490a(locationListener, looper);
        }

        public void onLocationChanged(Location location) {
            if (this.agW == null) {
                Log.e("LocationClientHelper", "Received a location in client after calling removeLocationUpdates.");
                return;
            }
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.obj = location;
            this.agW.sendMessage(obtain);
        }

        public void release() {
            this.agW = null;
        }
    }

    public nj(Context context, np<ni> npVar) {
        this.mContext = context;
        this.Ee = npVar;
    }

    /* renamed from: a */
    private C1416b m1735a(LocationListener locationListener, Looper looper) {
        C1416b c1416b;
        if (looper == null) {
            jx.m1578b(Looper.myLooper(), (Object) "Can't create handler inside thread that has not called Looper.prepare()");
        }
        synchronized (this.agU) {
            c1416b = (C1416b) this.agU.get(locationListener);
            if (c1416b == null) {
                c1416b = new C1416b(locationListener, looper);
            }
            this.agU.put(locationListener, c1416b);
        }
        return c1416b;
    }

    /* renamed from: S */
    public void m1736S(boolean z) throws RemoteException {
        this.Ee.dS();
        ((ni) this.Ee.hw()).mo2006S(z);
        this.agT = z;
    }

    /* renamed from: a */
    public void m1737a(LocationListener locationListener) throws RemoteException {
        this.Ee.dS();
        jx.m1578b((Object) locationListener, (Object) "Invalid null listener");
        synchronized (this.agU) {
            C0517b c0517b = (C1416b) this.agU.remove(locationListener);
            if (this.agS != null && this.agU.isEmpty()) {
                this.agS.release();
                this.agS = null;
            }
            if (c0517b != null) {
                c0517b.release();
                ((ni) this.Ee.hw()).mo2025a(c0517b);
            }
        }
    }

    /* renamed from: a */
    public void m1738a(LocationRequest locationRequest, LocationListener locationListener, Looper looper) throws RemoteException {
        this.Ee.dS();
        ((ni) this.Ee.hw()).mo2023a(locationRequest, m1735a(locationListener, looper));
    }

    /* renamed from: b */
    public void m1739b(Location location) throws RemoteException {
        this.Ee.dS();
        ((ni) this.Ee.hw()).mo2035b(location);
    }

    /* renamed from: b */
    public void m1740b(LocationRequest locationRequest, PendingIntent pendingIntent) throws RemoteException {
        this.Ee.dS();
        ((ni) this.Ee.hw()).mo2022a(locationRequest, pendingIntent);
    }

    /* renamed from: c */
    public void m1741c(PendingIntent pendingIntent) throws RemoteException {
        this.Ee.dS();
        ((ni) this.Ee.hw()).mo2034b(pendingIntent);
    }

    public Location nl() {
        this.Ee.dS();
        try {
            return ((ni) this.Ee.hw()).bZ(this.mContext.getPackageName());
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public void nm() {
        if (this.agT) {
            try {
                m1736S(false);
            } catch (Throwable e) {
                throw new IllegalStateException(e);
            }
        }
    }

    public void removeAllListeners() {
        try {
            synchronized (this.agU) {
                for (C0517b c0517b : this.agU.values()) {
                    if (c0517b != null) {
                        ((ni) this.Ee.hw()).mo2025a(c0517b);
                    }
                }
                this.agU.clear();
            }
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }
}
