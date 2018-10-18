package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import java.util.List;

/* renamed from: com.google.android.gms.cast.b */
public class C0148b implements Creator<CastDevice> {
    /* renamed from: a */
    static void m117a(CastDevice castDevice, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, castDevice.getVersionCode());
        C0186b.m256a(parcel, 2, castDevice.getDeviceId(), false);
        C0186b.m256a(parcel, 3, castDevice.FH, false);
        C0186b.m256a(parcel, 4, castDevice.getFriendlyName(), false);
        C0186b.m256a(parcel, 5, castDevice.getModelName(), false);
        C0186b.m256a(parcel, 6, castDevice.getDeviceVersion(), false);
        C0186b.m268c(parcel, 7, castDevice.getServicePort());
        C0186b.m269c(parcel, 8, castDevice.getIcons(), false);
        C0186b.m268c(parcel, 9, castDevice.getCapabilities());
        C0186b.m268c(parcel, 10, castDevice.getStatus());
        C0186b.m244H(parcel, H);
    }

    /* renamed from: Z */
    public CastDevice[] m118Z(int i) {
        return new CastDevice[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m119v(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m118Z(x0);
    }

    /* renamed from: v */
    public CastDevice m119v(Parcel parcel) {
        int i = 0;
        List list = null;
        int G = C0185a.m208G(parcel);
        int i2 = 0;
        int i3 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        int i4 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i4 = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    str5 = C0185a.m229o(parcel, F);
                    break;
                case 3:
                    str4 = C0185a.m229o(parcel, F);
                    break;
                case 4:
                    str3 = C0185a.m229o(parcel, F);
                    break;
                case 5:
                    str2 = C0185a.m229o(parcel, F);
                    break;
                case 6:
                    str = C0185a.m229o(parcel, F);
                    break;
                case 7:
                    i3 = C0185a.m221g(parcel, F);
                    break;
                case 8:
                    list = C0185a.m216c(parcel, F, WebImage.CREATOR);
                    break;
                case 9:
                    i2 = C0185a.m221g(parcel, F);
                    break;
                case 10:
                    i = C0185a.m221g(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new CastDevice(i4, str5, str4, str3, str2, str, i3, list, i2, i);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }
}
