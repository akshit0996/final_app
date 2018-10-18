package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation.C0155b;
import com.google.android.gms.common.api.BaseImplementation.C1301a;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.Fitness;
import com.google.android.gms.fitness.SensorsApi;
import com.google.android.gms.fitness.data.C0291k;
import com.google.android.gms.fitness.data.C1334l.C0293a;
import com.google.android.gms.fitness.request.C0883o;
import com.google.android.gms.fitness.request.C0884q;
import com.google.android.gms.fitness.request.DataSourcesRequest;
import com.google.android.gms.fitness.request.OnDataPointListener;
import com.google.android.gms.fitness.request.SensorRequest;
import com.google.android.gms.fitness.result.DataSourcesResult;
import com.google.android.gms.internal.lu.C1401b;
import com.google.android.gms.internal.lx.C1023a;
import com.google.android.gms.internal.md.C1035a;

public class mm implements SensorsApi {

    /* renamed from: com.google.android.gms.internal.mm$b */
    private interface C0488b {
        void jO();
    }

    /* renamed from: com.google.android.gms.internal.mm$c */
    private static class C1406c extends C1023a {
        private final C0155b<DataSourcesResult> Ea;

        private C1406c(C0155b<DataSourcesResult> c0155b) {
            this.Ea = c0155b;
        }

        /* renamed from: a */
        public void mo1919a(DataSourcesResult dataSourcesResult) {
            this.Ea.mo908b(dataSourcesResult);
        }
    }

    /* renamed from: com.google.android.gms.internal.mm$d */
    private static class C1407d extends C1035a {
        private final C0155b<Status> Ea;
        private final C0488b Vu;

        private C1407d(C0155b<Status> c0155b, C0488b c0488b) {
            this.Ea = c0155b;
            this.Vu = c0488b;
        }

        /* renamed from: j */
        public void mo1948j(Status status) {
            if (this.Vu != null && status.isSuccess()) {
                this.Vu.jO();
            }
            this.Ea.mo908b(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.mm$a */
    private static abstract class C1526a<R extends Result> extends C1301a<R, lu> {
        public C1526a(GoogleApiClient googleApiClient) {
            super(Fitness.DQ, googleApiClient);
        }
    }

    /* renamed from: a */
    private PendingResult<Status> m3439a(GoogleApiClient googleApiClient, final C0883o c0883o) {
        return googleApiClient.mo926a(new C1526a<Status>(this, googleApiClient) {
            final /* synthetic */ mm Vp;

            /* renamed from: a */
            protected void m5121a(lu luVar) throws RemoteException {
                luVar.jM().mo1937a(c0883o, new C1401b(this), luVar.getContext().getPackageName());
            }

            /* renamed from: b */
            protected Status m5122b(Status status) {
                return status;
            }

            /* renamed from: c */
            protected /* synthetic */ Result mo2958c(Status status) {
                return m5122b(status);
            }
        });
    }

    /* renamed from: a */
    private PendingResult<Status> m3440a(GoogleApiClient googleApiClient, final C0884q c0884q, final C0488b c0488b) {
        return googleApiClient.mo928b(new C1526a<Status>(this, googleApiClient) {
            final /* synthetic */ mm Vp;

            /* renamed from: a */
            protected void m5125a(lu luVar) throws RemoteException {
                luVar.jM().mo1938a(c0884q, new C1407d(this, c0488b), luVar.getContext().getPackageName());
            }

            /* renamed from: b */
            protected Status m5126b(Status status) {
                return status;
            }

            /* renamed from: c */
            protected /* synthetic */ Result mo2958c(Status status) {
                return m5126b(status);
            }
        });
    }

    public PendingResult<Status> add(GoogleApiClient client, SensorRequest request, PendingIntent intent) {
        return m3439a(client, new C0883o(request, null, intent));
    }

    public PendingResult<Status> add(GoogleApiClient client, SensorRequest request, OnDataPointListener listener) {
        return m3439a(client, new C0883o(request, C0293a.jG().m548a(listener), null));
    }

    public PendingResult<DataSourcesResult> findDataSources(GoogleApiClient client, final DataSourcesRequest request) {
        return client.mo926a(new C1526a<DataSourcesResult>(this, client) {
            final /* synthetic */ mm Vp;

            /* renamed from: a */
            protected void m5117a(lu luVar) throws RemoteException {
                luVar.jM().mo1923a(request, new C1406c(this), luVar.getContext().getPackageName());
            }

            /* renamed from: c */
            protected /* synthetic */ Result mo2958c(Status status) {
                return m5119z(status);
            }

            /* renamed from: z */
            protected DataSourcesResult m5119z(Status status) {
                return DataSourcesResult.m2718D(status);
            }
        });
    }

    public PendingResult<Status> remove(GoogleApiClient client, PendingIntent pendingIntent) {
        return m3440a(client, new C0884q(null, pendingIntent), null);
    }

    public PendingResult<Status> remove(GoogleApiClient client, final OnDataPointListener listener) {
        C0291k b = C0293a.jG().m549b(listener);
        return b == null ? new me(Status.Kw) : m3440a(client, new C0884q(b, null), new C0488b(this) {
            final /* synthetic */ mm Vp;

            public void jO() {
                C0293a.jG().m550c(listener);
            }
        });
    }
}
