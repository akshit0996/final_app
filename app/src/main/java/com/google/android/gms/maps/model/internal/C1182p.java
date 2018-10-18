package com.google.android.gms.maps.model.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.maps.model.internal.p */
public final class C1182p implements SafeParcelable {
    public static final C0571q CREATOR = new C0571q();
    private final int CK;
    private C1161a amN;

    public C1182p() {
        this.CK = 1;
    }

    C1182p(int i, C1161a c1161a) {
        this.CK = i;
        this.amN = c1161a;
    }

    public int describeContents() {
        return 0;
    }

    int getVersionCode() {
        return this.CK;
    }

    public C1161a ol() {
        return this.amN;
    }

    public void writeToParcel(Parcel out, int flags) {
        C0571q.m2008a(this, out, flags);
    }
}
