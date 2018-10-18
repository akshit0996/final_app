package com.google.android.gms.games.achievement;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.games.PlayerEntity;

public class AchievementEntityCreator implements Creator<AchievementEntity> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m665a(AchievementEntity achievementEntity, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m256a(parcel, 1, achievementEntity.getAchievementId(), false);
        C0186b.m268c(parcel, 2, achievementEntity.getType());
        C0186b.m256a(parcel, 3, achievementEntity.getName(), false);
        C0186b.m256a(parcel, 4, achievementEntity.getDescription(), false);
        C0186b.m252a(parcel, 5, achievementEntity.getUnlockedImageUri(), i, false);
        C0186b.m256a(parcel, 6, achievementEntity.getUnlockedImageUrl(), false);
        C0186b.m252a(parcel, 7, achievementEntity.getRevealedImageUri(), i, false);
        C0186b.m256a(parcel, 8, achievementEntity.getRevealedImageUrl(), false);
        C0186b.m268c(parcel, 9, achievementEntity.getTotalSteps());
        C0186b.m256a(parcel, 10, achievementEntity.getFormattedTotalSteps(), false);
        C0186b.m252a(parcel, 11, achievementEntity.getPlayer(), i, false);
        C0186b.m268c(parcel, 12, achievementEntity.getState());
        C0186b.m268c(parcel, 13, achievementEntity.getCurrentSteps());
        C0186b.m256a(parcel, 14, achievementEntity.getFormattedCurrentSteps(), false);
        C0186b.m248a(parcel, 15, achievementEntity.getLastUpdatedTimestamp());
        C0186b.m248a(parcel, 16, achievementEntity.getXpValue());
        C0186b.m268c(parcel, 1000, achievementEntity.getVersionCode());
        C0186b.m244H(parcel, H);
    }

    public AchievementEntity createFromParcel(Parcel parcel) {
        int G = C0185a.m208G(parcel);
        int i = 0;
        String str = null;
        int i2 = 0;
        String str2 = null;
        String str3 = null;
        Uri uri = null;
        String str4 = null;
        Uri uri2 = null;
        String str5 = null;
        int i3 = 0;
        String str6 = null;
        PlayerEntity playerEntity = null;
        int i4 = 0;
        int i5 = 0;
        String str7 = null;
        long j = 0;
        long j2 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    str = C0185a.m229o(parcel, F);
                    break;
                case 2:
                    i2 = C0185a.m221g(parcel, F);
                    break;
                case 3:
                    str2 = C0185a.m229o(parcel, F);
                    break;
                case 4:
                    str3 = C0185a.m229o(parcel, F);
                    break;
                case 5:
                    uri = (Uri) C0185a.m210a(parcel, F, Uri.CREATOR);
                    break;
                case 6:
                    str4 = C0185a.m229o(parcel, F);
                    break;
                case 7:
                    uri2 = (Uri) C0185a.m210a(parcel, F, Uri.CREATOR);
                    break;
                case 8:
                    str5 = C0185a.m229o(parcel, F);
                    break;
                case 9:
                    i3 = C0185a.m221g(parcel, F);
                    break;
                case 10:
                    str6 = C0185a.m229o(parcel, F);
                    break;
                case 11:
                    playerEntity = (PlayerEntity) C0185a.m210a(parcel, F, PlayerEntity.CREATOR);
                    break;
                case 12:
                    i4 = C0185a.m221g(parcel, F);
                    break;
                case 13:
                    i5 = C0185a.m221g(parcel, F);
                    break;
                case 14:
                    str7 = C0185a.m229o(parcel, F);
                    break;
                case 15:
                    j = C0185a.m223i(parcel, F);
                    break;
                case 16:
                    j2 = C0185a.m223i(parcel, F);
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
            return new AchievementEntity(i, str, i2, str2, str3, uri, str4, uri2, str5, i3, str6, playerEntity, i4, i5, str7, j, j2);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public AchievementEntity[] newArray(int size) {
        return new AchievementEntity[size];
    }
}
