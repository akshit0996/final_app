package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.util.TimeUtils;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

public class GameEntityCreator implements Creator<GameEntity> {
    /* renamed from: a */
    static void m658a(GameEntity gameEntity, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m256a(parcel, 1, gameEntity.getApplicationId(), false);
        C0186b.m256a(parcel, 2, gameEntity.getDisplayName(), false);
        C0186b.m256a(parcel, 3, gameEntity.getPrimaryCategory(), false);
        C0186b.m256a(parcel, 4, gameEntity.getSecondaryCategory(), false);
        C0186b.m256a(parcel, 5, gameEntity.getDescription(), false);
        C0186b.m256a(parcel, 6, gameEntity.getDeveloperName(), false);
        C0186b.m252a(parcel, 7, gameEntity.getIconImageUri(), i, false);
        C0186b.m252a(parcel, 8, gameEntity.getHiResImageUri(), i, false);
        C0186b.m252a(parcel, 9, gameEntity.getFeaturedImageUri(), i, false);
        C0186b.m259a(parcel, 10, gameEntity.ky());
        C0186b.m259a(parcel, 11, gameEntity.kA());
        C0186b.m256a(parcel, 12, gameEntity.kB(), false);
        C0186b.m268c(parcel, 13, gameEntity.kC());
        C0186b.m268c(parcel, 14, gameEntity.getAchievementTotalCount());
        C0186b.m268c(parcel, 15, gameEntity.getLeaderboardCount());
        C0186b.m259a(parcel, 17, gameEntity.isTurnBasedMultiplayerEnabled());
        C0186b.m259a(parcel, 16, gameEntity.isRealTimeMultiplayerEnabled());
        C0186b.m268c(parcel, 1000, gameEntity.getVersionCode());
        C0186b.m256a(parcel, 19, gameEntity.getHiResImageUrl(), false);
        C0186b.m256a(parcel, 18, gameEntity.getIconImageUrl(), false);
        C0186b.m259a(parcel, 21, gameEntity.isMuted());
        C0186b.m256a(parcel, 20, gameEntity.getFeaturedImageUrl(), false);
        C0186b.m259a(parcel, 23, gameEntity.areSnapshotsEnabled());
        C0186b.m259a(parcel, 22, gameEntity.kz());
        C0186b.m256a(parcel, 24, gameEntity.getThemeColor(), false);
        C0186b.m244H(parcel, H);
    }

    public GameEntity cl(Parcel parcel) {
        int G = C0185a.m208G(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        Uri uri = null;
        Uri uri2 = null;
        Uri uri3 = null;
        boolean z = false;
        boolean z2 = false;
        String str7 = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        boolean z3 = false;
        boolean z4 = false;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        String str11 = null;
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
                    str3 = C0185a.m229o(parcel, F);
                    break;
                case 4:
                    str4 = C0185a.m229o(parcel, F);
                    break;
                case 5:
                    str5 = C0185a.m229o(parcel, F);
                    break;
                case 6:
                    str6 = C0185a.m229o(parcel, F);
                    break;
                case 7:
                    uri = (Uri) C0185a.m210a(parcel, F, Uri.CREATOR);
                    break;
                case 8:
                    uri2 = (Uri) C0185a.m210a(parcel, F, Uri.CREATOR);
                    break;
                case 9:
                    uri3 = (Uri) C0185a.m210a(parcel, F, Uri.CREATOR);
                    break;
                case 10:
                    z = C0185a.m217c(parcel, F);
                    break;
                case 11:
                    z2 = C0185a.m217c(parcel, F);
                    break;
                case 12:
                    str7 = C0185a.m229o(parcel, F);
                    break;
                case 13:
                    i2 = C0185a.m221g(parcel, F);
                    break;
                case 14:
                    i3 = C0185a.m221g(parcel, F);
                    break;
                case 15:
                    i4 = C0185a.m221g(parcel, F);
                    break;
                case 16:
                    z3 = C0185a.m217c(parcel, F);
                    break;
                case 17:
                    z4 = C0185a.m217c(parcel, F);
                    break;
                case 18:
                    str8 = C0185a.m229o(parcel, F);
                    break;
                case TimeUtils.HUNDRED_DAY_FIELD_LEN /*19*/:
                    str9 = C0185a.m229o(parcel, F);
                    break;
                case 20:
                    str10 = C0185a.m229o(parcel, F);
                    break;
                case 21:
                    z5 = C0185a.m217c(parcel, F);
                    break;
                case 22:
                    z6 = C0185a.m217c(parcel, F);
                    break;
                case 23:
                    z7 = C0185a.m217c(parcel, F);
                    break;
                case 24:
                    str11 = C0185a.m229o(parcel, F);
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
            return new GameEntity(i, str, str2, str3, str4, str5, str6, uri, uri2, uri3, z, z2, str7, i2, i3, i4, z3, z4, str8, str9, str10, z5, z6, z7, str11);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cl(x0);
    }

    public GameEntity[] dG(int i) {
        return new GameEntity[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dG(x0);
    }
}
