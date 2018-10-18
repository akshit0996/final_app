package com.google.android.gms.identity.intents.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.identity.intents.model.b */
public class C0360b implements Creator<UserAddress> {
    /* renamed from: a */
    static void m975a(UserAddress userAddress, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, userAddress.getVersionCode());
        C0186b.m256a(parcel, 2, userAddress.name, false);
        C0186b.m256a(parcel, 3, userAddress.afK, false);
        C0186b.m256a(parcel, 4, userAddress.afL, false);
        C0186b.m256a(parcel, 5, userAddress.afM, false);
        C0186b.m256a(parcel, 6, userAddress.afN, false);
        C0186b.m256a(parcel, 7, userAddress.afO, false);
        C0186b.m256a(parcel, 8, userAddress.afP, false);
        C0186b.m256a(parcel, 9, userAddress.afQ, false);
        C0186b.m256a(parcel, 10, userAddress.vk, false);
        C0186b.m256a(parcel, 11, userAddress.afR, false);
        C0186b.m256a(parcel, 12, userAddress.afS, false);
        C0186b.m256a(parcel, 13, userAddress.afT, false);
        C0186b.m259a(parcel, 14, userAddress.afU);
        C0186b.m256a(parcel, 15, userAddress.afV, false);
        C0186b.m256a(parcel, 16, userAddress.afW, false);
        C0186b.m244H(parcel, H);
    }

    public UserAddress cH(Parcel parcel) {
        int G = C0185a.m208G(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        String str11 = null;
        String str12 = null;
        boolean z = false;
        String str13 = null;
        String str14 = null;
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
                    str2 = C0185a.m229o(parcel, F);
                    break;
                case 4:
                    str3 = C0185a.m229o(parcel, F);
                    break;
                case 5:
                    str4 = C0185a.m229o(parcel, F);
                    break;
                case 6:
                    str5 = C0185a.m229o(parcel, F);
                    break;
                case 7:
                    str6 = C0185a.m229o(parcel, F);
                    break;
                case 8:
                    str7 = C0185a.m229o(parcel, F);
                    break;
                case 9:
                    str8 = C0185a.m229o(parcel, F);
                    break;
                case 10:
                    str9 = C0185a.m229o(parcel, F);
                    break;
                case 11:
                    str10 = C0185a.m229o(parcel, F);
                    break;
                case 12:
                    str11 = C0185a.m229o(parcel, F);
                    break;
                case 13:
                    str12 = C0185a.m229o(parcel, F);
                    break;
                case 14:
                    z = C0185a.m217c(parcel, F);
                    break;
                case 15:
                    str13 = C0185a.m229o(parcel, F);
                    break;
                case 16:
                    str14 = C0185a.m229o(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new UserAddress(i, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, z, str13, str14);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cH(x0);
    }

    public UserAddress[] eu(int i) {
        return new UserAddress[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return eu(x0);
    }
}
