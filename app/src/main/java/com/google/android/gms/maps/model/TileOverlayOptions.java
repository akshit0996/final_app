package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.aa;
import com.google.android.gms.maps.model.internal.C0570o;
import com.google.android.gms.maps.model.internal.C0570o.C1181a;

public final class TileOverlayOptions implements SafeParcelable {
    public static final C0585w CREATOR = new C0585w();
    private final int CK;
    private float alX;
    private boolean alY;
    private C0570o amD;
    private TileProvider amE;
    private boolean amF;

    /* renamed from: com.google.android.gms.maps.model.TileOverlayOptions$1 */
    class C11581 implements TileProvider {
        private final C0570o amG = this.amH.amD;
        final /* synthetic */ TileOverlayOptions amH;

        C11581(TileOverlayOptions tileOverlayOptions) {
            this.amH = tileOverlayOptions;
        }

        public Tile getTile(int x, int y, int zoom) {
            try {
                return this.amG.getTile(x, y, zoom);
            } catch (RemoteException e) {
                return null;
            }
        }
    }

    public TileOverlayOptions() {
        this.alY = true;
        this.amF = true;
        this.CK = 1;
    }

    TileOverlayOptions(int versionCode, IBinder delegate, boolean visible, float zIndex, boolean fadeIn) {
        this.alY = true;
        this.amF = true;
        this.CK = versionCode;
        this.amD = C1181a.bE(delegate);
        this.amE = this.amD == null ? null : new C11581(this);
        this.alY = visible;
        this.alX = zIndex;
        this.amF = fadeIn;
    }

    public int describeContents() {
        return 0;
    }

    public TileOverlayOptions fadeIn(boolean fadeIn) {
        this.amF = fadeIn;
        return this;
    }

    public boolean getFadeIn() {
        return this.amF;
    }

    public TileProvider getTileProvider() {
        return this.amE;
    }

    int getVersionCode() {
        return this.CK;
    }

    public float getZIndex() {
        return this.alX;
    }

    public boolean isVisible() {
        return this.alY;
    }

    IBinder og() {
        return this.amD.asBinder();
    }

    public TileOverlayOptions tileProvider(final TileProvider tileProvider) {
        this.amE = tileProvider;
        this.amD = this.amE == null ? null : new C1181a(this) {
            final /* synthetic */ TileOverlayOptions amH;

            public Tile getTile(int x, int y, int zoom) {
                return tileProvider.getTile(x, y, zoom);
            }
        };
        return this;
    }

    public TileOverlayOptions visible(boolean visible) {
        this.alY = visible;
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        if (aa.ob()) {
            C0586x.m2023a(this, out, flags);
        } else {
            C0585w.m2022a(this, out, flags);
        }
    }

    public TileOverlayOptions zIndex(float zIndex) {
        this.alX = zIndex;
        return this;
    }
}
