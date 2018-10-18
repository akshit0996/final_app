package com.google.android.gms.internal;

import java.util.ArrayList;

public final class la {
    /* renamed from: a */
    public static <T> int m1623a(T[] tArr, T t) {
        int i = 0;
        int length = tArr != null ? tArr.length : 0;
        while (i < length) {
            if (jv.equal(tArr[i], t)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    /* renamed from: a */
    public static void m1624a(StringBuilder stringBuilder, double[] dArr) {
        int length = dArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(Double.toString(dArr[i]));
        }
    }

    /* renamed from: a */
    public static void m1625a(StringBuilder stringBuilder, float[] fArr) {
        int length = fArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(Float.toString(fArr[i]));
        }
    }

    /* renamed from: a */
    public static void m1626a(StringBuilder stringBuilder, int[] iArr) {
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(Integer.toString(iArr[i]));
        }
    }

    /* renamed from: a */
    public static void m1627a(StringBuilder stringBuilder, long[] jArr) {
        int length = jArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(Long.toString(jArr[i]));
        }
    }

    /* renamed from: a */
    public static <T> void m1628a(StringBuilder stringBuilder, T[] tArr) {
        int length = tArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(tArr[i].toString());
        }
    }

    /* renamed from: a */
    public static void m1629a(StringBuilder stringBuilder, String[] strArr) {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append("\"").append(strArr[i]).append("\"");
        }
    }

    /* renamed from: a */
    public static void m1630a(StringBuilder stringBuilder, boolean[] zArr) {
        int length = zArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(Boolean.toString(zArr[i]));
        }
    }

    /* renamed from: a */
    public static Integer[] m1631a(int[] iArr) {
        if (iArr == null) {
            return null;
        }
        int length = iArr.length;
        Integer[] numArr = new Integer[length];
        for (int i = 0; i < length; i++) {
            numArr[i] = Integer.valueOf(iArr[i]);
        }
        return numArr;
    }

    /* renamed from: b */
    public static <T> ArrayList<T> m1632b(T[] tArr) {
        ArrayList<T> arrayList = new ArrayList(r1);
        for (Object add : tArr) {
            arrayList.add(add);
        }
        return arrayList;
    }

    /* renamed from: b */
    public static <T> boolean m1633b(T[] tArr, T t) {
        return m1623a((Object[]) tArr, (Object) t) >= 0;
    }

    public static <T> ArrayList<T> ie() {
        return new ArrayList();
    }
}
