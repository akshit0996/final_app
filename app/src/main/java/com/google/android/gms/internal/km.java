package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.kr.C0485b;

public class km implements SafeParcelable {
    public static final kn CREATOR = new kn();
    private final int CK;
    private final ko NF;

    km(int i, ko koVar) {
        this.CK = i;
        this.NF = koVar;
    }

    private km(ko koVar) {
        this.CK = 1;
        this.NF = koVar;
    }

    /* renamed from: a */
    public static km m3373a(C0485b<?, ?> c0485b) {
        if (c0485b instanceof ko) {
            return new km((ko) c0485b);
        }
        throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
    }

    public int describeContents() {
        kn knVar = CREATOR;
        return 0;
    }

    int getVersionCode() {
        return this.CK;
    }

    ko hF() {
        return this.NF;
    }

    public C0485b<?, ?> hG() {
        if (this.NF != null) {
            return this.NF;
        }
        throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
    }

    public void writeToParcel(Parcel out, int flags) {
        kn knVar = CREATOR;
        kn.m1602a(this, out, flags);
    }
}
