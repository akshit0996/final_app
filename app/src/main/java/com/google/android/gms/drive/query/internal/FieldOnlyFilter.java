package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class FieldOnlyFilter extends AbstractFilter {
    public static final Creator<FieldOnlyFilter> CREATOR = new C0230b();
    final int CK;
    final MetadataBundle Si;
    private final MetadataField<?> Sj;

    FieldOnlyFilter(int versionCode, MetadataBundle value) {
        this.CK = versionCode;
        this.Si = value;
        this.Sj = C0233e.m413b(value);
    }

    public FieldOnlyFilter(SearchableMetadataField<?> field) {
        this(1, MetadataBundle.m2582a(field, null));
    }

    /* renamed from: a */
    public <T> T mo3685a(C0234f<T> c0234f) {
        return c0234f.mo1064d(this.Sj);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        C0230b.m410a(this, out, flags);
    }
}
