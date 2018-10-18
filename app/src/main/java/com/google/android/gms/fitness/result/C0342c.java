package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.fitness.data.DataSource;
import java.util.List;

/* renamed from: com.google.android.gms.fitness.result.c */
public class C0342c implements Creator<DataSourcesResult> {
    /* renamed from: a */
    static void m652a(DataSourcesResult dataSourcesResult, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m269c(parcel, 1, dataSourcesResult.getDataSources(), false);
        C0186b.m268c(parcel, 1000, dataSourcesResult.getVersionCode());
        C0186b.m252a(parcel, 2, dataSourcesResult.getStatus(), i, false);
        C0186b.m244H(parcel, H);
    }

    public DataSourcesResult cf(Parcel parcel) {
        Status status = null;
        int G = C0185a.m208G(parcel);
        int i = 0;
        List list = null;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    list = C0185a.m216c(parcel, F, DataSource.CREATOR);
                    break;
                case 2:
                    status = (Status) C0185a.m210a(parcel, F, Status.CREATOR);
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
            return new DataSourcesResult(i, list, status);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cf(x0);
    }

    public DataSourcesResult[] dA(int i) {
        return new DataSourcesResult[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dA(x0);
    }
}
