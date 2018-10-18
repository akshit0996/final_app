package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.drive.DriveId;

/* renamed from: com.google.android.gms.drive.events.a */
public class C0195a implements Creator<ChangeEvent> {
    /* renamed from: a */
    static void m287a(ChangeEvent changeEvent, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, changeEvent.CK);
        C0186b.m252a(parcel, 2, changeEvent.Oj, i, false);
        C0186b.m268c(parcel, 3, changeEvent.OX);
        C0186b.m244H(parcel, H);
    }

    /* renamed from: X */
    public ChangeEvent m288X(Parcel parcel) {
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
            return new ChangeEvent(i2, driveId, i);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public ChangeEvent[] bf(int i) {
        return new ChangeEvent[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m288X(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bf(x0);
    }
}
