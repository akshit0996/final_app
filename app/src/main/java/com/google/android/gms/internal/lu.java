package com.google.android.gms.internal;

import android.content.Context;
import android.os.DeadObjectException;
import com.google.android.gms.common.api.Api.C0152a;
import com.google.android.gms.common.api.BaseImplementation.C0155b;
import com.google.android.gms.common.api.BaseImplementation.C1301a;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.Fitness;
import com.google.android.gms.internal.md.C1035a;

public interface lu extends C0152a {

    /* renamed from: com.google.android.gms.internal.lu$b */
    public static class C1401b extends C1035a {
        private final C0155b<Status> Ea;

        public C1401b(C0155b<Status> c0155b) {
            this.Ea = c0155b;
        }

        /* renamed from: j */
        public void mo1948j(Status status) {
            this.Ea.mo908b(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.lu$a */
    public static abstract class C1525a<R extends Result> extends C1301a<R, lu> {
        public C1525a(GoogleApiClient googleApiClient) {
            super(Fitness.DQ, googleApiClient);
        }
    }

    /* renamed from: com.google.android.gms.internal.lu$c */
    public static abstract class C1569c extends C1525a<Status> {
        C1569c(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: b */
        protected Status m5094b(Status status) {
            jx.m1575L(!status.isSuccess());
            return status;
        }

        /* renamed from: c */
        protected /* synthetic */ Result mo2958c(Status status) {
            return m5094b(status);
        }
    }

    Context getContext();

    lz jM() throws DeadObjectException;
}
