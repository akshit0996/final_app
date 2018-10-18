package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.wallet.wobs.c */
public class C0683c implements Creator<C1252b> {
    /* renamed from: a */
    static void m2257a(C1252b c1252b, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, c1252b.getVersionCode());
        C0186b.m256a(parcel, 2, c1252b.label, false);
        C0186b.m256a(parcel, 3, c1252b.value, false);
        C0186b.m244H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ed(x0);
    }

    public C1252b ed(Parcel parcel) {
        String str = null;
        int G = C0185a.m208G(parcel);
        int i = 0;
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
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new C1252b(i, str2, str);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public C1252b[] gm(int i) {
        return new C1252b[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return gm(x0);
    }
}
