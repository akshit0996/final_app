package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.wearable.internal.x */
public class C1278x implements SafeParcelable {
    public static final Creator<C1278x> CREATOR = new C0710y();
    public final C1490m axM;
    public final int statusCode;
    public final int versionCode;

    C1278x(int i, int i2, C1490m c1490m) {
        this.versionCode = i;
        this.statusCode = i2;
        this.axM = c1490m;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0710y.m2334a(this, dest, flags);
    }
}
