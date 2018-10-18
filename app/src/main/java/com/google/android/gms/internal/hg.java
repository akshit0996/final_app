package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

public class hg implements Creator<hf> {
    /* renamed from: a */
    static void m1388a(hf hfVar, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m256a(parcel, 1, hfVar.CS, false);
        C0186b.m268c(parcel, 1000, hfVar.CK);
        C0186b.m256a(parcel, 2, hfVar.CT, false);
        C0186b.m256a(parcel, 3, hfVar.CU, false);
        C0186b.m244H(parcel, H);
    }

    /* renamed from: K */
    public hf[] m1389K(int i) {
        return new hf[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m1390m(x0);
    }

    /* renamed from: m */
    public hf m1390m(Parcel parcel) {
        String str = null;
        int G = C0185a.m208G(parcel);
        int i = 0;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    str3 = C0185a.m229o(parcel, F);
                    break;
                case 2:
                    str2 = C0185a.m229o(parcel, F);
                    break;
                case 3:
                    str = C0185a.m229o(parcel, F);
                    break;
                case 1000:
                    i = C0185a.m221g(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new hf(i, str3, str2, str);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m1389K(x0);
    }
}
