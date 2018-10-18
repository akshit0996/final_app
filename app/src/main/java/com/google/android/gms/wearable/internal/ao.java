package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

public class ao implements Creator<an> {
    /* renamed from: a */
    static void m2322a(an anVar, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, anVar.versionCode);
        C0186b.m256a(parcel, 2, anVar.packageName, false);
        C0186b.m256a(parcel, 3, anVar.label, false);
        C0186b.m248a(parcel, 4, anVar.ayc);
        C0186b.m244H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return eA(x0);
    }

    public an eA(Parcel parcel) {
        String str = null;
        int G = C0185a.m208G(parcel);
        int i = 0;
        long j = 0;
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
                    j = C0185a.m223i(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new an(i, str2, str, j);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public an[] gJ(int i) {
        return new an[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return gJ(x0);
    }
}
