package com.google.android.gms.internal;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.gms.internal.ez.C0412a;
import com.google.android.gms.internal.fe.C0426a;
import com.google.android.gms.internal.fh.C0427a;
import com.google.android.gms.internal.fy.C0432a;
import org.json.JSONException;
import org.json.JSONObject;

@ey
public class fa extends gf implements C0426a {
    private final Context mContext;
    private final Object mH = new Object();
    private cr qi;
    private final C0412a ti;
    private final Object tj = new Object();
    private final C0427a tk;
    private final C0484k tl;
    private gf tm;
    private fj tn;

    /* renamed from: com.google.android.gms.internal.fa$1 */
    class C04161 implements Runnable {
        final /* synthetic */ fa to;

        C04161(fa faVar) {
            this.to = faVar;
        }

        public void run() {
            this.to.onStop();
        }
    }

    @ey
    /* renamed from: com.google.android.gms.internal.fa$a */
    private static final class C0418a extends Exception {
        private final int tq;

        public C0418a(String str, int i) {
            super(str);
            this.tq = i;
        }

        public int getErrorCode() {
            return this.tq;
        }
    }

    public fa(Context context, C0427a c0427a, C0484k c0484k, C0412a c0412a) {
        this.ti = c0412a;
        this.mContext = context;
        this.tk = c0427a;
        this.tl = c0484k;
    }

    /* renamed from: a */
    private ay m3157a(fh fhVar) throws C0418a {
        if (this.tn.tZ == null) {
            throw new C0418a("The ad response must specify one of the supported ad sizes.", 0);
        }
        String[] split = this.tn.tZ.split("x");
        if (split.length != 2) {
            throw new C0418a("Could not parse the ad size from the ad response: " + this.tn.tZ, 0);
        }
        try {
            int parseInt = Integer.parseInt(split[0]);
            int parseInt2 = Integer.parseInt(split[1]);
            for (ay ayVar : fhVar.lS.or) {
                float f = this.mContext.getResources().getDisplayMetrics().density;
                int i = ayVar.width == -1 ? (int) (((float) ayVar.widthPixels) / f) : ayVar.width;
                int i2 = ayVar.height == -2 ? (int) (((float) ayVar.heightPixels) / f) : ayVar.height;
                if (parseInt == i && parseInt2 == i2) {
                    return new ay(ayVar, fhVar.lS.or);
                }
            }
            throw new C0418a("The ad size from the ad response was not one of the requested sizes: " + this.tn.tZ, 0);
        } catch (NumberFormatException e) {
            throw new C0418a("Could not parse the ad size from the ad response: " + this.tn.tZ, 0);
        }
    }

    /* renamed from: c */
    private boolean m3160c(long j) throws C0418a {
        long elapsedRealtime = 60000 - (SystemClock.elapsedRealtime() - j);
        if (elapsedRealtime <= 0) {
            return false;
        }
        try {
            this.mH.wait(elapsedRealtime);
            return true;
        } catch (InterruptedException e) {
            throw new C0418a("Ad request cancelled.", -1);
        }
    }

    private void cE() throws C0418a {
        if (this.tn.errorCode != -3) {
            if (TextUtils.isEmpty(this.tn.tU)) {
                throw new C0418a("No fill from ad server.", 3);
            }
            ga.m3192a(this.mContext, this.tn.tT);
            if (this.tn.tW) {
                try {
                    this.qi = new cr(this.tn.tU);
                } catch (JSONException e) {
                    throw new C0418a("Could not parse mediation config: " + this.tn.tU, 0);
                }
            }
        }
    }

    /* renamed from: e */
    private void m3161e(long j) throws C0418a {
        while (m3160c(j)) {
            if (this.tn != null) {
                synchronized (this.tj) {
                    this.tm = null;
                }
                if (this.tn.errorCode != -2 && this.tn.errorCode != -3) {
                    throw new C0418a("There was a problem getting an ad response. ErrorCode: " + this.tn.errorCode, this.tn.errorCode);
                }
                return;
            }
        }
        throw new C0418a("Timed out waiting for ad response.", 2);
    }

    /* renamed from: t */
    private void m3162t(boolean z) {
        ga.dc().m3208x(z);
        an l = ga.dc().m3207l(this.mContext);
        if (l != null && !l.isAlive()) {
            gr.m1337S("start fetching content...");
            l.ba();
        }
    }

    /* renamed from: a */
    public void mo1791a(fj fjVar) {
        synchronized (this.mH) {
            gr.m1337S("Received ad response.");
            this.tn = fjVar;
            this.mH.notify();
        }
    }

    public void cx() {
        long elapsedRealtime;
        ay a;
        C0418a e;
        JSONObject jSONObject;
        final C0432a c0432a;
        synchronized (this.mH) {
            gr.m1337S("AdLoaderBackgroundTask started.");
            fh fhVar = new fh(this.tk, this.tl.m1591C().mo1798a(this.mContext));
            int i = -2;
            long j = -1;
            try {
                elapsedRealtime = SystemClock.elapsedRealtime();
                gf a2 = fe.m1206a(this.mContext, fhVar, this);
                synchronized (this.tj) {
                    this.tm = a2;
                    if (this.tm == null) {
                        throw new C0418a("Could not start the ad request service.", 0);
                    }
                }
                m3161e(elapsedRealtime);
                j = SystemClock.elapsedRealtime();
                cE();
                a = fhVar.lS.or != null ? m3157a(fhVar) : null;
                try {
                    m3162t(this.tn.uh);
                    elapsedRealtime = j;
                } catch (C0418a e2) {
                    e = e2;
                    i = e.getErrorCode();
                    if (i == 3 || i == -1) {
                        gr.m1339U(e.getMessage());
                    } else {
                        gr.m1341W(e.getMessage());
                    }
                    if (this.tn == null) {
                        this.tn = new fj(i);
                    } else {
                        this.tn = new fj(i, this.tn.qA);
                    }
                    gq.wR.post(new C04161(this));
                    elapsedRealtime = j;
                    if (!TextUtils.isEmpty(this.tn.ue)) {
                        try {
                            jSONObject = new JSONObject(this.tn.ue);
                        } catch (Throwable e3) {
                            gr.m1343b("Error parsing the JSON for Active View.", e3);
                        }
                        c0432a = new C0432a(fhVar, this.tn, this.qi, a, i, elapsedRealtime, this.tn.ua, jSONObject);
                        gq.wR.post(new Runnable(this) {
                            final /* synthetic */ fa to;

                            public void run() {
                                synchronized (this.to.mH) {
                                    this.to.ti.mo3584a(c0432a);
                                }
                            }
                        });
                    }
                    jSONObject = null;
                    c0432a = new C0432a(fhVar, this.tn, this.qi, a, i, elapsedRealtime, this.tn.ua, jSONObject);
                    gq.wR.post(/* anonymous class already generated */);
                }
            } catch (C0418a e4) {
                e = e4;
                a = null;
            }
            if (TextUtils.isEmpty(this.tn.ue)) {
                jSONObject = new JSONObject(this.tn.ue);
                c0432a = new C0432a(fhVar, this.tn, this.qi, a, i, elapsedRealtime, this.tn.ua, jSONObject);
                gq.wR.post(/* anonymous class already generated */);
            }
            jSONObject = null;
            c0432a = new C0432a(fhVar, this.tn, this.qi, a, i, elapsedRealtime, this.tn.ua, jSONObject);
            gq.wR.post(/* anonymous class already generated */);
        }
    }

    public void onStop() {
        synchronized (this.tj) {
            if (this.tm != null) {
                this.tm.cancel();
            }
        }
    }
}
