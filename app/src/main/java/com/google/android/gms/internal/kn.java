package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

public class kn implements Creator<km> {
    /* renamed from: a */
    static void m1602a(km kmVar, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, kmVar.getVersionCode());
        C0186b.m252a(parcel, 2, kmVar.hF(), i, false);
        C0186b.m244H(parcel, H);
    }

    /* renamed from: J */
    public km m1603J(Parcel parcel) {
        int G = C0185a.m208G(parcel);
        int i = 0;
        ko koVar = null;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    koVar = (ko) C0185a.m210a(parcel, F, ko.CREATOR);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new km(i, koVar);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public km[] aK(int i) {
        return new km[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m1603J(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aK(x0);
    }
}
