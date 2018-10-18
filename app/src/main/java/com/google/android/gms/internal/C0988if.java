package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.internal.if */
public class C0988if implements SafeParcelable {
    public static final ig CREATOR = new ig();
    final Bundle Ep;
    final byte[] Eq;
    final int responseCode;
    final int versionCode;

    public C0988if(int i, int i2, Bundle bundle, byte[] bArr) {
        this.versionCode = i;
        this.responseCode = i2;
        this.Ep = bundle;
        this.Eq = bArr;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int flags) {
        ig.m1437a(this, parcel, flags);
    }
}
