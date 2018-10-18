package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.drive.query.Query;

public class bb implements Creator<QueryRequest> {
    /* renamed from: a */
    static void m373a(QueryRequest queryRequest, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, queryRequest.CK);
        C0186b.m252a(parcel, 2, queryRequest.QV, i, false);
        C0186b.m244H(parcel, H);
    }

    public QueryRequest aF(Parcel parcel) {
        int G = C0185a.m208G(parcel);
        int i = 0;
        Query query = null;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    query = (Query) C0185a.m210a(parcel, F, Query.CREATOR);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new QueryRequest(i, query);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public QueryRequest[] bU(int i) {
        return new QueryRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aF(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bU(x0);
    }
}
