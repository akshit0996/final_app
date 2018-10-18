package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.wallet.o */
public class C0679o implements Creator<ProxyCard> {
    /* renamed from: a */
    static void m2255a(ProxyCard proxyCard, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, proxyCard.getVersionCode());
        C0186b.m256a(parcel, 2, proxyCard.avP, false);
        C0186b.m256a(parcel, 3, proxyCard.avQ, false);
        C0186b.m268c(parcel, 4, proxyCard.avR);
        C0186b.m268c(parcel, 5, proxyCard.avS);
        C0186b.m244H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return dW(x0);
    }

    public ProxyCard dW(Parcel parcel) {
        String str = null;
        int i = 0;
        int G = C0185a.m208G(parcel);
        int i2 = 0;
        String str2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i3 = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    str2 = C0185a.m229o(parcel, F);
                    break;
                case 3:
                    str = C0185a.m229o(parcel, F);
                    break;
                case 4:
                    i2 = C0185a.m221g(parcel, F);
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
            return new ProxyCard(i3, str2, str, i2, i);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public ProxyCard[] gd(int i) {
        return new ProxyCard[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return gd(x0);
    }
}
