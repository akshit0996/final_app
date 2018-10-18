package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.fitness.data.DataType;

/* renamed from: com.google.android.gms.fitness.request.n */
public class C0328n implements Creator<C0882m> {
    /* renamed from: a */
    static void m637a(C0882m c0882m, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m252a(parcel, 1, c0882m.getDataType(), i, false);
        C0186b.m268c(parcel, 1000, c0882m.getVersionCode());
        C0186b.m244H(parcel, H);
    }

    public C0882m bP(Parcel parcel) {
        int G = C0185a.m208G(parcel);
        int i = 0;
        DataType dataType = null;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    dataType = (DataType) C0185a.m210a(parcel, F, DataType.CREATOR);
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
            return new C0882m(i, dataType);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bP(x0);
    }

    public C0882m[] dj(int i) {
        return new C0882m[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dj(x0);
    }
}
