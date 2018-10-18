package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.drive.metadata.CustomPropertyKey;

/* renamed from: com.google.android.gms.drive.metadata.internal.c */
public class C0223c implements Creator<CustomProperty> {
    /* renamed from: a */
    static void m404a(CustomProperty customProperty, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, customProperty.CK);
        C0186b.m252a(parcel, 2, customProperty.Rg, i, false);
        C0186b.m256a(parcel, 3, customProperty.mValue, false);
        C0186b.m244H(parcel, H);
    }

    public CustomProperty aO(Parcel parcel) {
        String str = null;
        int G = C0185a.m208G(parcel);
        int i = 0;
        CustomPropertyKey customPropertyKey = null;
        while (parcel.dataPosition() < G) {
            CustomPropertyKey customPropertyKey2;
            int g;
            String str2;
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    String str3 = str;
                    customPropertyKey2 = customPropertyKey;
                    g = C0185a.m221g(parcel, F);
                    str2 = str3;
                    break;
                case 2:
                    g = i;
                    CustomPropertyKey customPropertyKey3 = (CustomPropertyKey) C0185a.m210a(parcel, F, CustomPropertyKey.CREATOR);
                    str2 = str;
                    customPropertyKey2 = customPropertyKey3;
                    break;
                case 3:
                    str2 = C0185a.m229o(parcel, F);
                    customPropertyKey2 = customPropertyKey;
                    g = i;
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    str2 = str;
                    customPropertyKey2 = customPropertyKey;
                    g = i;
                    break;
            }
            i = g;
            customPropertyKey = customPropertyKey2;
            str = str2;
        }
        if (parcel.dataPosition() == G) {
            return new CustomProperty(i, customPropertyKey, str);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public CustomProperty[] cd(int i) {
        return new CustomProperty[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aO(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cd(x0);
    }
}
