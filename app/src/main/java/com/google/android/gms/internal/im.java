package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.Cast.ApplicationConnectionResult;
import com.google.android.gms.cast.Cast.Listener;
import com.google.android.gms.cast.Cast.MessageReceivedCallback;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.BaseImplementation.C0155b;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.iq.C0992a;
import com.google.android.gms.internal.ir.C0993a;
import com.google.android.gms.internal.jl.C1399e;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

public final class im extends jl<iq> {
    private static final Object HB = new Object();
    private static final Object HC = new Object();
    private static final is Hh = new is("CastClientImpl");
    private final Listener FD;
    private double Gp;
    private boolean Gq;
    private C0155b<Status> HA;
    private ApplicationMetadata Hi;
    private final CastDevice Hj;
    private final Map<String, MessageReceivedCallback> Hk = new HashMap();
    private final long Hl;
    private C1398c Hm;
    private String Hn;
    private boolean Ho;
    private boolean Hp;
    private boolean Hq;
    private int Hr;
    private int Hs;
    private final AtomicLong Ht = new AtomicLong(0);
    private String Hu;
    private String Hv;
    private Bundle Hw;
    private final Map<Long, C0155b<Status>> Hx = new HashMap();
    private final C1397b Hy;
    private C0155b<ApplicationConnectionResult> Hz;
    private final Handler mHandler;

    /* renamed from: com.google.android.gms.internal.im$a */
    private static final class C1396a implements ApplicationConnectionResult {
        private final Status Eb;
        private final ApplicationMetadata HD;
        private final String HE;
        private final boolean HF;
        private final String vZ;

        public C1396a(Status status) {
            this(status, null, null, null, false);
        }

        public C1396a(Status status, ApplicationMetadata applicationMetadata, String str, String str2, boolean z) {
            this.Eb = status;
            this.HD = applicationMetadata;
            this.HE = str;
            this.vZ = str2;
            this.HF = z;
        }

        public ApplicationMetadata getApplicationMetadata() {
            return this.HD;
        }

        public String getApplicationStatus() {
            return this.HE;
        }

        public String getSessionId() {
            return this.vZ;
        }

        public Status getStatus() {
            return this.Eb;
        }

        public boolean getWasLaunched() {
            return this.HF;
        }
    }

    /* renamed from: com.google.android.gms.internal.im$b */
    private class C1397b implements OnConnectionFailedListener {
        final /* synthetic */ im HG;

        private C1397b(im imVar) {
            this.HG = imVar;
        }

        public void onConnectionFailed(ConnectionResult result) {
            this.HG.ga();
        }
    }

    /* renamed from: com.google.android.gms.internal.im$c */
    private class C1398c extends C0993a {
        final /* synthetic */ im HG;
        private final AtomicBoolean HH;

        private C1398c(im imVar) {
            this.HG = imVar;
            this.HH = new AtomicBoolean(false);
        }

        private boolean ah(int i) {
            synchronized (im.HC) {
                if (this.HG.HA != null) {
                    this.HG.HA.mo908b(new Status(i));
                    this.HG.HA = null;
                    return true;
                }
                return false;
            }
        }

        /* renamed from: c */
        private void m4417c(long j, int i) {
            synchronized (this.HG.Hx) {
                C0155b c0155b = (C0155b) this.HG.Hx.remove(Long.valueOf(j));
            }
            if (c0155b != null) {
                c0155b.mo908b(new Status(i));
            }
        }

        /* renamed from: a */
        public void mo3333a(ApplicationMetadata applicationMetadata, String str, String str2, boolean z) {
            if (!this.HH.get()) {
                this.HG.Hi = applicationMetadata;
                this.HG.Hu = applicationMetadata.getApplicationId();
                this.HG.Hv = str2;
                synchronized (im.HB) {
                    if (this.HG.Hz != null) {
                        this.HG.Hz.mo908b(new C1396a(new Status(0), applicationMetadata, str, str2, z));
                        this.HG.Hz = null;
                    }
                }
            }
        }

        /* renamed from: a */
        public void mo3334a(String str, double d, boolean z) {
            im.Hh.m1470b("Deprecated callback: \"onStatusreceived\"", new Object[0]);
        }

        /* renamed from: a */
        public void mo3335a(String str, long j) {
            if (!this.HH.get()) {
                m4417c(j, 0);
            }
        }

        /* renamed from: a */
        public void mo3336a(String str, long j, int i) {
            if (!this.HH.get()) {
                m4417c(j, i);
            }
        }

        public void ad(int i) {
            if (gg()) {
                im.Hh.m1470b("ICastDeviceControllerListener.onDisconnected: %d", Integer.valueOf(i));
                if (i != 0) {
                    this.HG.aD(2);
                }
            }
        }

        public void ae(int i) {
            if (!this.HH.get()) {
                synchronized (im.HB) {
                    if (this.HG.Hz != null) {
                        this.HG.Hz.mo908b(new C1396a(new Status(i)));
                        this.HG.Hz = null;
                    }
                }
            }
        }

        public void af(int i) {
            if (!this.HH.get()) {
                ah(i);
            }
        }

        public void ag(int i) {
            if (!this.HH.get()) {
                ah(i);
            }
        }

        /* renamed from: b */
        public void mo3341b(final ij ijVar) {
            if (!this.HH.get()) {
                im.Hh.m1470b("onApplicationStatusChanged", new Object[0]);
                this.HG.mHandler.post(new Runnable(this) {
                    final /* synthetic */ C1398c HJ;

                    public void run() {
                        this.HJ.HG.m4429a(ijVar);
                    }
                });
            }
        }

        /* renamed from: b */
        public void mo3342b(final io ioVar) {
            if (!this.HH.get()) {
                im.Hh.m1470b("onDeviceStatusChanged", new Object[0]);
                this.HG.mHandler.post(new Runnable(this) {
                    final /* synthetic */ C1398c HJ;

                    public void run() {
                        this.HJ.HG.m4432a(ioVar);
                    }
                });
            }
        }

        /* renamed from: b */
        public void mo3343b(String str, byte[] bArr) {
            if (!this.HH.get()) {
                im.Hh.m1470b("IGNORING: Receive (type=binary, ns=%s) <%d bytes>", str, Integer.valueOf(bArr.length));
            }
        }

        public boolean gg() {
            if (this.HH.getAndSet(true)) {
                return false;
            }
            this.HG.fW();
            return true;
        }

        public boolean gh() {
            return this.HH.get();
        }

        /* renamed from: j */
        public void mo3344j(final String str, final String str2) {
            if (!this.HH.get()) {
                im.Hh.m1470b("Receive (type=text, ns=%s) %s", str, str2);
                this.HG.mHandler.post(new Runnable(this) {
                    final /* synthetic */ C1398c HJ;

                    public void run() {
                        synchronized (this.HJ.HG.Hk) {
                            MessageReceivedCallback messageReceivedCallback = (MessageReceivedCallback) this.HJ.HG.Hk.get(str);
                        }
                        if (messageReceivedCallback != null) {
                            messageReceivedCallback.onMessageReceived(this.HJ.HG.Hj, str, str2);
                            return;
                        }
                        im.Hh.m1470b("Discarded message for unknown namespace '%s'", str);
                    }
                });
            }
        }

        public void onApplicationDisconnected(final int statusCode) {
            if (!this.HH.get()) {
                this.HG.Hu = null;
                this.HG.Hv = null;
                ah(statusCode);
                if (this.HG.FD != null) {
                    this.HG.mHandler.post(new Runnable(this) {
                        final /* synthetic */ C1398c HJ;

                        public void run() {
                            if (this.HJ.HG.FD != null) {
                                this.HJ.HG.FD.onApplicationDisconnected(statusCode);
                            }
                        }
                    });
                }
            }
        }
    }

    public im(Context context, Looper looper, CastDevice castDevice, long j, Listener listener, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, (String[]) null);
        this.Hj = castDevice;
        this.FD = listener;
        this.Hl = j;
        this.mHandler = new Handler(looper);
        fW();
        this.Hy = new C1397b();
        registerConnectionFailedListener(this.Hy);
    }

    /* renamed from: a */
    private void m4429a(ij ijVar) {
        boolean z;
        String fT = ijVar.fT();
        if (in.m1447a(fT, this.Hn)) {
            z = false;
        } else {
            this.Hn = fT;
            z = true;
        }
        Hh.m1470b("hasChanged=%b, mFirstApplicationStatusUpdate=%b", Boolean.valueOf(z), Boolean.valueOf(this.Ho));
        if (this.FD != null && (z || this.Ho)) {
            this.FD.onApplicationStatusChanged();
        }
        this.Ho = false;
    }

    /* renamed from: a */
    private void m4432a(io ioVar) {
        boolean z;
        ApplicationMetadata applicationMetadata = ioVar.getApplicationMetadata();
        if (!in.m1447a(applicationMetadata, this.Hi)) {
            this.Hi = applicationMetadata;
            this.FD.onApplicationMetadataChanged(this.Hi);
        }
        double fZ = ioVar.fZ();
        if (fZ == Double.NaN || fZ == this.Gp) {
            z = false;
        } else {
            this.Gp = fZ;
            z = true;
        }
        boolean gi = ioVar.gi();
        if (gi != this.Gq) {
            this.Gq = gi;
            z = true;
        }
        Hh.m1470b("hasVolumeChanged=%b, mFirstDeviceStatusUpdate=%b", Boolean.valueOf(z), Boolean.valueOf(this.Hp));
        if (this.FD != null && (z || this.Hp)) {
            this.FD.onVolumeChanged();
        }
        int gj = ioVar.gj();
        if (gj != this.Hr) {
            this.Hr = gj;
            z = true;
        } else {
            z = false;
        }
        Hh.m1470b("hasActiveInputChanged=%b, mFirstDeviceStatusUpdate=%b", Boolean.valueOf(z), Boolean.valueOf(this.Hp));
        if (this.FD != null && (z || this.Hp)) {
            this.FD.m98X(this.Hr);
        }
        gj = ioVar.gk();
        if (gj != this.Hs) {
            this.Hs = gj;
            z = true;
        } else {
            z = false;
        }
        Hh.m1470b("hasStandbyStateChanged=%b, mFirstDeviceStatusUpdate=%b", Boolean.valueOf(z), Boolean.valueOf(this.Hp));
        if (this.FD != null && (z || this.Hp)) {
            this.FD.m99Y(this.Hs);
        }
        this.Hp = false;
    }

    /* renamed from: c */
    private void m4436c(C0155b<ApplicationConnectionResult> c0155b) {
        synchronized (HB) {
            if (this.Hz != null) {
                this.Hz.mo908b(new C1396a(new Status(2002)));
            }
            this.Hz = c0155b;
        }
    }

    /* renamed from: e */
    private void m4440e(C0155b<Status> c0155b) {
        synchronized (HC) {
            if (this.HA != null) {
                c0155b.mo908b(new Status(2001));
                return;
            }
            this.HA = c0155b;
        }
    }

    private void fW() {
        this.Hq = false;
        this.Hr = -1;
        this.Hs = -1;
        this.Hi = null;
        this.Hn = null;
        this.Gp = 0.0d;
        this.Gq = false;
    }

    private void ga() {
        Hh.m1470b("removing all MessageReceivedCallbacks", new Object[0]);
        synchronized (this.Hk) {
            this.Hk.clear();
        }
    }

    private void gb() throws IllegalStateException {
        if (!this.Hq || this.Hm == null || this.Hm.gh()) {
            throw new IllegalStateException("Not connected to a device");
        }
    }

    /* renamed from: I */
    public void m4446I(boolean z) throws IllegalStateException, RemoteException {
        ((iq) hw()).mo1841a(z, this.Gp, this.Gq);
    }

    /* renamed from: L */
    protected iq m4447L(IBinder iBinder) {
        return C0992a.m3274M(iBinder);
    }

    /* renamed from: a */
    public void m4448a(double d) throws IllegalArgumentException, IllegalStateException, RemoteException {
        if (Double.isInfinite(d) || Double.isNaN(d)) {
            throw new IllegalArgumentException("Volume cannot be " + d);
        }
        ((iq) hw()).mo1837a(d, this.Gp, this.Gq);
    }

    /* renamed from: a */
    protected void mo2968a(int i, IBinder iBinder, Bundle bundle) {
        Hh.m1470b("in onPostInitHandler; statusCode=%d", Integer.valueOf(i));
        if (i == 0 || i == 1001) {
            this.Hq = true;
            this.Ho = true;
            this.Hp = true;
        } else {
            this.Hq = false;
        }
        if (i == 1001) {
            this.Hw = new Bundle();
            this.Hw.putBoolean(Cast.EXTRA_APP_NO_LONGER_RUNNING, true);
            i = 0;
        }
        super.mo2968a(i, iBinder, bundle);
    }

    /* renamed from: a */
    protected void mo2969a(jt jtVar, C1399e c1399e) throws RemoteException {
        Bundle bundle = new Bundle();
        Hh.m1470b("getServiceFromBroker(): mLastApplicationId=%s, mLastSessionId=%s", this.Hu, this.Hv);
        this.Hj.putInBundle(bundle);
        bundle.putLong("com.google.android.gms.cast.EXTRA_CAST_FLAGS", this.Hl);
        if (this.Hu != null) {
            bundle.putString("last_application_id", this.Hu);
            if (this.Hv != null) {
                bundle.putString("last_session_id", this.Hv);
            }
        }
        this.Hm = new C1398c();
        jtVar.mo1865a((js) c1399e, (int) GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName(), this.Hm.asBinder(), bundle);
    }

    /* renamed from: a */
    public void m4451a(String str, MessageReceivedCallback messageReceivedCallback) throws IllegalArgumentException, IllegalStateException, RemoteException {
        in.aF(str);
        aE(str);
        if (messageReceivedCallback != null) {
            synchronized (this.Hk) {
                this.Hk.put(str, messageReceivedCallback);
            }
            ((iq) hw()).aI(str);
        }
    }

    /* renamed from: a */
    public void m4452a(String str, LaunchOptions launchOptions, C0155b<ApplicationConnectionResult> c0155b) throws IllegalStateException, RemoteException {
        m4436c((C0155b) c0155b);
        ((iq) hw()).mo1838a(str, launchOptions);
    }

    /* renamed from: a */
    public void m4453a(String str, C0155b<Status> c0155b) throws IllegalStateException, RemoteException {
        m4440e((C0155b) c0155b);
        ((iq) hw()).aH(str);
    }

    /* renamed from: a */
    public void m4454a(String str, String str2, C0155b<Status> c0155b) throws IllegalArgumentException, IllegalStateException, RemoteException {
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("The message payload cannot be null or empty");
        } else if (str2.length() > 65536) {
            throw new IllegalArgumentException("Message exceeds maximum size");
        } else {
            in.aF(str);
            gb();
            long incrementAndGet = this.Ht.incrementAndGet();
            try {
                this.Hx.put(Long.valueOf(incrementAndGet), c0155b);
                ((iq) hw()).mo1839a(str, str2, incrementAndGet);
            } catch (Throwable th) {
                this.Hx.remove(Long.valueOf(incrementAndGet));
            }
        }
    }

    /* renamed from: a */
    public void m4455a(String str, boolean z, C0155b<ApplicationConnectionResult> c0155b) throws IllegalStateException, RemoteException {
        m4436c((C0155b) c0155b);
        ((iq) hw()).mo1847g(str, z);
    }

    public void aE(String str) throws IllegalArgumentException, RemoteException {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Channel namespace cannot be null or empty");
        }
        synchronized (this.Hk) {
            MessageReceivedCallback messageReceivedCallback = (MessageReceivedCallback) this.Hk.remove(str);
        }
        if (messageReceivedCallback != null) {
            try {
                ((iq) hw()).aJ(str);
            } catch (Throwable e) {
                Hh.m1469a(e, "Error unregistering namespace (%s): %s", str, e.getMessage());
            }
        }
    }

    /* renamed from: b */
    public void m4456b(String str, String str2, C0155b<ApplicationConnectionResult> c0155b) throws IllegalStateException, RemoteException {
        m4436c((C0155b) c0155b);
        ((iq) hw()).mo1849k(str, str2);
    }

    protected String bK() {
        return "com.google.android.gms.cast.service.BIND_CAST_DEVICE_CONTROLLER_SERVICE";
    }

    protected String bL() {
        return "com.google.android.gms.cast.internal.ICastDeviceController";
    }

    /* renamed from: d */
    public void m4457d(C0155b<Status> c0155b) throws IllegalStateException, RemoteException {
        m4440e((C0155b) c0155b);
        ((iq) hw()).gl();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void disconnect() {
        /*
        r6 = this;
        r5 = 1;
        r4 = 0;
        r0 = Hh;
        r1 = "disconnect(); ServiceListener=%s, isConnected=%b";
        r2 = 2;
        r2 = new java.lang.Object[r2];
        r3 = r6.Hm;
        r2[r4] = r3;
        r3 = r6.isConnected();
        r3 = java.lang.Boolean.valueOf(r3);
        r2[r5] = r3;
        r0.m1470b(r1, r2);
        r0 = r6.Hm;
        r1 = 0;
        r6.Hm = r1;
        if (r0 == 0) goto L_0x0027;
    L_0x0021:
        r0 = r0.gg();
        if (r0 != 0) goto L_0x0031;
    L_0x0027:
        r0 = Hh;
        r1 = "already disposed, so short-circuiting";
        r2 = new java.lang.Object[r4];
        r0.m1470b(r1, r2);
    L_0x0030:
        return;
    L_0x0031:
        r6.ga();
        r0 = r6.isConnected();	 Catch:{ RemoteException -> 0x004d }
        if (r0 != 0) goto L_0x0040;
    L_0x003a:
        r0 = r6.isConnecting();	 Catch:{ RemoteException -> 0x004d }
        if (r0 == 0) goto L_0x0049;
    L_0x0040:
        r0 = r6.hw();	 Catch:{ RemoteException -> 0x004d }
        r0 = (com.google.android.gms.internal.iq) r0;	 Catch:{ RemoteException -> 0x004d }
        r0.disconnect();	 Catch:{ RemoteException -> 0x004d }
    L_0x0049:
        super.disconnect();
        goto L_0x0030;
    L_0x004d:
        r0 = move-exception;
        r1 = Hh;	 Catch:{ all -> 0x0063 }
        r2 = "Error while disconnecting the controller interface: %s";
        r3 = 1;
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x0063 }
        r4 = 0;
        r5 = r0.getMessage();	 Catch:{ all -> 0x0063 }
        r3[r4] = r5;	 Catch:{ all -> 0x0063 }
        r1.m1469a(r0, r2, r3);	 Catch:{ all -> 0x0063 }
        super.disconnect();
        goto L_0x0030;
    L_0x0063:
        r0 = move-exception;
        super.disconnect();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.im.disconnect():void");
    }

    public Bundle fX() {
        if (this.Hw == null) {
            return super.fX();
        }
        Bundle bundle = this.Hw;
        this.Hw = null;
        return bundle;
    }

    public void fY() throws IllegalStateException, RemoteException {
        ((iq) hw()).fY();
    }

    public double fZ() throws IllegalStateException {
        gb();
        return this.Gp;
    }

    public ApplicationMetadata getApplicationMetadata() throws IllegalStateException {
        gb();
        return this.Hi;
    }

    public String getApplicationStatus() throws IllegalStateException {
        gb();
        return this.Hn;
    }

    public boolean isMute() throws IllegalStateException {
        gb();
        return this.Gq;
    }

    /* renamed from: l */
    protected /* synthetic */ IInterface mo2972l(IBinder iBinder) {
        return m4447L(iBinder);
    }
}
