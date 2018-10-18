package com.google.android.gms.maps.internal;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.maps.internal.z */
public class C0549z implements Creator<C1157y> {
    /* renamed from: a */
    static void m1979a(C1157y c1157y, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, c1157y.getVersionCode());
        C0186b.m252a(parcel, 2, c1157y.oa(), i, false);
        C0186b.m244H(parcel, H);
    }

    public C1157y cZ(Parcel parcel) {
        int G = C0185a.m208G(parcel);
        int i = 0;
        Point point = null;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    point = (Point) C0185a.m210a(parcel, F, Point.CREATOR);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new C1157y(i, point);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cZ(x0);
    }

    public C1157y[] eV(int i) {
        return new C1157y[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return eV(x0);
    }
}
