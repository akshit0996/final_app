package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

public class ParticipantResultCreator implements Creator<ParticipantResult> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m958a(ParticipantResult participantResult, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m256a(parcel, 1, participantResult.getParticipantId(), false);
        C0186b.m268c(parcel, 1000, participantResult.getVersionCode());
        C0186b.m268c(parcel, 2, participantResult.getResult());
        C0186b.m268c(parcel, 3, participantResult.getPlacing());
        C0186b.m244H(parcel, H);
    }

    public ParticipantResult createFromParcel(Parcel parcel) {
        int i = 0;
        int G = C0185a.m208G(parcel);
        String str = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    str = C0185a.m229o(parcel, F);
                    break;
                case 2:
                    i2 = C0185a.m221g(parcel, F);
                    break;
                case 3:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 1000:
                    i3 = C0185a.m221g(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new ParticipantResult(i3, str, i2, i);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public ParticipantResult[] newArray(int size) {
        return new ParticipantResult[size];
    }
}
