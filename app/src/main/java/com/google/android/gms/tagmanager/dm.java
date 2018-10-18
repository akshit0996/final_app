package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0386d.C1389a;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

class dm {
    /* renamed from: a */
    private static bz<C1389a> m2206a(bz<C1389a> bzVar) {
        try {
            return new bz(di.m2202u(dg(di.m2191j((C1389a) bzVar.getObject()))), bzVar.pX());
        } catch (Throwable e) {
            bh.m2118b("Escape URI: unsupported encoding", e);
            return bzVar;
        }
    }

    /* renamed from: a */
    private static bz<C1389a> m2207a(bz<C1389a> bzVar, int i) {
        if (m2209q((C1389a) bzVar.getObject())) {
            switch (i) {
                case 12:
                    return m2206a(bzVar);
                default:
                    bh.m2114T("Unsupported Value Escaping: " + i);
                    return bzVar;
            }
        }
        bh.m2114T("Escaping can only be applied to strings.");
        return bzVar;
    }

    /* renamed from: a */
    static bz<C1389a> m2208a(bz<C1389a> bzVar, int... iArr) {
        bz a;
        for (int a2 : iArr) {
            a = m2207a(a, a2);
        }
        return a;
    }

    static String dg(String str) throws UnsupportedEncodingException {
        return URLEncoder.encode(str, "UTF-8").replaceAll("\\+", "%20");
    }

    /* renamed from: q */
    private static boolean m2209q(C1389a c1389a) {
        return di.m2196o(c1389a) instanceof String;
    }
}
