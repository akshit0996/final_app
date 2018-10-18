package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.drive.query.internal.d */
public class C0232d implements Creator<FilterHolder> {
    /* renamed from: a */
    static void m412a(FilterHolder filterHolder, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m252a(parcel, 1, filterHolder.Sl, i, false);
        C0186b.m268c(parcel, 1000, filterHolder.CK);
        C0186b.m252a(parcel, 2, filterHolder.Sm, i, false);
        C0186b.m252a(parcel, 3, filterHolder.Sn, i, false);
        C0186b.m252a(parcel, 4, filterHolder.So, i, false);
        C0186b.m252a(parcel, 5, filterHolder.Sp, i, false);
        C0186b.m252a(parcel, 6, filterHolder.Sq, i, false);
        C0186b.m252a(parcel, 7, filterHolder.Sr, i, false);
        C0186b.m244H(parcel, H);
    }

    public FilterHolder aV(Parcel parcel) {
        HasFilter hasFilter = null;
        int G = C0185a.m208G(parcel);
        int i = 0;
        MatchAllFilter matchAllFilter = null;
        InFilter inFilter = null;
        NotFilter notFilter = null;
        LogicalFilter logicalFilter = null;
        FieldOnlyFilter fieldOnlyFilter = null;
        ComparisonFilter comparisonFilter = null;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    comparisonFilter = (ComparisonFilter) C0185a.m210a(parcel, F, ComparisonFilter.CREATOR);
                    break;
                case 2:
                    fieldOnlyFilter = (FieldOnlyFilter) C0185a.m210a(parcel, F, FieldOnlyFilter.CREATOR);
                    break;
                case 3:
                    logicalFilter = (LogicalFilter) C0185a.m210a(parcel, F, LogicalFilter.CREATOR);
                    break;
                case 4:
                    notFilter = (NotFilter) C0185a.m210a(parcel, F, NotFilter.CREATOR);
                    break;
                case 5:
                    inFilter = (InFilter) C0185a.m210a(parcel, F, InFilter.CREATOR);
                    break;
                case 6:
                    matchAllFilter = (MatchAllFilter) C0185a.m210a(parcel, F, MatchAllFilter.CREATOR);
                    break;
                case 7:
                    hasFilter = (HasFilter) C0185a.m210a(parcel, F, HasFilter.CREATOR);
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
            return new FilterHolder(i, comparisonFilter, fieldOnlyFilter, logicalFilter, notFilter, inFilter, matchAllFilter, hasFilter);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public FilterHolder[] ck(int i) {
        return new FilterHolder[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aV(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ck(x0);
    }
}
