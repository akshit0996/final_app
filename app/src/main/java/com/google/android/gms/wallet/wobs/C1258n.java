package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.wallet.wobs.n */
public final class C1258n implements SafeParcelable {
    public static final Creator<C1258n> CREATOR = new C0689o();
    private final int CK;
    String awW;
    String description;

    C1258n() {
        this.CK = 1;
    }

    C1258n(int i, String str, String str2) {
        this.CK = i;
        this.awW = str;
        this.description = str2;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.CK;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0689o.m2263a(this, dest, flags);
    }
}
