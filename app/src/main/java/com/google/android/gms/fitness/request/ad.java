package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.request.C0325l.C0881a;
import com.google.android.gms.fitness.request.C1335a.C0311a;

public class ad implements SafeParcelable {
    public static final Creator<ad> CREATOR = new ae();
    private final int CK;
    private final C0325l Wm;

    ad(int i, IBinder iBinder) {
        this.CK = i;
        this.Wm = C0881a.aB(iBinder);
    }

    public ad(BleScanCallback bleScanCallback) {
        this.CK = 1;
        this.Wm = C0311a.jP().m612b(bleScanCallback);
    }

    public int describeContents() {
        return 0;
    }

    int getVersionCode() {
        return this.CK;
    }

    public IBinder km() {
        return this.Wm.asBinder();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        ae.m615a(this, parcel, flags);
    }
}
