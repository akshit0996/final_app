package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

public class ax implements Creator<OnSyncMoreResponse> {
    /* renamed from: a */
    static void m369a(OnSyncMoreResponse onSyncMoreResponse, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, onSyncMoreResponse.CK);
        C0186b.m259a(parcel, 2, onSyncMoreResponse.PJ);
        C0186b.m244H(parcel, H);
    }

    public OnSyncMoreResponse aC(Parcel parcel) {
        boolean z = false;
        int G = C0185a.m208G(parcel);
        int i = 0;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    z = C0185a.m217c(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new OnSyncMoreResponse(i, z);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public OnSyncMoreResponse[] bR(int i) {
        return new OnSyncMoreResponse[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aC(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bR(x0);
    }
}
