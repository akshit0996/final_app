package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

/* renamed from: com.google.android.gms.maps.c */
public class C0524c implements Creator<StreetViewPanoramaOptions> {
    /* renamed from: a */
    static void m1948a(StreetViewPanoramaOptions streetViewPanoramaOptions, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, streetViewPanoramaOptions.getVersionCode());
        C0186b.m252a(parcel, 2, streetViewPanoramaOptions.getStreetViewPanoramaCamera(), i, false);
        C0186b.m256a(parcel, 3, streetViewPanoramaOptions.getPanoramaId(), false);
        C0186b.m252a(parcel, 4, streetViewPanoramaOptions.getPosition(), i, false);
        C0186b.m254a(parcel, 5, streetViewPanoramaOptions.getRadius(), false);
        C0186b.m245a(parcel, 6, streetViewPanoramaOptions.nS());
        C0186b.m245a(parcel, 7, streetViewPanoramaOptions.nI());
        C0186b.m245a(parcel, 8, streetViewPanoramaOptions.nT());
        C0186b.m245a(parcel, 9, streetViewPanoramaOptions.nU());
        C0186b.m245a(parcel, 10, streetViewPanoramaOptions.nE());
        C0186b.m244H(parcel, H);
    }

    public StreetViewPanoramaOptions cY(Parcel parcel) {
        Integer num = null;
        byte b = (byte) 0;
        int G = C0185a.m208G(parcel);
        byte b2 = (byte) 0;
        byte b3 = (byte) 0;
        byte b4 = (byte) 0;
        byte b5 = (byte) 0;
        LatLng latLng = null;
        String str = null;
        StreetViewPanoramaCamera streetViewPanoramaCamera = null;
        int i = 0;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    streetViewPanoramaCamera = (StreetViewPanoramaCamera) C0185a.m210a(parcel, F, StreetViewPanoramaCamera.CREATOR);
                    break;
                case 3:
                    str = C0185a.m229o(parcel, F);
                    break;
                case 4:
                    latLng = (LatLng) C0185a.m210a(parcel, F, LatLng.CREATOR);
                    break;
                case 5:
                    num = C0185a.m222h(parcel, F);
                    break;
                case 6:
                    b5 = C0185a.m219e(parcel, F);
                    break;
                case 7:
                    b4 = C0185a.m219e(parcel, F);
                    break;
                case 8:
                    b3 = C0185a.m219e(parcel, F);
                    break;
                case 9:
                    b2 = C0185a.m219e(parcel, F);
                    break;
                case 10:
                    b = C0185a.m219e(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new StreetViewPanoramaOptions(i, streetViewPanoramaCamera, str, latLng, num, b5, b4, b3, b2, b);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cY(x0);
    }

    public StreetViewPanoramaOptions[] eU(int i) {
        return new StreetViewPanoramaOptions[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return eU(x0);
    }
}
