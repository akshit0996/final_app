package com.google.android.gms.internal;

import android.net.Uri.Builder;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.internal.fy.C0432a;

@ey
/* renamed from: com.google.android.gms.internal.v */
public class C0511v {
    private C0510a mk;
    private boolean ml;
    private boolean mm;

    /* renamed from: com.google.android.gms.internal.v$a */
    public interface C0510a {
        /* renamed from: e */
        void mo2122e(String str);
    }

    @ey
    /* renamed from: com.google.android.gms.internal.v$b */
    public static class C1079b implements C0510a {
        private final C0432a mn;
        private final gu mo;

        public C1079b(C0432a c0432a, gu guVar) {
            this.mn = c0432a;
            this.mo = guVar;
        }

        /* renamed from: e */
        public void mo2122e(String str) {
            gr.m1337S("An auto-clicking creative is blocked");
            Builder builder = new Builder();
            builder.scheme("https");
            builder.path("//pagead2.googlesyndication.com/pagead/gen_204");
            builder.appendQueryParameter("id", "gmob-apps-blocked-navigation");
            if (!TextUtils.isEmpty(str)) {
                builder.appendQueryParameter("navigationURL", str);
            }
            if (!(this.mn == null || this.mn.vK == null || TextUtils.isEmpty(this.mn.vK.ub))) {
                builder.appendQueryParameter("debugDialog", this.mn.vK.ub);
            }
            gi.m1307c(this.mo.getContext(), this.mo.dG().wS, builder.toString());
        }
    }

    public C0511v() {
        boolean z = false;
        Bundle bN = ga.bN();
        if (bN != null && bN.getBoolean("gads:block_autoclicks", false)) {
            z = true;
        }
        this.mm = z;
    }

    public C0511v(boolean z) {
        this.mm = z;
    }

    /* renamed from: a */
    public void m1926a(C0510a c0510a) {
        this.mk = c0510a;
    }

    public void av() {
        this.ml = true;
    }

    public boolean az() {
        return !this.mm || this.ml;
    }

    /* renamed from: d */
    public void m1927d(String str) {
        gr.m1337S("Action was blocked because no click was detected.");
        if (this.mk != null) {
            this.mk.mo2122e(str);
        }
    }
}
