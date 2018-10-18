package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

public class ig implements Creator<C0988if> {
    /* renamed from: a */
    static void m1437a(C0988if c0988if, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, c0988if.responseCode);
        C0186b.m268c(parcel, 1000, c0988if.versionCode);
        C0186b.m249a(parcel, 2, c0988if.Ep, false);
        C0186b.m260a(parcel, 3, c0988if.Eq, false);
        C0186b.m244H(parcel, H);
    }

    /* renamed from: U */
    public C0988if[] m1438U(int i) {
        return new C0988if[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m1439t(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m1438U(x0);
    }

    /* renamed from: t */
    public C0988if m1439t(Parcel parcel) {
        byte[] bArr = null;
        int i = 0;
        int G = C0185a.m208G(parcel);
        Bundle bundle = null;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    bundle = C0185a.m231q(parcel, F);
                    break;
                case 3:
                    bArr = C0185a.m232r(parcel, F);
                    break;
                case 1000:
                    i2 = C0185a.m221g(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new C0988if(i2, i, bundle, bArr);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }
}
