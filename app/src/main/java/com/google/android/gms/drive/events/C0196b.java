package com.google.android.gms.drive.events;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.List;

/* renamed from: com.google.android.gms.drive.events.b */
public class C0196b implements Creator<CompletionEvent> {
    /* renamed from: a */
    static void m289a(CompletionEvent completionEvent, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, completionEvent.CK);
        C0186b.m252a(parcel, 2, completionEvent.Oj, i, false);
        C0186b.m256a(parcel, 3, completionEvent.DZ, false);
        C0186b.m252a(parcel, 4, completionEvent.OY, i, false);
        C0186b.m252a(parcel, 5, completionEvent.OZ, i, false);
        C0186b.m252a(parcel, 6, completionEvent.Pa, i, false);
        C0186b.m267b(parcel, 7, completionEvent.Pb, false);
        C0186b.m268c(parcel, 8, completionEvent.FP);
        C0186b.m250a(parcel, 9, completionEvent.Pc, false);
        C0186b.m244H(parcel, H);
    }

    /* renamed from: Y */
    public CompletionEvent m290Y(Parcel parcel) {
        int i = 0;
        IBinder iBinder = null;
        int G = C0185a.m208G(parcel);
        List list = null;
        MetadataBundle metadataBundle = null;
        ParcelFileDescriptor parcelFileDescriptor = null;
        ParcelFileDescriptor parcelFileDescriptor2 = null;
        String str = null;
        DriveId driveId = null;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i2 = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    driveId = (DriveId) C0185a.m210a(parcel, F, DriveId.CREATOR);
                    break;
                case 3:
                    str = C0185a.m229o(parcel, F);
                    break;
                case 4:
                    parcelFileDescriptor2 = (ParcelFileDescriptor) C0185a.m210a(parcel, F, ParcelFileDescriptor.CREATOR);
                    break;
                case 5:
                    parcelFileDescriptor = (ParcelFileDescriptor) C0185a.m210a(parcel, F, ParcelFileDescriptor.CREATOR);
                    break;
                case 6:
                    metadataBundle = (MetadataBundle) C0185a.m210a(parcel, F, MetadataBundle.CREATOR);
                    break;
                case 7:
                    list = C0185a.m204C(parcel, F);
                    break;
                case 8:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 9:
                    iBinder = C0185a.m230p(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new CompletionEvent(i2, driveId, str, parcelFileDescriptor2, parcelFileDescriptor, metadataBundle, list, i, iBinder);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public CompletionEvent[] bg(int i) {
        return new CompletionEvent[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m290Y(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bg(x0);
    }
}
