package com.google.android.gms.maps.model.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.maps.model.internal.q */
public class C0571q implements Creator<C1182p> {
    /* renamed from: a */
    static void m2008a(C1182p c1182p, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, c1182p.getVersionCode());
        C0186b.m252a(parcel, 2, c1182p.ol(), i, false);
        C0186b.m244H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ds(x0);
    }

    public C1182p ds(Parcel parcel) {
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
            return new C1182p(i, c1161a);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public C1182p[] fp(int i) {
        return new C1182p[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return fp(x0);
    }
}
