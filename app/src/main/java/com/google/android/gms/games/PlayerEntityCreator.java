package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.games.internal.player.MostRecentGameInfoEntity;

public class PlayerEntityCreator implements Creator<PlayerEntity> {
    /* renamed from: a */
    static void m662a(PlayerEntity playerEntity, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m256a(parcel, 1, playerEntity.getPlayerId(), false);
        C0186b.m256a(parcel, 2, playerEntity.getDisplayName(), false);
        C0186b.m252a(parcel, 3, playerEntity.getIconImageUri(), i, false);
        C0186b.m252a(parcel, 4, playerEntity.getHiResImageUri(), i, false);
        C0186b.m248a(parcel, 5, playerEntity.getRetrievedTimestamp());
        C0186b.m268c(parcel, 6, playerEntity.kE());
        C0186b.m248a(parcel, 7, playerEntity.getLastPlayedWithTimestamp());
        C0186b.m256a(parcel, 8, playerEntity.getIconImageUrl(), false);
        C0186b.m256a(parcel, 9, playerEntity.getHiResImageUrl(), false);
        C0186b.m256a(parcel, 14, playerEntity.getTitle(), false);
        C0186b.m252a(parcel, 15, playerEntity.kF(), i, false);
        C0186b.m252a(parcel, 16, playerEntity.getLevelInfo(), i, false);
        C0186b.m268c(parcel, 1000, playerEntity.getVersionCode());
        C0186b.m259a(parcel, 18, playerEntity.isProfileVisible());
        C0186b.m244H(parcel, H);
    }

    public PlayerEntity cm(Parcel parcel) {
        int G = C0185a.m208G(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        Uri uri = null;
        Uri uri2 = null;
        long j = 0;
        int i2 = 0;
        long j2 = 0;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        MostRecentGameInfoEntity mostRecentGameInfoEntity = null;
        PlayerLevelInfo playerLevelInfo = null;
        boolean z = false;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    str = C0185a.m229o(parcel, F);
                    break;
                case 2:
                    str2 = C0185a.m229o(parcel, F);
                    break;
                case 3:
                    uri = (Uri) C0185a.m210a(parcel, F, Uri.CREATOR);
                    break;
                case 4:
                    uri2 = (Uri) C0185a.m210a(parcel, F, Uri.CREATOR);
                    break;
                case 5:
                    j = C0185a.m223i(parcel, F);
                    break;
                case 6:
                    i2 = C0185a.m221g(parcel, F);
                    break;
                case 7:
                    j2 = C0185a.m223i(parcel, F);
                    break;
                case 8:
                    str3 = C0185a.m229o(parcel, F);
                    break;
                case 9:
                    str4 = C0185a.m229o(parcel, F);
                    break;
                case 14:
                    str5 = C0185a.m229o(parcel, F);
                    break;
                case 15:
                    mostRecentGameInfoEntity = (MostRecentGameInfoEntity) C0185a.m210a(parcel, F, (Creator) MostRecentGameInfoEntity.CREATOR);
                    break;
                case 16:
                    playerLevelInfo = (PlayerLevelInfo) C0185a.m210a(parcel, F, (Creator) PlayerLevelInfo.CREATOR);
                    break;
                case 18:
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
            return new PlayerEntity(i, str, str2, uri, uri2, j, i2, j2, str3, str4, str5, mostRecentGameInfoEntity, playerLevelInfo, z);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cm(x0);
    }

    public PlayerEntity[] dH(int i) {
        return new PlayerEntity[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dH(x0);
    }
}
