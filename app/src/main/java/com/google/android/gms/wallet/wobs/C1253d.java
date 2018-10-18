package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.la;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.wallet.wobs.d */
public final class C1253d implements SafeParcelable {
    public static final Creator<C1253d> CREATOR = new C0684e();
    private final int CK;
    String awJ;
    String awK;
    ArrayList<C1252b> awL;

    C1253d() {
        this.CK = 1;
        this.awL = la.ie();
    }

    C1253d(int i, String str, String str2, ArrayList<C1252b> arrayList) {
        this.CK = i;
        this.awJ = str;
        this.awK = str2;
        this.awL = arrayList;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.CK;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0684e.m2258a(this, dest, flags);
    }
}
