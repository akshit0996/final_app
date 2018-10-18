package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

public class dn implements Creator<C0934do> {
    /* renamed from: a */
    static void m1137a(C0934do c0934do, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, c0934do.versionCode);
        C0186b.m256a(parcel, 2, c0934do.rG, false);
        C0186b.m256a(parcel, 3, c0934do.rH, false);
        C0186b.m256a(parcel, 4, c0934do.mimeType, false);
        C0186b.m256a(parcel, 5, c0934do.packageName, false);
        C0186b.m256a(parcel, 6, c0934do.rI, false);
        C0186b.m256a(parcel, 7, c0934do.rJ, false);
        C0186b.m256a(parcel, 8, c0934do.rK, false);
        C0186b.m244H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m1138e(x0);
    }

    /* renamed from: e */
    public C0934do m1138e(Parcel parcel) {
        String str = null;
        int G = C0185a.m208G(parcel);
        int i = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    str7 = C0185a.m229o(parcel, F);
                    break;
                case 3:
                    str6 = C0185a.m229o(parcel, F);
                    break;
                case 4:
                    str5 = C0185a.m229o(parcel, F);
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
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new C0934do(i, str7, str6, str5, str4, str3, str2, str);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    /* renamed from: m */
    public C0934do[] m1139m(int i) {
        return new C0934do[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m1139m(x0);
    }
}
