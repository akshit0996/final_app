package com.google.android.gms.maps;

import android.graphics.Bitmap;
import android.location.Location;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.C0272d;
import com.google.android.gms.dynamic.C1332e;
import com.google.android.gms.internal.jx;
import com.google.android.gms.maps.LocationSource.OnLocationChangedListener;
import com.google.android.gms.maps.internal.C0526b.C1116a;
import com.google.android.gms.maps.internal.C0528d.C1120a;
import com.google.android.gms.maps.internal.C0530f.C1124a;
import com.google.android.gms.maps.internal.C0531g.C1126a;
import com.google.android.gms.maps.internal.C0532h.C1128a;
import com.google.android.gms.maps.internal.C0533i;
import com.google.android.gms.maps.internal.C0534j.C1132a;
import com.google.android.gms.maps.internal.C0535k.C1134a;
import com.google.android.gms.maps.internal.C0536l.C1136a;
import com.google.android.gms.maps.internal.C0538n.C1140a;
import com.google.android.gms.maps.internal.C0539o.C1142a;
import com.google.android.gms.maps.internal.C0540p.C1144a;
import com.google.android.gms.maps.internal.C0541q.C1146a;
import com.google.android.gms.maps.internal.C0546v.C1156a;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.ILocationSourceDelegate.C1100a;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.IndoorBuilding;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.TileOverlay;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.android.gms.maps.model.internal.C0564i;
import com.google.android.gms.maps.model.internal.C0565j;
import com.google.android.gms.maps.model.internal.C0567l;
import com.google.android.gms.maps.model.internal.C0569n;

public final class GoogleMap {
    public static final int MAP_TYPE_HYBRID = 4;
    public static final int MAP_TYPE_NONE = 0;
    public static final int MAP_TYPE_NORMAL = 1;
    public static final int MAP_TYPE_SATELLITE = 2;
    public static final int MAP_TYPE_TERRAIN = 3;
    private final IGoogleMapDelegate akm;
    private UiSettings akn;

    public interface CancelableCallback {
        void onCancel();

        void onFinish();
    }

    public interface InfoWindowAdapter {
        View getInfoContents(Marker marker);

        View getInfoWindow(Marker marker);
    }

    public interface OnCameraChangeListener {
        void onCameraChange(CameraPosition cameraPosition);
    }

    public interface OnIndoorStateChangeListener {
        void onIndoorBuildingFocused();

        void onIndoorLevelActivated(IndoorBuilding indoorBuilding);
    }

    public interface OnInfoWindowClickListener {
        void onInfoWindowClick(Marker marker);
    }

    public interface OnMapClickListener {
        void onMapClick(LatLng latLng);
    }

    public interface OnMapLoadedCallback {
        void onMapLoaded();
    }

    public interface OnMapLongClickListener {
        void onMapLongClick(LatLng latLng);
    }

    public interface OnMarkerClickListener {
        boolean onMarkerClick(Marker marker);
    }

    public interface OnMarkerDragListener {
        void onMarkerDrag(Marker marker);

        void onMarkerDragEnd(Marker marker);

        void onMarkerDragStart(Marker marker);
    }

    public interface OnMyLocationButtonClickListener {
        boolean onMyLocationButtonClick();
    }

    @Deprecated
    public interface OnMyLocationChangeListener {
        void onMyLocationChange(Location location);
    }

    public interface SnapshotReadyCallback {
        void onSnapshotReady(Bitmap bitmap);
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap$a */
    private static final class C1450a extends C1116a {
        private final CancelableCallback akE;

        C1450a(CancelableCallback cancelableCallback) {
            this.akE = cancelableCallback;
        }

        public void onCancel() {
            this.akE.onCancel();
        }

        public void onFinish() {
            this.akE.onFinish();
        }
    }

    protected GoogleMap(IGoogleMapDelegate map) {
        this.akm = (IGoogleMapDelegate) jx.m1582i(map);
    }

    public final Circle addCircle(CircleOptions options) {
        try {
            return new Circle(this.akm.addCircle(options));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final GroundOverlay addGroundOverlay(GroundOverlayOptions options) {
        try {
            C0564i addGroundOverlay = this.akm.addGroundOverlay(options);
            return addGroundOverlay != null ? new GroundOverlay(addGroundOverlay) : null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Marker addMarker(MarkerOptions options) {
        try {
            C0567l addMarker = this.akm.addMarker(options);
            return addMarker != null ? new Marker(addMarker) : null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Polygon addPolygon(PolygonOptions options) {
        try {
            return new Polygon(this.akm.addPolygon(options));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Polyline addPolyline(PolylineOptions options) {
        try {
            return new Polyline(this.akm.addPolyline(options));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final TileOverlay addTileOverlay(TileOverlayOptions options) {
        try {
            C0569n addTileOverlay = this.akm.addTileOverlay(options);
            return addTileOverlay != null ? new TileOverlay(addTileOverlay) : null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void animateCamera(CameraUpdate update) {
        try {
            this.akm.animateCamera(update.nA());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void animateCamera(CameraUpdate update, int durationMs, CancelableCallback callback) {
        try {
            this.akm.animateCameraWithDurationAndCallback(update.nA(), durationMs, callback == null ? null : new C1450a(callback));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void animateCamera(CameraUpdate update, CancelableCallback callback) {
        try {
            this.akm.animateCameraWithCallback(update.nA(), callback == null ? null : new C1450a(callback));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void clear() {
        try {
            this.akm.clear();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final CameraPosition getCameraPosition() {
        try {
            return this.akm.getCameraPosition();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public IndoorBuilding getFocusedBuilding() {
        try {
            C0565j focusedBuilding = this.akm.getFocusedBuilding();
            return focusedBuilding != null ? new IndoorBuilding(focusedBuilding) : null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final int getMapType() {
        try {
            return this.akm.getMapType();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final float getMaxZoomLevel() {
        try {
            return this.akm.getMaxZoomLevel();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final float getMinZoomLevel() {
        try {
            return this.akm.getMinZoomLevel();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    @Deprecated
    public final Location getMyLocation() {
        try {
            return this.akm.getMyLocation();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Projection getProjection() {
        try {
            return new Projection(this.akm.getProjection());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final UiSettings getUiSettings() {
        try {
            if (this.akn == null) {
                this.akn = new UiSettings(this.akm.getUiSettings());
            }
            return this.akn;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isBuildingsEnabled() {
        try {
            return this.akm.isBuildingsEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isIndoorEnabled() {
        try {
            return this.akm.isIndoorEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isMyLocationEnabled() {
        try {
            return this.akm.isMyLocationEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isTrafficEnabled() {
        try {
            return this.akm.isTrafficEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void moveCamera(CameraUpdate update) {
        try {
            this.akm.moveCamera(update.nA());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    IGoogleMapDelegate nC() {
        return this.akm;
    }

    public final void setBuildingsEnabled(boolean enabled) {
        try {
            this.akm.setBuildingsEnabled(enabled);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setContentDescription(String description) {
        try {
            this.akm.setContentDescription(description);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean setIndoorEnabled(boolean enabled) {
        try {
            return this.akm.setIndoorEnabled(enabled);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setInfoWindowAdapter(final InfoWindowAdapter adapter) {
        if (adapter == null) {
            try {
                this.akm.setInfoWindowAdapter(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.akm.setInfoWindowAdapter(new C1120a(this) {
            final /* synthetic */ GoogleMap akp;

            /* renamed from: f */
            public C0272d mo2309f(C0567l c0567l) {
                return C1332e.m4013k(adapter.getInfoWindow(new Marker(c0567l)));
            }

            /* renamed from: g */
            public C0272d mo2310g(C0567l c0567l) {
                return C1332e.m4013k(adapter.getInfoContents(new Marker(c0567l)));
            }
        });
    }

    public final void setLocationSource(final LocationSource source) {
        if (source == null) {
            try {
                this.akm.setLocationSource(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.akm.setLocationSource(new C1100a(this) {
            final /* synthetic */ GoogleMap akp;

            public void activate(final C0533i listener) {
                source.activate(new OnLocationChangedListener(this) {
                    final /* synthetic */ C14466 akw;

                    public void onLocationChanged(Location location) {
                        try {
                            listener.mo2316d(location);
                        } catch (RemoteException e) {
                            throw new RuntimeRemoteException(e);
                        }
                    }
                });
            }

            public void deactivate() {
                source.deactivate();
            }
        });
    }

    public final void setMapType(int type) {
        try {
            this.akm.setMapType(type);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setMyLocationEnabled(boolean enabled) {
        try {
            this.akm.setMyLocationEnabled(enabled);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setOnCameraChangeListener(final OnCameraChangeListener listener) {
        if (listener == null) {
            try {
                this.akm.setOnCameraChangeListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.akm.setOnCameraChangeListener(new C1124a(this) {
            final /* synthetic */ GoogleMap akp;

            public void onCameraChange(CameraPosition position) {
                listener.onCameraChange(position);
            }
        });
    }

    public final void setOnIndoorStateChangeListener(final OnIndoorStateChangeListener listener) {
        if (listener == null) {
            try {
                this.akm.setOnIndoorStateChangeListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.akm.setOnIndoorStateChangeListener(new C1126a(this) {
            final /* synthetic */ GoogleMap akp;

            /* renamed from: a */
            public void mo2313a(C0565j c0565j) {
                listener.onIndoorLevelActivated(new IndoorBuilding(c0565j));
            }

            public void onIndoorBuildingFocused() {
                listener.onIndoorBuildingFocused();
            }
        });
    }

    public final void setOnInfoWindowClickListener(final OnInfoWindowClickListener listener) {
        if (listener == null) {
            try {
                this.akm.setOnInfoWindowClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.akm.setOnInfoWindowClickListener(new C1128a(this) {
            final /* synthetic */ GoogleMap akp;

            /* renamed from: e */
            public void mo2315e(C0567l c0567l) {
                listener.onInfoWindowClick(new Marker(c0567l));
            }
        });
    }

    public final void setOnMapClickListener(final OnMapClickListener listener) {
        if (listener == null) {
            try {
                this.akm.setOnMapClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.akm.setOnMapClickListener(new C1132a(this) {
            final /* synthetic */ GoogleMap akp;

            public void onMapClick(LatLng point) {
                listener.onMapClick(point);
            }
        });
    }

    public void setOnMapLoadedCallback(final OnMapLoadedCallback callback) {
        if (callback == null) {
            try {
                this.akm.setOnMapLoadedCallback(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.akm.setOnMapLoadedCallback(new C1134a(this) {
            final /* synthetic */ GoogleMap akp;

            public void onMapLoaded() throws RemoteException {
                callback.onMapLoaded();
            }
        });
    }

    public final void setOnMapLongClickListener(final OnMapLongClickListener listener) {
        if (listener == null) {
            try {
                this.akm.setOnMapLongClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.akm.setOnMapLongClickListener(new C1136a(this) {
            final /* synthetic */ GoogleMap akp;

            public void onMapLongClick(LatLng point) {
                listener.onMapLongClick(point);
            }
        });
    }

    public final void setOnMarkerClickListener(final OnMarkerClickListener listener) {
        if (listener == null) {
            try {
                this.akm.setOnMarkerClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.akm.setOnMarkerClickListener(new C1140a(this) {
            final /* synthetic */ GoogleMap akp;

            /* renamed from: a */
            public boolean mo2322a(C0567l c0567l) {
                return listener.onMarkerClick(new Marker(c0567l));
            }
        });
    }

    public final void setOnMarkerDragListener(final OnMarkerDragListener listener) {
        if (listener == null) {
            try {
                this.akm.setOnMarkerDragListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.akm.setOnMarkerDragListener(new C1142a(this) {
            final /* synthetic */ GoogleMap akp;

            /* renamed from: b */
            public void mo2323b(C0567l c0567l) {
                listener.onMarkerDragStart(new Marker(c0567l));
            }

            /* renamed from: c */
            public void mo2324c(C0567l c0567l) {
                listener.onMarkerDragEnd(new Marker(c0567l));
            }

            /* renamed from: d */
            public void mo2325d(C0567l c0567l) {
                listener.onMarkerDrag(new Marker(c0567l));
            }
        });
    }

    public final void setOnMyLocationButtonClickListener(final OnMyLocationButtonClickListener listener) {
        if (listener == null) {
            try {
                this.akm.setOnMyLocationButtonClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.akm.setOnMyLocationButtonClickListener(new C1144a(this) {
            final /* synthetic */ GoogleMap akp;

            public boolean onMyLocationButtonClick() throws RemoteException {
                return listener.onMyLocationButtonClick();
            }
        });
    }

    @Deprecated
    public final void setOnMyLocationChangeListener(final OnMyLocationChangeListener listener) {
        if (listener == null) {
            try {
                this.akm.setOnMyLocationChangeListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.akm.setOnMyLocationChangeListener(new C1146a(this) {
            final /* synthetic */ GoogleMap akp;

            /* renamed from: c */
            public void mo2327c(Location location) {
                listener.onMyLocationChange(location);
            }

            /* renamed from: g */
            public void mo2328g(C0272d c0272d) {
                listener.onMyLocationChange((Location) C1332e.m4012f(c0272d));
            }
        });
    }

    public final void setPadding(int left, int top, int right, int bottom) {
        try {
            this.akm.setPadding(left, top, right, bottom);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setTrafficEnabled(boolean enabled) {
        try {
            this.akm.setTrafficEnabled(enabled);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void snapshot(SnapshotReadyCallback callback) {
        snapshot(callback, null);
    }

    public final void snapshot(final SnapshotReadyCallback callback, Bitmap bitmap) {
        try {
            this.akm.snapshot(new C1156a(this) {
                final /* synthetic */ GoogleMap akp;

                /* renamed from: h */
                public void mo2333h(C0272d c0272d) throws RemoteException {
                    callback.onSnapshotReady((Bitmap) C1332e.m4012f(c0272d));
                }

                public void onSnapshotReady(Bitmap snapshot) throws RemoteException {
                    callback.onSnapshotReady(snapshot);
                }
            }, (C1332e) (bitmap != null ? C1332e.m4013k(bitmap) : null));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void stopAnimation() {
        try {
            this.akm.stopAnimation();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
