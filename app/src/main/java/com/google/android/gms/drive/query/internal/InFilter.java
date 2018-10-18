package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.drive.metadata.C1324b;
import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.Collection;
import java.util.Collections;

public class InFilter<T> extends AbstractFilter {
    public static final C0236h CREATOR = new C0236h();
    final int CK;
    final MetadataBundle Si;
    private final C1324b<T> St;

    InFilter(int versionCode, MetadataBundle value) {
        this.CK = versionCode;
        this.Si = value;
        this.St = (C1324b) C0233e.m413b(value);
    }

    public InFilter(SearchableCollectionMetadataField<T> field, T value) {
        this(1, MetadataBundle.m2582a(field, Collections.singleton(value)));
    }

    /* renamed from: a */
    public <F> F mo3685a(C0234f<F> c0234f) {
        return c0234f.mo1061b(this.St, getValue());
    }

    public int describeContents() {
        return 0;
    }

    public T getValue() {
        return ((Collection) this.Si.m2584a(this.St)).iterator().next();
    }

    public void writeToParcel(Parcel out, int flags) {
        C0236h.m421a(this, out, flags);
    }
}
