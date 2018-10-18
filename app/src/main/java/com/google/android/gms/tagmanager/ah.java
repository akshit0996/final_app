package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0361a;
import com.google.android.gms.internal.C0386d.C1389a;
import java.util.Map;

class ah extends aj {
    private static final String ID = C0361a.EVENT.toString();
    private final ct aqo;

    public ah(ct ctVar) {
        super(ID, new String[0]);
        this.aqo = ctVar;
    }

    /* renamed from: B */
    public C1389a mo2513B(Map<String, C1389a> map) {
        String qE = this.aqo.qE();
        return qE == null ? di.rb() : di.m2202u(qE);
    }

    public boolean pe() {
        return false;
    }
}
