package com.google.android.gms.internal;

import java.util.PriorityQueue;

public class as {

    /* renamed from: com.google.android.gms.internal.as$a */
    public static class C0377a {
        final String oa;
        final long value;

        C0377a(long j, String str) {
            this.value = j;
            this.oa = str;
        }

        public boolean equals(Object other) {
            return other != null && (other instanceof C0377a) && ((C0377a) other).value == this.value;
        }

        public int hashCode() {
            return (int) this.value;
        }
    }

    /* renamed from: a */
    static long m1030a(int i, int i2, long j, long j2, long j3) {
        return ((((((j + 1073807359) - ((((((long) i) + 2147483647L) % 1073807359) * j2) % 1073807359)) % 1073807359) * j3) % 1073807359) + ((((long) i2) + 2147483647L) % 1073807359)) % 1073807359;
    }

    /* renamed from: a */
    static long m1031a(long j, int i) {
        return i == 0 ? 1 : i != 1 ? i % 2 == 0 ? m1031a((j * j) % 1073807359, i / 2) % 1073807359 : ((m1031a((j * j) % 1073807359, i / 2) % 1073807359) * j) % 1073807359 : j;
    }

    /* renamed from: a */
    static String m1032a(String[] strArr, int i, int i2) {
        if (strArr.length < i + i2) {
            gr.m1338T("Unable to construct shingle");
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i3 = i; i3 < (i + i2) - 1; i3++) {
            stringBuffer.append(strArr[i3]);
            stringBuffer.append(' ');
        }
        stringBuffer.append(strArr[(i + i2) - 1]);
        return stringBuffer.toString();
    }

    /* renamed from: a */
    static void m1033a(int i, long j, String str, PriorityQueue<C0377a> priorityQueue) {
        C0377a c0377a = new C0377a(j, str);
        if ((priorityQueue.size() != i || ((C0377a) priorityQueue.peek()).value <= c0377a.value) && !priorityQueue.contains(c0377a)) {
            priorityQueue.add(c0377a);
            if (priorityQueue.size() > i) {
                priorityQueue.poll();
            }
        }
    }

    /* renamed from: a */
    public static void m1034a(String[] strArr, int i, int i2, PriorityQueue<C0377a> priorityQueue) {
        long b = m1035b(strArr, 0, i2);
        m1033a(i, b, m1032a(strArr, 0, i2), (PriorityQueue) priorityQueue);
        long a = m1031a(16785407, i2 - 1);
        for (int i3 = 1; i3 < (strArr.length - i2) + 1; i3++) {
            b = m1030a(aq.m1028o(strArr[i3 - 1]), aq.m1028o(strArr[(i3 + i2) - 1]), b, a, 16785407);
            m1033a(i, b, m1032a(strArr, i3, i2), (PriorityQueue) priorityQueue);
        }
    }

    /* renamed from: b */
    private static long m1035b(String[] strArr, int i, int i2) {
        long o = (((long) aq.m1028o(strArr[i])) + 2147483647L) % 1073807359;
        for (int i3 = i + 1; i3 < i + i2; i3++) {
            o = (((o * 16785407) % 1073807359) + ((((long) aq.m1028o(strArr[i3])) + 2147483647L) % 1073807359)) % 1073807359;
        }
        return o;
    }
}
