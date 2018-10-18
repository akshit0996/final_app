package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.C0291k;
import com.google.android.gms.fitness.data.C0291k.C0875a;

/* renamed from: com.google.android.gms.fitness.request.q */
public class C0884q implements SafeParcelable {
    public static final Creator<C0884q> CREATOR = new C0330r();
    private final int CK;
    private final C0291k VW;
    private final PendingIntent mPendingIntent;

    C0884q(int i, IBinder iBinder, PendingIntent pendingIntent) {
        this.CK = i;
        this.VW = iBinder == null ? null : C0875a.aq(iBinder);
        this.mPendingIntent = pendingIntent;
    }

    public C0884q(C0291k c0291k, PendingIntent pendingIntent) {
        this.CK = 2;
        this.VW = c0291k;
        this.mPendingIntent = pendingIntent;
    }

    public int describeContents() {
        return 0;
    }

    int getVersionCode() {
        return this.CK;
    }

    public PendingIntent kb() {
        return this.mPendingIntent;
    }

    IBinder kg() {
        return this.VW == null ? null : this.VW.asBinder();
    }

    public String toString() {
        return String.format("SensorUnregistrationRequest{%s}", new Object[]{this.VW});
    }

    public void writeToParcel(Parcel parcel, int flags) {
        C0330r.m639a(this, parcel, flags);
    }
}
