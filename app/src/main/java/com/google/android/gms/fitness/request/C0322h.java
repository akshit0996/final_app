package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.fitness.data.DataType;
import java.util.List;

/* renamed from: com.google.android.gms.fitness.request.h */
public class C0322h implements Creator<DataSourcesRequest> {
    /* renamed from: a */
    static void m632a(DataSourcesRequest dataSourcesRequest, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m269c(parcel, 1, dataSourcesRequest.getDataTypes(), false);
        C0186b.m268c(parcel, 1000, dataSourcesRequest.getVersionCode());
        C0186b.m257a(parcel, 2, dataSourcesRequest.jZ(), false);
        C0186b.m259a(parcel, 3, dataSourcesRequest.jY());
        C0186b.m244H(parcel, H);
    }

    public DataSourcesRequest bM(Parcel parcel) {
        List list = null;
        boolean z = false;
        int G = C0185a.m208G(parcel);
        List list2 = null;
        int i = 0;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    list2 = C0185a.m216c(parcel, F, DataType.CREATOR);
                    break;
                case 2:
                    list = C0185a.m203B(parcel, F);
                    break;
                case 3:
                    z = C0185a.m217c(parcel, F);
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
            return new DataSourcesRequest(i, list2, list, z);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bM(x0);
    }

    public DataSourcesRequest[] dg(int i) {
        return new DataSourcesRequest[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dg(x0);
    }
}
