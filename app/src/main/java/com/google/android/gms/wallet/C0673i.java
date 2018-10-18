package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.wallet.i */
public class C0673i implements Creator<LineItem> {
    /* renamed from: a */
    static void m2249a(LineItem lineItem, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, lineItem.getVersionCode());
        C0186b.m256a(parcel, 2, lineItem.description, false);
        C0186b.m256a(parcel, 3, lineItem.auZ, false);
        C0186b.m256a(parcel, 4, lineItem.ava, false);
        C0186b.m256a(parcel, 5, lineItem.auF, false);
        C0186b.m268c(parcel, 6, lineItem.avb);
        C0186b.m256a(parcel, 7, lineItem.auG, false);
        C0186b.m244H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return dQ(x0);
    }

    public LineItem dQ(Parcel parcel) {
        int i = 0;
        String str = null;
        int G = C0185a.m208G(parcel);
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i2 = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    str5 = C0185a.m229o(parcel, F);
                    break;
                case 3:
                    str4 = C0185a.m229o(parcel, F);
                    break;
                case 4:
                    str3 = C0185a.m229o(parcel, F);
                    break;
                case 5:
                    str2 = C0185a.m229o(parcel, F);
                    break;
                case 6:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 7:
                    str = C0185a.m229o(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new LineItem(i2, str5, str4, str3, str2, i, str);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public LineItem[] fX(int i) {
        return new LineItem[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return fX(x0);
    }
}
