package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import java.util.List;

public class nv implements Creator<nu> {
    /* renamed from: a */
    static void m1746a(nu nuVar, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m269c(parcel, 1, nuVar.ahn, false);
        C0186b.m268c(parcel, 1000, nuVar.CK);
        C0186b.m256a(parcel, 2, nuVar.nu(), false);
        C0186b.m259a(parcel, 3, nuVar.nv());
        C0186b.m269c(parcel, 4, nuVar.aht, false);
        C0186b.m267b(parcel, 6, nuVar.ahu, false);
        C0186b.m244H(parcel, H);
    }

    public nu cQ(Parcel parcel) {
        boolean z = false;
        List list = null;
        int G = C0185a.m208G(parcel);
        List list2 = null;
        String str = null;
        List list3 = null;
        int i = 0;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    list3 = C0185a.m216c(parcel, F, oa.CREATOR);
                    break;
                case 2:
                    str = C0185a.m229o(parcel, F);
                    break;
                case 3:
                    z = C0185a.m217c(parcel, F);
                    break;
                case 4:
                    list2 = C0185a.m216c(parcel, F, oe.CREATOR);
                    break;
                case 6:
                    list = C0185a.m204C(parcel, F);
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
            return new nu(i, list3, str, z, list2, list);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cQ(x0);
    }

    public nu[] eM(int i) {
        return new nu[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return eM(x0);
    }
}
