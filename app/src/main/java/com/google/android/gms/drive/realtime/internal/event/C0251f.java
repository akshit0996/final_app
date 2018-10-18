package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.drive.realtime.internal.event.f */
public class C0251f implements Creator<TextInsertedDetails> {
    /* renamed from: a */
    static void m439a(TextInsertedDetails textInsertedDetails, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, textInsertedDetails.CK);
        C0186b.m268c(parcel, 2, textInsertedDetails.mIndex);
        C0186b.m268c(parcel, 3, textInsertedDetails.Ti);
        C0186b.m244H(parcel, H);
    }

    public TextInsertedDetails bl(Parcel parcel) {
        int i = 0;
        int G = C0185a.m208G(parcel);
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i3 = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    i2 = C0185a.m221g(parcel, F);
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
            return new TextInsertedDetails(i3, i2, i);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public TextInsertedDetails[] cB(int i) {
        return new TextInsertedDetails[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bl(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cB(x0);
    }
}
