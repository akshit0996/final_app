package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import java.util.ArrayList;
import java.util.List;

public final class AppContentActionEntity implements SafeParcelable, AppContentAction {
    public static final AppContentActionEntityCreator CREATOR = new AppContentActionEntityCreator();
    private final int CK;
    private final ArrayList<AppContentConditionEntity> XJ;
    private final String XK;
    private final String XL;
    private final String XM;
    private final Bundle mExtras;
    private final String vc;

    AppContentActionEntity(int versionCode, ArrayList<AppContentConditionEntity> conditions, String contentDescription, Bundle extras, String label, String labelStyle, String type) {
        this.CK = versionCode;
        this.XJ = conditions;
        this.XK = contentDescription;
        this.mExtras = extras;
        this.XL = label;
        this.XM = labelStyle;
        this.vc = type;
    }

    public AppContentActionEntity(AppContentAction action) {
        this.CK = 1;
        this.XK = action.kI();
        this.mExtras = action.getExtras();
        this.XL = action.getLabel();
        this.XM = action.kJ();
        this.vc = action.getType();
        List kH = action.kH();
        int size = kH.size();
        this.XJ = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            this.XJ.add((AppContentConditionEntity) ((AppContentCondition) kH.get(i)).freeze());
        }
    }

    /* renamed from: a */
    static int m4024a(AppContentAction appContentAction) {
        return jv.hashCode(appContentAction.kH(), appContentAction.kI(), appContentAction.getExtras(), appContentAction.getLabel(), appContentAction.kJ(), appContentAction.getType());
    }

    /* renamed from: a */
    static boolean m4025a(AppContentAction appContentAction, Object obj) {
        if (!(obj instanceof AppContentAction)) {
            return false;
        }
        if (appContentAction == obj) {
            return true;
        }
        AppContentAction appContentAction2 = (AppContentAction) obj;
        return jv.equal(appContentAction2.kH(), appContentAction.kH()) && jv.equal(appContentAction2.kI(), appContentAction.kI()) && jv.equal(appContentAction2.getExtras(), appContentAction.getExtras()) && jv.equal(appContentAction2.getLabel(), appContentAction.getLabel()) && jv.equal(appContentAction2.kJ(), appContentAction.kJ()) && jv.equal(appContentAction2.getType(), appContentAction.getType());
    }

    /* renamed from: b */
    static String m4026b(AppContentAction appContentAction) {
        return jv.m1571h(appContentAction).m1570a("Conditions", appContentAction.kH()).m1570a("ContentDescription", appContentAction.kI()).m1570a("Extras", appContentAction.getExtras()).m1570a("Label", appContentAction.getLabel()).m1570a("LabelStyle", appContentAction.kJ()).m1570a("Type", appContentAction.getType()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return m4025a(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return kK();
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public String getLabel() {
        return this.XL;
    }

    public String getType() {
        return this.vc;
    }

    public int getVersionCode() {
        return this.CK;
    }

    public int hashCode() {
        return m4024a(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public List<AppContentCondition> kH() {
        return new ArrayList(this.XJ);
    }

    public String kI() {
        return this.XK;
    }

    public String kJ() {
        return this.XM;
    }

    public AppContentAction kK() {
        return this;
    }

    public String toString() {
        return m4026b(this);
    }

    public void writeToParcel(Parcel out, int flags) {
        AppContentActionEntityCreator.m666a(this, out, flags);
    }
}
