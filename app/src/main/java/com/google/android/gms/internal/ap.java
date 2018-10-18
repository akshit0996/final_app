package com.google.android.gms.internal;

import android.util.Base64OutputStream;
import com.google.android.gms.internal.as.C0377a;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.PriorityQueue;

public class ap {
    private final int nT;
    private final int nU;
    private final ao nV = new ar();
    private Base64OutputStream nW;
    private ByteArrayOutputStream nX;

    /* renamed from: com.google.android.gms.internal.ap$1 */
    class C03751 implements Comparator<String> {
        final /* synthetic */ ap nY;

        C03751(ap apVar) {
            this.nY = apVar;
        }

        public int compare(String s1, String s2) {
            return s2.length() - s1.length();
        }
    }

    /* renamed from: com.google.android.gms.internal.ap$2 */
    class C03762 implements Comparator<C0377a> {
        final /* synthetic */ ap nY;

        C03762(ap apVar) {
            this.nY = apVar;
        }

        /* renamed from: a */
        public int m1022a(C0377a c0377a, C0377a c0377a2) {
            return (int) (c0377a.value - c0377a2.value);
        }

        public /* synthetic */ int compare(Object x0, Object x1) {
            return m1022a((C0377a) x0, (C0377a) x1);
        }
    }

    public ap(int i) {
        this.nU = i;
        this.nT = 6;
    }

    /* renamed from: m */
    private String m1023m(String str) {
        String[] split = str.split("\n");
        if (split == null || split.length == 0) {
            return "";
        }
        this.nX = new ByteArrayOutputStream();
        this.nW = new Base64OutputStream(this.nX, 10);
        Arrays.sort(split, new C03751(this));
        int i = 0;
        while (i < split.length && i < this.nU) {
            if (split[i].trim().length() != 0) {
                try {
                    this.nW.write(this.nV.mo1671l(split[i]));
                } catch (Throwable e) {
                    gr.m1343b("Error while writing hash to byteStream", e);
                }
            }
            i++;
        }
        try {
            this.nW.flush();
            this.nW.close();
            return this.nX.toString();
        } catch (Throwable e2) {
            gr.m1343b("HashManager: Unable to convert to base 64", e2);
            return "";
        }
    }

    /* renamed from: a */
    public String m1024a(ArrayList<String> arrayList) {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            stringBuffer.append(((String) it.next()).toLowerCase(Locale.US));
            stringBuffer.append('\n');
        }
        switch (null) {
            case null:
                return m1025n(stringBuffer.toString());
            case 1:
                return m1023m(stringBuffer.toString());
            default:
                return "";
        }
    }

    /* renamed from: n */
    String m1025n(String str) {
        String[] split = str.split("\n");
        if (split == null || split.length == 0) {
            return "";
        }
        this.nX = new ByteArrayOutputStream();
        this.nW = new Base64OutputStream(this.nX, 10);
        PriorityQueue priorityQueue = new PriorityQueue(this.nU, new C03762(this));
        for (String p : split) {
            String[] p2 = aq.m1029p(p);
            if (p2.length >= this.nT) {
                as.m1034a(p2, this.nU, this.nT, priorityQueue);
            }
        }
        Iterator it = priorityQueue.iterator();
        while (it.hasNext()) {
            try {
                this.nW.write(this.nV.mo1671l(((C0377a) it.next()).oa));
            } catch (Throwable e) {
                gr.m1343b("Error while writing hash to byteStream", e);
            }
        }
        try {
            this.nW.flush();
            this.nW.close();
            return this.nX.toString();
        } catch (Throwable e2) {
            gr.m1343b("HashManager: unable to convert to base 64", e2);
            return "";
        }
    }
}
