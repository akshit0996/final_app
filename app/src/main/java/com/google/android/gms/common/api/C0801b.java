package com.google.android.gms.common.api;

import com.google.android.gms.common.data.DataHolder;

/* renamed from: com.google.android.gms.common.api.b */
public abstract class C0801b implements Releasable, Result {
    protected final Status Eb;
    protected final DataHolder JG;

    protected C0801b(DataHolder dataHolder) {
        this.Eb = new Status(dataHolder.getStatusCode());
        this.JG = dataHolder;
    }

    public Status getStatus() {
        return this.Eb;
    }

    public void release() {
        if (this.JG != null) {
            this.JG.close();
        }
    }
}
