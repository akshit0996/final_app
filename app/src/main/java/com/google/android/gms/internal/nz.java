package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

public class nz implements Creator<ny> {
    /* renamed from: a */
    static void m1748a(ny nyVar, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1000, nyVar.CK);
        C0186b.m252a(parcel, 2, nyVar.nt(), i, false);
        C0186b.m248a(parcel, 3, nyVar.getInterval());
        C0186b.m268c(parcel, 4, nyVar.getPriority());
        C0186b.m244H(parcel, H);
    }

    public ny cS(Parcel parcel) {
        int G = C0185a.m208G(parcel);
        int i = 0;
        nu nuVar = null;
        long j = ny.ahz;
        int i2 = 102;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 2:
                    nuVar = (nu) C0185a.m210a(parcel, F, nu.CREATOR);
                    break;
                case 3:
                    j = C0185a.m223i(parcel, F);
                    break;
                case 4:
                    i2 = C0185a.m221g(parcel, F);
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
            return new ny(i, nuVar, j, i2);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cS(x0);
    }

    public ny[] eO(int i) {
        return new ny[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return eO(x0);
    }
}
