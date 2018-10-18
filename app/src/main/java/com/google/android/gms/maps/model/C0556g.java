package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.maps.model.g */
public class C0556g implements Creator<LatLngBounds> {
    /* renamed from: a */
    static void m1988a(LatLngBounds latLngBounds, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, latLngBounds.getVersionCode());
        C0186b.m252a(parcel, 2, latLngBounds.southwest, i, false);
        C0186b.m252a(parcel, 3, latLngBounds.northeast, i, false);
        C0186b.m244H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return dd(x0);
    }

    public LatLngBounds dd(Parcel parcel) {
        LatLng latLng = null;
        int G = C0185a.m208G(parcel);
        int i = 0;
        LatLng latLng2 = null;
        while (parcel.dataPosition() < G) {
            int g;
            LatLng latLng3;
            int F = C0185a.m207F(parcel);
            LatLng latLng4;
            switch (C0185a.aH(F)) {
                case 1:
                    latLng4 = latLng;
                    latLng = latLng2;
                    g = C0185a.m221g(parcel, F);
                    latLng3 = latLng4;
                    break;
                case 2:
                    g = i;
                    latLng4 = (LatLng) C0185a.m210a(parcel, F, LatLng.CREATOR);
                    latLng3 = latLng;
                    latLng = latLng4;
                    break;
                case 3:
                    latLng3 = (LatLng) C0185a.m210a(parcel, F, LatLng.CREATOR);
                    latLng = latLng2;
                    g = i;
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    latLng3 = latLng;
                    latLng = latLng2;
                    g = i;
                    break;
            }
            i = g;
            latLng2 = latLng;
            latLng = latLng3;
        }
        if (parcel.dataPosition() == G) {
            return new LatLngBounds(i, latLng2, latLng);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public LatLngBounds[] eZ(int i) {
        return new LatLngBounds[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return eZ(x0);
    }
}
