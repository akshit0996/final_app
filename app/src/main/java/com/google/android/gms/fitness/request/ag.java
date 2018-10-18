package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.fitness.data.Subscription;

public class ag implements Creator<af> {
    /* renamed from: a */
    static void m619a(af afVar, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m252a(parcel, 1, afVar.kn(), i, false);
        C0186b.m268c(parcel, 1000, afVar.getVersionCode());
        C0186b.m259a(parcel, 2, afVar.ko());
        C0186b.m244H(parcel, H);
    }

    public af ca(Parcel parcel) {
        boolean z = false;
        int G = C0185a.m208G(parcel);
        Subscription subscription = null;
        int i = 0;
        while (parcel.dataPosition() < G) {
            int i2;
            boolean z2;
            Subscription subscription2;
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i2 = i;
                    Subscription subscription3 = (Subscription) C0185a.m210a(parcel, F, Subscription.CREATOR);
                    z2 = z;
                    subscription2 = subscription3;
                    break;
                case 2:
                    z2 = C0185a.m217c(parcel, F);
                    subscription2 = subscription;
                    i2 = i;
                    break;
                case 1000:
                    boolean z3 = z;
                    subscription2 = subscription;
                    i2 = C0185a.m221g(parcel, F);
                    z2 = z3;
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    z2 = z;
                    subscription2 = subscription;
                    i2 = i;
                    break;
            }
            i = i2;
            subscription = subscription2;
            z = z2;
        }
        if (parcel.dataPosition() == G) {
            return new af(i, subscription, z);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ca(x0);
    }

    public af[] dv(int i) {
        return new af[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dv(x0);
    }
}
