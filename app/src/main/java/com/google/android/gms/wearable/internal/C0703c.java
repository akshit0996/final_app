package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.wearable.internal.c */
public class C0703c implements Creator<C1271b> {
    /* renamed from: a */
    static void m2327a(C1271b c1271b, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, c1271b.CK);
        C0186b.m250a(parcel, 2, c1271b.rm(), false);
        C0186b.m262a(parcel, 3, c1271b.axw, i, false);
        C0186b.m244H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return eo(x0);
    }

    public C1271b eo(Parcel parcel) {
        IntentFilter[] intentFilterArr = null;
        int G = C0185a.m208G(parcel);
        int i = 0;
        IBinder iBinder = null;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    iBinder = C0185a.m230p(parcel, F);
                    break;
                case 3:
                    intentFilterArr = (IntentFilter[]) C0185a.m215b(parcel, F, IntentFilter.CREATOR);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new C1271b(i, iBinder, intentFilterArr);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public C1271b[] gx(int i) {
        return new C1271b[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return gx(x0);
    }
}
