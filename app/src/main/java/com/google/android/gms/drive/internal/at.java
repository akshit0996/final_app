package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class at implements Creator<OnMetadataResponse> {
    /* renamed from: a */
    static void m365a(OnMetadataResponse onMetadataResponse, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, onMetadataResponse.CK);
        C0186b.m252a(parcel, 2, onMetadataResponse.Px, i, false);
        C0186b.m244H(parcel, H);
    }

    public OnMetadataResponse ay(Parcel parcel) {
        int G = C0185a.m208G(parcel);
        int i = 0;
        MetadataBundle metadataBundle = null;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    metadataBundle = (MetadataBundle) C0185a.m210a(parcel, F, MetadataBundle.CREATOR);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new OnMetadataResponse(i, metadataBundle);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public OnMetadataResponse[] bN(int i) {
        return new OnMetadataResponse[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ay(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bN(x0);
    }
}
