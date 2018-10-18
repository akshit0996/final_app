package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.internal.kr.C1017a;
import com.google.android.gms.internal.kv.C1019b;

public class ku implements Creator<C1019b> {
    /* renamed from: a */
    static void m1615a(C1019b c1019b, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, c1019b.versionCode);
        C0186b.m256a(parcel, 2, c1019b.fv, false);
        C0186b.m252a(parcel, 3, c1019b.NZ, i, false);
        C0186b.m244H(parcel, H);
    }

    /* renamed from: N */
    public C1019b m1616N(Parcel parcel) {
        C1017a c1017a = null;
        int G = C0185a.m208G(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    str = C0185a.m229o(parcel, F);
                    break;
                case 3:
                    c1017a = (C1017a) C0185a.m210a(parcel, F, C1017a.CREATOR);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new C1019b(i, str, c1017a);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public C1019b[] aO(int i) {
        return new C1019b[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m1616N(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aO(x0);
    }
}
