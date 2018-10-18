package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.C0291k;
import com.google.android.gms.fitness.data.C0291k.C0875a;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.jv;
import com.google.android.gms.location.LocationRequest;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* renamed from: com.google.android.gms.fitness.request.o */
public class C0883o implements SafeParcelable {
    public static final Creator<C0883o> CREATOR = new C0329p();
    private final int CK;
    private final DataType TM;
    private final DataSource TN;
    private final long UQ;
    private final int UR;
    private C0291k VW;
    int VX;
    int VY;
    private final long VZ;
    private final long Wa;
    private final List<LocationRequest> Wb;
    private final long Wc;
    private final List Wd;
    private final PendingIntent mPendingIntent;

    C0883o(int i, DataSource dataSource, DataType dataType, IBinder iBinder, int i2, int i3, long j, long j2, PendingIntent pendingIntent, long j3, int i4, List<LocationRequest> list, long j4) {
        this.CK = i;
        this.TN = dataSource;
        this.TM = dataType;
        this.VW = iBinder == null ? null : C0875a.aq(iBinder);
        if (j == 0) {
            j = (long) i2;
        }
        this.UQ = j;
        this.Wa = j3;
        if (j2 == 0) {
            j2 = (long) i3;
        }
        this.VZ = j2;
        this.Wb = list;
        this.mPendingIntent = pendingIntent;
        this.UR = i4;
        this.Wd = Collections.emptyList();
        this.Wc = j4;
    }

    private C0883o(DataSource dataSource, DataType dataType, C0291k c0291k, PendingIntent pendingIntent, long j, long j2, long j3, int i, List list, List list2, long j4) {
        this.CK = 4;
        this.TN = dataSource;
        this.TM = dataType;
        this.VW = c0291k;
        this.mPendingIntent = pendingIntent;
        this.UQ = j;
        this.Wa = j2;
        this.VZ = j3;
        this.UR = i;
        this.Wb = list;
        this.Wd = list2;
        this.Wc = j4;
    }

    public C0883o(SensorRequest sensorRequest, C0291k c0291k, PendingIntent pendingIntent) {
        C0291k c0291k2 = c0291k;
        PendingIntent pendingIntent2 = pendingIntent;
        this(sensorRequest.getDataSource(), sensorRequest.getDataType(), c0291k2, pendingIntent2, sensorRequest.getSamplingRate(TimeUnit.MICROSECONDS), sensorRequest.getFastestRate(TimeUnit.MICROSECONDS), sensorRequest.getMaxDeliveryLatency(TimeUnit.MICROSECONDS), sensorRequest.getAccuracyMode(), null, Collections.emptyList(), sensorRequest.kh());
    }

    /* renamed from: a */
    private boolean m2707a(C0883o c0883o) {
        return jv.equal(this.TN, c0883o.TN) && jv.equal(this.TM, c0883o.TM) && this.UQ == c0883o.UQ && this.Wa == c0883o.Wa && this.VZ == c0883o.VZ && this.UR == c0883o.UR && jv.equal(this.Wb, c0883o.Wb);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof C0883o) && m2707a((C0883o) that));
    }

    public int getAccuracyMode() {
        return this.UR;
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
        return jv.hashCode(this.TN, this.TM, this.VW, Long.valueOf(this.UQ), Long.valueOf(this.Wa), Long.valueOf(this.VZ), Integer.valueOf(this.UR), this.Wb);
    }

    public long jI() {
        return this.UQ;
    }

    public PendingIntent kb() {
        return this.mPendingIntent;
    }

    public long kc() {
        return this.Wa;
    }

    public long kd() {
        return this.VZ;
    }

    public List<LocationRequest> ke() {
        return this.Wb;
    }

    public long kf() {
        return this.Wc;
    }

    IBinder kg() {
        return this.VW == null ? null : this.VW.asBinder();
    }

    public String toString() {
        return String.format("SensorRegistrationRequest{type %s source %s interval %s fastest %s latency %s}", new Object[]{this.TM, this.TN, Long.valueOf(this.UQ), Long.valueOf(this.Wa), Long.valueOf(this.VZ)});
    }

    public void writeToParcel(Parcel parcel, int flags) {
        C0329p.m638a(this, parcel, flags);
    }
}
