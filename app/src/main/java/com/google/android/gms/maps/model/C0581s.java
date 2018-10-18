package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.maps.model.s */
public class C0581s implements Creator<StreetViewPanoramaLocation> {
    /* renamed from: a */
    static void m2018a(StreetViewPanoramaLocation streetViewPanoramaLocation, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, streetViewPanoramaLocation.getVersionCode());
        C0186b.m262a(parcel, 2, streetViewPanoramaLocation.links, i, false);
        C0186b.m252a(parcel, 3, streetViewPanoramaLocation.position, i, false);
        C0186b.m256a(parcel, 4, streetViewPanoramaLocation.panoId, false);
        C0186b.m244H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return dk(x0);
    }

    public StreetViewPanoramaLocation dk(Parcel parcel) {
        String str = null;
        int G = C0185a.m208G(parcel);
        int i = 0;
        LatLng latLng = null;
        StreetViewPanoramaLink[] streetViewPanoramaLinkArr = null;
        while (parcel.dataPosition() < G) {
            LatLng latLng2;
            StreetViewPanoramaLink[] streetViewPanoramaLinkArr2;
            int g;
            String str2;
            int F = C0185a.m207F(parcel);
            String str3;
            switch (C0185a.aH(F)) {
                case 1:
                    str3 = str;
                    latLng2 = latLng;
                    streetViewPanoramaLinkArr2 = streetViewPanoramaLinkArr;
                    g = C0185a.m221g(parcel, F);
                    str2 = str3;
                    break;
                case 2:
                    g = i;
                    LatLng latLng3 = latLng;
                    streetViewPanoramaLinkArr2 = (StreetViewPanoramaLink[]) C0185a.m215b(parcel, F, StreetViewPanoramaLink.CREATOR);
                    str2 = str;
                    latLng2 = latLng3;
                    break;
                case 3:
                    streetViewPanoramaLinkArr2 = streetViewPanoramaLinkArr;
                    g = i;
                    str3 = str;
                    latLng2 = (LatLng) C0185a.m210a(parcel, F, LatLng.CREATOR);
                    str2 = str3;
                    break;
                case 4:
                    str2 = C0185a.m229o(parcel, F);
                    latLng2 = latLng;
                    streetViewPanoramaLinkArr2 = streetViewPanoramaLinkArr;
                    g = i;
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    str2 = str;
                    latLng2 = latLng;
                    streetViewPanoramaLinkArr2 = streetViewPanoramaLinkArr;
                    g = i;
                    break;
            }
            i = g;
            streetViewPanoramaLinkArr = streetViewPanoramaLinkArr2;
            latLng = latLng2;
            str = str2;
        }
        if (parcel.dataPosition() == G) {
            return new StreetViewPanoramaLocation(i, streetViewPanoramaLinkArr, latLng, str);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public StreetViewPanoramaLocation[] fg(int i) {
        return new StreetViewPanoramaLocation[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return fg(x0);
    }
}
