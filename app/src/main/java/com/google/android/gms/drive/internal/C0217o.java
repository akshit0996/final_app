package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.drive.internal.o */
public class C0217o implements Creator<DisconnectRequest> {
    /* renamed from: a */
    static void m391a(DisconnectRequest disconnectRequest, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, disconnectRequest.CK);
        C0186b.m244H(parcel, H);
    }

    public DisconnectRequest ak(Parcel parcel) {
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
            return new DisconnectRequest(i);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public DisconnectRequest[] bv(int i) {
        return new DisconnectRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ak(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bv(x0);
    }
}
