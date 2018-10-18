package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.ff.C1390a;
import com.google.android.gms.internal.ff.C1391b;

@ey
public final class fe {

    /* renamed from: com.google.android.gms.internal.fe$a */
    public interface C0426a {
        /* renamed from: a */
        void mo1791a(fj fjVar);
    }

    /* renamed from: a */
    public static gf m1206a(Context context, fh fhVar, C0426a c0426a) {
        return fhVar.lO.wV ? m1207b(context, fhVar, c0426a) : m1208c(context, fhVar, c0426a);
    }

    /* renamed from: b */
    private static gf m1207b(Context context, fh fhVar, C0426a c0426a) {
        gr.m1337S("Fetching ad response from local ad request service.");
        gf c1390a = new C1390a(context, fhVar, c0426a);
        c1390a.start();
        return c1390a;
    }

    /* renamed from: c */
    private static gf m1208c(Context context, fh fhVar, C0426a c0426a) {
        gr.m1337S("Fetching ad response from remote ad request service.");
        if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(context) == 0) {
            return new C1391b(context, fhVar, c0426a);
        }
        gr.m1341W("Failed to connect to remote ad request service.");
        return null;
    }
}
