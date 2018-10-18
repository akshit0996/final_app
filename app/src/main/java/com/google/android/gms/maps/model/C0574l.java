package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.maps.model.l */
public class C0574l {
    /* renamed from: a */
    static void m2011a(MarkerOptions markerOptions, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, markerOptions.getVersionCode());
        C0186b.m252a(parcel, 2, markerOptions.getPosition(), i, false);
        C0186b.m256a(parcel, 3, markerOptions.getTitle(), false);
        C0186b.m256a(parcel, 4, markerOptions.getSnippet(), false);
        C0186b.m250a(parcel, 5, markerOptions.oe(), false);
        C0186b.m247a(parcel, 6, markerOptions.getAnchorU());
        C0186b.m247a(parcel, 7, markerOptions.getAnchorV());
        C0186b.m259a(parcel, 8, markerOptions.isDraggable());
        C0186b.m259a(parcel, 9, markerOptions.isVisible());
        C0186b.m244H(parcel, H);
    }
}
