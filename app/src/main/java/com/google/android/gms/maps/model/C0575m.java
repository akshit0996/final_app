package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.maps.model.m */
public class C0575m implements Creator<PolygonOptions> {
    /* renamed from: a */
    static void m2012a(PolygonOptions polygonOptions, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, polygonOptions.getVersionCode());
        C0186b.m269c(parcel, 2, polygonOptions.getPoints(), false);
        C0186b.m270d(parcel, 3, polygonOptions.of(), false);
        C0186b.m247a(parcel, 4, polygonOptions.getStrokeWidth());
        C0186b.m268c(parcel, 5, polygonOptions.getStrokeColor());
        C0186b.m268c(parcel, 6, polygonOptions.getFillColor());
        C0186b.m247a(parcel, 7, polygonOptions.getZIndex());
        C0186b.m259a(parcel, 8, polygonOptions.isVisible());
        C0186b.m259a(parcel, 9, polygonOptions.isGeodesic());
        C0186b.m244H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return dg(x0);
    }

    public PolygonOptions dg(Parcel parcel) {
        float f = 0.0f;
        boolean z = false;
        int G = C0185a.m208G(parcel);
        List list = null;
        List arrayList = new ArrayList();
        boolean z2 = false;
        int i = 0;
        int i2 = 0;
        float f2 = 0.0f;
        int i3 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i3 = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    list = C0185a.m216c(parcel, F, LatLng.CREATOR);
                    break;
                case 3:
                    C0185a.m213a(parcel, F, arrayList, getClass().getClassLoader());
                    break;
                case 4:
                    f2 = C0185a.m226l(parcel, F);
                    break;
                case 5:
                    i2 = C0185a.m221g(parcel, F);
                    break;
                case 6:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 7:
                    f = C0185a.m226l(parcel, F);
                    break;
                case 8:
                    z2 = C0185a.m217c(parcel, F);
                    break;
                case 9:
                    z = C0185a.m217c(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new PolygonOptions(i3, list, arrayList, f2, i2, i, f, z2, z);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public PolygonOptions[] fc(int i) {
        return new PolygonOptions[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return fc(x0);
    }
}
