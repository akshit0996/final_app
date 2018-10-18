package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import java.util.HashSet;
import java.util.Set;

public class pg implements Creator<pf> {
    /* renamed from: a */
    static void m1771a(pf pfVar, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        Set set = pfVar.aon;
        if (set.contains(Integer.valueOf(1))) {
            C0186b.m268c(parcel, 1, pfVar.CK);
        }
        if (set.contains(Integer.valueOf(2))) {
            C0186b.m256a(parcel, 2, pfVar.CE, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            C0186b.m252a(parcel, 4, pfVar.api, i, true);
        }
        if (set.contains(Integer.valueOf(5))) {
            C0186b.m256a(parcel, 5, pfVar.apa, true);
        }
        if (set.contains(Integer.valueOf(6))) {
            C0186b.m252a(parcel, 6, pfVar.apj, i, true);
        }
        if (set.contains(Integer.valueOf(7))) {
            C0186b.m256a(parcel, 7, pfVar.vc, true);
        }
        C0186b.m244H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return dy(x0);
    }

    public pf dy(Parcel parcel) {
        String str = null;
        int G = C0185a.m208G(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        pd pdVar = null;
        String str2 = null;
        pd pdVar2 = null;
        String str3 = null;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            pd pdVar3;
            switch (C0185a.aH(F)) {
                case 1:
                    i = C0185a.m221g(parcel, F);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    str3 = C0185a.m229o(parcel, F);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case 4:
                    pdVar3 = (pd) C0185a.m210a(parcel, F, pd.CREATOR);
                    hashSet.add(Integer.valueOf(4));
                    pdVar2 = pdVar3;
                    break;
                case 5:
                    str2 = C0185a.m229o(parcel, F);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case 6:
                    pdVar3 = (pd) C0185a.m210a(parcel, F, pd.CREATOR);
                    hashSet.add(Integer.valueOf(6));
                    pdVar = pdVar3;
                    break;
                case 7:
                    str = C0185a.m229o(parcel, F);
                    hashSet.add(Integer.valueOf(7));
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new pf(hashSet, i, str3, pdVar2, str2, pdVar, str);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public pf[] fw(int i) {
        return new pf[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return fw(x0);
    }
}
