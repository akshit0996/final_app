package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.drive.query.internal.FieldWithSortOrder;
import java.util.List;

/* renamed from: com.google.android.gms.drive.query.b */
public class C0228b implements Creator<SortOrder> {
    /* renamed from: a */
    static void m408a(SortOrder sortOrder, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1000, sortOrder.CK);
        C0186b.m269c(parcel, 1, sortOrder.Sf, false);
        C0186b.m259a(parcel, 2, sortOrder.Sg);
        C0186b.m244H(parcel, H);
    }

    public SortOrder aR(Parcel parcel) {
        boolean z = false;
        int G = C0185a.m208G(parcel);
        List list = null;
        int i = 0;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    list = C0185a.m216c(parcel, F, FieldWithSortOrder.CREATOR);
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
            return new SortOrder(i, list, z);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public SortOrder[] cg(int i) {
        return new SortOrder[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aR(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cg(x0);
    }
}
