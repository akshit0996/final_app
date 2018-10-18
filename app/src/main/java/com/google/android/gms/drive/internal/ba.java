package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.drive.DriveId;

public class ba implements Creator<OpenFileIntentSenderRequest> {
    /* renamed from: a */
    static void m372a(OpenFileIntentSenderRequest openFileIntentSenderRequest, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, openFileIntentSenderRequest.CK);
        C0186b.m256a(parcel, 2, openFileIntentSenderRequest.OH, false);
        C0186b.m263a(parcel, 3, openFileIntentSenderRequest.OI, false);
        C0186b.m252a(parcel, 4, openFileIntentSenderRequest.OJ, i, false);
        C0186b.m244H(parcel, H);
    }

    public OpenFileIntentSenderRequest aE(Parcel parcel) {
        DriveId driveId = null;
        int G = C0185a.m208G(parcel);
        int i = 0;
        String[] strArr = null;
        String str = null;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    str = C0185a.m229o(parcel, F);
                    break;
                case 3:
                    strArr = C0185a.m202A(parcel, F);
                    break;
                case 4:
                    driveId = (DriveId) C0185a.m210a(parcel, F, DriveId.CREATOR);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new OpenFileIntentSenderRequest(i, str, strArr, driveId);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public OpenFileIntentSenderRequest[] bT(int i) {
        return new OpenFileIntentSenderRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aE(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bT(x0);
    }
}
