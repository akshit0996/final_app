package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.internal.pi.C1427d;
import java.util.HashSet;
import java.util.Set;

public class pp implements Creator<C1427d> {
    /* renamed from: a */
    static void m1778a(C1427d c1427d, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        Set set = c1427d.aon;
        if (set.contains(Integer.valueOf(1))) {
            C0186b.m268c(parcel, 1, c1427d.CK);
        }
        if (set.contains(Integer.valueOf(2))) {
            C0186b.m256a(parcel, 2, c1427d.aoL, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            C0186b.m256a(parcel, 3, c1427d.apL, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            C0186b.m256a(parcel, 4, c1427d.aoO, true);
        }
        if (set.contains(Integer.valueOf(5))) {
            C0186b.m256a(parcel, 5, c1427d.apM, true);
        }
        if (set.contains(Integer.valueOf(6))) {
            C0186b.m256a(parcel, 6, c1427d.apN, true);
        }
        if (set.contains(Integer.valueOf(7))) {
            C0186b.m256a(parcel, 7, c1427d.apO, true);
        }
        C0186b.m244H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return dF(x0);
    }

    public C1427d dF(Parcel parcel) {
        String str = null;
        int G = C0185a.m208G(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i = C0185a.m221g(parcel, F);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    str6 = C0185a.m229o(parcel, F);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case 3:
                    str5 = C0185a.m229o(parcel, F);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case 4:
                    str4 = C0185a.m229o(parcel, F);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case 5:
                    str3 = C0185a.m229o(parcel, F);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case 6:
                    str2 = C0185a.m229o(parcel, F);
                    hashSet.add(Integer.valueOf(6));
                    break;
                case 7:
                    str = C0185a.m229o(parcel, F);
                    hashSet.add(Integer.valueOf(7));
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new C1427d(hashSet, i, str6, str5, str4, str3, str2, str);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public C1427d[] fD(int i) {
        return new C1427d[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return fD(x0);
    }
}
