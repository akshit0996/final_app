package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

public class AccountChangeEventCreator implements Creator<AccountChangeEvent> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m91a(AccountChangeEvent accountChangeEvent, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, accountChangeEvent.Ef);
        C0186b.m248a(parcel, 2, accountChangeEvent.Eg);
        C0186b.m256a(parcel, 3, accountChangeEvent.DZ, false);
        C0186b.m268c(parcel, 4, accountChangeEvent.Eh);
        C0186b.m268c(parcel, 5, accountChangeEvent.Ei);
        C0186b.m256a(parcel, 6, accountChangeEvent.Ej, false);
        C0186b.m244H(parcel, H);
    }

    public AccountChangeEvent createFromParcel(Parcel parcel) {
        String str = null;
        int i = 0;
        int G = C0185a.m208G(parcel);
        long j = 0;
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
                    j = C0185a.m223i(parcel, F);
                    break;
                case 3:
                    str2 = C0185a.m229o(parcel, F);
                    break;
                case 4:
                    i2 = C0185a.m221g(parcel, F);
                    break;
                case 5:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 6:
                    str = C0185a.m229o(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new AccountChangeEvent(i3, j, str2, i2, i, str);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public AccountChangeEvent[] newArray(int size) {
        return new AccountChangeEvent[size];
    }
}
