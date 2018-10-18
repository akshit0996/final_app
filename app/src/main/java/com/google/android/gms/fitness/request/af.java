package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.Subscription;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;

public class af implements SafeParcelable {
    public static final Creator<af> CREATOR = new ag();
    private final int CK;
    private final Subscription Wo;
    private final boolean Wp;

    /* renamed from: com.google.android.gms.fitness.request.af$a */
    public static class C0313a {
        private Subscription Wo;
        private boolean Wp = false;

        /* renamed from: b */
        public C0313a m618b(Subscription subscription) {
            this.Wo = subscription;
            return this;
        }

        public af kp() {
            jx.m1576a(this.Wo != null, "Must call setSubscription()");
            return new af();
        }
    }

    af(int i, Subscription subscription, boolean z) {
        this.CK = i;
        this.Wo = subscription;
        this.Wp = z;
    }

    private af(C0313a c0313a) {
        this.CK = 1;
        this.Wo = c0313a.Wo;
        this.Wp = c0313a.Wp;
    }

    public int describeContents() {
        return 0;
    }

    int getVersionCode() {
        return this.CK;
    }

    public Subscription kn() {
        return this.Wo;
    }

    public boolean ko() {
        return this.Wp;
    }

    public String toString() {
        return jv.m1571h(this).m1570a("subscription", this.Wo).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        ag.m619a(this, dest, flags);
    }
}
