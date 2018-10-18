package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import java.util.List;

/* renamed from: com.google.android.gms.maps.model.o */
public class C0577o implements Creator<PolylineOptions> {
    /* renamed from: a */
    static void m2014a(PolylineOptions polylineOptions, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, polylineOptions.getVersionCode());
        C0186b.m269c(parcel, 2, polylineOptions.getPoints(), false);
        C0186b.m247a(parcel, 3, polylineOptions.getWidth());
        C0186b.m268c(parcel, 4, polylineOptions.getColor());
        C0186b.m247a(parcel, 5, polylineOptions.getZIndex());
        C0186b.m259a(parcel, 6, polylineOptions.isVisible());
        C0186b.m259a(parcel, 7, polylineOptions.isGeodesic());
        C0186b.m244H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return dh(x0);
    }

    public PolylineOptions dh(Parcel parcel) {
        float f = 0.0f;
        boolean z = false;
        int G = C0185a.m208G(parcel);
        List list = null;
        boolean z2 = false;
        int i = 0;
        float f2 = 0.0f;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i2 = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    list = C0185a.m216c(parcel, F, LatLng.CREATOR);
                    break;
                case 3:
                    f2 = C0185a.m226l(parcel, F);
                    break;
                case 4:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 5:
                    f = C0185a.m226l(parcel, F);
                    break;
                case 6:
                    z2 = C0185a.m217c(parcel, F);
                    break;
                case 7:
                    z = C0185a.m217c(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new PolylineOptions(i2, list, f2, i, f, z2, z);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public PolylineOptions[] fd(int i) {
        return new PolylineOptions[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return fd(x0);
    }
}
