package com.google.android.gms.appstate;

import com.google.android.gms.common.data.C0174d;
import com.google.android.gms.common.data.DataHolder;

/* renamed from: com.google.android.gms.appstate.b */
public final class C1296b extends C0174d implements AppState {
    C1296b(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    public boolean equals(Object obj) {
        return C1295a.m3915a(this, obj);
    }

    public AppState fJ() {
        return new C1295a(this);
    }

    public /* synthetic */ Object freeze() {
        return fJ();
    }

    public byte[] getConflictData() {
        return getByteArray("conflict_data");
    }

    public String getConflictVersion() {
        return getString("conflict_version");
    }

    public int getKey() {
        return getInteger("key");
    }

    public byte[] getLocalData() {
        return getByteArray("local_data");
    }

    public String getLocalVersion() {
        return getString("local_version");
    }

    public boolean hasConflict() {
        return !aS("conflict_version");
    }

    public int hashCode() {
        return C1295a.m3914a(this);
    }

    public String toString() {
        return C1295a.m3916b(this);
    }
}
