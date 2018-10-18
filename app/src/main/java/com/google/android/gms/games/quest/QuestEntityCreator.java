package com.google.android.gms.games.quest;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.games.GameEntity;
import java.util.ArrayList;

public class QuestEntityCreator implements Creator<QuestEntity> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m963a(QuestEntity questEntity, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m252a(parcel, 1, questEntity.getGame(), i, false);
        C0186b.m256a(parcel, 2, questEntity.getQuestId(), false);
        C0186b.m248a(parcel, 3, questEntity.getAcceptedTimestamp());
        C0186b.m252a(parcel, 4, questEntity.getBannerImageUri(), i, false);
        C0186b.m256a(parcel, 5, questEntity.getBannerImageUrl(), false);
        C0186b.m256a(parcel, 6, questEntity.getDescription(), false);
        C0186b.m248a(parcel, 7, questEntity.getEndTimestamp());
        C0186b.m248a(parcel, 8, questEntity.getLastUpdatedTimestamp());
        C0186b.m252a(parcel, 9, questEntity.getIconImageUri(), i, false);
        C0186b.m256a(parcel, 10, questEntity.getIconImageUrl(), false);
        C0186b.m256a(parcel, 12, questEntity.getName(), false);
        C0186b.m248a(parcel, 13, questEntity.mR());
        C0186b.m248a(parcel, 14, questEntity.getStartTimestamp());
        C0186b.m268c(parcel, 15, questEntity.getState());
        C0186b.m269c(parcel, 17, questEntity.mQ(), false);
        C0186b.m268c(parcel, 16, questEntity.getType());
        C0186b.m268c(parcel, 1000, questEntity.getVersionCode());
        C0186b.m244H(parcel, H);
    }

    public QuestEntity createFromParcel(Parcel parcel) {
        int G = C0185a.m208G(parcel);
        int i = 0;
        GameEntity gameEntity = null;
        String str = null;
        long j = 0;
        Uri uri = null;
        String str2 = null;
        String str3 = null;
        long j2 = 0;
        long j3 = 0;
        Uri uri2 = null;
        String str4 = null;
        String str5 = null;
        long j4 = 0;
        long j5 = 0;
        int i2 = 0;
        int i3 = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    gameEntity = (GameEntity) C0185a.m210a(parcel, F, GameEntity.CREATOR);
                    break;
                case 2:
                    str = C0185a.m229o(parcel, F);
                    break;
                case 3:
                    j = C0185a.m223i(parcel, F);
                    break;
                case 4:
                    uri = (Uri) C0185a.m210a(parcel, F, Uri.CREATOR);
                    break;
                case 5:
                    str2 = C0185a.m229o(parcel, F);
                    break;
                case 6:
                    str3 = C0185a.m229o(parcel, F);
                    break;
                case 7:
                    j2 = C0185a.m223i(parcel, F);
                    break;
                case 8:
                    j3 = C0185a.m223i(parcel, F);
                    break;
                case 9:
                    uri2 = (Uri) C0185a.m210a(parcel, F, Uri.CREATOR);
                    break;
                case 10:
                    str4 = C0185a.m229o(parcel, F);
                    break;
                case 12:
                    str5 = C0185a.m229o(parcel, F);
                    break;
                case 13:
                    j4 = C0185a.m223i(parcel, F);
                    break;
                case 14:
                    j5 = C0185a.m223i(parcel, F);
                    break;
                case 15:
                    i2 = C0185a.m221g(parcel, F);
                    break;
                case 16:
                    i3 = C0185a.m221g(parcel, F);
                    break;
                case 17:
                    arrayList = C0185a.m216c(parcel, F, MilestoneEntity.CREATOR);
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
            return new QuestEntity(i, gameEntity, str, j, uri, str2, str3, j2, j3, uri2, str4, str5, j4, j5, i2, i3, arrayList);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public QuestEntity[] newArray(int size) {
        return new QuestEntity[size];
    }
}
