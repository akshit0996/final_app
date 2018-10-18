package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.wallet.a */
public class C0659a implements Creator<Address> {
    /* renamed from: a */
    static void m2219a(Address address, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, address.getVersionCode());
        C0186b.m256a(parcel, 2, address.name, false);
        C0186b.m256a(parcel, 3, address.afK, false);
        C0186b.m256a(parcel, 4, address.afL, false);
        C0186b.m256a(parcel, 5, address.afM, false);
        C0186b.m256a(parcel, 6, address.vk, false);
        C0186b.m256a(parcel, 7, address.auD, false);
        C0186b.m256a(parcel, 8, address.auE, false);
        C0186b.m256a(parcel, 9, address.afR, false);
        C0186b.m256a(parcel, 10, address.afT, false);
        C0186b.m259a(parcel, 11, address.afU);
        C0186b.m256a(parcel, 12, address.afV, false);
        C0186b.m244H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return dJ(x0);
    }

    public Address dJ(Parcel parcel) {
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
        boolean z = false;
        String str10 = null;
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
                    z = C0185a.m217c(parcel, F);
                    break;
                case 12:
                    str10 = C0185a.m229o(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new Address(i, str, str2, str3, str4, str5, str6, str7, str8, str9, z, str10);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public Address[] fQ(int i) {
        return new Address[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return fQ(x0);
    }
}
