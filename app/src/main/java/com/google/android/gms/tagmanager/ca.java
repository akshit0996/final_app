package com.google.android.gms.tagmanager;

import android.os.Build.VERSION;
import com.google.android.gms.internal.C0361a;
import com.google.android.gms.internal.C0386d.C1389a;
import java.util.Map;

class ca extends aj {
    private static final String ID = C0361a.OS_VERSION.toString();

    public ca() {
        super(ID, new String[0]);
    }

    /* renamed from: B */
    public C1389a mo2513B(Map<String, C1389a> map) {
        return di.m2202u(VERSION.RELEASE);
    }

    public boolean pe() {
        return true;
    }
}
