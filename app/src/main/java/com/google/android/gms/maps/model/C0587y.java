package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.maps.model.y */
public class C0587y implements Creator<VisibleRegion> {
    /* renamed from: a */
    static void m2024a(VisibleRegion visibleRegion, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, visibleRegion.getVersionCode());
        C0186b.m252a(parcel, 2, visibleRegion.nearLeft, i, false);
        C0186b.m252a(parcel, 3, visibleRegion.nearRight, i, false);
        C0186b.m252a(parcel, 4, visibleRegion.farLeft, i, false);
        C0186b.m252a(parcel, 5, visibleRegion.farRight, i, false);
        C0186b.m252a(parcel, 6, visibleRegion.latLngBounds, i, false);
        C0186b.m244H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m2025do(x0);
    }

    /* renamed from: do */
    public VisibleRegion m2025do(Parcel parcel) {
        LatLngBounds latLngBounds = null;
        int G = C0185a.m208G(parcel);
        int i = 0;
        LatLng latLng = null;
        LatLng latLng2 = null;
        LatLng latLng3 = null;
        LatLng latLng4 = null;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    latLng4 = (LatLng) C0185a.m210a(parcel, F, LatLng.CREATOR);
                    break;
                case 3:
                    latLng3 = (LatLng) C0185a.m210a(parcel, F, LatLng.CREATOR);
                    break;
                case 4:
                    latLng2 = (LatLng) C0185a.m210a(parcel, F, LatLng.CREATOR);
                    break;
                case 5:
                    latLng = (LatLng) C0185a.m210a(parcel, F, LatLng.CREATOR);
                    break;
                case 6:
                    latLngBounds = (LatLngBounds) C0185a.m210a(parcel, F, LatLngBounds.CREATOR);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new VisibleRegion(i, latLng4, latLng3, latLng2, latLng, latLngBounds);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public VisibleRegion[] fk(int i) {
        return new VisibleRegion[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return fk(x0);
    }
}
