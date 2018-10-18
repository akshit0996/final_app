package com.google.android.gms.games.snapshot;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.C0810a;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

public class SnapshotMetadataChangeCreator implements Creator<SnapshotMetadataChangeEntity> {
    /* renamed from: a */
    static void m967a(SnapshotMetadataChangeEntity snapshotMetadataChangeEntity, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m256a(parcel, 1, snapshotMetadataChangeEntity.getDescription(), false);
        C0186b.m268c(parcel, 1000, snapshotMetadataChangeEntity.getVersionCode());
        C0186b.m255a(parcel, 2, snapshotMetadataChangeEntity.getPlayedTimeMillis(), false);
        C0186b.m252a(parcel, 4, snapshotMetadataChangeEntity.getCoverImageUri(), i, false);
        C0186b.m252a(parcel, 5, snapshotMetadataChangeEntity.mT(), i, false);
        C0186b.m244H(parcel, H);
    }

    public SnapshotMetadataChangeEntity cE(Parcel parcel) {
        Uri uri = null;
        int G = C0185a.m208G(parcel);
        int i = 0;
        C0810a c0810a = null;
        Long l = null;
        String str = null;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    str = C0185a.m229o(parcel, F);
                    break;
                case 2:
                    l = C0185a.m224j(parcel, F);
                    break;
                case 4:
                    uri = (Uri) C0185a.m210a(parcel, F, Uri.CREATOR);
                    break;
                case 5:
                    c0810a = (C0810a) C0185a.m210a(parcel, F, C0810a.CREATOR);
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
            return new SnapshotMetadataChangeEntity(i, str, l, c0810a, uri);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cE(x0);
    }

    public SnapshotMetadataChangeEntity[] er(int i) {
        return new SnapshotMetadataChangeEntity[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return er(x0);
    }
}
