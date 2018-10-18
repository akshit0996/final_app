package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

public class MostRecentGameInfoEntityCreator implements Creator<MostRecentGameInfoEntity> {
    /* renamed from: a */
    static void m951a(MostRecentGameInfoEntity mostRecentGameInfoEntity, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m256a(parcel, 1, mostRecentGameInfoEntity.mw(), false);
        C0186b.m268c(parcel, 1000, mostRecentGameInfoEntity.getVersionCode());
        C0186b.m256a(parcel, 2, mostRecentGameInfoEntity.mx(), false);
        C0186b.m248a(parcel, 3, mostRecentGameInfoEntity.my());
        C0186b.m252a(parcel, 4, mostRecentGameInfoEntity.mz(), i, false);
        C0186b.m252a(parcel, 5, mostRecentGameInfoEntity.mA(), i, false);
        C0186b.m252a(parcel, 6, mostRecentGameInfoEntity.mB(), i, false);
        C0186b.m244H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cx(x0);
    }

    public MostRecentGameInfoEntity cx(Parcel parcel) {
        Uri uri = null;
        int G = C0185a.m208G(parcel);
        int i = 0;
        long j = 0;
        Uri uri2 = null;
        Uri uri3 = null;
        String str = null;
        String str2 = null;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    str2 = C0185a.m229o(parcel, F);
                    break;
                case 2:
                    str = C0185a.m229o(parcel, F);
                    break;
                case 3:
                    j = C0185a.m223i(parcel, F);
                    break;
                case 4:
                    uri3 = (Uri) C0185a.m210a(parcel, F, Uri.CREATOR);
                    break;
                case 5:
                    uri2 = (Uri) C0185a.m210a(parcel, F, Uri.CREATOR);
                    break;
                case 6:
                    uri = (Uri) C0185a.m210a(parcel, F, Uri.CREATOR);
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
            return new MostRecentGameInfoEntity(i, str2, str, j, uri3, uri2, uri);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public MostRecentGameInfoEntity[] ei(int i) {
        return new MostRecentGameInfoEntity[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ei(x0);
    }
}
