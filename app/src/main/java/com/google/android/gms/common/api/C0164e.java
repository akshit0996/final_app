package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.common.api.e */
public class C0164e implements Creator<Scope> {
    /* renamed from: a */
    static void m163a(Scope scope, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, scope.CK);
        C0186b.m256a(parcel, 2, scope.gO(), false);
        C0186b.m244H(parcel, H);
    }

    public Scope[] am(int i) {
        return new Scope[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m164z(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return am(x0);
    }

    /* renamed from: z */
    public Scope m164z(Parcel parcel) {
        int G = C0185a.m208G(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    str = C0185a.m229o(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new Scope(i, str);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }
}
