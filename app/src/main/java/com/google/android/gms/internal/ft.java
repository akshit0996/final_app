package com.google.android.gms.internal;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@ey
public final class ft {
    private int mOrientation = -1;
    private String pD;
    private String uJ;
    private String uK;
    private List<String> uL;
    private String uM;
    private String uN;
    private List<String> uO;
    private long uP = -1;
    private boolean uQ = false;
    private final long uR = -1;
    private long uS = -1;
    private boolean uT = false;
    private boolean uU = false;
    private boolean uV = false;
    private boolean uW = true;
    private List<String> uo;

    /* renamed from: a */
    static String m1237a(Map<String, List<String>> map, String str) {
        List list = (List) map.get(str);
        return (list == null || list.isEmpty()) ? null : (String) list.get(0);
    }

    /* renamed from: b */
    static long m1238b(Map<String, List<String>> map, String str) {
        List list = (List) map.get(str);
        if (!(list == null || list.isEmpty())) {
            String str2 = (String) list.get(0);
            try {
                return (long) (Float.parseFloat(str2) * 1000.0f);
            } catch (NumberFormatException e) {
                gr.m1341W("Could not parse float from " + str + " header: " + str2);
            }
        }
        return -1;
    }

    /* renamed from: c */
    static List<String> m1239c(Map<String, List<String>> map, String str) {
        List list = (List) map.get(str);
        if (!(list == null || list.isEmpty())) {
            String str2 = (String) list.get(0);
            if (str2 != null) {
                return Arrays.asList(str2.trim().split("\\s+"));
            }
        }
        return null;
    }

    /* renamed from: d */
    private boolean m1240d(Map<String, List<String>> map, String str) {
        List list = (List) map.get(str);
        return (list == null || list.isEmpty() || !Boolean.valueOf((String) list.get(0)).booleanValue()) ? false : true;
    }

    /* renamed from: f */
    private void m1241f(Map<String, List<String>> map) {
        this.uJ = m1237a(map, "X-Afma-Ad-Size");
    }

    /* renamed from: g */
    private void m1242g(Map<String, List<String>> map) {
        List c = m1239c(map, "X-Afma-Click-Tracking-Urls");
        if (c != null) {
            this.uL = c;
        }
    }

    /* renamed from: h */
    private void m1243h(Map<String, List<String>> map) {
        List list = (List) map.get("X-Afma-Debug-Dialog");
        if (list != null && !list.isEmpty()) {
            this.uM = (String) list.get(0);
        }
    }

    /* renamed from: i */
    private void m1244i(Map<String, List<String>> map) {
        List c = m1239c(map, "X-Afma-Tracking-Urls");
        if (c != null) {
            this.uO = c;
        }
    }

    /* renamed from: j */
    private void m1245j(Map<String, List<String>> map) {
        long b = m1238b(map, "X-Afma-Interstitial-Timeout");
        if (b != -1) {
            this.uP = b;
        }
    }

    /* renamed from: k */
    private void m1246k(Map<String, List<String>> map) {
        this.uN = m1237a(map, "X-Afma-ActiveView");
    }

    /* renamed from: l */
    private void m1247l(Map<String, List<String>> map) {
        this.uU |= m1240d(map, "X-Afma-Native");
    }

    /* renamed from: m */
    private void m1248m(Map<String, List<String>> map) {
        this.uT |= m1240d(map, "X-Afma-Custom-Rendering-Allowed");
    }

    /* renamed from: n */
    private void m1249n(Map<String, List<String>> map) {
        this.uQ |= m1240d(map, "X-Afma-Mediation");
    }

    /* renamed from: o */
    private void m1250o(Map<String, List<String>> map) {
        List c = m1239c(map, "X-Afma-Manual-Tracking-Urls");
        if (c != null) {
            this.uo = c;
        }
    }

    /* renamed from: p */
    private void m1251p(Map<String, List<String>> map) {
        long b = m1238b(map, "X-Afma-Refresh-Rate");
        if (b != -1) {
            this.uS = b;
        }
    }

    /* renamed from: q */
    private void m1252q(Map<String, List<String>> map) {
        List list = (List) map.get("X-Afma-Orientation");
        if (list != null && !list.isEmpty()) {
            String str = (String) list.get(0);
            if ("portrait".equalsIgnoreCase(str)) {
                this.mOrientation = gi.dv();
            } else if ("landscape".equalsIgnoreCase(str)) {
                this.mOrientation = gi.du();
            }
        }
    }

    /* renamed from: r */
    private void m1253r(Map<String, List<String>> map) {
        List list = (List) map.get("X-Afma-Use-HTTPS");
        if (list != null && !list.isEmpty()) {
            this.uV = Boolean.valueOf((String) list.get(0)).booleanValue();
        }
    }

    /* renamed from: s */
    private void m1254s(Map<String, List<String>> map) {
        List list = (List) map.get("X-Afma-Content-Url-Opted-Out");
        if (list != null && !list.isEmpty()) {
            this.uW = Boolean.valueOf((String) list.get(0)).booleanValue();
        }
    }

    /* renamed from: a */
    public void m1255a(String str, Map<String, List<String>> map, String str2) {
        this.uK = str;
        this.pD = str2;
        m1256e(map);
    }

    /* renamed from: e */
    public void m1256e(Map<String, List<String>> map) {
        m1241f(map);
        m1242g(map);
        m1243h(map);
        m1244i((Map) map);
        m1245j(map);
        m1249n(map);
        m1250o(map);
        m1251p(map);
        m1252q(map);
        m1246k(map);
        m1253r(map);
        m1248m(map);
        m1247l(map);
        m1254s(map);
    }

    /* renamed from: i */
    public fj m1257i(long j) {
        return new fj(this.uK, this.pD, this.uL, this.uO, this.uP, this.uQ, -1, this.uo, this.uS, this.mOrientation, this.uJ, j, this.uM, this.uN, this.uT, this.uU, this.uV, this.uW);
    }
}
