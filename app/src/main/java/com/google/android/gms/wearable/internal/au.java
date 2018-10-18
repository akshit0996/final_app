package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

public class au implements Creator<at> {
    /* renamed from: a */
    static void m2325a(at atVar, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, atVar.versionCode);
        C0186b.m268c(parcel, 2, atVar.statusCode);
        C0186b.m268c(parcel, 3, atVar.ayd);
        C0186b.m244H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return eD(x0);
    }

    public at eD(Parcel parcel) {
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
            return new at(i3, i2, i);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public at[] gM(int i) {
        return new at[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return gM(x0);
    }
}
