package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import java.util.List;

public class nr implements Creator<nq> {
    /* renamed from: a */
    static void m1744a(nq nqVar, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m259a(parcel, 1, nqVar.nr());
        C0186b.m268c(parcel, 1000, nqVar.CK);
        C0186b.m269c(parcel, 2, nqVar.ahn, false);
        C0186b.m244H(parcel, H);
    }

    public nq cO(Parcel parcel) {
        boolean z = false;
        int G = C0185a.m208G(parcel);
        List list = null;
        int i = 0;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    z = C0185a.m217c(parcel, F);
                    break;
                case 2:
                    list = C0185a.m216c(parcel, F, oa.CREATOR);
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
            return new nq(i, z, list);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cO(x0);
    }

    public nq[] eK(int i) {
        return new nq[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return eK(x0);
    }
}
