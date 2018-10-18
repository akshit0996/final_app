package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.internal.kr.C1017a;
import com.google.android.gms.plus.model.moments.ItemScope;
import com.google.android.gms.plus.model.moments.Moment;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public final class pf extends ks implements Moment {
    public static final pg CREATOR = new pg();
    private static final HashMap<String, C1017a<?, ?>> aom = new HashMap();
    String CE;
    final int CK;
    final Set<Integer> aon;
    String apa;
    pd api;
    pd apj;
    String vc;

    static {
        aom.put("id", C1017a.m3384l("id", 2));
        aom.put("result", C1017a.m3378a("result", 4, pd.class));
        aom.put("startDate", C1017a.m3384l("startDate", 5));
        aom.put("target", C1017a.m3378a("target", 6, pd.class));
        aom.put("type", C1017a.m3384l("type", 7));
    }

    public pf() {
        this.CK = 1;
        this.aon = new HashSet();
    }

    pf(Set<Integer> set, int i, String str, pd pdVar, String str2, pd pdVar2, String str3) {
        this.aon = set;
        this.CK = i;
        this.CE = str;
        this.api = pdVar;
        this.apa = str2;
        this.apj = pdVar2;
        this.vc = str3;
    }

    public pf(Set<Integer> set, String str, pd pdVar, String str2, pd pdVar2, String str3) {
        this.aon = set;
        this.CK = 1;
        this.CE = str;
        this.api = pdVar;
        this.apa = str2;
        this.apj = pdVar2;
        this.vc = str3;
    }

    /* renamed from: a */
    protected boolean mo3354a(C1017a c1017a) {
        return this.aon.contains(Integer.valueOf(c1017a.hR()));
    }

    /* renamed from: b */
    protected Object mo3355b(C1017a c1017a) {
        switch (c1017a.hR()) {
            case 2:
                return this.CE;
            case 4:
                return this.api;
            case 5:
                return this.apa;
            case 6:
                return this.apj;
            case 7:
                return this.vc;
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + c1017a.hR());
        }
    }

    public int describeContents() {
        pg pgVar = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof pf)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        pf pfVar = (pf) obj;
        for (C1017a c1017a : aom.values()) {
            if (mo3354a(c1017a)) {
                if (!pfVar.mo3354a(c1017a)) {
                    return false;
                }
                if (!mo3355b(c1017a).equals(pfVar.mo3355b(c1017a))) {
                    return false;
                }
            } else if (pfVar.mo3354a(c1017a)) {
                return false;
            }
        }
        return true;
    }

    public /* synthetic */ Object freeze() {
        return oJ();
    }

    public String getId() {
        return this.CE;
    }

    public ItemScope getResult() {
        return this.api;
    }

    public String getStartDate() {
        return this.apa;
    }

    public ItemScope getTarget() {
        return this.apj;
    }

    public String getType() {
        return this.vc;
    }

    public HashMap<String, C1017a<?, ?>> hK() {
        return aom;
    }

    public boolean hasId() {
        return this.aon.contains(Integer.valueOf(2));
    }

    public boolean hasResult() {
        return this.aon.contains(Integer.valueOf(4));
    }

    public boolean hasStartDate() {
        return this.aon.contains(Integer.valueOf(5));
    }

    public boolean hasTarget() {
        return this.aon.contains(Integer.valueOf(6));
    }

    public boolean hasType() {
        return this.aon.contains(Integer.valueOf(7));
    }

    public int hashCode() {
        int i = 0;
        for (C1017a c1017a : aom.values()) {
            int hashCode;
            if (mo3354a(c1017a)) {
                hashCode = mo3355b(c1017a).hashCode() + (i + c1017a.hR());
            } else {
                hashCode = i;
            }
            i = hashCode;
        }
        return i;
    }

    public boolean isDataValid() {
        return true;
    }

    public pf oJ() {
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        pg pgVar = CREATOR;
        pg.m1771a(this, out, flags);
    }
}
