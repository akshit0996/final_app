package com.google.android.gms.analytics;

import android.content.Context;
import android.util.DisplayMetrics;

class ai implements C0125q {
    private static ai Cc;
    private static Object xO = new Object();
    private final Context mContext;

    protected ai(Context context) {
        this.mContext = context;
    }

    public static ai fl() {
        ai aiVar;
        synchronized (xO) {
            aiVar = Cc;
        }
        return aiVar;
    }

    /* renamed from: y */
    public static void m2366y(Context context) {
        synchronized (xO) {
            if (Cc == null) {
                Cc = new ai(context);
            }
        }
    }

    public boolean ac(String str) {
        return "&sr".equals(str);
    }

    protected String fm() {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        return displayMetrics.widthPixels + "x" + displayMetrics.heightPixels;
    }

    public String getValue(String field) {
        return (field != null && field.equals("&sr")) ? fm() : null;
    }
}
