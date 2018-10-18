package com.google.android.gms.common.api;

import com.google.android.gms.common.api.C0163d.C0162b;
import com.google.android.gms.common.data.DataHolder;

/* renamed from: com.google.android.gms.common.api.a */
public abstract class C0800a<L> implements C0162b<L> {
    private final DataHolder JG;

    protected C0800a(DataHolder dataHolder) {
        this.JG = dataHolder;
    }

    /* renamed from: a */
    protected abstract void mo3102a(L l, DataHolder dataHolder);

    /* renamed from: c */
    public final void mo916c(L l) {
        mo3102a(l, this.JG);
    }

    public void gG() {
        if (this.JG != null) {
            this.JG.close();
        }
    }
}
