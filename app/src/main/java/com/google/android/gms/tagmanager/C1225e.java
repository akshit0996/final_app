package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.C0361a;
import com.google.android.gms.internal.C0378b;
import com.google.android.gms.internal.C0386d.C1389a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.e */
class C1225e extends aj {
    private static final String ID = C0361a.ADWORDS_CLICK_REFERRER.toString();
    private static final String aqd = C0378b.COMPONENT.toString();
    private static final String aqe = C0378b.CONVERSION_ID.toString();
    private final Context lM;

    public C1225e(Context context) {
        super(ID, aqe);
        this.lM = context;
    }

    /* renamed from: B */
    public C1389a mo2513B(Map<String, C1389a> map) {
        C1389a c1389a = (C1389a) map.get(aqe);
        if (c1389a == null) {
            return di.rb();
        }
        String j = di.m2191j(c1389a);
        c1389a = (C1389a) map.get(aqd);
        String f = ay.m2106f(this.lM, j, c1389a != null ? di.m2191j(c1389a) : null);
        return f != null ? di.m2202u(f) : di.rb();
    }

    public boolean pe() {
        return true;
    }
}
