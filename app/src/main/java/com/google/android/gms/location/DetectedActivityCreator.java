package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

public class DetectedActivityCreator implements Creator<DetectedActivity> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m1934a(DetectedActivity detectedActivity, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, detectedActivity.agb);
        C0186b.m268c(parcel, 1000, detectedActivity.getVersionCode());
        C0186b.m268c(parcel, 2, detectedActivity.agc);
        C0186b.m244H(parcel, H);
    }

    public DetectedActivity createFromParcel(Parcel parcel) {
        int i = 0;
        int G = C0185a.m208G(parcel);
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i2 = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 1000:
                    i3 = C0185a.m221g(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new DetectedActivity(i3, i2, i);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public DetectedActivity[] newArray(int size) {
        return new DetectedActivity[size];
    }
}
