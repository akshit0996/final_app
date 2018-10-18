package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

public class jk implements Creator<jj> {
    /* renamed from: a */
    static void m1498a(jj jjVar, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, jjVar.version);
        C0186b.m268c(parcel, 2, jjVar.MD);
        C0186b.m268c(parcel, 3, jjVar.ME);
        C0186b.m256a(parcel, 4, jjVar.MF, false);
        C0186b.m250a(parcel, 5, jjVar.MG, false);
        C0186b.m262a(parcel, 6, jjVar.MH, i, false);
        C0186b.m249a(parcel, 7, jjVar.MI, false);
        C0186b.m244H(parcel, H);
    }

    /* renamed from: D */
    public jj m1499D(Parcel parcel) {
        int i = 0;
        Bundle bundle = null;
        int G = C0185a.m208G(parcel);
        Scope[] scopeArr = null;
        IBinder iBinder = null;
        String str = null;
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
                    str = C0185a.m229o(parcel, F);
                    break;
                case 5:
                    iBinder = C0185a.m230p(parcel, F);
                    break;
                case 6:
                    scopeArr = (Scope[]) C0185a.m215b(parcel, F, Scope.CREATOR);
                    break;
                case 7:
                    bundle = C0185a.m231q(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new jj(i3, i2, i, str, iBinder, scopeArr, bundle);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public jj[] aC(int i) {
        return new jj[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m1499D(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aC(x0);
    }
}
