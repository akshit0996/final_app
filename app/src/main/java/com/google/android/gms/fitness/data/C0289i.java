package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.fitness.data.i */
public class C0289i implements Creator<Device> {
    /* renamed from: a */
    static void m545a(Device device, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m256a(parcel, 1, device.getManufacturer(), false);
        C0186b.m268c(parcel, 1000, device.getVersionCode());
        C0186b.m256a(parcel, 2, device.getModel(), false);
        C0186b.m256a(parcel, 3, device.getVersion(), false);
        C0186b.m256a(parcel, 4, device.jF(), false);
        C0186b.m268c(parcel, 5, device.getType());
        C0186b.m268c(parcel, 6, device.jC());
        C0186b.m244H(parcel, H);
    }

    public Device bx(Parcel parcel) {
        int i = 0;
        String str = null;
        int G = C0185a.m208G(parcel);
        int i2 = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        int i3 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    str4 = C0185a.m229o(parcel, F);
                    break;
                case 2:
                    str3 = C0185a.m229o(parcel, F);
                    break;
                case 3:
                    str2 = C0185a.m229o(parcel, F);
                    break;
                case 4:
                    str = C0185a.m229o(parcel, F);
                    break;
                case 5:
                    i2 = C0185a.m221g(parcel, F);
                    break;
                case 6:
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
            return new Device(i3, str4, str3, str2, str, i2, i);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public Device[] cQ(int i) {
        return new Device[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bx(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cQ(x0);
    }
}
