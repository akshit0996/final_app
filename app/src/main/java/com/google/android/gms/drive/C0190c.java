package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.drive.c */
public class C0190c implements Creator<DriveId> {
    /* renamed from: a */
    static void m280a(DriveId driveId, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, driveId.CK);
        C0186b.m256a(parcel, 2, driveId.Ot, false);
        C0186b.m248a(parcel, 3, driveId.Ou);
        C0186b.m248a(parcel, 4, driveId.Ov);
        C0186b.m244H(parcel, H);
    }

    /* renamed from: S */
    public DriveId m281S(Parcel parcel) {
        long j = 0;
        int G = C0185a.m208G(parcel);
        int i = 0;
        String str = null;
        long j2 = 0;
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
                    j2 = C0185a.m223i(parcel, F);
                    break;
                case 4:
                    j = C0185a.m223i(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new DriveId(i, str, j2, j);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public DriveId[] aY(int i) {
        return new DriveId[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m281S(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aY(x0);
    }
}
