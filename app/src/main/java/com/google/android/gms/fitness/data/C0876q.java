package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;

/* renamed from: com.google.android.gms.fitness.data.q */
public class C0876q implements SafeParcelable {
    public static final Creator<C0876q> CREATOR = new C0298r();
    final int CK;
    private final Session TQ;
    private final DataSet UP;

    C0876q(int i, Session session, DataSet dataSet) {
        this.CK = i;
        this.TQ = session;
        this.UP = dataSet;
    }

    /* renamed from: a */
    private boolean m2697a(C0876q c0876q) {
        return jv.equal(this.TQ, c0876q.TQ) && jv.equal(this.UP, c0876q.UP);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return o == this || ((o instanceof C0876q) && m2697a((C0876q) o));
    }

    public Session getSession() {
        return this.TQ;
    }

    public int hashCode() {
        return jv.hashCode(this.TQ, this.UP);
    }

    public DataSet jH() {
        return this.UP;
    }

    public String toString() {
        return jv.m1571h(this).m1570a("session", this.TQ).m1570a("dataSet", this.UP).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0298r.m555a(this, dest, flags);
    }
}
