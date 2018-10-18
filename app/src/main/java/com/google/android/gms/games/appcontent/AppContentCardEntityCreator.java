package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import java.util.ArrayList;

public class AppContentCardEntityCreator implements Creator<AppContentCardEntity> {
    /* renamed from: a */
    static void m668a(AppContentCardEntity appContentCardEntity, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m269c(parcel, 1, appContentCardEntity.getActions(), false);
        C0186b.m268c(parcel, 1000, appContentCardEntity.getVersionCode());
        C0186b.m269c(parcel, 2, appContentCardEntity.kN(), false);
        C0186b.m269c(parcel, 3, appContentCardEntity.kH(), false);
        C0186b.m256a(parcel, 4, appContentCardEntity.kI(), false);
        C0186b.m268c(parcel, 5, appContentCardEntity.kO());
        C0186b.m256a(parcel, 6, appContentCardEntity.getDescription(), false);
        C0186b.m249a(parcel, 7, appContentCardEntity.kP(), false);
        C0186b.m252a(parcel, 8, appContentCardEntity.getIconImageUri(), i, false);
        C0186b.m252a(parcel, 9, appContentCardEntity.kL(), i, false);
        C0186b.m256a(parcel, 10, appContentCardEntity.kQ(), false);
        C0186b.m256a(parcel, 11, appContentCardEntity.getTitle(), false);
        C0186b.m268c(parcel, 12, appContentCardEntity.kR());
        C0186b.m256a(parcel, 13, appContentCardEntity.getType(), false);
        C0186b.m244H(parcel, H);
    }

    public AppContentCardEntity cp(Parcel parcel) {
        int G = C0185a.m208G(parcel);
        int i = 0;
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        ArrayList arrayList3 = null;
        String str = null;
        int i2 = 0;
        String str2 = null;
        Bundle bundle = null;
        Uri uri = null;
        Uri uri2 = null;
        String str3 = null;
        String str4 = null;
        int i3 = 0;
        String str5 = null;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    arrayList = C0185a.m216c(parcel, F, AppContentActionEntity.CREATOR);
                    break;
                case 2:
                    arrayList2 = C0185a.m216c(parcel, F, AppContentAnnotationEntity.CREATOR);
                    break;
                case 3:
                    arrayList3 = C0185a.m216c(parcel, F, AppContentConditionEntity.CREATOR);
                    break;
                case 4:
                    str = C0185a.m229o(parcel, F);
                    break;
                case 5:
                    i2 = C0185a.m221g(parcel, F);
                    break;
                case 6:
                    str2 = C0185a.m229o(parcel, F);
                    break;
                case 7:
                    bundle = C0185a.m231q(parcel, F);
                    break;
                case 8:
                    uri = (Uri) C0185a.m210a(parcel, F, Uri.CREATOR);
                    break;
                case 9:
                    uri2 = (Uri) C0185a.m210a(parcel, F, Uri.CREATOR);
                    break;
                case 10:
                    str3 = C0185a.m229o(parcel, F);
                    break;
                case 11:
                    str4 = C0185a.m229o(parcel, F);
                    break;
                case 12:
                    i3 = C0185a.m221g(parcel, F);
                    break;
                case 13:
                    str5 = C0185a.m229o(parcel, F);
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
            return new AppContentCardEntity(i, arrayList, arrayList2, arrayList3, str, i2, str2, bundle, uri, uri2, str3, str4, i3, str5);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cp(x0);
    }

    public AppContentCardEntity[] dK(int i) {
        return new AppContentCardEntity[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dK(x0);
    }
}
