package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.drive.realtime.internal.event.d */
public class C0249d implements Creator<ReferenceShiftedDetails> {
    /* renamed from: a */
    static void m437a(ReferenceShiftedDetails referenceShiftedDetails, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, referenceShiftedDetails.CK);
        C0186b.m256a(parcel, 2, referenceShiftedDetails.Te, false);
        C0186b.m256a(parcel, 3, referenceShiftedDetails.Tf, false);
        C0186b.m268c(parcel, 4, referenceShiftedDetails.Tg);
        C0186b.m268c(parcel, 5, referenceShiftedDetails.Th);
        C0186b.m244H(parcel, H);
    }

    public ReferenceShiftedDetails bj(Parcel parcel) {
        String str = null;
        int i = 0;
        int G = C0185a.m208G(parcel);
        int i2 = 0;
        String str2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i3 = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    str2 = C0185a.m229o(parcel, F);
                    break;
                case 3:
                    str = C0185a.m229o(parcel, F);
                    break;
                case 4:
                    i2 = C0185a.m221g(parcel, F);
                    break;
                case 5:
                    i = C0185a.m221g(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new ReferenceShiftedDetails(i3, str2, str, i2, i);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bj(x0);
    }

    public ReferenceShiftedDetails[] cz(int i) {
        return new ReferenceShiftedDetails[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cz(x0);
    }
}
