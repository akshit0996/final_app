package com.google.android.gms.maps;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.maps.b */
public class C0523b {
    /* renamed from: a */
    static void m1947a(GoogleMapOptions googleMapOptions, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, googleMapOptions.getVersionCode());
        C0186b.m245a(parcel, 2, googleMapOptions.nD());
        C0186b.m245a(parcel, 3, googleMapOptions.nE());
        C0186b.m268c(parcel, 4, googleMapOptions.getMapType());
        C0186b.m252a(parcel, 5, googleMapOptions.getCamera(), i, false);
        C0186b.m245a(parcel, 6, googleMapOptions.nF());
        C0186b.m245a(parcel, 7, googleMapOptions.nG());
        C0186b.m245a(parcel, 8, googleMapOptions.nH());
        C0186b.m245a(parcel, 9, googleMapOptions.nI());
        C0186b.m245a(parcel, 10, googleMapOptions.nJ());
        C0186b.m245a(parcel, 11, googleMapOptions.nK());
        C0186b.m244H(parcel, H);
    }
}
