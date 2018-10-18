package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.jx;

/* renamed from: com.google.android.gms.drive.i */
public abstract class C0202i implements Parcelable {
    private volatile transient boolean OW = false;

    /* renamed from: I */
    protected abstract void mo969I(Parcel parcel, int i);

    public final boolean iB() {
        return this.OW;
    }

    public void writeToParcel(Parcel dest, int flags) {
        jx.m1574K(!iB());
        this.OW = true;
        mo969I(dest, flags);
    }
}
