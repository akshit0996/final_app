package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.wallet.h */
public class C0672h implements Creator<InstrumentInfo> {
    /* renamed from: a */
    static void m2248a(InstrumentInfo instrumentInfo, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, instrumentInfo.getVersionCode());
        C0186b.m256a(parcel, 2, instrumentInfo.getInstrumentType(), false);
        C0186b.m256a(parcel, 3, instrumentInfo.getInstrumentDetails(), false);
        C0186b.m244H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return dP(x0);
    }

    public InstrumentInfo dP(Parcel parcel) {
        String str = null;
        int G = C0185a.m208G(parcel);
        int i = 0;
        String str2 = null;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    str2 = C0185a.m229o(parcel, F);
                    break;
                case 3:
                    str = C0185a.m229o(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new InstrumentInfo(i, str2, str);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public InstrumentInfo[] fW(int i) {
        return new InstrumentInfo[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return fW(x0);
    }
}