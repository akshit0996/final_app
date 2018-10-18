package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;

/* renamed from: com.google.android.gms.fitness.request.y */
public class C0887y implements SafeParcelable {
    public static final Creator<C0887y> CREATOR = new C0339z();
    private final int CK;
    private final String UN;
    private final String mName;

    /* renamed from: com.google.android.gms.fitness.request.y$a */
    public static class C0338a {
        private String UN;
        private String mName;

        public C0338a bx(String str) {
            this.mName = str;
            return this;
        }

        public C0338a by(String str) {
            this.UN = str;
            return this;
        }

        public C0887y kl() {
            return new C0887y();
        }
    }

    C0887y(int i, String str, String str2) {
        this.CK = i;
        this.mName = str;
        this.UN = str2;
    }

    private C0887y(C0338a c0338a) {
        this.CK = 1;
        this.mName = c0338a.mName;
        this.UN = c0338a.UN;
    }

    /* renamed from: a */
    private boolean m2710a(C0887y c0887y) {
        return jv.equal(this.mName, c0887y.mName) && jv.equal(this.UN, c0887y.UN);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return o == this || ((o instanceof C0887y) && m2710a((C0887y) o));
    }

    public String getIdentifier() {
        return this.UN;
    }

    public String getName() {
        return this.mName;
    }

    int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        return jv.hashCode(this.mName, this.UN);
    }

    public String toString() {
        return jv.m1571h(this).m1570a("name", this.mName).m1570a("identifier", this.UN).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0339z.m649a(this, dest, flags);
    }
}
