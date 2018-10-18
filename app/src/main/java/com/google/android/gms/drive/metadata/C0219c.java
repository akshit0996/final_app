package com.google.android.gms.drive.metadata;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.drive.metadata.c */
public class C0219c implements Creator<CustomPropertyKey> {
    /* renamed from: a */
    static void m401a(CustomPropertyKey customPropertyKey, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, customPropertyKey.CK);
        C0186b.m256a(parcel, 2, customPropertyKey.KP, false);
        C0186b.m268c(parcel, 3, customPropertyKey.mVisibility);
        C0186b.m244H(parcel, H);
    }

    public CustomPropertyKey aM(Parcel parcel) {
        int i = 0;
        int G = C0185a.m208G(parcel);
        String str = null;
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
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new CustomPropertyKey(i2, str, i);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public CustomPropertyKey[] cb(int i) {
        return new CustomPropertyKey[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aM(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cb(x0);
    }
}
