package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

public class ab implements Creator<aa> {
    /* renamed from: a */
    static void m613a(aa aaVar, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m252a(parcel, 1, aaVar.kb(), i, false);
        C0186b.m268c(parcel, 1000, aaVar.getVersionCode());
        C0186b.m244H(parcel, H);
    }

    public aa bX(Parcel parcel) {
        int G = C0185a.m208G(parcel);
        int i = 0;
        PendingIntent pendingIntent = null;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    pendingIntent = (PendingIntent) C0185a.m210a(parcel, F, PendingIntent.CREATOR);
                    break;
                case 1000:
                    i = C0185a.m221g(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new aa(i, pendingIntent);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bX(x0);
    }

    public aa[] ds(int i) {
        return new aa[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ds(x0);
    }
}
