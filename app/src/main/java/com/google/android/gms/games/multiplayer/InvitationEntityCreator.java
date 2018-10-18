package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.games.GameEntity;
import java.util.ArrayList;

public class InvitationEntityCreator implements Creator<InvitationEntity> {
    /* renamed from: a */
    static void m956a(InvitationEntity invitationEntity, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m252a(parcel, 1, invitationEntity.getGame(), i, false);
        C0186b.m268c(parcel, 1000, invitationEntity.getVersionCode());
        C0186b.m256a(parcel, 2, invitationEntity.getInvitationId(), false);
        C0186b.m248a(parcel, 3, invitationEntity.getCreationTimestamp());
        C0186b.m268c(parcel, 4, invitationEntity.getInvitationType());
        C0186b.m252a(parcel, 5, invitationEntity.getInviter(), i, false);
        C0186b.m269c(parcel, 6, invitationEntity.getParticipants(), false);
        C0186b.m268c(parcel, 7, invitationEntity.getVariant());
        C0186b.m268c(parcel, 8, invitationEntity.getAvailableAutoMatchSlots());
        C0186b.m244H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cz(x0);
    }

    public InvitationEntity cz(Parcel parcel) {
        ArrayList arrayList = null;
        int i = 0;
        int G = C0185a.m208G(parcel);
        long j = 0;
        int i2 = 0;
        ParticipantEntity participantEntity = null;
        int i3 = 0;
        String str = null;
        GameEntity gameEntity = null;
        int i4 = 0;
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
                    i3 = C0185a.m221g(parcel, F);
                    break;
                case 5:
                    participantEntity = (ParticipantEntity) C0185a.m210a(parcel, F, ParticipantEntity.CREATOR);
                    break;
                case 6:
                    arrayList = C0185a.m216c(parcel, F, ParticipantEntity.CREATOR);
                    break;
                case 7:
                    i2 = C0185a.m221g(parcel, F);
                    break;
                case 8:
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
            return new InvitationEntity(i4, gameEntity, str, j, i3, participantEntity, arrayList, i2, i);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public InvitationEntity[] el(int i) {
        return new InvitationEntity[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return el(x0);
    }
}
