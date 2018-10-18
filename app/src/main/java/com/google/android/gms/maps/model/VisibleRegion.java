package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import com.google.android.gms.maps.internal.aa;

public final class VisibleRegion implements SafeParcelable {
    public static final C0587y CREATOR = new C0587y();
    private final int CK;
    public final LatLng farLeft;
    public final LatLng farRight;
    public final LatLngBounds latLngBounds;
    public final LatLng nearLeft;
    public final LatLng nearRight;

    VisibleRegion(int versionCode, LatLng nearLeft, LatLng nearRight, LatLng farLeft, LatLng farRight, LatLngBounds latLngBounds) {
        this.CK = versionCode;
        this.nearLeft = nearLeft;
        this.nearRight = nearRight;
        this.farLeft = farLeft;
        this.farRight = farRight;
        this.latLngBounds = latLngBounds;
    }

    public VisibleRegion(LatLng nearLeft, LatLng nearRight, LatLng farLeft, LatLng farRight, LatLngBounds latLngBounds) {
        this(1, nearLeft, nearRight, farLeft, farRight, latLngBounds);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof VisibleRegion)) {
            return false;
        }
        VisibleRegion visibleRegion = (VisibleRegion) o;
        return this.nearLeft.equals(visibleRegion.nearLeft) && this.nearRight.equals(visibleRegion.nearRight) && this.farLeft.equals(visibleRegion.farLeft) && this.farRight.equals(visibleRegion.farRight) && this.latLngBounds.equals(visibleRegion.latLngBounds);
    }

    int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        return jv.hashCode(this.nearLeft, this.nearRight, this.farLeft, this.farRight, this.latLngBounds);
    }

    public String toString() {
        return jv.m1571h(this).m1570a("nearLeft", this.nearLeft).m1570a("nearRight", this.nearRight).m1570a("farLeft", this.farLeft).m1570a("farRight", this.farRight).m1570a("latLngBounds", this.latLngBounds).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        if (aa.ob()) {
            C0588z.m2026a(this, out, flags);
        } else {
            C0587y.m2024a(this, out, flags);
        }
    }
}
