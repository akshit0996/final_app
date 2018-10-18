package com.google.android.gms.wallet.fragment;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.wallet.fragment.b */
public class C0669b implements Creator<WalletFragmentOptions> {
    /* renamed from: a */
    static void m2245a(WalletFragmentOptions walletFragmentOptions, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, walletFragmentOptions.CK);
        C0186b.m268c(parcel, 2, walletFragmentOptions.getEnvironment());
        C0186b.m268c(parcel, 3, walletFragmentOptions.getTheme());
        C0186b.m252a(parcel, 4, walletFragmentOptions.getFragmentStyle(), i, false);
        C0186b.m268c(parcel, 5, walletFragmentOptions.getMode());
        C0186b.m244H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ea(x0);
    }

    public WalletFragmentOptions ea(Parcel parcel) {
        int i = 1;
        int i2 = 0;
        int G = C0185a.m208G(parcel);
        WalletFragmentStyle walletFragmentStyle = null;
        int i3 = 1;
        int i4 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i4 = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    i3 = C0185a.m221g(parcel, F);
                    break;
                case 3:
                    i2 = C0185a.m221g(parcel, F);
                    break;
                case 4:
                    walletFragmentStyle = (WalletFragmentStyle) C0185a.m210a(parcel, F, WalletFragmentStyle.CREATOR);
                    break;
                case 5:
                    i = C0185a.m221g(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new WalletFragmentOptions(i4, i3, i2, walletFragmentStyle, i);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public WalletFragmentOptions[] gi(int i) {
        return new WalletFragmentOptions[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return gi(x0);
    }
}
