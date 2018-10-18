package com.google.android.gms.internal;

import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.fitness.data.DataSource;

public class mg {
    private static final ThreadLocal<String> UV = new ThreadLocal();

    public static String bw(String str) {
        return m1686r(str, (String) UV.get());
    }

    /* renamed from: c */
    public static DataSource m1685c(DataSource dataSource) {
        if (!dataSource.jz()) {
            return dataSource;
        }
        return (jN() || ((String) UV.get()).equals(dataSource.getAppPackageName())) ? dataSource : dataSource.jA();
    }

    public static boolean jN() {
        String str = (String) UV.get();
        return str == null || str.startsWith(GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE);
    }

    /* renamed from: r */
    private static String m1686r(String str, String str2) {
        if (str == null || str2 == null) {
            return str;
        }
        Object obj = new byte[(str.length() + str2.length())];
        System.arraycopy(str.getBytes(), 0, obj, 0, str.length());
        System.arraycopy(str2.getBytes(), 0, obj, str.length(), str2.length());
        return Integer.toHexString(lk.m1646a(obj, 0, obj.length, 0));
    }
}
