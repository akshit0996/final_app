package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

public class az implements Creator<ay> {
    /* renamed from: a */
    static void m1040a(ay ayVar, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, ayVar.versionCode);
        C0186b.m256a(parcel, 2, ayVar.op, false);
        C0186b.m268c(parcel, 3, ayVar.height);
        C0186b.m268c(parcel, 4, ayVar.heightPixels);
        C0186b.m259a(parcel, 5, ayVar.oq);
        C0186b.m268c(parcel, 6, ayVar.width);
        C0186b.m268c(parcel, 7, ayVar.widthPixels);
        C0186b.m262a(parcel, 8, ayVar.or, i, false);
        C0186b.m244H(parcel, H);
    }

    /* renamed from: c */
    public ay m1041c(Parcel parcel) {
        ay[] ayVarArr = null;
        int i = 0;
        int G = C0185a.m208G(parcel);
        int i2 = 0;
        boolean z = false;
        int i3 = 0;
        int i4 = 0;
        String str = null;
        int i5 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i5 = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    str = C0185a.m229o(parcel, F);
                    break;
                case 3:
                    i4 = C0185a.m221g(parcel, F);
                    break;
                case 4:
                    i3 = C0185a.m221g(parcel, F);
                    break;
                case 5:
                    z = C0185a.m217c(parcel, F);
                    break;
                case 6:
                    i2 = C0185a.m221g(parcel, F);
                    break;
                case 7:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 8:
                    ayVarArr = (ay[]) C0185a.m215b(parcel, F, ay.CREATOR);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new ay(i5, str, i4, i3, z, i2, i, ayVarArr);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m1041c(x0);
    }

    /* renamed from: g */
    public ay[] m1042g(int i) {
        return new ay[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m1042g(x0);
    }
}
