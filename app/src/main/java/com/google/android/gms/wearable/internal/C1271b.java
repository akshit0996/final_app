package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.ae.C1265a;

/* renamed from: com.google.android.gms.wearable.internal.b */
public class C1271b implements SafeParcelable {
    public static final Creator<C1271b> CREATOR = new C0703c();
    final int CK;
    public final ae axv;
    public final IntentFilter[] axw;

    C1271b(int i, IBinder iBinder, IntentFilter[] intentFilterArr) {
        this.CK = i;
        if (iBinder != null) {
            this.axv = C1265a.bY(iBinder);
        } else {
            this.axv = null;
        }
        this.axw = intentFilterArr;
    }

    public C1271b(bb bbVar) {
        this.CK = 1;
        this.axv = bbVar;
        this.axw = bbVar.rs();
    }

    public int describeContents() {
        return 0;
    }

    IBinder rm() {
        return this.axv == null ? null : this.axv.asBinder();
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0703c.m2327a(this, dest, flags);
    }
}
