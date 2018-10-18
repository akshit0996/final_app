package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

public class he implements Creator<hd> {
    /* renamed from: a */
    static void m1385a(hd hdVar, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m262a(parcel, 1, hdVar.CL, i, false);
        C0186b.m268c(parcel, 1000, hdVar.CK);
        C0186b.m256a(parcel, 2, hdVar.CM, false);
        C0186b.m259a(parcel, 3, hdVar.CN);
        C0186b.m252a(parcel, 4, hdVar.account, i, false);
        C0186b.m244H(parcel, H);
    }

    /* renamed from: J */
    public hd[] m1386J(int i) {
        return new hd[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m1387l(x0);
    }

    /* renamed from: l */
    public hd m1387l(Parcel parcel) {
        boolean z = false;
        Account account = null;
        int G = C0185a.m208G(parcel);
        String str = null;
        hh[] hhVarArr = null;
        int i = 0;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    hhVarArr = (hh[]) C0185a.m215b(parcel, F, hh.CREATOR);
                    break;
                case 2:
                    str = C0185a.m229o(parcel, F);
                    break;
                case 3:
                    z = C0185a.m217c(parcel, F);
                    break;
                case 4:
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
            return new hd(i, hhVarArr, str, z, account);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m1386J(x0);
    }
}
