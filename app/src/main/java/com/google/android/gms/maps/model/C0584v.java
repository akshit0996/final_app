package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.maps.model.v */
public class C0584v {
    /* renamed from: a */
    static void m2021a(Tile tile, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, tile.getVersionCode());
        C0186b.m268c(parcel, 2, tile.width);
        C0186b.m268c(parcel, 3, tile.height);
        C0186b.m260a(parcel, 4, tile.data, false);
        C0186b.m244H(parcel, H);
    }
}
