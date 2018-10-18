package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;
import com.google.android.gms.maps.internal.aa;

public final class LatLngBounds implements SafeParcelable {
    public static final C0556g CREATOR = new C0556g();
    private final int CK;
    public final LatLng northeast;
    public final LatLng southwest;

    public static final class Builder {
        private double amk = Double.POSITIVE_INFINITY;
        private double aml = Double.NEGATIVE_INFINITY;
        private double amm = Double.NaN;
        private double amn = Double.NaN;

        /* renamed from: d */
        private boolean m1981d(double d) {
            boolean z = false;
            if (this.amm <= this.amn) {
                return this.amm <= d && d <= this.amn;
            } else {
                if (this.amm <= d || d <= this.amn) {
                    z = true;
                }
                return z;
            }
        }

        public LatLngBounds build() {
            jx.m1576a(!Double.isNaN(this.amm), "no included points");
            return new LatLngBounds(new LatLng(this.amk, this.amm), new LatLng(this.aml, this.amn));
        }

        public Builder include(LatLng point) {
            this.amk = Math.min(this.amk, point.latitude);
            this.aml = Math.max(this.aml, point.latitude);
            double d = point.longitude;
            if (Double.isNaN(this.amm)) {
                this.amm = d;
                this.amn = d;
            } else if (!m1981d(d)) {
                if (LatLngBounds.m3595b(this.amm, d) < LatLngBounds.m3596c(this.amn, d)) {
                    this.amm = d;
                } else {
                    this.amn = d;
                }
            }
            return this;
        }
    }

    LatLngBounds(int versionCode, LatLng southwest, LatLng northeast) {
        jx.m1578b((Object) southwest, (Object) "null southwest");
        jx.m1578b((Object) northeast, (Object) "null northeast");
        jx.m1581b(northeast.latitude >= southwest.latitude, "southern latitude exceeds northern latitude (%s > %s)", Double.valueOf(southwest.latitude), Double.valueOf(northeast.latitude));
        this.CK = versionCode;
        this.southwest = southwest;
        this.northeast = northeast;
    }

    public LatLngBounds(LatLng southwest, LatLng northeast) {
        this(1, southwest, northeast);
    }

    /* renamed from: b */
    private static double m3595b(double d, double d2) {
        return ((d - d2) + 360.0d) % 360.0d;
    }

    public static Builder builder() {
        return new Builder();
    }

    /* renamed from: c */
    private static double m3596c(double d, double d2) {
        return ((d2 - d) + 360.0d) % 360.0d;
    }

    /* renamed from: c */
    private boolean m3597c(double d) {
        return this.southwest.latitude <= d && d <= this.northeast.latitude;
    }

    /* renamed from: d */
    private boolean m3599d(double d) {
        boolean z = false;
        if (this.southwest.longitude <= this.northeast.longitude) {
            return this.southwest.longitude <= d && d <= this.northeast.longitude;
        } else {
            if (this.southwest.longitude <= d || d <= this.northeast.longitude) {
                z = true;
            }
            return z;
        }
    }

    public boolean contains(LatLng point) {
        return m3597c(point.latitude) && m3599d(point.longitude);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LatLngBounds)) {
            return false;
        }
        LatLngBounds latLngBounds = (LatLngBounds) o;
        return this.southwest.equals(latLngBounds.southwest) && this.northeast.equals(latLngBounds.northeast);
    }

    public LatLng getCenter() {
        double d = (this.southwest.latitude + this.northeast.latitude) / 2.0d;
        double d2 = this.northeast.longitude;
        double d3 = this.southwest.longitude;
        return new LatLng(d, d3 <= d2 ? (d2 + d3) / 2.0d : ((d2 + 360.0d) + d3) / 2.0d);
    }

    int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        return jv.hashCode(this.southwest, this.northeast);
    }

    public LatLngBounds including(LatLng point) {
        double min = Math.min(this.southwest.latitude, point.latitude);
        double max = Math.max(this.northeast.latitude, point.latitude);
        double d = this.northeast.longitude;
        double d2 = this.southwest.longitude;
        double d3 = point.longitude;
        if (m3599d(d3)) {
            d3 = d2;
            d2 = d;
        } else if (m3595b(d2, d3) < m3596c(d, d3)) {
            d2 = d;
        } else {
            double d4 = d2;
            d2 = d3;
            d3 = d4;
        }
        return new LatLngBounds(new LatLng(min, d3), new LatLng(max, d2));
    }

    public String toString() {
        return jv.m1571h(this).m1570a("southwest", this.southwest).m1570a("northeast", this.northeast).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        if (aa.ob()) {
            C0557h.m1989a(this, out, flags);
        } else {
            C0556g.m1988a(this, out, flags);
        }
    }
}
