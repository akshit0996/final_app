package com.google.android.gms.common.api;

import java.util.concurrent.TimeUnit;

public interface PendingResult<R extends Result> {

    /* renamed from: com.google.android.gms.common.api.PendingResult$a */
    public interface C0156a {
        /* renamed from: m */
        void mo913m(Status status);
    }

    /* renamed from: a */
    void mo905a(C0156a c0156a);

    R await();

    R await(long j, TimeUnit timeUnit);

    void cancel();

    boolean isCanceled();

    void setResultCallback(ResultCallback<R> resultCallback);

    void setResultCallback(ResultCallback<R> resultCallback, long j, TimeUnit timeUnit);
}
