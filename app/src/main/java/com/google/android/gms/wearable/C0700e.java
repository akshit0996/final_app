package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.wearable.e */
public class C0700e implements Creator<PutDataRequest> {
    /* renamed from: a */
    static void m2275a(PutDataRequest putDataRequest, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, putDataRequest.CK);
        C0186b.m252a(parcel, 2, putDataRequest.getUri(), i, false);
        C0186b.m249a(parcel, 4, putDataRequest.rk(), false);
        C0186b.m260a(parcel, 5, putDataRequest.getData(), false);
        C0186b.m244H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return en(x0);
    }

    public PutDataRequest en(Parcel parcel) {
        byte[] bArr = null;
        int G = C0185a.m208G(parcel);
        int i = 0;
        Bundle bundle = null;
        Uri uri = null;
        while (parcel.dataPosition() < G) {
            Bundle bundle2;
            Uri uri2;
            int g;
            byte[] bArr2;
            int F = C0185a.m207F(parcel);
            byte[] bArr3;
            switch (C0185a.aH(F)) {
                case 1:
                    bArr3 = bArr;
                    bundle2 = bundle;
                    uri2 = uri;
                    g = C0185a.m221g(parcel, F);
                    bArr2 = bArr3;
                    break;
                case 2:
                    g = i;
                    Bundle bundle3 = bundle;
                    uri2 = (Uri) C0185a.m210a(parcel, F, Uri.CREATOR);
                    bArr2 = bArr;
                    bundle2 = bundle3;
                    break;
                case 4:
                    uri2 = uri;
                    g = i;
                    bArr3 = bArr;
                    bundle2 = C0185a.m231q(parcel, F);
                    bArr2 = bArr3;
                    break;
                case 5:
                    bArr2 = C0185a.m232r(parcel, F);
                    bundle2 = bundle;
                    uri2 = uri;
                    g = i;
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    bArr2 = bArr;
                    bundle2 = bundle;
                    uri2 = uri;
                    g = i;
                    break;
            }
            i = g;
            uri = uri2;
            bundle = bundle2;
            bArr = bArr2;
        }
        if (parcel.dataPosition() == G) {
            return new PutDataRequest(i, uri, bundle, bArr);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public PutDataRequest[] gw(int i) {
        return new PutDataRequest[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return gw(x0);
    }
}
