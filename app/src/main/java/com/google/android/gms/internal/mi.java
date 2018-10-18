package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation.C0155b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.ConfigApi;
import com.google.android.gms.fitness.request.C0879j;
import com.google.android.gms.fitness.request.DataTypeCreateRequest;
import com.google.android.gms.fitness.result.DataTypeResult;
import com.google.android.gms.internal.lu.C1401b;
import com.google.android.gms.internal.lu.C1525a;
import com.google.android.gms.internal.lu.C1569c;
import com.google.android.gms.internal.ly.C1025a;

public class mi implements ConfigApi {

    /* renamed from: com.google.android.gms.internal.mi$a */
    private static class C1403a extends C1025a {
        private final C0155b<DataTypeResult> Ea;

        private C1403a(C0155b<DataTypeResult> c0155b) {
            this.Ea = c0155b;
        }

        /* renamed from: a */
        public void mo1920a(DataTypeResult dataTypeResult) {
            this.Ea.mo908b(dataTypeResult);
        }
    }

    public PendingResult<DataTypeResult> createCustomDataType(GoogleApiClient client, final DataTypeCreateRequest request) {
        return client.mo928b(new C1525a<DataTypeResult>(this, client) {
            final /* synthetic */ mi Vc;

            /* renamed from: a */
            protected void m5101a(lu luVar) throws RemoteException {
                luVar.jM().mo1924a(request, new C1403a(this), luVar.getContext().getPackageName());
            }

            /* renamed from: c */
            protected /* synthetic */ Result mo2958c(Status status) {
                return m5103w(status);
            }

            /* renamed from: w */
            protected DataTypeResult m5103w(Status status) {
                return DataTypeResult.m2720E(status);
            }
        });
    }

    public PendingResult<Status> disableFit(GoogleApiClient client) {
        return client.mo928b(new C1569c(this, client) {
            final /* synthetic */ mi Vc;

            /* renamed from: a */
            protected void m5556a(lu luVar) throws RemoteException {
                luVar.jM().mo1942a(new C1401b(this), luVar.getContext().getPackageName());
            }
        });
    }

    public PendingResult<DataTypeResult> readDataType(GoogleApiClient client, String dataTypeName) {
        final C0879j c0879j = new C0879j(dataTypeName);
        return client.mo926a(new C1525a<DataTypeResult>(this, client) {
            final /* synthetic */ mi Vc;

            /* renamed from: a */
            protected void m5105a(lu luVar) throws RemoteException {
                luVar.jM().mo1935a(c0879j, new C1403a(this), luVar.getContext().getPackageName());
            }

            /* renamed from: c */
            protected /* synthetic */ Result mo2958c(Status status) {
                return m5107w(status);
            }

            /* renamed from: w */
            protected DataTypeResult m5107w(Status status) {
                return DataTypeResult.m2720E(status);
            }
        });
    }
}
