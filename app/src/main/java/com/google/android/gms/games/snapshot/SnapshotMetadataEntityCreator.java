package com.google.android.gms.games.snapshot;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.PlayerEntity;

public class SnapshotMetadataEntityCreator implements Creator<SnapshotMetadataEntity> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m968a(SnapshotMetadataEntity snapshotMetadataEntity, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m252a(parcel, 1, snapshotMetadataEntity.getGame(), i, false);
        C0186b.m268c(parcel, 1000, snapshotMetadataEntity.getVersionCode());
        C0186b.m252a(parcel, 2, snapshotMetadataEntity.getOwner(), i, false);
        C0186b.m256a(parcel, 3, snapshotMetadataEntity.getSnapshotId(), false);
        C0186b.m252a(parcel, 5, snapshotMetadataEntity.getCoverImageUri(), i, false);
        C0186b.m256a(parcel, 6, snapshotMetadataEntity.getCoverImageUrl(), false);
        C0186b.m256a(parcel, 7, snapshotMetadataEntity.getTitle(), false);
        C0186b.m256a(parcel, 8, snapshotMetadataEntity.getDescription(), false);
        C0186b.m248a(parcel, 9, snapshotMetadataEntity.getLastModifiedTimestamp());
        C0186b.m248a(parcel, 10, snapshotMetadataEntity.getPlayedTime());
        C0186b.m247a(parcel, 11, snapshotMetadataEntity.getCoverImageAspectRatio());
        C0186b.m256a(parcel, 12, snapshotMetadataEntity.getUniqueName(), false);
        C0186b.m259a(parcel, 13, snapshotMetadataEntity.hasChangePending());
        C0186b.m244H(parcel, H);
    }

    public SnapshotMetadataEntity createFromParcel(Parcel parcel) {
        int G = C0185a.m208G(parcel);
        int i = 0;
        GameEntity gameEntity = null;
        PlayerEntity playerEntity = null;
        String str = null;
        Uri uri = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        long j = 0;
        long j2 = 0;
        float f = 0.0f;
        String str5 = null;
        boolean z = false;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    gameEntity = (GameEntity) C0185a.m210a(parcel, F, GameEntity.CREATOR);
                    break;
                case 2:
                    playerEntity = (PlayerEntity) C0185a.m210a(parcel, F, PlayerEntity.CREATOR);
                    break;
                case 3:
                    str = C0185a.m229o(parcel, F);
                    break;
                case 5:
                    uri = (Uri) C0185a.m210a(parcel, F, Uri.CREATOR);
                    break;
                case 6:
                    str2 = C0185a.m229o(parcel, F);
                    break;
                case 7:
                    str3 = C0185a.m229o(parcel, F);
                    break;
                case 8:
                    str4 = C0185a.m229o(parcel, F);
                    break;
                case 9:
                    j = C0185a.m223i(parcel, F);
                    break;
                case 10:
                    j2 = C0185a.m223i(parcel, F);
                    break;
                case 11:
                    f = C0185a.m226l(parcel, F);
                    break;
                case 12:
                    str5 = C0185a.m229o(parcel, F);
                    break;
                case 13:
                    z = C0185a.m217c(parcel, F);
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
            return new SnapshotMetadataEntity(i, gameEntity, playerEntity, str, uri, str2, str3, str4, j, j2, f, str5, z);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public SnapshotMetadataEntity[] newArray(int size) {
        return new SnapshotMetadataEntity[size];
    }
}
