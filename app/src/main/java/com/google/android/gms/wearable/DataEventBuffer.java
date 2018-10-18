package com.google.android.gms.wearable;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.C1307g;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.internal.C1486h;

public class DataEventBuffer extends C1307g<DataEvent> implements Result {
    private final Status Eb;

    public DataEventBuffer(DataHolder dataHolder) {
        super(dataHolder);
        this.Eb = new Status(dataHolder.getStatusCode());
    }

    /* renamed from: f */
    protected /* synthetic */ Object mo3686f(int i, int i2) {
        return m4974q(i, i2);
    }

    public Status getStatus() {
        return this.Eb;
    }

    protected String ha() {
        return "path";
    }

    /* renamed from: q */
    protected DataEvent m4974q(int i, int i2) {
        return new C1486h(this.JG, i, i2);
    }
}
