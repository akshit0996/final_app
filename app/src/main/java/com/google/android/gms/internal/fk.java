package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.util.TimeUtils;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import java.util.List;

public class fk implements Creator<fj> {
    /* renamed from: a */
    static void m1212a(fj fjVar, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, fjVar.versionCode);
        C0186b.m256a(parcel, 2, fjVar.sg, false);
        C0186b.m256a(parcel, 3, fjVar.tU, false);
        C0186b.m267b(parcel, 4, fjVar.qw, false);
        C0186b.m268c(parcel, 5, fjVar.errorCode);
        C0186b.m267b(parcel, 6, fjVar.qx, false);
        C0186b.m248a(parcel, 7, fjVar.tV);
        C0186b.m259a(parcel, 8, fjVar.tW);
        C0186b.m248a(parcel, 9, fjVar.tX);
        C0186b.m267b(parcel, 10, fjVar.tY, false);
        C0186b.m248a(parcel, 11, fjVar.qA);
        C0186b.m268c(parcel, 12, fjVar.orientation);
        C0186b.m256a(parcel, 13, fjVar.tZ, false);
        C0186b.m248a(parcel, 14, fjVar.ua);
        C0186b.m256a(parcel, 15, fjVar.ub, false);
        C0186b.m256a(parcel, 19, fjVar.ud, false);
        C0186b.m259a(parcel, 18, fjVar.uc);
        C0186b.m256a(parcel, 21, fjVar.ue, false);
        C0186b.m259a(parcel, 23, fjVar.ug);
        C0186b.m259a(parcel, 22, fjVar.uf);
        C0186b.m259a(parcel, 25, fjVar.uh);
        C0186b.m259a(parcel, 24, fjVar.tT);
        C0186b.m244H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m1213i(x0);
    }

    /* renamed from: i */
    public fj m1213i(Parcel parcel) {
        int G = C0185a.m208G(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        List list = null;
        int i2 = 0;
        List list2 = null;
        long j = 0;
        boolean z = false;
        long j2 = 0;
        List list3 = null;
        long j3 = 0;
        int i3 = 0;
        String str3 = null;
        long j4 = 0;
        String str4 = null;
        boolean z2 = false;
        String str5 = null;
        String str6 = null;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    str = C0185a.m229o(parcel, F);
                    break;
                case 3:
                    str2 = C0185a.m229o(parcel, F);
                    break;
                case 4:
                    list = C0185a.m204C(parcel, F);
                    break;
                case 5:
                    i2 = C0185a.m221g(parcel, F);
                    break;
                case 6:
                    list2 = C0185a.m204C(parcel, F);
                    break;
                case 7:
                    j = C0185a.m223i(parcel, F);
                    break;
                case 8:
                    z = C0185a.m217c(parcel, F);
                    break;
                case 9:
                    j2 = C0185a.m223i(parcel, F);
                    break;
                case 10:
                    list3 = C0185a.m204C(parcel, F);
                    break;
                case 11:
                    j3 = C0185a.m223i(parcel, F);
                    break;
                case 12:
                    i3 = C0185a.m221g(parcel, F);
                    break;
                case 13:
                    str3 = C0185a.m229o(parcel, F);
                    break;
                case 14:
                    j4 = C0185a.m223i(parcel, F);
                    break;
                case 15:
                    str4 = C0185a.m229o(parcel, F);
                    break;
                case 18:
                    z2 = C0185a.m217c(parcel, F);
                    break;
                case TimeUtils.HUNDRED_DAY_FIELD_LEN /*19*/:
                    str5 = C0185a.m229o(parcel, F);
                    break;
                case 21:
                    str6 = C0185a.m229o(parcel, F);
                    break;
                case 22:
                    z3 = C0185a.m217c(parcel, F);
                    break;
                case 23:
                    z4 = C0185a.m217c(parcel, F);
                    break;
                case 24:
                    z5 = C0185a.m217c(parcel, F);
                    break;
                case 25:
                    z6 = C0185a.m217c(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new fj(i, str, str2, list, i2, list2, j, z, j2, list3, j3, i3, str3, j4, str4, z2, str5, str6, z3, z4, z5, z6);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m1214r(x0);
    }

    /* renamed from: r */
    public fj[] m1214r(int i) {
        return new fj[i];
    }
}
