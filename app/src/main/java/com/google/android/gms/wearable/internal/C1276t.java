package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.C1261c;

/* renamed from: com.google.android.gms.wearable.internal.t */
public class C1276t implements SafeParcelable {
    public static final Creator<C1276t> CREATOR = new C0708u();
    public final C1261c[] axK;
    public final int statusCode;
    public final int versionCode;

    C1276t(int i, int i2, C1261c[] c1261cArr) {
        this.versionCode = i;
        this.statusCode = i2;
        this.axK = c1261cArr;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0708u.m2332a(this, dest, flags);
    }
}
