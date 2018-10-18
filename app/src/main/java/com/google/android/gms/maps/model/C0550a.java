package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.maps.model.a */
public class C0550a implements Creator<CameraPosition> {
    /* renamed from: a */
    static void m1982a(CameraPosition cameraPosition, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, cameraPosition.getVersionCode());
        C0186b.m252a(parcel, 2, cameraPosition.target, i, false);
        C0186b.m247a(parcel, 3, cameraPosition.zoom);
        C0186b.m247a(parcel, 4, cameraPosition.tilt);
        C0186b.m247a(parcel, 5, cameraPosition.bearing);
        C0186b.m244H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return da(x0);
    }

    public CameraPosition da(Parcel parcel) {
        float f = 0.0f;
        int G = C0185a.m208G(parcel);
        int i = 0;
        LatLng latLng = null;
        float f2 = 0.0f;
        float f3 = 0.0f;
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
                    f3 = C0185a.m226l(parcel, F);
                    break;
                case 4:
                    f2 = C0185a.m226l(parcel, F);
                    break;
                case 5:
                    f = C0185a.m226l(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new CameraPosition(i, latLng, f3, f2, f);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public CameraPosition[] eW(int i) {
        return new CameraPosition[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return eW(x0);
    }
}
