package com.google.android.gms.maps.model.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.maps.model.internal.f */
public class C0561f implements Creator<C1163e> {
    /* renamed from: a */
    static void m1993a(C1163e c1163e, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, c1163e.getVersionCode());
        C0186b.m252a(parcel, 2, c1163e.oj(), i, false);
        C0186b.m244H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return dr(x0);
    }

    public C1163e dr(Parcel parcel) {
        int G = C0185a.m208G(parcel);
        int i = 0;
        C1161a c1161a = null;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    c1161a = (C1161a) C0185a.m210a(parcel, F, C1161a.CREATOR);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new C1163e(i, c1161a);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public C1163e[] fn(int i) {
        return new C1163e[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return fn(x0);
    }
}
