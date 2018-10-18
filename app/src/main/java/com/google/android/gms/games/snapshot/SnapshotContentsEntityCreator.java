package com.google.android.gms.games.snapshot;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.drive.Contents;

public class SnapshotContentsEntityCreator implements Creator<SnapshotContentsEntity> {
    /* renamed from: a */
    static void m965a(SnapshotContentsEntity snapshotContentsEntity, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m252a(parcel, 1, snapshotContentsEntity.ir(), i, false);
        C0186b.m268c(parcel, 1000, snapshotContentsEntity.getVersionCode());
        C0186b.m244H(parcel, H);
    }

    public SnapshotContentsEntity cD(Parcel parcel) {
        int G = C0185a.m208G(parcel);
        int i = 0;
        Contents contents = null;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    contents = (Contents) C0185a.m210a(parcel, F, Contents.CREATOR);
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
            return new SnapshotContentsEntity(i, contents);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cD(x0);
    }

    public SnapshotContentsEntity[] eq(int i) {
        return new SnapshotContentsEntity[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return eq(x0);
    }
}
