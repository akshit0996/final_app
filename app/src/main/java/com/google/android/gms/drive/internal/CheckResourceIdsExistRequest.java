package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class CheckResourceIdsExistRequest implements SafeParcelable {
    public static final Creator<CheckResourceIdsExistRequest> CREATOR = new C0208e();
    private final int CK;
    private final List<String> Po;

    CheckResourceIdsExistRequest(int versionCode, List<String> resourceIds) {
        this.CK = versionCode;
        this.Po = resourceIds;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.CK;
    }

    public List<String> iF() {
        return this.Po;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0208e.m381a(this, dest, flags);
    }
}
