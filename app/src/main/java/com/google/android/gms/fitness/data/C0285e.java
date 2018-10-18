package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.fitness.data.e */
public class C0285e implements Creator<DataPoint> {
    /* renamed from: a */
    static void m541a(DataPoint dataPoint, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m252a(parcel, 1, dataPoint.getDataSource(), i, false);
        C0186b.m268c(parcel, 1000, dataPoint.getVersionCode());
        C0186b.m248a(parcel, 3, dataPoint.getTimestampNanos());
        C0186b.m248a(parcel, 4, dataPoint.ju());
        C0186b.m262a(parcel, 5, dataPoint.jr(), i, false);
        C0186b.m252a(parcel, 6, dataPoint.getOriginalDataSource(), i, false);
        C0186b.m248a(parcel, 7, dataPoint.js());
        C0186b.m248a(parcel, 8, dataPoint.jt());
        C0186b.m244H(parcel, H);
    }

    public DataPoint bt(Parcel parcel) {
        int G = C0185a.m208G(parcel);
        int i = 0;
        DataSource dataSource = null;
        long j = 0;
        long j2 = 0;
        Value[] valueArr = null;
        DataSource dataSource2 = null;
        long j3 = 0;
        long j4 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    dataSource = (DataSource) C0185a.m210a(parcel, F, DataSource.CREATOR);
                    break;
                case 3:
                    j = C0185a.m223i(parcel, F);
                    break;
                case 4:
                    j2 = C0185a.m223i(parcel, F);
                    break;
                case 5:
                    valueArr = (Value[]) C0185a.m215b(parcel, F, Value.CREATOR);
                    break;
                case 6:
                    dataSource2 = (DataSource) C0185a.m210a(parcel, F, DataSource.CREATOR);
                    break;
                case 7:
                    j3 = C0185a.m223i(parcel, F);
                    break;
                case 8:
                    j4 = C0185a.m223i(parcel, F);
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
            return new DataPoint(i, dataSource, j, j2, valueArr, dataSource2, j3, j4);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public DataPoint[] cM(int i) {
        return new DataPoint[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bt(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cM(x0);
    }
}
