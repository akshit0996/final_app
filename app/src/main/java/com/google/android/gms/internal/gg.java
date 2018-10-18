package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

@ey
public final class gg {
    /* renamed from: a */
    public static void m1280a(Context context, boolean z) {
        Editor edit = m1281n(context).edit();
        edit.putBoolean("use_https", z);
        edit.commit();
    }

    /* renamed from: n */
    private static SharedPreferences m1281n(Context context) {
        return context.getSharedPreferences("admob", 0);
    }

    /* renamed from: o */
    public static boolean m1282o(Context context) {
        return m1281n(context).getBoolean("use_https", true);
    }
}
