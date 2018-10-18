package com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.analytics.C0123n.C0122a;

class al extends C0123n<am> {

    /* renamed from: com.google.android.gms.analytics.al$a */
    private static class C0780a implements C0122a<am> {
        private final am Cu = new am();

        /* renamed from: c */
        public void mo823c(String str, int i) {
            if ("ga_sessionTimeout".equals(str)) {
                this.Cu.Cx = i;
            } else {
                ae.m45W("int configuration name not recognized:  " + str);
            }
        }

        /* renamed from: e */
        public void mo824e(String str, String str2) {
            this.Cu.CB.put(str, str2);
        }

        /* renamed from: e */
        public void mo825e(String str, boolean z) {
            int i = 1;
            am amVar;
            if ("ga_autoActivityTracking".equals(str)) {
                amVar = this.Cu;
                if (!z) {
                    i = 0;
                }
                amVar.Cy = i;
            } else if ("ga_anonymizeIp".equals(str)) {
                amVar = this.Cu;
                if (!z) {
                    i = 0;
                }
                amVar.Cz = i;
            } else if ("ga_reportUncaughtExceptions".equals(str)) {
                amVar = this.Cu;
                if (!z) {
                    i = 0;
                }
                amVar.CA = i;
            } else {
                ae.m45W("bool configuration name not recognized:  " + str);
            }
        }

        public /* synthetic */ C0121m er() {
            return fs();
        }

        /* renamed from: f */
        public void mo827f(String str, String str2) {
            if ("ga_trackingId".equals(str)) {
                this.Cu.Cv = str2;
            } else if ("ga_sampleFrequency".equals(str)) {
                try {
                    this.Cu.Cw = Double.parseDouble(str2);
                } catch (NumberFormatException e) {
                    ae.m42T("Error parsing ga_sampleFrequency value: " + str2);
                }
            } else {
                ae.m45W("string configuration name not recognized:  " + str);
            }
        }

        public am fs() {
            return this.Cu;
        }
    }

    public al(Context context) {
        super(context, new C0780a());
    }
}
