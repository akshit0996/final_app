package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import java.util.ArrayList;

public class AppContentActionEntityCreator implements Creator<AppContentActionEntity> {
    /* renamed from: a */
    static void m666a(AppContentActionEntity appContentActionEntity, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m269c(parcel, 1, appContentActionEntity.kH(), false);
        C0186b.m268c(parcel, 1000, appContentActionEntity.getVersionCode());
        C0186b.m256a(parcel, 2, appContentActionEntity.kI(), false);
        C0186b.m249a(parcel, 3, appContentActionEntity.getExtras(), false);
        C0186b.m256a(parcel, 4, appContentActionEntity.getLabel(), false);
        C0186b.m256a(parcel, 5, appContentActionEntity.kJ(), false);
        C0186b.m256a(parcel, 6, appContentActionEntity.getType(), false);
        C0186b.m244H(parcel, H);
    }

    public AppContentActionEntity cn(Parcel parcel) {
        String str = null;
        int G = C0185a.m208G(parcel);
        int i = 0;
        String str2 = null;
        String str3 = null;
        Bundle bundle = null;
        String str4 = null;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    arrayList = C0185a.m216c(parcel, F, AppContentConditionEntity.CREATOR);
                    break;
                case 2:
                    str4 = C0185a.m229o(parcel, F);
                    break;
                case 3:
                    bundle = C0185a.m231q(parcel, F);
                    break;
                case 4:
                    str3 = C0185a.m229o(parcel, F);
                    break;
                case 5:
                    str2 = C0185a.m229o(parcel, F);
                    break;
                case 6:
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
            return new AppContentActionEntity(i, arrayList, str4, bundle, str3, str2, str);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cn(x0);
    }

    public AppContentActionEntity[] dI(int i) {
        return new AppContentActionEntity[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dI(x0);
    }
}
