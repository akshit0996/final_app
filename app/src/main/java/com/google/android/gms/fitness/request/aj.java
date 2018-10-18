package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.jv;

public class aj implements SafeParcelable {
    public static final Creator<aj> CREATOR = new ak();
    private final int CK;
    private final DataType TM;
    private final DataSource TN;

    /* renamed from: com.google.android.gms.fitness.request.aj$a */
    public static class C0315a {
        private DataType TM;
        private DataSource TN;

        /* renamed from: d */
        public C0315a m623d(DataSource dataSource) {
            this.TN = dataSource;
            return this;
        }

        /* renamed from: d */
        public C0315a m624d(DataType dataType) {
            this.TM = dataType;
            return this;
        }

        public aj kq() {
            if (this.TM == null || this.TN == null) {
                return new aj();
            }
            throw new IllegalArgumentException("Cannot specify both dataType and dataSource");
        }
    }

    aj(int i, DataType dataType, DataSource dataSource) {
        this.CK = i;
        this.TM = dataType;
        this.TN = dataSource;
    }

    private aj(C0315a c0315a) {
        this.CK = 1;
        this.TM = c0315a.TM;
        this.TN = c0315a.TN;
    }

    /* renamed from: a */
    private boolean m2704a(aj ajVar) {
        return jv.equal(this.TN, ajVar.TN) && jv.equal(this.TM, ajVar.TM);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return this == o || ((o instanceof aj) && m2704a((aj) o));
    }

    public DataSource getDataSource() {
        return this.TN;
    }

    public DataType getDataType() {
        return this.TM;
    }

    int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        return jv.hashCode(this.TN, this.TM);
    }

    public void writeToParcel(Parcel parcel, int flags) {
        ak.m625a(this, parcel, flags);
    }
}
