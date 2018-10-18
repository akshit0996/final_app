package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0361a;
import com.google.android.gms.internal.C0386d.C1389a;
import java.util.Map;

class ad extends dd {
    private static final String ID = C0361a.ENDS_WITH.toString();

    public ad() {
        super(ID);
    }

    /* renamed from: a */
    protected boolean mo3693a(String str, String str2, Map<String, C1389a> map) {
        return str.endsWith(str2);
    }
}
