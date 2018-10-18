package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.fitness.data.g */
public class C0287g implements Creator<DataSource> {
    /* renamed from: a */
    static void m543a(DataSource dataSource, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m252a(parcel, 1, dataSource.getDataType(), i, false);
        C0186b.m268c(parcel, 1000, dataSource.getVersionCode());
        C0186b.m256a(parcel, 2, dataSource.getName(), false);
        C0186b.m268c(parcel, 3, dataSource.getType());
        C0186b.m252a(parcel, 4, dataSource.getDevice(), i, false);
        C0186b.m252a(parcel, 5, dataSource.jx(), i, false);
        C0186b.m256a(parcel, 6, dataSource.getStreamName(), false);
        C0186b.m259a(parcel, 7, dataSource.jz());
        C0186b.m244H(parcel, H);
    }

    public DataSource bv(Parcel parcel) {
        boolean z = false;
        String str = null;
        int G = C0185a.m208G(parcel);
        C0873a c0873a = null;
        Device device = null;
        int i = 0;
        String str2 = null;
        DataType dataType = null;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    dataType = (DataType) C0185a.m210a(parcel, F, DataType.CREATOR);
                    break;
                case 2:
                    str2 = C0185a.m229o(parcel, F);
                    break;
                case 3:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 4:
                    device = (Device) C0185a.m210a(parcel, F, Device.CREATOR);
                    break;
                case 5:
                    c0873a = (C0873a) C0185a.m210a(parcel, F, C0873a.CREATOR);
                    break;
                case 6:
                    str = C0185a.m229o(parcel, F);
                    break;
                case 7:
                    z = C0185a.m217c(parcel, F);
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
            return new DataSource(i2, dataType, str2, i, device, c0873a, str, z);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public DataSource[] cO(int i) {
        return new DataSource[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bv(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cO(x0);
    }
}
