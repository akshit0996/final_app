package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.maps.model.f */
public class C0555f {
    /* renamed from: a */
    static void m1987a(GroundOverlayOptions groundOverlayOptions, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, groundOverlayOptions.getVersionCode());
        C0186b.m250a(parcel, 2, groundOverlayOptions.od(), false);
        C0186b.m252a(parcel, 3, groundOverlayOptions.getLocation(), i, false);
        C0186b.m247a(parcel, 4, groundOverlayOptions.getWidth());
        C0186b.m247a(parcel, 5, groundOverlayOptions.getHeight());
        C0186b.m252a(parcel, 6, groundOverlayOptions.getBounds(), i, false);
        C0186b.m247a(parcel, 7, groundOverlayOptions.getBearing());
        C0186b.m247a(parcel, 8, groundOverlayOptions.getZIndex());
        C0186b.m259a(parcel, 9, groundOverlayOptions.isVisible());
        C0186b.m247a(parcel, 10, groundOverlayOptions.getTransparency());
        C0186b.m247a(parcel, 11, groundOverlayOptions.getAnchorU());
        C0186b.m247a(parcel, 12, groundOverlayOptions.getAnchorV());
        C0186b.m244H(parcel, H);
    }
}
