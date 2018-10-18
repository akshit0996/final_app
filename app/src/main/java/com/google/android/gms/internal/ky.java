package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.kr.C1017a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class ky extends kr implements SafeParcelable {
    public static final kz CREATOR = new kz();
    private final int CK;
    private final kv NT;
    private final Parcel Oa;
    private final int Ob;
    private int Oc;
    private int Od;
    private final String mClassName;

    ky(int i, Parcel parcel, kv kvVar) {
        this.CK = i;
        this.Oa = (Parcel) jx.m1582i(parcel);
        this.Ob = 2;
        this.NT = kvVar;
        if (this.NT == null) {
            this.mClassName = null;
        } else {
            this.mClassName = this.NT.ia();
        }
        this.Oc = 2;
    }

    private ky(SafeParcelable safeParcelable, kv kvVar, String str) {
        this.CK = 1;
        this.Oa = Parcel.obtain();
        safeParcelable.writeToParcel(this.Oa, 0);
        this.Ob = 1;
        this.NT = (kv) jx.m1582i(kvVar);
        this.mClassName = (String) jx.m1582i(str);
        this.Oc = 2;
    }

    /* renamed from: a */
    public static <T extends kr & SafeParcelable> ky m3391a(T t) {
        String canonicalName = t.getClass().getCanonicalName();
        return new ky((SafeParcelable) t, m3397b((kr) t), canonicalName);
    }

    /* renamed from: a */
    private static void m3392a(kv kvVar, kr krVar) {
        Class cls = krVar.getClass();
        if (!kvVar.m3390b(cls)) {
            HashMap hK = krVar.hK();
            kvVar.m3389a(cls, krVar.hK());
            for (String str : hK.keySet()) {
                C1017a c1017a = (C1017a) hK.get(str);
                Class hS = c1017a.hS();
                if (hS != null) {
                    try {
                        m3392a(kvVar, (kr) hS.newInstance());
                    } catch (Throwable e) {
                        throw new IllegalStateException("Could not instantiate an object of type " + c1017a.hS().getCanonicalName(), e);
                    } catch (Throwable e2) {
                        throw new IllegalStateException("Could not access object of type " + c1017a.hS().getCanonicalName(), e2);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private void m3393a(StringBuilder stringBuilder, int i, Object obj) {
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                stringBuilder.append(obj);
                return;
            case 7:
                stringBuilder.append("\"").append(li.bh(obj.toString())).append("\"");
                return;
            case 8:
                stringBuilder.append("\"").append(lb.m1634d((byte[]) obj)).append("\"");
                return;
            case 9:
                stringBuilder.append("\"").append(lb.m1635e((byte[]) obj));
                stringBuilder.append("\"");
                return;
            case 10:
                lj.m1645a(stringBuilder, (HashMap) obj);
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException("Unknown type = " + i);
        }
    }

    /* renamed from: a */
    private void m3394a(StringBuilder stringBuilder, C1017a<?, ?> c1017a, Parcel parcel, int i) {
        switch (c1017a.hJ()) {
            case 0:
                m3400b(stringBuilder, (C1017a) c1017a, m1610a(c1017a, Integer.valueOf(C0185a.m221g(parcel, i))));
                return;
            case 1:
                m3400b(stringBuilder, (C1017a) c1017a, m1610a(c1017a, C0185a.m225k(parcel, i)));
                return;
            case 2:
                m3400b(stringBuilder, (C1017a) c1017a, m1610a(c1017a, Long.valueOf(C0185a.m223i(parcel, i))));
                return;
            case 3:
                m3400b(stringBuilder, (C1017a) c1017a, m1610a(c1017a, Float.valueOf(C0185a.m226l(parcel, i))));
                return;
            case 4:
                m3400b(stringBuilder, (C1017a) c1017a, m1610a(c1017a, Double.valueOf(C0185a.m227m(parcel, i))));
                return;
            case 5:
                m3400b(stringBuilder, (C1017a) c1017a, m1610a(c1017a, C0185a.m228n(parcel, i)));
                return;
            case 6:
                m3400b(stringBuilder, (C1017a) c1017a, m1610a(c1017a, Boolean.valueOf(C0185a.m217c(parcel, i))));
                return;
            case 7:
                m3400b(stringBuilder, (C1017a) c1017a, m1610a(c1017a, C0185a.m229o(parcel, i)));
                return;
            case 8:
            case 9:
                m3400b(stringBuilder, (C1017a) c1017a, m1610a(c1017a, C0185a.m232r(parcel, i)));
                return;
            case 10:
                m3400b(stringBuilder, (C1017a) c1017a, m1610a(c1017a, m3402g(C0185a.m231q(parcel, i))));
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException("Unknown field out type = " + c1017a.hJ());
        }
    }

    /* renamed from: a */
    private void m3395a(StringBuilder stringBuilder, String str, C1017a<?, ?> c1017a, Parcel parcel, int i) {
        stringBuilder.append("\"").append(str).append("\":");
        if (c1017a.hU()) {
            m3394a(stringBuilder, c1017a, parcel, i);
        } else {
            m3399b(stringBuilder, c1017a, parcel, i);
        }
    }

    /* renamed from: a */
    private void m3396a(StringBuilder stringBuilder, HashMap<String, C1017a<?, ?>> hashMap, Parcel parcel) {
        HashMap b = m3398b((HashMap) hashMap);
        stringBuilder.append('{');
        int G = C0185a.m208G(parcel);
        Object obj = null;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            Entry entry = (Entry) b.get(Integer.valueOf(C0185a.aH(F)));
            if (entry != null) {
                if (obj != null) {
                    stringBuilder.append(",");
                }
                m3395a(stringBuilder, (String) entry.getKey(), (C1017a) entry.getValue(), parcel, F);
                obj = 1;
            }
        }
        if (parcel.dataPosition() != G) {
            throw new C0184a("Overread allowed size end=" + G, parcel);
        }
        stringBuilder.append('}');
    }

    /* renamed from: b */
    private static kv m3397b(kr krVar) {
        kv kvVar = new kv(krVar.getClass());
        m3392a(kvVar, krVar);
        kvVar.hY();
        kvVar.hX();
        return kvVar;
    }

    /* renamed from: b */
    private static HashMap<Integer, Entry<String, C1017a<?, ?>>> m3398b(HashMap<String, C1017a<?, ?>> hashMap) {
        HashMap<Integer, Entry<String, C1017a<?, ?>>> hashMap2 = new HashMap();
        for (Entry entry : hashMap.entrySet()) {
            hashMap2.put(Integer.valueOf(((C1017a) entry.getValue()).hR()), entry);
        }
        return hashMap2;
    }

    /* renamed from: b */
    private void m3399b(StringBuilder stringBuilder, C1017a<?, ?> c1017a, Parcel parcel, int i) {
        if (c1017a.hP()) {
            stringBuilder.append("[");
            switch (c1017a.hJ()) {
                case 0:
                    la.m1626a(stringBuilder, C0185a.m235u(parcel, i));
                    break;
                case 1:
                    la.m1628a(stringBuilder, C0185a.m237w(parcel, i));
                    break;
                case 2:
                    la.m1627a(stringBuilder, C0185a.m236v(parcel, i));
                    break;
                case 3:
                    la.m1625a(stringBuilder, C0185a.m238x(parcel, i));
                    break;
                case 4:
                    la.m1624a(stringBuilder, C0185a.m239y(parcel, i));
                    break;
                case 5:
                    la.m1628a(stringBuilder, C0185a.m240z(parcel, i));
                    break;
                case 6:
                    la.m1630a(stringBuilder, C0185a.m234t(parcel, i));
                    break;
                case 7:
                    la.m1629a(stringBuilder, C0185a.m202A(parcel, i));
                    break;
                case 8:
                case 9:
                case 10:
                    throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
                case 11:
                    Parcel[] E = C0185a.m206E(parcel, i);
                    int length = E.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        if (i2 > 0) {
                            stringBuilder.append(",");
                        }
                        E[i2].setDataPosition(0);
                        m3396a(stringBuilder, c1017a.hW(), E[i2]);
                    }
                    break;
                default:
                    throw new IllegalStateException("Unknown field type out.");
            }
            stringBuilder.append("]");
            return;
        }
        switch (c1017a.hJ()) {
            case 0:
                stringBuilder.append(C0185a.m221g(parcel, i));
                return;
            case 1:
                stringBuilder.append(C0185a.m225k(parcel, i));
                return;
            case 2:
                stringBuilder.append(C0185a.m223i(parcel, i));
                return;
            case 3:
                stringBuilder.append(C0185a.m226l(parcel, i));
                return;
            case 4:
                stringBuilder.append(C0185a.m227m(parcel, i));
                return;
            case 5:
                stringBuilder.append(C0185a.m228n(parcel, i));
                return;
            case 6:
                stringBuilder.append(C0185a.m217c(parcel, i));
                return;
            case 7:
                stringBuilder.append("\"").append(li.bh(C0185a.m229o(parcel, i))).append("\"");
                return;
            case 8:
                stringBuilder.append("\"").append(lb.m1634d(C0185a.m232r(parcel, i))).append("\"");
                return;
            case 9:
                stringBuilder.append("\"").append(lb.m1635e(C0185a.m232r(parcel, i)));
                stringBuilder.append("\"");
                return;
            case 10:
                Bundle q = C0185a.m231q(parcel, i);
                Set<String> keySet = q.keySet();
                keySet.size();
                stringBuilder.append("{");
                int i3 = 1;
                for (String str : keySet) {
                    if (i3 == 0) {
                        stringBuilder.append(",");
                    }
                    stringBuilder.append("\"").append(str).append("\"");
                    stringBuilder.append(":");
                    stringBuilder.append("\"").append(li.bh(q.getString(str))).append("\"");
                    i3 = 0;
                }
                stringBuilder.append("}");
                return;
            case 11:
                Parcel D = C0185a.m205D(parcel, i);
                D.setDataPosition(0);
                m3396a(stringBuilder, c1017a.hW(), D);
                return;
            default:
                throw new IllegalStateException("Unknown field type out");
        }
    }

    /* renamed from: b */
    private void m3400b(StringBuilder stringBuilder, C1017a<?, ?> c1017a, Object obj) {
        if (c1017a.hO()) {
            m3401b(stringBuilder, (C1017a) c1017a, (ArrayList) obj);
        } else {
            m3393a(stringBuilder, c1017a.hI(), obj);
        }
    }

    /* renamed from: b */
    private void m3401b(StringBuilder stringBuilder, C1017a<?, ?> c1017a, ArrayList<?> arrayList) {
        stringBuilder.append("[");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                stringBuilder.append(",");
            }
            m3393a(stringBuilder, c1017a.hI(), arrayList.get(i));
        }
        stringBuilder.append("]");
    }

    /* renamed from: g */
    public static HashMap<String, String> m3402g(Bundle bundle) {
        HashMap<String, String> hashMap = new HashMap();
        for (String str : bundle.keySet()) {
            hashMap.put(str, bundle.getString(str));
        }
        return hashMap;
    }

    protected Object bc(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    protected boolean bd(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    public int describeContents() {
        kz kzVar = CREATOR;
        return 0;
    }

    public int getVersionCode() {
        return this.CK;
    }

    public HashMap<String, C1017a<?, ?>> hK() {
        return this.NT == null ? null : this.NT.bg(this.mClassName);
    }

    public Parcel ic() {
        switch (this.Oc) {
            case 0:
                this.Od = C0186b.m243H(this.Oa);
                C0186b.m244H(this.Oa, this.Od);
                this.Oc = 2;
                break;
            case 1:
                C0186b.m244H(this.Oa, this.Od);
                this.Oc = 2;
                break;
        }
        return this.Oa;
    }

    kv id() {
        switch (this.Ob) {
            case 0:
                return null;
            case 1:
                return this.NT;
            case 2:
                return this.NT;
            default:
                throw new IllegalStateException("Invalid creation type: " + this.Ob);
        }
    }

    public String toString() {
        jx.m1578b(this.NT, (Object) "Cannot convert to JSON on client side.");
        Parcel ic = ic();
        ic.setDataPosition(0);
        StringBuilder stringBuilder = new StringBuilder(100);
        m3396a(stringBuilder, this.NT.bg(this.mClassName), ic);
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        kz kzVar = CREATOR;
        kz.m1621a(this, out, flags);
    }
}
