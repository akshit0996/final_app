package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0361a;
import com.google.android.gms.internal.C0386d.C1389a;
import java.util.Map;

class dc extends dd {
    private static final String ID = C0361a.STARTS_WITH.toString();

    public dc() {
        super(ID);
    }

    /* renamed from: a */
    protected boolean mo3693a(String str, String str2, Map<String, C1389a> map) {
        return str.startsWith(str2);
    }
}
