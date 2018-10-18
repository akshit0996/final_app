package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.maps.model.r */
public class C0580r implements Creator<StreetViewPanoramaLink> {
    /* renamed from: a */
    static void m2017a(StreetViewPanoramaLink streetViewPanoramaLink, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, streetViewPanoramaLink.getVersionCode());
        C0186b.m256a(parcel, 2, streetViewPanoramaLink.panoId, false);
        C0186b.m247a(parcel, 3, streetViewPanoramaLink.bearing);
        C0186b.m244H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return dj(x0);
    }

    public StreetViewPanoramaLink dj(Parcel parcel) {
        int G = C0185a.m208G(parcel);
        int i = 0;
        String str = null;
        float f = 0.0f;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    str = C0185a.m229o(parcel, F);
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
            return new StreetViewPanoramaLink(i, str, f);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public StreetViewPanoramaLink[] ff(int i) {
        return new StreetViewPanoramaLink[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ff(x0);
    }
}
