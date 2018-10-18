package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.maps.model.b */
public class C0551b {
    /* renamed from: a */
    static void m1983a(CameraPosition cameraPosition, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, cameraPosition.getVersionCode());
        C0186b.m252a(parcel, 2, cameraPosition.target, i, false);
        C0186b.m247a(parcel, 3, cameraPosition.zoom);
        C0186b.m247a(parcel, 4, cameraPosition.tilt);
        C0186b.m247a(parcel, 5, cameraPosition.bearing);
        C0186b.m244H(parcel, H);
    }
}
