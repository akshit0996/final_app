package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.wearable.C1261c;

/* renamed from: com.google.android.gms.wearable.internal.u */
public class C0708u implements Creator<C1276t> {
    /* renamed from: a */
    static void m2332a(C1276t c1276t, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, c1276t.versionCode);
        C0186b.m268c(parcel, 2, c1276t.statusCode);
        C0186b.m262a(parcel, 3, c1276t.axK, i, false);
        C0186b.m244H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return et(x0);
    }

    public C1276t et(Parcel parcel) {
        int i = 0;
        int G = C0185a.m208G(parcel);
        C1261c[] c1261cArr = null;
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
                    c1261cArr = (C1261c[]) C0185a.m215b(parcel, F, C1261c.CREATOR);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new C1276t(i2, i, c1261cArr);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public C1276t[] gC(int i) {
        return new C1276t[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return gC(x0);
    }
}
