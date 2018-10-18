package com.google.android.gms.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.drive.metadata.internal.C1329j;
import java.util.Arrays;
import java.util.Collections;

public class lo extends C1329j<AppVisibleCustomProperties> {
    public lo(int i) {
        super("customProperties", Collections.singleton("customProperties"), Arrays.asList(new String[]{"customPropertiesExtra"}), i);
    }

    /* renamed from: c */
    protected /* synthetic */ Object mo2983c(DataHolder dataHolder, int i, int i2) {
        return m4940l(dataHolder, i, i2);
    }

    /* renamed from: l */
    protected AppVisibleCustomProperties m4940l(DataHolder dataHolder, int i, int i2) {
        return (AppVisibleCustomProperties) dataHolder.gV().getSparseParcelableArray("customPropertiesExtra").get(i, AppVisibleCustomProperties.Rd);
    }
}
