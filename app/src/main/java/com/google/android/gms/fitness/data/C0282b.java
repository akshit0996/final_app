package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.fitness.data.b */
public class C0282b implements Creator<C0873a> {
    /* renamed from: a */
    static void m538a(C0873a c0873a, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m256a(parcel, 1, c0873a.getPackageName(), false);
        C0186b.m268c(parcel, 1000, c0873a.getVersionCode());
        C0186b.m256a(parcel, 2, c0873a.getVersion(), false);
        C0186b.m256a(parcel, 3, c0873a.jk(), false);
        C0186b.m244H(parcel, H);
    }

    public C0873a bq(Parcel parcel) {
        String str = null;
        int G = C0185a.m208G(parcel);
        int i = 0;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    str3 = C0185a.m229o(parcel, F);
                    break;
                case 2:
                    str2 = C0185a.m229o(parcel, F);
                    break;
                case 3:
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
            return new C0873a(i, str3, str2, str);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public C0873a[] cH(int i) {
        return new C0873a[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bq(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cH(x0);
    }
}
