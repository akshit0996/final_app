package com.google.android.gms.games.request;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.PlayerEntity;
import java.util.ArrayList;

public class GameRequestEntityCreator implements Creator<GameRequestEntity> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m964a(GameRequestEntity gameRequestEntity, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m252a(parcel, 1, gameRequestEntity.getGame(), i, false);
        C0186b.m268c(parcel, 1000, gameRequestEntity.getVersionCode());
        C0186b.m252a(parcel, 2, gameRequestEntity.getSender(), i, false);
        C0186b.m260a(parcel, 3, gameRequestEntity.getData(), false);
        C0186b.m256a(parcel, 4, gameRequestEntity.getRequestId(), false);
        C0186b.m269c(parcel, 5, gameRequestEntity.getRecipients(), false);
        C0186b.m268c(parcel, 7, gameRequestEntity.getType());
        C0186b.m248a(parcel, 9, gameRequestEntity.getCreationTimestamp());
        C0186b.m248a(parcel, 10, gameRequestEntity.getExpirationTimestamp());
        C0186b.m249a(parcel, 11, gameRequestEntity.mS(), false);
        C0186b.m268c(parcel, 12, gameRequestEntity.getStatus());
        C0186b.m244H(parcel, H);
    }

    public GameRequestEntity createFromParcel(Parcel parcel) {
        int G = C0185a.m208G(parcel);
        int i = 0;
        GameEntity gameEntity = null;
        PlayerEntity playerEntity = null;
        byte[] bArr = null;
        String str = null;
        ArrayList arrayList = null;
        int i2 = 0;
        long j = 0;
        long j2 = 0;
        Bundle bundle = null;
        int i3 = 0;
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
                    bArr = C0185a.m232r(parcel, F);
                    break;
                case 4:
                    str = C0185a.m229o(parcel, F);
                    break;
                case 5:
                    arrayList = C0185a.m216c(parcel, F, PlayerEntity.CREATOR);
                    break;
                case 7:
                    i2 = C0185a.m221g(parcel, F);
                    break;
                case 9:
                    j = C0185a.m223i(parcel, F);
                    break;
                case 10:
                    j2 = C0185a.m223i(parcel, F);
                    break;
                case 11:
                    bundle = C0185a.m231q(parcel, F);
                    break;
                case 12:
                    i3 = C0185a.m221g(parcel, F);
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
            return new GameRequestEntity(i, gameEntity, playerEntity, bArr, str, arrayList, i2, j, j2, bundle, i3);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public GameRequestEntity[] newArray(int size) {
        return new GameRequestEntity[size];
    }
}
