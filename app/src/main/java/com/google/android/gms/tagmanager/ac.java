package com.google.android.gms.tagmanager;

import android.util.Base64;
import com.google.android.gms.internal.C0361a;
import com.google.android.gms.internal.C0378b;
import com.google.android.gms.internal.C0386d.C1389a;
import java.util.Map;

class ac extends aj {
    private static final String ID = C0361a.ENCODE.toString();
    private static final String arp = C0378b.ARG0.toString();
    private static final String arq = C0378b.NO_PADDING.toString();
    private static final String arr = C0378b.INPUT_FORMAT.toString();
    private static final String ars = C0378b.OUTPUT_FORMAT.toString();

    public ac() {
        super(ID, arp);
    }

    /* renamed from: B */
    public C1389a mo2513B(Map<String, C1389a> map) {
        C1389a c1389a = (C1389a) map.get(arp);
        if (c1389a == null || c1389a == di.rb()) {
            return di.rb();
        }
        String j = di.m2191j(c1389a);
        c1389a = (C1389a) map.get(arr);
        String j2 = c1389a == null ? "text" : di.m2191j(c1389a);
        c1389a = (C1389a) map.get(ars);
        String j3 = c1389a == null ? "base16" : di.m2191j(c1389a);
        c1389a = (C1389a) map.get(arq);
        int i = (c1389a == null || !di.m2195n(c1389a).booleanValue()) ? 2 : 3;
        try {
            byte[] bytes;
            Object d;
            if ("text".equals(j2)) {
                bytes = j.getBytes();
            } else if ("base16".equals(j2)) {
                bytes = C0638j.co(j);
            } else if ("base64".equals(j2)) {
                bytes = Base64.decode(j, i);
            } else if ("base64url".equals(j2)) {
                bytes = Base64.decode(j, i | 8);
            } else {
                bh.m2114T("Encode: unknown input format: " + j2);
                return di.rb();
            }
            if ("base16".equals(j3)) {
                d = C0638j.m2210d(bytes);
            } else if ("base64".equals(j3)) {
                d = Base64.encodeToString(bytes, i);
            } else if ("base64url".equals(j3)) {
                d = Base64.encodeToString(bytes, i | 8);
            } else {
                bh.m2114T("Encode: unknown output format: " + j3);
                return di.rb();
            }
            return di.m2202u(d);
        } catch (IllegalArgumentException e) {
            bh.m2114T("Encode: invalid input:");
            return di.rb();
        }
    }

    public boolean pe() {
        return true;
    }
}
