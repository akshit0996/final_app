package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

public class gt implements Creator<gs> {
    /* renamed from: a */
    static void m1347a(gs gsVar, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, gsVar.versionCode);
        C0186b.m256a(parcel, 2, gsVar.wS, false);
        C0186b.m268c(parcel, 3, gsVar.wT);
        C0186b.m268c(parcel, 4, gsVar.wU);
        C0186b.m259a(parcel, 5, gsVar.wV);
        C0186b.m244H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m1348j(x0);
    }

    /* renamed from: j */
    public gs m1348j(Parcel parcel) {
        boolean z = false;
        int G = C0185a.m208G(parcel);
        String str = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i3 = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    str = C0185a.m229o(parcel, F);
                    break;
                case 3:
                    i2 = C0185a.m221g(parcel, F);
                    break;
                case 4:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 5:
                    z = C0185a.m217c(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new gs(i3, str, i2, i, z);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m1349w(x0);
    }

    /* renamed from: w */
    public gs[] m1349w(int i) {
        return new gs[i];
    }
}
