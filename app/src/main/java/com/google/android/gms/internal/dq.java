package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

public class dq implements Creator<dr> {
    /* renamed from: a */
    static void m1140a(dr drVar, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, drVar.versionCode);
        C0186b.m252a(parcel, 2, drVar.sb, i, false);
        C0186b.m250a(parcel, 3, drVar.ck(), false);
        C0186b.m250a(parcel, 4, drVar.cl(), false);
        C0186b.m250a(parcel, 5, drVar.cm(), false);
        C0186b.m250a(parcel, 6, drVar.cn(), false);
        C0186b.m256a(parcel, 7, drVar.sg, false);
        C0186b.m259a(parcel, 8, drVar.sh);
        C0186b.m256a(parcel, 9, drVar.si, false);
        C0186b.m250a(parcel, 10, drVar.cp(), false);
        C0186b.m268c(parcel, 11, drVar.orientation);
        C0186b.m268c(parcel, 12, drVar.sk);
        C0186b.m256a(parcel, 13, drVar.rH, false);
        C0186b.m252a(parcel, 14, drVar.lO, i, false);
        C0186b.m250a(parcel, 15, drVar.co(), false);
        C0186b.m252a(parcel, 17, drVar.sn, i, false);
        C0186b.m256a(parcel, 16, drVar.sm, false);
        C0186b.m244H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m1141f(x0);
    }

    /* renamed from: f */
    public dr m1141f(Parcel parcel) {
        int G = C0185a.m208G(parcel);
        int i = 0;
        C0934do c0934do = null;
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        IBinder iBinder4 = null;
        String str = null;
        boolean z = false;
        String str2 = null;
        IBinder iBinder5 = null;
        int i2 = 0;
        int i3 = 0;
        String str3 = null;
        gs gsVar = null;
        IBinder iBinder6 = null;
        String str4 = null;
        C1081y c1081y = null;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    c0934do = (C0934do) C0185a.m210a(parcel, F, C0934do.CREATOR);
                    break;
                case 3:
                    iBinder = C0185a.m230p(parcel, F);
                    break;
                case 4:
                    iBinder2 = C0185a.m230p(parcel, F);
                    break;
                case 5:
                    iBinder3 = C0185a.m230p(parcel, F);
                    break;
                case 6:
                    iBinder4 = C0185a.m230p(parcel, F);
                    break;
                case 7:
                    str = C0185a.m229o(parcel, F);
                    break;
                case 8:
                    z = C0185a.m217c(parcel, F);
                    break;
                case 9:
                    str2 = C0185a.m229o(parcel, F);
                    break;
                case 10:
                    iBinder5 = C0185a.m230p(parcel, F);
                    break;
                case 11:
                    i2 = C0185a.m221g(parcel, F);
                    break;
                case 12:
                    i3 = C0185a.m221g(parcel, F);
                    break;
                case 13:
                    str3 = C0185a.m229o(parcel, F);
                    break;
                case 14:
                    gsVar = (gs) C0185a.m210a(parcel, F, (Creator) gs.CREATOR);
                    break;
                case 15:
                    iBinder6 = C0185a.m230p(parcel, F);
                    break;
                case 16:
                    str4 = C0185a.m229o(parcel, F);
                    break;
                case 17:
                    c1081y = (C1081y) C0185a.m210a(parcel, F, (Creator) C1081y.CREATOR);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new dr(i, c0934do, iBinder, iBinder2, iBinder3, iBinder4, str, z, str2, iBinder5, i2, i3, str3, gsVar, iBinder6, str4, c1081y);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    /* renamed from: n */
    public dr[] m1142n(int i) {
        return new dr[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m1142n(x0);
    }
}
