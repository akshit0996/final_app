package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.maps.model.h */
public class C0557h {
    /* renamed from: a */
    static void m1989a(LatLngBounds latLngBounds, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, latLngBounds.getVersionCode());
        C0186b.m252a(parcel, 2, latLngBounds.southwest, i, false);
        C0186b.m252a(parcel, 3, latLngBounds.northeast, i, false);
        C0186b.m244H(parcel, H);
    }
}
