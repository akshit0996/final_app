package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.ActivityRecognition.C1529a;
import com.google.android.gms.location.ActivityRecognitionApi;

public class nb implements ActivityRecognitionApi {

    /* renamed from: com.google.android.gms.internal.nb$a */
    private static abstract class C1580a extends C1529a<Status> {
        public C1580a(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: b */
        public Status m5136b(Status status) {
            return status;
        }

        /* renamed from: c */
        public /* synthetic */ Result mo2958c(Status status) {
            return m5136b(status);
        }
    }

    public PendingResult<Status> removeActivityUpdates(GoogleApiClient client, final PendingIntent callbackIntent) {
        return client.mo928b(new C1580a(this, client) {
            final /* synthetic */ nb agC;

            /* renamed from: a */
            protected void m5576a(nk nkVar) throws RemoteException {
                nkVar.m4945a(callbackIntent);
                m2447b(Status.Kw);
            }
        });
    }

    public PendingResult<Status> requestActivityUpdates(GoogleApiClient client, long detectionIntervalMillis, PendingIntent callbackIntent) {
        final long j = detectionIntervalMillis;
        final PendingIntent pendingIntent = callbackIntent;
        return client.mo928b(new C1580a(this, client) {
            final /* synthetic */ nb agC;

            /* renamed from: a */
            protected void m5574a(nk nkVar) throws RemoteException {
                nkVar.m4944a(j, pendingIntent);
                m2447b(Status.Kw);
            }
        });
    }
}
