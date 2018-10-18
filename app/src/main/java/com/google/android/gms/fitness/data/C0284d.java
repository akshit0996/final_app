package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import java.util.List;

/* renamed from: com.google.android.gms.fitness.data.d */
public class C0284d implements Creator<Bucket> {
    /* renamed from: a */
    static void m540a(Bucket bucket, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m248a(parcel, 1, bucket.jo());
        C0186b.m268c(parcel, 1000, bucket.getVersionCode());
        C0186b.m248a(parcel, 2, bucket.jp());
        C0186b.m252a(parcel, 3, bucket.getSession(), i, false);
        C0186b.m268c(parcel, 4, bucket.jm());
        C0186b.m269c(parcel, 5, bucket.getDataSets(), false);
        C0186b.m268c(parcel, 6, bucket.getBucketType());
        C0186b.m259a(parcel, 7, bucket.jn());
        C0186b.m244H(parcel, H);
    }

    public Bucket bs(Parcel parcel) {
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
                    list = C0185a.m216c(parcel, F, DataSet.CREATOR);
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
            return new Bucket(i3, j2, j, session, i2, list, i, z);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public Bucket[] cK(int i) {
        return new Bucket[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bs(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cK(x0);
    }
}
