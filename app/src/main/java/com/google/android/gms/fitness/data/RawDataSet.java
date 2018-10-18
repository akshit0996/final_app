package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import java.util.List;

public final class RawDataSet implements SafeParcelable {
    public static final Creator<RawDataSet> CREATOR = new C0296o();
    final int CK;
    final int UJ;
    final int UL;
    final List<RawDataPoint> UM;
    final boolean Uc;

    RawDataSet(int versionCode, int dataSourceIndex, int dataTypeIndex, List<RawDataPoint> rawDataPoints, boolean serverHasMoreData) {
        this.CK = versionCode;
        this.UJ = dataSourceIndex;
        this.UL = dataTypeIndex;
        this.UM = rawDataPoints;
        this.Uc = serverHasMoreData;
    }

    public RawDataSet(DataSet dataSet, List<DataSource> uniqueDataSources, List<DataType> uniqueDataTypes) {
        this.CK = 2;
        this.UM = dataSet.m2678f(uniqueDataSources);
        this.Uc = dataSet.jn();
        this.UJ = C0300t.m557a(dataSet.getDataSource(), uniqueDataSources);
        this.UL = C0300t.m557a(dataSet.getDataType(), uniqueDataTypes);
    }

    /* renamed from: a */
    private boolean m2691a(RawDataSet rawDataSet) {
        return this.UJ == rawDataSet.UJ && this.UL == rawDataSet.UL && this.Uc == rawDataSet.Uc && jv.equal(this.UM, rawDataSet.UM);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return this == o || ((o instanceof RawDataSet) && m2691a((RawDataSet) o));
    }

    public int hashCode() {
        return jv.hashCode(Integer.valueOf(this.UJ), Integer.valueOf(this.UL));
    }

    public String toString() {
        return String.format("RawDataSet{%s@[%s, %s]}", new Object[]{Integer.valueOf(this.UJ), Integer.valueOf(this.UL), this.UM});
    }

    public void writeToParcel(Parcel parcel, int flags) {
        C0296o.m553a(this, parcel, flags);
    }
}
