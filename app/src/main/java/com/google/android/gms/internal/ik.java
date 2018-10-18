package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

public class ik implements Creator<ij> {
    /* renamed from: a */
    static void m1442a(ij ijVar, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, ijVar.getVersionCode());
        C0186b.m256a(parcel, 2, ijVar.fT(), false);
        C0186b.m244H(parcel, H);
    }

    public ij[] ac(int i) {
        return new ij[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m1443x(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ac(x0);
    }

    /* renamed from: x */
    public ij m1443x(Parcel parcel) {
        int G = C0185a.m208G(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    str = C0185a.m229o(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new ij(i, str);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }
}
