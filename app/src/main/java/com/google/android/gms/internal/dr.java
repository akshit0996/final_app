package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.C0272d.C0871a;
import com.google.android.gms.dynamic.C1332e;

@ey
public final class dr implements SafeParcelable {
    public static final dq CREATOR = new dq();
    public final gs lO;
    public final int orientation;
    public final String rH;
    public final C0934do sb;
    public final C0503t sc;
    public final ds sd;
    public final gu se;
    public final cb sf;
    public final String sg;
    public final boolean sh;
    public final String si;
    public final dv sj;
    public final int sk;
    public final ce sl;
    public final String sm;
    public final C1081y sn;
    public final int versionCode;

    dr(int i, C0934do c0934do, IBinder iBinder, IBinder iBinder2, IBinder iBinder3, IBinder iBinder4, String str, boolean z, String str2, IBinder iBinder5, int i2, int i3, String str3, gs gsVar, IBinder iBinder6, String str4, C1081y c1081y) {
        this.versionCode = i;
        this.sb = c0934do;
        this.sc = (C0503t) C1332e.m4012f(C0871a.ap(iBinder));
        this.sd = (ds) C1332e.m4012f(C0871a.ap(iBinder2));
        this.se = (gu) C1332e.m4012f(C0871a.ap(iBinder3));
        this.sf = (cb) C1332e.m4012f(C0871a.ap(iBinder4));
        this.sg = str;
        this.sh = z;
        this.si = str2;
        this.sj = (dv) C1332e.m4012f(C0871a.ap(iBinder5));
        this.orientation = i2;
        this.sk = i3;
        this.rH = str3;
        this.lO = gsVar;
        this.sl = (ce) C1332e.m4012f(C0871a.ap(iBinder6));
        this.sm = str4;
        this.sn = c1081y;
    }

    public dr(C0934do c0934do, C0503t c0503t, ds dsVar, dv dvVar, gs gsVar) {
        this.versionCode = 4;
        this.sb = c0934do;
        this.sc = c0503t;
        this.sd = dsVar;
        this.se = null;
        this.sf = null;
        this.sg = null;
        this.sh = false;
        this.si = null;
        this.sj = dvVar;
        this.orientation = -1;
        this.sk = 4;
        this.rH = null;
        this.lO = gsVar;
        this.sl = null;
        this.sm = null;
        this.sn = null;
    }

    public dr(C0503t c0503t, ds dsVar, cb cbVar, dv dvVar, gu guVar, boolean z, int i, String str, gs gsVar, ce ceVar) {
        this.versionCode = 4;
        this.sb = null;
        this.sc = c0503t;
        this.sd = dsVar;
        this.se = guVar;
        this.sf = cbVar;
        this.sg = null;
        this.sh = z;
        this.si = null;
        this.sj = dvVar;
        this.orientation = i;
        this.sk = 3;
        this.rH = str;
        this.lO = gsVar;
        this.sl = ceVar;
        this.sm = null;
        this.sn = null;
    }

    public dr(C0503t c0503t, ds dsVar, cb cbVar, dv dvVar, gu guVar, boolean z, int i, String str, String str2, gs gsVar, ce ceVar) {
        this.versionCode = 4;
        this.sb = null;
        this.sc = c0503t;
        this.sd = dsVar;
        this.se = guVar;
        this.sf = cbVar;
        this.sg = str2;
        this.sh = z;
        this.si = str;
        this.sj = dvVar;
        this.orientation = i;
        this.sk = 3;
        this.rH = null;
        this.lO = gsVar;
        this.sl = ceVar;
        this.sm = null;
        this.sn = null;
    }

    public dr(C0503t c0503t, ds dsVar, dv dvVar, gu guVar, int i, gs gsVar, String str, C1081y c1081y) {
        this.versionCode = 4;
        this.sb = null;
        this.sc = c0503t;
        this.sd = dsVar;
        this.se = guVar;
        this.sf = null;
        this.sg = null;
        this.sh = false;
        this.si = null;
        this.sj = dvVar;
        this.orientation = i;
        this.sk = 1;
        this.rH = null;
        this.lO = gsVar;
        this.sl = null;
        this.sm = str;
        this.sn = c1081y;
    }

    public dr(C0503t c0503t, ds dsVar, dv dvVar, gu guVar, boolean z, int i, gs gsVar) {
        this.versionCode = 4;
        this.sb = null;
        this.sc = c0503t;
        this.sd = dsVar;
        this.se = guVar;
        this.sf = null;
        this.sg = null;
        this.sh = z;
        this.si = null;
        this.sj = dvVar;
        this.orientation = i;
        this.sk = 2;
        this.rH = null;
        this.lO = gsVar;
        this.sl = null;
        this.sm = null;
        this.sn = null;
    }

    /* renamed from: a */
    public static void m3110a(Intent intent, dr drVar) {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", drVar);
        intent.putExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", bundle);
    }

    /* renamed from: b */
    public static dr m3111b(Intent intent) {
        try {
            Bundle bundleExtra = intent.getBundleExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
            bundleExtra.setClassLoader(dr.class.getClassLoader());
            return (dr) bundleExtra.getParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
        } catch (Exception e) {
            return null;
        }
    }

    IBinder ck() {
        return C1332e.m4013k(this.sc).asBinder();
    }

    IBinder cl() {
        return C1332e.m4013k(this.sd).asBinder();
    }

    IBinder cm() {
        return C1332e.m4013k(this.se).asBinder();
    }

    IBinder cn() {
        return C1332e.m4013k(this.sf).asBinder();
    }

    IBinder co() {
        return C1332e.m4013k(this.sl).asBinder();
    }

    IBinder cp() {
        return C1332e.m4013k(this.sj).asBinder();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        dq.m1140a(this, out, flags);
    }
}
