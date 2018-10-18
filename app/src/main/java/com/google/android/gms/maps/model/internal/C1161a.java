package com.google.android.gms.maps.model.internal;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.maps.model.internal.a */
public final class C1161a implements SafeParcelable {
    public static final C0559b CREATOR = new C0559b();
    private final int CK;
    private byte amJ;
    private Bundle amK;
    private Bitmap amL;

    C1161a(int i, byte b, Bundle bundle, Bitmap bitmap) {
        this.CK = i;
        this.amJ = b;
        this.amK = bundle;
        this.amL = bitmap;
    }

    public int describeContents() {
        return 0;
    }

    public Bitmap getBitmap() {
        return this.amL;
    }

    public int getVersionCode() {
        return this.CK;
    }

    public byte oh() {
        return this.amJ;
    }

    public Bundle oi() {
        return this.amK;
    }

    public void writeToParcel(Parcel out, int flags) {
        C0559b.m1991a(this, out, flags);
    }
}
