package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.drive.DriveFile;

/* renamed from: com.google.android.gms.drive.internal.h */
public class C0211h implements Creator<CreateContentsRequest> {
    /* renamed from: a */
    static void m384a(CreateContentsRequest createContentsRequest, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, createContentsRequest.CK);
        C0186b.m268c(parcel, 2, createContentsRequest.Oi);
        C0186b.m244H(parcel, H);
    }

    public CreateContentsRequest af(Parcel parcel) {
        int G = C0185a.m208G(parcel);
        int i = 0;
        int i2 = DriveFile.MODE_WRITE_ONLY;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    i2 = C0185a.m221g(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new CreateContentsRequest(i, i2);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public CreateContentsRequest[] bp(int i) {
        return new CreateContentsRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return af(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bp(x0);
    }
}
