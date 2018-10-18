package com.google.android.gms.drive.metadata;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public interface MetadataField<T> {
    /* renamed from: a */
    T mo1056a(DataHolder dataHolder, int i, int i2);

    /* renamed from: a */
    void mo1057a(DataHolder dataHolder, MetadataBundle metadataBundle, int i, int i2);

    /* renamed from: a */
    void mo1058a(T t, Bundle bundle);

    String getName();

    /* renamed from: h */
    T mo1060h(Bundle bundle);
}
