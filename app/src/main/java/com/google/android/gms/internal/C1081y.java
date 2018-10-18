package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@ey
/* renamed from: com.google.android.gms.internal.y */
public final class C1081y implements SafeParcelable {
    public static final C0513z CREATOR = new C0513z();
    public final boolean mi;
    public final boolean ms;
    public final int versionCode;

    C1081y(int i, boolean z, boolean z2) {
        this.versionCode = i;
        this.mi = z;
        this.ms = z2;
    }

    public C1081y(boolean z, boolean z2) {
        this.versionCode = 1;
        this.mi = z;
        this.ms = z2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        C0513z.m1929a(this, out, flags);
    }
}
