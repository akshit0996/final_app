package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.drive.query.internal.l */
public class C0240l implements Creator<Operator> {
    /* renamed from: a */
    static void m425a(Operator operator, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1000, operator.CK);
        C0186b.m256a(parcel, 1, operator.mTag, false);
        C0186b.m244H(parcel, H);
    }

    public Operator bb(Parcel parcel) {
        int G = C0185a.m208G(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    str = C0185a.m229o(parcel, F);
                    break;
                case 1000:
                    i = C0185a.m221g(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new Operator(i, str);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public Operator[] cq(int i) {
        return new Operator[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bb(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cq(x0);
    }
}
