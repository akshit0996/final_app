package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import java.util.List;

/* renamed from: com.google.android.gms.drive.realtime.internal.event.c */
public class C0248c implements Creator<ParcelableEventList> {
    /* renamed from: a */
    static void m436a(ParcelableEventList parcelableEventList, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, parcelableEventList.CK);
        C0186b.m269c(parcel, 2, parcelableEventList.mp, false);
        C0186b.m252a(parcel, 3, parcelableEventList.Tb, i, false);
        C0186b.m259a(parcel, 4, parcelableEventList.Tc);
        C0186b.m267b(parcel, 5, parcelableEventList.Td, false);
        C0186b.m244H(parcel, H);
    }

    public ParcelableEventList bi(Parcel parcel) {
        boolean z = false;
        List list = null;
        int G = C0185a.m208G(parcel);
        DataHolder dataHolder = null;
        List list2 = null;
        int i = 0;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    list2 = C0185a.m216c(parcel, F, ParcelableEvent.CREATOR);
                    break;
                case 3:
                    dataHolder = (DataHolder) C0185a.m210a(parcel, F, DataHolder.CREATOR);
                    break;
                case 4:
                    z = C0185a.m217c(parcel, F);
                    break;
                case 5:
                    list = C0185a.m204C(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new ParcelableEventList(i, list2, dataHolder, z, list);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bi(x0);
    }

    public ParcelableEventList[] cy(int i) {
        return new ParcelableEventList[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cy(x0);
    }
}
