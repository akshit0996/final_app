package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.wallet.g */
public class C0671g implements Creator<FullWalletRequest> {
    /* renamed from: a */
    static void m2247a(FullWalletRequest fullWalletRequest, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, fullWalletRequest.getVersionCode());
        C0186b.m256a(parcel, 2, fullWalletRequest.auL, false);
        C0186b.m256a(parcel, 3, fullWalletRequest.auM, false);
        C0186b.m252a(parcel, 4, fullWalletRequest.auV, i, false);
        C0186b.m244H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return dO(x0);
    }

    public FullWalletRequest dO(Parcel parcel) {
        Cart cart = null;
        int G = C0185a.m208G(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    str2 = C0185a.m229o(parcel, F);
                    break;
                case 3:
                    str = C0185a.m229o(parcel, F);
                    break;
                case 4:
                    cart = (Cart) C0185a.m210a(parcel, F, Cart.CREATOR);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new FullWalletRequest(i, str2, str, cart);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public FullWalletRequest[] fV(int i) {
        return new FullWalletRequest[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return fV(x0);
    }
}
