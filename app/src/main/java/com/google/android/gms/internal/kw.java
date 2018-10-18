package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.internal.kv.C1018a;
import java.util.ArrayList;

public class kw implements Creator<kv> {
    /* renamed from: a */
    static void m1617a(kv kvVar, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, kvVar.getVersionCode());
        C0186b.m269c(parcel, 2, kvVar.hZ(), false);
        C0186b.m256a(parcel, 3, kvVar.ia(), false);
        C0186b.m244H(parcel, H);
    }

    /* renamed from: O */
    public kv m1618O(Parcel parcel) {
        String str = null;
        int G = C0185a.m208G(parcel);
        int i = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    arrayList = C0185a.m216c(parcel, F, C1018a.CREATOR);
                    break;
                case 3:
                    str = C0185a.m229o(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new kv(i, arrayList, str);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public kv[] aP(int i) {
        return new kv[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m1618O(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aP(x0);
    }
}
