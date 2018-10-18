package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.Session;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.fitness.request.s */
public class C0331s implements Creator<SessionInsertRequest> {
    /* renamed from: a */
    static void m640a(SessionInsertRequest sessionInsertRequest, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m252a(parcel, 1, sessionInsertRequest.getSession(), i, false);
        C0186b.m268c(parcel, 1000, sessionInsertRequest.getVersionCode());
        C0186b.m269c(parcel, 2, sessionInsertRequest.getDataSets(), false);
        C0186b.m269c(parcel, 3, sessionInsertRequest.getAggregateDataPoints(), false);
        C0186b.m244H(parcel, H);
    }

    public SessionInsertRequest bS(Parcel parcel) {
        List list = null;
        int G = C0185a.m208G(parcel);
        int i = 0;
        List list2 = null;
        Session session = null;
        while (parcel.dataPosition() < G) {
            int i2;
            Session session2;
            Object c;
            ArrayList c2;
            int F = C0185a.m207F(parcel);
            List list3;
            List list4;
            switch (C0185a.aH(F)) {
                case 1:
                    i2 = i;
                    list3 = list2;
                    session2 = (Session) C0185a.m210a(parcel, F, Session.CREATOR);
                    list4 = list;
                    list = list3;
                    break;
                case 2:
                    session2 = session;
                    i2 = i;
                    list3 = list;
                    c = C0185a.m216c(parcel, F, DataSet.CREATOR);
                    list4 = list3;
                    break;
                case 3:
                    c2 = C0185a.m216c(parcel, F, DataPoint.CREATOR);
                    list = list2;
                    session2 = session;
                    i2 = i;
                    break;
                case 1000:
                    list3 = list;
                    list = list2;
                    session2 = session;
                    i2 = C0185a.m221g(parcel, F);
                    list4 = list3;
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    c2 = list;
                    list = list2;
                    session2 = session;
                    i2 = i;
                    break;
            }
            i = i2;
            session = session2;
            list2 = list;
            c = c2;
        }
        if (parcel.dataPosition() == G) {
            return new SessionInsertRequest(i, session, list2, list);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bS(x0);
    }

    public SessionInsertRequest[] dn(int i) {
        return new SessionInsertRequest[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dn(x0);
    }
}
