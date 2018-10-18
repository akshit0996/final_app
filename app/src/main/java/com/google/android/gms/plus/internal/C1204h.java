package com.google.android.gms.plus.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import java.util.Arrays;

/* renamed from: com.google.android.gms.plus.internal.h */
public class C1204h implements SafeParcelable {
    public static final C0597i CREATOR = new C0597i();
    private final int CK;
    private final String DZ;
    private final String[] anQ;
    private final String[] anR;
    private final String[] anS;
    private final String anT;
    private final String anU;
    private final String anV;
    private final String anW;
    private final PlusCommonExtras anX;

    C1204h(int i, String str, String[] strArr, String[] strArr2, String[] strArr3, String str2, String str3, String str4, String str5, PlusCommonExtras plusCommonExtras) {
        this.CK = i;
        this.DZ = str;
        this.anQ = strArr;
        this.anR = strArr2;
        this.anS = strArr3;
        this.anT = str2;
        this.anU = str3;
        this.anV = str4;
        this.anW = str5;
        this.anX = plusCommonExtras;
    }

    public C1204h(String str, String[] strArr, String[] strArr2, String[] strArr3, String str2, String str3, String str4, PlusCommonExtras plusCommonExtras) {
        this.CK = 1;
        this.DZ = str;
        this.anQ = strArr;
        this.anR = strArr2;
        this.anS = strArr3;
        this.anT = str2;
        this.anU = str3;
        this.anV = str4;
        this.anW = null;
        this.anX = plusCommonExtras;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1204h)) {
            return false;
        }
        C1204h c1204h = (C1204h) obj;
        return this.CK == c1204h.CK && jv.equal(this.DZ, c1204h.DZ) && Arrays.equals(this.anQ, c1204h.anQ) && Arrays.equals(this.anR, c1204h.anR) && Arrays.equals(this.anS, c1204h.anS) && jv.equal(this.anT, c1204h.anT) && jv.equal(this.anU, c1204h.anU) && jv.equal(this.anV, c1204h.anV) && jv.equal(this.anW, c1204h.anW) && jv.equal(this.anX, c1204h.anX);
    }

    public String getAccountName() {
        return this.DZ;
    }

    public int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        return jv.hashCode(Integer.valueOf(this.CK), this.DZ, this.anQ, this.anR, this.anS, this.anT, this.anU, this.anV, this.anW, this.anX);
    }

    public String[] oA() {
        return this.anR;
    }

    public String[] oB() {
        return this.anS;
    }

    public String oC() {
        return this.anT;
    }

    public String oD() {
        return this.anU;
    }

    public String oE() {
        return this.anV;
    }

    public String oF() {
        return this.anW;
    }

    public PlusCommonExtras oG() {
        return this.anX;
    }

    public Bundle oH() {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(PlusCommonExtras.class.getClassLoader());
        this.anX.m3635q(bundle);
        return bundle;
    }

    public String[] oz() {
        return this.anQ;
    }

    public String toString() {
        return jv.m1571h(this).m1570a("versionCode", Integer.valueOf(this.CK)).m1570a("accountName", this.DZ).m1570a("requestedScopes", this.anQ).m1570a("visibleActivities", this.anR).m1570a("requiredFeatures", this.anS).m1570a("packageNameForAuth", this.anT).m1570a("callingPackageName", this.anU).m1570a("applicationName", this.anV).m1570a("extra", this.anX.toString()).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        C0597i.m2057a(this, out, flags);
    }
}
