package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0361a;
import com.google.android.gms.internal.C0378b;
import com.google.android.gms.internal.C0386d.C1389a;
import java.util.Map;

class cf extends aj {
    private static final String ID = C0361a.RANDOM.toString();
    private static final String asu = C0378b.MIN.toString();
    private static final String asv = C0378b.MAX.toString();

    public cf() {
        super(ID, new String[0]);
    }

    /* renamed from: B */
    public C1389a mo2513B(Map<String, C1389a> map) {
        double doubleValue;
        double d;
        C1389a c1389a = (C1389a) map.get(asu);
        C1389a c1389a2 = (C1389a) map.get(asv);
        if (!(c1389a == null || c1389a == di.rb() || c1389a2 == null || c1389a2 == di.rb())) {
            dh k = di.m2192k(c1389a);
            dh k2 = di.m2192k(c1389a2);
            if (!(k == di.qZ() || k2 == di.qZ())) {
                double doubleValue2 = k.doubleValue();
                doubleValue = k2.doubleValue();
                if (doubleValue2 <= doubleValue) {
                    d = doubleValue2;
                    return di.m2202u(Long.valueOf(Math.round(((doubleValue - d) * Math.random()) + d)));
                }
            }
        }
        doubleValue = 2.147483647E9d;
        d = 0.0d;
        return di.m2202u(Long.valueOf(Math.round(((doubleValue - d) * Math.random()) + d)));
    }

    public boolean pe() {
        return false;
    }
}
