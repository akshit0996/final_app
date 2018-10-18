package com.google.android.gms.analytics;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.analytics.C0144y.C0143a;
import com.google.android.gms.analytics.GoogleAnalytics.C0107a;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.ld;
import com.google.android.gms.internal.lf;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

public class Tracker {
    private final TrackerHandler Ce;
    private final Map<String, String> Cf;
    private ah Cg;
    private final C0785k Ch;
    private final ai Ci;
    private final C0782g Cj;
    private boolean Ck;
    private C0778a Cl;
    private am Cm;
    private ExceptionReporter Cn;
    private Context mContext;
    private final Map<String, String> rd;

    /* renamed from: com.google.android.gms.analytics.Tracker$a */
    private class C0778a implements C0107a {
        private boolean Co = false;
        private int Cp = 0;
        private long Cq = -1;
        private boolean Cr = false;
        private long Cs;
        final /* synthetic */ Tracker Ct;
        private ld wb = lf.m3403if();

        public C0778a(Tracker tracker) {
            this.Ct = tracker;
        }

        private void fq() {
            GoogleAnalytics eY = GoogleAnalytics.eY();
            if (eY == null) {
                ae.m42T("GoogleAnalytics isn't initialized for the Tracker!");
            } else if (this.Cq >= 0 || this.Co) {
                eY.m2343a(this.Ct.Cl);
            } else {
                eY.m2345b(this.Ct.Cl);
            }
        }

        public void enableAutoActivityTracking(boolean enabled) {
            this.Co = enabled;
            fq();
        }

        public long fn() {
            return this.Cq;
        }

        public boolean fo() {
            return this.Co;
        }

        public boolean fp() {
            boolean z = this.Cr;
            this.Cr = false;
            return z;
        }

        boolean fr() {
            return this.wb.elapsedRealtime() >= this.Cs + Math.max(1000, this.Cq);
        }

        /* renamed from: i */
        public void mo814i(Activity activity) {
            C0144y.eK().m86a(C0143a.EASY_TRACKER_ACTIVITY_START);
            if (this.Cp == 0 && fr()) {
                this.Cr = true;
            }
            this.Cp++;
            if (this.Co) {
                Intent intent = activity.getIntent();
                if (intent != null) {
                    this.Ct.setCampaignParamsOnNextHit(intent.getData());
                }
                Map hashMap = new HashMap();
                hashMap.put("&t", "screenview");
                C0144y.eK().m85D(true);
                this.Ct.set("&cd", this.Ct.Cm != null ? this.Ct.Cm.m2371k(activity) : activity.getClass().getCanonicalName());
                this.Ct.send(hashMap);
                C0144y.eK().m85D(false);
            }
        }

        /* renamed from: j */
        public void mo815j(Activity activity) {
            C0144y.eK().m86a(C0143a.EASY_TRACKER_ACTIVITY_STOP);
            this.Cp--;
            this.Cp = Math.max(0, this.Cp);
            if (this.Cp == 0) {
                this.Cs = this.wb.elapsedRealtime();
            }
        }

        public void setSessionTimeout(long sessionTimeout) {
            this.Cq = sessionTimeout;
            fq();
        }
    }

    Tracker(String trackingId, TrackerHandler handler, Context context) {
        this(trackingId, handler, C0785k.el(), ai.fl(), C0782g.dZ(), new ad("tracking"), context);
    }

    Tracker(String trackingId, TrackerHandler handler, C0785k clientIdDefaultProvider, ai screenResolutionDefaultProvider, C0782g appFieldsDefaultProvider, ah rateLimiter, Context context) {
        this.rd = new HashMap();
        this.Cf = new HashMap();
        this.Ce = handler;
        if (context != null) {
            this.mContext = context.getApplicationContext();
        }
        if (trackingId != null) {
            this.rd.put("&tid", trackingId);
        }
        this.rd.put("useSecure", "1");
        this.Ch = clientIdDefaultProvider;
        this.Ci = screenResolutionDefaultProvider;
        this.Cj = appFieldsDefaultProvider;
        this.rd.put("&a", Integer.toString(new Random().nextInt(ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) + 1));
        this.Cg = rateLimiter;
        this.Cl = new C0778a(this);
        enableAdvertisingIdCollection(false);
    }

    /* renamed from: a */
    void m38a(am amVar) {
        ae.m44V("Loading Tracker config values.");
        this.Cm = amVar;
        if (this.Cm.ft()) {
            String fu = this.Cm.fu();
            set("&tid", fu);
            ae.m44V("[Tracker] trackingId loaded: " + fu);
        }
        if (this.Cm.fv()) {
            fu = Double.toString(this.Cm.fw());
            set("&sf", fu);
            ae.m44V("[Tracker] sample frequency loaded: " + fu);
        }
        if (this.Cm.fx()) {
            setSessionTimeout((long) this.Cm.getSessionTimeout());
            ae.m44V("[Tracker] session timeout loaded: " + fn());
        }
        if (this.Cm.fy()) {
            enableAutoActivityTracking(this.Cm.fz());
            ae.m44V("[Tracker] auto activity tracking loaded: " + fo());
        }
        if (this.Cm.fA()) {
            if (this.Cm.fB()) {
                set("&aip", "1");
                ae.m44V("[Tracker] anonymize ip loaded: true");
            }
            ae.m44V("[Tracker] anonymize ip loaded: false");
        }
        enableExceptionReporting(this.Cm.fC());
    }

    public void enableAdvertisingIdCollection(boolean enabled) {
        if (enabled) {
            if (this.rd.containsKey("&ate")) {
                this.rd.remove("&ate");
            }
            if (this.rd.containsKey("&adid")) {
                this.rd.remove("&adid");
                return;
            }
            return;
        }
        this.rd.put("&ate", null);
        this.rd.put("&adid", null);
    }

    public void enableAutoActivityTracking(boolean enabled) {
        this.Cl.enableAutoActivityTracking(enabled);
    }

    public void enableExceptionReporting(boolean enabled) {
        if (this.Ck != enabled) {
            this.Ck = enabled;
            if (enabled) {
                this.Cn = new ExceptionReporter(this, Thread.getDefaultUncaughtExceptionHandler(), this.mContext);
                Thread.setDefaultUncaughtExceptionHandler(this.Cn);
                ae.m44V("Uncaught exceptions will be reported to Google Analytics.");
                return;
            }
            if (this.Cn != null) {
                Thread.setDefaultUncaughtExceptionHandler(this.Cn.et());
            } else {
                Thread.setDefaultUncaughtExceptionHandler(null);
            }
            ae.m44V("Uncaught exceptions will not be reported to Google Analytics.");
        }
    }

    long fn() {
        return this.Cl.fn();
    }

    boolean fo() {
        return this.Cl.fo();
    }

    public String get(String key) {
        C0144y.eK().m86a(C0143a.GET);
        if (TextUtils.isEmpty(key)) {
            return null;
        }
        if (this.rd.containsKey(key)) {
            return (String) this.rd.get(key);
        }
        if (key.equals("&ul")) {
            return an.m54a(Locale.getDefault());
        }
        if (this.Ch != null && this.Ch.ac(key)) {
            return this.Ch.getValue(key);
        }
        if (this.Ci == null || !this.Ci.ac(key)) {
            return (this.Cj == null || !this.Cj.ac(key)) ? null : this.Cj.getValue(key);
        } else {
            return this.Ci.getValue(key);
        }
    }

    public void send(Map<String, String> params) {
        C0144y.eK().m86a(C0143a.SEND);
        Map hashMap = new HashMap();
        hashMap.putAll(this.rd);
        if (params != null) {
            hashMap.putAll(params);
        }
        for (String str : this.Cf.keySet()) {
            if (!hashMap.containsKey(str)) {
                hashMap.put(str, this.Cf.get(str));
            }
        }
        this.Cf.clear();
        if (TextUtils.isEmpty((CharSequence) hashMap.get("&tid"))) {
            ae.m45W(String.format("Missing tracking id (%s) parameter.", new Object[]{"&tid"}));
        }
        String str2 = (String) hashMap.get("&t");
        if (TextUtils.isEmpty(str2)) {
            ae.m45W(String.format("Missing hit type (%s) parameter.", new Object[]{"&t"}));
            str2 = "";
        }
        if (this.Cl.fp()) {
            hashMap.put("&sc", "start");
        }
        String toLowerCase = str2.toLowerCase();
        if ("screenview".equals(toLowerCase) || "pageview".equals(toLowerCase) || "appview".equals(toLowerCase) || TextUtils.isEmpty(toLowerCase)) {
            int parseInt = Integer.parseInt((String) this.rd.get("&a")) + 1;
            if (parseInt >= ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) {
                parseInt = 1;
            }
            this.rd.put("&a", Integer.toString(parseInt));
        }
        if (toLowerCase.equals("transaction") || toLowerCase.equals("item") || this.Cg.fe()) {
            this.Ce.mo811u(hashMap);
        } else {
            ae.m45W("Too many hits sent too quickly, rate limiting invoked.");
        }
    }

    public void set(String key, String value) {
        jx.m1578b((Object) key, (Object) "Key should be non-null");
        C0144y.eK().m86a(C0143a.SET);
        this.rd.put(key, value);
    }

    public void setAnonymizeIp(boolean anonymize) {
        set("&aip", an.m52E(anonymize));
    }

    public void setAppId(String appId) {
        set("&aid", appId);
    }

    public void setAppInstallerId(String appInstallerId) {
        set("&aiid", appInstallerId);
    }

    public void setAppName(String appName) {
        set("&an", appName);
    }

    public void setAppVersion(String appVersion) {
        set("&av", appVersion);
    }

    public void setCampaignParamsOnNextHit(Uri uri) {
        if (uri != null) {
            Object queryParameter = uri.getQueryParameter("referrer");
            if (!TextUtils.isEmpty(queryParameter)) {
                Uri parse = Uri.parse("http://hostname/?" + queryParameter);
                String queryParameter2 = parse.getQueryParameter("utm_id");
                if (queryParameter2 != null) {
                    this.Cf.put("&ci", queryParameter2);
                }
                queryParameter2 = parse.getQueryParameter("utm_campaign");
                if (queryParameter2 != null) {
                    this.Cf.put("&cn", queryParameter2);
                }
                queryParameter2 = parse.getQueryParameter("utm_content");
                if (queryParameter2 != null) {
                    this.Cf.put("&cc", queryParameter2);
                }
                queryParameter2 = parse.getQueryParameter("utm_medium");
                if (queryParameter2 != null) {
                    this.Cf.put("&cm", queryParameter2);
                }
                queryParameter2 = parse.getQueryParameter("utm_source");
                if (queryParameter2 != null) {
                    this.Cf.put("&cs", queryParameter2);
                }
                queryParameter2 = parse.getQueryParameter("utm_term");
                if (queryParameter2 != null) {
                    this.Cf.put("&ck", queryParameter2);
                }
                queryParameter2 = parse.getQueryParameter("dclid");
                if (queryParameter2 != null) {
                    this.Cf.put("&dclid", queryParameter2);
                }
                String queryParameter3 = parse.getQueryParameter("gclid");
                if (queryParameter3 != null) {
                    this.Cf.put("&gclid", queryParameter3);
                }
            }
        }
    }

    public void setClientId(String clientId) {
        set("&cid", clientId);
    }

    public void setEncoding(String encoding) {
        set("&de", encoding);
    }

    public void setHostname(String hostname) {
        set("&dh", hostname);
    }

    public void setLanguage(String language) {
        set("&ul", language);
    }

    public void setLocation(String location) {
        set("&dl", location);
    }

    public void setPage(String page) {
        set("&dp", page);
    }

    public void setReferrer(String referrer) {
        set("&dr", referrer);
    }

    public void setSampleRate(double sampleRate) {
        set("&sf", Double.toHexString(sampleRate));
    }

    public void setScreenColors(String screenColors) {
        set("&sd", screenColors);
    }

    public void setScreenName(String screenName) {
        set("&cd", screenName);
    }

    public void setScreenResolution(int width, int height) {
        if (width >= 0 || height >= 0) {
            set("&sr", width + "x" + height);
        } else {
            ae.m45W("Invalid width or height. The values should be non-negative.");
        }
    }

    public void setSessionTimeout(long sessionTimeout) {
        this.Cl.setSessionTimeout(1000 * sessionTimeout);
    }

    public void setTitle(String title) {
        set("&dt", title);
    }

    public void setUseSecure(boolean useSecure) {
        set("useSecure", an.m52E(useSecure));
    }

    public void setViewportSize(String viewportSize) {
        set("&vp", viewportSize);
    }
}
