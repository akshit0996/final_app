package com.google.android.gms.plus.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.plus.internal.i */
public class C0597i implements Creator<C1204h> {
    /* renamed from: a */
    static void m2057a(C1204h c1204h, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m256a(parcel, 1, c1204h.getAccountName(), false);
        C0186b.m268c(parcel, 1000, c1204h.getVersionCode());
        C0186b.m263a(parcel, 2, c1204h.oz(), false);
        C0186b.m263a(parcel, 3, c1204h.oA(), false);
        C0186b.m263a(parcel, 4, c1204h.oB(), false);
        C0186b.m256a(parcel, 5, c1204h.oC(), false);
        C0186b.m256a(parcel, 6, c1204h.oD(), false);
        C0186b.m256a(parcel, 7, c1204h.oE(), false);
        C0186b.m256a(parcel, 8, c1204h.oF(), false);
        C0186b.m252a(parcel, 9, c1204h.oG(), i, false);
        C0186b.m244H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return dw(x0);
    }

    public C1204h dw(Parcel parcel) {
        PlusCommonExtras plusCommonExtras = null;
        int G = C0185a.m208G(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String[] strArr = null;
        String[] strArr2 = null;
        String[] strArr3 = null;
        String str5 = null;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    str5 = C0185a.m229o(parcel, F);
                    break;
                case 2:
                    strArr3 = C0185a.m202A(parcel, F);
                    break;
                case 3:
                    strArr2 = C0185a.m202A(parcel, F);
                    break;
                case 4:
                    strArr = C0185a.m202A(parcel, F);
                    break;
                case 5:
                    str4 = C0185a.m229o(parcel, F);
                    break;
                case 6:
                    str3 = C0185a.m229o(parcel, F);
                    break;
                case 7:
                    str2 = C0185a.m229o(parcel, F);
                    break;
                case 8:
                    str = C0185a.m229o(parcel, F);
                    break;
                case 9:
                    plusCommonExtras = (PlusCommonExtras) C0185a.m210a(parcel, F, PlusCommonExtras.CREATOR);
                    break;
                case 1000:
                    i = C0185a.m221g(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new C1204h(i, str5, strArr3, strArr2, strArr, str4, str3, str2, str, plusCommonExtras);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public C1204h[] fu(int i) {
        return new C1204h[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return fu(x0);
    }
}
