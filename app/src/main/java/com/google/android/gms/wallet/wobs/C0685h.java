package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.wallet.wobs.h */
public class C0685h implements Creator<C1255g> {
    /* renamed from: a */
    static void m2259a(C1255g c1255g, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, c1255g.getVersionCode());
        C0186b.m268c(parcel, 2, c1255g.awN);
        C0186b.m256a(parcel, 3, c1255g.awO, false);
        C0186b.m246a(parcel, 4, c1255g.awP);
        C0186b.m256a(parcel, 5, c1255g.awQ, false);
        C0186b.m248a(parcel, 6, c1255g.awR);
        C0186b.m268c(parcel, 7, c1255g.awS);
        C0186b.m244H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ef(x0);
    }

    public C1255g ef(Parcel parcel) {
        String str = null;
        int i = 0;
        int G = C0185a.m208G(parcel);
        double d = 0.0d;
        long j = 0;
        int i2 = -1;
        String str2 = null;
        int i3 = 0;
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
                    str2 = C0185a.m229o(parcel, F);
                    break;
                case 4:
                    d = C0185a.m227m(parcel, F);
                    break;
                case 5:
                    str = C0185a.m229o(parcel, F);
                    break;
                case 6:
                    j = C0185a.m223i(parcel, F);
                    break;
                case 7:
                    i2 = C0185a.m221g(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new C1255g(i3, i, str2, d, str, j, i2);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public C1255g[] go(int i) {
        return new C1255g[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return go(x0);
    }
}
