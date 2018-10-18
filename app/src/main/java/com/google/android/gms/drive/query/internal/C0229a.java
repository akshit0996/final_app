package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

/* renamed from: com.google.android.gms.drive.query.internal.a */
public class C0229a implements Creator<ComparisonFilter> {
    /* renamed from: a */
    static void m409a(ComparisonFilter comparisonFilter, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1000, comparisonFilter.CK);
        C0186b.m252a(parcel, 1, comparisonFilter.Sh, i, false);
        C0186b.m252a(parcel, 2, comparisonFilter.Si, i, false);
        C0186b.m244H(parcel, H);
    }

    public ComparisonFilter aS(Parcel parcel) {
        MetadataBundle metadataBundle = null;
        int G = C0185a.m208G(parcel);
        int i = 0;
        Operator operator = null;
        while (parcel.dataPosition() < G) {
            int i2;
            MetadataBundle metadataBundle2;
            Operator operator2;
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i2 = i;
                    Operator operator3 = (Operator) C0185a.m210a(parcel, F, Operator.CREATOR);
                    metadataBundle2 = metadataBundle;
                    operator2 = operator3;
                    break;
                case 2:
                    metadataBundle2 = (MetadataBundle) C0185a.m210a(parcel, F, MetadataBundle.CREATOR);
                    operator2 = operator;
                    i2 = i;
                    break;
                case 1000:
                    MetadataBundle metadataBundle3 = metadataBundle;
                    operator2 = operator;
                    i2 = C0185a.m221g(parcel, F);
                    metadataBundle2 = metadataBundle3;
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    metadataBundle2 = metadataBundle;
                    operator2 = operator;
                    i2 = i;
                    break;
            }
            i = i2;
            operator = operator2;
            metadataBundle = metadataBundle2;
        }
        if (parcel.dataPosition() == G) {
            return new ComparisonFilter(i, operator, metadataBundle);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public ComparisonFilter[] ch(int i) {
        return new ComparisonFilter[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aS(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ch(x0);
    }
}
