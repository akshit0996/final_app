package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0381c.C1380c;
import com.google.android.gms.internal.C0381c.C1381d;
import com.google.android.gms.internal.C0381c.C1386i;
import com.google.android.gms.internal.C0386d.C1389a;
import java.util.Map;

class ai {
    /* renamed from: a */
    private static void m2094a(DataLayer dataLayer, C1381d c1381d) {
        for (C1389a j : c1381d.fB) {
            dataLayer.cx(di.m2191j(j));
        }
    }

    /* renamed from: a */
    public static void m2095a(DataLayer dataLayer, C1386i c1386i) {
        if (c1386i.gq == null) {
            bh.m2117W("supplemental missing experimentSupplemental");
            return;
        }
        m2094a(dataLayer, c1386i.gq);
        m2096b(dataLayer, c1386i.gq);
        m2098c(dataLayer, c1386i.gq);
    }

    /* renamed from: b */
    private static void m2096b(DataLayer dataLayer, C1381d c1381d) {
        for (C1389a c : c1381d.fA) {
            Map c2 = m2097c(c);
            if (c2 != null) {
                dataLayer.push(c2);
            }
        }
    }

    /* renamed from: c */
    private static Map<String, Object> m2097c(C1389a c1389a) {
        Object o = di.m2196o(c1389a);
        if (o instanceof Map) {
            return (Map) o;
        }
        bh.m2117W("value: " + o + " is not a map value, ignored.");
        return null;
    }

    /* renamed from: c */
    private static void m2098c(DataLayer dataLayer, C1381d c1381d) {
        for (C1380c c1380c : c1381d.fC) {
            if (c1380c.fv == null) {
                bh.m2117W("GaExperimentRandom: No key");
            } else {
                Object obj = dataLayer.get(c1380c.fv);
                Long valueOf = !(obj instanceof Number) ? null : Long.valueOf(((Number) obj).longValue());
                long j = c1380c.fw;
                long j2 = c1380c.fx;
                if (!c1380c.fy || valueOf == null || valueOf.longValue() < j || valueOf.longValue() > j2) {
                    if (j <= j2) {
                        obj = Long.valueOf(Math.round((Math.random() * ((double) (j2 - j))) + ((double) j)));
                    } else {
                        bh.m2117W("GaExperimentRandom: random range invalid");
                    }
                }
                dataLayer.cx(c1380c.fv);
                Map c = dataLayer.m2082c(c1380c.fv, obj);
                if (c1380c.fz > 0) {
                    if (c.containsKey("gtm")) {
                        Object obj2 = c.get("gtm");
                        if (obj2 instanceof Map) {
                            ((Map) obj2).put("lifetime", Long.valueOf(c1380c.fz));
                        } else {
                            bh.m2117W("GaExperimentRandom: gtm not a map");
                        }
                    } else {
                        c.put("gtm", DataLayer.mapOf("lifetime", Long.valueOf(c1380c.fz)));
                    }
                }
                dataLayer.push(c);
            }
        }
    }
}
