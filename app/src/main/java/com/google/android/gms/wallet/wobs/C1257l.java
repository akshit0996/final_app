package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.wallet.wobs.l */
public final class C1257l implements SafeParcelable {
    public static final Creator<C1257l> CREATOR = new C0688m();
    private final int CK;
    long awU;
    long awV;

    C1257l() {
        this.CK = 1;
    }

    C1257l(int i, long j, long j2) {
        this.CK = i;
        this.awU = j;
        this.awV = j2;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.CK;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0688m.m2262a(this, dest, flags);
    }
}
