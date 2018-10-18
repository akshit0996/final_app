package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.internal.jg.C0998a;
import java.util.List;

public class jw implements Creator<C0998a> {
    /* renamed from: a */
    static void m1572a(C0998a c0998a, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m256a(parcel, 1, c0998a.getAccountName(), false);
        C0186b.m268c(parcel, 1000, c0998a.getVersionCode());
        C0186b.m267b(parcel, 2, c0998a.ho(), false);
        C0186b.m268c(parcel, 3, c0998a.hn());
        C0186b.m256a(parcel, 4, c0998a.hq(), false);
        C0186b.m244H(parcel, H);
    }

    /* renamed from: E */
    public C0998a m1573E(Parcel parcel) {
        int i = 0;
        String str = null;
        int G = C0185a.m208G(parcel);
        List list = null;
        String str2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    str2 = C0185a.m229o(parcel, F);
                    break;
                case 2:
                    list = C0185a.m204C(parcel, F);
                    break;
                case 3:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 4:
                    str = C0185a.m229o(parcel, F);
                    break;
                case 1000:
                    i2 = C0185a.m221g(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new C0998a(i2, str2, list, i, str);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public C0998a[] aG(int i) {
        return new C0998a[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m1573E(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aG(x0);
    }
}
