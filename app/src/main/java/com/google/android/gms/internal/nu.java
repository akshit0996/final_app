package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class nu implements SafeParcelable {
    public static final nv CREATOR = new nv();
    final int CK;
    final List<oa> ahn;
    private final Set<oa> aho;
    private final String ahr;
    private final boolean ahs;
    final List<oe> aht;
    final List<String> ahu;
    private final Set<oe> ahv;
    private final Set<String> ahw;

    nu(int i, List<oa> list, String str, boolean z, List<oe> list2, List<String> list3) {
        this.CK = i;
        this.ahn = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
        if (str == null) {
            str = "";
        }
        this.ahr = str;
        this.ahs = z;
        this.aht = list2 == null ? Collections.emptyList() : Collections.unmodifiableList(list2);
        this.ahu = list3 == null ? Collections.emptyList() : Collections.unmodifiableList(list3);
        this.aho = m3492g(this.ahn);
        this.ahv = m3492g(this.aht);
        this.ahw = m3492g(this.ahu);
    }

    /* renamed from: g */
    private static <E> Set<E> m3492g(List<E> list) {
        return list.isEmpty() ? Collections.emptySet() : Collections.unmodifiableSet(new HashSet(list));
    }

    public int describeContents() {
        nv nvVar = CREATOR;
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof nu)) {
            return false;
        }
        nu nuVar = (nu) object;
        return this.aho.equals(nuVar.aho) && this.ahs == nuVar.ahs && this.ahv.equals(nuVar.ahv) && this.ahw.equals(nuVar.ahw);
    }

    public int hashCode() {
        return jv.hashCode(this.aho, Boolean.valueOf(this.ahs), this.ahv, this.ahw);
    }

    @Deprecated
    public String nu() {
        return this.ahr;
    }

    public boolean nv() {
        return this.ahs;
    }

    public String toString() {
        return jv.m1571h(this).m1570a("types", this.aho).m1570a("placeIds", this.ahw).m1570a("requireOpenNow", Boolean.valueOf(this.ahs)).m1570a("requestedUserDataTypes", this.ahv).toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        nv nvVar = CREATOR;
        nv.m1746a(this, parcel, flags);
    }
}
