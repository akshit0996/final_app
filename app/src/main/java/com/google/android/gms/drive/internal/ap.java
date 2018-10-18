package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.drive.DrivePreferences;

public class ap implements Creator<OnDrivePreferencesResponse> {
    /* renamed from: a */
    static void m361a(OnDrivePreferencesResponse onDrivePreferencesResponse, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, onDrivePreferencesResponse.CK);
        C0186b.m252a(parcel, 2, onDrivePreferencesResponse.QN, i, false);
        C0186b.m244H(parcel, H);
    }

    public OnDrivePreferencesResponse au(Parcel parcel) {
        int G = C0185a.m208G(parcel);
        int i = 0;
        DrivePreferences drivePreferences = null;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    drivePreferences = (DrivePreferences) C0185a.m210a(parcel, F, DrivePreferences.CREATOR);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new OnDrivePreferencesResponse(i, drivePreferences);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public OnDrivePreferencesResponse[] bJ(int i) {
        return new OnDrivePreferencesResponse[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return au(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bJ(x0);
    }
}
