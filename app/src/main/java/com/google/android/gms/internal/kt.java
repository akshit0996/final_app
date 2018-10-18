package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.internal.kr.C1017a;

public class kt implements Creator<C1017a> {
    /* renamed from: a */
    static void m1613a(C1017a c1017a, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, c1017a.getVersionCode());
        C0186b.m268c(parcel, 2, c1017a.hI());
        C0186b.m259a(parcel, 3, c1017a.hO());
        C0186b.m268c(parcel, 4, c1017a.hJ());
        C0186b.m259a(parcel, 5, c1017a.hP());
        C0186b.m256a(parcel, 6, c1017a.hQ(), false);
        C0186b.m268c(parcel, 7, c1017a.hR());
        C0186b.m256a(parcel, 8, c1017a.hT(), false);
        C0186b.m252a(parcel, 9, c1017a.hV(), i, false);
        C0186b.m244H(parcel, H);
    }

    /* renamed from: M */
    public C1017a m1614M(Parcel parcel) {
        km kmVar = null;
        int i = 0;
        int G = C0185a.m208G(parcel);
        String str = null;
        String str2 = null;
        boolean z = false;
        int i2 = 0;
        boolean z2 = false;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i4 = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    i3 = C0185a.m221g(parcel, F);
                    break;
                case 3:
                    z2 = C0185a.m217c(parcel, F);
                    break;
                case 4:
                    i2 = C0185a.m221g(parcel, F);
                    break;
                case 5:
                    z = C0185a.m217c(parcel, F);
                    break;
                case 6:
                    str2 = C0185a.m229o(parcel, F);
                    break;
                case 7:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 8:
                    str = C0185a.m229o(parcel, F);
                    break;
                case 9:
                    kmVar = (km) C0185a.m210a(parcel, F, km.CREATOR);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new C1017a(i4, i3, z2, i2, z, str2, i, str, kmVar);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public C1017a[] aN(int i) {
        return new C1017a[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m1614M(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aN(x0);
    }
}
