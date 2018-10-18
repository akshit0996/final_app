package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.internal.nn;
import java.util.List;

/* renamed from: com.google.android.gms.location.a */
public class C0516a implements Creator<GeofencingRequest> {
    /* renamed from: a */
    static void m1938a(GeofencingRequest geofencingRequest, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m269c(parcel, 1, geofencingRequest.ng(), false);
        C0186b.m268c(parcel, 1000, geofencingRequest.getVersionCode());
        C0186b.m268c(parcel, 2, geofencingRequest.getInitialTrigger());
        C0186b.m244H(parcel, H);
    }

    public GeofencingRequest cI(Parcel parcel) {
        int i = 0;
        int G = C0185a.m208G(parcel);
        List list = null;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    list = C0185a.m216c(parcel, F, nn.CREATOR);
                    break;
                case 2:
                    i = C0185a.m221g(parcel, F);
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
            return new GeofencingRequest(i2, list, i);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cI(x0);
    }

    public GeofencingRequest[] ex(int i) {
        return new GeofencingRequest[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ex(x0);
    }
}
