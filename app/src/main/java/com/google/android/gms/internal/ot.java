package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

public class ot implements Creator<or> {
    /* renamed from: a */
    static void m1768a(or orVar, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, orVar.versionCode);
        C0186b.m248a(parcel, 2, orVar.amW);
        C0186b.m256a(parcel, 3, orVar.tag, false);
        C0186b.m260a(parcel, 4, orVar.amX, false);
        C0186b.m249a(parcel, 5, orVar.amY, false);
        C0186b.m244H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return dt(x0);
    }

    public or dt(Parcel parcel) {
        Bundle bundle = null;
        int G = C0185a.m208G(parcel);
        int i = 0;
        long j = 0;
        byte[] bArr = null;
        String str = null;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    j = C0185a.m223i(parcel, F);
                    break;
                case 3:
                    str = C0185a.m229o(parcel, F);
                    break;
                case 4:
                    bArr = C0185a.m232r(parcel, F);
                    break;
                case 5:
                    bundle = C0185a.m231q(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new or(i, j, str, bArr, bundle);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public or[] fq(int i) {
        return new or[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return fq(x0);
    }
}
