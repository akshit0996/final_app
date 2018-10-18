package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0361a;
import com.google.android.gms.internal.C0378b;
import com.google.android.gms.internal.C0386d.C1389a;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

class ch extends aj {
    private static final String ID = C0361a.REGEX_GROUP.toString();
    private static final String asw = C0378b.ARG0.toString();
    private static final String asx = C0378b.ARG1.toString();
    private static final String asy = C0378b.IGNORE_CASE.toString();
    private static final String asz = C0378b.GROUP.toString();

    public ch() {
        super(ID, asw, asx);
    }

    /* renamed from: B */
    public C1389a mo2513B(Map<String, C1389a> map) {
        C1389a c1389a = (C1389a) map.get(asw);
        C1389a c1389a2 = (C1389a) map.get(asx);
        if (c1389a == null || c1389a == di.rb() || c1389a2 == null || c1389a2 == di.rb()) {
            return di.rb();
        }
        int intValue;
        int i = 64;
        if (di.m2195n((C1389a) map.get(asy)).booleanValue()) {
            i = 66;
        }
        C1389a c1389a3 = (C1389a) map.get(asz);
        if (c1389a3 != null) {
            Long l = di.m2193l(c1389a3);
            if (l == di.qW()) {
                return di.rb();
            }
            intValue = l.intValue();
            if (intValue < 0) {
                return di.rb();
            }
        }
        intValue = 1;
        try {
            CharSequence j = di.m2191j(c1389a);
            Object obj = null;
            Matcher matcher = Pattern.compile(di.m2191j(c1389a2), i).matcher(j);
            if (matcher.find() && matcher.groupCount() >= intValue) {
                obj = matcher.group(intValue);
            }
            return obj == null ? di.rb() : di.m2202u(obj);
        } catch (PatternSyntaxException e) {
            return di.rb();
        }
    }

    public boolean pe() {
        return true;
    }
}
