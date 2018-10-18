package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.fitness.request.v */
public class C0333v implements Creator<C0885u> {
    /* renamed from: a */
    static void m643a(C0885u c0885u, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m252a(parcel, 1, c0885u.kb(), i, false);
        C0186b.m268c(parcel, 1000, c0885u.getVersionCode());
        C0186b.m244H(parcel, H);
    }

    public C0885u bU(Parcel parcel) {
        int G = C0185a.m208G(parcel);
        int i = 0;
        PendingIntent pendingIntent = null;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    pendingIntent = (PendingIntent) C0185a.m210a(parcel, F, PendingIntent.CREATOR);
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
            return new C0885u(i, pendingIntent);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bU(x0);
    }

    public C0885u[] dp(int i) {
        return new C0885u[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dp(x0);
    }
}
