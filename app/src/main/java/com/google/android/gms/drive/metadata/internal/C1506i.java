package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.drive.metadata.C1324b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/* renamed from: com.google.android.gms.drive.metadata.internal.i */
public class C1506i<T extends Parcelable> extends C1324b<T> {
    public C1506i(String str, int i) {
        super(str, Collections.emptySet(), Collections.singleton(str), i);
    }

    /* renamed from: a */
    protected void m4781a(Bundle bundle, Collection<T> collection) {
        bundle.putParcelableArrayList(getName(), new ArrayList(collection));
    }

    /* renamed from: i */
    protected /* synthetic */ Object mo2985i(Bundle bundle) {
        return m4783n(bundle);
    }

    /* renamed from: n */
    protected Collection<T> m4783n(Bundle bundle) {
        return bundle.getParcelableArrayList(getName());
    }
}
