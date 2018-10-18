package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import java.util.List;

public class ax implements Creator<aw> {
    /* renamed from: a */
    static void m2326a(aw awVar, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, awVar.versionCode);
        C0186b.m268c(parcel, 2, awVar.statusCode);
        C0186b.m248a(parcel, 3, awVar.ayc);
        C0186b.m269c(parcel, 4, awVar.aye, false);
        C0186b.m244H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return eE(x0);
    }

    public aw eE(Parcel parcel) {
        int i = 0;
        int G = C0185a.m208G(parcel);
        long j = 0;
        List list = null;
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
                    j = C0185a.m223i(parcel, F);
                    break;
                case 4:
                    list = C0185a.m216c(parcel, F, an.CREATOR);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new aw(i2, i, j, list);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public aw[] gO(int i) {
        return new aw[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return gO(x0);
    }
}
