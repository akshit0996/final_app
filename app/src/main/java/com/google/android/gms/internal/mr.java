package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.fitness.data.DataType;
import java.util.List;

public class mr implements Creator<mq> {
    /* renamed from: a */
    static void m1688a(mq mqVar, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m269c(parcel, 1, mqVar.getDataTypes(), false);
        C0186b.m268c(parcel, 1000, mqVar.getVersionCode());
        C0186b.m244H(parcel, H);
    }

    public mq bG(Parcel parcel) {
        int G = C0185a.m208G(parcel);
        int i = 0;
        List list = null;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    list = C0185a.m216c(parcel, F, DataType.CREATOR);
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
            return new mq(i, list);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bG(x0);
    }

    public mq[] da(int i) {
        return new mq[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return da(x0);
    }
}
