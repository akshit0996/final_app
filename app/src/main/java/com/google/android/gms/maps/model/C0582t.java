package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.maps.model.t */
public class C0582t implements Creator<StreetViewPanoramaOrientation> {
    /* renamed from: a */
    static void m2019a(StreetViewPanoramaOrientation streetViewPanoramaOrientation, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, streetViewPanoramaOrientation.getVersionCode());
        C0186b.m247a(parcel, 2, streetViewPanoramaOrientation.tilt);
        C0186b.m247a(parcel, 3, streetViewPanoramaOrientation.bearing);
        C0186b.m244H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return dl(x0);
    }

    public StreetViewPanoramaOrientation dl(Parcel parcel) {
        float f = 0.0f;
        int G = C0185a.m208G(parcel);
        int i = 0;
        float f2 = 0.0f;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    f2 = C0185a.m226l(parcel, F);
                    break;
                case 3:
                    f = C0185a.m226l(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new StreetViewPanoramaOrientation(i, f2, f);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public StreetViewPanoramaOrientation[] fh(int i) {
        return new StreetViewPanoramaOrientation[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return fh(x0);
    }
}
