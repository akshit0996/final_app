package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.wearable.internal.p */
public class C1274p implements SafeParcelable {
    public static final Creator<C1274p> CREATOR = new C0706q();
    public final int axI;
    public final int statusCode;
    public final int versionCode;

    C1274p(int i, int i2, int i3) {
        this.versionCode = i;
        this.statusCode = i2;
        this.axI = i3;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0706q.m2330a(this, dest, flags);
    }
}
