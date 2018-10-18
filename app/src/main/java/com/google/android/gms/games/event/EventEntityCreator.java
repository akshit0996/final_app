package com.google.android.gms.games.event;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;

public class EventEntityCreator implements Creator<EventEntity> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m678a(EventEntity eventEntity, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m256a(parcel, 1, eventEntity.getEventId(), false);
        C0186b.m268c(parcel, 1000, eventEntity.getVersionCode());
        C0186b.m256a(parcel, 2, eventEntity.getName(), false);
        C0186b.m256a(parcel, 3, eventEntity.getDescription(), false);
        C0186b.m252a(parcel, 4, eventEntity.getIconImageUri(), i, false);
        C0186b.m256a(parcel, 5, eventEntity.getIconImageUrl(), false);
        C0186b.m252a(parcel, 6, eventEntity.getPlayer(), i, false);
        C0186b.m248a(parcel, 7, eventEntity.getValue());
        C0186b.m256a(parcel, 8, eventEntity.getFormattedValue(), false);
        C0186b.m259a(parcel, 9, eventEntity.isVisible());
        C0186b.m244H(parcel, H);
    }

    public EventEntity createFromParcel(Parcel parcel) {
        boolean z = false;
        String str = null;
        int G = C0185a.m208G(parcel);
        long j = 0;
        Player player = null;
        String str2 = null;
        Uri uri = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        int i = 0;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    str5 = C0185a.m229o(parcel, F);
                    break;
                case 2:
                    str4 = C0185a.m229o(parcel, F);
                    break;
                case 3:
                    str3 = C0185a.m229o(parcel, F);
                    break;
                case 4:
                    uri = (Uri) C0185a.m210a(parcel, F, Uri.CREATOR);
                    break;
                case 5:
                    str2 = C0185a.m229o(parcel, F);
                    break;
                case 6:
                    player = (PlayerEntity) C0185a.m210a(parcel, F, PlayerEntity.CREATOR);
                    break;
                case 7:
                    j = C0185a.m223i(parcel, F);
                    break;
                case 8:
                    str = C0185a.m229o(parcel, F);
                    break;
                case 9:
                    z = C0185a.m217c(parcel, F);
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
            return new EventEntity(i, str5, str4, str3, uri, str2, player, j, str, z);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public EventEntity[] newArray(int size) {
        return new EventEntity[size];
    }
}
