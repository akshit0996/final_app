package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.internal.pi.C1428f;
import java.util.HashSet;
import java.util.Set;

public class pq implements Creator<C1428f> {
    /* renamed from: a */
    static void m1779a(C1428f c1428f, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        Set set = c1428f.aon;
        if (set.contains(Integer.valueOf(1))) {
            C0186b.m268c(parcel, 1, c1428f.CK);
        }
        if (set.contains(Integer.valueOf(2))) {
            C0186b.m256a(parcel, 2, c1428f.apP, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            C0186b.m256a(parcel, 3, c1428f.UO, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            C0186b.m256a(parcel, 4, c1428f.aoK, true);
        }
        if (set.contains(Integer.valueOf(5))) {
            C0186b.m256a(parcel, 5, c1428f.apQ, true);
        }
        if (set.contains(Integer.valueOf(6))) {
            C0186b.m256a(parcel, 6, c1428f.mName, true);
        }
        if (set.contains(Integer.valueOf(7))) {
            C0186b.m259a(parcel, 7, c1428f.apR);
        }
        if (set.contains(Integer.valueOf(8))) {
            C0186b.m256a(parcel, 8, c1428f.apa, true);
        }
        if (set.contains(Integer.valueOf(9))) {
            C0186b.m256a(parcel, 9, c1428f.OH, true);
        }
        if (set.contains(Integer.valueOf(10))) {
            C0186b.m268c(parcel, 10, c1428f.Gt);
        }
        C0186b.m244H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return dG(x0);
    }

    public C1428f dG(Parcel parcel) {
        int i = 0;
        String str = null;
        int G = C0185a.m208G(parcel);
        Set hashSet = new HashSet();
        String str2 = null;
        boolean z = false;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i2 = C0185a.m221g(parcel, F);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    str7 = C0185a.m229o(parcel, F);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case 3:
                    str6 = C0185a.m229o(parcel, F);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case 4:
                    str5 = C0185a.m229o(parcel, F);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case 5:
                    str4 = C0185a.m229o(parcel, F);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case 6:
                    str3 = C0185a.m229o(parcel, F);
                    hashSet.add(Integer.valueOf(6));
                    break;
                case 7:
                    z = C0185a.m217c(parcel, F);
                    hashSet.add(Integer.valueOf(7));
                    break;
                case 8:
                    str2 = C0185a.m229o(parcel, F);
                    hashSet.add(Integer.valueOf(8));
                    break;
                case 9:
                    str = C0185a.m229o(parcel, F);
                    hashSet.add(Integer.valueOf(9));
                    break;
                case 10:
                    i = C0185a.m221g(parcel, F);
                    hashSet.add(Integer.valueOf(10));
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new C1428f(hashSet, i2, str7, str6, str5, str4, str3, z, str2, str, i);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public C1428f[] fE(int i) {
        return new C1428f[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return fE(x0);
    }
}
