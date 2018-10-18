package com.google.android.gms.identity.intents;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.identity.intents.model.CountrySpecification;
import java.util.List;

/* renamed from: com.google.android.gms.identity.intents.a */
public class C0358a implements Creator<UserAddressRequest> {
    /* renamed from: a */
    static void m973a(UserAddressRequest userAddressRequest, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, userAddressRequest.getVersionCode());
        C0186b.m269c(parcel, 2, userAddressRequest.afH, false);
        C0186b.m244H(parcel, H);
    }

    public UserAddressRequest cF(Parcel parcel) {
        int G = C0185a.m208G(parcel);
        int i = 0;
        List list = null;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    list = C0185a.m216c(parcel, F, CountrySpecification.CREATOR);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new UserAddressRequest(i, list);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cF(x0);
    }

    public UserAddressRequest[] es(int i) {
        return new UserAddressRequest[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return es(x0);
    }
}
