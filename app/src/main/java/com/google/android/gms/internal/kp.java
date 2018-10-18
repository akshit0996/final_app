package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.internal.ko.C1016a;
import java.util.ArrayList;

public class kp implements Creator<ko> {
    /* renamed from: a */
    static void m1604a(ko koVar, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, koVar.getVersionCode());
        C0186b.m269c(parcel, 2, koVar.hH(), false);
        C0186b.m244H(parcel, H);
    }

    /* renamed from: K */
    public ko m1605K(Parcel parcel) {
        int G = C0185a.m208G(parcel);
        int i = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    arrayList = C0185a.m216c(parcel, F, C1016a.CREATOR);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new ko(i, arrayList);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public ko[] aL(int i) {
        return new ko[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m1605K(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aL(x0);
    }
}
