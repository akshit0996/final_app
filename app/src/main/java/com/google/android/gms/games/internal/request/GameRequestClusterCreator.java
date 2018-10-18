package com.google.android.gms.games.internal.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.games.request.GameRequestEntity;
import java.util.ArrayList;

public class GameRequestClusterCreator implements Creator<GameRequestCluster> {
    /* renamed from: a */
    static void m952a(GameRequestCluster gameRequestCluster, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m269c(parcel, 1, gameRequestCluster.mD(), false);
        C0186b.m268c(parcel, 1000, gameRequestCluster.getVersionCode());
        C0186b.m244H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cy(x0);
    }

    public GameRequestCluster cy(Parcel parcel) {
        int G = C0185a.m208G(parcel);
        int i = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    arrayList = C0185a.m216c(parcel, F, GameRequestEntity.CREATOR);
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
            return new GameRequestCluster(i, arrayList);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public GameRequestCluster[] ej(int i) {
        return new GameRequestCluster[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ej(x0);
    }
}
