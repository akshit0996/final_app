package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0361a;
import com.google.android.gms.internal.C0378b;
import com.google.android.gms.internal.C0386d.C1389a;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.w */
class C1474w extends dg {
    private static final String ID = C0361a.DATA_LAYER_WRITE.toString();
    private static final String VALUE = C0378b.VALUE.toString();
    private static final String ark = C0378b.CLEAR_PERSISTENT_DATA_LAYER_PREFIX.toString();
    private final DataLayer aqn;

    public C1474w(DataLayer dataLayer) {
        super(ID, VALUE);
        this.aqn = dataLayer;
    }

    /* renamed from: a */
    private void m4701a(C1389a c1389a) {
        if (c1389a != null && c1389a != di.qV()) {
            String j = di.m2191j(c1389a);
            if (j != di.ra()) {
                this.aqn.cx(j);
            }
        }
    }

    /* renamed from: b */
    private void m4702b(C1389a c1389a) {
        if (c1389a != null && c1389a != di.qV()) {
            Object o = di.m2196o(c1389a);
            if (o instanceof List) {
                for (Object o2 : (List) o2) {
                    if (o2 instanceof Map) {
                        this.aqn.push((Map) o2);
                    }
                }
            }
        }
    }

    /* renamed from: D */
    public void mo3614D(Map<String, C1389a> map) {
        m4702b((C1389a) map.get(VALUE));
        m4701a((C1389a) map.get(ark));
    }
}
