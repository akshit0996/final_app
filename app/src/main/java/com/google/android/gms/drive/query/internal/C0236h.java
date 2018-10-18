package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

/* renamed from: com.google.android.gms.drive.query.internal.h */
public class C0236h implements Creator<InFilter> {
    /* renamed from: a */
    static void m421a(InFilter inFilter, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1000, inFilter.CK);
        C0186b.m252a(parcel, 1, inFilter.Si, i, false);
        C0186b.m244H(parcel, H);
    }

    public InFilter aX(Parcel parcel) {
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
            return new InFilter(i, metadataBundle);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public InFilter[] cm(int i) {
        return new InFilter[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aX(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cm(x0);
    }
}
