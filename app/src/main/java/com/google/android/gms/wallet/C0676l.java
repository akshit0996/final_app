package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.identity.intents.model.CountrySpecification;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.wallet.l */
public class C0676l implements Creator<MaskedWalletRequest> {
    /* renamed from: a */
    static void m2252a(MaskedWalletRequest maskedWalletRequest, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, maskedWalletRequest.getVersionCode());
        C0186b.m256a(parcel, 2, maskedWalletRequest.auM, false);
        C0186b.m259a(parcel, 3, maskedWalletRequest.avz);
        C0186b.m259a(parcel, 4, maskedWalletRequest.avA);
        C0186b.m259a(parcel, 5, maskedWalletRequest.avB);
        C0186b.m256a(parcel, 6, maskedWalletRequest.avC, false);
        C0186b.m256a(parcel, 7, maskedWalletRequest.auG, false);
        C0186b.m256a(parcel, 8, maskedWalletRequest.avD, false);
        C0186b.m252a(parcel, 9, maskedWalletRequest.auV, i, false);
        C0186b.m259a(parcel, 10, maskedWalletRequest.avE);
        C0186b.m259a(parcel, 11, maskedWalletRequest.avF);
        C0186b.m262a(parcel, 12, maskedWalletRequest.avG, i, false);
        C0186b.m259a(parcel, 13, maskedWalletRequest.avH);
        C0186b.m259a(parcel, 14, maskedWalletRequest.avI);
        C0186b.m269c(parcel, 15, maskedWalletRequest.avJ, false);
        C0186b.m244H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return dT(x0);
    }

    public MaskedWalletRequest dT(Parcel parcel) {
        int G = C0185a.m208G(parcel);
        int i = 0;
        String str = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        Cart cart = null;
        boolean z4 = false;
        boolean z5 = false;
        CountrySpecification[] countrySpecificationArr = null;
        boolean z6 = true;
        boolean z7 = true;
        ArrayList arrayList = null;
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
                    z = C0185a.m217c(parcel, F);
                    break;
                case 4:
                    z2 = C0185a.m217c(parcel, F);
                    break;
                case 5:
                    z3 = C0185a.m217c(parcel, F);
                    break;
                case 6:
                    str2 = C0185a.m229o(parcel, F);
                    break;
                case 7:
                    str3 = C0185a.m229o(parcel, F);
                    break;
                case 8:
                    str4 = C0185a.m229o(parcel, F);
                    break;
                case 9:
                    cart = (Cart) C0185a.m210a(parcel, F, Cart.CREATOR);
                    break;
                case 10:
                    z4 = C0185a.m217c(parcel, F);
                    break;
                case 11:
                    z5 = C0185a.m217c(parcel, F);
                    break;
                case 12:
                    countrySpecificationArr = (CountrySpecification[]) C0185a.m215b(parcel, F, CountrySpecification.CREATOR);
                    break;
                case 13:
                    z6 = C0185a.m217c(parcel, F);
                    break;
                case 14:
                    z7 = C0185a.m217c(parcel, F);
                    break;
                case 15:
                    arrayList = C0185a.m216c(parcel, F, CountrySpecification.CREATOR);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new MaskedWalletRequest(i, str, z, z2, z3, str2, str3, str4, cart, z4, z5, countrySpecificationArr, z6, z7, arrayList);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public MaskedWalletRequest[] ga(int i) {
        return new MaskedWalletRequest[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ga(x0);
    }
}
