package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import java.util.List;

/* renamed from: com.google.android.gms.fitness.data.o */
public class C0296o implements Creator<RawDataSet> {
    /* renamed from: a */
    static void m553a(RawDataSet rawDataSet, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, rawDataSet.UJ);
        C0186b.m268c(parcel, 1000, rawDataSet.CK);
        C0186b.m268c(parcel, 2, rawDataSet.UL);
        C0186b.m269c(parcel, 3, rawDataSet.UM, false);
        C0186b.m259a(parcel, 4, rawDataSet.Uc);
        C0186b.m244H(parcel, H);
    }

    public RawDataSet bB(Parcel parcel) {
        boolean z = false;
        int G = C0185a.m208G(parcel);
        List list = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i2 = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 3:
                    list = C0185a.m216c(parcel, F, RawDataPoint.CREATOR);
                    break;
                case 4:
                    z = C0185a.m217c(parcel, F);
                    break;
                case 1000:
                    i3 = C0185a.m221g(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new RawDataSet(i3, i2, i, list, z);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public RawDataSet[] cU(int i) {
        return new RawDataSet[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bB(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cU(x0);
    }
}
