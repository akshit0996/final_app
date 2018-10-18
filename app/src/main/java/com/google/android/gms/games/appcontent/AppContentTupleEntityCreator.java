package com.google.android.gms.games.appcontent;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

public class AppContentTupleEntityCreator implements Creator<AppContentTupleEntity> {
    /* renamed from: a */
    static void m671a(AppContentTupleEntity appContentTupleEntity, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m256a(parcel, 1, appContentTupleEntity.getName(), false);
        C0186b.m268c(parcel, 1000, appContentTupleEntity.getVersionCode());
        C0186b.m256a(parcel, 2, appContentTupleEntity.getValue(), false);
        C0186b.m244H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cs(x0);
    }

    public AppContentTupleEntity cs(Parcel parcel) {
        String str = null;
        int G = C0185a.m208G(parcel);
        int i = 0;
        String str2 = null;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    str2 = C0185a.m229o(parcel, F);
                    break;
                case 2:
                    str = C0185a.m229o(parcel, F);
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
            return new AppContentTupleEntity(i, str2, str);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public AppContentTupleEntity[] dN(int i) {
        return new AppContentTupleEntity[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dN(x0);
    }
}
