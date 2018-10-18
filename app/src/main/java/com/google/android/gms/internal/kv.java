package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.kr.C1017a;
import java.util.ArrayList;
import java.util.HashMap;

public class kv implements SafeParcelable {
    public static final kw CREATOR = new kw();
    private final int CK;
    private final HashMap<String, HashMap<String, C1017a<?, ?>>> NV;
    private final ArrayList<C1018a> NW;
    private final String NX;

    /* renamed from: com.google.android.gms.internal.kv$a */
    public static class C1018a implements SafeParcelable {
        public static final kx CREATOR = new kx();
        final ArrayList<C1019b> NY;
        final String className;
        final int versionCode;

        C1018a(int i, String str, ArrayList<C1019b> arrayList) {
            this.versionCode = i;
            this.className = str;
            this.NY = arrayList;
        }

        C1018a(String str, HashMap<String, C1017a<?, ?>> hashMap) {
            this.versionCode = 1;
            this.className = str;
            this.NY = C1018a.m3387a(hashMap);
        }

        /* renamed from: a */
        private static ArrayList<C1019b> m3387a(HashMap<String, C1017a<?, ?>> hashMap) {
            if (hashMap == null) {
                return null;
            }
            ArrayList<C1019b> arrayList = new ArrayList();
            for (String str : hashMap.keySet()) {
                arrayList.add(new C1019b(str, (C1017a) hashMap.get(str)));
            }
            return arrayList;
        }

        public int describeContents() {
            kx kxVar = CREATOR;
            return 0;
        }

        HashMap<String, C1017a<?, ?>> ib() {
            HashMap<String, C1017a<?, ?>> hashMap = new HashMap();
            int size = this.NY.size();
            for (int i = 0; i < size; i++) {
                C1019b c1019b = (C1019b) this.NY.get(i);
                hashMap.put(c1019b.fv, c1019b.NZ);
            }
            return hashMap;
        }

        public void writeToParcel(Parcel out, int flags) {
            kx kxVar = CREATOR;
            kx.m1619a(this, out, flags);
        }
    }

    /* renamed from: com.google.android.gms.internal.kv$b */
    public static class C1019b implements SafeParcelable {
        public static final ku CREATOR = new ku();
        final C1017a<?, ?> NZ;
        final String fv;
        final int versionCode;

        C1019b(int i, String str, C1017a<?, ?> c1017a) {
            this.versionCode = i;
            this.fv = str;
            this.NZ = c1017a;
        }

        C1019b(String str, C1017a<?, ?> c1017a) {
            this.versionCode = 1;
            this.fv = str;
            this.NZ = c1017a;
        }

        public int describeContents() {
            ku kuVar = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel out, int flags) {
            ku kuVar = CREATOR;
            ku.m1615a(this, out, flags);
        }
    }

    kv(int i, ArrayList<C1018a> arrayList, String str) {
        this.CK = i;
        this.NW = null;
        this.NV = m3388c(arrayList);
        this.NX = (String) jx.m1582i(str);
        hX();
    }

    public kv(Class<? extends kr> cls) {
        this.CK = 1;
        this.NW = null;
        this.NV = new HashMap();
        this.NX = cls.getCanonicalName();
    }

    /* renamed from: c */
    private static HashMap<String, HashMap<String, C1017a<?, ?>>> m3388c(ArrayList<C1018a> arrayList) {
        HashMap<String, HashMap<String, C1017a<?, ?>>> hashMap = new HashMap();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            C1018a c1018a = (C1018a) arrayList.get(i);
            hashMap.put(c1018a.className, c1018a.ib());
        }
        return hashMap;
    }

    /* renamed from: a */
    public void m3389a(Class<? extends kr> cls, HashMap<String, C1017a<?, ?>> hashMap) {
        this.NV.put(cls.getCanonicalName(), hashMap);
    }

    /* renamed from: b */
    public boolean m3390b(Class<? extends kr> cls) {
        return this.NV.containsKey(cls.getCanonicalName());
    }

    public HashMap<String, C1017a<?, ?>> bg(String str) {
        return (HashMap) this.NV.get(str);
    }

    public int describeContents() {
        kw kwVar = CREATOR;
        return 0;
    }

    int getVersionCode() {
        return this.CK;
    }

    public void hX() {
        for (String str : this.NV.keySet()) {
            HashMap hashMap = (HashMap) this.NV.get(str);
            for (String str2 : hashMap.keySet()) {
                ((C1017a) hashMap.get(str2)).m3386a(this);
            }
        }
    }

    public void hY() {
        for (String str : this.NV.keySet()) {
            HashMap hashMap = (HashMap) this.NV.get(str);
            HashMap hashMap2 = new HashMap();
            for (String str2 : hashMap.keySet()) {
                hashMap2.put(str2, ((C1017a) hashMap.get(str2)).hN());
            }
            this.NV.put(str, hashMap2);
        }
    }

    ArrayList<C1018a> hZ() {
        ArrayList<C1018a> arrayList = new ArrayList();
        for (String str : this.NV.keySet()) {
            arrayList.add(new C1018a(str, (HashMap) this.NV.get(str)));
        }
        return arrayList;
    }

    public String ia() {
        return this.NX;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : this.NV.keySet()) {
            stringBuilder.append(str).append(":\n");
            HashMap hashMap = (HashMap) this.NV.get(str);
            for (String str2 : hashMap.keySet()) {
                stringBuilder.append("  ").append(str2).append(": ");
                stringBuilder.append(hashMap.get(str2));
            }
        }
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        kw kwVar = CREATOR;
        kw.m1617a(this, out, flags);
    }
}
