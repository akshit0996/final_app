package com.google.android.gms.maps.model.internal;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.maps.model.internal.b */
public class C0559b implements Creator<C1161a> {
    /* renamed from: a */
    static void m1991a(C1161a c1161a, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, c1161a.getVersionCode());
        C0186b.m245a(parcel, 2, c1161a.oh());
        C0186b.m249a(parcel, 3, c1161a.oi(), false);
        C0186b.m252a(parcel, 4, c1161a.getBitmap(), i, false);
        C0186b.m244H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return dp(x0);
    }

    public C1161a dp(Parcel parcel) {
        Bitmap bitmap = null;
        byte b = (byte) 0;
        int G = C0185a.m208G(parcel);
        Bundle bundle = null;
        int i = 0;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    b = C0185a.m219e(parcel, F);
                    break;
                case 3:
                    bundle = C0185a.m231q(parcel, F);
                    break;
                case 4:
                    bitmap = (Bitmap) C0185a.m210a(parcel, F, Bitmap.CREATOR);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new C1161a(i, b, bundle, bitmap);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public C1161a[] fl(int i) {
        return new C1161a[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return fl(x0);
    }
}
