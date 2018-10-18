package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

public class GameBadgeEntityCreator implements Creator<GameBadgeEntity> {
    /* renamed from: a */
    static void m949a(GameBadgeEntity gameBadgeEntity, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, gameBadgeEntity.getType());
        C0186b.m268c(parcel, 1000, gameBadgeEntity.getVersionCode());
        C0186b.m256a(parcel, 2, gameBadgeEntity.getTitle(), false);
        C0186b.m256a(parcel, 3, gameBadgeEntity.getDescription(), false);
        C0186b.m252a(parcel, 4, gameBadgeEntity.getIconImageUri(), i, false);
        C0186b.m244H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cv(x0);
    }

    public GameBadgeEntity cv(Parcel parcel) {
        int i = 0;
        Uri uri = null;
        int G = C0185a.m208G(parcel);
        String str = null;
        String str2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    str2 = C0185a.m229o(parcel, F);
                    break;
                case 3:
                    str = C0185a.m229o(parcel, F);
                    break;
                case 4:
                    uri = (Uri) C0185a.m210a(parcel, F, Uri.CREATOR);
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
            return new GameBadgeEntity(i2, i, str2, str, uri);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public GameBadgeEntity[] ed(int i) {
        return new GameBadgeEntity[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ed(x0);
    }
}
