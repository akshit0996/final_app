package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class TextDeletedDetails implements SafeParcelable {
    public static final Creator<TextDeletedDetails> CREATOR = new C0250e();
    final int CK;
    final int Ti;
    final int mIndex;

    TextDeletedDetails(int versionCode, int index, int stringDataIndex) {
        this.CK = versionCode;
        this.mIndex = index;
        this.Ti = stringDataIndex;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0250e.m438a(this, dest, flags);
    }
}
