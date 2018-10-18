package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import java.util.List;

/* renamed from: com.google.android.gms.fitness.request.t */
public class C0332t implements Creator<SessionReadRequest> {
    /* renamed from: a */
    static void m641a(SessionReadRequest sessionReadRequest, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m256a(parcel, 1, sessionReadRequest.getSessionName(), false);
        C0186b.m268c(parcel, 1000, sessionReadRequest.getVersionCode());
        C0186b.m256a(parcel, 2, sessionReadRequest.getSessionId(), false);
        C0186b.m248a(parcel, 3, sessionReadRequest.jo());
        C0186b.m248a(parcel, 4, sessionReadRequest.jp());
        C0186b.m269c(parcel, 5, sessionReadRequest.getDataTypes(), false);
        C0186b.m269c(parcel, 6, sessionReadRequest.getDataSources(), false);
        C0186b.m259a(parcel, 7, sessionReadRequest.kj());
        C0186b.m259a(parcel, 8, sessionReadRequest.jV());
        C0186b.m267b(parcel, 9, sessionReadRequest.getExcludedPackages(), false);
        C0186b.m244H(parcel, H);
    }

    public SessionReadRequest bT(Parcel parcel) {
        int G = C0185a.m208G(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        long j = 0;
        long j2 = 0;
        List list = null;
        List list2 = null;
        boolean z = false;
        boolean z2 = false;
        List list3 = null;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    str = C0185a.m229o(parcel, F);
                    break;
                case 2:
                    str2 = C0185a.m229o(parcel, F);
                    break;
                case 3:
                    j = C0185a.m223i(parcel, F);
                    break;
                case 4:
                    j2 = C0185a.m223i(parcel, F);
                    break;
                case 5:
                    list = C0185a.m216c(parcel, F, DataType.CREATOR);
                    break;
                case 6:
                    list2 = C0185a.m216c(parcel, F, DataSource.CREATOR);
                    break;
                case 7:
                    z = C0185a.m217c(parcel, F);
                    break;
                case 8:
                    z2 = C0185a.m217c(parcel, F);
                    break;
                case 9:
                    list3 = C0185a.m204C(parcel, F);
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
            return new SessionReadRequest(i, str, str2, j, j2, list, list2, z, z2, list3);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bT(x0);
    }

    /* renamed from: do */
    public SessionReadRequest[] m642do(int i) {
        return new SessionReadRequest[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m642do(x0);
    }
}
