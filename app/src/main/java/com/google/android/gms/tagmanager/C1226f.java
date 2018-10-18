package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.C0361a;
import com.google.android.gms.internal.C0386d.C1389a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.f */
class C1226f extends aj {
    private static final String ID = C0361a.APP_ID.toString();
    private final Context mContext;

    public C1226f(Context context) {
        super(ID, new String[0]);
        this.mContext = context;
    }

    /* renamed from: B */
    public C1389a mo2513B(Map<String, C1389a> map) {
        return di.m2202u(this.mContext.getPackageName());
    }

    public boolean pe() {
        return true;
    }
}
