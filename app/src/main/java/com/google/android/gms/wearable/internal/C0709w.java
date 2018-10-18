package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import java.util.List;

/* renamed from: com.google.android.gms.wearable.internal.w */
public class C0709w implements Creator<C1277v> {
    /* renamed from: a */
    static void m2333a(C1277v c1277v, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, c1277v.versionCode);
        C0186b.m268c(parcel, 2, c1277v.statusCode);
        C0186b.m269c(parcel, 3, c1277v.axL, false);
        C0186b.m244H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return eu(x0);
    }

    public C1277v eu(Parcel parcel) {
        int i = 0;
        int G = C0185a.m208G(parcel);
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
                    list = C0185a.m216c(parcel, F, al.CREATOR);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new C1277v(i2, i, list);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public C1277v[] gD(int i) {
        return new C1277v[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return gD(x0);
    }
}
