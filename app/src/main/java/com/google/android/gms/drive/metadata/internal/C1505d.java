package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.C1325d;
import java.util.Date;

/* renamed from: com.google.android.gms.drive.metadata.internal.d */
public class C1505d extends C1325d<Date> {
    public C1505d(String str, int i) {
        super(str, i);
    }

    /* renamed from: a */
    protected void m4775a(Bundle bundle, Date date) {
        bundle.putLong(getName(), date.getTime());
    }

    /* renamed from: c */
    protected /* synthetic */ Object mo2983c(DataHolder dataHolder, int i, int i2) {
        return m4777f(dataHolder, i, i2);
    }

    /* renamed from: f */
    protected Date m4777f(DataHolder dataHolder, int i, int i2) {
        return new Date(dataHolder.m2490a(getName(), i, i2));
    }

    /* renamed from: i */
    protected /* synthetic */ Object mo2985i(Bundle bundle) {
        return m4779k(bundle);
    }

    /* renamed from: k */
    protected Date m4779k(Bundle bundle) {
        return new Date(bundle.getLong(getName()));
    }
}
