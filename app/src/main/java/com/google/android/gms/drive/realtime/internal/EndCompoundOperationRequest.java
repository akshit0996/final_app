package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class EndCompoundOperationRequest implements SafeParcelable {
    public static final Creator<EndCompoundOperationRequest> CREATOR = new C0242b();
    final int CK;

    public EndCompoundOperationRequest() {
        this(1);
    }

    EndCompoundOperationRequest(int versionCode) {
        this.CK = versionCode;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0242b.m427a(this, dest, flags);
    }
}
