package com.google.android.gms.maps;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.util.AttributeSet;
import com.google.android.gms.C0099R;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.C0525a;
import com.google.android.gms.maps.internal.aa;
import com.google.android.gms.maps.model.CameraPosition;

public final class GoogleMapOptions implements SafeParcelable {
    public static final C0522a CREATOR = new C0522a();
    private final int CK;
    private Boolean akF;
    private Boolean akG;
    private int akH;
    private CameraPosition akI;
    private Boolean akJ;
    private Boolean akK;
    private Boolean akL;
    private Boolean akM;
    private Boolean akN;
    private Boolean akO;
    private Boolean akP;
    private Boolean akQ;

    public GoogleMapOptions() {
        this.akH = -1;
        this.CK = 1;
    }

    GoogleMapOptions(int versionCode, byte zOrderOnTop, byte useViewLifecycleInFragment, int mapType, CameraPosition camera, byte zoomControlsEnabled, byte compassEnabled, byte scrollGesturesEnabled, byte zoomGesturesEnabled, byte tiltGesturesEnabled, byte rotateGesturesEnabled, byte liteMode, byte mapToolbarEnabled) {
        this.akH = -1;
        this.CK = versionCode;
        this.akF = C0525a.m1949a(zOrderOnTop);
        this.akG = C0525a.m1949a(useViewLifecycleInFragment);
        this.akH = mapType;
        this.akI = camera;
        this.akJ = C0525a.m1949a(zoomControlsEnabled);
        this.akK = C0525a.m1949a(compassEnabled);
        this.akL = C0525a.m1949a(scrollGesturesEnabled);
        this.akM = C0525a.m1949a(zoomGesturesEnabled);
        this.akN = C0525a.m1949a(tiltGesturesEnabled);
        this.akO = C0525a.m1949a(rotateGesturesEnabled);
        this.akP = C0525a.m1949a(liteMode);
        this.akQ = C0525a.m1949a(mapToolbarEnabled);
    }

    public static GoogleMapOptions createFromAttributes(Context context, AttributeSet attrs) {
        if (attrs == null) {
            return null;
        }
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attrs, C0099R.styleable.MapAttrs);
        GoogleMapOptions googleMapOptions = new GoogleMapOptions();
        if (obtainAttributes.hasValue(C0099R.styleable.MapAttrs_mapType)) {
            googleMapOptions.mapType(obtainAttributes.getInt(C0099R.styleable.MapAttrs_mapType, -1));
        }
        if (obtainAttributes.hasValue(C0099R.styleable.MapAttrs_zOrderOnTop)) {
            googleMapOptions.zOrderOnTop(obtainAttributes.getBoolean(C0099R.styleable.MapAttrs_zOrderOnTop, false));
        }
        if (obtainAttributes.hasValue(C0099R.styleable.MapAttrs_useViewLifecycle)) {
            googleMapOptions.useViewLifecycleInFragment(obtainAttributes.getBoolean(C0099R.styleable.MapAttrs_useViewLifecycle, false));
        }
        if (obtainAttributes.hasValue(C0099R.styleable.MapAttrs_uiCompass)) {
            googleMapOptions.compassEnabled(obtainAttributes.getBoolean(C0099R.styleable.MapAttrs_uiCompass, true));
        }
        if (obtainAttributes.hasValue(C0099R.styleable.MapAttrs_uiRotateGestures)) {
            googleMapOptions.rotateGesturesEnabled(obtainAttributes.getBoolean(C0099R.styleable.MapAttrs_uiRotateGestures, true));
        }
        if (obtainAttributes.hasValue(C0099R.styleable.MapAttrs_uiScrollGestures)) {
            googleMapOptions.scrollGesturesEnabled(obtainAttributes.getBoolean(C0099R.styleable.MapAttrs_uiScrollGestures, true));
        }
        if (obtainAttributes.hasValue(C0099R.styleable.MapAttrs_uiTiltGestures)) {
            googleMapOptions.tiltGesturesEnabled(obtainAttributes.getBoolean(C0099R.styleable.MapAttrs_uiTiltGestures, true));
        }
        if (obtainAttributes.hasValue(C0099R.styleable.MapAttrs_uiZoomGestures)) {
            googleMapOptions.zoomGesturesEnabled(obtainAttributes.getBoolean(C0099R.styleable.MapAttrs_uiZoomGestures, true));
        }
        if (obtainAttributes.hasValue(C0099R.styleable.MapAttrs_uiZoomControls)) {
            googleMapOptions.zoomControlsEnabled(obtainAttributes.getBoolean(C0099R.styleable.MapAttrs_uiZoomControls, true));
        }
        if (obtainAttributes.hasValue(C0099R.styleable.MapAttrs_liteMode)) {
            googleMapOptions.liteMode(obtainAttributes.getBoolean(C0099R.styleable.MapAttrs_liteMode, false));
        }
        if (obtainAttributes.hasValue(C0099R.styleable.MapAttrs_uiMapToolbar)) {
            googleMapOptions.mapToolbarEnabled(obtainAttributes.getBoolean(C0099R.styleable.MapAttrs_uiMapToolbar, true));
        }
        googleMapOptions.camera(CameraPosition.createFromAttributes(context, attrs));
        obtainAttributes.recycle();
        return googleMapOptions;
    }

    public GoogleMapOptions camera(CameraPosition camera) {
        this.akI = camera;
        return this;
    }

    public GoogleMapOptions compassEnabled(boolean enabled) {
        this.akK = Boolean.valueOf(enabled);
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public CameraPosition getCamera() {
        return this.akI;
    }

    public Boolean getCompassEnabled() {
        return this.akK;
    }

    public Boolean getLiteMode() {
        return this.akP;
    }

    public Boolean getMapToolbarEnabled() {
        return this.akQ;
    }

    public int getMapType() {
        return this.akH;
    }

    public Boolean getRotateGesturesEnabled() {
        return this.akO;
    }

    public Boolean getScrollGesturesEnabled() {
        return this.akL;
    }

    public Boolean getTiltGesturesEnabled() {
        return this.akN;
    }

    public Boolean getUseViewLifecycleInFragment() {
        return this.akG;
    }

    int getVersionCode() {
        return this.CK;
    }

    public Boolean getZOrderOnTop() {
        return this.akF;
    }

    public Boolean getZoomControlsEnabled() {
        return this.akJ;
    }

    public Boolean getZoomGesturesEnabled() {
        return this.akM;
    }

    public GoogleMapOptions liteMode(boolean enabled) {
        this.akP = Boolean.valueOf(enabled);
        return this;
    }

    public GoogleMapOptions mapToolbarEnabled(boolean enabled) {
        this.akQ = Boolean.valueOf(enabled);
        return this;
    }

    public GoogleMapOptions mapType(int mapType) {
        this.akH = mapType;
        return this;
    }

    byte nD() {
        return C0525a.m1950c(this.akF);
    }

    byte nE() {
        return C0525a.m1950c(this.akG);
    }

    byte nF() {
        return C0525a.m1950c(this.akJ);
    }

    byte nG() {
        return C0525a.m1950c(this.akK);
    }

    byte nH() {
        return C0525a.m1950c(this.akL);
    }

    byte nI() {
        return C0525a.m1950c(this.akM);
    }

    byte nJ() {
        return C0525a.m1950c(this.akN);
    }

    byte nK() {
        return C0525a.m1950c(this.akO);
    }

    byte nL() {
        return C0525a.m1950c(this.akP);
    }

    byte nM() {
        return C0525a.m1950c(this.akQ);
    }

    public GoogleMapOptions rotateGesturesEnabled(boolean enabled) {
        this.akO = Boolean.valueOf(enabled);
        return this;
    }

    public GoogleMapOptions scrollGesturesEnabled(boolean enabled) {
        this.akL = Boolean.valueOf(enabled);
        return this;
    }

    public GoogleMapOptions tiltGesturesEnabled(boolean enabled) {
        this.akN = Boolean.valueOf(enabled);
        return this;
    }

    public GoogleMapOptions useViewLifecycleInFragment(boolean useViewLifecycleInFragment) {
        this.akG = Boolean.valueOf(useViewLifecycleInFragment);
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        if (aa.ob()) {
            C0523b.m1947a(this, out, flags);
        } else {
            C0522a.m1946a(this, out, flags);
        }
    }

    public GoogleMapOptions zOrderOnTop(boolean zOrderOnTop) {
        this.akF = Boolean.valueOf(zOrderOnTop);
        return this;
    }

    public GoogleMapOptions zoomControlsEnabled(boolean enabled) {
        this.akJ = Boolean.valueOf(enabled);
        return this;
    }

    public GoogleMapOptions zoomGesturesEnabled(boolean enabled) {
        this.akM = Boolean.valueOf(enabled);
        return this;
    }
}
