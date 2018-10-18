package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.C0272d.C0871a;
import com.google.android.gms.internal.jx;
import com.google.android.gms.maps.internal.aa;

public final class GroundOverlayOptions implements SafeParcelable {
    public static final C0554e CREATOR = new C0554e();
    public static final float NO_DIMENSION = -1.0f;
    private final int CK;
    private float alQ;
    private float alX;
    private boolean alY;
    private BitmapDescriptor ama;
    private LatLng amb;
    private float amc;
    private float amd;
    private LatLngBounds ame;
    private float amf;
    private float amg;
    private float amh;

    public GroundOverlayOptions() {
        this.alY = true;
        this.amf = 0.0f;
        this.amg = 0.5f;
        this.amh = 0.5f;
        this.CK = 1;
    }

    GroundOverlayOptions(int versionCode, IBinder wrappedImage, LatLng location, float width, float height, LatLngBounds bounds, float bearing, float zIndex, boolean visible, float transparency, float anchorU, float anchorV) {
        this.alY = true;
        this.amf = 0.0f;
        this.amg = 0.5f;
        this.amh = 0.5f;
        this.CK = versionCode;
        this.ama = new BitmapDescriptor(C0871a.ap(wrappedImage));
        this.amb = location;
        this.amc = width;
        this.amd = height;
        this.ame = bounds;
        this.alQ = bearing;
        this.alX = zIndex;
        this.alY = visible;
        this.amf = transparency;
        this.amg = anchorU;
        this.amh = anchorV;
    }

    /* renamed from: a */
    private GroundOverlayOptions m3594a(LatLng latLng, float f, float f2) {
        this.amb = latLng;
        this.amc = f;
        this.amd = f2;
        return this;
    }

    public GroundOverlayOptions anchor(float u, float v) {
        this.amg = u;
        this.amh = v;
        return this;
    }

    public GroundOverlayOptions bearing(float bearing) {
        this.alQ = ((bearing % 360.0f) + 360.0f) % 360.0f;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public float getAnchorU() {
        return this.amg;
    }

    public float getAnchorV() {
        return this.amh;
    }

    public float getBearing() {
        return this.alQ;
    }

    public LatLngBounds getBounds() {
        return this.ame;
    }

    public float getHeight() {
        return this.amd;
    }

    public BitmapDescriptor getImage() {
        return this.ama;
    }

    public LatLng getLocation() {
        return this.amb;
    }

    public float getTransparency() {
        return this.amf;
    }

    int getVersionCode() {
        return this.CK;
    }

    public float getWidth() {
        return this.amc;
    }

    public float getZIndex() {
        return this.alX;
    }

    public GroundOverlayOptions image(BitmapDescriptor image) {
        this.ama = image;
        return this;
    }

    public boolean isVisible() {
        return this.alY;
    }

    IBinder od() {
        return this.ama.nA().asBinder();
    }

    public GroundOverlayOptions position(LatLng location, float width) {
        boolean z = true;
        jx.m1576a(this.ame == null, "Position has already been set using positionFromBounds");
        jx.m1580b(location != null, (Object) "Location must be specified");
        if (width < 0.0f) {
            z = false;
        }
        jx.m1580b(z, (Object) "Width must be non-negative");
        return m3594a(location, width, -1.0f);
    }

    public GroundOverlayOptions position(LatLng location, float width, float height) {
        boolean z = true;
        jx.m1576a(this.ame == null, "Position has already been set using positionFromBounds");
        jx.m1580b(location != null, (Object) "Location must be specified");
        jx.m1580b(width >= 0.0f, (Object) "Width must be non-negative");
        if (height < 0.0f) {
            z = false;
        }
        jx.m1580b(z, (Object) "Height must be non-negative");
        return m3594a(location, width, height);
    }

    public GroundOverlayOptions positionFromBounds(LatLngBounds bounds) {
        jx.m1576a(this.amb == null, "Position has already been set using position: " + this.amb);
        this.ame = bounds;
        return this;
    }

    public GroundOverlayOptions transparency(float transparency) {
        boolean z = transparency >= 0.0f && transparency <= 1.0f;
        jx.m1580b(z, (Object) "Transparency must be in the range [0..1]");
        this.amf = transparency;
        return this;
    }

    public GroundOverlayOptions visible(boolean visible) {
        this.alY = visible;
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        if (aa.ob()) {
            C0555f.m1987a(this, out, flags);
        } else {
            C0554e.m1986a(this, out, flags);
        }
    }

    public GroundOverlayOptions zIndex(float zIndex) {
        this.alX = zIndex;
        return this;
    }
}
