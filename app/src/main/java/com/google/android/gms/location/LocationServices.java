package com.google.android.gms.location;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.C0152a;
import com.google.android.gms.common.api.Api.C0153b;
import com.google.android.gms.common.api.Api.C0154c;
import com.google.android.gms.common.api.BaseImplementation.C1301a;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.jg;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.nf;
import com.google.android.gms.internal.ng;
import com.google.android.gms.internal.nk;

public class LocationServices {
    public static final Api<NoOptions> API = new Api(DR, DQ, new Scope[0]);
    private static final C0154c<nk> DQ = new C0154c();
    private static final C0153b<nk, NoOptions> DR = new C10831();
    public static FusedLocationProviderApi FusedLocationApi = new nf();
    public static GeofencingApi GeofencingApi = new ng();

    /* renamed from: com.google.android.gms.location.LocationServices$1 */
    static class C10831 implements C0153b<nk, NoOptions> {
        C10831() {
        }

        /* renamed from: a */
        public /* synthetic */ C0152a mo878a(Context context, Looper looper, jg jgVar, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return m3561e(context, looper, jgVar, (NoOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }

        /* renamed from: e */
        public nk m3561e(Context context, Looper looper, jg jgVar, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new nk(context, looper, context.getPackageName(), connectionCallbacks, onConnectionFailedListener, "locationServices", jgVar.getAccountName());
        }

        public int getPriority() {
            return ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
    }

    /* renamed from: com.google.android.gms.location.LocationServices$a */
    public static abstract class C1530a<R extends Result> extends C1301a<R, nk> {
        public C1530a(GoogleApiClient googleApiClient) {
            super(LocationServices.DQ, googleApiClient);
        }
    }

    private LocationServices() {
    }

    /* renamed from: f */
    public static nk m1937f(GoogleApiClient googleApiClient) {
        boolean z = true;
        jx.m1580b(googleApiClient != null, (Object) "GoogleApiClient parameter is required.");
        nk nkVar = (nk) googleApiClient.mo925a(DQ);
        if (nkVar == null) {
            z = false;
        }
        jx.m1576a(z, "GoogleApiClient is not configured to use the LocationServices.API Api. Pass thisinto GoogleApiClient.Builder#addApi() to use this feature.");
        return nkVar;
    }
}
