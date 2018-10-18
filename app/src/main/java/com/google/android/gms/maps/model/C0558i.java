package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.maps.model.i */
public class C0558i implements Creator<LatLng> {
    /* renamed from: a */
    static void m1990a(LatLng latLng, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, latLng.getVersionCode());
        C0186b.m246a(parcel, 2, latLng.latitude);
        C0186b.m246a(parcel, 3, latLng.longitude);
        C0186b.m244H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return de(x0);
    }

    public LatLng de(Parcel parcel) {
        double d = 0.0d;
        int G = C0185a.m208G(parcel);
        int i = 0;
        double d2 = 0.0d;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    d2 = C0185a.m227m(parcel, F);
                    break;
                case 3:
                    d = C0185a.m227m(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new LatLng(i, d2, d);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public LatLng[] fa(int i) {
        return new LatLng[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return fa(x0);
    }
}
