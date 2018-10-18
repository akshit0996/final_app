package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.maps.model.d */
public class C0553d {
    /* renamed from: a */
    static void m1985a(CircleOptions circleOptions, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, circleOptions.getVersionCode());
        C0186b.m252a(parcel, 2, circleOptions.getCenter(), i, false);
        C0186b.m246a(parcel, 3, circleOptions.getRadius());
        C0186b.m247a(parcel, 4, circleOptions.getStrokeWidth());
        C0186b.m268c(parcel, 5, circleOptions.getStrokeColor());
        C0186b.m268c(parcel, 6, circleOptions.getFillColor());
        C0186b.m247a(parcel, 7, circleOptions.getZIndex());
        C0186b.m259a(parcel, 8, circleOptions.isVisible());
        C0186b.m244H(parcel, H);
    }
}
