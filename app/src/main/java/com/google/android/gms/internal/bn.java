package com.google.android.gms.internal;

import android.os.Bundle;

@ey
public final class bn {
    public static iy<String> ph = m1086a("gads:sdk_core_location", "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/sdk-core-v40.html");
    public static iy<String> pi = m1086a("gads:sdk_core_experiment_id", (String) null);
    public static iy<Boolean> pj = m1087c("gads:sdk_crash_report_enabled", false);
    public static iy<Boolean> pk = m1087c("gads:sdk_crash_report_full_stacktrace", false);
    public static iy<Boolean> pl = m1087c("gads:block_autoclicks", false);
    public static iy<String> pm = m1086a("gads:block_autoclicks_experiment_id", (String) null);
    public static iy<Boolean> pn = m1087c("gads:spam_app_context:enabled", false);
    public static iy<String> po = m1086a("gads:spam_app_context:experiment_id", (String) null);
    public static iy<Boolean> pp = m1087c("gads:enable_content_fetching", false);
    public static iy<Integer> pq = m1085a("gads:content_length_weight", 1);
    public static iy<Integer> pr = m1085a("gads:content_age_weight", 1);
    public static iy<Integer> ps = m1085a("gads:min_content_len", 11);
    public static iy<Integer> pt = m1085a("gads:fingerprint_number", 10);
    public static iy<Integer> pu = m1085a("gads:sleep_sec", 10);
    private static final Bundle pv = new Bundle();
    private static boolean pw;

    static {
        pw = false;
        pw = true;
    }

    /* renamed from: a */
    private static iy<Integer> m1085a(String str, int i) {
        pv.putInt(str, i);
        return iy.m1486a(str, Integer.valueOf(i));
    }

    /* renamed from: a */
    private static iy<String> m1086a(String str, String str2) {
        pv.putString(str, str2);
        return iy.m1488l(str, str2);
    }

    public static Bundle by() {
        return pv;
    }

    /* renamed from: c */
    private static iy<Boolean> m1087c(String str, boolean z) {
        pv.putBoolean(str, z);
        return iy.m1487h(str, z);
    }
}
