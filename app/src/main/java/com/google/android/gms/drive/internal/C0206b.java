package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.drive.DriveId;

/* renamed from: com.google.android.gms.drive.internal.b */
public class C0206b implements Creator<AuthorizeAccessRequest> {
    /* renamed from: a */
    static void m371a(AuthorizeAccessRequest authorizeAccessRequest, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, authorizeAccessRequest.CK);
        C0186b.m248a(parcel, 2, authorizeAccessRequest.Pn);
        C0186b.m252a(parcel, 3, authorizeAccessRequest.Oj, i, false);
        C0186b.m244H(parcel, H);
    }

    public AuthorizeAccessRequest aa(Parcel parcel) {
        int G = C0185a.m208G(parcel);
        int i = 0;
        long j = 0;
        DriveId driveId = null;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    j = C0185a.m223i(parcel, F);
                    break;
                case 3:
                    driveId = (DriveId) C0185a.m210a(parcel, F, DriveId.CREATOR);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new AuthorizeAccessRequest(i, j, driveId);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public AuthorizeAccessRequest[] bk(int i) {
        return new AuthorizeAccessRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aa(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bk(x0);
    }
}
