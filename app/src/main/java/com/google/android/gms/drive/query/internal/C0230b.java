package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

/* renamed from: com.google.android.gms.drive.query.internal.b */
public class C0230b implements Creator<FieldOnlyFilter> {
    /* renamed from: a */
    static void m410a(FieldOnlyFilter fieldOnlyFilter, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1000, fieldOnlyFilter.CK);
        C0186b.m252a(parcel, 1, fieldOnlyFilter.Si, i, false);
        C0186b.m244H(parcel, H);
    }

    public FieldOnlyFilter aT(Parcel parcel) {
        int G = C0185a.m208G(parcel);
        int i = 0;
        MetadataBundle metadataBundle = null;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    metadataBundle = (MetadataBundle) C0185a.m210a(parcel, F, MetadataBundle.CREATOR);
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
            return new FieldOnlyFilter(i, metadataBundle);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public FieldOnlyFilter[] ci(int i) {
        return new FieldOnlyFilter[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aT(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ci(x0);
    }
}
