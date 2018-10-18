package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.fitness.data.f */
public class C0286f implements Creator<DataSet> {
    /* renamed from: a */
    static void m542a(DataSet dataSet, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m252a(parcel, 1, dataSet.getDataSource(), i, false);
        C0186b.m268c(parcel, 1000, dataSet.getVersionCode());
        C0186b.m252a(parcel, 2, dataSet.getDataType(), i, false);
        C0186b.m270d(parcel, 3, dataSet.jv(), false);
        C0186b.m269c(parcel, 4, dataSet.jw(), false);
        C0186b.m259a(parcel, 5, dataSet.jn());
        C0186b.m244H(parcel, H);
    }

    public DataSet bu(Parcel parcel) {
        boolean z = false;
        List list = null;
        int G = C0185a.m208G(parcel);
        List arrayList = new ArrayList();
        DataType dataType = null;
        DataSource dataSource = null;
        int i = 0;
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
                    C0185a.m213a(parcel, F, arrayList, getClass().getClassLoader());
                    break;
                case 4:
                    list = C0185a.m216c(parcel, F, DataSource.CREATOR);
                    break;
                case 5:
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
            return new DataSet(i, dataSource, dataType, arrayList, list, z);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public DataSet[] cN(int i) {
        return new DataSet[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bu(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cN(x0);
    }
}
