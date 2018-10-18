package com.google.android.gms.analytics;

/* renamed from: com.google.android.gms.analytics.s */
public final class C0127s {
    /* renamed from: A */
    public static String m71A(int i) {
        return C0127s.m77d("&pr", i);
    }

    /* renamed from: B */
    public static String m72B(int i) {
        return C0127s.m77d("&promo", i);
    }

    /* renamed from: C */
    public static String m73C(int i) {
        return C0127s.m77d("pi", i);
    }

    /* renamed from: D */
    public static String m74D(int i) {
        return C0127s.m77d("&il", i);
    }

    /* renamed from: E */
    public static String m75E(int i) {
        return C0127s.m77d("cd", i);
    }

    /* renamed from: F */
    public static String m76F(int i) {
        return C0127s.m77d("cm", i);
    }

    /* renamed from: d */
    private static String m77d(String str, int i) {
        if (i >= 1) {
            return str + i;
        }
        ae.m42T("index out of range for " + str + " (" + i + ")");
        return "";
    }

    /* renamed from: y */
    static String m78y(int i) {
        return C0127s.m77d("&cd", i);
    }

    /* renamed from: z */
    static String m79z(int i) {
        return C0127s.m77d("&cm", i);
    }
}
