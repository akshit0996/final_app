package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

/* renamed from: com.google.android.gms.drive.internal.l */
public class C0215l implements Creator<CreateFolderRequest> {
    /* renamed from: a */
    static void m389a(CreateFolderRequest createFolderRequest, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, createFolderRequest.CK);
        C0186b.m252a(parcel, 2, createFolderRequest.Pz, i, false);
        C0186b.m252a(parcel, 3, createFolderRequest.Px, i, false);
        C0186b.m244H(parcel, H);
    }

    public CreateFolderRequest ai(Parcel parcel) {
        MetadataBundle metadataBundle = null;
        int G = C0185a.m208G(parcel);
        int i = 0;
        DriveId driveId = null;
        while (parcel.dataPosition() < G) {
            DriveId driveId2;
            int g;
            MetadataBundle metadataBundle2;
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    MetadataBundle metadataBundle3 = metadataBundle;
                    driveId2 = driveId;
                    g = C0185a.m221g(parcel, F);
                    metadataBundle2 = metadataBundle3;
                    break;
                case 2:
                    g = i;
                    DriveId driveId3 = (DriveId) C0185a.m210a(parcel, F, DriveId.CREATOR);
                    metadataBundle2 = metadataBundle;
                    driveId2 = driveId3;
                    break;
                case 3:
                    metadataBundle2 = (MetadataBundle) C0185a.m210a(parcel, F, MetadataBundle.CREATOR);
                    driveId2 = driveId;
                    g = i;
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    metadataBundle2 = metadataBundle;
                    driveId2 = driveId;
                    g = i;
                    break;
            }
            i = g;
            driveId = driveId2;
            metadataBundle = metadataBundle2;
        }
        if (parcel.dataPosition() == G) {
            return new CreateFolderRequest(i, driveId, metadataBundle);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public CreateFolderRequest[] bt(int i) {
        return new CreateFolderRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ai(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bt(x0);
    }
}
