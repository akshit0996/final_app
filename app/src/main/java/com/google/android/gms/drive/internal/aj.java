package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.drive.DriveId;

public class aj implements Creator<LoadRealtimeRequest> {
    /* renamed from: a */
    static void m356a(LoadRealtimeRequest loadRealtimeRequest, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, loadRealtimeRequest.CK);
        C0186b.m252a(parcel, 2, loadRealtimeRequest.Oj, i, false);
        C0186b.m259a(parcel, 3, loadRealtimeRequest.QF);
        C0186b.m244H(parcel, H);
    }

    public LoadRealtimeRequest ap(Parcel parcel) {
        boolean z = false;
        int G = C0185a.m208G(parcel);
        DriveId driveId = null;
        int i = 0;
        while (parcel.dataPosition() < G) {
            DriveId driveId2;
            int g;
            boolean z2;
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    boolean z3 = z;
                    driveId2 = driveId;
                    g = C0185a.m221g(parcel, F);
                    z2 = z3;
                    break;
                case 2:
                    g = i;
                    DriveId driveId3 = (DriveId) C0185a.m210a(parcel, F, DriveId.CREATOR);
                    z2 = z;
                    driveId2 = driveId3;
                    break;
                case 3:
                    z2 = C0185a.m217c(parcel, F);
                    driveId2 = driveId;
                    g = i;
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    z2 = z;
                    driveId2 = driveId;
                    g = i;
                    break;
            }
            i = g;
            driveId = driveId2;
            z = z2;
        }
        if (parcel.dataPosition() == G) {
            return new LoadRealtimeRequest(i, driveId, z);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public LoadRealtimeRequest[] bE(int i) {
        return new LoadRealtimeRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ap(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bE(x0);
    }
}
