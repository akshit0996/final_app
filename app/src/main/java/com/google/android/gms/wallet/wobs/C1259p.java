package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.wallet.wobs.p */
public final class C1259p implements SafeParcelable {
    public static final Creator<C1259p> CREATOR = new C0690q();
    private final int CK;
    String awT;
    C1257l awX;
    C1258n awY;
    C1258n awZ;
    String tU;

    C1259p() {
        this.CK = 1;
    }

    C1259p(int i, String str, String str2, C1257l c1257l, C1258n c1258n, C1258n c1258n2) {
        this.CK = i;
        this.awT = str;
        this.tU = str2;
        this.awX = c1257l;
        this.awY = c1258n;
        this.awZ = c1258n2;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.CK;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0690q.m2264a(this, dest, flags);
    }
}
