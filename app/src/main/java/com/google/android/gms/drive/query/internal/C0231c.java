package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.drive.query.internal.c */
public class C0231c implements Creator<FieldWithSortOrder> {
    /* renamed from: a */
    static void m411a(FieldWithSortOrder fieldWithSortOrder, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1000, fieldWithSortOrder.CK);
        C0186b.m256a(parcel, 1, fieldWithSortOrder.QY, false);
        C0186b.m259a(parcel, 2, fieldWithSortOrder.Sk);
        C0186b.m244H(parcel, H);
    }

    public FieldWithSortOrder aU(Parcel parcel) {
        boolean z = false;
        int G = C0185a.m208G(parcel);
        String str = null;
        int i = 0;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    str = C0185a.m229o(parcel, F);
                    break;
                case 2:
                    z = C0185a.m217c(parcel, F);
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
            return new FieldWithSortOrder(i, str, z);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public FieldWithSortOrder[] cj(int i) {
        return new FieldWithSortOrder[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aU(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cj(x0);
    }
}
