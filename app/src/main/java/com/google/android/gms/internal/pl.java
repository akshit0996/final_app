package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.internal.pi.C1425b;
import com.google.android.gms.internal.pi.C1425b.C1423a;
import com.google.android.gms.internal.pi.C1425b.C1424b;
import java.util.HashSet;
import java.util.Set;

public class pl implements Creator<C1425b> {
    /* renamed from: a */
    static void m1774a(C1425b c1425b, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        Set set = c1425b.aon;
        if (set.contains(Integer.valueOf(1))) {
            C0186b.m268c(parcel, 1, c1425b.CK);
        }
        if (set.contains(Integer.valueOf(2))) {
            C0186b.m252a(parcel, 2, c1425b.apG, i, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            C0186b.m252a(parcel, 3, c1425b.apH, i, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            C0186b.m268c(parcel, 4, c1425b.apI);
        }
        C0186b.m244H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return dB(x0);
    }

    public C1425b dB(Parcel parcel) {
        C1424b c1424b = null;
        int i = 0;
        int G = C0185a.m208G(parcel);
        Set hashSet = new HashSet();
        C1423a c1423a = null;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i2 = C0185a.m221g(parcel, F);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    C1423a c1423a2 = (C1423a) C0185a.m210a(parcel, F, C1423a.CREATOR);
                    hashSet.add(Integer.valueOf(2));
                    c1423a = c1423a2;
                    break;
                case 3:
                    C1424b c1424b2 = (C1424b) C0185a.m210a(parcel, F, C1424b.CREATOR);
                    hashSet.add(Integer.valueOf(3));
                    c1424b = c1424b2;
                    break;
                case 4:
                    i = C0185a.m221g(parcel, F);
                    hashSet.add(Integer.valueOf(4));
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new C1425b(hashSet, i2, c1423a, c1424b, i);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public C1425b[] fz(int i) {
        return new C1425b[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return fz(x0);
    }
}
