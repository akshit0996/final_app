package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.C0834a;

/* renamed from: com.google.android.gms.drive.metadata.internal.b */
public class C1326b extends C0834a<Boolean> {
    public C1326b(String str, int i) {
        super(str, i);
    }

    /* renamed from: a */
    protected void m3981a(Bundle bundle, Boolean bool) {
        bundle.putBoolean(getName(), bool.booleanValue());
    }

    /* renamed from: c */
    protected /* synthetic */ Object mo2983c(DataHolder dataHolder, int i, int i2) {
        return mo3692e(dataHolder, i, i2);
    }

    /* renamed from: e */
    protected Boolean mo3692e(DataHolder dataHolder, int i, int i2) {
        return Boolean.valueOf(dataHolder.m2494d(getName(), i, i2));
    }

    /* renamed from: i */
    protected /* synthetic */ Object mo2985i(Bundle bundle) {
        return m3986j(bundle);
    }

    /* renamed from: j */
    protected Boolean m3986j(Bundle bundle) {
        return Boolean.valueOf(bundle.getBoolean(getName()));
    }
}
