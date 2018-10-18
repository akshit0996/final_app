package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.maps.model.u */
public class C0583u implements Creator<Tile> {
    /* renamed from: a */
    static void m2020a(Tile tile, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, tile.getVersionCode());
        C0186b.m268c(parcel, 2, tile.width);
        C0186b.m268c(parcel, 3, tile.height);
        C0186b.m260a(parcel, 4, tile.data, false);
        C0186b.m244H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return dm(x0);
    }

    public Tile dm(Parcel parcel) {
        int i = 0;
        int G = C0185a.m208G(parcel);
        byte[] bArr = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i3 = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    i2 = C0185a.m221g(parcel, F);
                    break;
                case 3:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 4:
                    bArr = C0185a.m232r(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new Tile(i3, i2, i, bArr);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public Tile[] fi(int i) {
        return new Tile[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return fi(x0);
    }
}
