package com.google.android.gms.internal;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.BaseImplementation.C0155b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.HistoryApi;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.request.C0878e.C0319a;
import com.google.android.gms.fitness.request.DataDeleteRequest;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.result.DataReadResult;
import com.google.android.gms.internal.lu.C1401b;
import com.google.android.gms.internal.lu.C1525a;
import com.google.android.gms.internal.lu.C1569c;
import com.google.android.gms.internal.lw.C1021a;

public class mj implements HistoryApi {

    /* renamed from: com.google.android.gms.internal.mj$a */
    private static class C1404a extends C1021a {
        private final C0155b<DataReadResult> Ea;
        private int Vi;
        private DataReadResult Vj;

        private C1404a(C0155b<DataReadResult> c0155b) {
            this.Vi = 0;
            this.Vj = null;
            this.Ea = c0155b;
        }

        /* renamed from: a */
        public void mo1918a(DataReadResult dataReadResult) {
            synchronized (this) {
                Log.v("Fitness", "Received batch result");
                if (this.Vj == null) {
                    this.Vj = dataReadResult;
                } else {
                    this.Vj.m2717b(dataReadResult);
                }
                this.Vi++;
                if (this.Vi == this.Vj.kr()) {
                    this.Ea.mo908b(this.Vj);
                }
            }
        }
    }

    public PendingResult<Status> deleteData(GoogleApiClient client, final DataDeleteRequest request) {
        return client.mo926a(new C1569c(this, client) {
            final /* synthetic */ mj Vf;

            /* renamed from: a */
            protected void m5560a(lu luVar) throws RemoteException {
                luVar.jM().mo1921a(request, new C1401b(this), luVar.getContext().getPackageName());
            }
        });
    }

    public PendingResult<Status> insertData(GoogleApiClient client, final DataSet dataSet) {
        return client.mo926a(new C1569c(this, client) {
            final /* synthetic */ mj Vf;

            /* renamed from: a */
            protected void m5558a(lu luVar) throws RemoteException {
                luVar.jM().mo1934a(new C0319a().m629b(dataSet).jU(), new C1401b(this), luVar.getContext().getPackageName());
            }
        });
    }

    public PendingResult<DataReadResult> readData(GoogleApiClient client, final DataReadRequest request) {
        return client.mo926a(new C1525a<DataReadResult>(this, client) {
            final /* synthetic */ mj Vf;

            /* renamed from: a */
            protected void m5109a(lu luVar) throws RemoteException {
                luVar.jM().mo1922a(request, new C1404a(this), luVar.getContext().getPackageName());
            }

            /* renamed from: c */
            protected /* synthetic */ Result mo2958c(Status status) {
                return m5111x(status);
            }

            /* renamed from: x */
            protected DataReadResult m5111x(Status status) {
                return DataReadResult.m2713a(status, request);
            }
        });
    }
}
