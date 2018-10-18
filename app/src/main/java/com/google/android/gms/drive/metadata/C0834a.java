package com.google.android.gms.drive.metadata;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.jx;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.google.android.gms.drive.metadata.a */
public abstract class C0834a<T> implements MetadataField<T> {
    private final String QY;
    private final Set<String> QZ;
    private final Set<String> Ra;
    private final int Rb;

    protected C0834a(String str, int i) {
        this.QY = (String) jx.m1578b((Object) str, (Object) "fieldName");
        this.QZ = Collections.singleton(str);
        this.Ra = Collections.emptySet();
        this.Rb = i;
    }

    protected C0834a(String str, Collection<String> collection, Collection<String> collection2, int i) {
        this.QY = (String) jx.m1578b((Object) str, (Object) "fieldName");
        this.QZ = Collections.unmodifiableSet(new HashSet(collection));
        this.Ra = Collections.unmodifiableSet(new HashSet(collection2));
        this.Rb = i;
    }

    /* renamed from: a */
    public final T mo1056a(DataHolder dataHolder, int i, int i2) {
        return mo3684b(dataHolder, i, i2) ? mo2983c(dataHolder, i, i2) : null;
    }

    /* renamed from: a */
    protected abstract void mo2984a(Bundle bundle, T t);

    /* renamed from: a */
    public final void mo1057a(DataHolder dataHolder, MetadataBundle metadataBundle, int i, int i2) {
        jx.m1578b((Object) dataHolder, (Object) "dataHolder");
        jx.m1578b((Object) metadataBundle, (Object) "bundle");
        metadataBundle.m2585b(this, mo1056a(dataHolder, i, i2));
    }

    /* renamed from: a */
    public final void mo1058a(T t, Bundle bundle) {
        jx.m1578b((Object) bundle, (Object) "bundle");
        if (t == null) {
            bundle.putString(getName(), null);
        } else {
            mo2984a(bundle, (Object) t);
        }
    }

    /* renamed from: b */
    protected boolean mo3684b(DataHolder dataHolder, int i, int i2) {
        for (String h : this.QZ) {
            if (dataHolder.m2499h(h, i, i2)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: c */
    protected abstract T mo2983c(DataHolder dataHolder, int i, int i2);

    public final String getName() {
        return this.QY;
    }

    /* renamed from: h */
    public final T mo1060h(Bundle bundle) {
        jx.m1578b((Object) bundle, (Object) "bundle");
        return bundle.get(getName()) != null ? mo2985i(bundle) : null;
    }

    /* renamed from: i */
    protected abstract T mo2985i(Bundle bundle);

    public String toString() {
        return this.QY;
    }
}
