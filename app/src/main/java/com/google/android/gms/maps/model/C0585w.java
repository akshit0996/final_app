package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.maps.model.w */
public class C0585w implements Creator<TileOverlayOptions> {
    /* renamed from: a */
    static void m2022a(TileOverlayOptions tileOverlayOptions, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, tileOverlayOptions.getVersionCode());
        C0186b.m250a(parcel, 2, tileOverlayOptions.og(), false);
        C0186b.m259a(parcel, 3, tileOverlayOptions.isVisible());
        C0186b.m247a(parcel, 4, tileOverlayOptions.getZIndex());
        C0186b.m259a(parcel, 5, tileOverlayOptions.getFadeIn());
        C0186b.m244H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return dn(x0);
    }

    public TileOverlayOptions dn(Parcel parcel) {
        boolean z = false;
        int G = C0185a.m208G(parcel);
        IBinder iBinder = null;
        float f = 0.0f;
        boolean z2 = true;
        int i = 0;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    iBinder = C0185a.m230p(parcel, F);
                    break;
                case 3:
                    z = C0185a.m217c(parcel, F);
                    break;
                case 4:
                    f = C0185a.m226l(parcel, F);
                    break;
                case 5:
                    z2 = C0185a.m217c(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new TileOverlayOptions(i, iBinder, z, f, z2);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public TileOverlayOptions[] fj(int i) {
        return new TileOverlayOptions[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return fj(x0);
    }
}
