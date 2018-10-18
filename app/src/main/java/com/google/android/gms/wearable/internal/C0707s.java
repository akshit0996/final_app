package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.wearable.C1261c;

/* renamed from: com.google.android.gms.wearable.internal.s */
public class C0707s implements Creator<C1275r> {
    /* renamed from: a */
    static void m2331a(C1275r c1275r, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, c1275r.versionCode);
        C0186b.m268c(parcel, 2, c1275r.statusCode);
        C0186b.m252a(parcel, 3, c1275r.axJ, i, false);
        C0186b.m244H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return es(x0);
    }

    public C1275r es(Parcel parcel) {
        int i = 0;
        int G = C0185a.m208G(parcel);
        C1261c c1261c = null;
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
                    c1261c = (C1261c) C0185a.m210a(parcel, F, C1261c.CREATOR);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new C1275r(i2, i, c1261c);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public C1275r[] gB(int i) {
        return new C1275r[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return gB(x0);
    }
}
