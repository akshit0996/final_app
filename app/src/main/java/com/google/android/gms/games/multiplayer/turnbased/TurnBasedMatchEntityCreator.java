package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.util.TimeUtils;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import java.util.ArrayList;

public class TurnBasedMatchEntityCreator implements Creator<TurnBasedMatchEntity> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m961a(TurnBasedMatchEntity turnBasedMatchEntity, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m252a(parcel, 1, turnBasedMatchEntity.getGame(), i, false);
        C0186b.m256a(parcel, 2, turnBasedMatchEntity.getMatchId(), false);
        C0186b.m256a(parcel, 3, turnBasedMatchEntity.getCreatorId(), false);
        C0186b.m248a(parcel, 4, turnBasedMatchEntity.getCreationTimestamp());
        C0186b.m256a(parcel, 5, turnBasedMatchEntity.getLastUpdaterId(), false);
        C0186b.m248a(parcel, 6, turnBasedMatchEntity.getLastUpdatedTimestamp());
        C0186b.m256a(parcel, 7, turnBasedMatchEntity.getPendingParticipantId(), false);
        C0186b.m268c(parcel, 8, turnBasedMatchEntity.getStatus());
        C0186b.m268c(parcel, 10, turnBasedMatchEntity.getVariant());
        C0186b.m268c(parcel, 11, turnBasedMatchEntity.getVersion());
        C0186b.m260a(parcel, 12, turnBasedMatchEntity.getData(), false);
        C0186b.m269c(parcel, 13, turnBasedMatchEntity.getParticipants(), false);
        C0186b.m256a(parcel, 14, turnBasedMatchEntity.getRematchId(), false);
        C0186b.m260a(parcel, 15, turnBasedMatchEntity.getPreviousMatchData(), false);
        C0186b.m249a(parcel, 17, turnBasedMatchEntity.getAutoMatchCriteria(), false);
        C0186b.m268c(parcel, 16, turnBasedMatchEntity.getMatchNumber());
        C0186b.m268c(parcel, 1000, turnBasedMatchEntity.getVersionCode());
        C0186b.m259a(parcel, 19, turnBasedMatchEntity.isLocallyModified());
        C0186b.m268c(parcel, 18, turnBasedMatchEntity.getTurnStatus());
        C0186b.m256a(parcel, 21, turnBasedMatchEntity.getDescriptionParticipantId(), false);
        C0186b.m256a(parcel, 20, turnBasedMatchEntity.getDescription(), false);
        C0186b.m244H(parcel, H);
    }

    public TurnBasedMatchEntity createFromParcel(Parcel parcel) {
        int G = C0185a.m208G(parcel);
        int i = 0;
        GameEntity gameEntity = null;
        String str = null;
        String str2 = null;
        long j = 0;
        String str3 = null;
        long j2 = 0;
        String str4 = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        byte[] bArr = null;
        ArrayList arrayList = null;
        String str5 = null;
        byte[] bArr2 = null;
        int i5 = 0;
        Bundle bundle = null;
        int i6 = 0;
        boolean z = false;
        String str6 = null;
        String str7 = null;
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
                    str2 = C0185a.m229o(parcel, F);
                    break;
                case 4:
                    j = C0185a.m223i(parcel, F);
                    break;
                case 5:
                    str3 = C0185a.m229o(parcel, F);
                    break;
                case 6:
                    j2 = C0185a.m223i(parcel, F);
                    break;
                case 7:
                    str4 = C0185a.m229o(parcel, F);
                    break;
                case 8:
                    i2 = C0185a.m221g(parcel, F);
                    break;
                case 10:
                    i3 = C0185a.m221g(parcel, F);
                    break;
                case 11:
                    i4 = C0185a.m221g(parcel, F);
                    break;
                case 12:
                    bArr = C0185a.m232r(parcel, F);
                    break;
                case 13:
                    arrayList = C0185a.m216c(parcel, F, ParticipantEntity.CREATOR);
                    break;
                case 14:
                    str5 = C0185a.m229o(parcel, F);
                    break;
                case 15:
                    bArr2 = C0185a.m232r(parcel, F);
                    break;
                case 16:
                    i5 = C0185a.m221g(parcel, F);
                    break;
                case 17:
                    bundle = C0185a.m231q(parcel, F);
                    break;
                case 18:
                    i6 = C0185a.m221g(parcel, F);
                    break;
                case TimeUtils.HUNDRED_DAY_FIELD_LEN /*19*/:
                    z = C0185a.m217c(parcel, F);
                    break;
                case 20:
                    str6 = C0185a.m229o(parcel, F);
                    break;
                case 21:
                    str7 = C0185a.m229o(parcel, F);
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
            return new TurnBasedMatchEntity(i, gameEntity, str, str2, j, str3, j2, str4, i2, i3, i4, bArr, arrayList, str5, bArr2, i5, bundle, i6, z, str6, str7);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public TurnBasedMatchEntity[] newArray(int size) {
        return new TurnBasedMatchEntity[size];
    }
}
