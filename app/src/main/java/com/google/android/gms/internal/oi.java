package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

public class oi implements Creator<oh> {
    /* renamed from: a */
    static void m1758a(oh ohVar, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m256a(parcel, 1, ohVar.akg, false);
        C0186b.m268c(parcel, 1000, ohVar.versionCode);
        C0186b.m256a(parcel, 2, ohVar.akh, false);
        C0186b.m256a(parcel, 3, ohVar.aki, false);
        C0186b.m256a(parcel, 4, ohVar.akj, false);
        C0186b.m244H(parcel, H);
    }

    public oh cW(Parcel parcel) {
        String str = null;
        int G = C0185a.m208G(parcel);
        int i = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    str4 = C0185a.m229o(parcel, F);
                    break;
                case 2:
                    str3 = C0185a.m229o(parcel, F);
                    break;
                case 3:
                    str2 = C0185a.m229o(parcel, F);
                    break;
                case 4:
                    str = C0185a.m229o(parcel, F);
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
            return new oh(i, str4, str3, str2, str);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cW(x0);
    }

    public oh[] eS(int i) {
        return new oh[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return eS(x0);
    }
}