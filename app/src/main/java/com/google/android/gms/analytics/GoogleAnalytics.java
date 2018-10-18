package com.google.android.gms.analytics;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.google.android.gms.analytics.C0144y.C0143a;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class GoogleAnalytics extends TrackerHandler {
    private static boolean Bm;
    private static GoogleAnalytics Bs;
    private aj Bn;
    private volatile Boolean Bo;
    private Logger Bp;
    private Set<C0107a> Bq;
    private boolean Br;
    private Context mContext;
    private C0116f yV;
    private String ya;
    private String yb;
    private boolean yt;

    /* renamed from: com.google.android.gms.analytics.GoogleAnalytics$a */
    interface C0107a {
        /* renamed from: i */
        void mo814i(Activity activity);

        /* renamed from: j */
        void mo815j(Activity activity);
    }

    /* renamed from: com.google.android.gms.analytics.GoogleAnalytics$b */
    class C0108b implements ActivityLifecycleCallbacks {
        final /* synthetic */ GoogleAnalytics Bt;

        C0108b(GoogleAnalytics googleAnalytics) {
            this.Bt = googleAnalytics;
        }

        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        }

        public void onActivityStarted(Activity activity) {
            this.Bt.m2346g(activity);
        }

        public void onActivityStopped(Activity activity) {
            this.Bt.m2347h(activity);
        }
    }

    protected GoogleAnalytics(Context context) {
        this(context, C0790x.m2415A(context), C0788v.eu());
    }

    private GoogleAnalytics(Context context, C0116f thread, aj serviceManager) {
        this.Bo = Boolean.valueOf(false);
        this.Br = false;
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.mContext = context.getApplicationContext();
        this.yV = thread;
        this.Bn = serviceManager;
        C0782g.m2379y(this.mContext);
        ai.m2366y(this.mContext);
        C0785k.m2393y(this.mContext);
        this.Bp = new C0786p();
        this.Bq = new HashSet();
        eZ();
    }

    /* renamed from: a */
    private Tracker m2342a(Tracker tracker) {
        if (this.ya != null) {
            tracker.set("&an", this.ya);
        }
        if (this.yb != null) {
            tracker.set("&av", this.yb);
        }
        return tracker;
    }

    private int ai(String str) {
        String toLowerCase = str.toLowerCase();
        return "verbose".equals(toLowerCase) ? 0 : "info".equals(toLowerCase) ? 1 : "warning".equals(toLowerCase) ? 2 : "error".equals(toLowerCase) ? 3 : -1;
    }

    static GoogleAnalytics eY() {
        GoogleAnalytics googleAnalytics;
        synchronized (GoogleAnalytics.class) {
            googleAnalytics = Bs;
        }
        return googleAnalytics;
    }

    private void eZ() {
        if (!Bm) {
            ApplicationInfo applicationInfo;
            try {
                applicationInfo = this.mContext.getPackageManager().getApplicationInfo(this.mContext.getPackageName(), 129);
            } catch (NameNotFoundException e) {
                ae.m44V("PackageManager doesn't know about package: " + e);
                applicationInfo = null;
            }
            if (applicationInfo == null) {
                ae.m45W("Couldn't get ApplicationInfo to load gloabl config.");
                return;
            }
            Bundle bundle = applicationInfo.metaData;
            if (bundle != null) {
                int i = bundle.getInt("com.google.android.gms.analytics.globalConfigResource");
                if (i > 0) {
                    aa aaVar = (aa) new C0792z(this.mContext).m69x(i);
                    if (aaVar != null) {
                        m2344a(aaVar);
                    }
                }
            }
        }
    }

    public static GoogleAnalytics getInstance(Context context) {
        GoogleAnalytics googleAnalytics;
        synchronized (GoogleAnalytics.class) {
            if (Bs == null) {
                Bs = new GoogleAnalytics(context);
            }
            googleAnalytics = Bs;
        }
        return googleAnalytics;
    }

    /* renamed from: a */
    void m2343a(C0107a c0107a) {
        this.Bq.add(c0107a);
        if (this.mContext instanceof Application) {
            enableAutoActivityReports((Application) this.mContext);
        }
    }

    /* renamed from: a */
    void m2344a(aa aaVar) {
        ae.m44V("Loading global config values.");
        if (aaVar.eO()) {
            this.ya = aaVar.eP();
            ae.m44V("app name loaded: " + this.ya);
        }
        if (aaVar.eQ()) {
            this.yb = aaVar.eR();
            ae.m44V("app version loaded: " + this.yb);
        }
        if (aaVar.eS()) {
            int ai = ai(aaVar.eT());
            if (ai >= 0) {
                ae.m44V("log level loaded: " + ai);
                getLogger().setLogLevel(ai);
            }
        }
        if (aaVar.eU()) {
            this.Bn.setLocalDispatchPeriod(aaVar.eV());
        }
        if (aaVar.eW()) {
            setDryRun(aaVar.eX());
        }
    }

    /* renamed from: b */
    void m2345b(C0107a c0107a) {
        this.Bq.remove(c0107a);
    }

    void dY() {
        this.yV.dY();
    }

    @Deprecated
    public void dispatchLocalHits() {
        this.Bn.dispatchLocalHits();
    }

    public void enableAutoActivityReports(Application application) {
        if (VERSION.SDK_INT >= 14 && !this.Br) {
            application.registerActivityLifecycleCallbacks(new C0108b(this));
            this.Br = true;
        }
    }

    /* renamed from: g */
    void m2346g(Activity activity) {
        for (C0107a i : this.Bq) {
            i.mo814i(activity);
        }
    }

    public boolean getAppOptOut() {
        C0144y.eK().m86a(C0143a.GET_APP_OPT_OUT);
        return this.Bo.booleanValue();
    }

    public Logger getLogger() {
        return this.Bp;
    }

    /* renamed from: h */
    void m2347h(Activity activity) {
        for (C0107a j : this.Bq) {
            j.mo815j(activity);
        }
    }

    public boolean isDryRunEnabled() {
        C0144y.eK().m86a(C0143a.GET_DRY_RUN);
        return this.yt;
    }

    public Tracker newTracker(int configResId) {
        Tracker a;
        synchronized (this) {
            C0144y.eK().m86a(C0143a.GET_TRACKER);
            Tracker tracker = new Tracker(null, this, this.mContext);
            if (configResId > 0) {
                am amVar = (am) new al(this.mContext).m69x(configResId);
                if (amVar != null) {
                    tracker.m38a(amVar);
                }
            }
            a = m2342a(tracker);
        }
        return a;
    }

    public Tracker newTracker(String trackingId) {
        Tracker a;
        synchronized (this) {
            C0144y.eK().m86a(C0143a.GET_TRACKER);
            a = m2342a(new Tracker(trackingId, this, this.mContext));
        }
        return a;
    }

    public void reportActivityStart(Activity activity) {
        if (!this.Br) {
            m2346g(activity);
        }
    }

    public void reportActivityStop(Activity activity) {
        if (!this.Br) {
            m2347h(activity);
        }
    }

    public void setAppOptOut(boolean optOut) {
        C0144y.eK().m86a(C0143a.SET_APP_OPT_OUT);
        this.Bo = Boolean.valueOf(optOut);
        if (this.Bo.booleanValue()) {
            this.yV.dQ();
        }
    }

    public void setDryRun(boolean dryRun) {
        C0144y.eK().m86a(C0143a.SET_DRY_RUN);
        this.yt = dryRun;
    }

    @Deprecated
    public void setLocalDispatchPeriod(int dispatchPeriodInSeconds) {
        this.Bn.setLocalDispatchPeriod(dispatchPeriodInSeconds);
    }

    public void setLogger(Logger logger) {
        C0144y.eK().m86a(C0143a.SET_LOGGER);
        this.Bp = logger;
    }

    /* renamed from: u */
    void mo811u(Map<String, String> map) {
        synchronized (this) {
            if (map == null) {
                throw new IllegalArgumentException("hit cannot be null");
            }
            an.m56a((Map) map, "&ul", an.m54a(Locale.getDefault()));
            an.m55a((Map) map, "&sr", ai.fl());
            map.put("&_u", C0144y.eK().eM());
            C0144y.eK().eL();
            this.yV.mo872u(map);
        }
    }
}
