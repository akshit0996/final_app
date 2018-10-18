package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import java.util.List;

/* renamed from: com.google.android.gms.fitness.request.g */
public class C0321g implements Creator<DataReadRequest> {
    /* renamed from: a */
    static void m631a(DataReadRequest dataReadRequest, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m269c(parcel, 1, dataReadRequest.getDataTypes(), false);
        C0186b.m268c(parcel, 1000, dataReadRequest.getVersionCode());
        C0186b.m269c(parcel, 2, dataReadRequest.getDataSources(), false);
        C0186b.m248a(parcel, 3, dataReadRequest.jo());
        C0186b.m248a(parcel, 4, dataReadRequest.jp());
        C0186b.m269c(parcel, 5, dataReadRequest.getAggregatedDataTypes(), false);
        C0186b.m269c(parcel, 6, dataReadRequest.getAggregatedDataSources(), false);
        C0186b.m268c(parcel, 7, dataReadRequest.getBucketType());
        C0186b.m248a(parcel, 8, dataReadRequest.jX());
        C0186b.m252a(parcel, 9, dataReadRequest.getActivityDataSource(), i, false);
        C0186b.m268c(parcel, 10, dataReadRequest.getLimit());
        C0186b.m259a(parcel, 12, dataReadRequest.jW());
        C0186b.m259a(parcel, 13, dataReadRequest.jV());
        C0186b.m244H(parcel, H);
    }

    public DataReadRequest bL(Parcel parcel) {
        int G = C0185a.m208G(parcel);
        int i = 0;
        List list = null;
        List list2 = null;
        long j = 0;
        long j2 = 0;
        List list3 = null;
        List list4 = null;
        int i2 = 0;
        long j3 = 0;
        DataSource dataSource = null;
        int i3 = 0;
        boolean z = false;
        boolean z2 = false;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    list = C0185a.m216c(parcel, F, DataType.CREATOR);
                    break;
                case 2:
                    list2 = C0185a.m216c(parcel, F, DataSource.CREATOR);
                    break;
                case 3:
                    j = C0185a.m223i(parcel, F);
                    break;
                case 4:
                    j2 = C0185a.m223i(parcel, F);
                    break;
                case 5:
                    list3 = C0185a.m216c(parcel, F, DataType.CREATOR);
                    break;
                case 6:
                    list4 = C0185a.m216c(parcel, F, DataSource.CREATOR);
                    break;
                case 7:
                    i2 = C0185a.m221g(parcel, F);
                    break;
                case 8:
                    j3 = C0185a.m223i(parcel, F);
                    break;
                case 9:
                    dataSource = (DataSource) C0185a.m210a(parcel, F, DataSource.CREATOR);
                    break;
                case 10:
                    i3 = C0185a.m221g(parcel, F);
                    break;
                case 12:
                    z = C0185a.m217c(parcel, F);
                    break;
                case 13:
                    z2 = C0185a.m217c(parcel, F);
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
            return new DataReadRequest(i, list, list2, j, j2, list3, list4, i2, j3, dataSource, i3, z, z2);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bL(x0);
    }

    public DataReadRequest[] df(int i) {
        return new DataReadRequest[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return df(x0);
    }
}
