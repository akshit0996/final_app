package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

public class ae implements Creator<ad> {
    /* renamed from: a */
    static void m615a(ad adVar, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m250a(parcel, 1, adVar.km(), false);
        C0186b.m268c(parcel, 1000, adVar.getVersionCode());
        C0186b.m244H(parcel, H);
    }

    public ad bZ(Parcel parcel) {
        int G = C0185a.m208G(parcel);
        int i = 0;
        IBinder iBinder = null;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    iBinder = C0185a.m230p(parcel, F);
                    break;
                case 1000:
                    i = C0185a.m221g(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new ad(i, iBinder);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bZ(x0);
    }

    public ad[] du(int i) {
        return new ad[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return du(x0);
    }
}
