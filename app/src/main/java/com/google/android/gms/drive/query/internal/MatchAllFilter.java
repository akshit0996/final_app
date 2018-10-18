package com.google.android.gms.drive.query.internal;

import android.os.Parcel;

public class MatchAllFilter extends AbstractFilter {
    public static final C0238j CREATOR = new C0238j();
    final int CK;

    public MatchAllFilter() {
        this(1);
    }

    MatchAllFilter(int versionCode) {
        this.CK = versionCode;
    }

    /* renamed from: a */
    public <F> F mo3685a(C0234f<F> c0234f) {
        return c0234f.jd();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        C0238j.m423a(this, out, flags);
    }
}
