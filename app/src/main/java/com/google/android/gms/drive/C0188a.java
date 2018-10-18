package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.drive.a */
public class C0188a implements Creator<Contents> {
    /* renamed from: a */
    static void m278a(Contents contents, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, contents.CK);
        C0186b.m252a(parcel, 2, contents.LG, i, false);
        C0186b.m268c(parcel, 3, contents.ve);
        C0186b.m268c(parcel, 4, contents.Oi);
        C0186b.m252a(parcel, 5, contents.Oj, i, false);
        C0186b.m259a(parcel, 7, contents.Ok);
        C0186b.m244H(parcel, H);
    }

    /* renamed from: R */
    public Contents m279R(Parcel parcel) {
        DriveId driveId = null;
        boolean z = false;
        int G = C0185a.m208G(parcel);
        int i = 0;
        int i2 = 0;
        ParcelFileDescriptor parcelFileDescriptor = null;
        int i3 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i3 = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    parcelFileDescriptor = (ParcelFileDescriptor) C0185a.m210a(parcel, F, ParcelFileDescriptor.CREATOR);
                    break;
                case 3:
                    i2 = C0185a.m221g(parcel, F);
                    break;
                case 4:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 5:
                    driveId = (DriveId) C0185a.m210a(parcel, F, DriveId.CREATOR);
                    break;
                case 7:
                    z = C0185a.m217c(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new Contents(i3, parcelFileDescriptor, i2, i, driveId, z);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public Contents[] aX(int i) {
        return new Contents[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m279R(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aX(x0);
    }
}
