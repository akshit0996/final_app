package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

public class px implements Creator<pw> {
    /* renamed from: a */
    static void m1782a(pw pwVar, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, pwVar.getVersionCode());
        C0186b.m261a(parcel, 2, pwVar.avX, false);
        C0186b.m244H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return dX(x0);
    }

    public pw dX(Parcel parcel) {
        int G = C0185a.m208G(parcel);
        int i = 0;
        int[] iArr = null;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    iArr = C0185a.m235u(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new pw(i, iArr);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public pw[] ge(int i) {
        return new pw[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ge(x0);
    }
}
