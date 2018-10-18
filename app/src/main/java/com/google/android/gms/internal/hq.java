package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

public class hq implements Creator<hp> {
    /* renamed from: a */
    static void m1407a(hp hpVar, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m256a(parcel, 1, hpVar.name, false);
        C0186b.m268c(parcel, 1000, hpVar.CK);
        C0186b.m256a(parcel, 2, hpVar.Dh, false);
        C0186b.m259a(parcel, 3, hpVar.Di);
        C0186b.m268c(parcel, 4, hpVar.weight);
        C0186b.m259a(parcel, 5, hpVar.Dj);
        C0186b.m256a(parcel, 6, hpVar.Dk, false);
        C0186b.m262a(parcel, 7, hpVar.Dl, i, false);
        C0186b.m261a(parcel, 8, hpVar.Dm, false);
        C0186b.m256a(parcel, 11, hpVar.Dn, false);
        C0186b.m244H(parcel, H);
    }

    /* renamed from: R */
    public hp[] m1408R(int i) {
        return new hp[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m1409r(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m1408R(x0);
    }

    /* renamed from: r */
    public hp m1409r(Parcel parcel) {
        boolean z = false;
        String str = null;
        int G = C0185a.m208G(parcel);
        int i = 1;
        int[] iArr = null;
        hj[] hjVarArr = null;
        String str2 = null;
        boolean z2 = false;
        String str3 = null;
        String str4 = null;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    str4 = C0185a.m229o(parcel, F);
                    break;
                case 2:
                    str3 = C0185a.m229o(parcel, F);
                    break;
                case 3:
                    z2 = C0185a.m217c(parcel, F);
                    break;
                case 4:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 5:
                    z = C0185a.m217c(parcel, F);
                    break;
                case 6:
                    str2 = C0185a.m229o(parcel, F);
                    break;
                case 7:
                    hjVarArr = (hj[]) C0185a.m215b(parcel, F, hj.CREATOR);
                    break;
                case 8:
                    iArr = C0185a.m235u(parcel, F);
                    break;
                case 11:
                    str = C0185a.m229o(parcel, F);
                    break;
                case 1000:
                    i2 = C0185a.m221g(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new hp(i2, str4, str3, z2, i, z, str2, hjVarArr, iArr, str);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }
}
