package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.query.Filter;

public class NotFilter extends AbstractFilter {
    public static final Creator<NotFilter> CREATOR = new C0239k();
    final int CK;
    final FilterHolder Sv;

    NotFilter(int versionCode, FilterHolder toNegate) {
        this.CK = versionCode;
        this.Sv = toNegate;
    }

    public NotFilter(Filter toNegate) {
        this(1, new FilterHolder(toNegate));
    }

    /* renamed from: a */
    public <T> T mo3685a(C0234f<T> c0234f) {
        return c0234f.mo1066j(this.Sv.getFilter().mo3685a(c0234f));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        C0239k.m424a(this, out, flags);
    }
}
