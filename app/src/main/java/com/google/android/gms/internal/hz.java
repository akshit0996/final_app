package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.RemoteException;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndexApi;
import com.google.android.gms.appindexing.AppIndexApi.ActionResult;
import com.google.android.gms.appindexing.AppIndexApi.AppIndexingLink;
import com.google.android.gms.common.api.BaseImplementation.C0155b;
import com.google.android.gms.common.api.BaseImplementation.C1301a;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import java.util.List;

public final class hz implements AppIndexApi, ht {

    /* renamed from: com.google.android.gms.internal.hz$a */
    private static final class C0983a implements ActionResult {
        private hz DE;
        private PendingResult<Status> DF;
        private Action DG;
        private String DH;

        C0983a(hz hzVar, PendingResult<Status> pendingResult, Action action, String str) {
            this.DE = hzVar;
            this.DF = pendingResult;
            this.DG = action;
            this.DH = str;
        }

        public PendingResult<Status> end(GoogleApiClient apiClient) {
            String packageName = ((hx) apiClient.mo925a(hc.CG)).getContext().getPackageName();
            hr a = hy.m1423a(this.DG, this.DH, System.currentTimeMillis(), packageName, 3);
            return this.DE.m3250a(apiClient, a);
        }

        public PendingResult<Status> getPendingResult() {
            return this.DF;
        }
    }

    /* renamed from: com.google.android.gms.internal.hz$b */
    private static abstract class C1510b<T extends Result> extends C1301a<T, hx> {
        public C1510b(GoogleApiClient googleApiClient) {
            super(hc.CG, googleApiClient);
        }

        /* renamed from: a */
        protected abstract void mo3717a(hu huVar) throws RemoteException;

        /* renamed from: a */
        protected final void m4923a(hx hxVar) throws RemoteException {
            mo3717a(hxVar.fH());
        }
    }

    /* renamed from: com.google.android.gms.internal.hz$d */
    private static final class C1511d extends hw<Status> {
        public C1511d(C0155b<Status> c0155b) {
            super(c0155b);
        }

        /* renamed from: a */
        public void mo1810a(Status status) {
            this.DA.mo908b(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.hz$c */
    private static abstract class C1560c<T extends Result> extends C1510b<Status> {
        C1560c(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: b */
        protected Status m5090b(Status status) {
            return status;
        }

        /* renamed from: c */
        protected /* synthetic */ Result mo2958c(Status status) {
            return m5090b(status);
        }
    }

    /* renamed from: a */
    public static Intent m3247a(String str, Uri uri) {
        m3248b(str, uri);
        List pathSegments = uri.getPathSegments();
        String str2 = (String) pathSegments.get(0);
        Builder builder = new Builder();
        builder.scheme(str2);
        if (pathSegments.size() > 1) {
            builder.authority((String) pathSegments.get(1));
            for (int i = 2; i < pathSegments.size(); i++) {
                builder.appendPath((String) pathSegments.get(i));
            }
        }
        builder.encodedQuery(uri.getEncodedQuery());
        builder.encodedFragment(uri.getEncodedFragment());
        return new Intent("android.intent.action.VIEW", builder.build());
    }

    /* renamed from: b */
    private static void m3248b(String str, Uri uri) {
        if ("android-app".equals(uri.getScheme())) {
            String host = uri.getHost();
            if (str == null || str.equals(host)) {
                List pathSegments = uri.getPathSegments();
                if (pathSegments.isEmpty() || ((String) pathSegments.get(0)).isEmpty()) {
                    throw new IllegalArgumentException("AppIndex: The app URI scheme must exist and follow the format android-app://<package_name>/<scheme>/[host_path]). Provided URI: " + uri);
                }
                return;
            }
            throw new IllegalArgumentException("AppIndex: The URI host must match the package name and follow the format (android-app://<package_name>/<scheme>/[host_path]). Provided URI: " + uri);
        }
        throw new IllegalArgumentException("AppIndex: The URI scheme must be 'android-app' and follow the format (android-app://<package_name>/<scheme>/[host_path]). Provided URI: " + uri);
    }

    /* renamed from: c */
    public static void m3249c(List<AppIndexingLink> list) {
        if (list != null) {
            for (AppIndexingLink appIndexingLink : list) {
                m3248b(null, appIndexingLink.appIndexingUrl);
            }
        }
    }

    /* renamed from: a */
    public PendingResult<Status> m3250a(GoogleApiClient googleApiClient, final hr... hrVarArr) {
        final String packageName = ((hx) googleApiClient.mo925a(hc.CG)).getContext().getPackageName();
        return googleApiClient.mo926a(new C1560c<Status>(this, googleApiClient) {
            final /* synthetic */ hz DD;

            /* renamed from: a */
            protected void mo3717a(hu huVar) throws RemoteException {
                huVar.mo1807a(new C1511d(this), packageName, hrVarArr);
            }
        });
    }

    public ActionResult action(GoogleApiClient apiClient, Action action) {
        String packageName = ((hx) apiClient.mo925a(hc.CG)).getContext().getPackageName();
        return new C0983a(this, m3250a(apiClient, hy.m1423a(action, String.valueOf(System.currentTimeMillis()), r2, packageName, 0)), action, String.valueOf(System.currentTimeMillis()));
    }

    public PendingResult<Status> view(GoogleApiClient apiClient, Activity activity, Intent viewIntent, String title, Uri webUrl, List<AppIndexingLink> outLinks) {
        String packageName = ((hx) apiClient.mo925a(hc.CG)).getContext().getPackageName();
        m3249c(outLinks);
        return m3250a(apiClient, new hr(packageName, viewIntent, title, webUrl, null, (List) outLinks));
    }

    public PendingResult<Status> view(GoogleApiClient apiClient, Activity activity, Uri appIndexingUrl, String title, Uri webUrl, List<AppIndexingLink> outLinks) {
        String packageName = ((hx) apiClient.mo925a(hc.CG)).getContext().getPackageName();
        m3248b(packageName, appIndexingUrl);
        return view(apiClient, activity, m3247a(packageName, appIndexingUrl), title, webUrl, (List) outLinks);
    }

    public PendingResult<Status> viewEnd(GoogleApiClient apiClient, Activity activity, Intent viewIntent) {
        hr hrVar = new hr(hr.m3230a(((hx) apiClient.mo925a(hc.CG)).getContext().getPackageName(), viewIntent), System.currentTimeMillis(), 3);
        return m3250a(apiClient, hrVar);
    }

    public PendingResult<Status> viewEnd(GoogleApiClient apiClient, Activity activity, Uri appIndexingUrl) {
        return viewEnd(apiClient, activity, m3247a(((hx) apiClient.mo925a(hc.CG)).getContext().getPackageName(), appIndexingUrl));
    }
}
