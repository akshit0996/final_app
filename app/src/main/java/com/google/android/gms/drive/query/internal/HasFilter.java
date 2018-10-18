package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class HasFilter<T> extends AbstractFilter {
    public static final C0235g CREATOR = new C0235g();
    final int CK;
    final MetadataBundle Si;
    final MetadataField<T> Sj;

    HasFilter(int versionCode, MetadataBundle value) {
        this.CK = versionCode;
        this.Si = value;
        this.Sj = C0233e.m413b(value);
    }

    public HasFilter(SearchableMetadataField<T> field, T value) {
        this(1, MetadataBundle.m2582a(field, value));
    }

    /* renamed from: a */
    public <F> F mo3685a(C0234f<F> c0234f) {
        return c0234f.mo1065d(this.Sj, getValue());
    }

    public int describeContents() {
        return 0;
    }

    public T getValue() {
        return this.Si.m2584a(this.Sj);
    }

    public void writeToParcel(Parcel out, int flags) {
        C0235g.m420a(this, out, flags);
    }
}
