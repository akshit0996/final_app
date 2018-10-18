package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.drive.DriveId;
import java.util.ArrayList;
import java.util.List;

public class bf implements Creator<SetResourceParentsRequest> {
    /* renamed from: a */
    static void m377a(SetResourceParentsRequest setResourceParentsRequest, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, setResourceParentsRequest.CK);
        C0186b.m252a(parcel, 2, setResourceParentsRequest.QW, i, false);
        C0186b.m269c(parcel, 3, setResourceParentsRequest.QX, false);
        C0186b.m244H(parcel, H);
    }

    public SetResourceParentsRequest aJ(Parcel parcel) {
        List list = null;
        int G = C0185a.m208G(parcel);
        int i = 0;
        DriveId driveId = null;
        while (parcel.dataPosition() < G) {
            DriveId driveId2;
            int g;
            ArrayList c;
            int F = C0185a.m207F(parcel);
            List list2;
            switch (C0185a.aH(F)) {
                case 1:
                    List list3 = list;
                    driveId2 = driveId;
                    g = C0185a.m221g(parcel, F);
                    list2 = list3;
                    break;
                case 2:
                    g = i;
                    DriveId driveId3 = (DriveId) C0185a.m210a(parcel, F, DriveId.CREATOR);
                    list2 = list;
                    driveId2 = driveId3;
                    break;
                case 3:
                    c = C0185a.m216c(parcel, F, DriveId.CREATOR);
                    driveId2 = driveId;
                    g = i;
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    c = list;
                    driveId2 = driveId;
                    g = i;
                    break;
            }
            i = g;
            driveId = driveId2;
            Object obj = c;
        }
        if (parcel.dataPosition() == G) {
            return new SetResourceParentsRequest(i, driveId, list);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public SetResourceParentsRequest[] bY(int i) {
        return new SetResourceParentsRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aJ(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bY(x0);
    }
}
