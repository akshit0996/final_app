package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.internal.z */
public class C0513z implements Creator<C1081y> {
    /* renamed from: a */
    static void m1929a(C1081y c1081y, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, c1081y.versionCode);
        C0186b.m259a(parcel, 2, c1081y.mi);
        C0186b.m259a(parcel, 3, c1081y.ms);
        C0186b.m244H(parcel, H);
    }

    /* renamed from: a */
    public C1081y m1930a(Parcel parcel) {
        boolean z = false;
        int G = C0185a.m208G(parcel);
        boolean z2 = false;
        int i = 0;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    z2 = C0185a.m217c(parcel, F);
                    break;
                case 3:
                    z = C0185a.m217c(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new C1081y(i, z2, z);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    /* renamed from: b */
    public C1081y[] m1931b(int i) {
        return new C1081y[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m1930a(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m1931b(x0);
    }
}
