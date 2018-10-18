package com.google.android.gms.internal;

import android.content.Intent;

@ey
public class ek {
    private final String oK;

    public ek(String str) {
        this.oK = str;
    }

    /* renamed from: a */
    public boolean m1173a(String str, int i, Intent intent) {
        if (str == null || intent == null) {
            return false;
        }
        String e = ei.m1170e(intent);
        String f = ei.m1171f(intent);
        if (e == null || f == null) {
            return false;
        }
        if (!str.equals(ei.m1166D(e))) {
            gr.m1341W("Developer payload not match.");
            return false;
        } else if (this.oK == null || el.m1176b(this.oK, e, f)) {
            return true;
        } else {
            gr.m1341W("Fail to verify signature.");
            return false;
        }
    }

    public String cC() {
        return gi.dx();
    }
}
