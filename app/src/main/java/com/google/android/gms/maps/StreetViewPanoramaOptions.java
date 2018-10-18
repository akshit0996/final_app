package com.google.android.gms.maps;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.C0525a;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

public final class StreetViewPanoramaOptions implements SafeParcelable {
    public static final C0524c CREATOR = new C0524c();
    private final int CK;
    private Boolean akG;
    private Boolean akM;
    private StreetViewPanoramaCamera alr;
    private String als;
    private LatLng alt;
    private Integer alu;
    private Boolean alv;
    private Boolean alw;
    private Boolean alx;

    public StreetViewPanoramaOptions() {
        this.alv = Boolean.valueOf(true);
        this.akM = Boolean.valueOf(true);
        this.alw = Boolean.valueOf(true);
        this.alx = Boolean.valueOf(true);
        this.CK = 1;
    }

    StreetViewPanoramaOptions(int versionCode, StreetViewPanoramaCamera camera, String panoId, LatLng position, Integer radius, byte userNavigationEnabled, byte zoomGesturesEnabled, byte panningGesturesEnabled, byte streetNamesEnabled, byte useViewLifecycleInFragment) {
        this.alv = Boolean.valueOf(true);
        this.akM = Boolean.valueOf(true);
        this.alw = Boolean.valueOf(true);
        this.alx = Boolean.valueOf(true);
        this.CK = versionCode;
        this.alr = camera;
        this.alt = position;
        this.alu = radius;
        this.als = panoId;
        this.alv = C0525a.m1949a(userNavigationEnabled);
        this.akM = C0525a.m1949a(zoomGesturesEnabled);
        this.alw = C0525a.m1949a(panningGesturesEnabled);
        this.alx = C0525a.m1949a(streetNamesEnabled);
        this.akG = C0525a.m1949a(useViewLifecycleInFragment);
    }

    public int describeContents() {
        return 0;
    }

    public Boolean getPanningGesturesEnabled() {
        return this.alw;
    }

    public String getPanoramaId() {
        return this.als;
    }

    public LatLng getPosition() {
        return this.alt;
    }

    public Integer getRadius() {
        return this.alu;
    }

    public Boolean getStreetNamesEnabled() {
        return this.alx;
    }

    public StreetViewPanoramaCamera getStreetViewPanoramaCamera() {
        return this.alr;
    }

    public Boolean getUseViewLifecycleInFragment() {
        return this.akG;
    }

    public Boolean getUserNavigationEnabled() {
        return this.alv;
    }

    int getVersionCode() {
        return this.CK;
    }

    public Boolean getZoomGesturesEnabled() {
        return this.akM;
    }

    byte nE() {
        return C0525a.m1950c(this.akG);
    }

    byte nI() {
        return C0525a.m1950c(this.akM);
    }

    byte nS() {
        return C0525a.m1950c(this.alv);
    }

    byte nT() {
        return C0525a.m1950c(this.alw);
    }

    byte nU() {
        return C0525a.m1950c(this.alx);
    }

    public StreetViewPanoramaOptions panningGesturesEnabled(boolean enabled) {
        this.alw = Boolean.valueOf(enabled);
        return this;
    }

    public StreetViewPanoramaOptions panoramaCamera(StreetViewPanoramaCamera camera) {
        this.alr = camera;
        return this;
    }

    public StreetViewPanoramaOptions panoramaId(String panoId) {
        this.als = panoId;
        return this;
    }

    public StreetViewPanoramaOptions position(LatLng position) {
        this.alt = position;
        return this;
    }

    public StreetViewPanoramaOptions position(LatLng position, Integer radius) {
        this.alt = position;
        this.alu = radius;
        return this;
    }

    public StreetViewPanoramaOptions streetNamesEnabled(boolean enabled) {
        this.alx = Boolean.valueOf(enabled);
        return this;
    }

    public StreetViewPanoramaOptions useViewLifecycleInFragment(boolean useViewLifecycleInFragment) {
        this.akG = Boolean.valueOf(useViewLifecycleInFragment);
        return this;
    }

    public StreetViewPanoramaOptions userNavigationEnabled(boolean enabled) {
        this.alv = Boolean.valueOf(enabled);
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        C0524c.m1948a(this, out, flags);
    }

    public StreetViewPanoramaOptions zoomGesturesEnabled(boolean enabled) {
        this.akM = Boolean.valueOf(enabled);
        return this;
    }
}
