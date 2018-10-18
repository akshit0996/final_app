package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import java.util.List;

/* renamed from: com.google.android.gms.fitness.data.m */
public class C0294m implements Creator<RawBucket> {
    /* renamed from: a */
    static void m551a(RawBucket rawBucket, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m248a(parcel, 1, rawBucket.LW);
        C0186b.m268c(parcel, 1000, rawBucket.CK);
        C0186b.m248a(parcel, 2, rawBucket.TO);
        C0186b.m252a(parcel, 3, rawBucket.TQ, i, false);
        C0186b.m268c(parcel, 4, rawBucket.UI);
        C0186b.m269c(parcel, 5, rawBucket.Ua, false);
        C0186b.m268c(parcel, 6, rawBucket.Ub);
        C0186b.m259a(parcel, 7, rawBucket.Uc);
        C0186b.m244H(parcel, H);
    }

    public RawBucket bz(Parcel parcel) {
        long j = 0;
        List list = null;
        boolean z = false;
        int G = C0185a.m208G(parcel);
        int i = 0;
        int i2 = 0;
        Session session = null;
        long j2 = 0;
        int i3 = 0;
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
                    session = (Session) C0185a.m210a(parcel, F, Session.CREATOR);
                    break;
                case 4:
                    i2 = C0185a.m221g(parcel, F);
                    break;
                case 5:
                    list = C0185a.m216c(parcel, F, RawDataSet.CREATOR);
                    break;
                case 6:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 7:
                    z = C0185a.m217c(parcel, F);
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
            return new RawBucket(i3, j2, j, session, i2, list, i, z);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public RawBucket[] cS(int i) {
        return new RawBucket[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bz(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cS(x0);
    }
}
