package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ValueChangedDetails implements SafeParcelable {
    public static final Creator<ValueChangedDetails> CREATOR = new C0252g();
    final int CK;
    final int Tj;

    ValueChangedDetails(int versionCode, int keyIndex) {
        this.CK = versionCode;
        this.Tj = keyIndex;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0252g.m440a(this, dest, flags);
    }
}
