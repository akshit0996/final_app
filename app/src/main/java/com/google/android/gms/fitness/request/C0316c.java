package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.fitness.data.BleDevice;

/* renamed from: com.google.android.gms.fitness.request.c */
public class C0316c implements Creator<C0877b> {
    /* renamed from: a */
    static void m626a(C0877b c0877b, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m256a(parcel, 1, c0877b.getDeviceAddress(), false);
        C0186b.m268c(parcel, 1000, c0877b.getVersionCode());
        C0186b.m252a(parcel, 2, c0877b.jQ(), i, false);
        C0186b.m244H(parcel, H);
    }

    public C0877b bI(Parcel parcel) {
        BleDevice bleDevice = null;
        int G = C0185a.m208G(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    str = C0185a.m229o(parcel, F);
                    break;
                case 2:
                    bleDevice = (BleDevice) C0185a.m210a(parcel, F, BleDevice.CREATOR);
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
            return new C0877b(i, str, bleDevice);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bI(x0);
    }

    public C0877b[] dc(int i) {
        return new C0877b[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dc(x0);
    }
}
