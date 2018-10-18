package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.fitness.request.k */
public class C0324k implements Creator<C0879j> {
    /* renamed from: a */
    static void m634a(C0879j c0879j, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m256a(parcel, 1, c0879j.getName(), false);
        C0186b.m268c(parcel, 1000, c0879j.getVersionCode());
        C0186b.m244H(parcel, H);
    }

    public C0879j bO(Parcel parcel) {
        int G = C0185a.m208G(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    str = C0185a.m229o(parcel, F);
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
            return new C0879j(i, str);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bO(x0);
    }

    public C0879j[] di(int i) {
        return new C0879j[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return di(x0);
    }
}
