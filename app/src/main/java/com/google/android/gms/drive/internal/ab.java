package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

public class ab implements Creator<FileUploadPreferencesImpl> {
    /* renamed from: a */
    static void m302a(FileUploadPreferencesImpl fileUploadPreferencesImpl, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, fileUploadPreferencesImpl.CK);
        C0186b.m268c(parcel, 2, fileUploadPreferencesImpl.Qz);
        C0186b.m268c(parcel, 3, fileUploadPreferencesImpl.QA);
        C0186b.m259a(parcel, 4, fileUploadPreferencesImpl.QB);
        C0186b.m244H(parcel, H);
    }

    public FileUploadPreferencesImpl al(Parcel parcel) {
        boolean z = false;
        int G = C0185a.m208G(parcel);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i3 = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    i2 = C0185a.m221g(parcel, F);
                    break;
                case 3:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 4:
                    z = C0185a.m217c(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new FileUploadPreferencesImpl(i3, i2, i, z);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public FileUploadPreferencesImpl[] bA(int i) {
        return new FileUploadPreferencesImpl[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return al(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bA(x0);
    }
}
