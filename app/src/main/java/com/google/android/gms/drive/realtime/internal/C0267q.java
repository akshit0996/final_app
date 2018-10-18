package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.drive.realtime.internal.q */
public class C0267q implements Creator<ParcelableIndexReference> {
    /* renamed from: a */
    static void m499a(ParcelableIndexReference parcelableIndexReference, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, parcelableIndexReference.CK);
        C0186b.m256a(parcel, 2, parcelableIndexReference.SM, false);
        C0186b.m268c(parcel, 3, parcelableIndexReference.mIndex);
        C0186b.m259a(parcel, 4, parcelableIndexReference.SN);
        C0186b.m244H(parcel, H);
    }

    public ParcelableIndexReference bf(Parcel parcel) {
        boolean z = false;
        int G = C0185a.m208G(parcel);
        String str = null;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i2 = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    str = C0185a.m229o(parcel, F);
                    break;
                case 3:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 4:
                    z = C0185a.m217c(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new ParcelableIndexReference(i2, str, i, z);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bf(x0);
    }

    public ParcelableIndexReference[] cv(int i) {
        return new ParcelableIndexReference[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cv(x0);
    }
}
