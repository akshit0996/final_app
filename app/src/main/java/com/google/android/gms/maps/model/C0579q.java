package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.maps.model.q */
public class C0579q implements Creator<StreetViewPanoramaCamera> {
    /* renamed from: a */
    static void m2016a(StreetViewPanoramaCamera streetViewPanoramaCamera, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, streetViewPanoramaCamera.getVersionCode());
        C0186b.m247a(parcel, 2, streetViewPanoramaCamera.zoom);
        C0186b.m247a(parcel, 3, streetViewPanoramaCamera.tilt);
        C0186b.m247a(parcel, 4, streetViewPanoramaCamera.bearing);
        C0186b.m244H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return di(x0);
    }

    public StreetViewPanoramaCamera di(Parcel parcel) {
        float f = 0.0f;
        int G = C0185a.m208G(parcel);
        float f2 = 0.0f;
        int i = 0;
        float f3 = 0.0f;
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
                    f3 = C0185a.m226l(parcel, F);
                    break;
                case 4:
                    f = C0185a.m226l(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new StreetViewPanoramaCamera(i, f2, f3, f);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public StreetViewPanoramaCamera[] fe(int i) {
        return new StreetViewPanoramaCamera[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return fe(x0);
    }
}
