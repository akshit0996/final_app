package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.internal.hl.C0977a;

public class hm implements Creator<C0977a> {
    /* renamed from: a */
    static void m1397a(C0977a c0977a, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m252a(parcel, 1, c0977a.Dc, i, false);
        C0186b.m268c(parcel, 1000, c0977a.CK);
        C0186b.m244H(parcel, H);
    }

    /* renamed from: N */
    public C0977a[] m1398N(int i) {
        return new C0977a[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m1399p(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m1398N(x0);
    }

    /* renamed from: p */
    public C0977a m1399p(Parcel parcel) {
        int G = C0185a.m208G(parcel);
        int i = 0;
        Account account = null;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    account = (Account) C0185a.m210a(parcel, F, Account.CREATOR);
                    break;
                case 1000:
                    i = C0185a.m221g(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new C0977a(i, account);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }
}
