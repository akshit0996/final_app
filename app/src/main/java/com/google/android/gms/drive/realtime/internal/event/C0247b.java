package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import java.util.List;

/* renamed from: com.google.android.gms.drive.realtime.internal.event.b */
public class C0247b implements Creator<ParcelableEvent> {
    /* renamed from: a */
    static void m435a(ParcelableEvent parcelableEvent, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, parcelableEvent.CK);
        C0186b.m256a(parcel, 2, parcelableEvent.vZ, false);
        C0186b.m256a(parcel, 3, parcelableEvent.SJ, false);
        C0186b.m267b(parcel, 4, parcelableEvent.SQ, false);
        C0186b.m259a(parcel, 5, parcelableEvent.SR);
        C0186b.m256a(parcel, 6, parcelableEvent.SM, false);
        C0186b.m256a(parcel, 7, parcelableEvent.SS, false);
        C0186b.m252a(parcel, 8, parcelableEvent.ST, i, false);
        C0186b.m252a(parcel, 9, parcelableEvent.SU, i, false);
        C0186b.m252a(parcel, 10, parcelableEvent.SV, i, false);
        C0186b.m252a(parcel, 11, parcelableEvent.SW, i, false);
        C0186b.m252a(parcel, 12, parcelableEvent.SX, i, false);
        C0186b.m252a(parcel, 13, parcelableEvent.SY, i, false);
        C0186b.m252a(parcel, 14, parcelableEvent.SZ, i, false);
        C0186b.m252a(parcel, 15, parcelableEvent.Ta, i, false);
        C0186b.m244H(parcel, H);
    }

    public ParcelableEvent bh(Parcel parcel) {
        int G = C0185a.m208G(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        List list = null;
        boolean z = false;
        String str3 = null;
        String str4 = null;
        TextInsertedDetails textInsertedDetails = null;
        TextDeletedDetails textDeletedDetails = null;
        ValuesAddedDetails valuesAddedDetails = null;
        ValuesRemovedDetails valuesRemovedDetails = null;
        ValuesSetDetails valuesSetDetails = null;
        ValueChangedDetails valueChangedDetails = null;
        ReferenceShiftedDetails referenceShiftedDetails = null;
        ObjectChangedDetails objectChangedDetails = null;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    str = C0185a.m229o(parcel, F);
                    break;
                case 3:
                    str2 = C0185a.m229o(parcel, F);
                    break;
                case 4:
                    list = C0185a.m204C(parcel, F);
                    break;
                case 5:
                    z = C0185a.m217c(parcel, F);
                    break;
                case 6:
                    str3 = C0185a.m229o(parcel, F);
                    break;
                case 7:
                    str4 = C0185a.m229o(parcel, F);
                    break;
                case 8:
                    textInsertedDetails = (TextInsertedDetails) C0185a.m210a(parcel, F, TextInsertedDetails.CREATOR);
                    break;
                case 9:
                    textDeletedDetails = (TextDeletedDetails) C0185a.m210a(parcel, F, TextDeletedDetails.CREATOR);
                    break;
                case 10:
                    valuesAddedDetails = (ValuesAddedDetails) C0185a.m210a(parcel, F, ValuesAddedDetails.CREATOR);
                    break;
                case 11:
                    valuesRemovedDetails = (ValuesRemovedDetails) C0185a.m210a(parcel, F, ValuesRemovedDetails.CREATOR);
                    break;
                case 12:
                    valuesSetDetails = (ValuesSetDetails) C0185a.m210a(parcel, F, ValuesSetDetails.CREATOR);
                    break;
                case 13:
                    valueChangedDetails = (ValueChangedDetails) C0185a.m210a(parcel, F, ValueChangedDetails.CREATOR);
                    break;
                case 14:
                    referenceShiftedDetails = (ReferenceShiftedDetails) C0185a.m210a(parcel, F, ReferenceShiftedDetails.CREATOR);
                    break;
                case 15:
                    objectChangedDetails = (ObjectChangedDetails) C0185a.m210a(parcel, F, ObjectChangedDetails.CREATOR);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new ParcelableEvent(i, str, str2, list, z, str3, str4, textInsertedDetails, textDeletedDetails, valuesAddedDetails, valuesRemovedDetails, valuesSetDetails, valueChangedDetails, referenceShiftedDetails, objectChangedDetails);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bh(x0);
    }

    public ParcelableEvent[] cx(int i) {
        return new ParcelableEvent[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cx(x0);
    }
}
