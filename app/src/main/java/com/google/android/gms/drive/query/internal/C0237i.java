package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.drive.query.internal.i */
public class C0237i implements Creator<LogicalFilter> {
    /* renamed from: a */
    static void m422a(LogicalFilter logicalFilter, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1000, logicalFilter.CK);
        C0186b.m252a(parcel, 1, logicalFilter.Sh, i, false);
        C0186b.m269c(parcel, 2, logicalFilter.Su, false);
        C0186b.m244H(parcel, H);
    }

    public LogicalFilter aY(Parcel parcel) {
        List list = null;
        int G = C0185a.m208G(parcel);
        int i = 0;
        Operator operator = null;
        while (parcel.dataPosition() < G) {
            int i2;
            Operator operator2;
            ArrayList c;
            int F = C0185a.m207F(parcel);
            List list2;
            switch (C0185a.aH(F)) {
                case 1:
                    i2 = i;
                    Operator operator3 = (Operator) C0185a.m210a(parcel, F, Operator.CREATOR);
                    list2 = list;
                    operator2 = operator3;
                    break;
                case 2:
                    c = C0185a.m216c(parcel, F, FilterHolder.CREATOR);
                    operator2 = operator;
                    i2 = i;
                    break;
                case 1000:
                    List list3 = list;
                    operator2 = operator;
                    i2 = C0185a.m221g(parcel, F);
                    list2 = list3;
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    c = list;
                    operator2 = operator;
                    i2 = i;
                    break;
            }
            i = i2;
            operator = operator2;
            Object obj = c;
        }
        if (parcel.dataPosition() == G) {
            return new LogicalFilter(i, operator, list);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public LogicalFilter[] cn(int i) {
        return new LogicalFilter[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aY(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cn(x0);
    }
}
