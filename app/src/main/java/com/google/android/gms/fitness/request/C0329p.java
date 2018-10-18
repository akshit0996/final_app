package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.location.LocationRequest;
import java.util.List;

/* renamed from: com.google.android.gms.fitness.request.p */
public class C0329p implements Creator<C0883o> {
    /* renamed from: a */
    static void m638a(C0883o c0883o, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m252a(parcel, 1, c0883o.getDataSource(), i, false);
        C0186b.m268c(parcel, 1000, c0883o.getVersionCode());
        C0186b.m252a(parcel, 2, c0883o.getDataType(), i, false);
        C0186b.m250a(parcel, 3, c0883o.kg(), false);
        C0186b.m268c(parcel, 4, c0883o.VX);
        C0186b.m268c(parcel, 5, c0883o.VY);
        C0186b.m248a(parcel, 6, c0883o.jI());
        C0186b.m248a(parcel, 7, c0883o.kd());
        C0186b.m252a(parcel, 8, c0883o.kb(), i, false);
        C0186b.m248a(parcel, 9, c0883o.kc());
        C0186b.m268c(parcel, 10, c0883o.getAccuracyMode());
        C0186b.m269c(parcel, 11, c0883o.ke(), false);
        C0186b.m248a(parcel, 12, c0883o.kf());
        C0186b.m244H(parcel, H);
    }

    public C0883o bQ(Parcel parcel) {
        int G = C0185a.m208G(parcel);
        int i = 0;
        DataSource dataSource = null;
        DataType dataType = null;
        IBinder iBinder = null;
        int i2 = 0;
        int i3 = 0;
        long j = 0;
        long j2 = 0;
        PendingIntent pendingIntent = null;
        long j3 = 0;
        int i4 = 0;
        List list = null;
        long j4 = 0;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    dataSource = (DataSource) C0185a.m210a(parcel, F, DataSource.CREATOR);
                    break;
                case 2:
                    dataType = (DataType) C0185a.m210a(parcel, F, DataType.CREATOR);
                    break;
                case 3:
                    iBinder = C0185a.m230p(parcel, F);
                    break;
                case 4:
                    i2 = C0185a.m221g(parcel, F);
                    break;
                case 5:
                    i3 = C0185a.m221g(parcel, F);
                    break;
                case 6:
                    j = C0185a.m223i(parcel, F);
                    break;
                case 7:
                    j2 = C0185a.m223i(parcel, F);
                    break;
                case 8:
                    pendingIntent = (PendingIntent) C0185a.m210a(parcel, F, PendingIntent.CREATOR);
                    break;
                case 9:
                    j3 = C0185a.m223i(parcel, F);
                    break;
                case 10:
                    i4 = C0185a.m221g(parcel, F);
                    break;
                case 11:
                    list = C0185a.m216c(parcel, F, LocationRequest.CREATOR);
                    break;
                case 12:
                    j4 = C0185a.m223i(parcel, F);
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
            return new C0883o(i, dataSource, dataType, iBinder, i2, i3, j, j2, pendingIntent, j3, i4, list, j4);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bQ(x0);
    }

    public C0883o[] dk(int i) {
        return new C0883o[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dk(x0);
    }
}
