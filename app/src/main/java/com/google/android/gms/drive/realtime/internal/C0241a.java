package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.drive.realtime.internal.a */
public class C0241a implements Creator<BeginCompoundOperationRequest> {
    /* renamed from: a */
    static void m426a(BeginCompoundOperationRequest beginCompoundOperationRequest, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, beginCompoundOperationRequest.CK);
        C0186b.m259a(parcel, 2, beginCompoundOperationRequest.SF);
        C0186b.m256a(parcel, 3, beginCompoundOperationRequest.mName, false);
        C0186b.m259a(parcel, 4, beginCompoundOperationRequest.SG);
        C0186b.m244H(parcel, H);
    }

    public BeginCompoundOperationRequest bc(Parcel parcel) {
        boolean z = false;
        int G = C0185a.m208G(parcel);
        String str = null;
        boolean z2 = true;
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
                case 3:
                    str = C0185a.m229o(parcel, F);
                    break;
                case 4:
                    z2 = C0185a.m217c(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new BeginCompoundOperationRequest(i, z, str, z2);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public BeginCompoundOperationRequest[] cr(int i) {
        return new BeginCompoundOperationRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bc(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cr(x0);
    }
}
