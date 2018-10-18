package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import java.util.ArrayList;

public class AppContentSectionEntityCreator implements Creator<AppContentSectionEntity> {
    /* renamed from: a */
    static void m670a(AppContentSectionEntity appContentSectionEntity, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m269c(parcel, 1, appContentSectionEntity.getActions(), false);
        C0186b.m268c(parcel, 1000, appContentSectionEntity.getVersionCode());
        C0186b.m252a(parcel, 2, appContentSectionEntity.kY(), i, false);
        C0186b.m269c(parcel, 3, appContentSectionEntity.kZ(), false);
        C0186b.m256a(parcel, 4, appContentSectionEntity.kI(), false);
        C0186b.m249a(parcel, 5, appContentSectionEntity.kP(), false);
        C0186b.m256a(parcel, 6, appContentSectionEntity.kQ(), false);
        C0186b.m256a(parcel, 7, appContentSectionEntity.getTitle(), false);
        C0186b.m256a(parcel, 8, appContentSectionEntity.getType(), false);
        C0186b.m244H(parcel, H);
    }

    public AppContentSectionEntity cr(Parcel parcel) {
        String str = null;
        int G = C0185a.m208G(parcel);
        int i = 0;
        String str2 = null;
        String str3 = null;
        Bundle bundle = null;
        String str4 = null;
        ArrayList arrayList = null;
        Uri uri = null;
        ArrayList arrayList2 = null;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    arrayList2 = C0185a.m216c(parcel, F, AppContentActionEntity.CREATOR);
                    break;
                case 2:
                    uri = (Uri) C0185a.m210a(parcel, F, Uri.CREATOR);
                    break;
                case 3:
                    arrayList = C0185a.m216c(parcel, F, AppContentCardEntity.CREATOR);
                    break;
                case 4:
                    str4 = C0185a.m229o(parcel, F);
                    break;
                case 5:
                    bundle = C0185a.m231q(parcel, F);
                    break;
                case 6:
                    str3 = C0185a.m229o(parcel, F);
                    break;
                case 7:
                    str2 = C0185a.m229o(parcel, F);
                    break;
                case 8:
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
            return new AppContentSectionEntity(i, arrayList2, uri, arrayList, str4, bundle, str3, str2, str);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cr(x0);
    }

    public AppContentSectionEntity[] dM(int i) {
        return new AppContentSectionEntity[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dM(x0);
    }
}
