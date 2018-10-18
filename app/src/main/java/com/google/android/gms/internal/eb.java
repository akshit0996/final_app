package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;

@ey
public class eb {
    private final Context mContext;
    private Object sC;

    public eb(Context context) {
        this.mContext = context;
    }

    /* renamed from: a */
    public Bundle m1157a(String str, String str2, String str3) {
        try {
            Class loadClass = this.mContext.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService");
            return (Bundle) loadClass.getDeclaredMethod("getBuyIntent", new Class[]{Integer.TYPE, String.class, String.class, String.class, String.class}).invoke(loadClass.cast(this.sC), new Object[]{Integer.valueOf(3), str, str2, "inapp", str3});
        } catch (Throwable e) {
            gr.m1345d("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.", e);
            return null;
        }
    }

    /* renamed from: c */
    public int m1158c(String str, String str2) {
        try {
            Class loadClass = this.mContext.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService");
            return ((Integer) loadClass.getDeclaredMethod("consumePurchase", new Class[]{Integer.TYPE, String.class, String.class}).invoke(loadClass.cast(this.sC), new Object[]{Integer.valueOf(3), str, str2})).intValue();
        } catch (Throwable e) {
            gr.m1345d("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.", e);
            return 5;
        }
    }

    /* renamed from: d */
    public Bundle m1159d(String str, String str2) {
        try {
            Class loadClass = this.mContext.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService");
            return (Bundle) loadClass.getDeclaredMethod("getPurchases", new Class[]{Integer.TYPE, String.class, String.class, String.class}).invoke(loadClass.cast(this.sC), new Object[]{Integer.valueOf(3), str, "inapp", str2});
        } catch (Throwable e) {
            gr.m1345d("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.", e);
            return null;
        }
    }

    public void destroy() {
        this.sC = null;
    }

    /* renamed from: t */
    public void m1160t(IBinder iBinder) {
        try {
            this.sC = this.mContext.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService$Stub").getDeclaredMethod("asInterface", new Class[]{IBinder.class}).invoke(null, new Object[]{iBinder});
        } catch (Exception e) {
            gr.m1341W("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.");
        }
    }
}
