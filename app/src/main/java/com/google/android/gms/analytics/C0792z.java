package com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.analytics.C0123n.C0122a;

/* renamed from: com.google.android.gms.analytics.z */
class C0792z extends C0123n<aa> {

    /* renamed from: com.google.android.gms.analytics.z$a */
    private static class C0791a implements C0122a<aa> {
        private final aa Bi = new aa();

        /* renamed from: c */
        public void mo823c(String str, int i) {
            if ("ga_dispatchPeriod".equals(str)) {
                this.Bi.Bk = i;
            } else {
                ae.m45W("int configuration name not recognized:  " + str);
            }
        }

        /* renamed from: e */
        public void mo824e(String str, String str2) {
        }

        /* renamed from: e */
        public void mo825e(String str, boolean z) {
            if ("ga_dryRun".equals(str)) {
                this.Bi.Bl = z ? 1 : 0;
                return;
            }
            ae.m45W("bool configuration name not recognized:  " + str);
        }

        public aa eN() {
            return this.Bi;
        }

        public /* synthetic */ C0121m er() {
            return eN();
        }

        /* renamed from: f */
        public void mo827f(String str, String str2) {
            if ("ga_appName".equals(str)) {
                this.Bi.ya = str2;
            } else if ("ga_appVersion".equals(str)) {
                this.Bi.yb = str2;
            } else if ("ga_logLevel".equals(str)) {
                this.Bi.Bj = str2;
            } else {
                ae.m45W("string configuration name not recognized:  " + str);
            }
        }
    }

    public C0792z(Context context) {
        super(context, new C0791a());
    }
}
