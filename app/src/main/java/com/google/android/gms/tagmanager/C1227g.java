package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.gms.internal.C0361a;
import com.google.android.gms.internal.C0386d.C1389a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.g */
class C1227g extends aj {
    private static final String ID = C0361a.APP_NAME.toString();
    private final Context mContext;

    public C1227g(Context context) {
        super(ID, new String[0]);
        this.mContext = context;
    }

    /* renamed from: B */
    public C1389a mo2513B(Map<String, C1389a> map) {
        try {
            PackageManager packageManager = this.mContext.getPackageManager();
            return di.m2202u(packageManager.getApplicationLabel(packageManager.getApplicationInfo(this.mContext.getPackageName(), 0)).toString());
        } catch (Throwable e) {
            bh.m2118b("App name is not found.", e);
            return di.rb();
        }
    }

    public boolean pe() {
        return true;
    }
}
