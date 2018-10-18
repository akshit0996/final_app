package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;

/* renamed from: com.google.android.gms.location.e */
public class C1087e implements SafeParcelable {
    public static final C0521f CREATOR = new C0521f();
    private final int CK;
    int agw;
    int agx;
    long agy;

    public C1087e(int i, int i2, int i3, long j) {
        this.CK = i;
        this.agw = i2;
        this.agx = i3;
        this.agy = j;
    }

    private String eB(int i) {
        switch (i) {
            case 0:
                return "STATUS_SUCCESSFUL";
            case 2:
                return "STATUS_TIMED_OUT_ON_SCAN";
            case 3:
                return "STATUS_NO_INFO_IN_DATABASE";
            case 4:
                return "STATUS_INVALID_SCAN";
            case 5:
                return "STATUS_UNABLE_TO_QUERY_DATABASE";
            case 6:
                return "STATUS_SCANS_DISABLED_IN_SETTINGS";
            case 7:
                return "STATUS_LOCATION_DISABLED_IN_SETTINGS";
            case 8:
                return "STATUS_IN_PROGRESS";
            default:
                return "STATUS_UNKNOWN";
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (!(other instanceof C1087e)) {
            return false;
        }
        C1087e c1087e = (C1087e) other;
        return this.agw == c1087e.agw && this.agx == c1087e.agx && this.agy == c1087e.agy;
    }

    int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        return jv.hashCode(Integer.valueOf(this.agw), Integer.valueOf(this.agx), Long.valueOf(this.agy));
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LocationStatus[cell status: ").append(eB(this.agw));
        stringBuilder.append(", wifi status: ").append(eB(this.agx));
        stringBuilder.append(", elapsed realtime ns: ").append(this.agy);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        C0521f.m1943a(this, parcel, flags);
    }
}
