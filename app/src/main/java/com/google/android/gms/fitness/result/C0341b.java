package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.fitness.result.b */
public class C0341b implements Creator<DataReadResult> {
    /* renamed from: a */
    static void m651a(DataReadResult dataReadResult, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m270d(parcel, 1, dataReadResult.kt(), false);
        C0186b.m268c(parcel, 1000, dataReadResult.getVersionCode());
        C0186b.m252a(parcel, 2, dataReadResult.getStatus(), i, false);
        C0186b.m270d(parcel, 3, dataReadResult.ks(), false);
        C0186b.m268c(parcel, 5, dataReadResult.kr());
        C0186b.m269c(parcel, 6, dataReadResult.jw(), false);
        C0186b.m269c(parcel, 7, dataReadResult.ku(), false);
        C0186b.m244H(parcel, H);
    }

    public DataReadResult ce(Parcel parcel) {
        int i = 0;
        List list = null;
        int G = C0185a.m208G(parcel);
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        List list2 = null;
        Status status = null;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    C0185a.m213a(parcel, F, arrayList, getClass().getClassLoader());
                    break;
                case 2:
                    status = (Status) C0185a.m210a(parcel, F, Status.CREATOR);
                    break;
                case 3:
                    C0185a.m213a(parcel, F, arrayList2, getClass().getClassLoader());
                    break;
                case 5:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 6:
                    list2 = C0185a.m216c(parcel, F, DataSource.CREATOR);
                    break;
                case 7:
                    list = C0185a.m216c(parcel, F, DataType.CREATOR);
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
            return new DataReadResult(i2, arrayList, status, arrayList2, i, list2, list);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ce(x0);
    }

    public DataReadResult[] dz(int i) {
        return new DataReadResult[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dz(x0);
    }
}
