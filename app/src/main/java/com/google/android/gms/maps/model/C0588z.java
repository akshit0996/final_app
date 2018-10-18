package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.maps.model.z */
public class C0588z {
    /* renamed from: a */
    static void m2026a(VisibleRegion visibleRegion, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, visibleRegion.getVersionCode());
        C0186b.m252a(parcel, 2, visibleRegion.nearLeft, i, false);
        C0186b.m252a(parcel, 3, visibleRegion.nearRight, i, false);
        C0186b.m252a(parcel, 4, visibleRegion.farLeft, i, false);
        C0186b.m252a(parcel, 5, visibleRegion.farRight, i, false);
        C0186b.m252a(parcel, 6, visibleRegion.latLngBounds, i, false);
        C0186b.m244H(parcel, H);
    }
}
