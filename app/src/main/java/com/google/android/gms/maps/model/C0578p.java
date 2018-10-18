package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.maps.model.p */
public class C0578p {
    /* renamed from: a */
    static void m2015a(PolylineOptions polylineOptions, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, polylineOptions.getVersionCode());
        C0186b.m269c(parcel, 2, polylineOptions.getPoints(), false);
        C0186b.m247a(parcel, 3, polylineOptions.getWidth());
        C0186b.m268c(parcel, 4, polylineOptions.getColor());
        C0186b.m247a(parcel, 5, polylineOptions.getZIndex());
        C0186b.m259a(parcel, 6, polylineOptions.isVisible());
        C0186b.m259a(parcel, 7, polylineOptions.isGeodesic());
        C0186b.m244H(parcel, H);
    }
}
