package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

public class ar implements Creator<OnListEntriesResponse> {
    /* renamed from: a */
    static void m363a(OnListEntriesResponse onListEntriesResponse, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, onListEntriesResponse.CK);
        C0186b.m252a(parcel, 2, onListEntriesResponse.QQ, i, false);
        C0186b.m259a(parcel, 3, onListEntriesResponse.PJ);
        C0186b.m244H(parcel, H);
    }

    public OnListEntriesResponse aw(Parcel parcel) {
        boolean z = false;
        int G = C0185a.m208G(parcel);
        DataHolder dataHolder = null;
        int i = 0;
        while (parcel.dataPosition() < G) {
            DataHolder dataHolder2;
            int g;
            boolean z2;
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    boolean z3 = z;
                    dataHolder2 = dataHolder;
                    g = C0185a.m221g(parcel, F);
                    z2 = z3;
                    break;
                case 2:
                    g = i;
                    DataHolder dataHolder3 = (DataHolder) C0185a.m210a(parcel, F, DataHolder.CREATOR);
                    z2 = z;
                    dataHolder2 = dataHolder3;
                    break;
                case 3:
                    z2 = C0185a.m217c(parcel, F);
                    dataHolder2 = dataHolder;
                    g = i;
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    z2 = z;
                    dataHolder2 = dataHolder;
                    g = i;
                    break;
            }
            i = g;
            dataHolder = dataHolder2;
            z = z2;
        }
        if (parcel.dataPosition() == G) {
            return new OnListEntriesResponse(i, dataHolder, z);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public OnListEntriesResponse[] bL(int i) {
        return new OnListEntriesResponse[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aw(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bL(x0);
    }
}
