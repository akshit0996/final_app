package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

public class StatusCreator implements Creator<Status> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m155a(Status status, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, status.getStatusCode());
        C0186b.m268c(parcel, 1000, status.getVersionCode());
        C0186b.m256a(parcel, 2, status.getStatusMessage(), false);
        C0186b.m252a(parcel, 3, status.gP(), i, false);
        C0186b.m244H(parcel, H);
    }

    public Status createFromParcel(Parcel parcel) {
        PendingIntent pendingIntent = null;
        int i = 0;
        int G = C0185a.m208G(parcel);
        String str = null;
        int i2 = 0;
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
                    pendingIntent = (PendingIntent) C0185a.m210a(parcel, F, PendingIntent.CREATOR);
                    break;
                case 1000:
                    i2 = C0185a.m221g(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new Status(i2, i, str, pendingIntent);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public Status[] newArray(int size) {
        return new Status[size];
    }
}
