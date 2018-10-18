package com.google.android.gms.drive.internal;

import com.google.android.gms.common.api.BaseImplementation.C1301a;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Drive;

/* renamed from: com.google.android.gms.drive.internal.q */
abstract class C1499q<R extends Result> extends C1301a<R, C1317r> {

    /* renamed from: com.google.android.gms.drive.internal.q$a */
    static abstract class C1551a extends C1499q<Status> {
        C1551a(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: b */
        protected Status m4997b(Status status) {
            return status;
        }

        /* renamed from: c */
        protected /* synthetic */ Result mo2958c(Status status) {
            return m4997b(status);
        }
    }

    public C1499q(GoogleApiClient googleApiClient) {
        super(Drive.DQ, googleApiClient);
    }
}
