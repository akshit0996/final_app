package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.internal.pi.C1425b.C1423a;
import java.util.HashSet;
import java.util.Set;

public class pm implements Creator<C1423a> {
    /* renamed from: a */
    static void m1775a(C1423a c1423a, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        Set set = c1423a.aon;
        if (set.contains(Integer.valueOf(1))) {
            C0186b.m268c(parcel, 1, c1423a.CK);
        }
        if (set.contains(Integer.valueOf(2))) {
            C0186b.m268c(parcel, 2, c1423a.apJ);
        }
        if (set.contains(Integer.valueOf(3))) {
            C0186b.m268c(parcel, 3, c1423a.apK);
        }
        C0186b.m244H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return dC(x0);
    }

    public C1423a dC(Parcel parcel) {
        int i = 0;
        int G = C0185a.m208G(parcel);
        Set hashSet = new HashSet();
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i3 = C0185a.m221g(parcel, F);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    i2 = C0185a.m221g(parcel, F);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case 3:
                    i = C0185a.m221g(parcel, F);
                    hashSet.add(Integer.valueOf(3));
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new C1423a(hashSet, i3, i2, i);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public C1423a[] fA(int i) {
        return new C1423a[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return fA(x0);
    }
}
