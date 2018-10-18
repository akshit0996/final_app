package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.drive.realtime.internal.event.j */
public class C0255j implements Creator<ValuesSetDetails> {
    /* renamed from: a */
    static void m443a(ValuesSetDetails valuesSetDetails, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, valuesSetDetails.CK);
        C0186b.m268c(parcel, 2, valuesSetDetails.mIndex);
        C0186b.m268c(parcel, 3, valuesSetDetails.SO);
        C0186b.m268c(parcel, 4, valuesSetDetails.SP);
        C0186b.m244H(parcel, H);
    }

    public ValuesSetDetails bp(Parcel parcel) {
        int i = 0;
        int G = C0185a.m208G(parcel);
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i4 = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    i3 = C0185a.m221g(parcel, F);
                    break;
                case 3:
                    i2 = C0185a.m221g(parcel, F);
                    break;
                case 4:
                    i = C0185a.m221g(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new ValuesSetDetails(i4, i3, i2, i);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public ValuesSetDetails[] cF(int i) {
        return new ValuesSetDetails[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bp(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cF(x0);
    }
}
