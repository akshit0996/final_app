package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.drive.metadata.C0834a;
import java.util.Collection;

/* renamed from: com.google.android.gms.drive.metadata.internal.j */
public abstract class C1329j<T extends Parcelable> extends C0834a<T> {
    public C1329j(String str, Collection<String> collection, Collection<String> collection2, int i) {
        super(str, collection, collection2, i);
    }

    /* renamed from: a */
    protected void m3999a(Bundle bundle, T t) {
        bundle.putParcelable(getName(), t);
    }

    /* renamed from: i */
    protected /* synthetic */ Object mo2985i(Bundle bundle) {
        return m4002o(bundle);
    }

    /* renamed from: o */
    protected T m4002o(Bundle bundle) {
        return bundle.getParcelable(getName());
    }
}
