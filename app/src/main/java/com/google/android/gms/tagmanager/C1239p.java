package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0361a;
import com.google.android.gms.internal.C0386d.C1389a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.p */
class C1239p extends aj {
    private static final String ID = C0361a.CONTAINER_VERSION.toString();
    private final String TU;

    public C1239p(String str) {
        super(ID, new String[0]);
        this.TU = str;
    }

    /* renamed from: B */
    public C1389a mo2513B(Map<String, C1389a> map) {
        return this.TU == null ? di.rb() : di.m2202u(this.TU);
    }

    public boolean pe() {
        return true;
    }
}
