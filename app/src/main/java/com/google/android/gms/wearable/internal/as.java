package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

public class as implements Creator<ar> {
    /* renamed from: a */
    static void m2324a(ar arVar, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, arVar.CK);
        C0186b.m250a(parcel, 2, arVar.rm(), false);
        C0186b.m244H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return eC(x0);
    }

    public ar eC(Parcel parcel) {
        int G = C0185a.m208G(parcel);
        int i = 0;
        IBinder iBinder = null;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    iBinder = C0185a.m230p(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new ar(i, iBinder);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public ar[] gL(int i) {
        return new ar[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return gL(x0);
    }
}
