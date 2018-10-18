package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.location.d */
public class C0520d implements Creator<LocationRequest> {
    /* renamed from: a */
    static void m1942a(LocationRequest locationRequest, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, locationRequest.mPriority);
        C0186b.m268c(parcel, 1000, locationRequest.getVersionCode());
        C0186b.m248a(parcel, 2, locationRequest.agr);
        C0186b.m248a(parcel, 3, locationRequest.ags);
        C0186b.m259a(parcel, 4, locationRequest.Wg);
        C0186b.m248a(parcel, 5, locationRequest.age);
        C0186b.m268c(parcel, 6, locationRequest.agt);
        C0186b.m247a(parcel, 7, locationRequest.agu);
        C0186b.m248a(parcel, 8, locationRequest.agv);
        C0186b.m244H(parcel, H);
    }

    public LocationRequest cJ(Parcel parcel) {
        int G = C0185a.m208G(parcel);
        int i = 0;
        int i2 = 102;
        long j = 3600000;
        long j2 = 600000;
        boolean z = false;
        long j3 = Long.MAX_VALUE;
        int i3 = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        float f = 0.0f;
        long j4 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i2 = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    j = C0185a.m223i(parcel, F);
                    break;
                case 3:
                    j2 = C0185a.m223i(parcel, F);
                    break;
                case 4:
                    z = C0185a.m217c(parcel, F);
                    break;
                case 5:
                    j3 = C0185a.m223i(parcel, F);
                    break;
                case 6:
                    i3 = C0185a.m221g(parcel, F);
                    break;
                case 7:
                    f = C0185a.m226l(parcel, F);
                    break;
                case 8:
                    j4 = C0185a.m223i(parcel, F);
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
            return new LocationRequest(i, i2, j, j2, z, j3, i3, f, j4);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cJ(x0);
    }

    public LocationRequest[] eA(int i) {
        return new LocationRequest[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return eA(x0);
    }
}
