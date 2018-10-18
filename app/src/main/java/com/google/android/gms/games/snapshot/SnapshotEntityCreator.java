package com.google.android.gms.games.snapshot;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

public class SnapshotEntityCreator implements Creator<SnapshotEntity> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m966a(SnapshotEntity snapshotEntity, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m252a(parcel, 1, snapshotEntity.getMetadata(), i, false);
        C0186b.m268c(parcel, 1000, snapshotEntity.getVersionCode());
        C0186b.m252a(parcel, 3, snapshotEntity.getSnapshotContents(), i, false);
        C0186b.m244H(parcel, H);
    }

    public SnapshotEntity createFromParcel(Parcel parcel) {
        SnapshotContentsEntity snapshotContentsEntity = null;
        int G = C0185a.m208G(parcel);
        int i = 0;
        SnapshotMetadata snapshotMetadata = null;
        while (parcel.dataPosition() < G) {
            int i2;
            SnapshotContentsEntity snapshotContentsEntity2;
            SnapshotMetadata snapshotMetadata2;
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i2 = i;
                    SnapshotMetadataEntity snapshotMetadataEntity = (SnapshotMetadataEntity) C0185a.m210a(parcel, F, SnapshotMetadataEntity.CREATOR);
                    snapshotContentsEntity2 = snapshotContentsEntity;
                    Object obj = snapshotMetadataEntity;
                    break;
                case 3:
                    snapshotContentsEntity2 = (SnapshotContentsEntity) C0185a.m210a(parcel, F, SnapshotContentsEntity.CREATOR);
                    snapshotMetadata2 = snapshotMetadata;
                    i2 = i;
                    break;
                case 1000:
                    SnapshotContentsEntity snapshotContentsEntity3 = snapshotContentsEntity;
                    snapshotMetadata2 = snapshotMetadata;
                    i2 = C0185a.m221g(parcel, F);
                    snapshotContentsEntity2 = snapshotContentsEntity3;
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    snapshotContentsEntity2 = snapshotContentsEntity;
                    snapshotMetadata2 = snapshotMetadata;
                    i2 = i;
                    break;
            }
            i = i2;
            snapshotMetadata = snapshotMetadata2;
            snapshotContentsEntity = snapshotContentsEntity2;
        }
        if (parcel.dataPosition() == G) {
            return new SnapshotEntity(i, snapshotMetadata, snapshotContentsEntity);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public SnapshotEntity[] newArray(int size) {
        return new SnapshotEntity[size];
    }
}
