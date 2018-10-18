package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

public class AppContentAnnotationEntityCreator implements Creator<AppContentAnnotationEntity> {
    /* renamed from: a */
    static void m667a(AppContentAnnotationEntity appContentAnnotationEntity, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m256a(parcel, 1, appContentAnnotationEntity.getDescription(), false);
        C0186b.m268c(parcel, 1000, appContentAnnotationEntity.getVersionCode());
        C0186b.m252a(parcel, 2, appContentAnnotationEntity.kL(), i, false);
        C0186b.m256a(parcel, 3, appContentAnnotationEntity.getTitle(), false);
        C0186b.m256a(parcel, 4, appContentAnnotationEntity.getType(), false);
        C0186b.m244H(parcel, H);
    }

    public AppContentAnnotationEntity co(Parcel parcel) {
        String str = null;
        int G = C0185a.m208G(parcel);
        int i = 0;
        String str2 = null;
        Uri uri = null;
        String str3 = null;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    str3 = C0185a.m229o(parcel, F);
                    break;
                case 2:
                    uri = (Uri) C0185a.m210a(parcel, F, Uri.CREATOR);
                    break;
                case 3:
                    str2 = C0185a.m229o(parcel, F);
                    break;
                case 4:
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
            return new AppContentAnnotationEntity(i, str3, uri, str2, str);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return co(x0);
    }

    public AppContentAnnotationEntity[] dJ(int i) {
        return new AppContentAnnotationEntity[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dJ(x0);
    }
}
