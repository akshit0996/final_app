package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

/* renamed from: com.google.android.gms.drive.internal.k */
public class C0214k implements Creator<CreateFileRequest> {
    /* renamed from: a */
    static void m388a(CreateFileRequest createFileRequest, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, createFileRequest.CK);
        C0186b.m252a(parcel, 2, createFileRequest.Pz, i, false);
        C0186b.m252a(parcel, 3, createFileRequest.Px, i, false);
        C0186b.m252a(parcel, 4, createFileRequest.Pr, i, false);
        C0186b.m254a(parcel, 5, createFileRequest.Py, false);
        C0186b.m259a(parcel, 6, createFileRequest.PA);
        C0186b.m256a(parcel, 7, createFileRequest.Oy, false);
        C0186b.m268c(parcel, 8, createFileRequest.PB);
        C0186b.m268c(parcel, 9, createFileRequest.PC);
        C0186b.m244H(parcel, H);
    }

    public CreateFileRequest ah(Parcel parcel) {
        int i = 0;
        String str = null;
        int G = C0185a.m208G(parcel);
        int i2 = 0;
        boolean z = false;
        Integer num = null;
        Contents contents = null;
        MetadataBundle metadataBundle = null;
        DriveId driveId = null;
        int i3 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i3 = C0185a.m221g(parcel, F);
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
                    num = C0185a.m222h(parcel, F);
                    break;
                case 6:
                    z = C0185a.m217c(parcel, F);
                    break;
                case 7:
                    str = C0185a.m229o(parcel, F);
                    break;
                case 8:
                    i2 = C0185a.m221g(parcel, F);
                    break;
                case 9:
                    i = C0185a.m221g(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new CreateFileRequest(i3, driveId, metadataBundle, contents, num, z, str, i2, i);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public CreateFileRequest[] bs(int i) {
        return new CreateFileRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ah(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bs(x0);
    }
}
