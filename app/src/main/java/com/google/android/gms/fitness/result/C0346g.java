package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.fitness.data.Session;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.fitness.result.g */
public class C0346g implements Creator<SessionStopResult> {
    /* renamed from: a */
    static void m656a(SessionStopResult sessionStopResult, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1000, sessionStopResult.getVersionCode());
        C0186b.m252a(parcel, 2, sessionStopResult.getStatus(), i, false);
        C0186b.m269c(parcel, 3, sessionStopResult.getSessions(), false);
        C0186b.m244H(parcel, H);
    }

    public SessionStopResult cj(Parcel parcel) {
        List list = null;
        int G = C0185a.m208G(parcel);
        int i = 0;
        Status status = null;
        while (parcel.dataPosition() < G) {
            int i2;
            Status status2;
            ArrayList c;
            int F = C0185a.m207F(parcel);
            List list2;
            switch (C0185a.aH(F)) {
                case 2:
                    i2 = i;
                    Status status3 = (Status) C0185a.m210a(parcel, F, Status.CREATOR);
                    list2 = list;
                    status2 = status3;
                    break;
                case 3:
                    c = C0185a.m216c(parcel, F, Session.CREATOR);
                    status2 = status;
                    i2 = i;
                    break;
                case 1000:
                    List list3 = list;
                    status2 = status;
                    i2 = C0185a.m221g(parcel, F);
                    list2 = list3;
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    c = list;
                    status2 = status;
                    i2 = i;
                    break;
            }
            i = i2;
            status = status2;
            Object obj = c;
        }
        if (parcel.dataPosition() == G) {
            return new SessionStopResult(i, status, list);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cj(x0);
    }

    public SessionStopResult[] dE(int i) {
        return new SessionStopResult[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dE(x0);
    }
}
