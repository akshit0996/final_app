package com.google.android.gms.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.C1329j;
import java.util.Arrays;

public class lq extends C1329j<DriveId> {
    public static final lq RV = new lq();

    private lq() {
        super("driveId", Arrays.asList(new String[]{"sqlId", "resourceId"}), Arrays.asList(new String[]{"dbInstanceId"}), 4100000);
    }

    /* renamed from: c */
    protected /* synthetic */ Object mo2983c(DataHolder dataHolder, int i, int i2) {
        return m4942m(dataHolder, i, i2);
    }

    /* renamed from: m */
    protected DriveId m4942m(DataHolder dataHolder, int i, int i2) {
        long j = dataHolder.gV().getLong("dbInstanceId");
        String c = dataHolder.m2493c("resourceId", i, i2);
        if (c != null && c.startsWith("generated-android-")) {
            c = null;
        }
        return new DriveId(c, Long.valueOf(dataHolder.m2490a("sqlId", i, i2)).longValue(), j);
    }
}
