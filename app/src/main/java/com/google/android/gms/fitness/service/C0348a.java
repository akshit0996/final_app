package com.google.android.gms.fitness.service;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.fitness.data.DataSource;

/* renamed from: com.google.android.gms.fitness.service.a */
public class C0348a implements Creator<FitnessSensorServiceRequest> {
    /* renamed from: a */
    static void m657a(FitnessSensorServiceRequest fitnessSensorServiceRequest, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m252a(parcel, 1, fitnessSensorServiceRequest.getDataSource(), i, false);
        C0186b.m268c(parcel, 1000, fitnessSensorServiceRequest.getVersionCode());
        C0186b.m250a(parcel, 2, fitnessSensorServiceRequest.kg(), false);
        C0186b.m248a(parcel, 3, fitnessSensorServiceRequest.jI());
        C0186b.m248a(parcel, 4, fitnessSensorServiceRequest.kx());
        C0186b.m244H(parcel, H);
    }

    public FitnessSensorServiceRequest ck(Parcel parcel) {
        long j = 0;
        IBinder iBinder = null;
        int G = C0185a.m208G(parcel);
        int i = 0;
        long j2 = 0;
        DataSource dataSource = null;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    dataSource = (DataSource) C0185a.m210a(parcel, F, DataSource.CREATOR);
                    break;
                case 2:
                    iBinder = C0185a.m230p(parcel, F);
                    break;
                case 3:
                    j2 = C0185a.m223i(parcel, F);
                    break;
                case 4:
                    j = C0185a.m223i(parcel, F);
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
            return new FitnessSensorServiceRequest(i, dataSource, iBinder, j2, j);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ck(x0);
    }

    public FitnessSensorServiceRequest[] dF(int i) {
        return new FitnessSensorServiceRequest[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dF(x0);
    }
}
