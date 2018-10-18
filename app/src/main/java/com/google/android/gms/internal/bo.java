package com.google.android.gms.internal;

import android.view.View;
import com.google.android.gms.dynamic.C0272d;
import com.google.android.gms.dynamic.C1332e;
import com.google.android.gms.internal.bq.C0912a;

@ey
public final class bo extends C0912a {
    private final C0512w px;
    private final String py;
    private final String pz;

    public bo(C0512w c0512w, String str, String str2) {
        this.px = c0512w;
        this.py = str;
        this.pz = str2;
    }

    /* renamed from: a */
    public void mo1697a(C0272d c0272d) {
        if (c0272d != null) {
            this.px.mo3599b((View) C1332e.m4012f(c0272d));
        }
    }

    public void av() {
        this.px.av();
    }

    public void aw() {
        this.px.aw();
    }

    public String bA() {
        return this.pz;
    }

    public String bz() {
        return this.py;
    }
}
