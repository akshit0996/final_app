package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0378b;
import com.google.android.gms.internal.C0386d.C1389a;
import java.util.Map;

abstract class cd extends aj {
    private static final String arp = C0378b.ARG0.toString();
    private static final String ask = C0378b.ARG1.toString();

    public cd(String str) {
        super(str, arp, ask);
    }

    /* renamed from: B */
    public C1389a mo2513B(Map<String, C1389a> map) {
        for (C1389a c1389a : map.values()) {
            if (c1389a == di.rb()) {
                return di.m2202u(Boolean.valueOf(false));
            }
        }
        C1389a c1389a2 = (C1389a) map.get(arp);
        C1389a c1389a3 = (C1389a) map.get(ask);
        boolean a = (c1389a2 == null || c1389a3 == null) ? false : mo3606a(c1389a2, c1389a3, map);
        return di.m2202u(Boolean.valueOf(a));
    }

    /* renamed from: a */
    protected abstract boolean mo3606a(C1389a c1389a, C1389a c1389a2, Map<String, C1389a> map);

    public boolean pe() {
        return true;
    }
}
