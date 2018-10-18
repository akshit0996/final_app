package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.location.LocationRequest;
import java.util.List;

public class nm implements Creator<nl> {
    /* renamed from: a */
    static void m1742a(nl nlVar, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m252a(parcel, 1, nlVar.We, i, false);
        C0186b.m268c(parcel, 1000, nlVar.getVersionCode());
        C0186b.m259a(parcel, 2, nlVar.ahh);
        C0186b.m259a(parcel, 3, nlVar.ahi);
        C0186b.m259a(parcel, 4, nlVar.ahj);
        C0186b.m269c(parcel, 5, nlVar.ahk, false);
        C0186b.m256a(parcel, 6, nlVar.mTag, false);
        C0186b.m244H(parcel, H);
    }

    public nl cM(Parcel parcel) {
        String str = null;
        boolean z = true;
        boolean z2 = false;
        int G = C0185a.m208G(parcel);
        List list = nl.ahg;
        boolean z3 = true;
        LocationRequest locationRequest = null;
        int i = 0;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    locationRequest = (LocationRequest) C0185a.m210a(parcel, F, LocationRequest.CREATOR);
                    break;
                case 2:
                    z2 = C0185a.m217c(parcel, F);
                    break;
                case 3:
                    z3 = C0185a.m217c(parcel, F);
                    break;
                case 4:
                    z = C0185a.m217c(parcel, F);
                    break;
                case 5:
                    list = C0185a.m216c(parcel, F, nd.CREATOR);
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
            return new nl(i, locationRequest, z2, z3, z, list, str);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cM(x0);
    }

    public nl[] eG(int i) {
        return new nl[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return eG(x0);
    }
}
