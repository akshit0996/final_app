package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

public class hs implements Creator<hr> {
    /* renamed from: a */
    static void m1410a(hr hrVar, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m252a(parcel, 1, hrVar.Dw, i, false);
        C0186b.m268c(parcel, 1000, hrVar.CK);
        C0186b.m248a(parcel, 2, hrVar.Dx);
        C0186b.m268c(parcel, 3, hrVar.Dy);
        C0186b.m256a(parcel, 4, hrVar.pc, false);
        C0186b.m252a(parcel, 5, hrVar.Dz, i, false);
        C0186b.m244H(parcel, H);
    }

    /* renamed from: S */
    public hr[] m1411S(int i) {
        return new hr[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m1412s(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m1411S(x0);
    }

    /* renamed from: s */
    public hr m1412s(Parcel parcel) {
        int i = 0;
        hd hdVar = null;
        int G = C0185a.m208G(parcel);
        long j = 0;
        String str = null;
        hf hfVar = null;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    hfVar = (hf) C0185a.m210a(parcel, F, hf.CREATOR);
                    break;
                case 2:
                    j = C0185a.m223i(parcel, F);
                    break;
                case 3:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 4:
                    str = C0185a.m229o(parcel, F);
                    break;
                case 5:
                    hdVar = (hd) C0185a.m210a(parcel, F, hd.CREATOR);
                    break;
                case 1000:
                    i2 = C0185a.m221g(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new hr(i2, hfVar, j, i, str, hdVar);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }
}
