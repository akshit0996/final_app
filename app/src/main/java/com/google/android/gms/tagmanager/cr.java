package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0378b;
import com.google.android.gms.internal.C0381c.C1379b;
import com.google.android.gms.internal.C0381c.C1382e;
import com.google.android.gms.internal.C0381c.C1383f;
import com.google.android.gms.internal.C0381c.C1384g;
import com.google.android.gms.internal.C0381c.C1385h;
import com.google.android.gms.internal.C0386d.C1389a;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class cr {

    /* renamed from: com.google.android.gms.tagmanager.cr$a */
    public static class C0623a {
        private final Map<String, C1389a> asM;
        private final C1389a asN;

        private C0623a(Map<String, C1389a> map, C1389a c1389a) {
            this.asM = map;
            this.asN = c1389a;
        }

        public static C0624b qk() {
            return new C0624b();
        }

        /* renamed from: a */
        public void m2138a(String str, C1389a c1389a) {
            this.asM.put(str, c1389a);
        }

        public Map<String, C1389a> ql() {
            return Collections.unmodifiableMap(this.asM);
        }

        public C1389a qm() {
            return this.asN;
        }

        public String toString() {
            return "Properties: " + ql() + " pushAfterEvaluate: " + this.asN;
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cr$b */
    public static class C0624b {
        private final Map<String, C1389a> asM;
        private C1389a asN;

        private C0624b() {
            this.asM = new HashMap();
        }

        /* renamed from: b */
        public C0624b m2139b(String str, C1389a c1389a) {
            this.asM.put(str, c1389a);
            return this;
        }

        /* renamed from: i */
        public C0624b m2140i(C1389a c1389a) {
            this.asN = c1389a;
            return this;
        }

        public C0623a qn() {
            return new C0623a(this.asM, this.asN);
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cr$c */
    public static class C0625c {
        private final String TU;
        private final List<C0627e> asO;
        private final Map<String, List<C0623a>> asP;
        private final int asQ;

        private C0625c(List<C0627e> list, Map<String, List<C0623a>> map, String str, int i) {
            this.asO = Collections.unmodifiableList(list);
            this.asP = Collections.unmodifiableMap(map);
            this.TU = str;
            this.asQ = i;
        }

        public static C0626d qo() {
            return new C0626d();
        }

        public String getVersion() {
            return this.TU;
        }

        public List<C0627e> qp() {
            return this.asO;
        }

        public Map<String, List<C0623a>> qq() {
            return this.asP;
        }

        public String toString() {
            return "Rules: " + qp() + "  Macros: " + this.asP;
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cr$d */
    public static class C0626d {
        private String TU;
        private final List<C0627e> asO;
        private final Map<String, List<C0623a>> asP;
        private int asQ;

        private C0626d() {
            this.asO = new ArrayList();
            this.asP = new HashMap();
            this.TU = "";
            this.asQ = 0;
        }

        /* renamed from: a */
        public C0626d m2141a(C0623a c0623a) {
            String j = di.m2191j((C1389a) c0623a.ql().get(C0378b.INSTANCE_NAME.toString()));
            List list = (List) this.asP.get(j);
            if (list == null) {
                list = new ArrayList();
                this.asP.put(j, list);
            }
            list.add(c0623a);
            return this;
        }

        /* renamed from: a */
        public C0626d m2142a(C0627e c0627e) {
            this.asO.add(c0627e);
            return this;
        }

        public C0626d cO(String str) {
            this.TU = str;
            return this;
        }

        public C0626d fO(int i) {
            this.asQ = i;
            return this;
        }

        public C0625c qr() {
            return new C0625c(this.asO, this.asP, this.TU, this.asQ);
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cr$e */
    public static class C0627e {
        private final List<C0623a> asR;
        private final List<C0623a> asS;
        private final List<C0623a> asT;
        private final List<C0623a> asU;
        private final List<C0623a> asV;
        private final List<C0623a> asW;
        private final List<String> asX;
        private final List<String> asY;
        private final List<String> asZ;
        private final List<String> ata;

        private C0627e(List<C0623a> list, List<C0623a> list2, List<C0623a> list3, List<C0623a> list4, List<C0623a> list5, List<C0623a> list6, List<String> list7, List<String> list8, List<String> list9, List<String> list10) {
            this.asR = Collections.unmodifiableList(list);
            this.asS = Collections.unmodifiableList(list2);
            this.asT = Collections.unmodifiableList(list3);
            this.asU = Collections.unmodifiableList(list4);
            this.asV = Collections.unmodifiableList(list5);
            this.asW = Collections.unmodifiableList(list6);
            this.asX = Collections.unmodifiableList(list7);
            this.asY = Collections.unmodifiableList(list8);
            this.asZ = Collections.unmodifiableList(list9);
            this.ata = Collections.unmodifiableList(list10);
        }

        public static C0628f qs() {
            return new C0628f();
        }

        public List<String> qA() {
            return this.asZ;
        }

        public List<String> qB() {
            return this.ata;
        }

        public List<C0623a> qC() {
            return this.asW;
        }

        public List<C0623a> qt() {
            return this.asR;
        }

        public List<C0623a> qu() {
            return this.asS;
        }

        public List<C0623a> qv() {
            return this.asT;
        }

        public List<C0623a> qw() {
            return this.asU;
        }

        public List<C0623a> qx() {
            return this.asV;
        }

        public List<String> qy() {
            return this.asX;
        }

        public List<String> qz() {
            return this.asY;
        }

        public String toString() {
            return "Positive predicates: " + qt() + "  Negative predicates: " + qu() + "  Add tags: " + qv() + "  Remove tags: " + qw() + "  Add macros: " + qx() + "  Remove macros: " + qC();
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cr$f */
    public static class C0628f {
        private final List<C0623a> asR;
        private final List<C0623a> asS;
        private final List<C0623a> asT;
        private final List<C0623a> asU;
        private final List<C0623a> asV;
        private final List<C0623a> asW;
        private final List<String> asX;
        private final List<String> asY;
        private final List<String> asZ;
        private final List<String> ata;

        private C0628f() {
            this.asR = new ArrayList();
            this.asS = new ArrayList();
            this.asT = new ArrayList();
            this.asU = new ArrayList();
            this.asV = new ArrayList();
            this.asW = new ArrayList();
            this.asX = new ArrayList();
            this.asY = new ArrayList();
            this.asZ = new ArrayList();
            this.ata = new ArrayList();
        }

        /* renamed from: b */
        public C0628f m2143b(C0623a c0623a) {
            this.asR.add(c0623a);
            return this;
        }

        /* renamed from: c */
        public C0628f m2144c(C0623a c0623a) {
            this.asS.add(c0623a);
            return this;
        }

        public C0628f cP(String str) {
            this.asZ.add(str);
            return this;
        }

        public C0628f cQ(String str) {
            this.ata.add(str);
            return this;
        }

        public C0628f cR(String str) {
            this.asX.add(str);
            return this;
        }

        public C0628f cS(String str) {
            this.asY.add(str);
            return this;
        }

        /* renamed from: d */
        public C0628f m2145d(C0623a c0623a) {
            this.asT.add(c0623a);
            return this;
        }

        /* renamed from: e */
        public C0628f m2146e(C0623a c0623a) {
            this.asU.add(c0623a);
            return this;
        }

        /* renamed from: f */
        public C0628f m2147f(C0623a c0623a) {
            this.asV.add(c0623a);
            return this;
        }

        /* renamed from: g */
        public C0628f m2148g(C0623a c0623a) {
            this.asW.add(c0623a);
            return this;
        }

        public C0627e qD() {
            return new C0627e(this.asR, this.asS, this.asT, this.asU, this.asV, this.asW, this.asX, this.asY, this.asZ, this.ata);
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cr$g */
    public static class C0629g extends Exception {
        public C0629g(String str) {
            super(str);
        }
    }

    /* renamed from: a */
    private static C1389a m2149a(int i, C1383f c1383f, C1389a[] c1389aArr, Set<Integer> set) throws C0629g {
        int i2 = 0;
        if (set.contains(Integer.valueOf(i))) {
            cN("Value cycle detected.  Current value reference: " + i + "." + "  Previous value references: " + set + ".");
        }
        C1389a c1389a = (C1389a) m2152a(c1383f.fG, i, "values");
        if (c1389aArr[i] != null) {
            return c1389aArr[i];
        }
        C1389a c1389a2 = null;
        set.add(Integer.valueOf(i));
        C1385h h;
        int[] iArr;
        int length;
        int i3;
        int i4;
        switch (c1389a.type) {
            case 1:
            case 5:
            case 6:
            case 8:
                c1389a2 = c1389a;
                break;
            case 2:
                h = m2156h(c1389a);
                c1389a2 = m2155g(c1389a);
                c1389a2.gw = new C1389a[h.gh.length];
                iArr = h.gh;
                length = iArr.length;
                i3 = 0;
                while (i2 < length) {
                    i4 = i3 + 1;
                    c1389a2.gw[i3] = m2149a(iArr[i2], c1383f, c1389aArr, (Set) set);
                    i2++;
                    i3 = i4;
                }
                break;
            case 3:
                c1389a2 = m2155g(c1389a);
                C1385h h2 = m2156h(c1389a);
                if (h2.gi.length != h2.gj.length) {
                    cN("Uneven map keys (" + h2.gi.length + ") and map values (" + h2.gj.length + ")");
                }
                c1389a2.gx = new C1389a[h2.gi.length];
                c1389a2.gy = new C1389a[h2.gi.length];
                int[] iArr2 = h2.gi;
                int length2 = iArr2.length;
                i3 = 0;
                i4 = 0;
                while (i3 < length2) {
                    int i5 = i4 + 1;
                    c1389a2.gx[i4] = m2149a(iArr2[i3], c1383f, c1389aArr, (Set) set);
                    i3++;
                    i4 = i5;
                }
                iArr = h2.gj;
                length = iArr.length;
                i3 = 0;
                while (i2 < length) {
                    i4 = i3 + 1;
                    c1389a2.gy[i3] = m2149a(iArr[i2], c1383f, c1389aArr, (Set) set);
                    i2++;
                    i3 = i4;
                }
                break;
            case 4:
                c1389a2 = m2155g(c1389a);
                c1389a2.gz = di.m2191j(m2149a(m2156h(c1389a).gm, c1383f, c1389aArr, (Set) set));
                break;
            case 7:
                c1389a2 = m2155g(c1389a);
                h = m2156h(c1389a);
                c1389a2.gD = new C1389a[h.gl.length];
                iArr = h.gl;
                length = iArr.length;
                i3 = 0;
                while (i2 < length) {
                    i4 = i3 + 1;
                    c1389a2.gD[i3] = m2149a(iArr[i2], c1383f, c1389aArr, (Set) set);
                    i2++;
                    i3 = i4;
                }
                break;
        }
        if (c1389a2 == null) {
            cN("Invalid value: " + c1389a);
        }
        c1389aArr[i] = c1389a2;
        set.remove(Integer.valueOf(i));
        return c1389a2;
    }

    /* renamed from: a */
    private static C0623a m2150a(C1379b c1379b, C1383f c1383f, C1389a[] c1389aArr, int i) throws C0629g {
        C0624b qk = C0623a.qk();
        for (int valueOf : c1379b.fq) {
            C1382e c1382e = (C1382e) m2152a(c1383f.fH, Integer.valueOf(valueOf).intValue(), "properties");
            String str = (String) m2152a(c1383f.fF, c1382e.key, "keys");
            C1389a c1389a = (C1389a) m2152a(c1389aArr, c1382e.value, "values");
            if (C0378b.PUSH_AFTER_EVALUATE.toString().equals(str)) {
                qk.m2140i(c1389a);
            } else {
                qk.m2139b(str, c1389a);
            }
        }
        return qk.qn();
    }

    /* renamed from: a */
    private static C0627e m2151a(C1384g c1384g, List<C0623a> list, List<C0623a> list2, List<C0623a> list3, C1383f c1383f) {
        C0628f qs = C0627e.qs();
        for (int valueOf : c1384g.fV) {
            qs.m2143b((C0623a) list3.get(Integer.valueOf(valueOf).intValue()));
        }
        for (int valueOf2 : c1384g.fW) {
            qs.m2144c((C0623a) list3.get(Integer.valueOf(valueOf2).intValue()));
        }
        for (int valueOf22 : c1384g.fX) {
            qs.m2145d((C0623a) list.get(Integer.valueOf(valueOf22).intValue()));
        }
        for (int valueOf3 : c1384g.fZ) {
            qs.cP(c1383f.fG[Integer.valueOf(valueOf3).intValue()].gv);
        }
        for (int valueOf222 : c1384g.fY) {
            qs.m2146e((C0623a) list.get(Integer.valueOf(valueOf222).intValue()));
        }
        for (int valueOf32 : c1384g.ga) {
            qs.cQ(c1383f.fG[Integer.valueOf(valueOf32).intValue()].gv);
        }
        for (int valueOf2222 : c1384g.gb) {
            qs.m2147f((C0623a) list2.get(Integer.valueOf(valueOf2222).intValue()));
        }
        for (int valueOf322 : c1384g.gd) {
            qs.cR(c1383f.fG[Integer.valueOf(valueOf322).intValue()].gv);
        }
        for (int valueOf22222 : c1384g.gc) {
            qs.m2148g((C0623a) list2.get(Integer.valueOf(valueOf22222).intValue()));
        }
        for (int valueOf4 : c1384g.ge) {
            qs.cS(c1383f.fG[Integer.valueOf(valueOf4).intValue()].gv);
        }
        return qs.qD();
    }

    /* renamed from: a */
    private static <T> T m2152a(T[] tArr, int i, String str) throws C0629g {
        if (i < 0 || i >= tArr.length) {
            cN("Index out of bounds detected: " + i + " in " + str);
        }
        return tArr[i];
    }

    /* renamed from: b */
    public static C0625c m2153b(C1383f c1383f) throws C0629g {
        int i;
        int i2 = 0;
        C1389a[] c1389aArr = new C1389a[c1383f.fG.length];
        for (i = 0; i < c1383f.fG.length; i++) {
            m2149a(i, c1383f, c1389aArr, new HashSet(0));
        }
        C0626d qo = C0625c.qo();
        List arrayList = new ArrayList();
        for (i = 0; i < c1383f.fJ.length; i++) {
            arrayList.add(m2150a(c1383f.fJ[i], c1383f, c1389aArr, i));
        }
        List arrayList2 = new ArrayList();
        for (i = 0; i < c1383f.fK.length; i++) {
            arrayList2.add(m2150a(c1383f.fK[i], c1383f, c1389aArr, i));
        }
        List arrayList3 = new ArrayList();
        for (i = 0; i < c1383f.fI.length; i++) {
            C0623a a = m2150a(c1383f.fI[i], c1383f, c1389aArr, i);
            qo.m2141a(a);
            arrayList3.add(a);
        }
        C1384g[] c1384gArr = c1383f.fL;
        int length = c1384gArr.length;
        while (i2 < length) {
            qo.m2142a(m2151a(c1384gArr[i2], arrayList, arrayList3, arrayList2, c1383f));
            i2++;
        }
        qo.cO(c1383f.version);
        qo.fO(c1383f.fT);
        return qo.qr();
    }

    /* renamed from: b */
    public static void m2154b(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    private static void cN(String str) throws C0629g {
        bh.m2114T(str);
        throw new C0629g(str);
    }

    /* renamed from: g */
    public static C1389a m2155g(C1389a c1389a) {
        C1389a c1389a2 = new C1389a();
        c1389a2.type = c1389a.type;
        c1389a2.gE = (int[]) c1389a.gE.clone();
        if (c1389a.gF) {
            c1389a2.gF = c1389a.gF;
        }
        return c1389a2;
    }

    /* renamed from: h */
    private static C1385h m2156h(C1389a c1389a) throws C0629g {
        if (((C1385h) c1389a.m3536a(C1385h.gf)) == null) {
            cN("Expected a ServingValue and didn't get one. Value is: " + c1389a);
        }
        return (C1385h) c1389a.m3536a(C1385h.gf);
    }
}
