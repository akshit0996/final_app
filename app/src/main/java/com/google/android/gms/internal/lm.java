package com.google.android.gms.internal;

import com.google.android.gms.common.api.Scope;

public class lm {
    /* renamed from: d */
    public static Scope[] m1647d(String[] strArr) {
        jx.m1578b((Object) strArr, (Object) "scopeStrings can't be null.");
        Scope[] scopeArr = new Scope[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            scopeArr[i] = new Scope(strArr[i]);
        }
        return scopeArr;
    }
}
