package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.util.TimeUtils;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.internal.pi.C1422a;
import com.google.android.gms.internal.pi.C1425b;
import com.google.android.gms.internal.pi.C1426c;
import com.google.android.gms.internal.pi.C1427d;
import com.google.android.gms.internal.pi.C1428f;
import com.google.android.gms.internal.pi.C1429g;
import com.google.android.gms.internal.pi.C1430h;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class pj implements Creator<pi> {
    /* renamed from: a */
    static void m1772a(pi piVar, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        Set set = piVar.aon;
        if (set.contains(Integer.valueOf(1))) {
            C0186b.m268c(parcel, 1, piVar.CK);
        }
        if (set.contains(Integer.valueOf(2))) {
            C0186b.m256a(parcel, 2, piVar.apl, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            C0186b.m252a(parcel, 3, piVar.apm, i, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            C0186b.m256a(parcel, 4, piVar.apn, true);
        }
        if (set.contains(Integer.valueOf(5))) {
            C0186b.m256a(parcel, 5, piVar.apo, true);
        }
        if (set.contains(Integer.valueOf(6))) {
            C0186b.m268c(parcel, 6, piVar.app);
        }
        if (set.contains(Integer.valueOf(7))) {
            C0186b.m252a(parcel, 7, piVar.apq, i, true);
        }
        if (set.contains(Integer.valueOf(8))) {
            C0186b.m256a(parcel, 8, piVar.apr, true);
        }
        if (set.contains(Integer.valueOf(9))) {
            C0186b.m256a(parcel, 9, piVar.OS, true);
        }
        if (set.contains(Integer.valueOf(12))) {
            C0186b.m268c(parcel, 12, piVar.ow);
        }
        if (set.contains(Integer.valueOf(14))) {
            C0186b.m256a(parcel, 14, piVar.CE, true);
        }
        if (set.contains(Integer.valueOf(15))) {
            C0186b.m252a(parcel, 15, piVar.aps, i, true);
        }
        if (set.contains(Integer.valueOf(16))) {
            C0186b.m259a(parcel, 16, piVar.apt);
        }
        if (set.contains(Integer.valueOf(19))) {
            C0186b.m252a(parcel, 19, piVar.apu, i, true);
        }
        if (set.contains(Integer.valueOf(18))) {
            C0186b.m256a(parcel, 18, piVar.FR, true);
        }
        if (set.contains(Integer.valueOf(21))) {
            C0186b.m268c(parcel, 21, piVar.apw);
        }
        if (set.contains(Integer.valueOf(20))) {
            C0186b.m256a(parcel, 20, piVar.apv, true);
        }
        if (set.contains(Integer.valueOf(23))) {
            C0186b.m269c(parcel, 23, piVar.apy, true);
        }
        if (set.contains(Integer.valueOf(22))) {
            C0186b.m269c(parcel, 22, piVar.apx, true);
        }
        if (set.contains(Integer.valueOf(25))) {
            C0186b.m268c(parcel, 25, piVar.apA);
        }
        if (set.contains(Integer.valueOf(24))) {
            C0186b.m268c(parcel, 24, piVar.apz);
        }
        if (set.contains(Integer.valueOf(27))) {
            C0186b.m256a(parcel, 27, piVar.vf, true);
        }
        if (set.contains(Integer.valueOf(26))) {
            C0186b.m256a(parcel, 26, piVar.apB, true);
        }
        if (set.contains(Integer.valueOf(29))) {
            C0186b.m259a(parcel, 29, piVar.apD);
        }
        if (set.contains(Integer.valueOf(28))) {
            C0186b.m269c(parcel, 28, piVar.apC, true);
        }
        C0186b.m244H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return dz(x0);
    }

    public pi dz(Parcel parcel) {
        int G = C0185a.m208G(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        String str = null;
        C1422a c1422a = null;
        String str2 = null;
        String str3 = null;
        int i2 = 0;
        C1425b c1425b = null;
        String str4 = null;
        String str5 = null;
        int i3 = 0;
        String str6 = null;
        C1426c c1426c = null;
        boolean z = false;
        String str7 = null;
        C1427d c1427d = null;
        String str8 = null;
        int i4 = 0;
        List list = null;
        List list2 = null;
        int i5 = 0;
        int i6 = 0;
        String str9 = null;
        String str10 = null;
        List list3 = null;
        boolean z2 = false;
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
                case 3:
                    C1422a c1422a2 = (C1422a) C0185a.m210a(parcel, F, C1422a.CREATOR);
                    hashSet.add(Integer.valueOf(3));
                    c1422a = c1422a2;
                    break;
                case 4:
                    str2 = C0185a.m229o(parcel, F);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case 5:
                    str3 = C0185a.m229o(parcel, F);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case 6:
                    i2 = C0185a.m221g(parcel, F);
                    hashSet.add(Integer.valueOf(6));
                    break;
                case 7:
                    C1425b c1425b2 = (C1425b) C0185a.m210a(parcel, F, C1425b.CREATOR);
                    hashSet.add(Integer.valueOf(7));
                    c1425b = c1425b2;
                    break;
                case 8:
                    str4 = C0185a.m229o(parcel, F);
                    hashSet.add(Integer.valueOf(8));
                    break;
                case 9:
                    str5 = C0185a.m229o(parcel, F);
                    hashSet.add(Integer.valueOf(9));
                    break;
                case 12:
                    i3 = C0185a.m221g(parcel, F);
                    hashSet.add(Integer.valueOf(12));
                    break;
                case 14:
                    str6 = C0185a.m229o(parcel, F);
                    hashSet.add(Integer.valueOf(14));
                    break;
                case 15:
                    C1426c c1426c2 = (C1426c) C0185a.m210a(parcel, F, C1426c.CREATOR);
                    hashSet.add(Integer.valueOf(15));
                    c1426c = c1426c2;
                    break;
                case 16:
                    z = C0185a.m217c(parcel, F);
                    hashSet.add(Integer.valueOf(16));
                    break;
                case 18:
                    str7 = C0185a.m229o(parcel, F);
                    hashSet.add(Integer.valueOf(18));
                    break;
                case TimeUtils.HUNDRED_DAY_FIELD_LEN /*19*/:
                    C1427d c1427d2 = (C1427d) C0185a.m210a(parcel, F, (Creator) C1427d.CREATOR);
                    hashSet.add(Integer.valueOf(19));
                    c1427d = c1427d2;
                    break;
                case 20:
                    str8 = C0185a.m229o(parcel, F);
                    hashSet.add(Integer.valueOf(20));
                    break;
                case 21:
                    i4 = C0185a.m221g(parcel, F);
                    hashSet.add(Integer.valueOf(21));
                    break;
                case 22:
                    list = C0185a.m216c(parcel, F, C1428f.CREATOR);
                    hashSet.add(Integer.valueOf(22));
                    break;
                case 23:
                    list2 = C0185a.m216c(parcel, F, C1429g.CREATOR);
                    hashSet.add(Integer.valueOf(23));
                    break;
                case 24:
                    i5 = C0185a.m221g(parcel, F);
                    hashSet.add(Integer.valueOf(24));
                    break;
                case 25:
                    i6 = C0185a.m221g(parcel, F);
                    hashSet.add(Integer.valueOf(25));
                    break;
                case 26:
                    str9 = C0185a.m229o(parcel, F);
                    hashSet.add(Integer.valueOf(26));
                    break;
                case 27:
                    str10 = C0185a.m229o(parcel, F);
                    hashSet.add(Integer.valueOf(27));
                    break;
                case 28:
                    list3 = C0185a.m216c(parcel, F, C1430h.CREATOR);
                    hashSet.add(Integer.valueOf(28));
                    break;
                case 29:
                    z2 = C0185a.m217c(parcel, F);
                    hashSet.add(Integer.valueOf(29));
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new pi(hashSet, i, str, c1422a, str2, str3, i2, c1425b, str4, str5, i3, str6, c1426c, z, str7, c1427d, str8, i4, list, list2, i5, i6, str9, str10, list3, z2);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public pi[] fx(int i) {
        return new pi[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return fx(x0);
    }
}
