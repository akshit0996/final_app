package com.google.android.gms.internal;

import android.content.ContentResolver;
import android.content.Context;

public abstract class iy<T> {
    private static C0466a KO = null;
    private static final Object mH = new Object();
    protected final String KP;
    protected final T KQ;
    private T KR = null;

    /* renamed from: com.google.android.gms.internal.iy$a */
    private interface C0466a {
    }

    /* renamed from: com.google.android.gms.internal.iy$b */
    private static class C0997b implements C0466a {
        private final ContentResolver mContentResolver;

        public C0997b(ContentResolver contentResolver) {
            this.mContentResolver = contentResolver;
        }
    }

    protected iy(String str, T t) {
        this.KP = str;
        this.KQ = t;
    }

    /* renamed from: H */
    public static void m1485H(Context context) {
        synchronized (mH) {
            if (KO == null) {
                KO = new C0997b(context.getContentResolver());
            }
        }
    }

    /* renamed from: a */
    public static iy<Integer> m1486a(String str, Integer num) {
        return new iy<Integer>(str, num) {
        };
    }

    /* renamed from: h */
    public static iy<Boolean> m1487h(String str, boolean z) {
        return new iy<Boolean>(str, Boolean.valueOf(z)) {
        };
    }

    /* renamed from: l */
    public static iy<String> m1488l(String str, String str2) {
        return new iy<String>(str, str2) {
        };
    }

    public String getKey() {
        return this.KP;
    }
}
