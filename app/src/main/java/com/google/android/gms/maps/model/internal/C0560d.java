package com.google.android.gms.maps.model.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.maps.model.internal.d */
public class C0560d implements Creator<C1162c> {
    /* renamed from: a */
    static void m1992a(C1162c c1162c, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, c1162c.getVersionCode());
        C0186b.m268c(parcel, 2, c1162c.getType());
        C0186b.m249a(parcel, 3, c1162c.oi(), false);
        C0186b.m244H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return dq(x0);
    }

    public C1162c dq(Parcel parcel) {
        int i = 0;
        int G = C0185a.m208G(parcel);
        Bundle bundle = null;
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
                    bundle = C0185a.m231q(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new C1162c(i2, i, bundle);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public C1162c[] fm(int i) {
        return new C1162c[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return fm(x0);
    }
}
