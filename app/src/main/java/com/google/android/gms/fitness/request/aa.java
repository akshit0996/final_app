package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;

public class aa implements SafeParcelable {
    public static final Creator<aa> CREATOR = new ab();
    private final int CK;
    private final PendingIntent mPendingIntent;

    aa(int i, PendingIntent pendingIntent) {
        this.CK = i;
        this.mPendingIntent = pendingIntent;
    }

    public aa(PendingIntent pendingIntent) {
        this.CK = 3;
        this.mPendingIntent = pendingIntent;
    }

    /* renamed from: a */
    private boolean m2703a(aa aaVar) {
        return jv.equal(this.mPendingIntent, aaVar.mPendingIntent);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof aa) && m2703a((aa) that));
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
        ab.m613a(this, parcel, flags);
    }
}
