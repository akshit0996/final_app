package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.drive.query.internal.LogicalFilter;
import java.util.List;

/* renamed from: com.google.android.gms.drive.query.a */
public class C0227a implements Creator<Query> {
    /* renamed from: a */
    static void m407a(Query query, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1000, query.CK);
        C0186b.m252a(parcel, 1, query.RY, i, false);
        C0186b.m256a(parcel, 3, query.RZ, false);
        C0186b.m252a(parcel, 4, query.Sa, i, false);
        C0186b.m267b(parcel, 5, query.Sb, false);
        C0186b.m244H(parcel, H);
    }

    public Query aQ(Parcel parcel) {
        List list = null;
        int G = C0185a.m208G(parcel);
        int i = 0;
        SortOrder sortOrder = null;
        String str = null;
        LogicalFilter logicalFilter = null;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    logicalFilter = (LogicalFilter) C0185a.m210a(parcel, F, LogicalFilter.CREATOR);
                    break;
                case 3:
                    str = C0185a.m229o(parcel, F);
                    break;
                case 4:
                    sortOrder = (SortOrder) C0185a.m210a(parcel, F, SortOrder.CREATOR);
                    break;
                case 5:
                    list = C0185a.m204C(parcel, F);
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
            return new Query(i, logicalFilter, str, sortOrder, list);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public Query[] cf(int i) {
        return new Query[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aQ(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cf(x0);
    }
}
