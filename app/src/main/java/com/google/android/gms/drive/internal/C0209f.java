package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

/* renamed from: com.google.android.gms.drive.internal.f */
public class C0209f implements Creator<CloseContentsAndUpdateMetadataRequest> {
    /* renamed from: a */
    static void m382a(CloseContentsAndUpdateMetadataRequest closeContentsAndUpdateMetadataRequest, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, closeContentsAndUpdateMetadataRequest.CK);
        C0186b.m252a(parcel, 2, closeContentsAndUpdateMetadataRequest.Pp, i, false);
        C0186b.m252a(parcel, 3, closeContentsAndUpdateMetadataRequest.Pq, i, false);
        C0186b.m252a(parcel, 4, closeContentsAndUpdateMetadataRequest.Pr, i, false);
        C0186b.m259a(parcel, 5, closeContentsAndUpdateMetadataRequest.Oz);
        C0186b.m256a(parcel, 6, closeContentsAndUpdateMetadataRequest.Oy, false);
        C0186b.m268c(parcel, 7, closeContentsAndUpdateMetadataRequest.Ps);
        C0186b.m244H(parcel, H);
    }

    public CloseContentsAndUpdateMetadataRequest ad(Parcel parcel) {
        int i = 0;
        String str = null;
        int G = C0185a.m208G(parcel);
        boolean z = false;
        Contents contents = null;
        MetadataBundle metadataBundle = null;
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
                    metadataBundle = (MetadataBundle) C0185a.m210a(parcel, F, MetadataBundle.CREATOR);
                    break;
                case 4:
                    contents = (Contents) C0185a.m210a(parcel, F, Contents.CREATOR);
                    break;
                case 5:
                    z = C0185a.m217c(parcel, F);
                    break;
                case 6:
                    str = C0185a.m229o(parcel, F);
                    break;
                case 7:
                    i = C0185a.m221g(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new CloseContentsAndUpdateMetadataRequest(i2, driveId, metadataBundle, contents, z, str, i);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public CloseContentsAndUpdateMetadataRequest[] bn(int i) {
        return new CloseContentsAndUpdateMetadataRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ad(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bn(x0);
    }
}
