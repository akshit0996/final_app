package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;

/* renamed from: com.google.android.gms.fitness.request.e */
public class C0878e implements SafeParcelable {
    public static final Creator<C0878e> CREATOR = new C0320f();
    private final int CK;
    private final DataSet UP;

    /* renamed from: com.google.android.gms.fitness.request.e$a */
    public static class C0319a {
        private DataSet UP;

        /* renamed from: b */
        public C0319a m629b(DataSet dataSet) {
            this.UP = dataSet;
            return this;
        }

        public C0878e jU() {
            boolean z = true;
            jx.m1576a(this.UP != null, "Must set the data set");
            jx.m1576a(!this.UP.getDataPoints().isEmpty(), "Cannot use an empty data set");
            if (this.UP.getDataSource().jx() == null) {
                z = false;
            }
            jx.m1576a(z, "Must set the app package name for the data source");
            return new C0878e();
        }
    }

    C0878e(int i, DataSet dataSet) {
        this.CK = i;
        this.UP = dataSet;
    }

    private C0878e(C0319a c0319a) {
        this.CK = 1;
        this.UP = c0319a.UP;
    }

    /* renamed from: a */
    private boolean m2705a(C0878e c0878e) {
        return jv.equal(this.UP, c0878e.UP);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return o == this || ((o instanceof C0878e) && m2705a((C0878e) o));
    }

    int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        return jv.hashCode(this.UP);
    }

    public DataSet jH() {
        return this.UP;
    }

    public String toString() {
        return jv.m1571h(this).m1570a("dataSet", this.UP).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0320f.m630a(this, dest, flags);
    }
}
