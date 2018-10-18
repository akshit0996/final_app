package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.drive.DriveId;

/* renamed from: com.google.android.gms.drive.internal.a */
public class C0203a implements Creator<AddEventListenerRequest> {
    /* renamed from: a */
    static void m299a(AddEventListenerRequest addEventListenerRequest, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, addEventListenerRequest.CK);
        C0186b.m252a(parcel, 2, addEventListenerRequest.Oj, i, false);
        C0186b.m268c(parcel, 3, addEventListenerRequest.Pm);
        C0186b.m244H(parcel, H);
    }

    /* renamed from: Z */
    public AddEventListenerRequest m300Z(Parcel parcel) {
        int i = 0;
        int G = C0185a.m208G(parcel);
        DriveId driveId = null;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            DriveId driveId2;
            int g;
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    int i3 = i;
                    driveId2 = driveId;
                    g = C0185a.m221g(parcel, F);
                    F = i3;
                    break;
                case 2:
                    g = i2;
                    DriveId driveId3 = (DriveId) C0185a.m210a(parcel, F, DriveId.CREATOR);
                    F = i;
                    driveId2 = driveId3;
                    break;
                case 3:
                    F = C0185a.m221g(parcel, F);
                    driveId2 = driveId;
                    g = i2;
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    F = i;
                    driveId2 = driveId;
                    g = i2;
                    break;
            }
            i2 = g;
            driveId = driveId2;
            i = F;
        }
        if (parcel.dataPosition() == G) {
            return new AddEventListenerRequest(i2, driveId, i);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public AddEventListenerRequest[] bj(int i) {
        return new AddEventListenerRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m300Z(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bj(x0);
    }
}
