package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.drive.DriveId;

public class ad implements Creator<GetMetadataRequest> {
    /* renamed from: a */
    static void m304a(GetMetadataRequest getMetadataRequest, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, getMetadataRequest.CK);
        C0186b.m252a(parcel, 2, getMetadataRequest.Pp, i, false);
        C0186b.m244H(parcel, H);
    }

    public GetMetadataRequest an(Parcel parcel) {
        int G = C0185a.m208G(parcel);
        int i = 0;
        DriveId driveId = null;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    driveId = (DriveId) C0185a.m210a(parcel, F, DriveId.CREATOR);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new GetMetadataRequest(i, driveId);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public GetMetadataRequest[] bC(int i) {
        return new GetMetadataRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return an(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bC(x0);
    }
}
