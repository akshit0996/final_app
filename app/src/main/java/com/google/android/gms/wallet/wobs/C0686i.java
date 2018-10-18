package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.wallet.wobs.i */
public class C0686i implements Creator<C1254f> {
    /* renamed from: a */
    static void m2260a(C1254f c1254f, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, c1254f.getVersionCode());
        C0186b.m256a(parcel, 2, c1254f.label, false);
        C0186b.m252a(parcel, 3, c1254f.awM, i, false);
        C0186b.m256a(parcel, 4, c1254f.type, false);
        C0186b.m252a(parcel, 5, c1254f.avm, i, false);
        C0186b.m244H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return eg(x0);
    }

    public C1254f eg(Parcel parcel) {
        C1257l c1257l = null;
        int G = C0185a.m208G(parcel);
        int i = 0;
        String str = null;
        C1255g c1255g = null;
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
                    c1255g = (C1255g) C0185a.m210a(parcel, F, C1255g.CREATOR);
                    break;
                case 4:
                    str = C0185a.m229o(parcel, F);
                    break;
                case 5:
                    c1257l = (C1257l) C0185a.m210a(parcel, F, C1257l.CREATOR);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new C1254f(i, str2, c1255g, str, c1257l);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public C1254f[] gp(int i) {
        return new C1254f[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return gp(x0);
    }
}
