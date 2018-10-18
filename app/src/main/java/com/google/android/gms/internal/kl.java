package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

public class kl implements Creator<kk> {
    /* renamed from: a */
    static void m1600a(kk kkVar, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, kkVar.CK);
        C0186b.m256a(parcel, 2, kkVar.ND, false);
        C0186b.m268c(parcel, 3, kkVar.NE);
        C0186b.m244H(parcel, H);
    }

    /* renamed from: I */
    public kk m1601I(Parcel parcel) {
        int i = 0;
        int G = C0185a.m208G(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i2 = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    str = C0185a.m229o(parcel, F);
                    break;
                case 3:
                    i = C0185a.m221g(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new kk(i2, str, i);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public kk[] aJ(int i) {
        return new kk[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m1601I(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aJ(x0);
    }
}
