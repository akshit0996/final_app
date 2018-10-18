package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0361a;
import com.google.android.gms.internal.C0378b;
import com.google.android.gms.internal.C0386d.C1389a;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

class ci extends dd {
    private static final String ID = C0361a.REGEX.toString();
    private static final String asy = C0378b.IGNORE_CASE.toString();

    public ci() {
        super(ID);
    }

    /* renamed from: a */
    protected boolean mo3693a(String str, String str2, Map<String, C1389a> map) {
        try {
            return Pattern.compile(str2, di.m2195n((C1389a) map.get(asy)).booleanValue() ? 66 : 64).matcher(str).find();
        } catch (PatternSyntaxException e) {
            return false;
        }
    }
}
