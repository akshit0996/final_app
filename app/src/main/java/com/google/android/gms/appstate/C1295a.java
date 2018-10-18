package com.google.android.gms.appstate;

import com.google.android.gms.internal.jv;

/* renamed from: com.google.android.gms.appstate.a */
public final class C1295a implements AppState {
    private final int DK;
    private final String DL;
    private final byte[] DM;
    private final boolean DN;
    private final String DO;
    private final byte[] DP;

    public C1295a(AppState appState) {
        this.DK = appState.getKey();
        this.DL = appState.getLocalVersion();
        this.DM = appState.getLocalData();
        this.DN = appState.hasConflict();
        this.DO = appState.getConflictVersion();
        this.DP = appState.getConflictData();
    }

    /* renamed from: a */
    static int m3914a(AppState appState) {
        return jv.hashCode(Integer.valueOf(appState.getKey()), appState.getLocalVersion(), appState.getLocalData(), Boolean.valueOf(appState.hasConflict()), appState.getConflictVersion(), appState.getConflictData());
    }

    /* renamed from: a */
    static boolean m3915a(AppState appState, Object obj) {
        if (!(obj instanceof AppState)) {
            return false;
        }
        if (appState == obj) {
            return true;
        }
        AppState appState2 = (AppState) obj;
        return jv.equal(Integer.valueOf(appState2.getKey()), Integer.valueOf(appState.getKey())) && jv.equal(appState2.getLocalVersion(), appState.getLocalVersion()) && jv.equal(appState2.getLocalData(), appState.getLocalData()) && jv.equal(Boolean.valueOf(appState2.hasConflict()), Boolean.valueOf(appState.hasConflict())) && jv.equal(appState2.getConflictVersion(), appState.getConflictVersion()) && jv.equal(appState2.getConflictData(), appState.getConflictData());
    }

    /* renamed from: b */
    static String m3916b(AppState appState) {
        return jv.m1571h(appState).m1570a("Key", Integer.valueOf(appState.getKey())).m1570a("LocalVersion", appState.getLocalVersion()).m1570a("LocalData", appState.getLocalData()).m1570a("HasConflict", Boolean.valueOf(appState.hasConflict())).m1570a("ConflictVersion", appState.getConflictVersion()).m1570a("ConflictData", appState.getConflictData()).toString();
    }

    public boolean equals(Object obj) {
        return C1295a.m3915a(this, obj);
    }

    public AppState fJ() {
        return this;
    }

    public /* synthetic */ Object freeze() {
        return fJ();
    }

    public byte[] getConflictData() {
        return this.DP;
    }

    public String getConflictVersion() {
        return this.DO;
    }

    public int getKey() {
        return this.DK;
    }

    public byte[] getLocalData() {
        return this.DM;
    }

    public String getLocalVersion() {
        return this.DL;
    }

    public boolean hasConflict() {
        return this.DN;
    }

    public int hashCode() {
        return C1295a.m3914a(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return C1295a.m3916b(this);
    }
}
