package com.google.android.gms.common.data;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.common.data.b */
public class C0172b implements Creator<C0810a> {
    /* renamed from: a */
    static void m170a(C0810a c0810a, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, c0810a.CK);
        C0186b.m252a(parcel, 2, c0810a.KS, i, false);
        C0186b.m268c(parcel, 3, c0810a.Gt);
        C0186b.m244H(parcel, H);
    }

    /* renamed from: A */
    public C0810a m171A(Parcel parcel) {
        int i = 0;
        int G = C0185a.m208G(parcel);
        ParcelFileDescriptor parcelFileDescriptor = null;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            ParcelFileDescriptor parcelFileDescriptor2;
            int g;
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    int i3 = i;
                    parcelFileDescriptor2 = parcelFileDescriptor;
                    g = C0185a.m221g(parcel, F);
                    F = i3;
                    break;
                case 2:
                    g = i2;
                    ParcelFileDescriptor parcelFileDescriptor3 = (ParcelFileDescriptor) C0185a.m210a(parcel, F, ParcelFileDescriptor.CREATOR);
                    F = i;
                    parcelFileDescriptor2 = parcelFileDescriptor3;
                    break;
                case 3:
                    F = C0185a.m221g(parcel, F);
                    parcelFileDescriptor2 = parcelFileDescriptor;
                    g = i2;
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    F = i;
                    parcelFileDescriptor2 = parcelFileDescriptor;
                    g = i2;
                    break;
            }
            i2 = g;
            parcelFileDescriptor = parcelFileDescriptor2;
            i = F;
        }
        if (parcel.dataPosition() == G) {
            return new C0810a(i2, parcelFileDescriptor, i);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public C0810a[] ar(int i) {
        return new C0810a[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m171A(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ar(x0);
    }
}
