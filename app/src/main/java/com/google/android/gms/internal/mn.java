package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation.C0155b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.SessionsApi;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.request.C0885u;
import com.google.android.gms.fitness.request.C0886w.C0335a;
import com.google.android.gms.fitness.request.C0887y.C0338a;
import com.google.android.gms.fitness.request.SessionInsertRequest;
import com.google.android.gms.fitness.request.SessionReadRequest;
import com.google.android.gms.fitness.request.aa;
import com.google.android.gms.fitness.result.SessionReadResult;
import com.google.android.gms.fitness.result.SessionStopResult;
import com.google.android.gms.internal.lu.C1401b;
import com.google.android.gms.internal.lu.C1525a;
import com.google.android.gms.internal.lu.C1569c;
import com.google.android.gms.internal.mb.C1031a;
import com.google.android.gms.internal.mc.C1033a;

public class mn implements SessionsApi {

    /* renamed from: com.google.android.gms.internal.mn$a */
    private static class C1408a extends C1031a {
        private final C0155b<SessionReadResult> Ea;

        private C1408a(C0155b<SessionReadResult> c0155b) {
            this.Ea = c0155b;
        }

        /* renamed from: a */
        public void mo1946a(SessionReadResult sessionReadResult) throws RemoteException {
            this.Ea.mo908b(sessionReadResult);
        }
    }

    /* renamed from: com.google.android.gms.internal.mn$b */
    private static class C1409b extends C1033a {
        private final C0155b<SessionStopResult> Ea;

        private C1409b(C0155b<SessionStopResult> c0155b) {
            this.Ea = c0155b;
        }

        /* renamed from: a */
        public void mo1947a(SessionStopResult sessionStopResult) {
            this.Ea.mo908b(sessionStopResult);
        }
    }

    /* renamed from: a */
    private PendingResult<SessionStopResult> m3441a(GoogleApiClient googleApiClient, final String str, final String str2) {
        return googleApiClient.mo928b(new C1525a<SessionStopResult>(this, googleApiClient) {
            final /* synthetic */ mn Vw;

            /* renamed from: A */
            protected SessionStopResult m5128A(Status status) {
                return SessionStopResult.m2726H(status);
            }

            /* renamed from: a */
            protected void m5130a(lu luVar) throws RemoteException {
                luVar.jM().mo1941a(new C0338a().bx(str).by(str2).kl(), new C1409b(this), luVar.getContext().getPackageName());
            }

            /* renamed from: c */
            protected /* synthetic */ Result mo2958c(Status status) {
                return m5128A(status);
            }
        });
    }

    public PendingResult<Status> insertSession(GoogleApiClient client, final SessionInsertRequest request) {
        return client.mo926a(new C1569c(this, client) {
            final /* synthetic */ mn Vw;

            /* renamed from: a */
            protected void m5568a(lu luVar) throws RemoteException {
                luVar.jM().mo1925a(request, new C1401b(this), luVar.getContext().getPackageName());
            }
        });
    }

    public PendingResult<SessionReadResult> readSession(GoogleApiClient client, final SessionReadRequest request) {
        return client.mo926a(new C1525a<SessionReadResult>(this, client) {
            final /* synthetic */ mn Vw;

            /* renamed from: B */
            protected SessionReadResult m5132B(Status status) {
                return SessionReadResult.m2724G(status);
            }

            /* renamed from: a */
            protected void m5134a(lu luVar) throws RemoteException {
                luVar.jM().mo1926a(request, new C1408a(this), luVar.getContext().getPackageName());
            }

            /* renamed from: c */
            protected /* synthetic */ Result mo2958c(Status status) {
                return m5132B(status);
            }
        });
    }

    public PendingResult<Status> registerForSessions(GoogleApiClient client, final PendingIntent intent) {
        return client.mo928b(new C1569c(this, client) {
            final /* synthetic */ mn Vw;

            /* renamed from: a */
            protected void m5570a(lu luVar) throws RemoteException {
                md c1401b = new C1401b(this);
                luVar.jM().mo1939a(new C0885u(intent), c1401b, luVar.getContext().getPackageName());
            }
        });
    }

    public PendingResult<Status> startSession(GoogleApiClient client, final Session session) {
        return client.mo928b(new C1569c(this, client) {
            final /* synthetic */ mn Vw;

            /* renamed from: a */
            protected void m5566a(lu luVar) throws RemoteException {
                luVar.jM().mo1940a(new C0335a().m645b(session).kk(), new C1401b(this), luVar.getContext().getPackageName());
            }
        });
    }

    public PendingResult<SessionStopResult> stopSession(GoogleApiClient client, String identifier) {
        return m3441a(client, null, identifier);
    }

    public PendingResult<Status> unregisterForSessions(GoogleApiClient client, final PendingIntent intent) {
        return client.mo928b(new C1569c(this, client) {
            final /* synthetic */ mn Vw;

            /* renamed from: a */
            protected void m5572a(lu luVar) throws RemoteException {
                md c1401b = new C1401b(this);
                luVar.jM().mo1928a(new aa(intent), c1401b, luVar.getContext().getPackageName());
            }
        });
    }
}
