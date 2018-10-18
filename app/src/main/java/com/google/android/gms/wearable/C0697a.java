package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.wearable.a */
public class C0697a implements Creator<Asset> {
    /* renamed from: a */
    static void m2273a(Asset asset, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, asset.CK);
        C0186b.m260a(parcel, 2, asset.getData(), false);
        C0186b.m256a(parcel, 3, asset.getDigest(), false);
        C0186b.m252a(parcel, 4, asset.axb, i, false);
        C0186b.m252a(parcel, 5, asset.uri, i, false);
        C0186b.m244H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return el(x0);
    }

    public Asset el(Parcel parcel) {
        Uri uri = null;
        int G = C0185a.m208G(parcel);
        int i = 0;
        ParcelFileDescriptor parcelFileDescriptor = null;
        String str = null;
        byte[] bArr = null;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    bArr = C0185a.m232r(parcel, F);
                    break;
                case 3:
                    str = C0185a.m229o(parcel, F);
                    break;
                case 4:
                    parcelFileDescriptor = (ParcelFileDescriptor) C0185a.m210a(parcel, F, ParcelFileDescriptor.CREATOR);
                    break;
                case 5:
                    uri = (Uri) C0185a.m210a(parcel, F, Uri.CREATOR);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new Asset(i, bArr, str, parcelFileDescriptor, uri);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public Asset[] gu(int i) {
        return new Asset[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return gu(x0);
    }
}
