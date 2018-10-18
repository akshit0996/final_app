package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.fitness.data.DataType;

/* renamed from: com.google.android.gms.fitness.result.d */
public class C0343d implements Creator<DataTypeResult> {
    /* renamed from: a */
    static void m653a(DataTypeResult dataTypeResult, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m252a(parcel, 1, dataTypeResult.getStatus(), i, false);
        C0186b.m268c(parcel, 1000, dataTypeResult.getVersionCode());
        C0186b.m252a(parcel, 3, dataTypeResult.getDataType(), i, false);
        C0186b.m244H(parcel, H);
    }

    public DataTypeResult cg(Parcel parcel) {
        DataType dataType = null;
        int G = C0185a.m208G(parcel);
        int i = 0;
        Status status = null;
        while (parcel.dataPosition() < G) {
            int i2;
            DataType dataType2;
            Status status2;
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i2 = i;
                    Status status3 = (Status) C0185a.m210a(parcel, F, Status.CREATOR);
                    dataType2 = dataType;
                    status2 = status3;
                    break;
                case 3:
                    dataType2 = (DataType) C0185a.m210a(parcel, F, DataType.CREATOR);
                    status2 = status;
                    i2 = i;
                    break;
                case 1000:
                    DataType dataType3 = dataType;
                    status2 = status;
                    i2 = C0185a.m221g(parcel, F);
                    dataType2 = dataType3;
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    dataType2 = dataType;
                    status2 = status;
                    i2 = i;
                    break;
            }
            i = i2;
            status = status2;
            dataType = dataType2;
        }
        if (parcel.dataPosition() == G) {
            return new DataTypeResult(i, status, dataType);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cg(x0);
    }

    public DataTypeResult[] dB(int i) {
        return new DataTypeResult[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dB(x0);
    }
}
