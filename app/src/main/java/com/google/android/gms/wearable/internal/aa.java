package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

public class aa implements Creator<C1279z> {
    /* renamed from: a */
    static void m2276a(C1279z c1279z, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, c1279z.versionCode);
        C0186b.m268c(parcel, 2, c1279z.statusCode);
        C0186b.m252a(parcel, 3, c1279z.axN, i, false);
        C0186b.m244H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ew(x0);
    }

    public C1279z ew(Parcel parcel) {
        int i = 0;
        int G = C0185a.m208G(parcel);
        ParcelFileDescriptor parcelFileDescriptor = null;
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
                    parcelFileDescriptor = (ParcelFileDescriptor) C0185a.m210a(parcel, F, ParcelFileDescriptor.CREATOR);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new C1279z(i2, i, parcelFileDescriptor);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public C1279z[] gF(int i) {
        return new C1279z[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return gF(x0);
    }
}
