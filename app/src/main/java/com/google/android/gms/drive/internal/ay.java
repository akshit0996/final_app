package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.drive.DriveId;

public class ay implements Creator<OpenContentsRequest> {
    /* renamed from: a */
    static void m370a(OpenContentsRequest openContentsRequest, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, openContentsRequest.CK);
        C0186b.m252a(parcel, 2, openContentsRequest.Pp, i, false);
        C0186b.m268c(parcel, 3, openContentsRequest.Oi);
        C0186b.m268c(parcel, 4, openContentsRequest.QT);
        C0186b.m244H(parcel, H);
    }

    public OpenContentsRequest aD(Parcel parcel) {
        int i = 0;
        int G = C0185a.m208G(parcel);
        DriveId driveId = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < G) {
            DriveId driveId2;
            int g;
            int F = C0185a.m207F(parcel);
            int i4;
            switch (C0185a.aH(F)) {
                case 1:
                    i4 = i;
                    i = i2;
                    driveId2 = driveId;
                    g = C0185a.m221g(parcel, F);
                    F = i4;
                    break;
                case 2:
                    g = i3;
                    i4 = i2;
                    driveId2 = (DriveId) C0185a.m210a(parcel, F, DriveId.CREATOR);
                    F = i;
                    i = i4;
                    break;
                case 3:
                    driveId2 = driveId;
                    g = i3;
                    i4 = i;
                    i = C0185a.m221g(parcel, F);
                    F = i4;
                    break;
                case 4:
                    F = C0185a.m221g(parcel, F);
                    i = i2;
                    driveId2 = driveId;
                    g = i3;
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    F = i;
                    i = i2;
                    driveId2 = driveId;
                    g = i3;
                    break;
            }
            i3 = g;
            driveId = driveId2;
            i2 = i;
            i = F;
        }
        if (parcel.dataPosition() == G) {
            return new OpenContentsRequest(i3, driveId, i2, i);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public OpenContentsRequest[] bS(int i) {
        return new OpenContentsRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aD(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bS(x0);
    }
}
