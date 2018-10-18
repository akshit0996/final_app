package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jv.C0483a;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.la;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DataSourcesRequest implements SafeParcelable {
    public static final Creator<DataSourcesRequest> CREATOR = new C0322h();
    private final int CK;
    private final List<DataType> TY;
    private final List<Integer> VS;
    private final boolean VT;

    public static class Builder {
        private boolean VT = false;
        private DataType[] VU = new DataType[0];
        private int[] VV = new int[]{0, 1};

        public DataSourcesRequest build() {
            boolean z = true;
            jx.m1576a(this.VU.length > 0, "Must add at least one data type");
            if (this.VV.length <= 0) {
                z = false;
            }
            jx.m1576a(z, "Must add at least one data source type");
            return new DataSourcesRequest();
        }

        public Builder setDataSourceTypes(int... dataSourceTypes) {
            this.VV = dataSourceTypes;
            return this;
        }

        public Builder setDataTypes(DataType... dataTypes) {
            this.VU = dataTypes;
            return this;
        }
    }

    DataSourcesRequest(int versionCode, List<DataType> dataTypes, List<Integer> dataSourceTypes, boolean includeDbOnlySources) {
        this.CK = versionCode;
        this.TY = dataTypes;
        this.VS = dataSourceTypes;
        this.VT = includeDbOnlySources;
    }

    private DataSourcesRequest(Builder builder) {
        this.CK = 2;
        this.TY = la.m1632b(builder.VU);
        this.VS = Arrays.asList(la.m1631a(builder.VV));
        this.VT = builder.VT;
    }

    public int describeContents() {
        return 0;
    }

    public List<DataType> getDataTypes() {
        return Collections.unmodifiableList(this.TY);
    }

    int getVersionCode() {
        return this.CK;
    }

    public boolean jY() {
        return this.VT;
    }

    List<Integer> jZ() {
        return this.VS;
    }

    public String toString() {
        C0483a a = jv.m1571h(this).m1570a("dataTypes", this.TY).m1570a("sourceTypes", this.VS);
        if (this.VT) {
            a.m1570a("includeDbOnlySources", "true");
        }
        return a.toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        C0322h.m632a(this, parcel, flags);
    }
}
