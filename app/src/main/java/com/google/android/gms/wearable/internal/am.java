package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

public class am implements Creator<al> {
    /* renamed from: a */
    static void m2321a(al alVar, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, alVar.CK);
        C0186b.m256a(parcel, 2, alVar.getId(), false);
        C0186b.m256a(parcel, 3, alVar.getDisplayName(), false);
        C0186b.m244H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ez(x0);
    }

    public al ez(Parcel parcel) {
        String str = null;
        int G = C0185a.m208G(parcel);
        int i = 0;
        String str2 = null;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    str2 = C0185a.m229o(parcel, F);
                    break;
                case 3:
                    str = C0185a.m229o(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new al(i, str2, str);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public al[] gI(int i) {
        return new al[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return gI(x0);
    }
}
