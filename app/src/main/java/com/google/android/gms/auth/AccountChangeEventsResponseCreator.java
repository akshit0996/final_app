package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import java.util.List;

public class AccountChangeEventsResponseCreator implements Creator<AccountChangeEventsResponse> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m93a(AccountChangeEventsResponse accountChangeEventsResponse, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, accountChangeEventsResponse.Ef);
        C0186b.m269c(parcel, 2, accountChangeEventsResponse.mp, false);
        C0186b.m244H(parcel, H);
    }

    public AccountChangeEventsResponse createFromParcel(Parcel parcel) {
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
                    list = C0185a.m216c(parcel, F, AccountChangeEvent.CREATOR);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new AccountChangeEventsResponse(i, list);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public AccountChangeEventsResponse[] newArray(int size) {
        return new AccountChangeEventsResponse[size];
    }
}
