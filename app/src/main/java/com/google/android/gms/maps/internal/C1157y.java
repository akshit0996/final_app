package com.google.android.gms.maps.internal;

import android.graphics.Point;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.maps.internal.y */
public class C1157y implements SafeParcelable {
    public static final C0549z CREATOR = new C0549z();
    private final Point alK;
    private final int versionCode;

    public C1157y(int i, Point point) {
        this.versionCode = i;
        this.alK = point;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof C1157y)) {
            return false;
        }
        return this.alK.equals(((C1157y) o).alK);
    }

    int getVersionCode() {
        return this.versionCode;
    }

    public int hashCode() {
        return this.alK.hashCode();
    }

    public Point oa() {
        return this.alK;
    }

    public String toString() {
        return this.alK.toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        C0549z.m1979a(this, out, flags);
    }
}
