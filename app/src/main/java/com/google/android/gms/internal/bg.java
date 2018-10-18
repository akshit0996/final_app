package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.admob.AdMobExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.search.SearchAdRequest;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@ey
public final class bg {
    public static final String DEVICE_ID_EMULATOR = gq.m1330R("emulator");
    /* renamed from: d */
    private final Date f44d;
    /* renamed from: f */
    private final Set<String> f45f;
    /* renamed from: h */
    private final Location f46h;
    private final String oA;
    private final SearchAdRequest oB;
    private final int oC;
    private final Set<String> oD;
    private final String ov;
    private final int ow;
    private final boolean ox;
    private final Bundle oy;
    private final Map<Class<? extends NetworkExtras>, NetworkExtras> oz;

    /* renamed from: com.google.android.gms.internal.bg$a */
    public static final class C0379a {
        /* renamed from: d */
        private Date f42d;
        /* renamed from: h */
        private Location f43h;
        private String oA;
        private int oC = -1;
        private final HashSet<String> oE = new HashSet();
        private final HashMap<Class<? extends NetworkExtras>, NetworkExtras> oF = new HashMap();
        private final HashSet<String> oG = new HashSet();
        private String ov;
        private int ow = -1;
        private boolean ox = false;
        private final Bundle oy = new Bundle();

        /* renamed from: a */
        public void m1064a(Location location) {
            this.f43h = location;
        }

        @Deprecated
        /* renamed from: a */
        public void m1065a(NetworkExtras networkExtras) {
            if (networkExtras instanceof AdMobExtras) {
                m1066a(AdMobAdapter.class, ((AdMobExtras) networkExtras).getExtras());
            } else {
                this.oF.put(networkExtras.getClass(), networkExtras);
            }
        }

        /* renamed from: a */
        public void m1066a(Class<? extends MediationAdapter> cls, Bundle bundle) {
            this.oy.putBundle(cls.getName(), bundle);
        }

        /* renamed from: a */
        public void m1067a(Date date) {
            this.f42d = date;
        }

        /* renamed from: b */
        public void m1068b(Class<? extends CustomEvent> cls, Bundle bundle) {
            if (this.oy.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter") == null) {
                this.oy.putBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter", new Bundle());
            }
            this.oy.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter").putBundle(cls.getName(), bundle);
        }

        /* renamed from: h */
        public void m1069h(int i) {
            this.ow = i;
        }

        /* renamed from: i */
        public void m1070i(boolean z) {
            this.ox = z;
        }

        /* renamed from: j */
        public void m1071j(boolean z) {
            this.oC = z ? 1 : 0;
        }

        /* renamed from: r */
        public void m1072r(String str) {
            this.oE.add(str);
        }

        /* renamed from: s */
        public void m1073s(String str) {
            this.oG.add(str);
        }

        /* renamed from: t */
        public void m1074t(String str) {
            this.ov = str;
        }

        /* renamed from: u */
        public void m1075u(String str) {
            this.oA = str;
        }
    }

    public bg(C0379a c0379a) {
        this(c0379a, null);
    }

    public bg(C0379a c0379a, SearchAdRequest searchAdRequest) {
        this.f44d = c0379a.f42d;
        this.ov = c0379a.ov;
        this.ow = c0379a.ow;
        this.f45f = Collections.unmodifiableSet(c0379a.oE);
        this.f46h = c0379a.f43h;
        this.ox = c0379a.ox;
        this.oy = c0379a.oy;
        this.oz = Collections.unmodifiableMap(c0379a.oF);
        this.oA = c0379a.oA;
        this.oB = searchAdRequest;
        this.oC = c0379a.oC;
        this.oD = Collections.unmodifiableSet(c0379a.oG);
    }

    public SearchAdRequest bi() {
        return this.oB;
    }

    public Map<Class<? extends NetworkExtras>, NetworkExtras> bj() {
        return this.oz;
    }

    public Bundle bk() {
        return this.oy;
    }

    public int bl() {
        return this.oC;
    }

    public Date getBirthday() {
        return this.f44d;
    }

    public String getContentUrl() {
        return this.ov;
    }

    public Bundle getCustomEventExtrasBundle(Class<? extends CustomEvent> adapterClass) {
        Bundle bundle = this.oy.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter");
        return bundle != null ? bundle.getBundle(adapterClass.getClass().getName()) : null;
    }

    public int getGender() {
        return this.ow;
    }

    public Set<String> getKeywords() {
        return this.f45f;
    }

    public Location getLocation() {
        return this.f46h;
    }

    public boolean getManualImpressionsEnabled() {
        return this.ox;
    }

    @Deprecated
    public <T extends NetworkExtras> T getNetworkExtras(Class<T> networkExtrasClass) {
        return (NetworkExtras) this.oz.get(networkExtrasClass);
    }

    public Bundle getNetworkExtrasBundle(Class<? extends MediationAdapter> adapterClass) {
        return this.oy.getBundle(adapterClass.getName());
    }

    public String getPublisherProvidedId() {
        return this.oA;
    }

    public boolean isTestDevice(Context context) {
        return this.oD.contains(gq.m1336v(context));
    }
}
