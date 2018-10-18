package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.mg;

/* renamed from: com.google.android.gms.fitness.data.a */
public final class C0873a implements SafeParcelable {
    public static final Creator<C0873a> CREATOR = new C0282b();
    public static final C0873a TT = new C0873a(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE, String.valueOf(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE), null);
    private final int CK;
    private final String CS;
    private final String TU;
    private final String TV;

    C0873a(int i, String str, String str2, String str3) {
        this.CK = i;
        this.CS = (String) jx.m1582i(str);
        this.TU = "";
        this.TV = str3;
    }

    public C0873a(String str, String str2, String str3) {
        this(1, str, "", str3);
    }

    /* renamed from: a */
    private boolean m2695a(C0873a c0873a) {
        return this.CS.equals(c0873a.CS) && jv.equal(this.TU, c0873a.TU) && jv.equal(this.TV, c0873a.TV);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof C0873a) && m2695a((C0873a) that));
    }

    public String getPackageName() {
        return this.CS;
    }

    public String getVersion() {
        return this.TU;
    }

    int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        return jv.hashCode(this.CS, this.TU, this.TV);
    }

    public String jk() {
        return this.TV;
    }

    C0873a jl() {
        return new C0873a(mg.bw(this.CS), mg.bw(this.TU), mg.bw(this.TV));
    }

    public String toString() {
        return String.format("Application{%s:%s:%s}", new Object[]{this.CS, this.TU, this.TV});
    }

    public void writeToParcel(Parcel parcel, int flags) {
        C0282b.m538a(this, parcel, flags);
    }
}
