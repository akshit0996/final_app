package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import java.util.ArrayList;

public class RoomEntityCreator implements Creator<RoomEntity> {
    /* renamed from: a */
    static void m959a(RoomEntity roomEntity, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m256a(parcel, 1, roomEntity.getRoomId(), false);
        C0186b.m268c(parcel, 1000, roomEntity.getVersionCode());
        C0186b.m256a(parcel, 2, roomEntity.getCreatorId(), false);
        C0186b.m248a(parcel, 3, roomEntity.getCreationTimestamp());
        C0186b.m268c(parcel, 4, roomEntity.getStatus());
        C0186b.m256a(parcel, 5, roomEntity.getDescription(), false);
        C0186b.m268c(parcel, 6, roomEntity.getVariant());
        C0186b.m249a(parcel, 7, roomEntity.getAutoMatchCriteria(), false);
        C0186b.m269c(parcel, 8, roomEntity.getParticipants(), false);
        C0186b.m268c(parcel, 9, roomEntity.getAutoMatchWaitEstimateSeconds());
        C0186b.m244H(parcel, H);
    }

    public RoomEntity cC(Parcel parcel) {
        int i = 0;
        ArrayList arrayList = null;
        int G = C0185a.m208G(parcel);
        long j = 0;
        Bundle bundle = null;
        int i2 = 0;
        String str = null;
        int i3 = 0;
        String str2 = null;
        String str3 = null;
        int i4 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    str3 = C0185a.m229o(parcel, F);
                    break;
                case 2:
                    str2 = C0185a.m229o(parcel, F);
                    break;
                case 3:
                    j = C0185a.m223i(parcel, F);
                    break;
                case 4:
                    i3 = C0185a.m221g(parcel, F);
                    break;
                case 5:
                    str = C0185a.m229o(parcel, F);
                    break;
                case 6:
                    i2 = C0185a.m221g(parcel, F);
                    break;
                case 7:
                    bundle = C0185a.m231q(parcel, F);
                    break;
                case 8:
                    arrayList = C0185a.m216c(parcel, F, ParticipantEntity.CREATOR);
                    break;
                case 9:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 1000:
                    i4 = C0185a.m221g(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new RoomEntity(i4, str3, str2, j, i3, str, i2, bundle, arrayList, i);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cC(x0);
    }

    public RoomEntity[] eo(int i) {
        return new RoomEntity[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return eo(x0);
    }
}
