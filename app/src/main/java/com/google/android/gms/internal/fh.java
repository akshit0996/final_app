package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

@ey
public final class fh implements SafeParcelable {
    public static final fi CREATOR = new fi();
    public final ApplicationInfo applicationInfo;
    public final String lL;
    public final gs lO;
    public final ay lS;
    public final List<String> mc;
    public final Bundle tK;
    public final av tL;
    public final PackageInfo tM;
    public final String tN;
    public final String tO;
    public final String tP;
    public final Bundle tQ;
    public final int tR;
    public final Bundle tS;
    public final boolean tT;
    public final int versionCode;

    @ey
    /* renamed from: com.google.android.gms.internal.fh$a */
    public static final class C0427a {
        public final ApplicationInfo applicationInfo;
        public final String lL;
        public final gs lO;
        public final ay lS;
        public final List<String> mc;
        public final Bundle tK;
        public final av tL;
        public final PackageInfo tM;
        public final String tO;
        public final String tP;
        public final Bundle tQ;
        public final int tR;
        public final Bundle tS;
        public final boolean tT;

        public C0427a(Bundle bundle, av avVar, ay ayVar, String str, ApplicationInfo applicationInfo, PackageInfo packageInfo, String str2, String str3, gs gsVar, Bundle bundle2, List<String> list, Bundle bundle3, boolean z) {
            this.tK = bundle;
            this.tL = avVar;
            this.lS = ayVar;
            this.lL = str;
            this.applicationInfo = applicationInfo;
            this.tM = packageInfo;
            this.tO = str2;
            this.tP = str3;
            this.lO = gsVar;
            this.tQ = bundle2;
            this.tT = z;
            if (list == null || list.size() <= 0) {
                this.tR = 0;
                this.mc = null;
            } else {
                this.tR = 2;
                this.mc = list;
            }
            this.tS = bundle3;
        }
    }

    fh(int i, Bundle bundle, av avVar, ay ayVar, String str, ApplicationInfo applicationInfo, PackageInfo packageInfo, String str2, String str3, String str4, gs gsVar, Bundle bundle2, int i2, List<String> list, Bundle bundle3, boolean z) {
        this.versionCode = i;
        this.tK = bundle;
        this.tL = avVar;
        this.lS = ayVar;
        this.lL = str;
        this.applicationInfo = applicationInfo;
        this.tM = packageInfo;
        this.tN = str2;
        this.tO = str3;
        this.tP = str4;
        this.lO = gsVar;
        this.tQ = bundle2;
        this.tR = i2;
        this.mc = list;
        this.tS = bundle3;
        this.tT = z;
    }

    public fh(Bundle bundle, av avVar, ay ayVar, String str, ApplicationInfo applicationInfo, PackageInfo packageInfo, String str2, String str3, String str4, gs gsVar, Bundle bundle2, int i, List<String> list, Bundle bundle3, boolean z) {
        this(4, bundle, avVar, ayVar, str, applicationInfo, packageInfo, str2, str3, str4, gsVar, bundle2, i, list, bundle3, z);
    }

    public fh(C0427a c0427a, String str) {
        this(c0427a.tK, c0427a.tL, c0427a.lS, c0427a.lL, c0427a.applicationInfo, c0427a.tM, str, c0427a.tO, c0427a.tP, c0427a.lO, c0427a.tQ, c0427a.tR, c0427a.mc, c0427a.tS, c0427a.tT);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        fi.m1209a(this, out, flags);
    }
}
