package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.internal.hl.C0978b;
import java.util.ArrayList;
import java.util.List;

public class hn implements Creator<C0978b> {
    /* renamed from: a */
    static void m1400a(C0978b c0978b, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1000, c0978b.CK);
        C0186b.m252a(parcel, 1, c0978b.Dd, i, false);
        C0186b.m269c(parcel, 2, c0978b.De, false);
        C0186b.m244H(parcel, H);
    }

    /* renamed from: O */
    public C0978b[] m1401O(int i) {
        return new C0978b[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m1402q(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m1401O(x0);
    }

    /* renamed from: q */
    public C0978b m1402q(Parcel parcel) {
        List list = null;
        int G = C0185a.m208G(parcel);
        int i = 0;
        Status status = null;
        while (parcel.dataPosition() < G) {
            int i2;
            Status status2;
            ArrayList c;
            int F = C0185a.m207F(parcel);
            List list2;
            switch (C0185a.aH(F)) {
                case 1:
                    i2 = i;
                    Status status3 = (Status) C0185a.m210a(parcel, F, Status.CREATOR);
                    list2 = list;
                    status2 = status3;
                    break;
                case 2:
                    c = C0185a.m216c(parcel, F, hr.CREATOR);
                    status2 = status;
                    i2 = i;
                    break;
                case 1000:
                    List list3 = list;
                    status2 = status;
                    i2 = C0185a.m221g(parcel, F);
                    list2 = list3;
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    c = list;
                    status2 = status;
                    i2 = i;
                    break;
            }
            i = i2;
            status = status2;
            Object obj = c;
        }
        if (parcel.dataPosition() == G) {
            return new C0978b(i, status, list);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }
}
