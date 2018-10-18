package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.drive.h */
public class C0201h implements Creator<UserMetadata> {
    /* renamed from: a */
    static void m296a(UserMetadata userMetadata, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, userMetadata.CK);
        C0186b.m256a(parcel, 2, userMetadata.OR, false);
        C0186b.m256a(parcel, 3, userMetadata.OS, false);
        C0186b.m256a(parcel, 4, userMetadata.OT, false);
        C0186b.m259a(parcel, 5, userMetadata.OU);
        C0186b.m256a(parcel, 6, userMetadata.OV, false);
        C0186b.m244H(parcel, H);
    }

    /* renamed from: W */
    public UserMetadata m297W(Parcel parcel) {
        boolean z = false;
        String str = null;
        int G = C0185a.m208G(parcel);
        String str2 = null;
        String str3 = null;
        String str4 = null;
        int i = 0;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    str4 = C0185a.m229o(parcel, F);
                    break;
                case 3:
                    str3 = C0185a.m229o(parcel, F);
                    break;
                case 4:
                    str2 = C0185a.m229o(parcel, F);
                    break;
                case 5:
                    z = C0185a.m217c(parcel, F);
                    break;
                case 6:
                    str = C0185a.m229o(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new UserMetadata(i, str4, str3, str2, z, str);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public UserMetadata[] be(int i) {
        return new UserMetadata[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m297W(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return be(x0);
    }
}
