package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0361a;
import com.google.android.gms.internal.C0378b;
import com.google.android.gms.internal.C0386d.C1389a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.m */
class C1231m extends aj {
    private static final String ID = C0361a.CONSTANT.toString();
    private static final String VALUE = C0378b.VALUE.toString();

    public C1231m() {
        super(ID, VALUE);
    }

    public static String ph() {
        return ID;
    }

    public static String pi() {
        return VALUE;
    }

    /* renamed from: B */
    public C1389a mo2513B(Map<String, C1389a> map) {
        return (C1389a) map.get(VALUE);
    }

    public boolean pe() {
        return true;
    }
}
