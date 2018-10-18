package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.wearable.internal.z */
public class C1279z implements SafeParcelable {
    public static final Creator<C1279z> CREATOR = new aa();
    public final ParcelFileDescriptor axN;
    public final int statusCode;
    public final int versionCode;

    C1279z(int i, int i2, ParcelFileDescriptor parcelFileDescriptor) {
        this.versionCode = i;
        this.statusCode = i2;
        this.axN = parcelFileDescriptor;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        aa.m2276a(this, dest, flags | 1);
    }
}
