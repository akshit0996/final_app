package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.fitness.data.s */
public class C0299s implements Creator<Subscription> {
    /* renamed from: a */
    static void m556a(Subscription subscription, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m252a(parcel, 1, subscription.getDataSource(), i, false);
        C0186b.m268c(parcel, 1000, subscription.getVersionCode());
        C0186b.m252a(parcel, 2, subscription.getDataType(), i, false);
        C0186b.m248a(parcel, 3, subscription.jI());
        C0186b.m268c(parcel, 4, subscription.getAccuracyMode());
        C0186b.m244H(parcel, H);
    }

    public Subscription bE(Parcel parcel) {
        DataType dataType = null;
        int i = 0;
        int G = C0185a.m208G(parcel);
        long j = 0;
        DataSource dataSource = null;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    dataSource = (DataSource) C0185a.m210a(parcel, F, DataSource.CREATOR);
                    break;
                case 2:
                    dataType = (DataType) C0185a.m210a(parcel, F, DataType.CREATOR);
                    break;
                case 3:
                    j = C0185a.m223i(parcel, F);
                    break;
                case 4:
                    i = C0185a.m221g(parcel, F);
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
            return new Subscription(i2, dataSource, dataType, j, i);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public Subscription[] cY(int i) {
        return new Subscription[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bE(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cY(x0);
    }
}
