package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.drive.d */
public class C0191d implements Creator<DrivePreferences> {
    /* renamed from: a */
    static void m282a(DrivePreferences drivePreferences, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, drivePreferences.CK);
        C0186b.m259a(parcel, 2, drivePreferences.Ox);
        C0186b.m244H(parcel, H);
    }

    /* renamed from: T */
    public DrivePreferences m283T(Parcel parcel) {
        boolean z = false;
        int G = C0185a.m208G(parcel);
        int i = 0;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    z = C0185a.m217c(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new DrivePreferences(i, z);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public DrivePreferences[] aZ(int i) {
        return new DrivePreferences[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m283T(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aZ(x0);
    }
}
