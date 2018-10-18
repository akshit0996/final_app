package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import java.util.List;

/* renamed from: com.google.android.gms.drive.internal.d */
public class C0207d implements Creator<CancelPendingActionsRequest> {
    /* renamed from: a */
    static void m380a(CancelPendingActionsRequest cancelPendingActionsRequest, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, cancelPendingActionsRequest.CK);
        C0186b.m267b(parcel, 2, cancelPendingActionsRequest.Pb, false);
        C0186b.m244H(parcel, H);
    }

    public CancelPendingActionsRequest ab(Parcel parcel) {
        int G = C0185a.m208G(parcel);
        int i = 0;
        List list = null;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    list = C0185a.m204C(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new CancelPendingActionsRequest(i, list);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public CancelPendingActionsRequest[] bl(int i) {
        return new CancelPendingActionsRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ab(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bl(x0);
    }
}
