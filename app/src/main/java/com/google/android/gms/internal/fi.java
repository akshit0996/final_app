package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0185a;
import com.google.android.gms.common.internal.safeparcel.C0185a.C0184a;
import com.google.android.gms.common.internal.safeparcel.C0186b;
import java.util.List;

public class fi implements Creator<fh> {
    /* renamed from: a */
    static void m1209a(fh fhVar, Parcel parcel, int i) {
        int H = C0186b.m243H(parcel);
        C0186b.m268c(parcel, 1, fhVar.versionCode);
        C0186b.m249a(parcel, 2, fhVar.tK, false);
        C0186b.m252a(parcel, 3, fhVar.tL, i, false);
        C0186b.m252a(parcel, 4, fhVar.lS, i, false);
        C0186b.m256a(parcel, 5, fhVar.lL, false);
        C0186b.m252a(parcel, 6, fhVar.applicationInfo, i, false);
        C0186b.m252a(parcel, 7, fhVar.tM, i, false);
        C0186b.m256a(parcel, 8, fhVar.tN, false);
        C0186b.m256a(parcel, 9, fhVar.tO, false);
        C0186b.m256a(parcel, 10, fhVar.tP, false);
        C0186b.m252a(parcel, 11, fhVar.lO, i, false);
        C0186b.m249a(parcel, 12, fhVar.tQ, false);
        C0186b.m268c(parcel, 13, fhVar.tR);
        C0186b.m267b(parcel, 14, fhVar.mc, false);
        C0186b.m249a(parcel, 15, fhVar.tS, false);
        C0186b.m259a(parcel, 16, fhVar.tT);
        C0186b.m244H(parcel, H);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m1210h(x0);
    }

    /* renamed from: h */
    public fh m1210h(Parcel parcel) {
        int G = C0185a.m208G(parcel);
        int i = 0;
        Bundle bundle = null;
        av avVar = null;
        ay ayVar = null;
        String str = null;
        ApplicationInfo applicationInfo = null;
        PackageInfo packageInfo = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        gs gsVar = null;
        Bundle bundle2 = null;
        int i2 = 0;
        List list = null;
        Bundle bundle3 = null;
        boolean z = false;
        while (parcel.dataPosition() < G) {
            int F = C0185a.m207F(parcel);
            switch (C0185a.aH(F)) {
                case 1:
                    i = C0185a.m221g(parcel, F);
                    break;
                case 2:
                    bundle = C0185a.m231q(parcel, F);
                    break;
                case 3:
                    avVar = (av) C0185a.m210a(parcel, F, av.CREATOR);
                    break;
                case 4:
                    ayVar = (ay) C0185a.m210a(parcel, F, ay.CREATOR);
                    break;
                case 5:
                    str = C0185a.m229o(parcel, F);
                    break;
                case 6:
                    applicationInfo = (ApplicationInfo) C0185a.m210a(parcel, F, ApplicationInfo.CREATOR);
                    break;
                case 7:
                    packageInfo = (PackageInfo) C0185a.m210a(parcel, F, PackageInfo.CREATOR);
                    break;
                case 8:
                    str2 = C0185a.m229o(parcel, F);
                    break;
                case 9:
                    str3 = C0185a.m229o(parcel, F);
                    break;
                case 10:
                    str4 = C0185a.m229o(parcel, F);
                    break;
                case 11:
                    gsVar = (gs) C0185a.m210a(parcel, F, gs.CREATOR);
                    break;
                case 12:
                    bundle2 = C0185a.m231q(parcel, F);
                    break;
                case 13:
                    i2 = C0185a.m221g(parcel, F);
                    break;
                case 14:
                    list = C0185a.m204C(parcel, F);
                    break;
                case 15:
                    bundle3 = C0185a.m231q(parcel, F);
                    break;
                case 16:
                    z = C0185a.m217c(parcel, F);
                    break;
                default:
                    C0185a.m214b(parcel, F);
                    break;
            }
        }
        if (parcel.dataPosition() == G) {
            return new fh(i, bundle, avVar, ayVar, str, applicationInfo, packageInfo, str2, str3, str4, gsVar, bundle2, i2, list, bundle3, z);
        }
        throw new C0184a("Overread allowed size end=" + G, parcel);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m1211q(x0);
    }

    /* renamed from: q */
    public fh[] m1211q(int i) {
        return new fh[i];
    }
}
