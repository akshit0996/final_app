package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.C0272d.C0871a;
import com.google.android.gms.dynamic.C1332e;

@ey
public final class ea implements SafeParcelable {
    public static final dz CREATOR = new dz();
    public final ek md;
    public final Context sA;
    public final ej sB;
    public final em sz;
    public final int versionCode;

    ea(int i, IBinder iBinder, IBinder iBinder2, IBinder iBinder3, IBinder iBinder4) {
        this.versionCode = i;
        this.md = (ek) C1332e.m4012f(C0871a.ap(iBinder));
        this.sz = (em) C1332e.m4012f(C0871a.ap(iBinder2));
        this.sA = (Context) C1332e.m4012f(C0871a.ap(iBinder3));
        this.sB = (ej) C1332e.m4012f(C0871a.ap(iBinder4));
    }

    public ea(Context context, ek ekVar, em emVar, ej ejVar) {
        this.versionCode = 2;
        this.sA = context;
        this.md = ekVar;
        this.sz = emVar;
        this.sB = ejVar;
    }

    /* renamed from: a */
    public static void m3123a(Intent intent, ea eaVar) {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo", eaVar);
        intent.putExtra("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo", bundle);
    }

    /* renamed from: c */
    public static ea m3124c(Intent intent) {
        try {
            Bundle bundleExtra = intent.getBundleExtra("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo");
            bundleExtra.setClassLoader(ea.class.getClassLoader());
            return (ea) bundleExtra.getParcelable("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo");
        } catch (Exception e) {
            return null;
        }
    }

    IBinder ct() {
        return C1332e.m4013k(this.sB).asBinder();
    }

    IBinder cu() {
        return C1332e.m4013k(this.md).asBinder();
    }

    IBinder cv() {
        return C1332e.m4013k(this.sz).asBinder();
    }

    IBinder cw() {
        return C1332e.m4013k(this.sA).asBinder();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        dz.m1154a(this, out, flags);
    }
}
