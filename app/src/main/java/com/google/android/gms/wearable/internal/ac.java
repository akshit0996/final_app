package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

public class ac implements Creator<ab> {
    /* renamed from: a */
    static void m2277a(ab abVar, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, abVar.versionCode);
        C0186b.m268c(parcel, 2, abVar.statusCode);
        C0186b.m252a(parcel, 3, abVar.axO, i, false);
        C0186b.m244H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ex(x0);
    }

    public ab ex(Parcel parcel) {
        int i = 0;
        int G = C0185a.m208G(parcel);
        al alVar = null;
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
                    alVar = (al) C0185a.m210a(parcel, F, al.CREATOR);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new ab(i2, i, alVar);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public ab[] gG(int i) {
        return new ab[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return gG(x0);
    }
}
