package com.google.android.gms.internal;

import com.google.android.gms.common.api.Api.C0154c;
import com.google.android.gms.common.api.BaseImplementation.C0155b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.Account;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.Plus.C1531a;
import com.google.android.gms.plus.internal.C1470e;

public final class oy implements Account {

    /* renamed from: com.google.android.gms.internal.oy$a */
    private static abstract class C1584a extends C1531a<Status> {
        private C1584a(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: b */
        public Status m5143b(Status status) {
            return status;
        }

        /* renamed from: c */
        public /* synthetic */ Result mo2958c(Status status) {
            return m5143b(status);
        }
    }

    /* renamed from: a */
    private static C1470e m3511a(GoogleApiClient googleApiClient, C0154c<C1470e> c0154c) {
        boolean z = true;
        jx.m1580b(googleApiClient != null, (Object) "GoogleApiClient parameter is required.");
        jx.m1576a(googleApiClient.isConnected(), "GoogleApiClient must be connected.");
        C1470e c1470e = (C1470e) googleApiClient.mo925a((C0154c) c0154c);
        if (c1470e == null) {
            z = false;
        }
        jx.m1576a(z, "GoogleApiClient is not configured to use the Plus.API Api. Pass this into GoogleApiClient.Builder#addApi() to use this feature.");
        return c1470e;
    }

    public void clearDefaultAccount(GoogleApiClient googleApiClient) {
        m3511a(googleApiClient, Plus.DQ).clearDefaultAccount();
    }

    public String getAccountName(GoogleApiClient googleApiClient) {
        return m3511a(googleApiClient, Plus.DQ).getAccountName();
    }

    public PendingResult<Status> revokeAccessAndDisconnect(GoogleApiClient googleApiClient) {
        return googleApiClient.mo928b(new C1584a(this, googleApiClient) {
            final /* synthetic */ oy anY;

            /* renamed from: a */
            protected void m5600a(C1470e c1470e) {
                c1470e.m4654l((C0155b) this);
            }
        });
    }
}
