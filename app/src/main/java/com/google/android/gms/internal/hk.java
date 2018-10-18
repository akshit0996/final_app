package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

public class hk implements Creator<hj> {
    /* renamed from: a */
    static void m1394a(hj hjVar, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, hjVar.id);
        C0186b.m268c(parcel, 1000, hjVar.CK);
        C0186b.m249a(parcel, 2, hjVar.Db, false);
        C0186b.m244H(parcel, H);
    }

    /* renamed from: M */
    public hj[] m1395M(int i) {
        return new hj[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m1396o(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m1395M(x0);
    }

    /* renamed from: o */
    public hj m1396o(Parcel parcel) {
        int i = 0;
        int G = C0185a.m208G(parcel);
        Bundle bundle = null;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    bundle = C0185a.m231q(parcel, F);
                    break;
                case 1000:
                    i2 = C0185a.m221g(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new hj(i2, i, bundle);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }
}
