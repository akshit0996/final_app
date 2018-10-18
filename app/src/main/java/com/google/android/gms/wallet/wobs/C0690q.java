package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.wallet.wobs.q */
public class C0690q implements Creator<C1259p> {
    /* renamed from: a */
    static void m2264a(C1259p c1259p, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, c1259p.getVersionCode());
        C0186b.m256a(parcel, 2, c1259p.awT, false);
        C0186b.m256a(parcel, 3, c1259p.tU, false);
        C0186b.m252a(parcel, 4, c1259p.awX, i, false);
        C0186b.m252a(parcel, 5, c1259p.awY, i, false);
        C0186b.m252a(parcel, 6, c1259p.awZ, i, false);
        C0186b.m244H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ek(x0);
    }

    public C1259p ek(Parcel parcel) {
        C1258n c1258n = null;
        int G = C0185a.m208G(parcel);
        int i = 0;
        C1258n c1258n2 = null;
        C1257l c1257l = null;
        String str = null;
        String str2 = null;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    str2 = C0185a.m229o(parcel, F);
                    break;
                case 3:
                    str = C0185a.m229o(parcel, F);
                    break;
                case 4:
                    c1257l = (C1257l) C0185a.m210a(parcel, F, C1257l.CREATOR);
                    break;
                case 5:
                    c1258n2 = (C1258n) C0185a.m210a(parcel, F, C1258n.CREATOR);
                    break;
                case 6:
                    c1258n = (C1258n) C0185a.m210a(parcel, F, C1258n.CREATOR);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new C1259p(i, str2, str, c1257l, c1258n2, c1258n);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public C1259p[] gt(int i) {
        return new C1259p[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return gt(x0);
    }
}
