package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.drive.query.internal.k */
public class C0239k implements Creator<NotFilter> {
    /* renamed from: a */
    static void m424a(NotFilter notFilter, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1000, notFilter.CK);
        C0186b.m252a(parcel, 1, notFilter.Sv, i, false);
        C0186b.m244H(parcel, H);
    }

    public NotFilter ba(Parcel parcel) {
        int G = C0185a.m208G(parcel);
        int i = 0;
        FilterHolder filterHolder = null;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    filterHolder = (FilterHolder) C0185a.m210a(parcel, F, FilterHolder.CREATOR);
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
            return new NotFilter(i, filterHolder);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public NotFilter[] cp(int i) {
        return new NotFilter[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ba(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cp(x0);
    }
}
