package com.google.android.gms.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResult.C0156a;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import java.util.concurrent.TimeUnit;

class me<T extends Result> implements PendingResult<T> {
    private final T UU;

    me(T t) {
        this.UU = t;
    }

    /* renamed from: a */
    public void mo905a(C0156a c0156a) {
        c0156a.mo913m(this.UU.getStatus());
    }

    public T await() {
        return this.UU;
    }

    public T await(long time, TimeUnit units) {
        return this.UU;
    }

    public void cancel() {
    }

    public boolean isCanceled() {
        return false;
    }

    public void setResultCallback(ResultCallback<T> callback) {
        callback.onResult(this.UU);
    }

    public void setResultCallback(ResultCallback<T> callback, long time, TimeUnit units) {
        callback.onResult(this.UU);
    }
}
