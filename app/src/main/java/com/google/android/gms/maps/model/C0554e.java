package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.maps.model.e */
public class C0554e implements Creator<GroundOverlayOptions> {
    /* renamed from: a */
    static void m1986a(GroundOverlayOptions groundOverlayOptions, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, groundOverlayOptions.getVersionCode());
        C0186b.m250a(parcel, 2, groundOverlayOptions.od(), false);
        C0186b.m252a(parcel, 3, groundOverlayOptions.getLocation(), i, false);
        C0186b.m247a(parcel, 4, groundOverlayOptions.getWidth());
        C0186b.m247a(parcel, 5, groundOverlayOptions.getHeight());
        C0186b.m252a(parcel, 6, groundOverlayOptions.getBounds(), i, false);
        C0186b.m247a(parcel, 7, groundOverlayOptions.getBearing());
        C0186b.m247a(parcel, 8, groundOverlayOptions.getZIndex());
        C0186b.m259a(parcel, 9, groundOverlayOptions.isVisible());
        C0186b.m247a(parcel, 10, groundOverlayOptions.getTransparency());
        C0186b.m247a(parcel, 11, groundOverlayOptions.getAnchorU());
        C0186b.m247a(parcel, 12, groundOverlayOptions.getAnchorV());
        C0186b.m244H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return dc(x0);
    }

    public GroundOverlayOptions dc(Parcel parcel) {
        int G = C0185a.m208G(parcel);
        int i = 0;
        IBinder iBinder = null;
        LatLng latLng = null;
        float f = 0.0f;
        float f2 = 0.0f;
        LatLngBounds latLngBounds = null;
        float f3 = 0.0f;
        float f4 = 0.0f;
        boolean z = false;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
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
                    latLng = (LatLng) C0185a.m210a(parcel, F, LatLng.CREATOR);
                    break;
                case 4:
                    f = C0185a.m226l(parcel, F);
                    break;
                case 5:
                    f2 = C0185a.m226l(parcel, F);
                    break;
                case 6:
                    latLngBounds = (LatLngBounds) C0185a.m210a(parcel, F, LatLngBounds.CREATOR);
                    break;
                case 7:
                    f3 = C0185a.m226l(parcel, F);
                    break;
                case 8:
                    f4 = C0185a.m226l(parcel, F);
                    break;
                case 9:
                    z = C0185a.m217c(parcel, F);
                    break;
                case 10:
                    f5 = C0185a.m226l(parcel, F);
                    break;
                case 11:
                    f6 = C0185a.m226l(parcel, F);
                    break;
                case 12:
                    f7 = C0185a.m226l(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new GroundOverlayOptions(i, iBinder, latLng, f, f2, latLngBounds, f3, f4, z, f5, f6, f7);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public GroundOverlayOptions[] eY(int i) {
        return new GroundOverlayOptions[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return eY(x0);
    }
}
