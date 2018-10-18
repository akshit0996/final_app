package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.wearable.internal.q */
public class C0706q implements Creator<C1274p> {
    /* renamed from: a */
    static void m2330a(C1274p c1274p, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, c1274p.versionCode);
        C0186b.m268c(parcel, 2, c1274p.statusCode);
        C0186b.m268c(parcel, 3, c1274p.axI);
        C0186b.m244H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return er(x0);
    }

    public C1274p er(Parcel parcel) {
        int i = 0;
        int G = C0185a.m208G(parcel);
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i3 = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    i2 = C0185a.m221g(parcel, F);
                    break;
                case 3:
                    i = C0185a.m221g(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new C1274p(i3, i2, i);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public C1274p[] gA(int i) {
        return new C1274p[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return gA(x0);
    }
}
