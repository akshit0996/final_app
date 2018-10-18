package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0386d.C1389a;
import java.util.Map;

abstract class dd extends cd {
    public dd(String str) {
        super(str);
    }

    /* renamed from: a */
    protected boolean mo3606a(C1389a c1389a, C1389a c1389a2, Map<String, C1389a> map) {
        String j = di.m2191j(c1389a);
        String j2 = di.m2191j(c1389a2);
        return (j == di.ra() || j2 == di.ra()) ? false : mo3693a(j, j2, (Map) map);
    }

    /* renamed from: a */
    protected abstract boolean mo3693a(String str, String str2, Map<String, C1389a> map);
}
