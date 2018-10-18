package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.fitness.request.r */
public class C0330r implements Creator<C0884q> {
    /* renamed from: a */
    static void m639a(C0884q c0884q, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m250a(parcel, 1, c0884q.kg(), false);
        C0186b.m268c(parcel, 1000, c0884q.getVersionCode());
        C0186b.m252a(parcel, 2, c0884q.kb(), i, false);
        C0186b.m244H(parcel, H);
    }

    public C0884q bR(Parcel parcel) {
        PendingIntent pendingIntent = null;
        int G = C0185a.m208G(parcel);
        int i = 0;
        IBinder iBinder = null;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    iBinder = C0185a.m230p(parcel, F);
                    break;
                case 2:
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
            return new C0884q(i, iBinder, pendingIntent);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bR(x0);
    }

    public C0884q[] dm(int i) {
        return new C0884q[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dm(x0);
    }
}
