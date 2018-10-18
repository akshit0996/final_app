package com.google.android.gms.identity.intents.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.identity.intents.model.a */
public class C0359a implements Creator<CountrySpecification> {
    /* renamed from: a */
    static void m974a(CountrySpecification countrySpecification, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, countrySpecification.getVersionCode());
        C0186b.m256a(parcel, 2, countrySpecification.vk, false);
        C0186b.m244H(parcel, H);
    }

    public CountrySpecification cG(Parcel parcel) {
        int G = C0185a.m208G(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    str = C0185a.m229o(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new CountrySpecification(i, str);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cG(x0);
    }

    public CountrySpecification[] et(int i) {
        return new CountrySpecification[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return et(x0);
    }
}
