package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.identity.intents.model.UserAddress;

/* renamed from: com.google.android.gms.wallet.f */
public class C0663f implements Creator<FullWallet> {
    /* renamed from: a */
    static void m2223a(FullWallet fullWallet, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, fullWallet.getVersionCode());
        C0186b.m256a(parcel, 2, fullWallet.auL, false);
        C0186b.m256a(parcel, 3, fullWallet.auM, false);
        C0186b.m252a(parcel, 4, fullWallet.auN, i, false);
        C0186b.m256a(parcel, 5, fullWallet.auO, false);
        C0186b.m252a(parcel, 6, fullWallet.auP, i, false);
        C0186b.m252a(parcel, 7, fullWallet.auQ, i, false);
        C0186b.m263a(parcel, 8, fullWallet.auR, false);
        C0186b.m252a(parcel, 9, fullWallet.auS, i, false);
        C0186b.m252a(parcel, 10, fullWallet.auT, i, false);
        C0186b.m262a(parcel, 11, fullWallet.auU, i, false);
        C0186b.m244H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return dN(x0);
    }

    public FullWallet dN(Parcel parcel) {
        InstrumentInfo[] instrumentInfoArr = null;
        int G = C0185a.m208G(parcel);
        int i = 0;
        UserAddress userAddress = null;
        UserAddress userAddress2 = null;
        String[] strArr = null;
        Address address = null;
        Address address2 = null;
        String str = null;
        ProxyCard proxyCard = null;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    str3 = C0185a.m229o(parcel, F);
                    break;
                case 3:
                    str2 = C0185a.m229o(parcel, F);
                    break;
                case 4:
                    proxyCard = (ProxyCard) C0185a.m210a(parcel, F, ProxyCard.CREATOR);
                    break;
                case 5:
                    str = C0185a.m229o(parcel, F);
                    break;
                case 6:
                    address2 = (Address) C0185a.m210a(parcel, F, Address.CREATOR);
                    break;
                case 7:
                    address = (Address) C0185a.m210a(parcel, F, Address.CREATOR);
                    break;
                case 8:
                    strArr = C0185a.m202A(parcel, F);
                    break;
                case 9:
                    userAddress2 = (UserAddress) C0185a.m210a(parcel, F, UserAddress.CREATOR);
                    break;
                case 10:
                    userAddress = (UserAddress) C0185a.m210a(parcel, F, UserAddress.CREATOR);
                    break;
                case 11:
                    instrumentInfoArr = (InstrumentInfo[]) C0185a.m215b(parcel, F, InstrumentInfo.CREATOR);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new FullWallet(i, str3, str2, proxyCard, str, address2, address, strArr, userAddress2, userAddress, instrumentInfoArr);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public FullWallet[] fU(int i) {
        return new FullWallet[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return fU(x0);
    }
}
