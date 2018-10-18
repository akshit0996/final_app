package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.C0361a;
import com.google.android.gms.internal.C0386d.C1389a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.c */
class C1214c extends aj {
    private static final String ID = C0361a.ADVERTISING_TRACKING_ENABLED.toString();
    private final C0610a aqc;

    public C1214c(Context context) {
        this(C0610a.m2090W(context));
    }

    C1214c(C0610a c0610a) {
        super(ID, new String[0]);
        this.aqc = c0610a;
    }

    /* renamed from: B */
    public C1389a mo2513B(Map<String, C1389a> map) {
        return di.m2202u(Boolean.valueOf(!this.aqc.isLimitAdTrackingEnabled()));
    }

    public boolean pe() {
        return false;
    }
}
