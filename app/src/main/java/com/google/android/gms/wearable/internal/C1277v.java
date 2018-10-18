package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

/* renamed from: com.google.android.gms.wearable.internal.v */
public class C1277v implements SafeParcelable {
    public static final Creator<C1277v> CREATOR = new C0709w();
    public final List<al> axL;
    public final int statusCode;
    public final int versionCode;

    C1277v(int i, int i2, List<al> list) {
        this.versionCode = i;
        this.statusCode = i2;
        this.axL = list;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0709w.m2333a(this, dest, flags);
    }
}
