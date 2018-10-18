package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.drive.realtime.internal.b */
public class C0242b implements Creator<EndCompoundOperationRequest> {
    /* renamed from: a */
    static void m427a(EndCompoundOperationRequest endCompoundOperationRequest, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, endCompoundOperationRequest.CK);
        C0186b.m244H(parcel, H);
    }

    public EndCompoundOperationRequest bd(Parcel parcel) {
        int G = C0185a.m208G(parcel);
        int i = 0;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i = C0185a.m221g(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new EndCompoundOperationRequest(i);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bd(x0);
    }

    public EndCompoundOperationRequest[] cs(int i) {
        return new EndCompoundOperationRequest[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cs(x0);
    }
}
