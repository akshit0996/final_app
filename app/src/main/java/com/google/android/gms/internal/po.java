package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.internal.pi.C1426c;
import java.util.HashSet;
import java.util.Set;

public class po implements Creator<C1426c> {
    /* renamed from: a */
    static void m1777a(C1426c c1426c, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        Set set = c1426c.aon;
        if (set.contains(Integer.valueOf(1))) {
            C0186b.m268c(parcel, 1, c1426c.CK);
        }
        if (set.contains(Integer.valueOf(2))) {
            C0186b.m256a(parcel, 2, c1426c.vf, true);
        }
        C0186b.m244H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return dE(x0);
    }

    public C1426c dE(Parcel parcel) {
        int G = C0185a.m208G(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i = C0185a.m221g(parcel, F);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    str = C0185a.m229o(parcel, F);
                    hashSet.add(Integer.valueOf(2));
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new C1426c(hashSet, i, str);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public C1426c[] fC(int i) {
        return new C1426c[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return fC(x0);
    }
}
