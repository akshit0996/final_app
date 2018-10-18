package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.wallet.e */
public class C0662e implements Creator<C1247d> {
    /* renamed from: a */
    static void m2222a(C1247d c1247d, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, c1247d.getVersionCode());
        C0186b.m252a(parcel, 2, c1247d.auJ, i, false);
        C0186b.m252a(parcel, 3, c1247d.auK, i, false);
        C0186b.m244H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return dM(x0);
    }

    public C1247d dM(Parcel parcel) {
        OfferWalletObject offerWalletObject = null;
        int G = C0185a.m208G(parcel);
        int i = 0;
        LoyaltyWalletObject loyaltyWalletObject = null;
        while (parcel.dataPosition() < G) {
            LoyaltyWalletObject loyaltyWalletObject2;
            int g;
            OfferWalletObject offerWalletObject2;
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    OfferWalletObject offerWalletObject3 = offerWalletObject;
                    loyaltyWalletObject2 = loyaltyWalletObject;
                    g = C0185a.m221g(parcel, F);
                    offerWalletObject2 = offerWalletObject3;
                    break;
                case 2:
                    g = i;
                    LoyaltyWalletObject loyaltyWalletObject3 = (LoyaltyWalletObject) C0185a.m210a(parcel, F, LoyaltyWalletObject.CREATOR);
                    offerWalletObject2 = offerWalletObject;
                    loyaltyWalletObject2 = loyaltyWalletObject3;
                    break;
                case 3:
                    offerWalletObject2 = (OfferWalletObject) C0185a.m210a(parcel, F, OfferWalletObject.CREATOR);
                    loyaltyWalletObject2 = loyaltyWalletObject;
                    g = i;
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    offerWalletObject2 = offerWalletObject;
                    loyaltyWalletObject2 = loyaltyWalletObject;
                    g = i;
                    break;
            }
            i = g;
            loyaltyWalletObject = loyaltyWalletObject2;
            offerWalletObject = offerWalletObject2;
        }
        if (parcel.dataPosition() == G) {
            return new C1247d(i, loyaltyWalletObject, offerWalletObject);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public C1247d[] fT(int i) {
        return new C1247d[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return fT(x0);
    }
}
