package com.google.android.gms.internal;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import java.util.List;

public class aw implements Creator<av> {
    /* renamed from: a */
    static void m1036a(av avVar, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, avVar.versionCode);
        C0186b.m248a(parcel, 2, avVar.od);
        C0186b.m249a(parcel, 3, avVar.extras, false);
        C0186b.m268c(parcel, 4, avVar.oe);
        C0186b.m267b(parcel, 5, avVar.of, false);
        C0186b.m259a(parcel, 6, avVar.og);
        C0186b.m268c(parcel, 7, avVar.oh);
        C0186b.m259a(parcel, 8, avVar.oi);
        C0186b.m256a(parcel, 9, avVar.oj, false);
        C0186b.m252a(parcel, 10, avVar.ok, i, false);
        C0186b.m252a(parcel, 11, avVar.ol, i, false);
        C0186b.m256a(parcel, 12, avVar.om, false);
        C0186b.m249a(parcel, 13, avVar.on, false);
        C0186b.m244H(parcel, H);
    }

    /* renamed from: b */
    public av m1037b(Parcel parcel) {
        int G = C0185a.m208G(parcel);
        int i = 0;
        long j = 0;
        Bundle bundle = null;
        int i2 = 0;
        List list = null;
        boolean z = false;
        int i3 = 0;
        boolean z2 = false;
        String str = null;
        bj bjVar = null;
        Location location = null;
        String str2 = null;
        Bundle bundle2 = null;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    j = C0185a.m223i(parcel, F);
                    break;
                case 3:
                    bundle = C0185a.m231q(parcel, F);
                    break;
                case 4:
                    i2 = C0185a.m221g(parcel, F);
                    break;
                case 5:
                    list = C0185a.m204C(parcel, F);
                    break;
                case 6:
                    z = C0185a.m217c(parcel, F);
                    break;
                case 7:
                    i3 = C0185a.m221g(parcel, F);
                    break;
                case 8:
                    z2 = C0185a.m217c(parcel, F);
                    break;
                case 9:
                    str = C0185a.m229o(parcel, F);
                    break;
                case 10:
                    bjVar = (bj) C0185a.m210a(parcel, F, bj.CREATOR);
                    break;
                case 11:
                    location = (Location) C0185a.m210a(parcel, F, Location.CREATOR);
                    break;
                case 12:
                    str2 = C0185a.m229o(parcel, F);
                    break;
                case 13:
                    bundle2 = C0185a.m231q(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new av(i, j, bundle, i2, list, z, i3, z2, str, bjVar, location, str2, bundle2);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m1037b(x0);
    }

    /* renamed from: f */
    public av[] m1038f(int i) {
        return new av[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m1038f(x0);
    }
}
