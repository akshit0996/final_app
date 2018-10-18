package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.internal.C0361a;
import com.google.android.gms.internal.C0386d.C1389a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.h */
class C1228h extends aj {
    private static final String ID = C0361a.APP_VERSION.toString();
    private final Context mContext;

    public C1228h(Context context) {
        super(ID, new String[0]);
        this.mContext = context;
    }

    /* renamed from: B */
    public C1389a mo2513B(Map<String, C1389a> map) {
        try {
            return di.m2202u(Integer.valueOf(this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 0).versionCode));
        } catch (NameNotFoundException e) {
            bh.m2114T("Package name " + this.mContext.getPackageName() + " not found. " + e.getMessage());
            return di.rb();
        }
    }

    public boolean pe() {
        return true;
    }
}
