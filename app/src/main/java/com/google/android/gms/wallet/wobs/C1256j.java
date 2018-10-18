package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.wallet.wobs.j */
public final class C1256j implements SafeParcelable {
    public static final Creator<C1256j> CREATOR = new C0687k();
    private final int CK;
    String awT;
    String tU;

    C1256j() {
        this.CK = 1;
    }

    C1256j(int i, String str, String str2) {
        this.CK = i;
        this.awT = str;
        this.tU = str2;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.CK;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0687k.m2261a(this, dest, flags);
    }
}
