package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.fitness.data.DataSource;

public class mt implements Creator<ms> {
    /* renamed from: a */
    static void m1689a(ms msVar, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m252a(parcel, 1, msVar.getDataSource(), i, false);
        C0186b.m268c(parcel, 1000, msVar.getVersionCode());
        C0186b.m244H(parcel, H);
    }

    public ms bH(Parcel parcel) {
        int G = C0185a.m208G(parcel);
        int i = 0;
        DataSource dataSource = null;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    dataSource = (DataSource) C0185a.m210a(parcel, F, DataSource.CREATOR);
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
            return new ms(i, dataSource);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bH(x0);
    }

    public ms[] db(int i) {
        return new ms[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return db(x0);
    }
}
