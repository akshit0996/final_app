package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.fitness.data.n */
public class C0295n implements Creator<RawDataPoint> {
    /* renamed from: a */
    static void m552a(RawDataPoint rawDataPoint, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m248a(parcel, 1, rawDataPoint.Ud);
        C0186b.m268c(parcel, 1000, rawDataPoint.CK);
        C0186b.m248a(parcel, 2, rawDataPoint.Ue);
        C0186b.m262a(parcel, 3, rawDataPoint.Uf, i, false);
        C0186b.m268c(parcel, 4, rawDataPoint.UJ);
        C0186b.m268c(parcel, 5, rawDataPoint.UK);
        C0186b.m248a(parcel, 6, rawDataPoint.Uh);
        C0186b.m248a(parcel, 7, rawDataPoint.Ui);
        C0186b.m244H(parcel, H);
    }

    public RawDataPoint bA(Parcel parcel) {
        int G = C0185a.m208G(parcel);
        int i = 0;
        long j = 0;
        long j2 = 0;
        Value[] valueArr = null;
        int i2 = 0;
        int i3 = 0;
        long j3 = 0;
        long j4 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    j = C0185a.m223i(parcel, F);
                    break;
                case 2:
                    j2 = C0185a.m223i(parcel, F);
                    break;
                case 3:
                    valueArr = (Value[]) C0185a.m215b(parcel, F, Value.CREATOR);
                    break;
                case 4:
                    i2 = C0185a.m221g(parcel, F);
                    break;
                case 5:
                    i3 = C0185a.m221g(parcel, F);
                    break;
                case 6:
                    j3 = C0185a.m223i(parcel, F);
                    break;
                case 7:
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
            return new RawDataPoint(i, j, j2, valueArr, i2, i3, j3, j4);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public RawDataPoint[] cT(int i) {
        return new RawDataPoint[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bA(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cT(x0);
    }
}
