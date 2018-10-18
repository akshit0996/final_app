package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.common.data.f */
public class C0175f implements Creator<DataHolder> {
    /* renamed from: a */
    static void m173a(DataHolder dataHolder, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m263a(parcel, 1, dataHolder.gY(), false);
        C0186b.m268c(parcel, 1000, dataHolder.getVersionCode());
        C0186b.m262a(parcel, 2, dataHolder.gZ(), i, false);
        C0186b.m268c(parcel, 3, dataHolder.getStatusCode());
        C0186b.m249a(parcel, 4, dataHolder.gV(), false);
        C0186b.m244H(parcel, H);
    }

    /* renamed from: B */
    public DataHolder m174B(Parcel parcel) {
        int i = 0;
        Bundle bundle = null;
        int G = C0185a.m208G(parcel);
        CursorWindow[] cursorWindowArr = null;
        String[] strArr = null;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    strArr = C0185a.m202A(parcel, F);
                    break;
                case 2:
                    cursorWindowArr = (CursorWindow[]) C0185a.m215b(parcel, F, CursorWindow.CREATOR);
                    break;
                case 3:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 4:
                    bundle = C0185a.m231q(parcel, F);
                    break;
                case 1000:
                    i2 = C0185a.m221g(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() != G) {
            throw new C0184a("Overread allowed size end=" + G, parcel);
        }
        DataHolder dataHolder = new DataHolder(i2, strArr, cursorWindowArr, i, bundle);
        dataHolder.gX();
        return dataHolder;
    }

    public DataHolder[] aw(int i) {
        return new DataHolder[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m174B(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aw(x0);
    }
}
