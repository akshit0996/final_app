package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

public class ip implements Creator<io> {
    /* renamed from: a */
    static void m1451a(io ioVar, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, ioVar.getVersionCode());
        C0186b.m246a(parcel, 2, ioVar.fZ());
        C0186b.m259a(parcel, 3, ioVar.gi());
        C0186b.m268c(parcel, 4, ioVar.gj());
        C0186b.m252a(parcel, 5, ioVar.getApplicationMetadata(), i, false);
        C0186b.m268c(parcel, 6, ioVar.gk());
        C0186b.m244H(parcel, H);
    }

    public io[] ai(int i) {
        return new io[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m1452y(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ai(x0);
    }

    /* renamed from: y */
    public io m1452y(Parcel parcel) {
        int i = 0;
        int G = C0185a.m208G(parcel);
        double d = 0.0d;
        ApplicationMetadata applicationMetadata = null;
        int i2 = 0;
        boolean z = false;
        int i3 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i3 = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    d = C0185a.m227m(parcel, F);
                    break;
                case 3:
                    z = C0185a.m217c(parcel, F);
                    break;
                case 4:
                    i2 = C0185a.m221g(parcel, F);
                    break;
                case 5:
                    applicationMetadata = (ApplicationMetadata) C0185a.m210a(parcel, F, ApplicationMetadata.CREATOR);
                    break;
                case 6:
                    i = C0185a.m221g(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new io(i3, d, z, i2, applicationMetadata, i);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }
}
