package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;

public class ak implements Creator<aj> {
    /* renamed from: a */
    static void m625a(aj ajVar, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m252a(parcel, 1, ajVar.getDataType(), i, false);
        C0186b.m268c(parcel, 1000, ajVar.getVersionCode());
        C0186b.m252a(parcel, 2, ajVar.getDataSource(), i, false);
        C0186b.m244H(parcel, H);
    }

    public aj cc(Parcel parcel) {
        DataSource dataSource = null;
        int G = C0185a.m208G(parcel);
        int i = 0;
        DataType dataType = null;
        while (parcel.dataPosition() < G) {
            int i2;
            DataSource dataSource2;
            DataType dataType2;
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i2 = i;
                    DataType dataType3 = (DataType) C0185a.m210a(parcel, F, DataType.CREATOR);
                    dataSource2 = dataSource;
                    dataType2 = dataType3;
                    break;
                case 2:
                    dataSource2 = (DataSource) C0185a.m210a(parcel, F, DataSource.CREATOR);
                    dataType2 = dataType;
                    i2 = i;
                    break;
                case 1000:
                    DataSource dataSource3 = dataSource;
                    dataType2 = dataType;
                    i2 = C0185a.m221g(parcel, F);
                    dataSource2 = dataSource3;
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    dataSource2 = dataSource;
                    dataType2 = dataType;
                    i2 = i;
                    break;
            }
            i = i2;
            dataType = dataType2;
            dataSource = dataSource2;
        }
        if (parcel.dataPosition() == G) {
            return new aj(i, dataType, dataSource);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cc(x0);
    }

    public aj[] dx(int i) {
        return new aj[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dx(x0);
    }
}
