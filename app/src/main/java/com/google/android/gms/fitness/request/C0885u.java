package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;

/* renamed from: com.google.android.gms.fitness.request.u */
public class C0885u implements SafeParcelable {
    public static final Creator<C0885u> CREATOR = new C0333v();
    private final int CK;
    private final PendingIntent mPendingIntent;

    C0885u(int i, PendingIntent pendingIntent) {
        this.CK = i;
        this.mPendingIntent = pendingIntent;
    }

    public C0885u(PendingIntent pendingIntent) {
        this.CK = 3;
        this.mPendingIntent = pendingIntent;
    }

    /* renamed from: a */
    private boolean m2708a(C0885u c0885u) {
        return jv.equal(this.mPendingIntent, c0885u.mPendingIntent);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof C0885u) && m2708a((C0885u) that));
    }

    int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        return jv.hashCode(this.mPendingIntent);
    }

    public PendingIntent kb() {
        return this.mPendingIntent;
    }

    public String toString() {
        return jv.m1571h(this).m1570a("pendingIntent", this.mPendingIntent).toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        C0333v.m643a(this, parcel, flags);
    }
}
