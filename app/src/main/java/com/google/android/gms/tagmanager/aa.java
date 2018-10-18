package com.google.android.gms.tagmanager;

import android.os.Build;
import com.google.android.gms.internal.C0361a;
import com.google.android.gms.internal.C0386d.C1389a;
import java.util.Map;

class aa extends aj {
    private static final String ID = C0361a.DEVICE_NAME.toString();

    public aa() {
        super(ID, new String[0]);
    }

    /* renamed from: B */
    public C1389a mo2513B(Map<String, C1389a> map) {
        String str = Build.MANUFACTURER;
        Object obj = Build.MODEL;
        if (!(obj.startsWith(str) || str.equals("unknown"))) {
            obj = str + " " + obj;
        }
        return di.m2202u(obj);
    }

    public boolean pe() {
        return true;
    }
}
