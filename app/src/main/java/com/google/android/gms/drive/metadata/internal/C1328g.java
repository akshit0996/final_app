package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.C0834a;

/* renamed from: com.google.android.gms.drive.metadata.internal.g */
public class C1328g extends C0834a<Long> {
    public C1328g(String str, int i) {
        super(str, i);
    }

    /* renamed from: a */
    protected void m3993a(Bundle bundle, Long l) {
        bundle.putLong(getName(), l.longValue());
    }

    /* renamed from: c */
    protected /* synthetic */ Object mo2983c(DataHolder dataHolder, int i, int i2) {
        return m3996h(dataHolder, i, i2);
    }

    /* renamed from: h */
    protected Long m3996h(DataHolder dataHolder, int i, int i2) {
        return Long.valueOf(dataHolder.m2490a(getName(), i, i2));
    }

    /* renamed from: i */
    protected /* synthetic */ Object mo2985i(Bundle bundle) {
        return m3998m(bundle);
    }

    /* renamed from: m */
    protected Long m3998m(Bundle bundle) {
        return Long.valueOf(bundle.getLong(getName()));
    }
}
