package com.google.android.gms.games.internal.game;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;
import java.util.ArrayList;

public class ExtendedGameEntityCreator implements Creator<ExtendedGameEntity> {
    /* renamed from: a */
    static void m948a(ExtendedGameEntity extendedGameEntity, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m252a(parcel, 1, extendedGameEntity.mi(), i, false);
        C0186b.m268c(parcel, 1000, extendedGameEntity.getVersionCode());
        C0186b.m268c(parcel, 2, extendedGameEntity.lZ());
        C0186b.m259a(parcel, 3, extendedGameEntity.ma());
        C0186b.m268c(parcel, 4, extendedGameEntity.mb());
        C0186b.m248a(parcel, 5, extendedGameEntity.mc());
        C0186b.m248a(parcel, 6, extendedGameEntity.md());
        C0186b.m256a(parcel, 7, extendedGameEntity.me(), false);
        C0186b.m248a(parcel, 8, extendedGameEntity.mf());
        C0186b.m256a(parcel, 9, extendedGameEntity.mg(), false);
        C0186b.m269c(parcel, 10, extendedGameEntity.lY(), false);
        C0186b.m252a(parcel, 11, extendedGameEntity.mh(), i, false);
        C0186b.m244H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cu(x0);
    }

    public ExtendedGameEntity cu(Parcel parcel) {
        int G = C0185a.m208G(parcel);
        int i = 0;
        GameEntity gameEntity = null;
        int i2 = 0;
        boolean z = false;
        int i3 = 0;
        long j = 0;
        long j2 = 0;
        String str = null;
        long j3 = 0;
        String str2 = null;
        ArrayList arrayList = null;
        SnapshotMetadataEntity snapshotMetadataEntity = null;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    gameEntity = (GameEntity) C0185a.m210a(parcel, F, GameEntity.CREATOR);
                    break;
                case 2:
                    i2 = C0185a.m221g(parcel, F);
                    break;
                case 3:
                    z = C0185a.m217c(parcel, F);
                    break;
                case 4:
                    i3 = C0185a.m221g(parcel, F);
                    break;
                case 5:
                    j = C0185a.m223i(parcel, F);
                    break;
                case 6:
                    j2 = C0185a.m223i(parcel, F);
                    break;
                case 7:
                    str = C0185a.m229o(parcel, F);
                    break;
                case 8:
                    j3 = C0185a.m223i(parcel, F);
                    break;
                case 9:
                    str2 = C0185a.m229o(parcel, F);
                    break;
                case 10:
                    arrayList = C0185a.m216c(parcel, F, GameBadgeEntity.CREATOR);
                    break;
                case 11:
                    snapshotMetadataEntity = (SnapshotMetadataEntity) C0185a.m210a(parcel, F, (Creator) SnapshotMetadataEntity.CREATOR);
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
            return new ExtendedGameEntity(i, gameEntity, i2, z, i3, j, j2, str, j3, str2, arrayList, snapshotMetadataEntity);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public ExtendedGameEntity[] eb(int i) {
        return new ExtendedGameEntity[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return eb(x0);
    }
}
