package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.BaseImplementation.C0155b;
import com.google.android.gms.common.api.BaseImplementation.C1301a;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.oj.C1057a;
import com.google.android.gms.panorama.Panorama;
import com.google.android.gms.panorama.PanoramaApi;
import com.google.android.gms.panorama.PanoramaApi.PanoramaResult;

public class ol implements PanoramaApi {

    /* renamed from: com.google.android.gms.internal.ol$b */
    private static final class C1419b extends C1057a {
        private final C0155b<PanoramaResult> Ea;

        public C1419b(C0155b<PanoramaResult> c0155b) {
            this.Ea = c0155b;
        }

        /* renamed from: a */
        public void mo2047a(int i, Bundle bundle, int i2, Intent intent) {
            this.Ea.mo908b(new on(new Status(i, null, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null), intent));
        }
    }

    /* renamed from: com.google.android.gms.internal.ol$c */
    private static abstract class C1527c<R extends Result> extends C1301a<R, om> {
        protected C1527c(GoogleApiClient googleApiClient) {
            super(Panorama.DQ, googleApiClient);
        }

        /* renamed from: a */
        protected abstract void mo3718a(Context context, ok okVar) throws RemoteException;

        /* renamed from: a */
        protected final void m4956a(om omVar) throws RemoteException {
            mo3718a(omVar.getContext(), (ok) omVar.hw());
        }
    }

    /* renamed from: com.google.android.gms.internal.ol$a */
    private static abstract class C1583a extends C1527c<PanoramaResult> {
        public C1583a(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        protected PanoramaResult ay(Status status) {
            return new on(status, null);
        }

        /* renamed from: c */
        protected /* synthetic */ Result mo2958c(Status status) {
            return ay(status);
        }
    }

    /* renamed from: a */
    private static void m3499a(Context context, Uri uri) {
        context.revokeUriPermission(uri, 1);
    }

    /* renamed from: a */
    private static void m3500a(final Context context, ok okVar, final oj ojVar, final Uri uri, Bundle bundle) throws RemoteException {
        context.grantUriPermission(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE, uri, 1);
        try {
            okVar.mo2048a(new C1057a() {
                /* renamed from: a */
                public void mo2047a(int i, Bundle bundle, int i2, Intent intent) throws RemoteException {
                    ol.m3499a(context, uri);
                    ojVar.mo2047a(i, bundle, i2, intent);
                }
            }, uri, bundle, true);
        } catch (RemoteException e) {
            m3499a(context, uri);
            throw e;
        } catch (RuntimeException e2) {
            m3499a(context, uri);
            throw e2;
        }
    }

    public PendingResult<PanoramaResult> loadPanoramaInfo(GoogleApiClient client, final Uri uri) {
        return client.mo926a(new C1583a(this, client) {
            final /* synthetic */ ol amP;

            /* renamed from: a */
            protected void mo3718a(Context context, ok okVar) throws RemoteException {
                okVar.mo2048a(new C1419b(this), uri, null, false);
            }
        });
    }

    public PendingResult<PanoramaResult> loadPanoramaInfoAndGrantAccess(GoogleApiClient client, final Uri uri) {
        return client.mo926a(new C1583a(this, client) {
            final /* synthetic */ ol amP;

            /* renamed from: a */
            protected void mo3718a(Context context, ok okVar) throws RemoteException {
                ol.m3500a(context, okVar, new C1419b(this), uri, null);
            }
        });
    }
}
