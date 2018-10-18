package com.google.android.gms.games.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

public class ConnectionInfoCreator implements Creator<ConnectionInfo> {
    /* renamed from: a */
    static void m679a(ConnectionInfo connectionInfo, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m256a(parcel, 1, connectionInfo.le(), false);
        C0186b.m268c(parcel, 1000, connectionInfo.getVersionCode());
        C0186b.m268c(parcel, 2, connectionInfo.lf());
        C0186b.m244H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ct(x0);
    }

    public ConnectionInfo ct(Parcel parcel) {
        int i = 0;
        int G = C0185a.m208G(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    str = C0185a.m229o(parcel, F);
                    break;
                case 2:
                    i = C0185a.m221g(parcel, F);
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
            return new ConnectionInfo(i2, str, i);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public ConnectionInfo[] dR(int i) {
        return new ConnectionInfo[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dR(x0);
    }
}
