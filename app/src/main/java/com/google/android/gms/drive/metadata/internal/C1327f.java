package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.C0834a;

/* renamed from: com.google.android.gms.drive.metadata.internal.f */
public class C1327f extends C0834a<Integer> {
    public C1327f(String str, int i) {
        super(str, i);
    }

    /* renamed from: a */
    protected void m3987a(Bundle bundle, Integer num) {
        bundle.putInt(getName(), num.intValue());
    }

    /* renamed from: c */
    protected /* synthetic */ Object mo2983c(DataHolder dataHolder, int i, int i2) {
        return m3990g(dataHolder, i, i2);
    }

    /* renamed from: g */
    protected Integer m3990g(DataHolder dataHolder, int i, int i2) {
        return Integer.valueOf(dataHolder.m2492b(getName(), i, i2));
    }

    /* renamed from: i */
    protected /* synthetic */ Object mo2985i(Bundle bundle) {
        return m3992l(bundle);
    }

    /* renamed from: l */
    protected Integer m3992l(Bundle bundle) {
        return Integer.valueOf(bundle.getInt(getName()));
    }
}
