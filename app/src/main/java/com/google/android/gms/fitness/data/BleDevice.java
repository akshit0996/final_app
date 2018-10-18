package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.ls;
import java.util.Collections;
import java.util.List;

public class BleDevice implements SafeParcelable {
    public static final Creator<BleDevice> CREATOR = new C0283c();
    private final int CK;
    private final String TW;
    private final List<String> TX;
    private final List<DataType> TY;
    private final String mName;

    BleDevice(int versionCode, String address, String name, List<String> profiles, List<DataType> dataTypes) {
        this.CK = versionCode;
        this.TW = address;
        this.mName = name;
        this.TX = Collections.unmodifiableList(profiles);
        this.TY = Collections.unmodifiableList(dataTypes);
    }

    /* renamed from: a */
    private boolean m2668a(BleDevice bleDevice) {
        return this.mName.equals(bleDevice.mName) && this.TW.equals(bleDevice.TW) && ls.m1648a(bleDevice.TX, this.TX) && ls.m1648a(this.TY, bleDevice.TY);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return o == this || ((o instanceof BleDevice) && m2668a((BleDevice) o));
    }

    public String getAddress() {
        return this.TW;
    }

    public List<DataType> getDataTypes() {
        return this.TY;
    }

    public String getName() {
        return this.mName;
    }

    public List<String> getSupportedProfiles() {
        return this.TX;
    }

    int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        return jv.hashCode(this.mName, this.TW, this.TX, this.TY);
    }

    public String toString() {
        return jv.m1571h(this).m1570a("name", this.mName).m1570a("address", this.TW).m1570a("dataTypes", this.TY).m1570a("supportedProfiles", this.TX).toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        C0283c.m539a(this, parcel, flags);
    }
}
