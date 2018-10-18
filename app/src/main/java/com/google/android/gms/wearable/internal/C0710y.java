package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.wearable.internal.y */
public class C0710y implements Creator<C1278x> {
    /* renamed from: a */
    static void m2334a(C1278x c1278x, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, c1278x.versionCode);
        C0186b.m268c(parcel, 2, c1278x.statusCode);
        C0186b.m252a(parcel, 3, c1278x.axM, i, false);
        C0186b.m244H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ev(x0);
    }

    public C1278x ev(Parcel parcel) {
        int i = 0;
        int G = C0185a.m208G(parcel);
        C1490m c1490m = null;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i2 = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 3:
                    c1490m = (C1490m) C0185a.m210a(parcel, F, C1490m.CREATOR);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new C1278x(i2, i, c1490m);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public C1278x[] gE(int i) {
        return new C1278x[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return gE(x0);
    }
}
