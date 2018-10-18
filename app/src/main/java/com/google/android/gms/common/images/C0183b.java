package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.common.images.b */
public class C0183b implements Creator<WebImage> {
    /* renamed from: a */
    static void m200a(WebImage webImage, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, webImage.getVersionCode());
        C0186b.m252a(parcel, 2, webImage.getUrl(), i, false);
        C0186b.m268c(parcel, 3, webImage.getWidth());
        C0186b.m268c(parcel, 4, webImage.getHeight());
        C0186b.m244H(parcel, H);
    }

    /* renamed from: C */
    public WebImage m201C(Parcel parcel) {
        int i = 0;
        int G = C0185a.m208G(parcel);
        Uri uri = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < G) {
            Uri uri2;
            int g;
            int F = C0185a.m207F(parcel);
            int i4;
            switch (C0185a.aH(F)) {
                case 1:
                    i4 = i;
                    i = i2;
                    uri2 = uri;
                    g = C0185a.m221g(parcel, F);
                    F = i4;
                    break;
                case 2:
                    g = i3;
                    i4 = i2;
                    uri2 = (Uri) C0185a.m210a(parcel, F, Uri.CREATOR);
                    F = i;
                    i = i4;
                    break;
                case 3:
                    uri2 = uri;
                    g = i3;
                    i4 = i;
                    i = C0185a.m221g(parcel, F);
                    F = i4;
                    break;
                case 4:
                    F = C0185a.m221g(parcel, F);
                    i = i2;
                    uri2 = uri;
                    g = i3;
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    F = i;
                    i = i2;
                    uri2 = uri;
                    g = i3;
                    break;
            }
            i3 = g;
            uri = uri2;
            i2 = i;
            i = F;
        }
        if (parcel.dataPosition() == G) {
            return new WebImage(i3, uri, i2, i);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public WebImage[] aA(int i) {
        return new WebImage[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m201C(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aA(x0);
    }
}
