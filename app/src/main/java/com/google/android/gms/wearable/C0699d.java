package com.google.android.gms.wearable;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.wearable.d */
public class C0699d implements Creator<C1261c> {
    /* renamed from: a */
    static void m2274a(C1261c c1261c, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, c1261c.CK);
        C0186b.m256a(parcel, 2, c1261c.getName(), false);
        C0186b.m256a(parcel, 3, c1261c.getAddress(), false);
        C0186b.m268c(parcel, 4, c1261c.getType());
        C0186b.m268c(parcel, 5, c1261c.getRole());
        C0186b.m259a(parcel, 6, c1261c.isEnabled());
        C0186b.m259a(parcel, 7, c1261c.isConnected());
        C0186b.m256a(parcel, 8, c1261c.rj(), false);
        C0186b.m244H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return em(x0);
    }

    public C1261c em(Parcel parcel) {
        String str = null;
        boolean z = false;
        int G = C0185a.m208G(parcel);
        boolean z2 = false;
        int i = 0;
        int i2 = 0;
        String str2 = null;
        String str3 = null;
        int i3 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i3 = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    str3 = C0185a.m229o(parcel, F);
                    break;
                case 3:
                    str2 = C0185a.m229o(parcel, F);
                    break;
                case 4:
                    i2 = C0185a.m221g(parcel, F);
                    break;
                case 5:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 6:
                    z2 = C0185a.m217c(parcel, F);
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
            return new C1261c(i3, str3, str2, i2, i, z2, z, str);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public C1261c[] gv(int i) {
        return new C1261c[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return gv(x0);
    }
}
