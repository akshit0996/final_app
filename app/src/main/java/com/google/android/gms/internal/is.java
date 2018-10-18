package com.google.android.gms.internal;

import android.text.TextUtils;
import android.util.Log;

public class is {
    private static boolean HN = false;
    private boolean HO;
    private boolean HP;
    private String HQ;
    protected final String mTag;

    public is(String str) {
        this(str, go());
    }

    public is(String str, boolean z) {
        this.mTag = str;
        this.HO = z;
        this.HP = false;
    }

    public static boolean go() {
        return HN;
    }

    /* renamed from: a */
    public void m1468a(String str, Object... objArr) {
        if (gn()) {
            Log.v(this.mTag, m1473e(str, objArr));
        }
    }

    /* renamed from: a */
    public void m1469a(Throwable th, String str, Object... objArr) {
        if (gm() || HN) {
            Log.d(this.mTag, m1473e(str, objArr), th);
        }
    }

    public void aK(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            str2 = null;
        } else {
            str2 = String.format("[%s] ", new Object[]{str});
        }
        this.HQ = str2;
    }

    /* renamed from: b */
    public void m1470b(String str, Object... objArr) {
        if (gm() || HN) {
            Log.d(this.mTag, m1473e(str, objArr));
        }
    }

    /* renamed from: c */
    public void m1471c(String str, Object... objArr) {
        Log.i(this.mTag, m1473e(str, objArr));
    }

    /* renamed from: d */
    public void m1472d(String str, Object... objArr) {
        Log.w(this.mTag, m1473e(str, objArr));
    }

    /* renamed from: e */
    protected String m1473e(String str, Object... objArr) {
        if (objArr.length != 0) {
            str = String.format(str, objArr);
        }
        return !TextUtils.isEmpty(this.HQ) ? this.HQ + str : str;
    }

    public boolean gm() {
        return this.HO;
    }

    public boolean gn() {
        return this.HP;
    }
}
