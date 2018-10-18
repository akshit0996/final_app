package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.maps.model.j */
public class C0572j {
    /* renamed from: a */
    static void m2009a(LatLng latLng, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, latLng.getVersionCode());
        C0186b.m246a(parcel, 2, latLng.latitude);
        C0186b.m246a(parcel, 3, latLng.longitude);
        C0186b.m244H(parcel, H);
    }
}
