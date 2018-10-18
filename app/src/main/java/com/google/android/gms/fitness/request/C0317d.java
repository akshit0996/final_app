package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Session;
import java.util.List;

/* renamed from: com.google.android.gms.fitness.request.d */
public class C0317d implements Creator<DataDeleteRequest> {
    /* renamed from: a */
    static void m627a(DataDeleteRequest dataDeleteRequest, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m248a(parcel, 1, dataDeleteRequest.jo());
        C0186b.m268c(parcel, 1000, dataDeleteRequest.getVersionCode());
        C0186b.m248a(parcel, 2, dataDeleteRequest.jp());
        C0186b.m269c(parcel, 3, dataDeleteRequest.getDataSources(), false);
        C0186b.m269c(parcel, 4, dataDeleteRequest.getDataTypes(), false);
        C0186b.m269c(parcel, 5, dataDeleteRequest.getSessions(), false);
        C0186b.m259a(parcel, 6, dataDeleteRequest.jR());
        C0186b.m259a(parcel, 7, dataDeleteRequest.jS());
        C0186b.m244H(parcel, H);
    }

    public DataDeleteRequest bJ(Parcel parcel) {
        long j = 0;
        List list = null;
        boolean z = false;
        int G = C0185a.m208G(parcel);
        boolean z2 = false;
        List list2 = null;
        List list3 = null;
        long j2 = 0;
        int i = 0;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    j2 = C0185a.m223i(parcel, F);
                    break;
                case 2:
                    j = C0185a.m223i(parcel, F);
                    break;
                case 3:
                    list3 = C0185a.m216c(parcel, F, DataSource.CREATOR);
                    break;
                case 4:
                    list2 = C0185a.m216c(parcel, F, DataType.CREATOR);
                    break;
                case 5:
                    list = C0185a.m216c(parcel, F, Session.CREATOR);
                    break;
                case 6:
                    z2 = C0185a.m217c(parcel, F);
                    break;
                case 7:
                    z = C0185a.m217c(parcel, F);
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
            return new DataDeleteRequest(i, j2, j, list3, list2, list, z2, z);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bJ(x0);
    }

    public DataDeleteRequest[] dd(int i) {
        return new DataDeleteRequest[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dd(x0);
    }
}
