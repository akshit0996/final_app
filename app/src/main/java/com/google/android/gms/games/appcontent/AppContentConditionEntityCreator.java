package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

public class AppContentConditionEntityCreator implements Creator<AppContentConditionEntity> {
    /* renamed from: a */
    static void m669a(AppContentConditionEntity appContentConditionEntity, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m256a(parcel, 1, appContentConditionEntity.kT(), false);
        C0186b.m268c(parcel, 1000, appContentConditionEntity.getVersionCode());
        C0186b.m256a(parcel, 2, appContentConditionEntity.kU(), false);
        C0186b.m256a(parcel, 3, appContentConditionEntity.kV(), false);
        C0186b.m249a(parcel, 4, appContentConditionEntity.kW(), false);
        C0186b.m244H(parcel, H);
    }

    public AppContentConditionEntity cq(Parcel parcel) {
        Bundle bundle = null;
        int G = C0185a.m208G(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    str3 = C0185a.m229o(parcel, F);
                    break;
                case 2:
                    str2 = C0185a.m229o(parcel, F);
                    break;
                case 3:
                    str = C0185a.m229o(parcel, F);
                    break;
                case 4:
                    bundle = C0185a.m231q(parcel, F);
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
            return new AppContentConditionEntity(i, str3, str2, str, bundle);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cq(x0);
    }

    public AppContentConditionEntity[] dL(int i) {
        return new AppContentConditionEntity[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dL(x0);
    }
}
