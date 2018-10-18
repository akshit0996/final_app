package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Comparator;

public class DetectedActivity implements SafeParcelable {
    public static final DetectedActivityCreator CREATOR = new DetectedActivityCreator();
    public static final int IN_VEHICLE = 0;
    public static final int ON_BICYCLE = 1;
    public static final int ON_FOOT = 2;
    public static final int RUNNING = 8;
    public static final int STILL = 3;
    public static final int TILTING = 5;
    public static final int UNKNOWN = 4;
    public static final int WALKING = 7;
    public static final Comparator<DetectedActivity> aga = new C05141();
    private final int CK;
    int agb;
    int agc;

    /* renamed from: com.google.android.gms.location.DetectedActivity$1 */
    static class C05141 implements Comparator<DetectedActivity> {
        C05141() {
        }

        /* renamed from: a */
        public int m1933a(DetectedActivity detectedActivity, DetectedActivity detectedActivity2) {
            int compareTo = Integer.valueOf(detectedActivity2.getConfidence()).compareTo(Integer.valueOf(detectedActivity.getConfidence()));
            return compareTo == 0 ? Integer.valueOf(detectedActivity.getType()).compareTo(Integer.valueOf(detectedActivity2.getType())) : compareTo;
        }

        public /* synthetic */ int compare(Object x0, Object x1) {
            return m1933a((DetectedActivity) x0, (DetectedActivity) x1);
        }
    }

    public DetectedActivity(int activityType, int confidence) {
        this.CK = 1;
        this.agb = activityType;
        this.agc = confidence;
    }

    public DetectedActivity(int versionCode, int activityType, int confidence) {
        this.CK = versionCode;
        this.agb = activityType;
        this.agc = confidence;
    }

    private int ev(int i) {
        return i > 9 ? 4 : i;
    }

    public int describeContents() {
        return 0;
    }

    public int getConfidence() {
        return this.agc;
    }

    public int getType() {
        return ev(this.agb);
    }

    public int getVersionCode() {
        return this.CK;
    }

    public String toString() {
        return "DetectedActivity [type=" + getType() + ", confidence=" + this.agc + "]";
    }

    public void writeToParcel(Parcel out, int flags) {
        DetectedActivityCreator.m1934a(this, out, flags);
    }
}
