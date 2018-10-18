package com.google.android.gms.analytics;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

/* renamed from: com.google.android.gms.analytics.g */
class C0782g implements C0125q {
    private static Object xO = new Object();
    private static C0782g ye;
    protected String ya;
    protected String yb;
    protected String yc;
    protected String yd;

    protected C0782g() {
    }

    private C0782g(Context context) {
        PackageManager packageManager = context.getPackageManager();
        this.yc = context.getPackageName();
        this.yd = packageManager.getInstallerPackageName(this.yc);
        String str = this.yc;
        String str2 = null;
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            if (packageInfo != null) {
                str = packageManager.getApplicationLabel(packageInfo.applicationInfo).toString();
                str2 = packageInfo.versionName;
            }
        } catch (NameNotFoundException e) {
            ae.m42T("Error retrieving package info: appName set to " + str);
        }
        this.ya = str;
        this.yb = str2;
    }

    public static C0782g dZ() {
        return ye;
    }

    /* renamed from: y */
    public static void m2379y(Context context) {
        synchronized (xO) {
            if (ye == null) {
                ye = new C0782g(context);
            }
        }
    }

    public boolean ac(String str) {
        return "&an".equals(str) || "&av".equals(str) || "&aid".equals(str) || "&aiid".equals(str);
    }

    public String getValue(String field) {
        if (field == null) {
            return null;
        }
        if (field.equals("&an")) {
            return this.ya;
        }
        if (field.equals("&av")) {
            return this.yb;
        }
        if (field.equals("&aid")) {
            return this.yc;
        }
        return field.equals("&aiid") ? this.yd : null;
    }
}
