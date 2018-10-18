package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DataDeleteRequest implements SafeParcelable {
    public static final Creator<DataDeleteRequest> CREATOR = new C0317d();
    private final int CK;
    private final long LW;
    private final long TO;
    private final List<DataType> TY;
    private final List<DataSource> VH;
    private final List<Session> VI;
    private final boolean VJ;
    private final boolean VK;

    public static class Builder {
        private long LW;
        private long TO;
        private List<DataType> TY = new ArrayList();
        private List<DataSource> VH = new ArrayList();
        private List<Session> VI = new ArrayList();
        private boolean VJ = false;
        private boolean VK = false;

        private void jT() {
            if (!this.VI.isEmpty()) {
                for (Session session : this.VI) {
                    boolean z = session.getStartTime(TimeUnit.MILLISECONDS) >= this.LW && session.getEndTime(TimeUnit.MILLISECONDS) <= this.TO;
                    jx.m1577a(z, "Session %s is outside the time interval [%d, %d]", session, Long.valueOf(this.LW), Long.valueOf(this.TO));
                }
            }
        }

        public Builder addDataSource(DataSource dataSource) {
            boolean z = true;
            jx.m1580b(!this.VJ, (Object) "All data is already marked for deletion");
            if (dataSource == null) {
                z = false;
            }
            jx.m1580b(z, (Object) "Must specify a valid data source");
            if (!this.VH.contains(dataSource)) {
                this.VH.add(dataSource);
            }
            return this;
        }

        public Builder addDataType(DataType dataType) {
            boolean z = true;
            jx.m1580b(!this.VJ, (Object) "All data is already marked for deletion");
            if (dataType == null) {
                z = false;
            }
            jx.m1580b(z, (Object) "Must specify a valid data type");
            if (!this.TY.contains(dataType)) {
                this.TY.add(dataType);
            }
            return this;
        }

        public Builder addSession(Session session) {
            boolean z = true;
            jx.m1580b(!this.VK, (Object) "All sessions already marked for deletion");
            jx.m1580b(session != null, (Object) "Must specify a valid session");
            if (session.getEndTime(TimeUnit.MILLISECONDS) <= 0) {
                z = false;
            }
            jx.m1580b(z, (Object) "Must specify a session that has already ended");
            this.VI.add(session);
            return this;
        }

        public DataDeleteRequest build() {
            boolean z = false;
            boolean z2 = this.LW > 0 && this.TO > this.LW;
            jx.m1576a(z2, "Must specify a valid time interval");
            z2 = (!this.VJ && this.VH.isEmpty() && this.TY.isEmpty()) ? false : true;
            boolean z3 = this.VK || !this.VI.isEmpty();
            if (z2 || z3) {
                z = true;
            }
            jx.m1576a(z, "No data or session marked for deletion");
            jT();
            return new DataDeleteRequest();
        }

        public Builder deleteAllData() {
            boolean z = this.TY.isEmpty() && this.VH.isEmpty();
            jx.m1581b(z, "Specific data source/type already specified for deletion. DataSources: %s DataTypes: %s", this.VH, this.TY);
            this.VJ = true;
            return this;
        }

        public Builder deleteAllSessions() {
            jx.m1581b(this.VI.isEmpty(), "Specific sessions already added for deletion: %s", this.VI);
            this.VK = true;
            return this;
        }

        public Builder setTimeInterval(long startTime, long endTime, TimeUnit timeUnit) {
            jx.m1581b(startTime > 0, "Invalid start time :%d", Long.valueOf(startTime));
            jx.m1581b(endTime > startTime, "Invalid end time :%d", Long.valueOf(endTime));
            this.LW = timeUnit.toMillis(startTime);
            this.TO = timeUnit.toMillis(endTime);
            return this;
        }
    }

    DataDeleteRequest(int versionCode, long startTimeMillis, long endTimeMillis, List<DataSource> dataSources, List<DataType> dataTypes, List<Session> sessions, boolean deleteAllData, boolean deleteAllSessions) {
        this.CK = versionCode;
        this.LW = startTimeMillis;
        this.TO = endTimeMillis;
        this.VH = Collections.unmodifiableList(dataSources);
        this.TY = Collections.unmodifiableList(dataTypes);
        this.VI = sessions;
        this.VJ = deleteAllData;
        this.VK = deleteAllSessions;
    }

    private DataDeleteRequest(Builder builder) {
        this.CK = 1;
        this.LW = builder.LW;
        this.TO = builder.TO;
        this.VH = Collections.unmodifiableList(builder.VH);
        this.TY = Collections.unmodifiableList(builder.TY);
        this.VI = Collections.unmodifiableList(builder.VI);
        this.VJ = builder.VJ;
        this.VK = builder.VK;
    }

    /* renamed from: a */
    private boolean m2698a(DataDeleteRequest dataDeleteRequest) {
        return this.LW == dataDeleteRequest.LW && this.TO == dataDeleteRequest.TO && jv.equal(this.VH, dataDeleteRequest.VH) && jv.equal(this.TY, dataDeleteRequest.TY) && jv.equal(this.VI, dataDeleteRequest.VI) && this.VJ == dataDeleteRequest.VJ && this.VK == dataDeleteRequest.VK;
    }

    public boolean deleteAllData() {
        return this.VJ;
    }

    public boolean deleteAllSessions() {
        return this.VK;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return o == this || ((o instanceof DataDeleteRequest) && m2698a((DataDeleteRequest) o));
    }

    public List<DataSource> getDataSources() {
        return this.VH;
    }

    public List<DataType> getDataTypes() {
        return this.TY;
    }

    public long getEndTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.TO, TimeUnit.MILLISECONDS);
    }

    public List<Session> getSessions() {
        return this.VI;
    }

    public long getStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.LW, TimeUnit.MILLISECONDS);
    }

    int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        return jv.hashCode(Long.valueOf(this.LW), Long.valueOf(this.TO));
    }

    public boolean jR() {
        return this.VJ;
    }

    public boolean jS() {
        return this.VK;
    }

    public long jo() {
        return this.LW;
    }

    public long jp() {
        return this.TO;
    }

    public String toString() {
        return jv.m1571h(this).m1570a("startTimeMillis", Long.valueOf(this.LW)).m1570a("endTimeMillis", Long.valueOf(this.TO)).m1570a("dataSources", this.VH).m1570a("dateTypes", this.TY).m1570a("sessions", this.VI).m1570a("deleteAllData", Boolean.valueOf(this.VJ)).m1570a("deleteAllSessions", Boolean.valueOf(this.VK)).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0317d.m627a(this, dest, flags);
    }
}
