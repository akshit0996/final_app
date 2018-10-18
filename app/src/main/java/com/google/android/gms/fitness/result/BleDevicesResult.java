package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.jv;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BleDevicesResult implements Result, SafeParcelable {
    public static final Creator<BleDevicesResult> CREATOR = new C0340a();
    private final int CK;
    private final Status Eb;
    private final List<BleDevice> Wq;

    BleDevicesResult(int versionCode, List<BleDevice> bleDevices, Status status) {
        this.CK = versionCode;
        this.Wq = Collections.unmodifiableList(bleDevices);
        this.Eb = status;
    }

    public BleDevicesResult(List<BleDevice> bleDevices, Status status) {
        this.CK = 3;
        this.Wq = Collections.unmodifiableList(bleDevices);
        this.Eb = status;
    }

    /* renamed from: C */
    public static BleDevicesResult m2711C(Status status) {
        return new BleDevicesResult(Collections.emptyList(), status);
    }

    /* renamed from: b */
    private boolean m2712b(BleDevicesResult bleDevicesResult) {
        return this.Eb.equals(bleDevicesResult.Eb) && jv.equal(this.Wq, bleDevicesResult.Wq);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof BleDevicesResult) && m2712b((BleDevicesResult) that));
    }

    public List<BleDevice> getClaimedBleDevices() {
        return this.Wq;
    }

    public List<BleDevice> getClaimedBleDevices(DataType dataType) {
        List arrayList = new ArrayList();
        for (BleDevice bleDevice : this.Wq) {
            if (bleDevice.getDataTypes().contains(dataType)) {
                arrayList.add(bleDevice);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public Status getStatus() {
        return this.Eb;
    }

    int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        return jv.hashCode(this.Eb, this.Wq);
    }

    public String toString() {
        return jv.m1571h(this).m1570a("status", this.Eb).m1570a("bleDevices", this.Wq).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0340a.m650a(this, dest, flags);
    }
}
