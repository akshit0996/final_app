package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@ey
/* renamed from: com.google.android.gms.internal.do */
public final class C0934do implements SafeParcelable {
    public static final dn CREATOR = new dn();
    public final String mimeType;
    public final String packageName;
    public final String rG;
    public final String rH;
    public final String rI;
    public final String rJ;
    public final String rK;
    public final int versionCode;

    public C0934do(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.versionCode = i;
        this.rG = str;
        this.rH = str2;
        this.mimeType = str3;
        this.packageName = str4;
        this.rI = str5;
        this.rJ = str6;
        this.rK = str7;
    }

    public C0934do(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this(1, str, str2, str3, str4, str5, str6, str7);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        dn.m1137a(this, out, flags);
    }
}
