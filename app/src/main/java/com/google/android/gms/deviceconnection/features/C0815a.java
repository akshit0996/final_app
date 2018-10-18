package com.google.android.gms.deviceconnection.features;

import com.google.android.gms.common.data.C0174d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.jv;

/* renamed from: com.google.android.gms.deviceconnection.features.a */
public final class C0815a extends C0174d implements DeviceFeature {
    public C0815a(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    public String getFeatureName() {
        return getString("feature_name");
    }

    public long getLastConnectionTimestampMillis() {
        return getLong("last_connection_timestamp");
    }

    public String toString() {
        return jv.m1571h(this).m1570a("FeatureName", getFeatureName()).m1570a("Timestamp", Long.valueOf(getLastConnectionTimestampMillis())).toString();
    }
}
