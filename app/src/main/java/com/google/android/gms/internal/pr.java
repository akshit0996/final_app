package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.internal.pi.C1429g;
import java.util.HashSet;
import java.util.Set;

public class pr implements Creator<C1429g> {
    /* renamed from: a */
    static void m1780a(C1429g c1429g, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        Set set = c1429g.aon;
        if (set.contains(Integer.valueOf(1))) {
            C0186b.m268c(parcel, 1, c1429g.CK);
        }
        if (set.contains(Integer.valueOf(2))) {
            C0186b.m259a(parcel, 2, c1429g.apR);
        }
        if (set.contains(Integer.valueOf(3))) {
            C0186b.m256a(parcel, 3, c1429g.mValue, true);
        }
        C0186b.m244H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return dH(x0);
    }

    public C1429g dH(Parcel parcel) {
        boolean z = false;
        int G = C0185a.m208G(parcel);
        Set hashSet = new HashSet();
        String str = null;
        int i = 0;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i = C0185a.m221g(parcel, F);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    z = C0185a.m217c(parcel, F);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case 3:
                    str = C0185a.m229o(parcel, F);
                    hashSet.add(Integer.valueOf(3));
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new C1429g(hashSet, i, z, str);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public C1429g[] fF(int i) {
        return new C1429g[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return fF(x0);
    }
}
