package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import java.util.List;

/* renamed from: com.google.android.gms.fitness.data.c */
public class C0283c implements Creator<BleDevice> {
    /* renamed from: a */
    static void m539a(BleDevice bleDevice, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m256a(parcel, 1, bleDevice.getAddress(), false);
        C0186b.m268c(parcel, 1000, bleDevice.getVersionCode());
        C0186b.m256a(parcel, 2, bleDevice.getName(), false);
        C0186b.m267b(parcel, 3, bleDevice.getSupportedProfiles(), false);
        C0186b.m269c(parcel, 4, bleDevice.getDataTypes(), false);
        C0186b.m244H(parcel, H);
    }

    public BleDevice br(Parcel parcel) {
        List list = null;
        int G = C0185a.m208G(parcel);
        int i = 0;
        List list2 = null;
        String str = null;
        String str2 = null;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    str2 = C0185a.m229o(parcel, F);
                    break;
                case 2:
                    str = C0185a.m229o(parcel, F);
                    break;
                case 3:
                    list2 = C0185a.m204C(parcel, F);
                    break;
                case 4:
                    list = C0185a.m216c(parcel, F, DataType.CREATOR);
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
            return new BleDevice(i, str2, str, list2, list);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public BleDevice[] cI(int i) {
        return new BleDevice[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return br(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cI(x0);
    }
}
