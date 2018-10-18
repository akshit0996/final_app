package com.google.android.gms.games.internal.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.games.multiplayer.InvitationEntity;
import java.util.ArrayList;

public class InvitationClusterCreator implements Creator<ZInvitationCluster> {
    /* renamed from: a */
    static void m950a(ZInvitationCluster zInvitationCluster, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m269c(parcel, 1, zInvitationCluster.mq(), false);
        C0186b.m268c(parcel, 1000, zInvitationCluster.getVersionCode());
        C0186b.m244H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cw(x0);
    }

    public ZInvitationCluster cw(Parcel parcel) {
        int G = C0185a.m208G(parcel);
        int i = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    arrayList = C0185a.m216c(parcel, F, InvitationEntity.CREATOR);
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
            return new ZInvitationCluster(i, arrayList);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public ZInvitationCluster[] eg(int i) {
        return new ZInvitationCluster[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return eg(x0);
    }
}
