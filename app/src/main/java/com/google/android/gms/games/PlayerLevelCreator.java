package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

public class PlayerLevelCreator implements Creator<PlayerLevel> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m663a(PlayerLevel playerLevel, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, playerLevel.getLevelNumber());
        C0186b.m268c(parcel, 1000, playerLevel.getVersionCode());
        C0186b.m248a(parcel, 2, playerLevel.getMinXp());
        C0186b.m248a(parcel, 3, playerLevel.getMaxXp());
        C0186b.m244H(parcel, H);
    }

    public PlayerLevel createFromParcel(Parcel parcel) {
        long j = 0;
        int i = 0;
        int G = C0185a.m208G(parcel);
        long j2 = 0;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    j2 = C0185a.m223i(parcel, F);
                    break;
                case 3:
                    j = C0185a.m223i(parcel, F);
                    break;
                case 1000:
                    i2 = C0185a.m221g(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new PlayerLevel(i2, i, j2, j);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public PlayerLevel[] newArray(int size) {
        return new PlayerLevel[size];
    }
}
