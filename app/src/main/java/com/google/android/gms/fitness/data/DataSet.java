package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class DataSet implements SafeParcelable {
    public static final Creator<DataSet> CREATOR = new C0286f();
    private final int CK;
    private final DataType TM;
    private final DataSource TN;
    private boolean Uc;
    private final List<DataPoint> Uj;
    private final List<DataSource> Uk;

    DataSet(int versionCode, DataSource dataSource, DataType dataType, List<RawDataPoint> dataPoints, List<DataSource> uniqueDataSources, boolean serverHasMoreData) {
        this.Uc = false;
        this.CK = versionCode;
        this.TN = dataSource;
        this.TM = dataType;
        this.Uc = serverHasMoreData;
        this.Uj = new ArrayList(dataPoints.size());
        if (versionCode < 2) {
            uniqueDataSources = Collections.singletonList(dataSource);
        }
        this.Uk = uniqueDataSources;
        for (RawDataPoint dataPoint : dataPoints) {
            this.Uj.add(new DataPoint(this.Uk, dataPoint));
        }
    }

    private DataSet(DataSource dataSource, DataType dataType) {
        this.Uc = false;
        this.CK = 3;
        this.TN = (DataSource) jx.m1582i(dataSource);
        this.TM = (DataType) jx.m1582i(dataType);
        this.Uj = new ArrayList();
        this.Uk = new ArrayList();
        this.Uk.add(this.TN);
    }

    public DataSet(RawDataSet dataSet, List<DataSource> uniqueDataSources, List<DataType> uniqueDataTypes) {
        this(3, (DataSource) m2675d(uniqueDataSources, dataSet.UJ), (DataType) m2675d(uniqueDataTypes, dataSet.UL), dataSet.UM, uniqueDataSources, dataSet.Uc);
    }

    /* renamed from: a */
    private boolean m2674a(DataSet dataSet) {
        return jv.equal(this.TM, dataSet.TM) && jv.equal(this.TN, dataSet.TN) && jv.equal(this.Uj, dataSet.Uj) && this.Uc == dataSet.Uc;
    }

    public static DataSet create(DataSource dataSource) {
        jx.m1578b((Object) dataSource, (Object) "DataSource should be specified");
        return new DataSet(dataSource, dataSource.getDataType());
    }

    /* renamed from: d */
    private static <T> T m2675d(List<T> list, int i) {
        return (i < 0 || i >= list.size()) ? null : list.get(i);
    }

    /* renamed from: a */
    public void m2676a(Iterable<DataPoint> iterable) {
        for (DataPoint b : iterable) {
            m2677b(b);
        }
    }

    public void add(DataPoint dataPoint) {
        jx.m1581b(dataPoint.getDataSource().getStreamIdentifier().equals(this.TN.getStreamIdentifier()), "Conflicting data sources found %s vs %s", dataPoint.getDataSource(), this.TN);
        jx.m1581b(dataPoint.getDataType().getName().equals(this.TM.getName()), "Conflicting data types found %s vs %s", dataPoint.getDataType(), this.TM);
        jx.m1581b(dataPoint.getTimestamp(TimeUnit.NANOSECONDS) > 0, "Data point does not have the timestamp set: %s", dataPoint);
        jx.m1581b(dataPoint.getStartTime(TimeUnit.NANOSECONDS) <= dataPoint.getEndTime(TimeUnit.NANOSECONDS), "Data point with start time greater than end time found: %s", dataPoint);
        m2677b(dataPoint);
    }

    public void addAll(Iterable<DataPoint> dataPoints) {
        for (DataPoint add : dataPoints) {
            add(add);
        }
    }

    /* renamed from: b */
    public void m2677b(DataPoint dataPoint) {
        this.Uj.add(dataPoint);
        DataSource originalDataSource = dataPoint.getOriginalDataSource();
        if (originalDataSource != null && !this.Uk.contains(originalDataSource)) {
            this.Uk.add(originalDataSource);
        }
    }

    public DataPoint createDataPoint() {
        return DataPoint.create(this.TN);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return o == this || ((o instanceof DataSet) && m2674a((DataSet) o));
    }

    /* renamed from: f */
    List<RawDataPoint> m2678f(List<DataSource> list) {
        List<RawDataPoint> arrayList = new ArrayList(this.Uj.size());
        for (DataPoint rawDataPoint : this.Uj) {
            arrayList.add(new RawDataPoint(rawDataPoint, list));
        }
        return arrayList;
    }

    public List<DataPoint> getDataPoints() {
        return Collections.unmodifiableList(this.Uj);
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
        return jv.hashCode(this.TM, this.TN);
    }

    public boolean jn() {
        return this.Uc;
    }

    List<RawDataPoint> jv() {
        return m2678f(this.Uk);
    }

    List<DataSource> jw() {
        return this.Uk;
    }

    public String toString() {
        List jv = jv();
        String str = "DataSet{%s %s}";
        Object[] objArr = new Object[2];
        objArr[0] = this.TN.toDebugString();
        if (this.Uj.size() >= 10) {
            jv = String.format("%d data points, first 5: %s", new Object[]{Integer.valueOf(this.Uj.size()), jv.subList(0, 5)});
        }
        objArr[1] = jv;
        return String.format(str, objArr);
    }

    public void writeToParcel(Parcel parcel, int flags) {
        C0286f.m542a(this, parcel, flags);
    }
}
