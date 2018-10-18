package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import java.util.Collection;

/* renamed from: com.google.android.gms.drive.metadata.internal.a */
public class C0222a implements Creator<AppVisibleCustomProperties> {
    /* renamed from: a */
    static void m403a(AppVisibleCustomProperties appVisibleCustomProperties, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, appVisibleCustomProperties.CK);
        C0186b.m269c(parcel, 2, appVisibleCustomProperties.Re, false);
        C0186b.m244H(parcel, H);
    }

    public AppVisibleCustomProperties aN(Parcel parcel) {
        int G = C0185a.m208G(parcel);
        int i = 0;
        Collection collection = null;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    collection = C0185a.m216c(parcel, F, CustomProperty.CREATOR);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new AppVisibleCustomProperties(i, collection);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public AppVisibleCustomProperties[] cc(int i) {
        return new AppVisibleCustomProperties[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aN(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cc(x0);
    }
}
