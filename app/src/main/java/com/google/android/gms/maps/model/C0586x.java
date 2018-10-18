package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.maps.model.x */
public class C0586x {
    /* renamed from: a */
    static void m2023a(TileOverlayOptions tileOverlayOptions, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, tileOverlayOptions.getVersionCode());
        C0186b.m250a(parcel, 2, tileOverlayOptions.og(), false);
        C0186b.m259a(parcel, 3, tileOverlayOptions.isVisible());
        C0186b.m247a(parcel, 4, tileOverlayOptions.getZIndex());
        C0186b.m244H(parcel, H);
    }
}
