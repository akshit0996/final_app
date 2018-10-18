package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;

public final class AppContentConditionEntity implements SafeParcelable, AppContentCondition {
    public static final AppContentConditionEntityCreator CREATOR = new AppContentConditionEntityCreator();
    private final int CK;
    private final String XT;
    private final String XU;
    private final String XV;
    private final Bundle XW;

    AppContentConditionEntity(int versionCode, String defaultValue, String expectedValue, String predicate, Bundle predicateParameters) {
        this.CK = versionCode;
        this.XT = defaultValue;
        this.XU = expectedValue;
        this.XV = predicate;
        this.XW = predicateParameters;
    }

    public AppContentConditionEntity(AppContentCondition condition) {
        this.CK = 1;
        this.XT = condition.kT();
        this.XU = condition.kT();
        this.XV = condition.kV();
        this.XW = condition.kW();
    }

    /* renamed from: a */
    static int m4033a(AppContentCondition appContentCondition) {
        return jv.hashCode(appContentCondition.kT(), appContentCondition.kU(), appContentCondition.kV(), appContentCondition.kW());
    }

    /* renamed from: a */
    static boolean m4034a(AppContentCondition appContentCondition, Object obj) {
        if (!(obj instanceof AppContentCondition)) {
            return false;
        }
        if (appContentCondition == obj) {
            return true;
        }
        AppContentCondition appContentCondition2 = (AppContentCondition) obj;
        return jv.equal(appContentCondition2.kT(), appContentCondition.kT()) && jv.equal(appContentCondition2.kU(), appContentCondition.kU()) && jv.equal(appContentCondition2.kV(), appContentCondition.kV()) && jv.equal(appContentCondition2.kW(), appContentCondition.kW());
    }

    /* renamed from: b */
    static String m4035b(AppContentCondition appContentCondition) {
        return jv.m1571h(appContentCondition).m1570a("DefaultValue", appContentCondition.kT()).m1570a("ExpectedValue", appContentCondition.kU()).m1570a("Predicate", appContentCondition.kV()).m1570a("PredicateParameters", appContentCondition.kW()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return m4034a(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return kX();
    }

    public int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        return m4033a(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String kT() {
        return this.XT;
    }

    public String kU() {
        return this.XU;
    }

    public String kV() {
        return this.XV;
    }

    public Bundle kW() {
        return this.XW;
    }

    public AppContentCondition kX() {
        return this;
    }

    public String toString() {
        return m4035b(this);
    }

    public void writeToParcel(Parcel out, int flags) {
        AppContentConditionEntityCreator.m669a(this, out, flags);
    }
}
