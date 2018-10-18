package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.C0361a;
import com.google.android.gms.internal.C0378b;
import com.google.android.gms.internal.C0386d.C1389a;
import java.util.Map;

class ax extends aj {
    private static final String ID = C0361a.INSTALL_REFERRER.toString();
    private static final String aqd = C0378b.COMPONENT.toString();
    private final Context lM;

    public ax(Context context) {
        super(ID, new String[0]);
        this.lM = context;
    }

    /* renamed from: B */
    public C1389a mo2513B(Map<String, C1389a> map) {
        String e = ay.m2105e(this.lM, ((C1389a) map.get(aqd)) != null ? di.m2191j((C1389a) map.get(aqd)) : null);
        return e != null ? di.m2202u(e) : di.rb();
    }

    public boolean pe() {
        return true;
    }
}
