package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

public class aj implements Creator<ai> {
    /* renamed from: a */
    static void m2320a(ai aiVar, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, aiVar.CK);
        C0186b.m268c(parcel, 2, aiVar.getRequestId());
        C0186b.m256a(parcel, 3, aiVar.getPath(), false);
        C0186b.m260a(parcel, 4, aiVar.getData(), false);
        C0186b.m256a(parcel, 5, aiVar.getSourceNodeId(), false);
        C0186b.m244H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ey(x0);
    }

    public ai ey(Parcel parcel) {
        int i = 0;
        String str = null;
        int G = C0185a.m208G(parcel);
        byte[] bArr = null;
        String str2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i2 = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 3:
                    str2 = C0185a.m229o(parcel, F);
                    break;
                case 4:
                    bArr = C0185a.m232r(parcel, F);
                    break;
                case 5:
                    str = C0185a.m229o(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new ai(i2, i, str2, bArr, str);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public ai[] gH(int i) {
        return new ai[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return gH(x0);
    }
}
