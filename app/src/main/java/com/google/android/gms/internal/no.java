package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

public class no implements Creator<nn> {
    /* renamed from: a */
    static void m1743a(nn nnVar, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m256a(parcel, 1, nnVar.getRequestId(), false);
        C0186b.m268c(parcel, 1000, nnVar.getVersionCode());
        C0186b.m248a(parcel, 2, nnVar.getExpirationTime());
        C0186b.m258a(parcel, 3, nnVar.nn());
        C0186b.m246a(parcel, 4, nnVar.getLatitude());
        C0186b.m246a(parcel, 5, nnVar.getLongitude());
        C0186b.m247a(parcel, 6, nnVar.no());
        C0186b.m268c(parcel, 7, nnVar.np());
        C0186b.m268c(parcel, 8, nnVar.getNotificationResponsiveness());
        C0186b.m268c(parcel, 9, nnVar.nq());
        C0186b.m244H(parcel, H);
    }

    public nn cN(Parcel parcel) {
        int G = C0185a.m208G(parcel);
        int i = 0;
        String str = null;
        int i2 = 0;
        short s = (short) 0;
        double d = 0.0d;
        double d2 = 0.0d;
        float f = 0.0f;
        long j = 0;
        int i3 = 0;
        int i4 = -1;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    str = C0185a.m229o(parcel, F);
                    break;
                case 2:
                    j = C0185a.m223i(parcel, F);
                    break;
                case 3:
                    s = C0185a.m220f(parcel, F);
                    break;
                case 4:
                    d = C0185a.m227m(parcel, F);
                    break;
                case 5:
                    d2 = C0185a.m227m(parcel, F);
                    break;
                case 6:
                    f = C0185a.m226l(parcel, F);
                    break;
                case 7:
                    i2 = C0185a.m221g(parcel, F);
                    break;
                case 8:
                    i3 = C0185a.m221g(parcel, F);
                    break;
                case 9:
                    i4 = C0185a.m221g(parcel, F);
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
            return new nn(i, str, i2, s, d, d2, f, j, i3, i4);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cN(x0);
    }

    public nn[] eJ(int i) {
        return new nn[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return eJ(x0);
    }
}
