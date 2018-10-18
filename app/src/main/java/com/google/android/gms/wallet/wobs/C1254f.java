package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.wallet.wobs.f */
public final class C1254f implements SafeParcelable {
    public static final Creator<C1254f> CREATOR = new C0686i();
    private final int CK;
    C1257l avm;
    C1255g awM;
    String label;
    String type;

    C1254f() {
        this.CK = 1;
    }

    C1254f(int i, String str, C1255g c1255g, String str2, C1257l c1257l) {
        this.CK = i;
        this.label = str;
        this.awM = c1255g;
        this.type = str2;
        this.avm = c1257l;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.CK;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0686i.m2260a(this, dest, flags);
    }
}
