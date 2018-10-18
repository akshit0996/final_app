package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0361a;
import com.google.android.gms.internal.C0378b;
import com.google.android.gms.internal.C0386d.C1389a;
import java.util.Map;

class bj extends aj {
    private static final String ID = C0361a.LOWERCASE_STRING.toString();
    private static final String arp = C0378b.ARG0.toString();

    public bj() {
        super(ID, arp);
    }

    /* renamed from: B */
    public C1389a mo2513B(Map<String, C1389a> map) {
        return di.m2202u(di.m2191j((C1389a) map.get(arp)).toLowerCase());
    }

    public boolean pe() {
        return true;
    }
}
