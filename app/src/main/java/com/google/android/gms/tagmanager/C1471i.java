package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import com.google.android.gms.internal.C0361a;
import com.google.android.gms.internal.C0378b;
import com.google.android.gms.internal.C0386d.C1389a;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* renamed from: com.google.android.gms.tagmanager.i */
class C1471i extends dg {
    private static final String ID = C0361a.ARBITRARY_PIXEL.toString();
    private static final String URL = C0378b.URL.toString();
    private static final String aqf = C0378b.ADDITIONAL_PARAMS.toString();
    private static final String aqg = C0378b.UNREPEATABLE.toString();
    static final String aqh = ("gtm_" + ID + "_unrepeatable");
    private static final Set<String> aqi = new HashSet();
    private final C0637a aqj;
    private final Context mContext;

    /* renamed from: com.google.android.gms.tagmanager.i$a */
    public interface C0637a {
        aq pf();
    }

    /* renamed from: com.google.android.gms.tagmanager.i$1 */
    class C12291 implements C0637a {
        final /* synthetic */ Context nf;

        C12291(Context context) {
            this.nf = context;
        }

        public aq pf() {
            return C1244y.m3797X(this.nf);
        }
    }

    public C1471i(Context context) {
        this(context, new C12291(context));
    }

    C1471i(Context context, C0637a c0637a) {
        super(ID, URL);
        this.aqj = c0637a;
        this.mContext = context;
    }

    private synchronized boolean cl(String str) {
        boolean z = true;
        synchronized (this) {
            if (!cn(str)) {
                if (cm(str)) {
                    aqi.add(str);
                } else {
                    z = false;
                }
            }
        }
        return z;
    }

    /* renamed from: D */
    public void mo3614D(Map<String, C1389a> map) {
        String j = map.get(aqg) != null ? di.m2191j((C1389a) map.get(aqg)) : null;
        if (j == null || !cl(j)) {
            Builder buildUpon = Uri.parse(di.m2191j((C1389a) map.get(URL))).buildUpon();
            C1389a c1389a = (C1389a) map.get(aqf);
            if (c1389a != null) {
                Object o = di.m2196o(c1389a);
                if (o instanceof List) {
                    for (Object o2 : (List) o2) {
                        if (o2 instanceof Map) {
                            for (Entry entry : ((Map) o2).entrySet()) {
                                buildUpon.appendQueryParameter(entry.getKey().toString(), entry.getValue().toString());
                            }
                        } else {
                            bh.m2114T("ArbitraryPixel: additional params contains non-map: not sending partial hit: " + buildUpon.build().toString());
                            return;
                        }
                    }
                }
                bh.m2114T("ArbitraryPixel: additional params not a list: not sending partial hit: " + buildUpon.build().toString());
                return;
            }
            String uri = buildUpon.build().toString();
            this.aqj.pf().cB(uri);
            bh.m2116V("ArbitraryPixel: url = " + uri);
            if (j != null) {
                synchronized (C1471i.class) {
                    aqi.add(j);
                    cz.m2183a(this.mContext, aqh, j, "true");
                }
            }
        }
    }

    boolean cm(String str) {
        return this.mContext.getSharedPreferences(aqh, 0).contains(str);
    }

    boolean cn(String str) {
        return aqi.contains(str);
    }
}
