package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.C0361a;
import com.google.android.gms.internal.C0386d.C1389a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.b */
class C1212b extends aj {
    private static final String ID = C0361a.ADVERTISER_ID.toString();
    private final C0610a aqc;

    public C1212b(Context context) {
        this(C0610a.m2090W(context));
    }

    C1212b(C0610a c0610a) {
        super(ID, new String[0]);
        this.aqc = c0610a;
    }

    /* renamed from: B */
    public C1389a mo2513B(Map<String, C1389a> map) {
        String pa = this.aqc.pa();
        return pa == null ? di.rb() : di.m2202u(pa);
    }

    public boolean pe() {
        return false;
    }
}
