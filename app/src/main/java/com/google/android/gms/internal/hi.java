package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

public class hi implements Creator<hh> {
    /* renamed from: a */
    static void m1391a(hh hhVar, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m256a(parcel, 1, hhVar.CX, false);
        C0186b.m268c(parcel, 1000, hhVar.CK);
        C0186b.m252a(parcel, 3, hhVar.CY, i, false);
        C0186b.m268c(parcel, 4, hhVar.CZ);
        C0186b.m260a(parcel, 5, hhVar.Da, false);
        C0186b.m244H(parcel, H);
    }

    /* renamed from: L */
    public hh[] m1392L(int i) {
        return new hh[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m1393n(x0);
    }

    /* renamed from: n */
    public hh m1393n(Parcel parcel) {
        byte[] bArr = null;
        int G = C0185a.m208G(parcel);
        int i = 0;
        int i2 = -1;
        hp hpVar = null;
        String str = null;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    str = C0185a.m229o(parcel, F);
                    break;
                case 3:
                    hpVar = (hp) C0185a.m210a(parcel, F, hp.CREATOR);
                    break;
                case 4:
                    i2 = C0185a.m221g(parcel, F);
                    break;
                case 5:
                    bArr = C0185a.m232r(parcel, F);
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
            return new hh(i, str, hpVar, i2, bArr);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m1392L(x0);
    }
}
