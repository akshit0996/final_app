package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

public class PlayerLevelInfoCreator implements Creator<PlayerLevelInfo> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m664a(PlayerLevelInfo playerLevelInfo, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m248a(parcel, 1, playerLevelInfo.getCurrentXpTotal());
        C0186b.m268c(parcel, 1000, playerLevelInfo.getVersionCode());
        C0186b.m248a(parcel, 2, playerLevelInfo.getLastLevelUpTimestamp());
        C0186b.m252a(parcel, 3, playerLevelInfo.getCurrentLevel(), i, false);
        C0186b.m252a(parcel, 4, playerLevelInfo.getNextLevel(), i, false);
        C0186b.m244H(parcel, H);
    }

    public PlayerLevelInfo createFromParcel(Parcel parcel) {
        long j = 0;
        PlayerLevel playerLevel = null;
        int G = C0185a.m208G(parcel);
        int i = 0;
        PlayerLevel playerLevel2 = null;
        long j2 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    j2 = C0185a.m223i(parcel, F);
                    break;
                case 2:
                    j = C0185a.m223i(parcel, F);
                    break;
                case 3:
                    playerLevel2 = (PlayerLevel) C0185a.m210a(parcel, F, PlayerLevel.CREATOR);
                    break;
                case 4:
                    playerLevel = (PlayerLevel) C0185a.m210a(parcel, F, PlayerLevel.CREATOR);
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
            return new PlayerLevelInfo(i, j2, j, playerLevel2, playerLevel);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public PlayerLevelInfo[] newArray(int size) {
        return new PlayerLevelInfo[size];
    }
}
