package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

public class ac implements Creator<GetDriveIdFromUniqueIdentifierRequest> {
    /* renamed from: a */
    static void m303a(GetDriveIdFromUniqueIdentifierRequest getDriveIdFromUniqueIdentifierRequest, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, getDriveIdFromUniqueIdentifierRequest.CK);
        C0186b.m256a(parcel, 2, getDriveIdFromUniqueIdentifierRequest.QC, false);
        C0186b.m259a(parcel, 3, getDriveIdFromUniqueIdentifierRequest.QD);
        C0186b.m244H(parcel, H);
    }

    public GetDriveIdFromUniqueIdentifierRequest am(Parcel parcel) {
        boolean z = false;
        int G = C0185a.m208G(parcel);
        String str = null;
        int i = 0;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    str = C0185a.m229o(parcel, F);
                    break;
                case 3:
                    z = C0185a.m217c(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new GetDriveIdFromUniqueIdentifierRequest(i, str, z);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public GetDriveIdFromUniqueIdentifierRequest[] bB(int i) {
        return new GetDriveIdFromUniqueIdentifierRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return am(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bB(x0);
    }
}
