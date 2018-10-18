package com.google.android.gms.internal;

import android.util.Log;
import com.google.ads.AdRequest;

@ey
public final class gr {
    /* renamed from: S */
    public static void m1337S(String str) {
        if (m1346v(3)) {
            Log.d(AdRequest.LOGTAG, str);
        }
    }

    /* renamed from: T */
    public static void m1338T(String str) {
        if (m1346v(6)) {
            Log.e(AdRequest.LOGTAG, str);
        }
    }

    /* renamed from: U */
    public static void m1339U(String str) {
        if (m1346v(4)) {
            Log.i(AdRequest.LOGTAG, str);
        }
    }

    /* renamed from: V */
    public static void m1340V(String str) {
        if (m1346v(2)) {
            Log.v(AdRequest.LOGTAG, str);
        }
    }

    /* renamed from: W */
    public static void m1341W(String str) {
        if (m1346v(5)) {
            Log.w(AdRequest.LOGTAG, str);
        }
    }

    /* renamed from: a */
    public static void m1342a(String str, Throwable th) {
        if (m1346v(3)) {
            Log.d(AdRequest.LOGTAG, str, th);
        }
    }

    /* renamed from: b */
    public static void m1343b(String str, Throwable th) {
        if (m1346v(6)) {
            Log.e(AdRequest.LOGTAG, str, th);
        }
    }

    /* renamed from: c */
    public static void m1344c(String str, Throwable th) {
        if (m1346v(4)) {
            Log.i(AdRequest.LOGTAG, str, th);
        }
    }

    /* renamed from: d */
    public static void m1345d(String str, Throwable th) {
        if (m1346v(5)) {
            Log.w(AdRequest.LOGTAG, str, th);
        }
    }

    /* renamed from: v */
    public static boolean m1346v(int i) {
        return (i >= 5 || Log.isLoggable(AdRequest.LOGTAG, i)) && i != 2;
    }
}
