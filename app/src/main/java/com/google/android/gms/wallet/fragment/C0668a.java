package com.google.android.gms.wallet.fragment;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;

/* renamed from: com.google.android.gms.wallet.fragment.a */
public class C0668a implements Creator<WalletFragmentInitParams> {
    /* renamed from: a */
    static void m2244a(WalletFragmentInitParams walletFragmentInitParams, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, walletFragmentInitParams.CK);
        C0186b.m256a(parcel, 2, walletFragmentInitParams.getAccountName(), false);
        C0186b.m252a(parcel, 3, walletFragmentInitParams.getMaskedWalletRequest(), i, false);
        C0186b.m268c(parcel, 4, walletFragmentInitParams.getMaskedWalletRequestCode());
        C0186b.m252a(parcel, 5, walletFragmentInitParams.getMaskedWallet(), i, false);
        C0186b.m244H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return dZ(x0);
    }

    public WalletFragmentInitParams dZ(Parcel parcel) {
        MaskedWallet maskedWallet = null;
        int G = C0185a.m208G(parcel);
        int i = 0;
        int i2 = -1;
        MaskedWalletRequest maskedWalletRequest = null;
        String str = null;
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
                    maskedWalletRequest = (MaskedWalletRequest) C0185a.m210a(parcel, F, MaskedWalletRequest.CREATOR);
                    break;
                case 4:
                    i2 = C0185a.m221g(parcel, F);
                    break;
                case 5:
                    maskedWallet = (MaskedWallet) C0185a.m210a(parcel, F, MaskedWallet.CREATOR);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new WalletFragmentInitParams(i, str, maskedWalletRequest, i2, maskedWallet);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public WalletFragmentInitParams[] gh(int i) {
        return new WalletFragmentInitParams[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return gh(x0);
    }
}
