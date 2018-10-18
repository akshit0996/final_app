package com.google.android.gms.tagmanager;

import android.os.Build.VERSION;
import com.google.android.gms.internal.C0361a;
import com.google.android.gms.internal.C0386d.C1389a;
import java.util.Map;

class cv extends aj {
    private static final String ID = C0361a.SDK_VERSION.toString();

    public cv() {
        super(ID, new String[0]);
    }

    /* renamed from: B */
    public C1389a mo2513B(Map<String, C1389a> map) {
        return di.m2202u(Integer.valueOf(VERSION.SDK_INT));
    }

    public boolean pe() {
        return true;
    }
}
