package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import java.util.List;

public class ActivityRecognitionResultCreator implements Creator<ActivityRecognitionResult> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m1932a(ActivityRecognitionResult activityRecognitionResult, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m269c(parcel, 1, activityRecognitionResult.afX, false);
        C0186b.m268c(parcel, 1000, activityRecognitionResult.getVersionCode());
        C0186b.m248a(parcel, 2, activityRecognitionResult.afY);
        C0186b.m248a(parcel, 3, activityRecognitionResult.afZ);
        C0186b.m244H(parcel, H);
    }

    public ActivityRecognitionResult createFromParcel(Parcel parcel) {
        long j = 0;
        int G = C0185a.m208G(parcel);
        int i = 0;
        List list = null;
        long j2 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    list = C0185a.m216c(parcel, F, DetectedActivity.CREATOR);
                    break;
                case 2:
                    j2 = C0185a.m223i(parcel, F);
                    break;
                case 3:
                    j = C0185a.m223i(parcel, F);
                    break;
                case 1000:
                    i = C0185a.m221g(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new ActivityRecognitionResult(i, list, j2, j);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public ActivityRecognitionResult[] newArray(int size) {
        return new ActivityRecognitionResult[size];
    }
}
