package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

public class dz implements Creator<ea> {
    /* renamed from: a */
    static void m1154a(ea eaVar, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, eaVar.versionCode);
        C0186b.m250a(parcel, 3, eaVar.cu(), false);
        C0186b.m250a(parcel, 4, eaVar.cv(), false);
        C0186b.m250a(parcel, 5, eaVar.cw(), false);
        C0186b.m250a(parcel, 6, eaVar.ct(), false);
        C0186b.m244H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m1155g(x0);
    }

    /* renamed from: g */
    public ea m1155g(Parcel parcel) {
        IBinder iBinder = null;
        int G = C0185a.m208G(parcel);
        int i = 0;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        IBinder iBinder4 = null;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 3:
                    iBinder4 = C0185a.m230p(parcel, F);
                    break;
                case 4:
                    iBinder3 = C0185a.m230p(parcel, F);
                    break;
                case 5:
                    iBinder2 = C0185a.m230p(parcel, F);
                    break;
                case 6:
                    iBinder = C0185a.m230p(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new ea(i, iBinder4, iBinder3, iBinder2, iBinder);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m1156o(x0);
    }

    /* renamed from: o */
    public ea[] m1156o(int i) {
        return new ea[i];
    }
}
