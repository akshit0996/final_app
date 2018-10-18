package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.fitness.data.BleDevice;
import java.util.List;

/* renamed from: com.google.android.gms.fitness.result.a */
public class C0340a implements Creator<BleDevicesResult> {
    /* renamed from: a */
    static void m650a(BleDevicesResult bleDevicesResult, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m269c(parcel, 1, bleDevicesResult.getClaimedBleDevices(), false);
        C0186b.m268c(parcel, 1000, bleDevicesResult.getVersionCode());
        C0186b.m252a(parcel, 2, bleDevicesResult.getStatus(), i, false);
        C0186b.m244H(parcel, H);
    }

    public BleDevicesResult cd(Parcel parcel) {
        Status status = null;
        int G = C0185a.m208G(parcel);
        int i = 0;
        List list = null;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    list = C0185a.m216c(parcel, F, BleDevice.CREATOR);
                    break;
                case 2:
                    status = (Status) C0185a.m210a(parcel, F, Status.CREATOR);
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
            return new BleDevicesResult(i, list, status);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cd(x0);
    }

    public BleDevicesResult[] dy(int i) {
        return new BleDevicesResult[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dy(x0);
    }
}
