package com.google.android.gms.maps.model.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.maps.model.internal.c */
public final class C1162c implements SafeParcelable {
    public static final C0560d CREATOR = new C0560d();
    private final int CK;
    private Bundle amK;
    private int type;

    C1162c(int i, int i2, Bundle bundle) {
        this.CK = i;
        this.type = i2;
        this.amK = bundle;
    }

    public int describeContents() {
        return 0;
    }

    public int getType() {
        return this.type;
    }

    public int getVersionCode() {
        return this.CK;
    }

    public Bundle oi() {
        return this.amK;
    }

    public void writeToParcel(Parcel out, int flags) {
        C0560d.m1992a(this, out, flags);
    }
}
