package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.identity.intents.model.UserAddress;

/* renamed from: com.google.android.gms.wallet.k */
public class C0675k implements Creator<MaskedWallet> {
    /* renamed from: a */
    static void m2251a(MaskedWallet maskedWallet, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, maskedWallet.getVersionCode());
        C0186b.m256a(parcel, 2, maskedWallet.auL, false);
        C0186b.m256a(parcel, 3, maskedWallet.auM, false);
        C0186b.m263a(parcel, 4, maskedWallet.auR, false);
        C0186b.m256a(parcel, 5, maskedWallet.auO, false);
        C0186b.m252a(parcel, 6, maskedWallet.auP, i, false);
        C0186b.m252a(parcel, 7, maskedWallet.auQ, i, false);
        C0186b.m262a(parcel, 8, maskedWallet.avw, i, false);
        C0186b.m262a(parcel, 9, maskedWallet.avx, i, false);
        C0186b.m252a(parcel, 10, maskedWallet.auS, i, false);
        C0186b.m252a(parcel, 11, maskedWallet.auT, i, false);
        C0186b.m262a(parcel, 12, maskedWallet.auU, i, false);
        C0186b.m244H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return dS(x0);
    }

    public MaskedWallet dS(Parcel parcel) {
        int G = C0185a.m208G(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String[] strArr = null;
        String str3 = null;
        Address address = null;
        Address address2 = null;
        LoyaltyWalletObject[] loyaltyWalletObjectArr = null;
        OfferWalletObject[] offerWalletObjectArr = null;
        UserAddress userAddress = null;
        UserAddress userAddress2 = null;
        InstrumentInfo[] instrumentInfoArr = null;
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
                    strArr = C0185a.m202A(parcel, F);
                    break;
                case 5:
                    str3 = C0185a.m229o(parcel, F);
                    break;
                case 6:
                    address = (Address) C0185a.m210a(parcel, F, Address.CREATOR);
                    break;
                case 7:
                    address2 = (Address) C0185a.m210a(parcel, F, Address.CREATOR);
                    break;
                case 8:
                    loyaltyWalletObjectArr = (LoyaltyWalletObject[]) C0185a.m215b(parcel, F, LoyaltyWalletObject.CREATOR);
                    break;
                case 9:
                    offerWalletObjectArr = (OfferWalletObject[]) C0185a.m215b(parcel, F, OfferWalletObject.CREATOR);
                    break;
                case 10:
                    userAddress = (UserAddress) C0185a.m210a(parcel, F, UserAddress.CREATOR);
                    break;
                case 11:
                    userAddress2 = (UserAddress) C0185a.m210a(parcel, F, UserAddress.CREATOR);
                    break;
                case 12:
                    instrumentInfoArr = (InstrumentInfo[]) C0185a.m215b(parcel, F, InstrumentInfo.CREATOR);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new MaskedWallet(i, str, str2, strArr, str3, address, address2, loyaltyWalletObjectArr, offerWalletObjectArr, userAddress, userAddress2, instrumentInfoArr);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public MaskedWallet[] fZ(int i) {
        return new MaskedWallet[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return fZ(x0);
    }
}
