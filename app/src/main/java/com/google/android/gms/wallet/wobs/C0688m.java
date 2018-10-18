package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.wallet.wobs.m */
public class C0688m implements Creator<C1257l> {
    /* renamed from: a */
    static void m2262a(C1257l c1257l, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, c1257l.getVersionCode());
        C0186b.m248a(parcel, 2, c1257l.awU);
        C0186b.m248a(parcel, 3, c1257l.awV);
        C0186b.m244H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ei(x0);
    }

    public C1257l ei(Parcel parcel) {
        long j = 0;
        int G = C0185a.m208G(parcel);
        int i = 0;
        long j2 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    j2 = C0185a.m223i(parcel, F);
                    break;
                case 3:
                    j = C0185a.m223i(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new C1257l(i, j2, j);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public C1257l[] gr(int i) {
        return new C1257l[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return gr(x0);
    }
}
