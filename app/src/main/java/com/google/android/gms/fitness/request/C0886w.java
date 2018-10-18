package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;
import java.util.concurrent.TimeUnit;

/* renamed from: com.google.android.gms.fitness.request.w */
public class C0886w implements SafeParcelable {
    public static final Creator<C0886w> CREATOR = new C0336x();
    private final int CK;
    private final Session TQ;

    /* renamed from: com.google.android.gms.fitness.request.w$a */
    public static class C0335a {
        private Session TQ;

        /* renamed from: b */
        public C0335a m645b(Session session) {
            jx.m1580b(session.getEndTime(TimeUnit.MILLISECONDS) == 0, (Object) "Cannot start a session which has already ended");
            this.TQ = session;
            return this;
        }

        public C0886w kk() {
            return new C0886w();
        }
    }

    C0886w(int i, Session session) {
        this.CK = i;
        this.TQ = session;
    }

    private C0886w(C0335a c0335a) {
        this.CK = 1;
        this.TQ = c0335a.TQ;
    }

    /* renamed from: a */
    private boolean m2709a(C0886w c0886w) {
        return jv.equal(this.TQ, c0886w.TQ);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return o == this || ((o instanceof C0886w) && m2709a((C0886w) o));
    }

    public Session getSession() {
        return this.TQ;
    }

    int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        return jv.hashCode(this.TQ);
    }

    public String toString() {
        return jv.m1571h(this).m1570a("session", this.TQ).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0336x.m646a(this, dest, flags);
    }
}
