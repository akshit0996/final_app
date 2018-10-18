package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

/* renamed from: com.google.android.gms.drive.internal.j */
public class C0213j implements Creator<CreateFileIntentSenderRequest> {
    /* renamed from: a */
    static void m387a(CreateFileIntentSenderRequest createFileIntentSenderRequest, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, createFileIntentSenderRequest.CK);
        C0186b.m252a(parcel, 2, createFileIntentSenderRequest.Px, i, false);
        C0186b.m268c(parcel, 3, createFileIntentSenderRequest.ve);
        C0186b.m256a(parcel, 4, createFileIntentSenderRequest.OH, false);
        C0186b.m252a(parcel, 5, createFileIntentSenderRequest.OJ, i, false);
        C0186b.m254a(parcel, 6, createFileIntentSenderRequest.Py, false);
        C0186b.m244H(parcel, H);
    }

    public CreateFileIntentSenderRequest ag(Parcel parcel) {
        int i = 0;
        Integer num = null;
        int G = C0185a.m208G(parcel);
        DriveId driveId = null;
        String str = null;
        MetadataBundle metadataBundle = null;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i2 = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    metadataBundle = (MetadataBundle) C0185a.m210a(parcel, F, MetadataBundle.CREATOR);
                    break;
                case 3:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 4:
                    str = C0185a.m229o(parcel, F);
                    break;
                case 5:
                    driveId = (DriveId) C0185a.m210a(parcel, F, DriveId.CREATOR);
                    break;
                case 6:
                    num = C0185a.m222h(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new CreateFileIntentSenderRequest(i2, metadataBundle, i, str, driveId, num);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public CreateFileIntentSenderRequest[] br(int i) {
        return new CreateFileIntentSenderRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ag(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return br(x0);
    }
}
