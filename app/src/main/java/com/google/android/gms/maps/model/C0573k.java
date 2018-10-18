package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.maps.model.k */
public class C0573k implements Creator<MarkerOptions> {
    /* renamed from: a */
    static void m2010a(MarkerOptions markerOptions, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, markerOptions.getVersionCode());
        C0186b.m252a(parcel, 2, markerOptions.getPosition(), i, false);
        C0186b.m256a(parcel, 3, markerOptions.getTitle(), false);
        C0186b.m256a(parcel, 4, markerOptions.getSnippet(), false);
        C0186b.m250a(parcel, 5, markerOptions.oe(), false);
        C0186b.m247a(parcel, 6, markerOptions.getAnchorU());
        C0186b.m247a(parcel, 7, markerOptions.getAnchorV());
        C0186b.m259a(parcel, 8, markerOptions.isDraggable());
        C0186b.m259a(parcel, 9, markerOptions.isVisible());
        C0186b.m259a(parcel, 10, markerOptions.isFlat());
        C0186b.m247a(parcel, 11, markerOptions.getRotation());
        C0186b.m247a(parcel, 12, markerOptions.getInfoWindowAnchorU());
        C0186b.m247a(parcel, 13, markerOptions.getInfoWindowAnchorV());
        C0186b.m247a(parcel, 14, markerOptions.getAlpha());
        C0186b.m244H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return df(x0);
    }

    public MarkerOptions df(Parcel parcel) {
        int G = C0185a.m208G(parcel);
        int i = 0;
        LatLng latLng = null;
        String str = null;
        String str2 = null;
        IBinder iBinder = null;
        float f = 0.0f;
        float f2 = 0.0f;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        float f3 = 0.0f;
        float f4 = 0.5f;
        float f5 = 0.0f;
        float f6 = 1.0f;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    latLng = (LatLng) C0185a.m210a(parcel, F, LatLng.CREATOR);
                    break;
                case 3:
                    str = C0185a.m229o(parcel, F);
                    break;
                case 4:
                    str2 = C0185a.m229o(parcel, F);
                    break;
                case 5:
                    iBinder = C0185a.m230p(parcel, F);
                    break;
                case 6:
                    f = C0185a.m226l(parcel, F);
                    break;
                case 7:
                    f2 = C0185a.m226l(parcel, F);
                    break;
                case 8:
                    z = C0185a.m217c(parcel, F);
                    break;
                case 9:
                    z2 = C0185a.m217c(parcel, F);
                    break;
                case 10:
                    z3 = C0185a.m217c(parcel, F);
                    break;
                case 11:
                    f3 = C0185a.m226l(parcel, F);
                    break;
                case 12:
                    f4 = C0185a.m226l(parcel, F);
                    break;
                case 13:
                    f5 = C0185a.m226l(parcel, F);
                    break;
                case 14:
                    f6 = C0185a.m226l(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new MarkerOptions(i, latLng, str, str2, iBinder, f, f2, z, z2, z3, f3, f4, f5, f6);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public MarkerOptions[] fb(int i) {
        return new MarkerOptions[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return fb(x0);
    }
}
