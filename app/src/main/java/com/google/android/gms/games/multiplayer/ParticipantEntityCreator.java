package com.google.android.gms.games.multiplayer;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.games.PlayerEntity;

public class ParticipantEntityCreator implements Creator<ParticipantEntity> {
    /* renamed from: a */
    static void m957a(ParticipantEntity participantEntity, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m256a(parcel, 1, participantEntity.getParticipantId(), false);
        C0186b.m268c(parcel, 1000, participantEntity.getVersionCode());
        C0186b.m256a(parcel, 2, participantEntity.getDisplayName(), false);
        C0186b.m252a(parcel, 3, participantEntity.getIconImageUri(), i, false);
        C0186b.m252a(parcel, 4, participantEntity.getHiResImageUri(), i, false);
        C0186b.m268c(parcel, 5, participantEntity.getStatus());
        C0186b.m256a(parcel, 6, participantEntity.le(), false);
        C0186b.m259a(parcel, 7, participantEntity.isConnectedToRoom());
        C0186b.m252a(parcel, 8, participantEntity.getPlayer(), i, false);
        C0186b.m268c(parcel, 9, participantEntity.getCapabilities());
        C0186b.m252a(parcel, 10, participantEntity.getResult(), i, false);
        C0186b.m256a(parcel, 11, participantEntity.getIconImageUrl(), false);
        C0186b.m256a(parcel, 12, participantEntity.getHiResImageUrl(), false);
        C0186b.m244H(parcel, H);
    }

    public ParticipantEntity cA(Parcel parcel) {
        int G = C0185a.m208G(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        Uri uri = null;
        Uri uri2 = null;
        int i2 = 0;
        String str3 = null;
        boolean z = false;
        PlayerEntity playerEntity = null;
        int i3 = 0;
        ParticipantResult participantResult = null;
        String str4 = null;
        String str5 = null;
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
                    i2 = C0185a.m221g(parcel, F);
                    break;
                case 6:
                    str3 = C0185a.m229o(parcel, F);
                    break;
                case 7:
                    z = C0185a.m217c(parcel, F);
                    break;
                case 8:
                    playerEntity = (PlayerEntity) C0185a.m210a(parcel, F, PlayerEntity.CREATOR);
                    break;
                case 9:
                    i3 = C0185a.m221g(parcel, F);
                    break;
                case 10:
                    participantResult = (ParticipantResult) C0185a.m210a(parcel, F, ParticipantResult.CREATOR);
                    break;
                case 11:
                    str4 = C0185a.m229o(parcel, F);
                    break;
                case 12:
                    str5 = C0185a.m229o(parcel, F);
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
            return new ParticipantEntity(i, str, str2, uri, uri2, i2, str3, z, playerEntity, i3, participantResult, str4, str5);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cA(x0);
    }

    public ParticipantEntity[] em(int i) {
        return new ParticipantEntity[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return em(x0);
    }
}
