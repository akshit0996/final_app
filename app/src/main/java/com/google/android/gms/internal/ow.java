package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

public class ow implements Creator<ov> {
    /* renamed from: a */
    static void m1769a(ov ovVar, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, ovVar.versionCode);
        C0186b.m256a(parcel, 2, ovVar.packageName, false);
        C0186b.m268c(parcel, 3, ovVar.ang);
        C0186b.m268c(parcel, 4, ovVar.anh);
        C0186b.m256a(parcel, 5, ovVar.ani, false);
        C0186b.m256a(parcel, 6, ovVar.anj, false);
        C0186b.m259a(parcel, 7, ovVar.ank);
        C0186b.m256a(parcel, 8, ovVar.anl, false);
        C0186b.m244H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return du(x0);
    }

    public ov du(Parcel parcel) {
        int i = 0;
        String str = null;
        int G = C0185a.m208G(parcel);
        boolean z = true;
        String str2 = null;
        String str3 = null;
        int i2 = 0;
        String str4 = null;
        int i3 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i3 = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    str4 = C0185a.m229o(parcel, F);
                    break;
                case 3:
                    i2 = C0185a.m221g(parcel, F);
                    break;
                case 4:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 5:
                    str3 = C0185a.m229o(parcel, F);
                    break;
                case 6:
                    str2 = C0185a.m229o(parcel, F);
                    break;
                case 7:
                    z = C0185a.m217c(parcel, F);
                    break;
                case 8:
                    str = C0185a.m229o(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new ov(i3, str4, i2, i, str3, str2, z, str);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public ov[] fr(int i) {
        return new ov[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return fr(x0);
    }
}
