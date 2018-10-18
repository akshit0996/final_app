package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.internal.kv.C1018a;
import com.google.android.gms.internal.kv.C1019b;
import java.util.ArrayList;

public class kx implements Creator<C1018a> {
    /* renamed from: a */
    static void m1619a(C1018a c1018a, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, c1018a.versionCode);
        C0186b.m256a(parcel, 2, c1018a.className, false);
        C0186b.m269c(parcel, 3, c1018a.NY, false);
        C0186b.m244H(parcel, H);
    }

    /* renamed from: P */
    public C1018a m1620P(Parcel parcel) {
        ArrayList arrayList = null;
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
                    arrayList = C0185a.m216c(parcel, F, C1019b.CREATOR);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new C1018a(i, str, arrayList);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public C1018a[] aQ(int i) {
        return new C1018a[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m1620P(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aQ(x0);
    }
}
