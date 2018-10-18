package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.fitness.data.DataSet;

/* renamed from: com.google.android.gms.fitness.request.f */
public class C0320f implements Creator<C0878e> {
    /* renamed from: a */
    static void m630a(C0878e c0878e, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m252a(parcel, 1, c0878e.jH(), i, false);
        C0186b.m268c(parcel, 1000, c0878e.getVersionCode());
        C0186b.m244H(parcel, H);
    }

    public C0878e bK(Parcel parcel) {
        int G = C0185a.m208G(parcel);
        int i = 0;
        DataSet dataSet = null;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    dataSet = (DataSet) C0185a.m210a(parcel, F, DataSet.CREATOR);
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
            return new C0878e(i, dataSet);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bK(x0);
    }

    public C0878e[] de(int i) {
        return new C0878e[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return de(x0);
    }
}
