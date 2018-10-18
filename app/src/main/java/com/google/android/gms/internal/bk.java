package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

public class bk implements Creator<bj> {
    /* renamed from: a */
    static void m1081a(bj bjVar, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, bjVar.versionCode);
        C0186b.m268c(parcel, 2, bjVar.oQ);
        C0186b.m268c(parcel, 3, bjVar.backgroundColor);
        C0186b.m268c(parcel, 4, bjVar.oR);
        C0186b.m268c(parcel, 5, bjVar.oS);
        C0186b.m268c(parcel, 6, bjVar.oT);
        C0186b.m268c(parcel, 7, bjVar.oU);
        C0186b.m268c(parcel, 8, bjVar.oV);
        C0186b.m268c(parcel, 9, bjVar.oW);
        C0186b.m256a(parcel, 10, bjVar.oX, false);
        C0186b.m268c(parcel, 11, bjVar.oY);
        C0186b.m256a(parcel, 12, bjVar.oZ, false);
        C0186b.m268c(parcel, 13, bjVar.pa);
        C0186b.m268c(parcel, 14, bjVar.pb);
        C0186b.m256a(parcel, 15, bjVar.pc, false);
        C0186b.m244H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m1082d(x0);
    }

    /* renamed from: d */
    public bj m1082d(Parcel parcel) {
        int G = C0185a.m208G(parcel);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        String str = null;
        int i10 = 0;
        String str2 = null;
        int i11 = 0;
        int i12 = 0;
        String str3 = null;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    i2 = C0185a.m221g(parcel, F);
                    break;
                case 3:
                    i3 = C0185a.m221g(parcel, F);
                    break;
                case 4:
                    i4 = C0185a.m221g(parcel, F);
                    break;
                case 5:
                    i5 = C0185a.m221g(parcel, F);
                    break;
                case 6:
                    i6 = C0185a.m221g(parcel, F);
                    break;
                case 7:
                    i7 = C0185a.m221g(parcel, F);
                    break;
                case 8:
                    i8 = C0185a.m221g(parcel, F);
                    break;
                case 9:
                    i9 = C0185a.m221g(parcel, F);
                    break;
                case 10:
                    str = C0185a.m229o(parcel, F);
                    break;
                case 11:
                    i10 = C0185a.m221g(parcel, F);
                    break;
                case 12:
                    str2 = C0185a.m229o(parcel, F);
                    break;
                case 13:
                    i11 = C0185a.m221g(parcel, F);
                    break;
                case 14:
                    i12 = C0185a.m221g(parcel, F);
                    break;
                case 15:
                    str3 = C0185a.m229o(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new bj(i, i2, i3, i4, i5, i6, i7, i8, i9, str, i10, str2, i11, i12, str3);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    /* renamed from: i */
    public bj[] m1083i(int i) {
        return new bj[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m1083i(x0);
    }
}
