package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.maps.model.n */
public class C0576n {
    /* renamed from: a */
    static void m2013a(PolygonOptions polygonOptions, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, polygonOptions.getVersionCode());
        C0186b.m269c(parcel, 2, polygonOptions.getPoints(), false);
        C0186b.m270d(parcel, 3, polygonOptions.of(), false);
        C0186b.m247a(parcel, 4, polygonOptions.getStrokeWidth());
        C0186b.m268c(parcel, 5, polygonOptions.getStrokeColor());
        C0186b.m268c(parcel, 6, polygonOptions.getFillColor());
        C0186b.m247a(parcel, 7, polygonOptions.getZIndex());
        C0186b.m259a(parcel, 8, polygonOptions.isVisible());
        C0186b.m259a(parcel, 9, polygonOptions.isGeodesic());
        C0186b.m244H(parcel, H);
    }
}
