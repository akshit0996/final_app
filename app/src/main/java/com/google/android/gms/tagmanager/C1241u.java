package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0361a;
import com.google.android.gms.internal.C0378b;
import com.google.android.gms.internal.C0386d.C1389a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.u */
class C1241u extends aj {
    private static final String ID = C0361a.CUSTOM_VAR.toString();
    private static final String NAME = C0378b.NAME.toString();
    private static final String aqZ = C0378b.DEFAULT_VALUE.toString();
    private final DataLayer aqn;

    public C1241u(DataLayer dataLayer) {
        super(ID, NAME);
        this.aqn = dataLayer;
    }

    /* renamed from: B */
    public C1389a mo2513B(Map<String, C1389a> map) {
        Object obj = this.aqn.get(di.m2191j((C1389a) map.get(NAME)));
        if (obj != null) {
            return di.m2202u(obj);
        }
        C1389a c1389a = (C1389a) map.get(aqZ);
        return c1389a != null ? c1389a : di.rb();
    }

    public boolean pe() {
        return false;
    }
}
