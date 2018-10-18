package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.C1261c;

@Deprecated
/* renamed from: com.google.android.gms.wearable.internal.r */
public class C1275r implements SafeParcelable {
    public static final Creator<C1275r> CREATOR = new C0707s();
    public final C1261c axJ;
    public final int statusCode;
    public final int versionCode;

    C1275r(int i, int i2, C1261c c1261c) {
        this.versionCode = i;
        this.statusCode = i2;
        this.axJ = c1261c;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0707s.m2331a(this, dest, flags);
    }
}
