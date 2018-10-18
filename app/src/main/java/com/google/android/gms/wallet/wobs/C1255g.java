package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.wallet.wobs.g */
public final class C1255g implements SafeParcelable {
    public static final Creator<C1255g> CREATOR = new C0685h();
    private final int CK;
    int awN;
    String awO;
    double awP;
    String awQ;
    long awR;
    int awS;

    C1255g() {
        this.CK = 1;
        this.awS = -1;
        this.awN = -1;
        this.awP = -1.0d;
    }

    C1255g(int i, int i2, String str, double d, String str2, long j, int i3) {
        this.CK = i;
        this.awN = i2;
        this.awO = str;
        this.awP = d;
        this.awQ = str2;
        this.awR = j;
        this.awS = i3;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.CK;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0685h.m2259a(this, dest, flags);
    }
}
