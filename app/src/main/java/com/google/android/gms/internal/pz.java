package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

public class pz implements Creator<py> {
    /* renamed from: a */
    static void m1783a(py pyVar, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, pyVar.getVersionCode());
        C0186b.m263a(parcel, 2, pyVar.avY, false);
        C0186b.m264a(parcel, 3, pyVar.avZ, false);
        C0186b.m244H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return dY(x0);
    }

    public py dY(Parcel parcel) {
        String[] strArr = null;
        int G = C0185a.m208G(parcel);
        int i = 0;
        byte[][] bArr = (byte[][]) null;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    strArr = C0185a.m202A(parcel, F);
                    break;
                case 3:
                    bArr = C0185a.m233s(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new py(i, strArr, bArr);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public py[] gf(int i) {
        return new py[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return gf(x0);
    }
}
