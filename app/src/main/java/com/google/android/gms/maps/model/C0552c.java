package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.maps.model.c */
public class C0552c implements Creator<CircleOptions> {
    /* renamed from: a */
    static void m1984a(CircleOptions circleOptions, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, circleOptions.getVersionCode());
        C0186b.m252a(parcel, 2, circleOptions.getCenter(), i, false);
        C0186b.m246a(parcel, 3, circleOptions.getRadius());
        C0186b.m247a(parcel, 4, circleOptions.getStrokeWidth());
        C0186b.m268c(parcel, 5, circleOptions.getStrokeColor());
        C0186b.m268c(parcel, 6, circleOptions.getFillColor());
        C0186b.m247a(parcel, 7, circleOptions.getZIndex());
        C0186b.m259a(parcel, 8, circleOptions.isVisible());
        C0186b.m244H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return db(x0);
    }

    public CircleOptions db(Parcel parcel) {
        float f = 0.0f;
        boolean z = false;
        int G = C0185a.m208G(parcel);
        LatLng latLng = null;
        double d = 0.0d;
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
                    latLng = (LatLng) C0185a.m210a(parcel, F, LatLng.CREATOR);
                    break;
                case 3:
                    d = C0185a.m227m(parcel, F);
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
                    z = C0185a.m217c(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new CircleOptions(i3, latLng, d, f2, i2, i, f, z);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public CircleOptions[] eX(int i) {
        return new CircleOptions[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return eX(x0);
    }
}
