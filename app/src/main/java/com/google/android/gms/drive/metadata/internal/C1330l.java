package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.C0834a;

/* renamed from: com.google.android.gms.drive.metadata.internal.l */
public class C1330l extends C0834a<String> {
    public C1330l(String str, int i) {
        super(str, i);
    }

    /* renamed from: a */
    protected void m4004a(Bundle bundle, String str) {
        bundle.putString(getName(), str);
    }

    /* renamed from: c */
    protected /* synthetic */ Object mo2983c(DataHolder dataHolder, int i, int i2) {
        return m4007i(dataHolder, i, i2);
    }

    /* renamed from: i */
    protected /* synthetic */ Object mo2985i(Bundle bundle) {
        return m4008p(bundle);
    }

    /* renamed from: i */
    protected String m4007i(DataHolder dataHolder, int i, int i2) {
        return dataHolder.m2493c(getName(), i, i2);
    }

    /* renamed from: p */
    protected String m4008p(Bundle bundle) {
        return bundle.getString(getName());
    }
}
