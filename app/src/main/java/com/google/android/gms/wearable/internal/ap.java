package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ap implements SafeParcelable {
    public static final Creator<ap> CREATOR = new aq();
    public final C1490m axM;
    public final int statusCode;
    public final int versionCode;

    ap(int i, int i2, C1490m c1490m) {
        this.versionCode = i;
        this.statusCode = i2;
        this.axM = c1490m;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        aq.m2323a(this, dest, flags);
    }
}
