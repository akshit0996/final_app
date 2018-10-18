package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Process;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.internal.ld;
import com.google.android.gms.internal.lf;
import java.io.IOException;

/* renamed from: com.google.android.gms.tagmanager.a */
class C0610a {
    private static C0610a aqa;
    private static Object xO = new Object();
    private volatile long apW;
    private volatile long apX;
    private volatile long apY;
    private C0609a apZ;
    private volatile boolean mClosed;
    private final Context mContext;
    private final ld wb;
    private final Thread wu;
    private volatile Info xQ;

    /* renamed from: com.google.android.gms.tagmanager.a$2 */
    class C06082 implements Runnable {
        final /* synthetic */ C0610a aqb;

        C06082(C0610a c0610a) {
            this.aqb = c0610a;
        }

        public void run() {
            this.aqb.pb();
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.a$a */
    public interface C0609a {
        Info pd();
    }

    /* renamed from: com.google.android.gms.tagmanager.a$1 */
    class C12111 implements C0609a {
        final /* synthetic */ C0610a aqb;

        C12111(C0610a c0610a) {
            this.aqb = c0610a;
        }

        public Info pd() {
            Info info = null;
            try {
                info = AdvertisingIdClient.getAdvertisingIdInfo(this.aqb.mContext);
            } catch (IllegalStateException e) {
                bh.m2117W("IllegalStateException getting Advertising Id Info");
            } catch (GooglePlayServicesRepairableException e2) {
                bh.m2117W("GooglePlayServicesRepairableException getting Advertising Id Info");
            } catch (IOException e3) {
                bh.m2117W("IOException getting Ad Id Info");
            } catch (GooglePlayServicesNotAvailableException e4) {
                bh.m2117W("GooglePlayServicesNotAvailableException getting Advertising Id Info");
            } catch (Exception e5) {
                bh.m2117W("Unknown exception. Could not get the Advertising Id Info.");
            }
            return info;
        }
    }

    private C0610a(Context context) {
        this(context, null, lf.m3403if());
    }

    C0610a(Context context, C0609a c0609a, ld ldVar) {
        this.apW = 900000;
        this.apX = 30000;
        this.mClosed = false;
        this.apZ = new C12111(this);
        this.wb = ldVar;
        if (context != null) {
            this.mContext = context.getApplicationContext();
        } else {
            this.mContext = context;
        }
        if (c0609a != null) {
            this.apZ = c0609a;
        }
        this.wu = new Thread(new C06082(this));
    }

    /* renamed from: W */
    static C0610a m2090W(Context context) {
        if (aqa == null) {
            synchronized (xO) {
                if (aqa == null) {
                    aqa = new C0610a(context);
                    aqa.start();
                }
            }
        }
        return aqa;
    }

    private void pb() {
        Process.setThreadPriority(10);
        while (!this.mClosed) {
            try {
                this.xQ = this.apZ.pd();
                Thread.sleep(this.apW);
            } catch (InterruptedException e) {
                bh.m2115U("sleep interrupted in AdvertiserDataPoller thread; continuing");
            }
        }
    }

    private void pc() {
        if (this.wb.currentTimeMillis() - this.apY >= this.apX) {
            interrupt();
            this.apY = this.wb.currentTimeMillis();
        }
    }

    void interrupt() {
        this.wu.interrupt();
    }

    public boolean isLimitAdTrackingEnabled() {
        pc();
        return this.xQ == null ? true : this.xQ.isLimitAdTrackingEnabled();
    }

    public String pa() {
        pc();
        return this.xQ == null ? null : this.xQ.getId();
    }

    void start() {
        this.wu.start();
    }
}
