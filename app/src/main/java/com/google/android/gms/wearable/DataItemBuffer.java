package com.google.android.gms.wearable;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.C1307g;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.internal.C1491o;

public class DataItemBuffer extends C1307g<DataItem> implements Result {
    private final Status Eb;

    public DataItemBuffer(DataHolder dataHolder) {
        super(dataHolder);
        this.Eb = new Status(dataHolder.getStatusCode());
    }

    /* renamed from: f */
    protected /* synthetic */ Object mo3686f(int i, int i2) {
        return m4976r(i, i2);
    }

    public Status getStatus() {
        return this.Eb;
    }

    protected String ha() {
        return "path";
    }

    /* renamed from: r */
    protected DataItem m4976r(int i, int i2) {
        return new C1491o(this.JG, i, i2);
    }
}
