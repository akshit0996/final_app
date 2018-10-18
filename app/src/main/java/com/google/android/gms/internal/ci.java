package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

@ey
public final class ci implements cd {
    private final ce qc;
    private final C0511v qd;

    public ci(ce ceVar, C0511v c0511v) {
        this.qc = ceVar;
        this.qd = c0511v;
    }

    /* renamed from: b */
    private static boolean m3081b(Map<String, String> map) {
        return "1".equals(map.get("custom_close"));
    }

    /* renamed from: c */
    private static int m3082c(Map<String, String> map) {
        String str = (String) map.get("o");
        if (str != null) {
            if ("p".equalsIgnoreCase(str)) {
                return gi.dv();
            }
            if ("l".equalsIgnoreCase(str)) {
                return gi.du();
            }
        }
        return -1;
    }

    /* renamed from: a */
    public void mo1660a(gu guVar, Map<String, String> map) {
        String str = (String) map.get("a");
        if (str == null) {
            gr.m1341W("Action missing from an open GMSG.");
        } else if (this.qd == null || this.qd.az()) {
            gv dD = guVar.dD();
            if ("expand".equalsIgnoreCase(str)) {
                if (guVar.dH()) {
                    gr.m1341W("Cannot expand WebView that is already expanded.");
                } else {
                    dD.m1370a(m3081b(map), m3082c(map));
                }
            } else if ("webapp".equalsIgnoreCase(str)) {
                str = (String) map.get("u");
                if (str != null) {
                    dD.m1371a(m3081b(map), m3082c(map), str);
                } else {
                    dD.m1372a(m3081b(map), m3082c(map), (String) map.get("html"), (String) map.get("baseurl"));
                }
            } else if ("in_app_purchase".equalsIgnoreCase(str)) {
                str = (String) map.get("product_id");
                String str2 = (String) map.get("report_urls");
                if (this.qc == null) {
                    return;
                }
                if (str2 == null || str2.isEmpty()) {
                    this.qc.mo3586a(str, new ArrayList());
                    return;
                }
                this.qc.mo3586a(str, new ArrayList(Arrays.asList(str2.split(" "))));
            } else {
                dD.m1364a(new C0934do((String) map.get("i"), (String) map.get("u"), (String) map.get("m"), (String) map.get("p"), (String) map.get("c"), (String) map.get("f"), (String) map.get("e")));
            }
        } else {
            this.qd.m1927d((String) map.get("u"));
        }
    }
}
