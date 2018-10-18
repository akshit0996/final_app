package com.google.android.gms.games.quest;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

public class MilestoneEntityCreator implements Creator<MilestoneEntity> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m962a(MilestoneEntity milestoneEntity, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m256a(parcel, 1, milestoneEntity.getMilestoneId(), false);
        C0186b.m268c(parcel, 1000, milestoneEntity.getVersionCode());
        C0186b.m248a(parcel, 2, milestoneEntity.getCurrentProgress());
        C0186b.m248a(parcel, 3, milestoneEntity.getTargetProgress());
        C0186b.m260a(parcel, 4, milestoneEntity.getCompletionRewardData(), false);
        C0186b.m268c(parcel, 5, milestoneEntity.getState());
        C0186b.m256a(parcel, 6, milestoneEntity.getEventId(), false);
        C0186b.m244H(parcel, H);
    }

    public MilestoneEntity createFromParcel(Parcel parcel) {
        long j = 0;
        int i = 0;
        String str = null;
        int G = C0185a.m208G(parcel);
        byte[] bArr = null;
        long j2 = 0;
        String str2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    str2 = C0185a.m229o(parcel, F);
                    break;
                case 2:
                    j2 = C0185a.m223i(parcel, F);
                    break;
                case 3:
                    j = C0185a.m223i(parcel, F);
                    break;
                case 4:
                    bArr = C0185a.m232r(parcel, F);
                    break;
                case 5:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 6:
                    str = C0185a.m229o(parcel, F);
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
            return new MilestoneEntity(i2, str2, j2, j, bArr, i, str);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public MilestoneEntity[] newArray(int size) {
        return new MilestoneEntity[size];
    }
}
