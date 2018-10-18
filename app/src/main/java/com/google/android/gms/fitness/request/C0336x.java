package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.fitness.data.Session;

/* renamed from: com.google.android.gms.fitness.request.x */
public class C0336x implements Creator<C0886w> {
    /* renamed from: a */
    static void m646a(C0886w c0886w, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m252a(parcel, 1, c0886w.getSession(), i, false);
        C0186b.m268c(parcel, 1000, c0886w.getVersionCode());
        C0186b.m244H(parcel, H);
    }

    public C0886w bV(Parcel parcel) {
        int G = C0185a.m208G(parcel);
        int i = 0;
        Session session = null;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    session = (Session) C0185a.m210a(parcel, F, Session.CREATOR);
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
            return new C0886w(i, session);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bV(x0);
    }

    public C0886w[] dq(int i) {
        return new C0886w[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dq(x0);
    }
}
