package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.internal.la;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.wallet.wobs.e */
public class C0684e implements Creator<C1253d> {
    /* renamed from: a */
    static void m2258a(C1253d c1253d, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, c1253d.getVersionCode());
        C0186b.m256a(parcel, 2, c1253d.awJ, false);
        C0186b.m256a(parcel, 3, c1253d.awK, false);
        C0186b.m269c(parcel, 4, c1253d.awL, false);
        C0186b.m244H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ee(x0);
    }

    public C1253d ee(Parcel parcel) {
        String str = null;
        int G = C0185a.m208G(parcel);
        int i = 0;
        ArrayList ie = la.ie();
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
                case 4:
                    ie = C0185a.m216c(parcel, F, C1252b.CREATOR);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new C1253d(i, str2, str, ie);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public C1253d[] gn(int i) {
        return new C1253d[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return gn(x0);
    }
}
