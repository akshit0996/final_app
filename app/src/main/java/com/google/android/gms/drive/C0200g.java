package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;

/* renamed from: com.google.android.gms.drive.g */
public class C0200g implements Creator<StorageStats> {
    /* renamed from: a */
    static void m294a(StorageStats storageStats, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, storageStats.CK);
        C0186b.m248a(parcel, 2, storageStats.OM);
        C0186b.m248a(parcel, 3, storageStats.ON);
        C0186b.m248a(parcel, 4, storageStats.OO);
        C0186b.m248a(parcel, 5, storageStats.OP);
        C0186b.m268c(parcel, 6, storageStats.OQ);
        C0186b.m244H(parcel, H);
    }

    /* renamed from: V */
    public StorageStats m295V(Parcel parcel) {
        int i = 0;
        long j = 0;
        int G = C0185a.m208G(parcel);
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        int i2 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i2 = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    j4 = C0185a.m223i(parcel, F);
                    break;
                case 3:
                    j3 = C0185a.m223i(parcel, F);
                    break;
                case 4:
                    j2 = C0185a.m223i(parcel, F);
                    break;
                case 5:
                    j = C0185a.m223i(parcel, F);
                    break;
                case 6:
                    i = C0185a.m221g(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new StorageStats(i2, j4, j3, j2, j, i);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public StorageStats[] bd(int i) {
        return new StorageStats[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m295V(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bd(x0);
    }
}
