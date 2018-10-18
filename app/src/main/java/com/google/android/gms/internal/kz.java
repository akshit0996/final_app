package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

public class kz implements Creator<ky> {
    /* renamed from: a */
    static void m1621a(ky kyVar, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, kyVar.getVersionCode());
        C0186b.m251a(parcel, 2, kyVar.ic(), false);
        C0186b.m252a(parcel, 3, kyVar.id(), i, false);
        C0186b.m244H(parcel, H);
    }

    /* renamed from: Q */
    public ky m1622Q(Parcel parcel) {
        kv kvVar = null;
        int G = C0185a.m208G(parcel);
        int i = 0;
        Parcel parcel2 = null;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    parcel2 = C0185a.m205D(parcel, F);
                    break;
                case 3:
                    kvVar = (kv) C0185a.m210a(parcel, F, kv.CREATOR);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new ky(i, parcel2, kvVar);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public ky[] aR(int i) {
        return new ky[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m1622Q(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aR(x0);
    }
}
