package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.location.f */
public class C0521f implements Creator<C1087e> {
    /* renamed from: a */
    static void m1943a(C1087e c1087e, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, c1087e.agw);
        C0186b.m268c(parcel, 1000, c1087e.getVersionCode());
        C0186b.m268c(parcel, 2, c1087e.agx);
        C0186b.m248a(parcel, 3, c1087e.agy);
        C0186b.m244H(parcel, H);
    }

    public C1087e cK(Parcel parcel) {
        int i = 1;
        int G = C0185a.m208G(parcel);
        int i2 = 0;
        long j = 0;
        int i3 = 1;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i3 = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 3:
                    j = C0185a.m223i(parcel, F);
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
            return new C1087e(i2, i3, i, j);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cK(x0);
    }

    public C1087e[] eE(int i) {
        return new C1087e[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return eE(x0);
    }
}
