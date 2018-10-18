package com.google.android.gms.drive.internal;

import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

/* renamed from: com.google.android.gms.drive.internal.m */
public final class C1313m extends Metadata {
    private final MetadataBundle PD;

    public C1313m(MetadataBundle metadataBundle) {
        this.PD = metadataBundle;
    }

    /* renamed from: a */
    protected <T> T mo2961a(MetadataField<T> metadataField) {
        return this.PD.m2584a((MetadataField) metadataField);
    }

    public /* synthetic */ Object freeze() {
        return iy();
    }

    public boolean isDataValid() {
        return this.PD != null;
    }

    public Metadata iy() {
        return new C1313m(MetadataBundle.m2583a(this.PD));
    }

    public String toString() {
        return "Metadata [mImpl=" + this.PD + "]";
    }
}
