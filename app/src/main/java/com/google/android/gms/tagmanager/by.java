package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0386d.C1389a;
import java.util.Map;

abstract class by extends cd {
    public by(String str) {
        super(str);
    }

    /* renamed from: a */
    protected boolean mo3606a(C1389a c1389a, C1389a c1389a2, Map<String, C1389a> map) {
        dh k = di.m2192k(c1389a);
        dh k2 = di.m2192k(c1389a2);
        return (k == di.qZ() || k2 == di.qZ()) ? false : mo3694a(k, k2, (Map) map);
    }

    /* renamed from: a */
    protected abstract boolean mo3694a(dh dhVar, dh dhVar2, Map<String, C1389a> map);
}
