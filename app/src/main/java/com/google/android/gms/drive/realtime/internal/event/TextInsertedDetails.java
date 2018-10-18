package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class TextInsertedDetails implements SafeParcelable {
    public static final Creator<TextInsertedDetails> CREATOR = new C0251f();
    final int CK;
    final int Ti;
    final int mIndex;

    TextInsertedDetails(int versionCode, int index, int stringDataIndex) {
        this.CK = versionCode;
        this.mIndex = index;
        this.Ti = stringDataIndex;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0251f.m439a(this, dest, flags);
    }
}
