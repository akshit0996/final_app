package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.internal.pi.C1430h;
import java.util.HashSet;
import java.util.Set;

public class ps implements Creator<C1430h> {
    /* renamed from: a */
    static void m1781a(C1430h c1430h, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        Set set = c1430h.aon;
        if (set.contains(Integer.valueOf(1))) {
            C0186b.m268c(parcel, 1, c1430h.CK);
        }
        if (set.contains(Integer.valueOf(3))) {
            C0186b.m268c(parcel, 3, c1430h.oU());
        }
        if (set.contains(Integer.valueOf(4))) {
            C0186b.m256a(parcel, 4, c1430h.mValue, true);
        }
        if (set.contains(Integer.valueOf(5))) {
            C0186b.m256a(parcel, 5, c1430h.XL, true);
        }
        if (set.contains(Integer.valueOf(6))) {
            C0186b.m268c(parcel, 6, c1430h.Gt);
        }
        C0186b.m244H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return dI(x0);
    }

    public C1430h dI(Parcel parcel) {
        String str = null;
        int i = 0;
        int G = C0185a.m208G(parcel);
        Set hashSet = new HashSet();
        int i2 = 0;
        String str2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i3 = C0185a.m221g(parcel, F);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 3:
                    i = C0185a.m221g(parcel, F);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case 4:
                    str = C0185a.m229o(parcel, F);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case 5:
                    str2 = C0185a.m229o(parcel, F);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case 6:
                    i2 = C0185a.m221g(parcel, F);
                    hashSet.add(Integer.valueOf(6));
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new C1430h(hashSet, i3, str2, i2, str, i);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public C1430h[] fG(int i) {
        return new C1430h[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return fG(x0);
    }
}
