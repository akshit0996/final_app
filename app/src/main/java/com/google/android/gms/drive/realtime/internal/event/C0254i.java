package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.drive.realtime.internal.event.i */
public class C0254i implements Creator<ValuesRemovedDetails> {
    /* renamed from: a */
    static void m442a(ValuesRemovedDetails valuesRemovedDetails, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, valuesRemovedDetails.CK);
        C0186b.m268c(parcel, 2, valuesRemovedDetails.mIndex);
        C0186b.m268c(parcel, 3, valuesRemovedDetails.SO);
        C0186b.m268c(parcel, 4, valuesRemovedDetails.SP);
        C0186b.m256a(parcel, 5, valuesRemovedDetails.Tm, false);
        C0186b.m268c(parcel, 6, valuesRemovedDetails.Tn);
        C0186b.m244H(parcel, H);
    }

    public ValuesRemovedDetails bo(Parcel parcel) {
        int i = 0;
        int G = C0185a.m208G(parcel);
        String str = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i5 = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    i4 = C0185a.m221g(parcel, F);
                    break;
                case 3:
                    i3 = C0185a.m221g(parcel, F);
                    break;
                case 4:
                    i2 = C0185a.m221g(parcel, F);
                    break;
                case 5:
                    str = C0185a.m229o(parcel, F);
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
            return new ValuesRemovedDetails(i5, i4, i3, i2, str, i);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public ValuesRemovedDetails[] cE(int i) {
        return new ValuesRemovedDetails[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bo(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cE(x0);
    }
}
