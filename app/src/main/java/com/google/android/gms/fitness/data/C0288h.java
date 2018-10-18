package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import java.util.List;

/* renamed from: com.google.android.gms.fitness.data.h */
public class C0288h implements Creator<DataType> {
    /* renamed from: a */
    static void m544a(DataType dataType, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m256a(parcel, 1, dataType.getName(), false);
        C0186b.m268c(parcel, 1000, dataType.getVersionCode());
        C0186b.m269c(parcel, 2, dataType.getFields(), false);
        C0186b.m244H(parcel, H);
    }

    public DataType bw(Parcel parcel) {
        List list = null;
        int G = C0185a.m208G(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    str = C0185a.m229o(parcel, F);
                    break;
                case 2:
                    list = C0185a.m216c(parcel, F, Field.CREATOR);
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
            return new DataType(i, str, list);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public DataType[] cP(int i) {
        return new DataType[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bw(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cP(x0);
    }
}
