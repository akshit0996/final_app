package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

public class be implements Creator<SetFileUploadPreferencesRequest> {
    /* renamed from: a */
    static void m376a(SetFileUploadPreferencesRequest setFileUploadPreferencesRequest, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, setFileUploadPreferencesRequest.CK);
        C0186b.m252a(parcel, 2, setFileUploadPreferencesRequest.QK, i, false);
        C0186b.m244H(parcel, H);
    }

    public SetFileUploadPreferencesRequest aI(Parcel parcel) {
        int G = C0185a.m208G(parcel);
        int i = 0;
        FileUploadPreferencesImpl fileUploadPreferencesImpl = null;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    fileUploadPreferencesImpl = (FileUploadPreferencesImpl) C0185a.m210a(parcel, F, FileUploadPreferencesImpl.CREATOR);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new SetFileUploadPreferencesRequest(i, fileUploadPreferencesImpl);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public SetFileUploadPreferencesRequest[] bX(int i) {
        return new SetFileUploadPreferencesRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aI(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bX(x0);
    }
}
