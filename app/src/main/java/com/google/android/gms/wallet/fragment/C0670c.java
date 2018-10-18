package com.google.android.gms.wallet.fragment;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.wallet.fragment.c */
public class C0670c implements Creator<WalletFragmentStyle> {
    /* renamed from: a */
    static void m2246a(WalletFragmentStyle walletFragmentStyle, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, walletFragmentStyle.CK);
        C0186b.m249a(parcel, 2, walletFragmentStyle.awy, false);
        C0186b.m268c(parcel, 3, walletFragmentStyle.awz);
        C0186b.m244H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return eb(x0);
    }

    public WalletFragmentStyle eb(Parcel parcel) {
        int i = 0;
        int G = C0185a.m208G(parcel);
        Bundle bundle = null;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i2 = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    bundle = C0185a.m231q(parcel, F);
                    break;
                case 3:
                    i = C0185a.m221g(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new WalletFragmentStyle(i2, bundle, i);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public WalletFragmentStyle[] gj(int i) {
        return new WalletFragmentStyle[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return gj(x0);
    }
}
