package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.maps.model.LatLng;
import java.util.List;

public class od implements Creator<oc> {
    /* renamed from: a */
    static void m1753a(oc ocVar, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m256a(parcel, 1, ocVar.getName(), false);
        C0186b.m268c(parcel, 1000, ocVar.CK);
        C0186b.m252a(parcel, 2, ocVar.nx(), i, false);
        C0186b.m256a(parcel, 3, ocVar.getAddress(), false);
        C0186b.m269c(parcel, 4, ocVar.ny(), false);
        C0186b.m256a(parcel, 5, ocVar.getPhoneNumber(), false);
        C0186b.m256a(parcel, 6, ocVar.nz(), false);
        C0186b.m244H(parcel, H);
    }

    public oc cU(Parcel parcel) {
        String str = null;
        int G = C0185a.m208G(parcel);
        int i = 0;
        String str2 = null;
        List list = null;
        String str3 = null;
        LatLng latLng = null;
        String str4 = null;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    str4 = C0185a.m229o(parcel, F);
                    break;
                case 2:
                    latLng = (LatLng) C0185a.m210a(parcel, F, LatLng.CREATOR);
                    break;
                case 3:
                    str3 = C0185a.m229o(parcel, F);
                    break;
                case 4:
                    list = C0185a.m216c(parcel, F, oa.CREATOR);
                    break;
                case 5:
                    str2 = C0185a.m229o(parcel, F);
                    break;
                case 6:
                    str = C0185a.m229o(parcel, F);
                    break;
                case 1000:
                    i = C0185a.m221g(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new oc(i, str4, latLng, str3, list, str2, str);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cU(x0);
    }

    public oc[] eQ(int i) {
        return new oc[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return eQ(x0);
    }
}
