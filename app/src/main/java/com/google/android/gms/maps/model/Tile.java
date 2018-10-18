package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.aa;

public final class Tile implements SafeParcelable {
    public static final C0583u CREATOR = new C0583u();
    private final int CK;
    public final byte[] data;
    public final int height;
    public final int width;

    Tile(int versionCode, int width, int height, byte[] data) {
        this.CK = versionCode;
        this.width = width;
        this.height = height;
        this.data = data;
    }

    public Tile(int width, int height, byte[] data) {
        this(1, width, height, data);
    }

    public int describeContents() {
        return 0;
    }

    int getVersionCode() {
        return this.CK;
    }

    public void writeToParcel(Parcel out, int flags) {
        if (aa.ob()) {
            C0584v.m2021a(this, out, flags);
        } else {
            C0583u.m2020a(this, out, flags);
        }
    }
}
