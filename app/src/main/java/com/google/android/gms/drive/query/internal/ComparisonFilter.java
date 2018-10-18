package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class ComparisonFilter<T> extends AbstractFilter {
    public static final C0229a CREATOR = new C0229a();
    final int CK;
    final Operator Sh;
    final MetadataBundle Si;
    final MetadataField<T> Sj;

    ComparisonFilter(int versionCode, Operator operator, MetadataBundle value) {
        this.CK = versionCode;
        this.Sh = operator;
        this.Si = value;
        this.Sj = C0233e.m413b(value);
    }

    public ComparisonFilter(Operator operator, SearchableMetadataField<T> field, T value) {
        this(1, operator, MetadataBundle.m2582a(field, value));
    }

    /* renamed from: a */
    public <F> F mo3685a(C0234f<F> c0234f) {
        return c0234f.mo1062b(this.Sh, this.Sj, getValue());
    }

    public int describeContents() {
        return 0;
    }

    public T getValue() {
        return this.Si.m2584a(this.Sj);
    }

    public void writeToParcel(Parcel out, int flags) {
        C0229a.m409a(this, out, flags);
    }
}
