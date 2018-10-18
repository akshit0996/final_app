package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.fitness.data.C0876q;
import com.google.android.gms.fitness.data.Session;
import java.util.List;

/* renamed from: com.google.android.gms.fitness.result.f */
public class C0345f implements Creator<SessionReadResult> {
    /* renamed from: a */
    static void m655a(SessionReadResult sessionReadResult, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m269c(parcel, 1, sessionReadResult.getSessions(), false);
        C0186b.m268c(parcel, 1000, sessionReadResult.getVersionCode());
        C0186b.m269c(parcel, 2, sessionReadResult.kv(), false);
        C0186b.m252a(parcel, 3, sessionReadResult.getStatus(), i, false);
        C0186b.m244H(parcel, H);
    }

    public SessionReadResult ci(Parcel parcel) {
        Status status = null;
        int G = C0185a.m208G(parcel);
        int i = 0;
        List list = null;
        List list2 = null;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    list2 = C0185a.m216c(parcel, F, Session.CREATOR);
                    break;
                case 2:
                    list = C0185a.m216c(parcel, F, C0876q.CREATOR);
                    break;
                case 3:
                    status = (Status) C0185a.m210a(parcel, F, Status.CREATOR);
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
            return new SessionReadResult(i, list2, list, status);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ci(x0);
    }

    public SessionReadResult[] dD(int i) {
        return new SessionReadResult[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dD(x0);
    }
}
