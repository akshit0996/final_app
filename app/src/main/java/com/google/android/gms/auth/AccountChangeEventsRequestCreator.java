package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

public class AccountChangeEventsRequestCreator implements Creator<AccountChangeEventsRequest> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m92a(AccountChangeEventsRequest accountChangeEventsRequest, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, accountChangeEventsRequest.Ef);
        C0186b.m268c(parcel, 2, accountChangeEventsRequest.Ei);
        C0186b.m256a(parcel, 3, accountChangeEventsRequest.DZ, false);
        C0186b.m244H(parcel, H);
    }

    public AccountChangeEventsRequest createFromParcel(Parcel parcel) {
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
                    i = C0185a.m221g(parcel, F);
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
            return new AccountChangeEventsRequest(i2, i, str);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public AccountChangeEventsRequest[] newArray(int size) {
        return new AccountChangeEventsRequest[size];
    }
}
