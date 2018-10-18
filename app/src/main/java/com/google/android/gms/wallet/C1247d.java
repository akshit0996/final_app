package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.wallet.d */
public final class C1247d implements SafeParcelable {
    public static final Creator<C1247d> CREATOR = new C0662e();
    private final int CK;
    LoyaltyWalletObject auJ;
    OfferWalletObject auK;

    C1247d() {
        this.CK = 2;
    }

    C1247d(int i, LoyaltyWalletObject loyaltyWalletObject, OfferWalletObject offerWalletObject) {
        this.CK = i;
        this.auJ = loyaltyWalletObject;
        this.auK = offerWalletObject;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.CK;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0662e.m2222a(this, dest, flags);
    }
}
