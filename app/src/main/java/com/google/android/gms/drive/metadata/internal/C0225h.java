package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.drive.metadata.internal.h */
public class C0225h implements Creator<MetadataBundle> {
    /* renamed from: a */
    static void m406a(MetadataBundle metadataBundle, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, metadataBundle.CK);
        C0186b.m249a(parcel, 2, metadataBundle.Ri, false);
        C0186b.m244H(parcel, H);
    }

    public MetadataBundle aP(Parcel parcel) {
        int G = C0185a.m208G(parcel);
        int i = 0;
        Bundle bundle = null;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    bundle = C0185a.m231q(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new MetadataBundle(i, bundle);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public MetadataBundle[] ce(int i) {
        return new MetadataBundle[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aP(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ce(x0);
    }
}
