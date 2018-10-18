package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.fitness.data.r */
public class C0298r implements Creator<C0876q> {
    /* renamed from: a */
    static void m555a(C0876q c0876q, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m252a(parcel, 1, c0876q.getSession(), i, false);
        C0186b.m268c(parcel, 1000, c0876q.CK);
        C0186b.m252a(parcel, 2, c0876q.jH(), i, false);
        C0186b.m244H(parcel, H);
    }

    public C0876q bD(Parcel parcel) {
        DataSet dataSet = null;
        int G = C0185a.m208G(parcel);
        int i = 0;
        Session session = null;
        while (parcel.dataPosition() < G) {
            int i2;
            DataSet dataSet2;
            Session session2;
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i2 = i;
                    Session session3 = (Session) C0185a.m210a(parcel, F, Session.CREATOR);
                    dataSet2 = dataSet;
                    session2 = session3;
                    break;
                case 2:
                    dataSet2 = (DataSet) C0185a.m210a(parcel, F, DataSet.CREATOR);
                    session2 = session;
                    i2 = i;
                    break;
                case 1000:
                    DataSet dataSet3 = dataSet;
                    session2 = session;
                    i2 = C0185a.m221g(parcel, F);
                    dataSet2 = dataSet3;
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    dataSet2 = dataSet;
                    session2 = session;
                    i2 = i;
                    break;
            }
            i = i2;
            session = session2;
            dataSet = dataSet2;
        }
        if (parcel.dataPosition() == G) {
            return new C0876q(i, session, dataSet);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public C0876q[] cX(int i) {
        return new C0876q[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bD(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cX(x0);
    }
}
