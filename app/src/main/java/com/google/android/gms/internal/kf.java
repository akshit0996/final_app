package com.google.android.gms.internal;

import com.google.android.gms.common.api.BaseImplementation.C1301a;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

abstract class kf<R extends Result> extends C1301a<R, kg> {

    /* renamed from: com.google.android.gms.internal.kf$a */
    static abstract class C1561a extends kf<Status> {
        public C1561a(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: b */
        public Status m5092b(Status status) {
            return status;
        }

        /* renamed from: c */
        public /* synthetic */ Result mo2958c(Status status) {
            return m5092b(status);
        }
    }

    public kf(GoogleApiClient googleApiClient) {
        super(kc.DQ, googleApiClient);
    }
}
