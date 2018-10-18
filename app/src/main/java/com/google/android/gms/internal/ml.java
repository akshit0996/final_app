package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation.C0155b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.RecordingApi;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Subscription;
import com.google.android.gms.fitness.data.Subscription.C0281a;
import com.google.android.gms.fitness.request.C0882m;
import com.google.android.gms.fitness.request.C0882m.C0327a;
import com.google.android.gms.fitness.request.af;
import com.google.android.gms.fitness.request.af.C0313a;
import com.google.android.gms.fitness.request.aj;
import com.google.android.gms.fitness.request.aj.C0315a;
import com.google.android.gms.fitness.result.ListSubscriptionsResult;
import com.google.android.gms.internal.lu.C1401b;
import com.google.android.gms.internal.lu.C1525a;
import com.google.android.gms.internal.lu.C1569c;
import com.google.android.gms.internal.ma.C1029a;

public class ml implements RecordingApi {

    /* renamed from: com.google.android.gms.internal.ml$a */
    private static class C1405a extends C1029a {
        private final C0155b<ListSubscriptionsResult> Ea;

        private C1405a(C0155b<ListSubscriptionsResult> c0155b) {
            this.Ea = c0155b;
        }

        /* renamed from: a */
        public void mo1945a(ListSubscriptionsResult listSubscriptionsResult) {
            this.Ea.mo908b(listSubscriptionsResult);
        }
    }

    /* renamed from: a */
    private PendingResult<ListSubscriptionsResult> m3436a(GoogleApiClient googleApiClient, final C0882m c0882m) {
        return googleApiClient.mo926a(new C1525a<ListSubscriptionsResult>(this, googleApiClient) {
            final /* synthetic */ ml Vl;

            /* renamed from: a */
            protected void m5113a(lu luVar) throws RemoteException {
                luVar.jM().mo1936a(c0882m, new C1405a(this), luVar.getContext().getPackageName());
            }

            /* renamed from: c */
            protected /* synthetic */ Result mo2958c(Status status) {
                return m5115y(status);
            }

            /* renamed from: y */
            protected ListSubscriptionsResult m5115y(Status status) {
                return ListSubscriptionsResult.m2722F(status);
            }
        });
    }

    /* renamed from: a */
    public PendingResult<Status> m3437a(GoogleApiClient googleApiClient, final af afVar) {
        return googleApiClient.mo926a(new C1569c(this, googleApiClient) {
            final /* synthetic */ ml Vl;

            /* renamed from: a */
            protected void m5562a(lu luVar) throws RemoteException {
                luVar.jM().mo1930a(afVar, new C1401b(this), luVar.getContext().getPackageName());
            }
        });
    }

    /* renamed from: a */
    public PendingResult<Status> m3438a(GoogleApiClient googleApiClient, final aj ajVar) {
        return googleApiClient.mo928b(new C1569c(this, googleApiClient) {
            final /* synthetic */ ml Vl;

            /* renamed from: a */
            protected void m5564a(lu luVar) throws RemoteException {
                luVar.jM().mo1932a(ajVar, new C1401b(this), luVar.getContext().getPackageName());
            }
        });
    }

    public PendingResult<ListSubscriptionsResult> listSubscriptions(GoogleApiClient client) {
        return m3436a(client, new C0327a().ka());
    }

    public PendingResult<ListSubscriptionsResult> listSubscriptions(GoogleApiClient client, DataType dataType) {
        return m3436a(client, new C0327a().m636c(dataType).ka());
    }

    public PendingResult<Status> subscribe(GoogleApiClient client, DataSource dataSource) {
        return m3437a(client, new C0313a().m618b(new C0281a().m536b(dataSource).jK()).kp());
    }

    public PendingResult<Status> subscribe(GoogleApiClient client, DataType dataType) {
        return m3437a(client, new C0313a().m618b(new C0281a().m537b(dataType).jK()).kp());
    }

    public PendingResult<Status> unsubscribe(GoogleApiClient client, DataSource dataSource) {
        return m3438a(client, new C0315a().m623d(dataSource).kq());
    }

    public PendingResult<Status> unsubscribe(GoogleApiClient client, DataType dataType) {
        return m3438a(client, new C0315a().m624d(dataType).kq());
    }

    public PendingResult<Status> unsubscribe(GoogleApiClient client, Subscription subscription) {
        return subscription.getDataType() == null ? unsubscribe(client, subscription.getDataSource()) : unsubscribe(client, subscription.getDataType());
    }
}
