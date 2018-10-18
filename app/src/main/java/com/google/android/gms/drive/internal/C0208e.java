package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import java.util.List;

/* renamed from: com.google.android.gms.drive.internal.e */
public class C0208e implements Creator<CheckResourceIdsExistRequest> {
    /* renamed from: a */
    static void m381a(CheckResourceIdsExistRequest checkResourceIdsExistRequest, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, checkResourceIdsExistRequest.getVersionCode());
        C0186b.m267b(parcel, 2, checkResourceIdsExistRequest.iF(), false);
        C0186b.m244H(parcel, H);
    }

    public CheckResourceIdsExistRequest ac(Parcel parcel) {
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
            return new CheckResourceIdsExistRequest(i, list);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public CheckResourceIdsExistRequest[] bm(int i) {
        return new CheckResourceIdsExistRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ac(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bm(x0);
    }
}
