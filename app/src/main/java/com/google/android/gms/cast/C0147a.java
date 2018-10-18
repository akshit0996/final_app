package com.google.android.gms.cast;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import java.util.List;

/* renamed from: com.google.android.gms.cast.a */
public class C0147a implements Creator<ApplicationMetadata> {
    /* renamed from: a */
    static void m114a(ApplicationMetadata applicationMetadata, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, applicationMetadata.getVersionCode());
        C0186b.m256a(parcel, 2, applicationMetadata.getApplicationId(), false);
        C0186b.m256a(parcel, 3, applicationMetadata.getName(), false);
        C0186b.m269c(parcel, 4, applicationMetadata.getImages(), false);
        C0186b.m267b(parcel, 5, applicationMetadata.Fq, false);
        C0186b.m256a(parcel, 6, applicationMetadata.getSenderAppIdentifier(), false);
        C0186b.m252a(parcel, 7, applicationMetadata.fP(), i, false);
        C0186b.m244H(parcel, H);
    }

    /* renamed from: V */
    public ApplicationMetadata[] m115V(int i) {
        return new ApplicationMetadata[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m116u(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m115V(x0);
    }

    /* renamed from: u */
    public ApplicationMetadata m116u(Parcel parcel) {
        Uri uri = null;
        int G = C0185a.m208G(parcel);
        int i = 0;
        String str = null;
        List list = null;
        List list2 = null;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    str3 = C0185a.m229o(parcel, F);
                    break;
                case 3:
                    str2 = C0185a.m229o(parcel, F);
                    break;
                case 4:
                    list2 = C0185a.m216c(parcel, F, WebImage.CREATOR);
                    break;
                case 5:
                    list = C0185a.m204C(parcel, F);
                    break;
                case 6:
                    str = C0185a.m229o(parcel, F);
                    break;
                case 7:
                    uri = (Uri) C0185a.m210a(parcel, F, Uri.CREATOR);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new ApplicationMetadata(i, str3, str2, list2, list, str, uri);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }
}
