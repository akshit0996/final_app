package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;

public class StreetViewPanoramaLocation implements SafeParcelable {
    public static final C0581s CREATOR = new C0581s();
    private final int CK;
    public final StreetViewPanoramaLink[] links;
    public final String panoId;
    public final LatLng position;

    StreetViewPanoramaLocation(int versionCode, StreetViewPanoramaLink[] links, LatLng position, String panoId) {
        this.CK = versionCode;
        this.links = links;
        this.position = position;
        this.panoId = panoId;
    }

    public StreetViewPanoramaLocation(StreetViewPanoramaLink[] links, LatLng position, String panoId) {
        this(1, links, position, panoId);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof StreetViewPanoramaLocation)) {
            return false;
        }
        StreetViewPanoramaLocation streetViewPanoramaLocation = (StreetViewPanoramaLocation) o;
        return this.panoId.equals(streetViewPanoramaLocation.panoId) && this.position.equals(streetViewPanoramaLocation.position);
    }

    int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        return jv.hashCode(this.position, this.panoId);
    }

    public String toString() {
        return jv.m1571h(this).m1570a("panoId", this.panoId).m1570a("position", this.position.toString()).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        C0581s.m2018a(this, out, flags);
    }
}
