package com.google.android.gms.maps.model.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.maps.model.internal.e */
public final class C1163e implements SafeParcelable {
    public static final C0561f CREATOR = new C0561f();
    private final int CK;
    private C1161a amM;

    public C1163e() {
        this.CK = 1;
    }

    C1163e(int i, C1161a c1161a) {
        this.CK = i;
        this.amM = c1161a;
    }

    public int describeContents() {
        return 0;
    }

    int getVersionCode() {
        return this.CK;
    }

    public C1161a oj() {
        return this.amM;
    }

    public void writeToParcel(Parcel out, int flags) {
        C0561f.m1993a(this, out, flags);
    }
}
