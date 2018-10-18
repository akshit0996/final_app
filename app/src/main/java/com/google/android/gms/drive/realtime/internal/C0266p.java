package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.drive.realtime.internal.p */
public class C0266p implements Creator<ParcelableCollaborator> {
    /* renamed from: a */
    static void m498a(ParcelableCollaborator parcelableCollaborator, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, parcelableCollaborator.CK);
        C0186b.m259a(parcel, 2, parcelableCollaborator.SH);
        C0186b.m259a(parcel, 3, parcelableCollaborator.SI);
        C0186b.m256a(parcel, 4, parcelableCollaborator.vZ, false);
        C0186b.m256a(parcel, 5, parcelableCollaborator.SJ, false);
        C0186b.m256a(parcel, 6, parcelableCollaborator.OS, false);
        C0186b.m256a(parcel, 7, parcelableCollaborator.SK, false);
        C0186b.m256a(parcel, 8, parcelableCollaborator.SL, false);
        C0186b.m244H(parcel, H);
    }

    public ParcelableCollaborator be(Parcel parcel) {
        boolean z = false;
        String str = null;
        int G = C0185a.m208G(parcel);
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        boolean z2 = false;
        int i = 0;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    z2 = C0185a.m217c(parcel, F);
                    break;
                case 3:
                    z = C0185a.m217c(parcel, F);
                    break;
                case 4:
                    str5 = C0185a.m229o(parcel, F);
                    break;
                case 5:
                    str4 = C0185a.m229o(parcel, F);
                    break;
                case 6:
                    str3 = C0185a.m229o(parcel, F);
                    break;
                case 7:
                    str2 = C0185a.m229o(parcel, F);
                    break;
                case 8:
                    str = C0185a.m229o(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new ParcelableCollaborator(i, z2, z, str5, str4, str3, str2, str);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return be(x0);
    }

    public ParcelableCollaborator[] cu(int i) {
        return new ParcelableCollaborator[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cu(x0);
    }
}
