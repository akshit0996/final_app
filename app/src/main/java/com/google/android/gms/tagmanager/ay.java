package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import java.util.HashMap;
import java.util.Map;

class ay {
    private static String arH;
    static Map<String, String> arI = new HashMap();

    ay() {
    }

    static void cH(String str) {
        synchronized (ay.class) {
            arH = str;
        }
    }

    /* renamed from: d */
    static void m2104d(Context context, String str) {
        cz.m2183a(context, "gtm_install_referrer", "referrer", str);
        m2107f(context, str);
    }

    /* renamed from: e */
    static String m2105e(Context context, String str) {
        if (arH == null) {
            synchronized (ay.class) {
                if (arH == null) {
                    SharedPreferences sharedPreferences = context.getSharedPreferences("gtm_install_referrer", 0);
                    if (sharedPreferences != null) {
                        arH = sharedPreferences.getString("referrer", "");
                    } else {
                        arH = "";
                    }
                }
            }
        }
        return m2108w(arH, str);
    }

    /* renamed from: f */
    static String m2106f(Context context, String str, String str2) {
        String str3 = (String) arI.get(str);
        if (str3 == null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("gtm_click_referrers", 0);
            str3 = sharedPreferences != null ? sharedPreferences.getString(str, "") : "";
            arI.put(str, str3);
        }
        return m2108w(str3, str2);
    }

    /* renamed from: f */
    static void m2107f(Context context, String str) {
        String w = m2108w(str, "conv");
        if (w != null && w.length() > 0) {
            arI.put(w, str);
            cz.m2183a(context, "gtm_click_referrers", w, str);
        }
    }

    /* renamed from: w */
    static String m2108w(String str, String str2) {
        return str2 == null ? str.length() > 0 ? str : null : Uri.parse("http://hostname/?" + str).getQueryParameter(str2);
    }
}
