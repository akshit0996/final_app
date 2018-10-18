package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;

/* renamed from: com.google.android.gms.fitness.request.j */
public class C0879j implements SafeParcelable {
    public static final Creator<C0879j> CREATOR = new C0324k();
    private final int CK;
    private final String mName;

    C0879j(int i, String str) {
        this.CK = i;
        this.mName = str;
    }

    public C0879j(String str) {
        this.CK = 1;
        this.mName = str;
    }

    /* renamed from: a */
    private boolean m2706a(C0879j c0879j) {
        return jv.equal(this.mName, c0879j.mName);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return o == this || ((o instanceof C0879j) && m2706a((C0879j) o));
    }

    public String getName() {
        return this.mName;
    }

    int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        return jv.hashCode(this.mName);
    }

    public String toString() {
        return jv.m1571h(this).m1570a("name", this.mName).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0324k.m634a(this, dest, flags);
    }
}
