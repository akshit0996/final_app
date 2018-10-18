package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.wallet.m */
public class C0677m implements Creator<NotifyTransactionStatusRequest> {
    /* renamed from: a */
    static void m2253a(NotifyTransactionStatusRequest notifyTransactionStatusRequest, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, notifyTransactionStatusRequest.CK);
        C0186b.m256a(parcel, 2, notifyTransactionStatusRequest.auL, false);
        C0186b.m268c(parcel, 3, notifyTransactionStatusRequest.status);
        C0186b.m256a(parcel, 4, notifyTransactionStatusRequest.avL, false);
        C0186b.m244H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return dU(x0);
    }

    public NotifyTransactionStatusRequest dU(Parcel parcel) {
        String str = null;
        int i = 0;
        int G = C0185a.m208G(parcel);
        String str2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i2 = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    str2 = C0185a.m229o(parcel, F);
                    break;
                case 3:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 4:
                    str = C0185a.m229o(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new NotifyTransactionStatusRequest(i2, str2, i, str);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public NotifyTransactionStatusRequest[] gb(int i) {
        return new NotifyTransactionStatusRequest[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return gb(x0);
    }
}
