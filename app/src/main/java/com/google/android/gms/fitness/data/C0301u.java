package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.fitness.data.u */
public class C0301u implements Creator<Value> {
    /* renamed from: a */
    static void m558a(Value value, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, value.getFormat());
        C0186b.m268c(parcel, 1000, value.getVersionCode());
        C0186b.m259a(parcel, 2, value.isSet());
        C0186b.m247a(parcel, 3, value.jL());
        C0186b.m244H(parcel, H);
    }

    public Value bF(Parcel parcel) {
        boolean z = false;
        int G = C0185a.m208G(parcel);
        float f = 0.0f;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    z = C0185a.m217c(parcel, F);
                    break;
                case 3:
                    f = C0185a.m226l(parcel, F);
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
            return new Value(i2, i, z, f);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public Value[] cZ(int i) {
        return new Value[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bF(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cZ(x0);
    }
}
