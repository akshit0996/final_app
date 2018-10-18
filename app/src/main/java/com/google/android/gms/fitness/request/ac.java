package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.fitness.data.DataType;
import java.util.List;

public class ac implements Creator<StartBleScanRequest> {
    /* renamed from: a */
    static void m614a(StartBleScanRequest startBleScanRequest, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m269c(parcel, 1, startBleScanRequest.getDataTypes(), false);
        C0186b.m268c(parcel, 1000, startBleScanRequest.getVersionCode());
        C0186b.m250a(parcel, 2, startBleScanRequest.km(), false);
        C0186b.m268c(parcel, 3, startBleScanRequest.getTimeoutSecs());
        C0186b.m244H(parcel, H);
    }

    public StartBleScanRequest bY(Parcel parcel) {
        IBinder iBinder = null;
        int i = 0;
        int G = C0185a.m208G(parcel);
        List list = null;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    list = C0185a.m216c(parcel, F, DataType.CREATOR);
                    break;
                case 2:
                    iBinder = C0185a.m230p(parcel, F);
                    break;
                case 3:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 1000:
                    i2 = C0185a.m221g(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new StartBleScanRequest(i2, list, iBinder, i);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bY(x0);
    }

    public StartBleScanRequest[] dt(int i) {
        return new StartBleScanRequest[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dt(x0);
    }
}
