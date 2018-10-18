package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.kr.C0485b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class ko implements SafeParcelable, C0485b<String, Integer> {
    public static final kp CREATOR = new kp();
    private final int CK;
    private final HashMap<String, Integer> NG;
    private final HashMap<Integer, String> NH;
    private final ArrayList<C1016a> NI;

    /* renamed from: com.google.android.gms.internal.ko$a */
    public static final class C1016a implements SafeParcelable {
        public static final kq CREATOR = new kq();
        final String NJ;
        final int NK;
        final int versionCode;

        C1016a(int i, String str, int i2) {
            this.versionCode = i;
            this.NJ = str;
            this.NK = i2;
        }

        C1016a(String str, int i) {
            this.versionCode = 1;
            this.NJ = str;
            this.NK = i;
        }

        public int describeContents() {
            kq kqVar = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel out, int flags) {
            kq kqVar = CREATOR;
            kq.m1606a(this, out, flags);
        }
    }

    public ko() {
        this.CK = 1;
        this.NG = new HashMap();
        this.NH = new HashMap();
        this.NI = null;
    }

    ko(int i, ArrayList<C1016a> arrayList) {
        this.CK = i;
        this.NG = new HashMap();
        this.NH = new HashMap();
        this.NI = null;
        m3374b(arrayList);
    }

    /* renamed from: b */
    private void m3374b(ArrayList<C1016a> arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            C1016a c1016a = (C1016a) it.next();
            m3376h(c1016a.NJ, c1016a.NK);
        }
    }

    /* renamed from: a */
    public String m3375a(Integer num) {
        String str = (String) this.NH.get(num);
        return (str == null && this.NG.containsKey("gms_unknown")) ? "gms_unknown" : str;
    }

    public /* synthetic */ Object convertBack(Object x0) {
        return m3375a((Integer) x0);
    }

    public int describeContents() {
        kp kpVar = CREATOR;
        return 0;
    }

    int getVersionCode() {
        return this.CK;
    }

    /* renamed from: h */
    public ko m3376h(String str, int i) {
        this.NG.put(str, Integer.valueOf(i));
        this.NH.put(Integer.valueOf(i), str);
        return this;
    }

    ArrayList<C1016a> hH() {
        ArrayList<C1016a> arrayList = new ArrayList();
        for (String str : this.NG.keySet()) {
            arrayList.add(new C1016a(str, ((Integer) this.NG.get(str)).intValue()));
        }
        return arrayList;
    }

    public int hI() {
        return 7;
    }

    public int hJ() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        kp kpVar = CREATOR;
        kp.m1604a(this, out, flags);
    }
}
