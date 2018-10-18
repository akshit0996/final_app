package com.google.android.gms.panorama;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.C0152a;
import com.google.android.gms.common.api.Api.C0153b;
import com.google.android.gms.common.api.Api.C0154c;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.jg;
import com.google.android.gms.internal.ol;
import com.google.android.gms.internal.om;

public final class Panorama {
    public static final Api<NoOptions> API = new Api(DR, DQ, new Scope[0]);
    public static final C0154c<om> DQ = new C0154c();
    static final C0153b<om, NoOptions> DR = new C11831();
    public static final PanoramaApi PanoramaApi = new ol();

    /* renamed from: com.google.android.gms.panorama.Panorama$1 */
    static class C11831 implements C0153b<om, NoOptions> {
        C11831() {
        }

        /* renamed from: a */
        public /* synthetic */ C0152a mo878a(Context context, Looper looper, jg jgVar, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return m3619f(context, looper, jgVar, (NoOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }

        /* renamed from: f */
        public om m3619f(Context context, Looper looper, jg jgVar, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new om(context, looper, connectionCallbacks, onConnectionFailedListener);
        }

        public int getPriority() {
            return ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
    }

    private Panorama() {
    }
}
