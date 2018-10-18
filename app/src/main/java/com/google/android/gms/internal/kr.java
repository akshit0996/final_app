package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class kr {

    /* renamed from: com.google.android.gms.internal.kr$b */
    public interface C0485b<I, O> {
        I convertBack(O o);

        int hI();

        int hJ();
    }

    /* renamed from: com.google.android.gms.internal.kr$a */
    public static class C1017a<I, O> implements SafeParcelable {
        public static final kt CREATOR = new kt();
        private final int CK;
        protected final int NL;
        protected final boolean NM;
        protected final int NN;
        protected final boolean NO;
        protected final String NP;
        protected final int NQ;
        protected final Class<? extends kr> NR;
        protected final String NS;
        private kv NT;
        private C0485b<I, O> NU;

        C1017a(int i, int i2, boolean z, int i3, boolean z2, String str, int i4, String str2, km kmVar) {
            this.CK = i;
            this.NL = i2;
            this.NM = z;
            this.NN = i3;
            this.NO = z2;
            this.NP = str;
            this.NQ = i4;
            if (str2 == null) {
                this.NR = null;
                this.NS = null;
            } else {
                this.NR = ky.class;
                this.NS = str2;
            }
            if (kmVar == null) {
                this.NU = null;
            } else {
                this.NU = kmVar.hG();
            }
        }

        protected C1017a(int i, boolean z, int i2, boolean z2, String str, int i3, Class<? extends kr> cls, C0485b<I, O> c0485b) {
            this.CK = 1;
            this.NL = i;
            this.NM = z;
            this.NN = i2;
            this.NO = z2;
            this.NP = str;
            this.NQ = i3;
            this.NR = cls;
            if (cls == null) {
                this.NS = null;
            } else {
                this.NS = cls.getCanonicalName();
            }
            this.NU = c0485b;
        }

        /* renamed from: a */
        public static C1017a m3377a(String str, int i, C0485b<?, ?> c0485b, boolean z) {
            return new C1017a(c0485b.hI(), z, c0485b.hJ(), false, str, i, null, c0485b);
        }

        /* renamed from: a */
        public static <T extends kr> C1017a<T, T> m3378a(String str, int i, Class<T> cls) {
            return new C1017a(11, false, 11, false, str, i, cls, null);
        }

        /* renamed from: b */
        public static <T extends kr> C1017a<ArrayList<T>, ArrayList<T>> m3379b(String str, int i, Class<T> cls) {
            return new C1017a(11, true, 11, true, str, i, cls, null);
        }

        /* renamed from: i */
        public static C1017a<Integer, Integer> m3381i(String str, int i) {
            return new C1017a(0, false, 0, false, str, i, null, null);
        }

        /* renamed from: j */
        public static C1017a<Double, Double> m3382j(String str, int i) {
            return new C1017a(4, false, 4, false, str, i, null, null);
        }

        /* renamed from: k */
        public static C1017a<Boolean, Boolean> m3383k(String str, int i) {
            return new C1017a(6, false, 6, false, str, i, null, null);
        }

        /* renamed from: l */
        public static C1017a<String, String> m3384l(String str, int i) {
            return new C1017a(7, false, 7, false, str, i, null, null);
        }

        /* renamed from: m */
        public static C1017a<ArrayList<String>, ArrayList<String>> m3385m(String str, int i) {
            return new C1017a(7, true, 7, true, str, i, null, null);
        }

        /* renamed from: a */
        public void m3386a(kv kvVar) {
            this.NT = kvVar;
        }

        public I convertBack(O output) {
            return this.NU.convertBack(output);
        }

        public int describeContents() {
            kt ktVar = CREATOR;
            return 0;
        }

        public int getVersionCode() {
            return this.CK;
        }

        public int hI() {
            return this.NL;
        }

        public int hJ() {
            return this.NN;
        }

        public C1017a<I, O> hN() {
            return new C1017a(this.CK, this.NL, this.NM, this.NN, this.NO, this.NP, this.NQ, this.NS, hV());
        }

        public boolean hO() {
            return this.NM;
        }

        public boolean hP() {
            return this.NO;
        }

        public String hQ() {
            return this.NP;
        }

        public int hR() {
            return this.NQ;
        }

        public Class<? extends kr> hS() {
            return this.NR;
        }

        String hT() {
            return this.NS == null ? null : this.NS;
        }

        public boolean hU() {
            return this.NU != null;
        }

        km hV() {
            return this.NU == null ? null : km.m3373a(this.NU);
        }

        public HashMap<String, C1017a<?, ?>> hW() {
            jx.m1582i(this.NS);
            jx.m1582i(this.NT);
            return this.NT.bg(this.NS);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Field\n");
            stringBuilder.append("            versionCode=").append(this.CK).append('\n');
            stringBuilder.append("                 typeIn=").append(this.NL).append('\n');
            stringBuilder.append("            typeInArray=").append(this.NM).append('\n');
            stringBuilder.append("                typeOut=").append(this.NN).append('\n');
            stringBuilder.append("           typeOutArray=").append(this.NO).append('\n');
            stringBuilder.append("        outputFieldName=").append(this.NP).append('\n');
            stringBuilder.append("      safeParcelFieldId=").append(this.NQ).append('\n');
            stringBuilder.append("       concreteTypeName=").append(hT()).append('\n');
            if (hS() != null) {
                stringBuilder.append("     concreteType.class=").append(hS().getCanonicalName()).append('\n');
            }
            stringBuilder.append("          converterName=").append(this.NU == null ? "null" : this.NU.getClass().getCanonicalName()).append('\n');
            return stringBuilder.toString();
        }

        public void writeToParcel(Parcel out, int flags) {
            kt ktVar = CREATOR;
            kt.m1613a(this, out, flags);
        }
    }

    /* renamed from: a */
    private void m1608a(StringBuilder stringBuilder, C1017a c1017a, Object obj) {
        if (c1017a.hI() == 11) {
            stringBuilder.append(((kr) c1017a.hS().cast(obj)).toString());
        } else if (c1017a.hI() == 7) {
            stringBuilder.append("\"");
            stringBuilder.append(li.bh((String) obj));
            stringBuilder.append("\"");
        } else {
            stringBuilder.append(obj);
        }
    }

    /* renamed from: a */
    private void m1609a(StringBuilder stringBuilder, C1017a c1017a, ArrayList<Object> arrayList) {
        stringBuilder.append("[");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                stringBuilder.append(",");
            }
            Object obj = arrayList.get(i);
            if (obj != null) {
                m1608a(stringBuilder, c1017a, obj);
            }
        }
        stringBuilder.append("]");
    }

    /* renamed from: a */
    protected <O, I> I m1610a(C1017a<I, O> c1017a, Object obj) {
        return c1017a.NU != null ? c1017a.convertBack(obj) : obj;
    }

    /* renamed from: a */
    protected boolean mo3354a(C1017a c1017a) {
        return c1017a.hJ() == 11 ? c1017a.hP() ? bf(c1017a.hQ()) : be(c1017a.hQ()) : bd(c1017a.hQ());
    }

    /* renamed from: b */
    protected Object mo3355b(C1017a c1017a) {
        String hQ = c1017a.hQ();
        if (c1017a.hS() == null) {
            return bc(c1017a.hQ());
        }
        jx.m1577a(bc(c1017a.hQ()) == null, "Concrete field shouldn't be value object: %s", c1017a.hQ());
        Map hM = c1017a.hP() ? hM() : hL();
        if (hM != null) {
            return hM.get(hQ);
        }
        try {
            return getClass().getMethod("get" + Character.toUpperCase(hQ.charAt(0)) + hQ.substring(1), new Class[0]).invoke(this, new Object[0]);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    protected abstract Object bc(String str);

    protected abstract boolean bd(String str);

    protected boolean be(String str) {
        throw new UnsupportedOperationException("Concrete types not supported");
    }

    protected boolean bf(String str) {
        throw new UnsupportedOperationException("Concrete type arrays not supported");
    }

    public abstract HashMap<String, C1017a<?, ?>> hK();

    public HashMap<String, Object> hL() {
        return null;
    }

    public HashMap<String, Object> hM() {
        return null;
    }

    public String toString() {
        HashMap hK = hK();
        StringBuilder stringBuilder = new StringBuilder(100);
        for (String str : hK.keySet()) {
            C1017a c1017a = (C1017a) hK.get(str);
            if (mo3354a(c1017a)) {
                Object a = m1610a(c1017a, mo3355b(c1017a));
                if (stringBuilder.length() == 0) {
                    stringBuilder.append("{");
                } else {
                    stringBuilder.append(",");
                }
                stringBuilder.append("\"").append(str).append("\":");
                if (a != null) {
                    switch (c1017a.hJ()) {
                        case 8:
                            stringBuilder.append("\"").append(lb.m1634d((byte[]) a)).append("\"");
                            break;
                        case 9:
                            stringBuilder.append("\"").append(lb.m1635e((byte[]) a)).append("\"");
                            break;
                        case 10:
                            lj.m1645a(stringBuilder, (HashMap) a);
                            break;
                        default:
                            if (!c1017a.hO()) {
                                m1608a(stringBuilder, c1017a, a);
                                break;
                            }
                            m1609a(stringBuilder, c1017a, (ArrayList) a);
                            break;
                    }
                }
                stringBuilder.append("null");
            }
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.append("}");
        } else {
            stringBuilder.append("{}");
        }
        return stringBuilder.toString();
    }
}
